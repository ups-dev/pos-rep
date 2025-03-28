package ec.edu.ups.pos.rep.logic.sessions.ped;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.entities.ped.PedModalidad;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class PedModalidadFacade extends AbstractFacade<PedModalidad> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public PedModalidadFacade() {
		super(PedModalidad.class);
	}

	public List<PedModalidad> obtieneModalidadPorEstructura(OrgEstructura orgEstructura) {

		Query q = getEntityManager()
			.createNativeQuery(" SELECT distinct mod.mod_codigo,mod.mod_descripcion " + " FROM ped.ped_modalidad mod, "
					+ "     ped.ped_mod_pro_edu mpe, " + "     ped.ped_proyecto_educacion  pre, "
					+ "     ped.ped_des_est_pro_edu     dep, " + "     org.org_descripcion_estructura dpos, "
					+ "     org.org_estructura             pos " + " WHERE mod.mod_codigo = mpe.mod_codigo "
					+ " and   mod.aud_eliminado = 'N' " + " and   pre.pre_numero = mpe.pre_numero "
					+ " and   dep.pre_numero = pre.pre_numero " + " and   dpos.dee_codigo = dep.dee_codigo "
					+ " and   pos.dee_codigo  = dpos.dee_codigo " + " and   pos.est_codigo IN (SELECT e.est_codigo  "
					+ "                         FROM   org.org_estructura e  "
					+ "                         WHERE  e.est_nivel  = 4 "
					+ "                         START WITH e.est_codigo = ?1 "
					+ "                         CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre)  " + " ORDER BY 1 ",
					PedModalidad.class)
			.setParameter(1, orgEstructura.getEstCodigo());

		return q.getResultList();
	}

	public List<PedModalidad> obtieneModalidad() {
		Query q = getEntityManager().createNativeQuery(
				" SELECT  mod.mod_codigo,mod.mod_descripcion  " + " FROM ped.ped_modalidad mod "
						+ " WHERE mod.aud_eliminado = 'N' " + " AND   mod.mod_codigo != 5 " + " ORDER BY 1 ",
				PedModalidad.class);

		return q.getResultList();
	}

}
