package ec.edu.ups.pos.rep.logic.sessions.rep;


import ec.edu.ups.pos.rep.data.entities.rep.RepParametro;
import ec.edu.ups.pos.rep.data.entities.rep.RepParametroReporte;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
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
public class RepParametroReporteFacade extends AbstractFacade<RepParametroReporte> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepParametroReporteFacade() {
        super(RepParametroReporte.class);
    }
    
    /**
     * Lista Parámetros por Reportes.     
     * @param codigoParametro Código del Parámetro
     * @param repReportesSistema ReportesSistema
     * @return Parametros.
     */
    public List<RepParametroReporte> obtieneParametroPorReporte(Long codigoParametro, RepReportesSistema repReportesSistema){
        Query q = getEntityManager().createQuery("SELECT pre FROM RepParametroReporte pre WHERE pre.repParametro.parCodigo = :codigoParametro AND pre.repReportesSistema= :repReportesSistema AND pre.audEliminado= 'N' ")
                .setParameter("codigoParametro", codigoParametro)
                .setParameter("repReportesSistema", repReportesSistema);                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        
      //  System.out.println("q.getResultList()jkjlj"+q.getResultList().size());
      //    System.out.println("codigoParametro"+codigoParametro);
      //      System.out.println("repReportesSistema"+repReportesSistema);
        return q.getResultList();
        
    }
    
}
