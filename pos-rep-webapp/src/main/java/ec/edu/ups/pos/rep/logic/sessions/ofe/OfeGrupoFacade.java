package ec.edu.ups.pos.rep.logic.sessions.ofe;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.data.entities.ofe.OfeGrupo;
import ec.edu.ups.pos.rep.data.entities.ped.PedMalla;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class OfeGrupoFacade extends AbstractFacade<OfeGrupo> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public OfeGrupoFacade() {
		super(OfeGrupo.class);
	}

	/**
	 * Lista grupos.
	 * @param pedMalla mallas
	 * @param orgPeriodoInicial período inicial
	 * @param orgPeriodoFinal período final
	 * @param gthPersona docente
	 * @param estCodigo programa
	 * @return grupos por malla.
	 */
	public List<OfeGrupo> obtieneGrupo(PedMalla pedMalla, Long orgPeriodoInicial, Long orgPeriodoFinal,
			GthPersona gthPersona, Long estCodigo) {
		Query q = getEntityManager()
			.createNativeQuery(
					" SELECT gru.* " + " FROM   ofe.ofe_grupo         gru, " + "       ofe.ofe_distributivo  dis "
							+ " WHERE  dis.GRU_CODIGO=gru.GRU_CODIGO " + " AND    gru.mal_Codigo    = ?1 "
							+ " and    dis.est_codigo IN (SELECT  e.est_codigo " + " FROM    org.org_estructura e "
							+ " CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre " + " START WITH e.est_codigo = ?2) "
							+ " AND    gru.pel_Codigo    BETWEEN ?3 AND ?4 " + " AND    dis.per_Codigo    = ?5 "
							+ " AND    gru.aud_Eliminado = 'N' " + " ORDER BY gru.gru_Codigo",
					OfeGrupo.class)
			.setParameter(1, pedMalla.getMalCodigo())
			.setParameter(2, estCodigo)
			.setParameter(3, orgPeriodoInicial)
			.setParameter(4, orgPeriodoFinal)
			.setParameter(5, gthPersona.getPerCodigo())
			.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
		return q.getResultList();
	}

}
