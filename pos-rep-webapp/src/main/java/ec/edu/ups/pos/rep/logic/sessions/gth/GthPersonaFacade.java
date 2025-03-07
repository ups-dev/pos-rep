/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.gth;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author Administrador .
 */
@Stateless
public class GthPersonaFacade extends AbstractFacade<GthPersona> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public GthPersonaFacade() {
		super(GthPersona.class);
	}

	// Obtiene la lista de docentes de GthPersona y GthContrato
	public List<GthPersona> listaGthPersonaFiltro(String filtro, Long estCodigo, Long pelCodigo) {
		Query q = getEntityManager().createNativeQuery(" select distinct per.* " + " from   ofe.ofe_grupo gru, "
				+ " ofe.ofe_distributivo dis, " + " gth.gth_persona per " + " where  gru.gru_codigo = dis.gru_codigo "
				+ " and    dis.per_codigo = per.per_codigo " + " and    gru.pel_codigo = ?3 "
				+ " and    (per.PER_APELLIDOS like ?1 OR per.PER_NOMBRES like ?1 OR per.PER_NRO_IDENTIFICACION like ?1) "
				+ " and    dis.est_codigo IN (SELECT  e.est_codigo " + " FROM    org.org_estructura e "
				+ " CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre " + " START WITH e.est_codigo = ?2) "
				+ " AND per.per_eliminado = 'N' ", GthPersona.class)
			.setParameter(1, '%' + filtro + '%')
			.setParameter(2, estCodigo)
			.setParameter(3, pelCodigo)
			.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
		return q.getResultList();
	}

}
