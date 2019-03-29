/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepSecretarioGeneral;
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
 * @author UPS
 */
@Stateless
public class RepSecretarioGeneralFacade extends AbstractFacade<RepSecretarioGeneral> {
    
      @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepSecretarioGeneralFacade() {
        super(RepSecretarioGeneral.class);
    }
    
     public List<RepSecretarioGeneral> obtieneSecretarioGeneral(){
        Query q = getEntityManager().createQuery("SELECT seg FROM RepSecretarioGeneral seg WHERE seg.audEliminado = 'N' ORDER BY seg.segCodigo");
             
        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        
        return q.getResultList();
    }
    
}
