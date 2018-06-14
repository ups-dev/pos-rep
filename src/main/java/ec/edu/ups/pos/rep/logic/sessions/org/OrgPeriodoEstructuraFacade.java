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
     * @param orgEstructuraCampus Campus
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
      public List<OrgPeriodoLectivo> obtieneCohortePorPrograma(OrgEstructura orgEstructuraPrograma){
        System.out.println("programa "+orgEstructuraPrograma);
        Query q = getEntityManager().createQuery("SELECT pee.orgPeriodoLectivo FROM OrgPeriodoEstructura pee WHERE pee.orgEstructura = :orgEstructuraPrograma AND pee.orgPeriodoLectivo.pelTipo= 'P' AND pee.audEliminado= 'N' ORDER BY pee.orgPeriodoLectivo.pelCodigo DESC")
                .setParameter("orgEstructuraPrograma", orgEstructuraPrograma);                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        System.out.println("periodos "+q.getResultList().size());
        return q.getResultList();
    }
    /**
     * Lista Periodos Vigentes.         
     * @return Periodos.
     */
    public List<OrgPeriodoLectivo> obtienePeriodoLectivo(){
        Query q = getEntityManager().createQuery("SELECT pel FROM OrgPeriodoLectivo pel WHERE pel.pelTipo= 'O' AND pel.audEliminado= 'N' ORDER BY pel.pelCodigo DESC");                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
}
