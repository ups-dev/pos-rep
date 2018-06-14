package ec.edu.ups.pos.rep.logic.sessions.eva;

import ec.edu.ups.pos.rep.data.entities.eva.EvaEvaCueInf;
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
public class EvaEvaCueInfFacade extends AbstractFacade<EvaEvaCueInf> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaEvaCueInfFacade() {
        super(EvaEvaCueInf.class);
    }
    
    /**
     * Lista EvaluacionCuestionario.     
     * @param evaEvaluacionCuestionario Cuestionario por Evaluación
     * @return Cuestionarios por Evaluaciones.
     */
    public List<EvaEvaCueInf> obtieneInformantePorEvaluacionCuestionario(EvaEvaluacionCuestionario evaEvaluacionCuestionario){
        Query q = getEntityManager().createQuery("SELECT eci FROM EvaEvaCueInf eci WHERE eci.evaEvaluacionCuestionario= :evaEvaluacionCuestionario AND eci.audEliminado= 'N' ORDER BY eci.evaInfTipEva.evaTipoInformanteInf.tiiCodigo ") 
                .setParameter("evaEvaluacionCuestionario", evaEvaluacionCuestionario);                
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
//    public List<OrgEstructura> obtenerEstructuraAlumno(String alu_codigo){
//        String sql = " SELECT estCarrera.*" +                     
//                     " FROM INS.INS_ALUMNO alu " +
//                     "     inner join INS.INS_INSCRIPCION insc on alu.ALU_CODIGO = insc.ALU_CODIGO" +
//                     "     inner join INS.INS_OFERTA_INSCRIPCION_INICIAL oii on insc.OII_CODIGO = oii.OII_CODIGO" +
//                     "     inner join ORG.ORG_ESTRUCTURA estCarrera on estCarrera.EST_CODIGO = oii.EST_CODIGO" +
//                     "     inner join ORG.ORG_DESCRIPCION_ESTRUCTURA deeCarrera on deeCarrera.DEE_CODIGO = estCarrera.DEE_CODIGO" +
//                     " WHERE alu.ALU_CODIGO = "+alu_codigo;        
//        Query q = em.createNativeQuery(sql, OrgEstructura.class);                       
//        return q.getResultList();
//    }
    
}
