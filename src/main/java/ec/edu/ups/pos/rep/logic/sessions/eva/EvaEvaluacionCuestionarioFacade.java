package ec.edu.ups.pos.rep.logic.sessions.eva;

import ec.edu.ups.pos.rep.data.entities.eva.EvaEvaluacionCuestionario;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.org.common.data.entities.OrgPeriodoLectivo;
import ec.edu.ups.ped.common.data.entities.PedModalidad;
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
public class EvaEvaluacionCuestionarioFacade extends AbstractFacade<EvaEvaluacionCuestionario> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaEvaluacionCuestionarioFacade() {
        super(EvaEvaluacionCuestionario.class);
    }
    
    /**
     * Lista EvaluacionCuestionario.     
     * @param pedModalidad modalidad para la evaluacionCuestionario
     * @param orgPeriodoInicial Período Inicial
     * @param orgPeriodoFinal Período Final
     * @param orgEstructuraCampus Campus
     * @return Cuestionarios por Evaluaciones.
     */
    public List<EvaEvaluacionCuestionario> obtieneEvaluacionCuestionario(PedModalidad pedModalidad, OrgPeriodoLectivo orgPeriodoInicial, OrgPeriodoLectivo orgPeriodoFinal, OrgEstructura orgEstructuraCampus){
//        Query q = getEntityManager().createQuery("SELECT evc FROM EvaEvaluacionCuestionario evc WHERE evc.modCodigo= :modCodigo AND evc.pelCodigo BETWEEN :periodoInicial AND :periodoFinal AND evc.estCodigo= :estructuraCampus AND evc.audEliminado= 'N' ORDER BY evc.evaCuestionario.cueCodigo ")
//                .setParameter("modCodigo", pedModalidad.getModCodigo())
//                .setParameter("periodoInicial", orgPeriodoInicial.getPelCodigo())
//                .setParameter("periodoFinal", orgPeriodoFinal.getPelCodigo())
//                .setParameter("estructuraCampus", orgEstructuraCampus.getEstCodigo());                
//        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
                
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT evc FROM EvaEvaluacionCuestionario evc WHERE evc.audEliminado= 'N' ");

        if (pedModalidad!=null) {
            sb.append(" AND evc.modCodigo= :modCodigo ");
        }

        if (orgPeriodoInicial!=null && orgPeriodoFinal!=null) {
            sb.append(" AND evc.pelCodigo BETWEEN :periodoInicial AND :periodoFinal");            
        }
        if(orgPeriodoInicial!=null&& orgPeriodoFinal==null){
            sb.append(" AND evc.pelCodigo = :periodoInicial ");
        }
        if(orgPeriodoInicial==null&& orgPeriodoFinal!=null){
            sb.append(" AND evc.pelCodigo = :periodoFinal ");
        }
        if (orgEstructuraCampus!=null) {
            sb.append(" AND evc.estCodigo= :estructuraCampus ");            
        }
//        sb.append(" AND evc.evaEvaluacion.evaVigente = 'S' ");
        sb.append(" AND evc.evaEvaluacion.audEliminado = 'N' ");
        sb.append(" ORDER BY evc.evaCuestionario.cueCodigo, evc.estCodigo, evc.modCodigo ");

        Query result = em.createQuery(sb.toString());        

        if (pedModalidad!=null) {
            result.setParameter("modCodigo", pedModalidad.getModCodigo());
        }
        if (orgPeriodoInicial!=null && orgPeriodoFinal!=null) {
            result.setParameter("periodoInicial", orgPeriodoInicial.getPelCodigo());
            result.setParameter("periodoFinal", orgPeriodoFinal.getPelCodigo());          
        }
        if(orgPeriodoInicial!=null&& orgPeriodoFinal==null){
            result.setParameter("periodoInicial", orgPeriodoInicial.getPelCodigo());
        }
        if(orgPeriodoInicial==null&& orgPeriodoFinal!=null){
            result.setParameter("periodoFinal", orgPeriodoFinal.getPelCodigo()); 
        }
        if (orgEstructuraCampus!=null) {
            result.setParameter("estructuraCampus", orgEstructuraCampus.getEstCodigo());            
        }
        
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(result);

        return result.getResultList();
    }    
    
}
