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
        Query q = getEntityManager().createNativeQuery( "   select distinct aluCodigo,  " +
                                                    "       aluCodigo||'-'||decode( tieneMencion,'N',codMencionProyecto,'S',(decode(totalMenciones,1,codMencionProyecto,decode(codMencionEstudiante,null,null,codMencionEstudiante)))) identificador,  " +
                                                    "       sede, campus,  " +
                                                    "       posgrado,  " +
                                                    "       estSede,  " +
                                                    "       estCampus,  " +
                                                    "       estPosgrado,  " +
                                                    "       preCodigo,   " +
                                                    "       modalidad,  " +
                                                    "       periodo,  " +
                                                    "       codPeriodo,  " +
                                                    "       cohorte,  " +
                                                    "       cedula,  " +
                                                    "       estudiante,   " +
                                                    "       totalHoras,     " +
                                                    "       tieneMencion,  " +
                                                    "       NVL(tieneMencionEst,'N') tieneMencionEst,  " +
                                                    "       totalMenciones, " +
                                                    "       decode( tieneMencion,'N',decode(titulo,'OTRO',cde_des_tit_opcional,titulo),'S',(decode(totalMenciones,1,mencionProyecto,decode(mencionEstudiante,null,null,mencionEstudiante)))) titulo " +
                                                    "       from ( SELECT  dse.dee_descripcion        sede,  " +
                                                    "               dcm.dee_descripcion        campus,  " +
                                                    "               dpos.dee_descripcion        posgrado,  " +
                                                    "               pos.est_codigo              estPosgrado,  " +
                                                    "               cam.est_codigo              estCampus,  " +
                                                    "               sed.est_codigo              estSede,  " +
                                                    "               pre.pre_numero              preCodigo, " +
                                                    "               mod.mod_descripcion         modalidad,  " +
                                                    "               pel.pel_descripcion         periodo,  " +
                                                    "               pel.pel_codigo              codPeriodo,  " +
                                                    "               pel.pel_descripcion ||' ('||extract (year from pel.pel_fecha_inicio)||' - '||extract (year from pel.pel_fecha_fin)||') ' cohorte,  " +
                                                    "               inc.alu_codigo              aluCodigo,  " +
                                                    "               cli.cllc_cdg                cllcCdg ,  " +
                                                    "               cli.cllc_ruc                cedula,  " +
                                                    "               cli.cllc_nmb                estudiante, " +
                                                    "               ( select ppe.ppe_descripcion_numero  " +
                                                    "                 from   ped.ped_par_pro_edu ppe,  " +
                                                    "                        ped.ped_tip_par_tip_pro_edu tpt  " +
                                                    "               where ppe.tpt_codigo = tpt.tpt_codigo  " +
                                                    "               and ppe.pre_numero = mpe.pre_numero  " +
                                                    "               and tpt.tpp_codigo = 117) totalHoras,  " +
                                                    "               ( select ppe.ppe_descripcion_texto  " +
                                                    "               from ped.ped_par_pro_edu ppe,  " +
                                                    "                     ped.ped_tip_par_tip_pro_edu tpt  " +
                                                    "               where ppe.tpt_codigo=tpt.tpt_codigo  " +
                                                    "               and ppe.pre_numero = mpe.pre_numero  " +
                                                    "               and tpt.tpp_codigo = 114) tieneMencion, " +
                                                    "              (select 'S'  " +
                                                    "              from    ped.ped_cde_dep cdd,  " +
                                                    "                      ins.ins_ipa_cdd iic,  " +
                                                    "                      ins.ins_ins_pro_aca ipa  " +
                                                    "               where  cdd.cdd_codigo = iic.cdd_codigo  " +
                                                    "               and    ipa.ipa_codigo = iic.ipa_codigo  " +
                                                    "               and    ipa.ins_codigo = inc.ins_codigo  " +
                                                    "               and    cdd.dep_codigo = dep.dep_codigo  " +
                                                    "                      ) tieneMencionEst,  " +
                                                    "               (select cdd.cdd_codigo  " +
                                                    "              from    ped.ped_cde_dep cdd,  " +
                                                    "                      ins.ins_ipa_cdd iic,  " +
                                                    "                      ins.ins_ins_pro_aca ipa  " +
                                                    "               where  cdd.cdd_codigo = iic.cdd_codigo  " +
                                                    "               and    ipa.ipa_codigo = iic.ipa_codigo  " +
                                                    "               and    ipa.ins_codigo = inc.ins_codigo  " +
                                                    "               and    cdd.dep_codigo = dep.dep_codigo         " +
                                                    "                      ) codMencionEstudiante,          " +
                                                    "              (select cac2.cac_descripcion||', '||'MENCIÓN '||UPPER(cdd.cdd_mencion)  " +
                                                    "              from    ped.ped_cde_dep cdd,  " +
                                                    "                      ins.ins_ipa_cdd iic,  " +
                                                    "                      ins.ins_ins_pro_aca ipa  " +
                                                    "               where  cdd.cdd_codigo = iic.cdd_codigo  " +
                                                    "               and    ipa.ipa_codigo = iic.ipa_codigo  " +
                                                    "               and    ipa.ins_codigo = inc.ins_codigo  " +
                                                    "               and    cdd.dep_codigo = dep.dep_codigo         " +
                                                    "                      ) mencionEstudiante, " +
                                                    "              (select count(cdd1.cdd_mencion)  " +
                                                    "               from ped.ped_cde_dep  cdd1  " +
                                                    "               where cdd1.dep_codigo = dep.dep_codigo  " +
                                                    "               )totalMenciones,  " +
                                                    "               cdd.cdd_codigo codMencionProyecto,  " +
                                                    "               cac2.cac_descripcion titulo,  " +
                                                    "               cac2.cac_descripcion||', '||'MENCIÓN '||UPPER(cdd.cdd_mencion)  mencionProyecto,  " +
                                                    "               cde.cde_des_tit_opcional        " +
                                                    "    FROM  ins.ins_inscripcion                inc, " +
                                                    "          ins.ins_oferta_inscripcion_inicial oii, " +
                                                    "          ins.ins_alumno                     alu, " +
                                                    "          sigac.cliente_local                cli, " +
                                                    "          org.org_descripcion_estructura     dpos,  " +
                                                    "          org.org_estructura                 pos,  " +
                                                    "          org.org_descripcion_estructura     dcm,  " +
                                                    "          org.org_estructura                 cam,   " +
                                                    "          org.org_descripcion_estructura     dse,  " +
                                                    "          org.org_estructura                 sed,  " +
                                                    "          org.org_periodo_lectivo            pel, " +
                                                    "          ins.ins_ins_pro_aca                ipa, " +
                                                    "          ped.ped_mod_pro_edu                mpe, " +
                                                    "          ped.ped_modalidad                  mod, " +
                                                    "          ped.ped_proyecto_educacion         pre, " +
                                                    "          ped.ped_des_est_pro_edu            dep, " +
                                                    "          ped.ped_cam_des_est                cde,  " +
                                                    "          ped.ped_cde_dep                    cdd,  " +
                                                    "          ped.ped_cam_con_tip_tit            ctt,  " +
                                                    "          ped.ped_campo_conocimiento         cac,  " +
                                                    "          ped.ped_campo_conocimiento         cac2,  " +
                                                    "          ped.ped_tipo_titulacion            tit, " +
                                                    "          fac.fac_pago_factura               paf  " +
                                                    "    WHERE inc.oii_codigo         = oii.oii_codigo  " +
                                                    "    AND   alu.alu_codigo         = inc.alu_codigo " +
                                                    "    AND   cli.cllc_cdg           = alu.cllc_cdg " +
                                                    "    AND   oii.est_codigo         = pos.est_codigo " +
                                                    "    AND   pos.dee_codigo         = dpos.dee_codigo  " +
                                                    "    and   pos.est_codigo_padre   = cam.est_codigo  " +
                                                    "    and   cam.dee_codigo         = dcm.dee_codigo  " +
                                                    "    and   cam.est_codigo_padre   = sed.est_codigo  " +
                                                    "    and   sed.dee_codigo         = dse.dee_codigo " +
                                                    "    AND   oii.pel_codigo         = pel.pel_codigo " +
                                                    "    AND   inc.ins_codigo         = ipa.ins_codigo " +
                                                    "    AND   ipa.mpe_codigo         = mpe.mpe_codigo " +
                                                    "    AND   mod.mod_codigo         = mpe.mod_codigo " +
                                                    "    AND   pre.pre_numero         = mpe.pre_numero " +
                                                    "    AND   pre.pre_numero         = dep.pre_numero " +
                                                    "    AND   dep.dee_codigo         = dpos.dee_codigo " +
                                                    "    AND   dep.dep_codigo         = cdd.dep_codigo  " +
                                                    "    AND   cde.cde_codigo         = cdd.cde_codigo  " +
                                                    "    AND   ctt.cct_codigo         = cde.cct_codigo  " +
                                                    "    AND   cac.cac_codigo         = ctt.cac_codigo  " +
                                                    "    AND   cac.cac_codigo_padre   = cac2.cac_codigo  " +
                                                    "    AND   tit.tit_codigo         = ctt.tit_codigo  " +
                                                    "    AND   tit.ned_codigo         = 2     " +
                                                    "    AND   inc.aud_eliminado      = 'N' " +
                                                    "    AND   inc.ins_anulado        = 'N' " +
                                                    "    AND   inc.ins_vigencia       = 'S'              " +
                                                    "    AND   inc.ins_codigo         = paf.ins_codigo   " +
                                                    "    AND   paf.paf_pagado         = 'S' " +
                                                    "    AND   paf.tip_codigo         = 8 " +
                                                    "    AND   inc.alu_codigo         = ?1  " +
                                                    "  )order by  estsede,estcampus,estposgrado " , PosgradoAlumnoWrapper.class) 
                                                                  .setParameter(1, aluCodigo); 

        (new CacheStoreModeParam(CacheStoreMode.REFRESH)).processParam(q);
        return q.getResultList();
    }           
}
