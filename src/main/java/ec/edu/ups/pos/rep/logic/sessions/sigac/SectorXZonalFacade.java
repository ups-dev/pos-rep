package ec.edu.ups.pos.rep.logic.sessions.sigac;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pos.rep.data.entities.sigac.SectorXZonal;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author Administrador .
 */
@Stateless
public class SectorXZonalFacade extends AbstractFacade<SectorXZonal> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public SectorXZonalFacade() {
		super(SectorXZonal.class);
	}

}
