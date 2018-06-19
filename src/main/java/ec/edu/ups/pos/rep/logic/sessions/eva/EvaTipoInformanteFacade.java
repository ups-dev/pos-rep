/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.eva;

import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.pos.rep.data.entities.eva.EvaTipoInformante;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pedro
 */
@Stateless
public class EvaTipoInformanteFacade extends AbstractFacade<EvaTipoInformante>{
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaTipoInformanteFacade() {
        super(EvaTipoInformante.class);
    }
    
    /**
     * Lista EvaluacionCuestionario.     
     * @return Cuestionarios por Evaluaciones.
     */
    public List<EvaTipoInformante> obtieneTipoInformante(){
        Query q = getEntityManager().createQuery("SELECT tii FROM EvaTipoInformante tii WHERE tii.audEliminado= 'N' ORDER BY tii.tiiCodigo ");
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }

}
