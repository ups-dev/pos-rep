package ec.edu.ups.pos.rep.logic.sessions.org;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pos.rep.data.entities.org.OrgAreaGeografica;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author Administrador .
 */
@Stateless
public class OrgAreaGeograficaFacade extends AbstractFacade<OrgAreaGeografica> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public OrgAreaGeograficaFacade() {
		super(OrgAreaGeografica.class);
	}

}
