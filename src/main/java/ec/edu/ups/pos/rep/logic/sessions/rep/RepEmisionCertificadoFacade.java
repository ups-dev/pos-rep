package ec.edu.ups.pos.rep.logic.sessions.rep;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import ec.edu.ups.pos.rep.data.entities.rep.RepEmisionCertificado;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

@Stateless
public class RepEmisionCertificadoFacade extends AbstractFacade<RepEmisionCertificado> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepEmisionCertificadoFacade() {
		super(RepEmisionCertificado.class);
	}

	@Override
	public void createRecord(RepEmisionCertificado entity) {
		try {
			entity.setEmcCodigo(findSequence());
			// System.out.println(entity.getAluCodigo());
			// System.out.println(entity.getEmcCodigo());

			getEntityManager().persist(entity);
			getEntityManager().flush();
		}
		catch (PersistenceException ex) {
			wrapException(DataAction.INSERT, ex);
		}
	}

}
