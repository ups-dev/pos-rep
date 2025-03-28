package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.rep.RepParametroReporte;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class RepParametroReporteFacade extends AbstractFacade<RepParametroReporte> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepParametroReporteFacade() {
		super(RepParametroReporte.class);
	}

	/**
	 * Lista parámetros por reportes.
	 * @param codigoParametro código del parámetro
	 * @param repReportesSistema reportesSistema
	 * @return parametros.
	 */
	public List<RepParametroReporte> obtieneParametroPorReporte(Long codigoParametro,
			RepReportesSistema repReportesSistema) {

		TypedQuery<RepParametroReporte> query = getEntityManager().createQuery(
				"SELECT pre FROM RepParametroReporte pre WHERE pre.repParametro.parCodigo = :codigoParametro AND pre.repReportesSistema = :repReportesSistema AND pre.audEliminado = 'N'",
				RepParametroReporte.class)
			.setParameter("codigoParametro", codigoParametro)
			.setParameter("repReportesSistema", repReportesSistema)
			.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);

		return query.getResultList();
	}

}
