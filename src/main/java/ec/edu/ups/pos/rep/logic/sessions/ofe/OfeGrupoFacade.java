package ec.edu.ups.pos.rep.logic.sessions.ofe;


import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.data.entities.ofe.OfeGrupo;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.org.common.data.entities.OrgPeriodoLectivo;
import ec.edu.ups.ped.common.data.entities.PedMalla;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ups
 */
@Stateless
public class OfeGrupoFacade extends AbstractFacade<OfeGrupo> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfeGrupoFacade() {
        super(OfeGrupo.class);
    }
    
    /**
     * Lista grupos.     
     * @param pedMalla mallas
     * @param orgPeriodoInicial Período Inicial
     * @param orgPeriodoFinal Período Final
     * @param gthPersona Docente
     * @param estCodigo Programa
     * @return Grupos por malla.
     */
    public List<OfeGrupo> obtieneGrupo(PedMalla pedMalla, Long orgPeriodoInicial, Long orgPeriodoFinal, GthPersona gthPersona,Long estCodigo){
        Query q = getEntityManager().createNativeQuery(" SELECT gru.* " +
                                                        " FROM   ofe.ofe_grupo         gru, " +
                                                        "       ofe.ofe_distributivo  dis " +
                                                        " WHERE  dis.GRU_CODIGO=gru.GRU_CODIGO " +
                                                        " AND    gru.mal_Codigo    = ?1 " +
                                                        " and    dis.est_codigo IN (SELECT  e.est_codigo " +
                                                                                    " FROM    org.org_estructura e " +
                                                                                    " CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre " +
                                                                                    " START WITH e.est_codigo = ?2) " +
                                                        " AND    gru.pel_Codigo    BETWEEN ?3 AND ?4 " +
                                                        " AND    dis.per_Codigo    = ?5 " +
                                                        " AND    gru.aud_Eliminado = 'N' " +
                                                        " ORDER BY gru.gru_Codigo",OfeGrupo.class)
                .setParameter(1, pedMalla.getMalCodigo())
                .setParameter(2, estCodigo)
                .setParameter(3, orgPeriodoInicial)
                .setParameter(4, orgPeriodoFinal)
                .setParameter(5, gthPersona.getPerCodigo());                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
}
