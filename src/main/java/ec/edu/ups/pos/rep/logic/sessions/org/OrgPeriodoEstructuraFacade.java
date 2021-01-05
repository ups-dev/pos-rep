package ec.edu.ups.pos.rep.logic.sessions.org;


import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.org.common.data.entities.OrgPeriodoEstructura;
import ec.edu.ups.org.common.data.entities.OrgPeriodoLectivo;
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
public class OrgPeriodoEstructuraFacade extends AbstractFacade<OrgPeriodoEstructura> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrgPeriodoEstructuraFacade() {
        super(OrgPeriodoEstructura.class);
    }
    
    /**
     * Lista Periodos Vigentes Por Campus.     
     * @return Periodos.
     */
   /* public List<OrgPeriodoLectivo> obtienePeriodoPorCampus(OrgEstructura orgEstructuraCampus){
        System.out.println("campus "+orgEstructuraCampus);
        Query q = getEntityManager().createQuery("SELECT pee.orgPeriodoLectivo FROM OrgPeriodoEstructura pee WHERE pee.orgEstructura = :orgEstructuraCampus AND pee.orgPeriodoLectivo.pelTipo= 'P' AND pee.audEliminado= 'N' ORDER BY pee.orgPeriodoLectivo.pelCodigo DESC")
                .setParameter("orgEstructuraCampus", orgEstructuraCampus);                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        System.out.println("periodos "+q.getResultList().size());
        return q.getResultList();
    }*/
    
   /* public List<OrgPeriodoLectivo> obtieneCohortePorPrograma(OrgEstructura orgEstructuraPrograma){
        System.out.println("programa111 "+orgEstructuraPrograma);
        Query q = getEntityManager().createQuery("SELECT distinct pee.orgPeriodoLectivo FROM OrgPeriodoEstructura pee WHERE pee.orgEstructura = :orgEstructuraPrograma AND pee.orgPeriodoLectivo.pelTipo= 'P' AND pee.audEliminado= 'N' ORDER BY pee.orgPeriodoLectivo.pelCodigo DESC")
                .setParameter("orgEstructuraPrograma", orgEstructuraPrograma);                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        System.out.println("periodos "+q.getResultList().size());
        return q.getResultList();
    }*/
    
    public List<OrgPeriodoLectivo> obtieneCohortePorEstructura(OrgEstructura orgEstructura){
     //   System.out.println("programa 222 "+orgEstructura);
        
       Query q = getEntityManager().createNativeQuery(" Select distinct pel.* " +
                        " from org.org_periodo_estructura pee, " +
                        "     org.org_periodo_lectivo    pel, " +
                        "     org.org_estructura         est " +
                        " where est.est_codigo = pee.est_codigo " +
                        " and   pee.pel_codigo = pel.pel_codigo " +
                        " and   pee.est_codigo  IN (SELECT est_codigo e " +
                        "                            FROM   org.org_estructura e " +
                        "                            WHERE  e.est_nivel  = 4 " +
                        "                            START WITH e.est_codigo = ?1 " +  
                        "                            CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre) " +
                        " and pel.pel_Tipo = 'P' " +
                        " and pel.aud_eliminado = 'N' " +
                        " order by 1 DESC ", OrgPeriodoLectivo.class )

                .setParameter(1, orgEstructura.getEstCodigo());
                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }  
    
      
    /**
     * Lista Periodos Vigentes.         
     * @return Periodos.
     */
    public List<OrgPeriodoLectivo> obtienePeriodoLectivo(){
        Query q = getEntityManager().createQuery("SELECT pel FROM OrgPeriodoLectivo pel WHERE pel.pelTipo= 'P' AND pel.audEliminado= 'N' ORDER BY pel.pelCodigo DESC");                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
    ///Método Nuevo 
    public OrgPeriodoEstructura obtieneCohorteEstructura(Long estCodigoPrograma, Long pelCodigo) {

        Query q = getEntityManager().createNativeQuery("  Select distinct pee.* "
                + " from org.org_periodo_estructura pee  "
                + " where  pee.est_codigo = ?1 "
                + " and    pee.pel_codigo = ?2 "                
                + " and    pee.pee_fecha_inicial_cohorte IS NOT NULL "
                + " and    pee.pee_fecha_final_cohorte IS NOT NULL "
                + " and    pee.aud_eliminado = 'N' "
                + " order by 1 DESC", OrgPeriodoEstructura.class)
                .setParameter(1, estCodigoPrograma)
                .setParameter(2, pelCodigo);

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        List<OrgPeriodoEstructura> lista = q.getResultList();
        return lista.isEmpty()?null:lista.get(0);
    }
}
