package ec.edu.ups.pos.rep.logic.sessions.ped;


import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.org.common.data.entities.OrgEstructura;
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
public class PedMallaFacade extends AbstractFacade<PedMalla> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedMallaFacade() {
        super(PedMalla.class);
    }
    
    /**
     * Lista mallas por carrera.     
     * @param orgEstructuraCarrera Carrera
     * @param pelCodigo Periodo Lectivo
     * @return Mallas por carrera.
     */
    public List<PedMalla> obtieneMalla(Long orgEstructuraCarrera, Long pelCodigo){
        Query q = getEntityManager().createQuery("SELECT distinct mal "
                                               + "FROM   PedMalla mal, "
                                               + "       OfeGrupo gru, "
                                               + "       OfeDistributivo dis "
                                               + "WHERE  mal.malCodigo    = gru.malCodigo "
                                               + "AND    gru.gruCodigo = dis.ofeGrupo.gruCodigo "
                                               + "AND    dis.estCodigo = :estCodigoCarrera "
                                               + "AND    gru.pelCodigo  = :pelCodigo "
                                               + "AND    mal.audEliminado = 'N' "
                                               + "ORDER BY mal.pedMateria.matDescripcion ")
                .setParameter("estCodigoCarrera", orgEstructuraCarrera)
                .setParameter("pelCodigo", pelCodigo);
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
    /**
     * Lista mallas por carrera y docente.     
     * @param orgEstructuraCarrera Carrera
     * @param gthPersona docente
     * @param pelCodigo Periodo
     * @return Mallas por carrera.
     */
    public List<PedMalla> obtieneMallaDocente(Long orgEstructuraCarrera, GthPersona gthPersona, Long pelCodigo){
//        Query q = getEntityManager().createQuery("SELECT distinct mal "
//                                               + "FROM   PedMalla mal, "
//                                               + "       OfeGrupo gru, "
//                                               + "       OfeDistributivo  dis "
//                                               + "WHERE  mal.malCodigo    = gru.malCodigo "
//                                               + "AND    gru              = dis.ofeGrupo "
//                                               + "AND    gru.estCodigoEva = :estCodigoCarrera "
////                                               + "AND    gru.orgEstructura IN (SELECT  est"
////                                               + "                             FROM    orgEstructura est "
////                                               + "                             CONNECT BY PRIOR est.estCodigo = est.estCodigoPadre "                
////                                               + "                             START WITH est.estCodigo = :estCodigoCarrera) "
//                                               + "AND    dis.perCodigo    = :perCodigo "
//                                               + "AND    gru.pelCodigo    = :pelCodigo "
//                                               + "AND    mal.audEliminado = 'N' "
//                                               + "ORDER BY mal.pedMateria.matDescripcion ")
//                .setParameter("estCodigoCarrera", orgEstructuraCarrera)
//                .setParameter("perCodigo", gthPersona.getPerCodigo())
//                .setParameter("pelCodigo", pelCodigo);

        Query q = getEntityManager().createNativeQuery("SELECT distinct mal.* "
                                                     + "FROM   ped.ped_malla mal, "
                                                     + "       ofe.ofe_grupo gru, "
                                                     + "       ofe.ofe_distributivo  dis "
                                                     + "WHERE  mal.mal_codigo   = gru.mal_codigo "
                                                     + "AND    gru.gru_codigo   = dis.gru_codigo "
                                                     + "AND    dis.est_codigo IN (SELECT  est.est_codigo"
                                                     + "                              FROM    org.org_estructura est "
                                                     + "                              CONNECT BY PRIOR est.est_codigo = est.est_codigo_padre "
                                                     + "                              START WITH est.est_codigo = ?1) "
                                                     + "AND    dis.per_codigo    = ?2 "
                                                     + "AND    gru.pel_codigo    = ?3 "
                                                     + "AND    mal.aud_eliminado = 'N' ", PedMalla.class)

                .setParameter(1, orgEstructuraCarrera)
                .setParameter(2, gthPersona.getPerCodigo())
                .setParameter(3, pelCodigo);
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
     public List<Integer> obtieneNivelMalla(Long orgEstructuraCarrera, Long pelCodigo){
        Query q = getEntityManager().createQuery("SELECT distinct mal.malNivel "
                                               + "FROM   PedMalla mal, "
                                               + "       OfeGrupo gru, "
                                               + "       OfeDistributivo dis "
                                               + "WHERE  mal.malCodigo    = gru.malCodigo "
                                               + "AND    gru.gruCodigo = dis.ofeGrupo.gruCodigo "
                                               + "AND    dis.estCodigo = :estCodigoCarrera "
                                               + "AND    gru.pelCodigo  = :pelCodigo "
                                               + "AND    mal.audEliminado = 'N' "
                                               + "ORDER BY mal.pedMateria.matDescripcion ")
                .setParameter("estCodigoCarrera", orgEstructuraCarrera)
                .setParameter("pelCodigo", pelCodigo);
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
}
