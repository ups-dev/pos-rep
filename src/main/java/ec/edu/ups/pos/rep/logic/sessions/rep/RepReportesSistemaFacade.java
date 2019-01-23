package ec.edu.ups.pos.rep.logic.sessions.rep;


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
public class RepReportesSistemaFacade extends AbstractFacade<RepReportesSistema> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepReportesSistemaFacade() {
        super(RepReportesSistema.class);
    }

        //Obtiene la lista de docentes de GthPersona y GthContrato
    public List<RepReportesSistema> listaReportesAutorizados(String user, String sistema, String modulo) {
        System.out.println("2s: "+user+" sistema: "+sistema+" módulo: "+modulo);
        Query q = getEntityManager().createNativeQuery("SELECT DISTINCT res.* " +
                                                       "FROM   rep.rep_reportes_sistema       res, " +
                                                       "       rep.rep_reporte_rol            rer, " +
                                                       "       aseg.aseg_usr_est_rol          uer, " +
                                                       "       aseg.aseg_usuario_estructura   use, " +
                                                       "       aseg.aseg_usuario              usu " +
                                                       "WHERE  res.res_codigo                 = rer.res_codigo " +
                                                       "AND    rer.rol_codigo                 = uer.rol_codigo " +
                                                       "AND    uer.use_codigo                 = use.use_codigo " +
                                                       "AND    use.usu_codigo                 = usu.usu_codigo " +
                                                       "AND    usu.usu_email                  = ?1 " +
                                                       "AND    res.res_aplicacion             = ?2 " +
                                                       "AND    res.res_modulo                 = ?3 " , RepReportesSistema.class)
                .setParameter(1, user)
                .setParameter(2, sistema)
                .setParameter(3, modulo);
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }               
}
