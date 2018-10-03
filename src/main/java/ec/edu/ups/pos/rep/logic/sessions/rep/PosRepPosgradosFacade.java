/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.rep;

import ec.edu.ups.pos.rep.data.entities.wrapper.PosgradoAlumnoWrapper;
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
public class PosRepPosgradosFacade extends AbstractFacade<PosgradoAlumnoWrapper> {
    
    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PosRepPosgradosFacade() {
        super(PosgradoAlumnoWrapper.class);
    }
  
   //Obtiene la lista de docentes de GthPersona y GthContrato
    public List<PosgradoAlumnoWrapper> listaPosgrados(Long aluCodigo) {
        
        System.out.println("aluCodigoo: "+aluCodigo);

//    Query q = getEntityManager().createNativeQuery( " SELECT  alu.alu_codigo             aluCodigo, " + 
//                                                    "        dsed.dee_descripcion        sede, " +
//                                                    "        dcam.dee_descripcion        campus, " +
//                                                    "        dpos.dee_descripcion        posgrado, " +
//                                                    "        mod.mod_descripcion         modalidad, " +
//                                                    "        pel.pel_descripcion         periodo, " +
//                                                    "        pel.pel_codigo              codPeriodo" +
//                                                    " FROM  mat.mat_matricula           mat, " +
//                                                    "      fac.fac_pago_factura        paf, " +
//                                                    "      org.org_periodo_estructura  pee, " +
//                                                    "      org.org_periodo_lectivo     pel, " +
//                                                    "      ped.ped_proyecto_educacion  pre, " +
//                                                    "      ped.ped_des_est_pro_edu     dep, " +
//                                                    "      ped.ped_mod_pro_edu         mpe, " +
//                                                    "      ped.ped_modalidad           mod, " +
//                                                    "      org.org_descripcion_estructura dpos, " +
//                                                    "      org.org_descripcion_estructura dcam, " +
//                                                    "      org.org_descripcion_estructura dsed, " +
//                                                    "      org.org_estructura          pos, " +
//                                                    "      org.org_estructura          cam, " +
//                                                    "      org.org_estructura          sed, " +
//                                                    "      ins.ins_alumno              alu " +
//                                                    " WHERE mat.mat_codigo  = paf.ins_codigo " +
//                                                    " AND   mat.pee_codigo  = pee.pee_codigo " +
//                                                    " AND   pee.pel_codigo  = pel.pel_codigo " +
//                                                    " AND     mat.mat_tipo_proceso = 'M' " +
//                                                    " AND     pre.tpe_codigo  = 8 " +
//                                                    " AND     paf.tip_codigo  = 4 " +
//                                                    " AND     mat.aud_eliminado = 'N' " +
//                                                    " AND     paf.paf_pagado    = 'S' " +
//                                                    " AND     pre.pre_numero    = dep.pre_numero " +
//                                                    " AND     dep.dep_codigo    = mat.dep_codigo " +
//                                                    " AND     pre.pre_numero  = mpe.pre_numero " +
//                                                    " AND     mod.mod_codigo  = mpe.mod_codigo " +
//                                                    " AND     dep.dee_codigo  = dpos.dee_codigo " +
//                                                    " AND     pee.est_codigo  = pos.est_codigo " +
//                                                    " AND     pos.dee_codigo  = dpos.dee_codigo " +
//                                                    " AND     cam.est_codigo  = pos.est_codigo_padre " +
//                                                    " AND     cam.dee_codigo  = dcam.dee_codigo " +
//                                                    " AND     sed.est_codigo  = cam.est_codigo_padre " +
//                                                    " AND     sed.dee_codigo  = dsed.dee_codigo " +
//                                                    " AND     alu.cllc_cdg    = mat.cllc_cdg " +
//                                                    " AND     alu.alu_codigo  = ?1 ", PosgradoAlumnoWrapper.class)   
//          .setParameter(1, aluCodigo); 

 Query q = getEntityManager().createNativeQuery( " SELECT  distinct alu.alu_codigo      aluCodigo, " + 
                                                    "        alu.alu_codigo||'-'||cdd.cdd_codigo      identificador, " +
                                                    "        dsed.dee_descripcion        sede, " +
                                                    "        dcam.dee_descripcion        campus, " +
                                                    "        dpos.dee_descripcion        posgrado, " +
                                                    "        cam.est_codigo              est_campus, " +
                                                    "        pos.est_codigo              est_posgrado, " +
                                                    "        mod.mod_descripcion         modalidad, " +
                                                    "        pel.pel_descripcion ||' ('||extract (year from pel.pel_fecha_inicio)||' - '||extract (year from pel.pel_fecha_fin)||') '   periodo, " +
                                                    "        pel.pel_codigo              codPeriodo, " +
                                                    "        cac.cac_descripcion||' '||cac2.cac_descripcion ||decode(ppe.ppe_descripcion_texto,'S',(' - '||cdd.cdd_mencion),null) titulo " +
                                                    " FROM  mat.mat_matricula           mat, " +
                                                    "      fac.fac_pago_factura        paf, " +
                                                    "      org.org_periodo_estructura  pee, " +
                                                    "      org.org_periodo_lectivo     pel, " +
                                                    "      ped.ped_proyecto_educacion  pre, " +
                                                    "      ped.ped_des_est_pro_edu     dep, " +
                                                    "      ped.ped_mod_pro_edu         mpe, " +
                                                    "      ped.ped_modalidad           mod, " +
                                                    "      org.org_descripcion_estructura dpos, " +
                                                    "      org.org_descripcion_estructura dcam, " +
                                                    "      org.org_descripcion_estructura dsed, " +
                                                    "      org.org_estructura          pos, " +
                                                    "      org.org_estructura          cam, " +
                                                    "      org.org_estructura          sed, " +
                                                    "      ins.ins_alumno              alu, " +
                                                    "      ped.ped_cde_dep             cdd, " +
                                                    "      ped.ped_cam_des_est         cde, " +
                                                    "      ped.ped_cam_con_tip_tit     cct, " +
                                                    "      ped.ped_campo_conocimiento  cac, " +
                                                    "      ped.ped_campo_conocimiento  cac2, " +
                                                    "      ped.ped_par_pro_edu         ppe, " +
                                                    "      ped.ped_tip_par_tip_pro_edu tpt, " +
                                                    "      ped.ped_tipo_proyecto_educacion tpe  " +
                                                    " WHERE mat.mat_codigo  = paf.ins_codigo " +
                                                    " AND   mat.pee_codigo  = pee.pee_codigo " +
                                                    " AND   pee.pel_codigo  = pel.pel_codigo " +
                                                    " AND     mat.mat_tipo_proceso = 'M' " +
                                                    " AND     pre.tpe_codigo  = 8 " +
                                                    " AND     paf.tip_codigo  = 4 " +
                                                    " AND     mat.aud_eliminado = 'N' " +
                                                    " AND     paf.paf_pagado    = 'S' " +
                                                    " AND     pre.pre_numero    = dep.pre_numero " +
                                                    " AND     dep.dep_codigo    = mat.dep_codigo " +
                                                    " AND     pre.pre_numero  = mpe.pre_numero " +
                                                    " AND     mod.mod_codigo  = mpe.mod_codigo " +
                                                    " AND     dep.dee_codigo  = dpos.dee_codigo " +
                                                    " AND     pee.est_codigo  = pos.est_codigo " +
                                                    " AND     pos.dee_codigo  = dpos.dee_codigo " +
                                                    " AND     cam.est_codigo  = pos.est_codigo_padre " +
                                                    " AND     cam.dee_codigo  = dcam.dee_codigo " +
                                                    " AND     sed.est_codigo  = cam.est_codigo_padre " +
                                                    " AND     sed.dee_codigo  = dsed.dee_codigo " +
                                                    " AND     alu.cllc_cdg    = mat.cllc_cdg " +
                                                    " AND     dep.dep_codigo  = cdd.dep_codigo " +
                                                    " AND     cde.cde_codigo  = cdd.cde_codigo " +
                                                    " AND     cct.cct_codigo  = cde.cct_codigo " +
                                                    " AND     cac.cac_codigo  = cct.cac_codigo " +
                                                    " AND     cac.cac_codigo_padre = cac2.cac_codigo " +
                                                    " AND     pre.pre_numero       = ppe.pre_numero " +
                                                    " AND     tpt.tpt_codigo   = ppe.tpt_codigo " +
                                                    " AND     tpt.tpe_codigo   = tpe.tpe_codigo " +
                                                    " AND     tpe.tpe_codigo   = pre.tpe_codigo " +
                                                    " AND     tpt.tpp_codigo   = 114 " +
                                                    " AND     alu.alu_codigo  = ?1 ", PosgradoAlumnoWrapper.class)   
          .setParameter(1, aluCodigo); 

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }        
    
}
