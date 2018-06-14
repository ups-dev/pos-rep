package ec.edu.ups.pos.rep.logic.sessions;

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
import ec.edu.ups.util.jpa.search.AbstractSearch;
import ec.edu.ups.util.jpa.search.DefaultParamSearch;
import ec.edu.ups.util.jpa.search.SearchCondition;
import ec.edu.ups.util.jpa.search.SearchOperation;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;
import ec.edu.ups.util.jpa.search.param.AbstractParam;
import java.io.Serializable;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.omnifaces.util.Faces;

/**
 *
 * @author ups
 */
public abstract class AbstractFacade<T> implements Serializable {

    private static final Logger LOG = Logger.getLogger(AbstractFacade.class.getName());

    public static final Integer DEFAULT_TIMEOUT_LOCK = 2;
    private final Class<T> entityClass;
    @Resource
    private EJBContext context;

    public enum DataAction {

        SELECT,
        INSERT,
        UPDATE,
        DELETE,
        LOGICAL_REMOVE,
        LOGICAL_ENABLE
    }

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public EJBContext getContext() {
        return context;
    }

    public void setContext(EJBContext context) {
        this.context = context;
    }

    public void refreshRecord(T entity) {
        getEntityManager().refresh(find(getIdentifier(entity)));
    }

    public void createRecord(T entity) {
        try {
            getEntityManager().persist(entity);
            getEntityManager().flush();
        } catch (PersistenceException ex) {
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
                    String value = (action == DataAction.LOGICAL_REMOVE ? UPSDataConstants.CONDICION_LOGICA_SI : UPSDataConstants.CONDICION_LOGICA_NO);
                    String user = Faces.getRemoteUser();
                    Date date = new Date();

                    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
                    CriteriaUpdate<T> cu = cb.createCriteriaUpdate(entityClass);
                    cu.set("audEliminado", value);
                    cu.set("audModificado", user);
                    cu.set("audFechaModificacion", date);
                    Root<T> root = cu.getRoot();
                    Expression exp = root.get(root.getModel().getId(Object.class));
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
        } catch (PersistenceException ex) {
            wrapException(DataAction.UPDATE, ex);
        }
    }

