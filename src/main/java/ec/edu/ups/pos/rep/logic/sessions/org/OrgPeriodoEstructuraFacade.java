package ec.edu.ups.pos.rep.logic.sessions.org;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoEstructura;
import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoLectivo;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

@Stateless
public class OrgPeriodoEstructuraFacade extends AbstractFacade<OrgPeriodoEstructura> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public OrgPeriodoEstructuraFacade() {
		super(OrgPeriodoEstructura.class);
	}

	/**
	 * Lista periodos vigentes por campus.
	 * @param orgEstructura .
	 * @return periodos .
	 */

	public List<OrgPeriodoLectivo> obtieneCohortePorEstructura(OrgEstructura orgEstructura) {

		String sql = " Select distinct pel.* " + " from org.org_periodo_estructura pee, "
				+ "     org.org_periodo_lectivo    pel, " + "     org.org_estructura         est "
				+ " where est.est_codigo = pee.est_codigo " + " and   pee.pel_codigo = pel.pel_codigo "
				+ " and   pee.est_codigo  IN (SELECT est_codigo e "
				+ "                            FROM   org.org_estructura e "
				+ "                            WHERE  e.est_nivel  = 4 "
				+ "                            START WITH e.est_codigo = ?1 "
				+ "                            CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre) "
				+ " and pel.pel_Tipo = 'P' " + " and pel.aud_eliminado = 'N' " + " order by 1 DESC ";

		Query q = getEntityManager().createNativeQuery(sql, OrgPeriodoLectivo.class)
			.setParameter(1, orgEstructura.getEstCodigo())
			.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
		return q.getResultList();
	}

	/**
	 * Lista periodos vigentes por campus.
	 * @param orgEstructura .
	 * @return periodos .
	 */
	public List<OrgPeriodoLectivo> obtieneCohorteDoctoradoPorEstructura(OrgEstructura orgEstructura) {

		String sql = " Select distinct pel.* " + " from org.org_periodo_estructura pee, "
				+ "     org.org_periodo_lectivo    pel, " + "     org.org_estructura         est "
				+ " where est.est_codigo = pee.est_codigo " + " and   pee.pel_codigo = pel.pel_codigo "
				+ " and   pee.est_codigo  IN (SELECT est_codigo e "
				+ "                            FROM   org.org_estructura e "
				+ "                            WHERE  e.est_nivel  = 4 "
				+ "                            START WITH e.est_codigo = ?1 "
				+ "                            CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre) "
				+ " and pel.pel_Tipo = 'D' " + " and pel.aud_eliminado = 'N' " + " order by 1 DESC ";

		Query q = getEntityManager().createNativeQuery(sql, OrgPeriodoLectivo.class)
			.setParameter(1, orgEstructura.getEstCodigo())
			.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
		return q.getResultList();
	}

	/**
	 * Lista periodos vigentes.
	 * @return periodos.
	 */
	public List<OrgPeriodoLectivo> obtienePeriodoLectivo() {
		TypedQuery<OrgPeriodoLectivo> q = getEntityManager().createQuery(
				"SELECT pel FROM OrgPeriodoLectivo pel WHERE pel.pelTipo= ('P') AND pel.audEliminado= 'N' ORDER BY pel.pelCodigo DESC",
				OrgPeriodoLectivo.class)
			.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
		return q.getResultList();
	}

	/**
	 * Lista periodos vigentes.
	 * @return periodos.
	 */
	public List<OrgPeriodoLectivo> obtienePeriodoLectivoDoctorado() {
		TypedQuery<OrgPeriodoLectivo> q = getEntityManager().createQuery(
				"SELECT pel FROM OrgPeriodoLectivo pel WHERE pel.pelTipo= ('D') AND pel.audEliminado= 'N' ORDER BY pel.pelCodigo DESC",
				OrgPeriodoLectivo.class)
			.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
		return q.getResultList();
	}

	/// Método Nuevo
	public OrgPeriodoEstructura obtieneCohorteEstructura(Long estCodigoPrograma, Long pelCodigo) {

		String jpql = "SELECT DISTINCT pee " + "FROM OrgPeriodoEstructura pee "
				+ "WHERE pee.orgEstructura.estCodigo = :estCodigo "
				+ "AND pee.orgPeriodoLectivo.pelCodigo = :pelCodigo " + "AND pee.peeFechaInicialCohorte IS NOT NULL "
				+ "AND pee.peeFechaFinalCohorte IS NOT NULL " + "AND pee.audEliminado = 'N' "
				+ "ORDER BY pee.orgEstructura.estCodigo  DESC";

		TypedQuery<OrgPeriodoEstructura> q = getEntityManager().createQuery(jpql, OrgPeriodoEstructura.class)
			.setParameter("estCodigo", estCodigoPrograma)
			.setParameter("pelCodigo", pelCodigo)
			.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
		List<OrgPeriodoEstructura> lista = q.getResultList();
		return lista.isEmpty() ? null : lista.get(0);
	}

}
