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
     * @return Grupos por malla.
     */
    public List<OfeGrupo> obtieneGrupo(PedMalla pedMalla, Long orgPeriodoInicial, Long orgPeriodoFinal, GthPersona gthPersona){
        Query q = getEntityManager().createQuery("SELECT gru "
                                               + "FROM   OfeGrupo         gru, "
                                               + "       OfeDistributivo  dis "
                                               + "WHERE  gru              = dis.ofeGrupo "
                                               + "AND    gru.malCodigo    = :malCodigo "
                                               + "AND    gru.pelCodigo    BETWEEN :pelCodigoInicial AND :pelCodigoFinal "
                                               + "AND    dis.perCodigo    = :perCodigo "
                                               + "AND    gru.audEliminado = 'N' "
                                               + "ORDER BY gru.gruCodigo ")
                .setParameter("malCodigo", pedMalla.getMalCodigo())
                .setParameter("pelCodigoInicial", orgPeriodoInicial)
                .setParameter("pelCodigoFinal", orgPeriodoFinal)
                .setParameter("perCodigo", gthPersona.getPerCodigo());                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
}