    public void removeRecord(T entity) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().flush();
        } catch (PersistenceException ex) {
            wrapException(DataAction.DELETE, ex);
        }
    }

    /**
     * Nos devuelde el valor del ID de la entidad incrementado en 1. Si no
     * existe siempre devuelve el valor de 1.
     *
     * @return la secuencia.
     */
    public Long findSequence() {
        Long result = 1L;

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Object> cq = cb.createQuery(Object.class);
        Root<T> fromEntity = cq.from(entityClass);

        Expression exp = fromEntity.get(fromEntity.getModel().getId(Object.class));
        cq.select(cb.max(exp));
        Object id = getEntityManager().createQuery(cq).getSingleResult();

        if (id != null) {
            if (id instanceof Long) {
                result = result + (Long) id;
            } else {
                throw new UPSDataSelectSequenceException();
            }
        }

        return result;
    }

    public List<T> findRecordsNoDisabled() {
        return findRecordsNoDisabled(null);
    }

    public List<T> findRecordsNoDisabled(List<AbstractParam> params) {
        if (params == null) {
            params = new ArrayList<AbstractParam>();
        }

        return findRecords(SearchBuilder.create(new DefaultParamSearch("audEliminado", UPSDataConstants.CONDICION_LOGICA_NO, SearchCondition.EQUAL)), params);
    }

    public List<T> findRecords() {
        return findRecords(null, null);
    }

    public List<T> findRecords(AbstractSearch as) {
        return findRecords(as, null);
    }

    public List<T> findRecords(List<AbstractParam> params) {
        return findRecords(null, params);
    }

    public List<T> findRecords(AbstractSearch as, List<AbstractParam> params) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> fromEntity = cq.from(entityClass);
        cq.select(fromEntity);

        if (as == null) {
            as = SearchBuilder.create();
        }

        if (params != null && !params.isEmpty()) {
            as.addParams(params);
        }

        List<T> resultList = new ArrayList<T>();
        try {
            resultList = as.generate(getEntityManager(), cb, cq, fromEntity).getResultList();
        } catch (Exception e) {
            throw new UPSDataSelectException(e);
        }

        return resultList;
    }

    public Object getIdentifier(T object) {
        return getEntityManager().getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(object);
    }

    public T find(Object id, Map<String, Object> map, boolean refresh, LockModeType lmt) {
        Map<String, Object> params = (map == null ? new HashMap<String, Object>() : map);

        if (refresh) {
            params.put("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
        }

        return getEntityManager().find(entityClass, id, lmt, params);
    }

    public T find(Object id, boolean refresh) {
        return find(id, null, refresh, LockModeType.NONE);
    }

    public T find(Object id) {
        return find(id, false);
    }

    public T findByIdAndLock(Object id, Map<String, Object> map, boolean refresh, LockModeType lmt, Integer timeout) {
        Map<String, Object> params = (map == null ? new HashMap<String, Object>() : map);
        params.put("javax.persistence.lock.timeout", (timeout == null ? DEFAULT_TIMEOUT_LOCK : timeout));

        return find(id, params, refresh, lmt);
    }

    public T findByIdAndLock(Object id, Map<String, Object> map, LockModeType lmt) {
        return findByIdAndLock(id, map, false, lmt, null);
    }

    public T findByIdAndLock(Object id, LockModeType lmt) {
        return findByIdAndLock(id, null, lmt);
    }

    public T findByIdAndLockPessimisticRead(Object id, boolean refresh) {
        return findByIdAndLock(id, null, refresh, LockModeType.PESSIMISTIC_READ, null);
    }

    public T findByIdAndLockPessimisticRead(Object id) {
        return findByIdAndLockPessimisticRead(id, false);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    protected void wrapException(DataAction action, Throwable ex) {
        getContext().setRollbackOnly();

        if (UPSUtils.findCause(ex, SQLIntegrityConstraintViolationException.class)) {//Si la causa del error fue por restricciones de integridad
            if (action == DataAction.INSERT) {
                throw new UPSDataCreateExistException();
            } else if (action == DataAction.DELETE) {
                throw new UPSDataRemoveException();
            } else {
                throw new UPSDataIntegrityException();
            }
        }
        if (UPSUtils.findCause(ex, SQLDataException.class)) {  //Si la causa del error fue por alg�n dato inv�lido
            if (action == DataAction.INSERT) {
                throw new UPSDataCreateException();
            } else if (action == DataAction.DELETE) {
                throw new UPSDataRemoveException();
            } else {
                throw new UPSDataIntegrityException();
            }
        }
        if (UPSUtils.findCause(ex, SQLException.class)) {
            if (action == DataAction.SELECT) {
                throw new UPSDataSelectException();
            }
        }
        if (UPSUtils.findCause(ex, LockTimeoutException.class)) { //Si la causa del error fue por alg�n bloqueo
            throw new UPSDataLockedException();
        }

        throw new UPSException(ex);
    }

    public void buildParam(List<Predicate> pl, CriteriaBuilder cb, Expression e, AbstractParam ap) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (ap.getParams() != null && !ap.getParams().isEmpty()) {
            for (Object obj : ap.getParams()) {
                predicates.add(cb.equal(e, obj));
            }
            if (pl.size() == 1) {
                pl.add(predicates.get(0));
            } else if (pl.size() > 1) {
                if (ap.getOperation() == SearchOperation.AND) {
                    pl.add(cb.and(predicates.toArray(new Predicate[predicates.size()])));
                } else {
                    pl.add(cb.or(predicates.toArray(new Predicate[predicates.size()])));
                }
            }
        }
    }
}
