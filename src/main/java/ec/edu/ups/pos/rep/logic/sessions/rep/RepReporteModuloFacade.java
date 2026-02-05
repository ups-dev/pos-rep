package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.rep.RepReporteModulo;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

@Stateless
public class RepReporteModuloFacade extends AbstractFacade<RepReporteModulo> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepReporteModuloFacade() {
		super(RepReporteModulo.class);
	}

	public List<RepReporteModulo> obtieneReportesModulo() {
		TypedQuery<RepReporteModulo> q = getEntityManager().createQuery(
				"SELECT rm FROM RepReporteModulo rm WHERE rm.audEliminado = 'N' ORDER BY rm.rrmOrden",
				RepReporteModulo.class);

		return q.getResultList();
	}

}
