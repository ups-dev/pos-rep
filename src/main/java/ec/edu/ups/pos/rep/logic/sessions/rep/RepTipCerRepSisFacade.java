package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.rep.RepTipCerRepSis;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.util.exceptions.UPSDataSelectException;

/**
 * Description.
 *
 * @author UPS .
 */
@Stateless
public class RepTipCerRepSisFacade extends AbstractFacade<RepTipCerRepSis> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepTipCerRepSisFacade() {
		super(RepTipCerRepSis.class);
	}

	public RepTipCerRepSis consultaTipoCertificado(Long resCodigo) {
		try {
			String sql = "SELECT r FROM RepTipCerRepSis r WHERE r.resCodigo = :resCodigo AND r.audEliminado = 'N'";
			TypedQuery<RepTipCerRepSis> query = getEntityManager().createQuery(sql, RepTipCerRepSis.class)
				.setParameter("resCodigo", resCodigo);

			List<RepTipCerRepSis> result = query.getResultList();
			return result.isEmpty() ? null : result.get(0);
		}
		catch (Exception ex) {
			throw new UPSDataSelectException(ex); // Asegúrate de manejar correctamente la
													// excepción
		}
	}

}
