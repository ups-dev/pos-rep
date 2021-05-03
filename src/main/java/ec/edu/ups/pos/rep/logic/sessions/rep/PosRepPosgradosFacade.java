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
        
      //  System.out.println("aluCodigoo: "+aluCodigo);
      /*  Query q = getEntityManager().createNativeQuery( "   select distinct aluCodigo,   " +
                                                    "       aluCodigo||'-'||decode( tieneMencion,'N',codMencionProyecto,'S',(decode(totalMenciones,1,codMencionProyecto,decode(codMencionEstudiante,null,null,codMencionEstudiante)))) identificador,   " +
                                                    "       sede, campus, " +
                                                    "       posgrado,   " +
                                                    "       estSede,   " +
                                                    "       estCampus,   " +
                                                    "       estPosgrado,   " +
                                                    "       preCodigo, proyecto,   " +
                                                    "       modalidad,   " +
                                                    "       periodo,   " +
                                                    "       codPeriodo,   " +
                                                    "       cohorte,   " +
                                                    "       cedula,   " +
                                                    "       estudiante,    " +
                                                    "       tieneMencion,   " +
                                                    "       NVL(tieneMencionEst,'N') tieneMencionEst,   " +
                                                    "       totalMenciones,  " +
                                                    "       decode( tieneMencion,'N',decode(titulo,'OTRO',cde_des_tit_opcional,titulo),'S',(decode(totalMenciones,1,mencionProyecto,decode(mencionEstudiante,null,null,mencionEstudiante)))) titulo,  " +
                                                    "       preCodigo,  " +
                                                    "       codMencionEstudiante," +
                                                    "       vigencia,  " +
                                                    "       NVL(actaGrado,'N') actaGrado " +
                                                    "       from (" +
                                                    "                select " +
                                                    "                     dse.dee_descripcion        sede,   " +
                                                    "                     dcm.dee_descripcion        campus,   " +
                                                    "                     dpos.dee_descripcion        posgrado,   " +
                                                    "                     pos.est_codigo              estPosgrado,   " +
                                                    "                     cam.est_codigo              estCampus,   " +
                                                    "                     sed.est_codigo              estSede,   " +
                                                    "                     pre.pre_numero              preCodigo, " +
                                                    "                     pre.pre_titulo_proyecto     proyecto, " +
                                                    "                     mod.mod_descripcion         modalidad, " +
                                                    "                     pel.pel_descripcion         periodo, pel.pel_fecha_inicio,  pel.pel_fecha_fin, " +
                                                    "                     pel.pel_codigo              codPeriodo,   " +
                                                    "                     pel.pel_descripcion ||' ('||extract (year from (select min(pee.pee_fecha_inicial_cohorte) from org.org_periodo_estructura pee " +
                                                    "                     where pee.pel_codigo = pel.pel_codigo " +
                                                    "                     and   pee.est_codigo = pos.est_codigo))||' - '||extract (year from (select min(pee.pee_fecha_final_cohorte) from org.org_periodo_estructura pee " +
                                                    "                     where pee.pel_codigo = pel.pel_codigo and   pee.est_codigo = pos.est_codigo))||') ' cohorte, " +
                                                    "                     inc.alu_codigo              aluCodigo,   " +
                                                    "                     cli.cllc_cdg                cllcCdg ,   " +
                                                    "                     cli.cllc_ruc                cedula,   " +
                                                    "                     cli.cllc_nmb                estudiante, " +
                                                    "                     pre.pel_codigo,  " +
                                                    "                     DECODE(ipa.ipa_vigente,'S','SI','NO') vigencia, " +
                                                    "                         (select ppe.ppe_descripcion_texto   " +
                                                    "                           from ped.ped_par_pro_edu ppe,   " +
                                                    "                                 ped.ped_tip_par_tip_pro_edu tpt   " +
                                                    "                           where ppe.tpt_codigo=tpt.tpt_codigo   " +
                                                    "                           and ppe.pre_numero = mpe.pre_numero   " +
                                                    "                           and tpt.tpp_codigo = 114) tieneMencion,  " +
                                                    "                          (select 'S'   " +
                                                    "                          from    ped.ped_cde_dep cdd,   " +
                                                    "                                  ins.ins_ipa_cdd iic,   " +
                                                    "                                  ins.ins_ins_pro_aca ipa   " +
                                                    "                           where  cdd.cdd_codigo = iic.cdd_codigo   " +
                                                    "                           and    ipa.ipa_codigo = iic.ipa_codigo   " +
                                                    "                           and    ipa.ins_codigo = inc.ins_codigo   " +
                                                    "                           and    cdd.dep_codigo = dep.dep_codigo   " +
                                                    "                                  ) tieneMencionEst,   " +
                                                    "                           (select cdd.cdd_codigo   " +
                                                    "                          from    ped.ped_cde_dep cdd,   " +
                                                    "                                  ins.ins_ipa_cdd iic,   " +
                                                    "                                  ins.ins_ins_pro_aca ipa   " +
                                                    "                           where  cdd.cdd_codigo = iic.cdd_codigo   " +
                                                    "                           and    ipa.ipa_codigo = iic.ipa_codigo   " +
                                                    "                           and    ipa.ins_codigo = inc.ins_codigo   " +
                                                    "                           and    cdd.dep_codigo = dep.dep_codigo          " +
                                                    "                                  ) codMencionEstudiante,           " +
                                                    "                          (select cac2.cac_descripcion||', '||'MENCIÓN '||UPPER(cdd.cdd_mencion)   " +
                                                    "                          from    ped.ped_cde_dep cdd,   " +
                                                    "                                  ins.ins_ipa_cdd iic,   " +
                                                    "                                  ins.ins_ins_pro_aca ipa   " +
                                                    "                           where  cdd.cdd_codigo = iic.cdd_codigo   " +
                                                    "                           and    ipa.ipa_codigo = iic.ipa_codigo   " +
                                                    "                           and    ipa.ins_codigo = inc.ins_codigo   " +
                                                    "                           and    cdd.dep_codigo = dep.dep_codigo          " +
                                                    "                                  ) mencionEstudiante,  " +
                                                    "                          (select count(cdd1.cdd_mencion)   " +
                                                    "                           from ped.ped_cde_dep  cdd1   " +
                                                    "                           where cdd1.dep_codigo = dep.dep_codigo   " +
                                                    "                           )totalMenciones,   " +
                                                    "                           cdd.cdd_codigo codMencionProyecto,   " +
                                                    "                           cac2.cac_descripcion titulo,   " +
                                                    "                           cac2.cac_descripcion||', '||'MENCIÓN '||UPPER(cdd.cdd_mencion)  mencionProyecto,  " +
                                                    "                           cde.cde_des_tit_opcional   ,dep.dep_codigo,inc.ins_codigo,      " +
                                                    "                           (select 'S'     " +
                                                    "                           from  stg.stg_acta_grado  acg, " +
                                                    "                                   stg.stg_trabajo_graduacion trg, " +
                                                    "                                   ins.ins_ins_pro_aca        ipa2 " +
                                                    "                             where trg.tdg_codigo = acg.tdg_codigo " +
                                                    "                             and ipa2.ipa_codigo   = trg.ipa_codigo " +
                                                    "                             and ipa2.ipa_codigo   = ipa.ipa_codigo " +
                                                    "                             and acg.aud_eliminado = 'N')  actaGrado " + 
                                                    "              from ins.ins_ins_pro_aca ipa," +
                                                    "                   ped.ped_mod_pro_edu mpe," +
                                                    "                   ped.ped_proyecto_educacion pre, " +
                                                    "                   ins.ins_inscripcion        inc, " +
                                                    "                   ins.ins_alumno             alu, " +
                                                    "                   sigac.cliente_local        cli, " +
                                                    "                   ins.ins_oferta_inscripcion_inicial oii, " +
                                                    "                   org.org_descripcion_estructura     dpos,   " +
                                                    "                   org.org_estructura                 pos,   " +
                                                    "                   org.org_descripcion_estructura     dcm,   " +
                                                    "                   org.org_estructura                 cam,    " +
                                                    "                   org.org_descripcion_estructura     dse,   " +
                                                    "                   org.org_estructura                 sed, " +
                                                    "                   ped.ped_modalidad                  mod, " +
                                                    "                   org.org_periodo_lectivo            pel, " +
                                                    "                   ped.ped_des_est_pro_edu            dep, " +
                                                    "                   ped.ped_cam_des_est                cde, " +
                                                    "                   ped.ped_cde_dep                    cdd, " +
                                                    "                   ped.ped_cam_con_tip_tit            ctt, " +
                                                    "                   ped.ped_campo_conocimiento         cac, " +
                                                    "                   ped.ped_campo_conocimiento         cac2, " +
                                                    "                   ped.ped_tipo_titulacion            tit, " +
                                                    "                   fac.fac_pago_factura               paf " +
                                                    "                   " +
                                                    "              where mpe.mpe_codigo = ipa.mpe_codigo " +
                                                    "              and   pre.pre_numero = mpe.pre_numero " +
                                                    "              and   ipa.ins_codigo = inc.ins_codigo " +
                                                    "              and   alu.alu_codigo = inc.alu_codigo  " +
                                                    "              and   cli.cllc_cdg   = alu.cllc_cdg " +
                                                    "              and   oii.oii_codigo = inc.oii_codigo " +
                                                    "              and   oii.est_codigo         = pos.est_codigo  " +
                                                    "              and   pos.dee_codigo         = dpos.dee_codigo   " +
                                                    "              and   pos.est_codigo_padre   = cam.est_codigo   " +
                                                    "              and   cam.dee_codigo         = dcm.dee_codigo   " +
                                                    "              and   cam.est_codigo_padre   = sed.est_codigo   " +
                                                    "              and   sed.dee_codigo         = dse.dee_codigo " +
                                                    "              and   mod.mod_codigo         = mpe.mod_codigo    " +
                                                    "              and   ipa.pel_codigo_inicio_proyecto(+) = pel.pel_codigo        " +
                                                    "              and   dep.pre_numero         = pre.pre_numero" +
                                                    "              and   dep.dep_codigo         = cdd.dep_codigo   " +
                                                    "              and   cde.cde_codigo         = cdd.cde_codigo   " +
                                                    "              and   ctt.cct_codigo         = cde.cct_codigo   " +
                                                    "              and   cac.cac_codigo         = ctt.cac_codigo   " +
                                                    "              and   cac.cac_codigo_padre   = cac2.cac_codigo  " +
                                                    "              and   tit.tit_codigo         = ctt.tit_codigo   " +
                                                    "              and   tit.ned_codigo         = 2     " +
                                                    "              and   inc.aud_eliminado      = 'N'  " +
                                                    "              and   inc.ins_anulado        = 'N'  " +
                                                    "              and   ipa.aud_eliminado      = 'N' " +
                                                    "              and   inc.ins_codigo         = paf.ins_codigo    " +
                                                    "              and   paf.paf_pagado         = 'S'  " +
                                                    "              and   paf.tip_codigo         = 8  " +                                                       
                                                    "              and   inc.alu_codigo         = ?1  " +
                                                    "  )order by  estsede,estcampus,estposgrado,codperiodo " , PosgradoAlumnoWrapper.class) 
                                                                  .setParameter(1, aluCodigo); */
      
          Query q = getEntityManager().createNativeQuery( "   select distinct aluCodigo,   " +
                                                        "      aluCodigo||'-'||decode( tieneMencion,'N',codMencionProyecto,'S',(decode(totalMenciones,1,codMencionProyecto,decode(codMencionEstudiante,null,null,codMencionEstudiante)))) identificador,    " +
                                                        "      sede, campus,  " +
                                                        "      posgrado,    " +
                                                        "      estSede,    " +
                                                        "      estCampus,    " +
                                                        "      estPosgrado,    " +
                                                        "      preCodigo, proyecto,    " +
                                                        "      modalidad,    " +
                                                        "      periodo,    " +
                                                        "      codPeriodo,    " +
                                                        "      cohorte,    " +
                                                        "      cedula,    " +
                                                        "      estudiante,     " +
                                                        "      tieneMencion,    " +
                                                        "      NVL(tieneMencionEst,'N') tieneMencionEst,    " +
                                                        "      totalMenciones,   " +
                                                        "      decode( tieneMencion,'N',decode(titulo,'OTRO',cde_des_tit_opcional,titulo),'S',(decode(totalMenciones,1,mencionProyecto,decode(mencionEstudiante,null,null,mencionEstudiante)))) titulo,   " +
                                                        "      preCodigo,   " +
                                                        "      codMencionEstudiante, " +
                                                        "      vigencia,   " +
                                                        "      NVL(actaGrado,'N') actaGrado  " +
                                                        "      from ( " +
                                                        "              select distinct mta.pee_codigo, " +
                                                        "                   dse.dee_descripcion        sede,    " +
                                                        "                   dcm.dee_descripcion        campus,    " +
                                                        "                   dpos.dee_descripcion        posgrado,    " +
                                                        "                   pos.est_codigo              estPosgrado,    " +
                                                        "                   cam.est_codigo              estCampus,    " +
                                                        "                   sed.est_codigo              estSede,    " +
                                                        "                   pre.pre_numero              preCodigo,  " +
                                                        "                   pre.pre_titulo_proyecto     proyecto,  " +
                                                        "                   mod.mod_descripcion         modalidad,  " +
                                                        "                   pel.pel_descripcion         periodo, pel.pel_fecha_inicio,  pel.pel_fecha_fin,  " +
                                                        "                   pel.pel_codigo              codPeriodo,    " +
                                                        "                   pel.pel_descripcion ||' ('||extract (year from (select min(pee.pee_fecha_inicial_cohorte) from org.org_periodo_estructura pee  " +
                                                        "                   where pee.pel_codigo = pel.pel_codigo  " +
                                                        "                   and   pee.est_codigo = pos.est_codigo))||' - '||extract (year from (select min(pee.pee_fecha_final_cohorte) from org.org_periodo_estructura pee  " +
                                                        "                   where pee.pel_codigo = pel.pel_codigo and   pee.est_codigo = pos.est_codigo))||') ' cohorte,  " +
                                                        "                   inc.alu_codigo              aluCodigo,    " +
                                                        "                   cli.cllc_cdg                cllcCdg ,    " +
                                                        "                   cli.cllc_ruc                cedula,    " +
                                                        "                   cli.cllc_nmb                estudiante,  " +
                                                        "                   pre.pel_codigo,   " +
                                                        "                   DECODE(ipa.ipa_vigente,'S','SI','NO') vigencia,  " +
                                                        "                       (select ppe.ppe_descripcion_texto    " +
                                                        "                         from ped.ped_par_pro_edu ppe,    " +
                                                        "                               ped.ped_tip_par_tip_pro_edu tpt    " +
                                                        "                         where ppe.tpt_codigo=tpt.tpt_codigo    " +
                                                        "                         and ppe.pre_numero = mpe.pre_numero    " +
                                                        "                         and tpt.tpp_codigo = 114) tieneMencion,   " +
                                                        "                        (select 'S'    " +
                                                        "                        from    ped.ped_cde_dep cdd,    " +
                                                        "                                ins.ins_ipa_cdd iic,    " +
                                                        "                                ins.ins_ins_pro_aca ipa    " +
                                                        "                         where  cdd.cdd_codigo = iic.cdd_codigo    " +
                                                        "                         and    ipa.ipa_codigo = iic.ipa_codigo    " +
                                                        "                         and    ipa.ins_codigo = inc.ins_codigo    " +
                                                        "                         and    cdd.dep_codigo = dep.dep_codigo    " +
                                                        "                                ) tieneMencionEst,    " +
                                                        "                         (select cdd.cdd_codigo    " +
                                                        "                        from    ped.ped_cde_dep cdd,    " +
                                                        "                                ins.ins_ipa_cdd iic,    " +
                                                        "                                ins.ins_ins_pro_aca ipa    " +
                                                        "                         where  cdd.cdd_codigo = iic.cdd_codigo    " +
                                                        "                         and    ipa.ipa_codigo = iic.ipa_codigo    " +
                                                        "                         and    ipa.ins_codigo = inc.ins_codigo    " +
                                                        "                         and    cdd.dep_codigo = dep.dep_codigo           " +
                                                        "                                ) codMencionEstudiante,            " +
                                                        "                        (select cac2.cac_descripcion||', '||'MENCIÓN '||UPPER(cdd.cdd_mencion)    " +
                                                        "                        from    ped.ped_cde_dep cdd,    " +
                                                        "                                ins.ins_ipa_cdd iic,    " +
                                                        "                                ins.ins_ins_pro_aca ipa    " +
                                                        "                         where  cdd.cdd_codigo = iic.cdd_codigo    " +
                                                        "                         and    ipa.ipa_codigo = iic.ipa_codigo    " +
                                                        "                         and    ipa.ins_codigo = inc.ins_codigo    " +
                                                        "                         and    cdd.dep_codigo = dep.dep_codigo           " +
                                                        "                                ) mencionEstudiante,   " +
                                                        "                        (select count(cdd1.cdd_mencion)    " +
                                                        "                         from ped.ped_cde_dep  cdd1    " +
                                                        "                         where cdd1.dep_codigo = dep.dep_codigo    " +
                                                        "                         )totalMenciones,    " +
                                                        "                         cdd.cdd_codigo codMencionProyecto,    " +
                                                        "                         cac2.cac_descripcion titulo,    " +
                                                        "                         cac2.cac_descripcion||', '||'MENCIÓN '||UPPER(cdd.cdd_mencion)  mencionProyecto,   " +
                                                        "                         cde.cde_des_tit_opcional   ,dep.dep_codigo,inc.ins_codigo,       " +
                                                        "                         (select 'S'      " +
                                                        "                         from  stg.stg_acta_grado  acg,  " +
                                                        "                                 stg.stg_trabajo_graduacion trg,  " +
                                                        "                                 ins.ins_ins_pro_aca        ipa2  " +
                                                        "                           where trg.tdg_codigo = acg.tdg_codigo  " +
                                                        "                           and ipa2.ipa_codigo   = trg.ipa_codigo  " +
                                                        "                           and ipa2.ipa_codigo   = ipa.ipa_codigo  " +
                                                        "                           and acg.aud_eliminado = 'N')  actaGrado   " +
                                                        "            from ins.ins_ins_pro_aca ipa, " +
                                                        "                 ped.ped_mod_pro_edu mpe, " +
                                                        "                 ped.ped_proyecto_educacion pre,  " +
                                                        "                 ins.ins_inscripcion        inc,  " +
                                                        "                 ins.ins_alumno             alu,  " +
                                                        "                 sigac.cliente_local        cli,  " +
                                                        "                 ins.ins_oferta_inscripcion_inicial oii,  " +
                                                        "                 org.org_descripcion_estructura     dpos,    " +
                                                        "                 org.org_estructura                 pos,    " +
                                                        "                 org.org_descripcion_estructura     dcm,    " +
                                                        "                 org.org_estructura                 cam,     " +
                                                        "                 org.org_descripcion_estructura     dse,    " +
                                                        "                 org.org_estructura                 sed,  " +
                                                        "                 ped.ped_modalidad                  mod,  " +
                                                        "                 org.org_periodo_lectivo            pel,  " +
                                                        "                 ped.ped_des_est_pro_edu            dep,  " +
                                                        "                 ped.ped_cam_des_est                cde,  " +
                                                        "                 ped.ped_cde_dep                    cdd,  " +
                                                        "                 ped.ped_cam_con_tip_tit            ctt,  " +
                                                        "                 ped.ped_campo_conocimiento         cac,  " +
                                                        "                 ped.ped_campo_conocimiento         cac2,  " +
                                                        "                 ped.ped_tipo_titulacion            tit,  " +
                                                        "                 fac.fac_pago_factura               paf, " +
                                                        "                 mat.mat_matricula                  mta, " +
                                                        "                 ped.ped_est_mod_pro_edu            emp " +
                                                        "                                                                              " +
                                                        "            where mpe.mpe_codigo = ipa.mpe_codigo  " +
                                                        "            and   pre.pre_numero = mpe.pre_numero  " +
                                                        "            and   ipa.ins_codigo = inc.ins_codigo  " +
                                                        "            and   alu.alu_codigo = inc.alu_codigo   " +
                                                        "            and   cli.cllc_cdg   = alu.cllc_cdg  " +
                                                        "            and   oii.oii_codigo = inc.oii_codigo   " +
                                                        "            and   pos.dee_codigo         = dpos.dee_codigo    " +
                                                        "            and   pos.est_codigo_padre   = cam.est_codigo    " +
                                                        "            and   cam.dee_codigo         = dcm.dee_codigo    " +
                                                        "            and   cam.est_codigo_padre   = sed.est_codigo    " +
                                                        "            and   sed.dee_codigo         = dse.dee_codigo  " +
                                                        "            and   mod.mod_codigo         = mpe.mod_codigo     " +
                                                        "            and   ipa.pel_codigo_inicio_proyecto(+) = pel.pel_codigo         " +
                                                        "            and   dep.pre_numero         = pre.pre_numero " +
                                                        "            and   dep.dep_codigo         = cdd.dep_codigo    " +
                                                        "            and   cde.cde_codigo         = cdd.cde_codigo    " +
                                                        "            and   ctt.cct_codigo         = cde.cct_codigo    " +
                                                        "            and   cac.cac_codigo         = ctt.cac_codigo    " +
                                                        "            and   cac.cac_codigo_padre   = cac2.cac_codigo   " +
                                                        "            and   tit.tit_codigo         = ctt.tit_codigo    " +
                                                        "            and   tit.ned_codigo         = 2      " +
                                                        "            and   inc.aud_eliminado      = 'N'   " +
                                                        "            and   inc.ins_anulado        = 'N'   " +
                                                        "            and   ipa.aud_eliminado      = 'N'  " +
                                                        "            and   inc.ins_codigo         = paf.ins_codigo     " +
                                                        "            and   paf.paf_pagado         = 'S'   " +
                                                        "            and   paf.tip_codigo         = 8                  " +
                                                        "            and   mta.ins_codigo         = inc.ins_codigo " +
                                                        "            and   mta.mat_pagado         = 'S'       " +
                                                        "            and   mta.mat_tipo_proceso   = 'M'       " +
                                                        "            and   mta.aud_eliminado      = 'N'  " +
                                                        "            and   dep.dep_codigo         = mta.dep_codigo " +
                                                        "            and   dep.dee_codigo         = dpos.dee_codigo " +
                                                        "            and   dpos.dee_codigo        = pos.dee_codigo         " +
                                                        "            and   pre.pre_numero         = mpe.pre_numero " +
                                                        "            and   mpe.mpe_codigo         = emp.mpe_codigo " +
                                                        "            and   emp.emp_codigo         = mta.emp_codigo " +
                                                        "            and   emp.est_codigo         = cam.est_codigo  " +
                                                        "            and   (mta.pee_codigo,mta.cllc_cdg )        IN (select max(m.pee_codigo),m.cllc_cdg " +
                                                        "                                                          from mat.mat_matricula m    " +
                                                        "                                                          where m.aud_eliminado = 'N' " +
                                                        "                                                          and   m.mat_pagado = 'S' " +
                                                        "                                                          and   m.mat_tipo_proceso = 'M' " +
                                                        "                                                          group by  m.cllc_cdg " +
                                                        "                                                          )   " +
                                                        "            and   inc.alu_codigo         = ?1 " +
                                                        "  )order by  estsede,estcampus,estposgrado,codperiodo " , PosgradoAlumnoWrapper.class) 
                                                                  .setParameter(1, aluCodigo); 

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }      
    
    
}
