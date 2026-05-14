package ec.edu.ups.pos.rep.logic.sessions.aseg;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pos.rep.data.entities.aseg.AsegRol;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class AsegRolFacade extends AbstractFacade<AsegRol> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public AsegRolFacade() {
		super(AsegRol.class);
	}

	@Override
	public List<AsegRol> findAll() {
		return super.findAll();
	}

}
