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
    
     //Obtiene el Posgrado del alumno con sus menciones
    public List<PosgradoAlumnoWrapper> listaPosgrados(Long aluCodigo) {
        
        //System.out.println("aluCodigoo: "+aluCodigo);
        Query q = getEntityManager().createNativeQuery( " select distinct aluCodigo, " +
                                                        "       aluCodigo||'-'||decode( tieneMencion,'N',codMencionProyecto,'S',(decode(totalMenciones,1,codMencionProyecto,decode(codMencionEstudiante,null,null,codMencionEstudiante)))) identificador, " +
                                                        "       sede, campus, " +
                                                        "       posgrado, " +
                                                        "       estSede, " +
                                                        "       estCampus, " +
                                                        "       estPosgrado, " +
                                                        "       modalidad, " +
                                                        "       periodo, " +
                                                        "       codPeriodo, " +
                                                        "       cohorte, " +
                                                        "       cedula, " +
                                                        "       estudiante,  " +
                                                        "       totalHoras,    " +
                                                        "       tieneMencion, " +
                                                        "       NVL(tieneMencionEst,'N') tieneMencionEst, " +
                                                        "       totalMenciones, " +
                                                        "       decode( tieneMencion,'N',titulo,'S',(decode(totalMenciones,1,mencionProyecto,decode(mencionEstudiante,null,null,mencionEstudiante)))) titulo" +
                                                        " from (select distinct dse.dee_descripcion        sede, " +
                                                        "        dcm.dee_descripcion        campus, " +
                                                        "        dpos.dee_descripcion        posgrado, " +
                                                        "        pos.est_codigo              estPosgrado, " +
                                                        "        cam.est_codigo              estCampus, " +
                                                        "        sed.est_codigo              estSede, " +
                                                        "        mod.mod_descripcion         modalidad, " +
                                                        "        pel.pel_descripcion         periodo, " +
                                                        "        pel.pel_codigo              codPeriodo, " +
                                                        "        pel.pel_descripcion ||' ('||extract (year from pel.pel_fecha_inicio)||' - '||extract (year from pel.pel_fecha_fin)||') ' cohorte, " +
                                                        "        inc.alu_codigo              aluCodigo, " +
                                                        "        cli.cllc_cdg                cllcCdg , " +
                                                        "        cli.cllc_ruc                cedula, " +
                                                        "        cli.cllc_nmb                estudiante, " +
                                                        "        mta.mat_observaciones       observacionesMatricula, " +
                                                        "        ( select ppe.PPE_DESCRIPCION_NUMERO " +
                                                        "          from PED.PED_PAR_PRO_EDU ppe, " +
                                                        "               PED.PED_TIP_PAR_TIP_PRO_EDU tpt " +
                                                        "          where ppe.TPT_CODIGO=tpt.TPT_CODIGO " +
                                                        "          and ppe.PRE_NUMERO = pre.pre_numero " +
                                                        "          and tpt.TPP_CODIGO = 117) totalHoras, " +
                                                        "          ( select ppe.PPE_DESCRIPCION_TEXTO " +
                                                        "          from PED.PED_PAR_PRO_EDU ppe, " +
                                                        "               PED.PED_TIP_PAR_TIP_PRO_EDU tpt " +
                                                        "          where ppe.TPT_CODIGO=tpt.TPT_CODIGO " +
                                                        "          and ppe.PRE_NUMERO = pre.pre_numero " +
                                                        "          and tpt.TPP_CODIGO = 114) tieneMencion, " +
                                                        "         (select 'S' " +
                                                        "          from    ped.ped_cde_dep cdd, " +
                                                        "                  ins.ins_ipa_cdd iic, " +
                                                        "                  ins.ins_ins_pro_aca ipa " +
                                                        "           where  cdd.cdd_codigo = iic.cdd_codigo " +
                                                        "           and    ipa.ipa_codigo = iic.ipa_codigo " +
                                                        "           and    ipa.ins_codigo = inc.ins_codigo " +
                                                        "           and    cdd.dep_codigo = dep.dep_codigo " +
                                                        "                  ) tieneMencionEst, " +
                                                        "           (select cdd.cdd_codigo " +
                                                        "          from    ped.ped_cde_dep cdd, " +
                                                        "                  ins.ins_ipa_cdd iic, " +
                                                        "                  ins.ins_ins_pro_aca ipa " +
                                                        "           where  cdd.cdd_codigo = iic.cdd_codigo " +
                                                        "           and    ipa.ipa_codigo = iic.ipa_codigo " +
                                                        "           and    ipa.ins_codigo = inc.ins_codigo " +
                                                        "           and    cdd.dep_codigo = dep.dep_codigo        " +
                                                        "                  ) codMencionEstudiante,         " +
                                                        "          (select cac2.cac_descripcion||', '||'MENCIÓN '||cdd.cdd_mencion " +
                                                        "          from    ped.ped_cde_dep cdd, " +
                                                        "                  ins.ins_ipa_cdd iic, " +
                                                        "                  ins.ins_ins_pro_aca ipa " +
                                                        "           where  cdd.cdd_codigo = iic.cdd_codigo " +
                                                        "           and    ipa.ipa_codigo = iic.ipa_codigo " +
                                                        "           and    ipa.ins_codigo = inc.ins_codigo " +
                                                        "           and    cdd.dep_codigo = dep.dep_codigo        " +
                                                        "                  ) mencionEstudiante, " +
                                                        "           (select count(cdd1.cdd_mencion) " +
                                                        "           from ped.ped_cde_dep  cdd1 " +
                                                        "           where cdd1.dep_codigo = dep.dep_codigo " +
                                                        "           )totalMenciones, " +
                                                        "           cdd.cdd_codigo codMencionProyecto, " +
                                                        "           cac2.cac_descripcion titulo, " +
                                                        "           cac2.cac_descripcion||', '||'MENCIÓN '||cdd.cdd_mencion  mencionProyecto " +
                                                        "    from mat.mat_matricula mta, " +
                                                        "     fac.fac_pago_factura paf, " +
                                                        "     ins.ins_inscripcion inc, " +
                                                        "     sigac.cliente_local         cli, " +
                                                        "     ped.ped_proyecto_educacion  pre, " +
                                                        "     ped.ped_des_est_pro_edu     dep, " +
                                                        "     ped.ped_mod_pro_edu         mpe, " +
                                                        "     ped.ped_est_mod_pro_edu     emp, " +
                                                        "     ped.ped_modalidad           mod, " +
                                                        "     org.org_descripcion_estructura dpos, " +
                                                        "     org.org_estructura             pos, " +
                                                        "     org.org_descripcion_estructura dcm, " +
                                                        "     org.org_estructura             cam,  " +
                                                        "     org.org_descripcion_estructura dse, " +
                                                        "     org.org_estructura             sed, " +
                                                        "     org.org_periodo_estructura     pee, " +
                                                        "     org.org_periodo_lectivo        pel, " +
                                                        "     ped.ped_cam_des_est            cde, " +
                                                        "     ped.ped_cde_dep                cdd, " +
                                                        "     ped.ped_cam_con_tip_tit        ctt, " +
                                                        "     ped.ped_campo_conocimiento     cac, " +
                                                        "     ped.ped_campo_conocimiento     cac2, " +
                                                        "     ped.ped_tipo_titulacion        tit " +
                                                        " where mta.mat_codigo = paf.ins_codigo " +
                                                        " and   mta.ins_codigo = inc.ins_codigo " +
                                                        " and   mta.cllc_cdg   = cli.cllc_cdg " +
                                                        " AND   mta.mat_tipo_proceso = 'M' " +
                                                        " and   mta.mat_anulado      = 'N' " +
                                                        " and   mta.aud_eliminado    = 'N' " +
                                                        " AND   paf.tip_codigo  = 4 " +
                                                        " and   paf.paf_pagado  = 'S' " +
                                                        " and   pre.pre_numero    = dep.pre_numero " +
                                                        " and   dep.dep_codigo    = mta.dep_codigo " +
                                                        " and   pre.pre_numero    = mpe.pre_numero " +
                                                        " and   mod.mod_codigo    = mpe.mod_codigo " +
                                                        " and   mpe.mpe_codigo    = emp.mpe_codigo " +
                                                        " and   dpos.dee_codigo   = dep.dee_codigo " +
                                                        " and   pos.dee_codigo    = dpos.dee_codigo " +
                                                        " and   pos.est_codigo_padre = cam.est_codigo " +
                                                        " and   cam.dee_codigo       = dcm.dee_codigo " +
                                                        " and   cam.est_codigo_padre = sed.est_codigo " +
                                                        " and   sed.dee_codigo       = dse.dee_codigo " +
                                                        " and   pos.est_codigo_padre = emp.est_codigo " +
                                                        " and   emp.emp_codigo       = mta.emp_codigo " +
                                                        " and   mta.pee_codigo       = pee.pee_codigo " +
                                                        " and   pee.pel_codigo       = pel.pel_codigo " +
                                                        " and   dep.dep_codigo  = cdd.dep_codigo " +
                                                        " and   cde.cde_codigo  = cdd.cde_codigo " +
                                                        " and   ctt.cct_codigo  = cde.cct_codigo " +
                                                        " and   cac.cac_codigo  = ctt.cac_codigo " +
                                                        " and   cac.cac_codigo_padre = cac2.cac_codigo " +
                                                        " and   tit.tit_codigo       = ctt.tit_codigo " +
                                                        " and   tit.ned_codigo       = 2 " +                                                      
                                                        " and  inc.alu_codigo  = ?1 " +
                                                        " ) p " +
                                                        " ORDER BY sede, campus, posgrado " , PosgradoAlumnoWrapper.class) 
                                                                  .setParameter(1, aluCodigo); 

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }        
    
  
//   //Obtiene el Posgrado del alumno con sus menciones
//    public List<PosgradoAlumnoWrapper> listaPosgrados(Long aluCodigo) {
//        
//     //System.out.println("aluCodigoo: "+aluCodigo);
//     Query q = getEntityManager().createNativeQuery( " SELECT  distinct alu.alu_codigo      aluCodigo, " + 
//                                                    "        alu.alu_codigo||'-'||cdd.cdd_codigo      identificador, " +
//                                                    "        dsed.dee_descripcion        sede, " +
//                                                    "        dcam.dee_descripcion        campus, " +
//                                                    "        dpos.dee_descripcion        posgrado, " +
//                                                    "        sed.est_codigo              estSede,  " +
//                                                    "        cam.est_codigo              estCampus, " +
//                                                    "        pos.est_codigo              estPosgrado, " +
//                                                    "        mod.mod_descripcion         modalidad, " +
//                                                    "        pel.pel_descripcion ||' ('||extract (year from pel.pel_fecha_inicio)||' - '||extract (year from pel.pel_fecha_fin)||') '   periodo, " +
//                                                    "        pel.pel_codigo              codPeriodo, " +
//                                                    "        cac.cac_descripcion||' '||cac2.cac_descripcion ||decode(ppe.ppe_descripcion_texto,'S',(' - '||cdd.cdd_mencion),null) titulo " +
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
//                                                    "      ins.ins_alumno              alu, " +
//                                                    "      ped.ped_cde_dep             cdd, " +
//                                                    "      ped.ped_cam_des_est         cde, " +
//                                                    "      ped.ped_cam_con_tip_tit     cct, " +
//                                                    "      ped.ped_campo_conocimiento  cac, " +
//                                                    "      ped.ped_campo_conocimiento  cac2, " +
//                                                    "      ped.ped_par_pro_edu         ppe, " +
//                                                    "      ped.ped_tip_par_tip_pro_edu tpt, " +
//                                                    "      ped.ped_tipo_proyecto_educacion tpe  " +
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
//                                                    " AND     dep.dep_codigo  = cdd.dep_codigo " +
//                                                    " AND     cde.cde_codigo  = cdd.cde_codigo " +
//                                                    " AND     cct.cct_codigo  = cde.cct_codigo " +
//                                                    " AND     cac.cac_codigo  = cct.cac_codigo " +
//                                                    " AND     cac.cac_codigo_padre = cac2.cac_codigo " +
//                                                    " AND     pre.pre_numero       = ppe.pre_numero " +
//                                                    " AND     tpt.tpt_codigo   = ppe.tpt_codigo " +
//                                                    " AND     tpt.tpe_codigo   = tpe.tpe_codigo " +
//                                                    " AND     tpe.tpe_codigo   = pre.tpe_codigo " +
//                                                    " AND     tpt.tpp_codigo   = 114 " +
//                                                    " AND     alu.alu_codigo  = ?1 ", PosgradoAlumnoWrapper.class)   
//          .setParameter(1, aluCodigo); 
//
//        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
//        return q.getResultList();
//    }        
//    
}
