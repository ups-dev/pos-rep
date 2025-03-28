package ec.edu.ups.pos.rep.logic.sessions.org;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoLectivo;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class OrgPeriodoLectivoFacade extends AbstractFacade<OrgPeriodoLectivo> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public OrgPeriodoLectivoFacade() {
		super(OrgPeriodoLectivo.class);
	}

}
