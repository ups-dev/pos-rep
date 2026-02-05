package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.rep.RepParamDep;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

@Stateless
public class RepParamDepFacade extends AbstractFacade<RepParamDep> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepParamDepFacade() {
		super(RepParamDep.class);
	}

	public List<RepParamDep> obtieneParametrosDependientes() {
		TypedQuery<RepParamDep> q = getEntityManager().createQuery(
				"SELECT pd FROM RepParamDep pd WHERE pd.audEliminado = 'N' ORDER BY pd.ppdCodigo", RepParamDep.class);

		return q.getResultList();
	}

}
