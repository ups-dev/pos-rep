/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.pos.rep.logic.sessions.org;


import ec.edu.ups.org.common.data.entities.OrgPeriodoLectivo;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ups
 */
@Stateless
public class OrgPeriodoLectivoFacade extends AbstractFacade<OrgPeriodoLectivo> {
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrgPeriodoLectivoFacade() {
        super(OrgPeriodoLectivo.class);
    }
    
}
