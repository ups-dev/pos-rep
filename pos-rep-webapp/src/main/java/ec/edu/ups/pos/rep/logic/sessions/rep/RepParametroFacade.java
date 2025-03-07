package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pos.rep.data.entities.rep.RepParametro;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class RepParametroFacade extends AbstractFacade<RepParametro> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepParametroFacade() {
		super(RepParametro.class);
	}

	/**
	 * Lista parámetros por reportes.
	 * @return parametros.
	 */
	@Override
	public List<RepParametro> findAll() {
		return super.findAll();
	}

}
