package ec.edu.ups.pos.rep.logic.sessions;

import java.io.Serializable;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.omnifaces.util.Faces;

import ec.edu.ups.pos.rep.data.entities.org.OrgAreaGeografica;
import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.util.UPSUtils;
import ec.edu.ups.util.exceptions.UPSDataCreateException;
import ec.edu.ups.util.exceptions.UPSDataCreateExistException;
import ec.edu.ups.util.exceptions.UPSDataIntegrityException;
import ec.edu.ups.util.exceptions.UPSDataLockedException;
import ec.edu.ups.util.exceptions.UPSDataRemoveException;
import ec.edu.ups.util.exceptions.UPSDataSelectException;
import ec.edu.ups.util.exceptions.UPSDataSelectSequenceException;
import ec.edu.ups.util.exceptions.UPSException;
import ec.edu.ups.util.jpa.EntitySuperclass;
import ec.edu.ups.util.jpa.UPSDataConstants;

public abstract class AbstractFacade<T> implements Serializable {

	@Resource
	private EJBContext context;

	private final Class<T> entityClass;

	public enum DataAction {

		/**
		 * Description .
		 */
		SELECT, INSERT, UPDATE, DELETE, LOGICAL_REMOVE, LOGICAL_ENABLE

	}

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public EJBContext getContext() {
		return this.context;
	}

	public void createRecord(T entity) {
		try {
			getEntityManager().persist(entity);
			getEntityManager().flush();
		}
		catch (PersistenceException ex) {
			System.out.println("erro obt" + ex.getMessage());
			wrapException(DataAction.INSERT, ex);
		}
	}

	public void editRecord(T entity) {
		editRecord(DataAction.UPDATE, entity);
	}

	public void disableRecord(T entity) {
		editRecord(DataAction.LOGICAL_REMOVE, entity);
	}

	public void enableRecord(T entity) {
		editRecord(DataAction.LOGICAL_ENABLE, entity);
	}

	protected void editRecord(DataAction action, T entity) {
		try {
			switch (action) {
				case LOGICAL_REMOVE:
				case LOGICAL_ENABLE:
					String value = (action == DataAction.LOGICAL_REMOVE) ? UPSDataConstants.CONDICION_LOGICA_SI
							: UPSDataConstants.CONDICION_LOGICA_NO;
					String user = Faces.getRemoteUser();
					Date date = new Date();

					CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
					CriteriaUpdate<T> cu = cb.createCriteriaUpdate(this.entityClass);
					cu.set("audEliminado", value);
					cu.set("audModificado", user);
					cu.set("audFechaModificacion", date);
					Root<T> root = cu.getRoot();
					Expression<Object> exp = root.get(root.getModel().getId(Object.class));
					cu.where(cb.equal(exp, getIdentifier(entity)));
					getEntityManager().createQuery(cu).executeUpdate();

					((EntitySuperclass) entity).setAudEliminado(value);
					((EntitySuperclass) entity).setAudModificado(user);
					((EntitySuperclass) entity).setAudFechaModificacion(date);
					break;
				default:
					getEntityManager().merge(entity);
			}

			getEntityManager().flush();
		}
		catch (PersistenceException ex) {
			wrapException(DataAction.UPDATE, ex);
		}
	}

	public void removeRecord(T entity) {
		try {
			getEntityManager().remove(getEntityManager().merge(entity));
			getEntityManager().flush();
		}
		catch (PersistenceException ex) {
			wrapException(DataAction.DELETE, ex);
		}
	}

	/**
	 * Nos devuelde el valor del ID de la entidad incrementado en 1. Si no existe siempre
	 * devuelve el valor de 1.
	 * @return la secuencia.
	 */
	public Long findSequence() {
		long result = 1L;

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery(Object.class);
		Root<T> fromEntity = cq.from(this.entityClass);

		Expression<Long> exp = fromEntity.get(fromEntity.getModel().getId(Long.class));
		cq.select(cb.max(exp));
		Object id = getEntityManager().createQuery(cq).getSingleResult();

		if (id != null) {
			if (id instanceof Long) {
				result = result + (Long) id;
			}
			else {
				throw new UPSDataSelectSequenceException();
			}
		}

		return result;
	}

