/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.pos.rep.logic.sessions.ped;


import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.ped.common.data.entities.PedModalidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ups
 */
@Stateless
public class PedModalidadFacade extends AbstractFacade<PedModalidad> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedModalidadFacade() {
        super(PedModalidad.class);
    }
    
}
