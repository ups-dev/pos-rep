/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepTipCerRepSis;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author UPS
 */
@Stateless
public class RepTipCerRepSisFacade extends AbstractFacade<RepTipCerRepSis> {

    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepTipCerRepSisFacade() {
        super(RepTipCerRepSis.class);
    }
    
     public RepTipCerRepSis consultaTipoCertificado(Long resCodigo) {
      
        Query q = getEntityManager().createNativeQuery("select * from REP.REP_TIP_CER_REP_SIS r "
                                                      + "where r.res_codigo = ?1 "
                                                      + "AND r.aud_eliminado = 'N' ", RepTipCerRepSis.class)
                                                    .setParameter(1, resCodigo);

        List<RepTipCerRepSis> result = q.getResultList();

        return result.isEmpty() ? null : result.get(0);

    }
}