	public List<T> findRecordsNoDisabled() {
		return findRecordsNoDisabled(null);
	}

	public List<T> findRecordsNoDisabled(List<String> conditions) {
		StringBuilder jpql = new StringBuilder(
				"SELECT e FROM " + this.entityClass.getSimpleName() + " e WHERE e.audEliminado = :audEliminado");

		if (conditions != null && !conditions.isEmpty()) {
			for (String condition : conditions) {
				jpql.append(" AND ").append(condition);
			}
		}

		TypedQuery<T> query = getEntityManager().createQuery(jpql.toString(), this.entityClass);
		query.setParameter("audEliminado", UPSDataConstants.CONDICION_LOGICA_NO);

		return query.getResultList();
	}

	public List<T> findRecords() {
		String jpql = "SELECT e FROM " + this.entityClass.getSimpleName() + " e";
		TypedQuery<T> query = getEntityManager().createQuery(jpql, this.entityClass);
		return query.getResultList();
	}

	public Object getIdentifier(T object) {
		return getEntityManager().getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(object);
	}

	public T find(Object id) {
		return getEntityManager().find(this.entityClass, id);
	}

	public List<T> findAll() {
		String jpql = "SELECT e FROM " + this.entityClass.getSimpleName() + " e";
		TypedQuery<T> query = getEntityManager().createQuery(jpql, this.entityClass);
		return query.getResultList();
	}

	public List<OrgEstructura> findRecordsByParentCode(String parentCode) {
		String jpql = "SELECT o FROM OrgEstructura o WHERE o.orgEstructuraPadre.estCodigo = :parentCode ORDER BY o.estCodigo ASC";
		try {
			TypedQuery<OrgEstructura> query = getEntityManager().createQuery(jpql, OrgEstructura.class)
				.setParameter("parentCode", parentCode)
				.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
			return query.getResultList();
		}
		catch (Exception ex) {
			throw new UPSDataSelectException(ex);
		}
	}

	protected void wrapException(DataAction action, Throwable ex) {
		getContext().setRollbackOnly();

		if (UPSUtils.findCause(ex, SQLIntegrityConstraintViolationException.class)) {
			if (action == DataAction.INSERT) {
				throw new UPSDataCreateExistException();
			}
			else if (action == DataAction.DELETE) {
				throw new UPSDataRemoveException();
			}
			else {
				throw new UPSDataIntegrityException();
			}
		}
		if (UPSUtils.findCause(ex, SQLDataException.class)) {
			if (action == DataAction.INSERT) {
				throw new UPSDataCreateException();
			}
			else if (action == DataAction.DELETE) {
				throw new UPSDataRemoveException();
			}
			else {
				throw new UPSDataIntegrityException();
			}
		}
		if (UPSUtils.findCause(ex, SQLException.class)) {
			if (action == DataAction.SELECT) {
				throw new UPSDataSelectException();
			}
		}
		if (UPSUtils.findCause(ex, LockTimeoutException.class)) {
			throw new UPSDataLockedException();
		}

		throw new UPSException(ex);
	}

	public List<OrgAreaGeografica> findRecordsByTipoAreaGeografica(String tipoAreaGeografica) {
		String jpql = "SELECT o FROM OrgAreaGeografica o WHERE o.orgTipoAreaGeografica.tagCodigo = :tipoAreaGeografica ORDER BY o.argNombre ASC";
		try {
			TypedQuery<OrgAreaGeografica> query = getEntityManager().createQuery(jpql, OrgAreaGeografica.class)
				.setParameter("tipoAreaGeografica", tipoAreaGeografica)
				.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
			return query.getResultList();
		}
		catch (Exception ex) {
			throw new UPSDataSelectException(ex);
		}
	}

}
