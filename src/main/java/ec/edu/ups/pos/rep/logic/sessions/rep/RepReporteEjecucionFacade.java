package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.rep.RepReporteEjecucion;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

@Stateless
public class RepReporteEjecucionFacade extends AbstractFacade<RepReporteEjecucion> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepReporteEjecucionFacade() {
		super(RepReporteEjecucion.class);
	}

	public List<RepReporteEjecucion> obtieneReportesEjecucion() {
		TypedQuery<RepReporteEjecucion> q = getEntityManager().createQuery(
				"SELECT re FROM RepReporteEjecucion re WHERE re.audEliminado = 'N' ORDER BY re.fechaInicio DESC",
				RepReporteEjecucion.class);

		return q.getResultList();
	}

}
