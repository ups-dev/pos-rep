package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.rep.RepModulo;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

@Stateless
public class RepModuloFacade extends AbstractFacade<RepModulo> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepModuloFacade() {
		super(RepModulo.class);
	}

	public List<RepModulo> obtieneModulos() {
		TypedQuery<RepModulo> q = getEntityManager().createQuery(
				"SELECT m FROM RepModulo m WHERE m.audEliminado = 'N' ORDER BY m.modOrden, m.modNombre",
				RepModulo.class);

		return q.getResultList();
	}

}
