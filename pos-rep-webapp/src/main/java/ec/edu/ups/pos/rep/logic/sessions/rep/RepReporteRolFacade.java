package ec.edu.ups.pos.rep.logic.sessions.rep;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pos.rep.data.entities.rep.RepReporteRol;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class RepReporteRolFacade extends AbstractFacade<RepReporteRol> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepReporteRolFacade() {
		super(RepReporteRol.class);
	}

}
