/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.rep.RepNumeroCertificado;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.util.exceptions.UPSDataEditException;

/**
 * Description.
 *
 * @author UPS .
 */
@Stateless
public class RepNumeroCertificadoFacade extends AbstractFacade<RepNumeroCertificado> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepNumeroCertificadoFacade() {
		super(RepNumeroCertificado.class);
	}

	@Override
	public void createRecord(RepNumeroCertificado entity) {
		try {
			entity.setNceCodigo(findSequence());
			getEntityManager().persist(entity);
			getEntityManager().flush();
		}
		catch (PersistenceException ex) {
			wrapException(DataAction.INSERT, ex);
		}
	}

	@Override
	public void editRecord(RepNumeroCertificado entity) {
		try {
			RepNumeroCertificado repNumeroCertificado = find(entity.getNceCodigo());
			// Permite validar si el registro existe
			if (repNumeroCertificado == null) {
				throw new UPSDataEditException();
			}
			super.editRecord(entity);
		}
		catch (PersistenceException pe) {
			wrapException(DataAction.UPDATE, pe);
		}
	}

	public RepNumeroCertificado consultaSecuenciaCertificado(Long estCodigo, Long pelCodigo, Long ticCodigo) {

		String jpql = "SELECT nce FROM RepNumeroCertificado nce " + "WHERE nce.estCodigo = :estCodigo "
				+ "AND nce.pelCodigo = :pelCodigo " + "AND nce.ticCodigo = :ticCodigo " + "AND nce.audEliminado = 'N'";

		TypedQuery<RepNumeroCertificado> query = getEntityManager().createQuery(jpql, RepNumeroCertificado.class);
		query.setParameter("estCodigo", estCodigo);
		query.setParameter("pelCodigo", pelCodigo);
		query.setParameter("ticCodigo", ticCodigo);
		query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);

		// Obtener el resultado
		List<RepNumeroCertificado> result = query.getResultList();

		// Retornar el primer resultado o null si la lista está vacía
		return result.isEmpty() ? null : result.get(0);
	}

	public RepNumeroCertificado consultaSecuenciaCertificadoAnio(Long estCodigo, Long pelCodigo, Long ticCodigo,
			Long anio) {
		String jpql = " select nce from RepNumeroCertificado nce " + " where nce.estCodigo = ?1 "
				+ " and   nce.ticCodigo = ?2 " + " and   nce.nceAnio   = ?3 " + " and   nce.audEliminado = 'N' ";
		TypedQuery<RepNumeroCertificado> q = getEntityManager().createQuery(jpql, RepNumeroCertificado.class)
			.setParameter(1, estCodigo)
			.setParameter(2, ticCodigo)
			.setParameter(3, anio)
			.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);

		List<RepNumeroCertificado> result = q.getResultList();

		return result.isEmpty() ? null : result.get(0);

	}

}
