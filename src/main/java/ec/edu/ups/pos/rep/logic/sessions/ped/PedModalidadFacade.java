/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.ups.pos.rep.logic.sessions.ped;


import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
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
    
    public  List<PedModalidad> obtieneModalidadPorEstructura(OrgEstructura orgEstructura){

        Query q = getEntityManager().createNativeQuery(" SELECT distinct mod.mod_codigo,mod.mod_descripcion " +
                    " FROM ped.ped_modalidad mod, " +
                    "     ped.ped_mod_pro_edu mpe, " +
                    "     ped.ped_proyecto_educacion  pre, " +
                    "     ped.ped_des_est_pro_edu     dep, " +
                    "     org.org_descripcion_estructura dpos, " +
                    "     org.org_estructura             pos " +
                    " WHERE mod.mod_codigo = mpe.mod_codigo " +
                    " and   mod.aud_eliminado = 'N' " +
                    " and   pre.pre_numero = mpe.pre_numero " +
                    " and   dep.pre_numero = pre.pre_numero " +
                    " and   dpos.dee_codigo = dep.dee_codigo " +
                    " and   pos.dee_codigo  = dpos.dee_codigo " +                    
                    " and   pos.est_codigo IN (SELECT e.est_codigo  " +
                    "                         FROM   org.org_estructura e  " +
                    "                         WHERE  e.est_nivel  = 4 " +
                    "                         START WITH e.est_codigo = ?1 " +
                    "                         CONNECT BY PRIOR e.est_codigo = e.est_codigo_padre)  " +
                    " ORDER BY 1 ", PedModalidad.class)
                .setParameter(1, orgEstructura.getEstCodigo());

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
     public  List<PedModalidad> obtieneModalidad(){

        Query q = getEntityManager().createNativeQuery(" SELECT  mod.mod_codigo,mod.mod_descripcion  " +
                                                       " FROM ped.ped_modalidad mod " +
                                                       " WHERE mod.aud_eliminado = 'N' " +
                                                       " AND   mod.mod_codigo != 5 " +                    
                                                       " ORDER BY 1 ", PedModalidad.class);               

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }
    
    
    
}
