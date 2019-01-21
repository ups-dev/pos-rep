package ec.edu.ups.pos.rep.view.controllers;

import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.data.entities.ofe.OfeGrupo;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.pos.rep.view.controller.ins.InsAlumnoController;
import ec.edu.ups.pos.rep.view.controller.rep.RepReportesSistemaController;
import ec.edu.ups.org.common.data.entities.OrgPeriodoLectivo;
import ec.edu.ups.ped.common.data.entities.PedMalla;
import ec.edu.ups.ped.common.data.entities.PedModalidad;
import ec.edu.ups.util.jasper.ReportParamBuilder;
import ec.edu.ups.util.jasper.ReportType;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import net.sf.jasperreports.engine.JRParameter;
import org.omnifaces.util.Faces;


/**
 *
 * @author ups
 */
@Named(value = "posRepGeneralController")
@ViewScoped
public class PosRepGeneralController implements Serializable{
            
    @Inject
    PosReporteController evaReporteController;
         
    @Inject
    InsAlumnoController insAlumnoController;
    
    @Inject
    RepReportesSistemaController repReportesSistemaController;
    @Inject
    PosRepResultadoController posRepResultadoController;
    
    
    /**
     * Generar reporte general.
     * @param formato  Extensión del archivo a obtener ej: "pdf" , "xlsx".
     */
    public void generar_reporte_generico(String formato){ 
        RepReportesSistema repReportesSistema=repReportesSistemaController.getSelected();        
        if(repReportesSistema!=null){   
            String nombre="";//"repReportesSistema.getResArchivo();";
            if(formato.equals("pdf"))
            {
                nombre = repReportesSistema.getResArchivo();
            }
            else if(formato.equals("xlsx"))
            {
                nombre = repReportesSistema.getResArchivoExcel();
            }
        
            //Definición de nombre de: reporte y archivo
            String nombreReporte = "/WEB-INF/reportes/posRep_generico/"+nombre;        
            String nombreArchivo = repReportesSistema.getResReporte();    
            
            System.out.println("nombreArchivo   "+nombreArchivo);
            
            //Identificar la estructura seleccionada para el reporte
            OrgEstructura orgEstructura = evaReporteController.identificarEstructura();
            Integer codigoEstructura=Integer.valueOf(String.valueOf(orgEstructura.getEstCodigo()));
            
            //Parámetro Periodo Inicial
            OrgPeriodoLectivo orgPeriodoInicial=posRepResultadoController.getOrgPeriodoInicial();
            Integer codigoPeriodo=0;
            if(orgPeriodoInicial!=null){
                codigoPeriodo=Integer.valueOf(String.valueOf(orgPeriodoInicial.getPelCodigo()));
            } 
            //Parámetro Periodo Final
            OrgPeriodoLectivo orgPeriodoFinal=posRepResultadoController.getOrgPeriodoFinal();
            Integer codigoPeriodoFin=0;
            if(orgPeriodoFinal!=null){
                codigoPeriodoFin=Integer.valueOf(String.valueOf(orgPeriodoFinal.getPelCodigo()));
            }            
            //Parámetro Modalidad
        /*    PedModalidad pedModalidad=posRepResultadoController.getPedModalidad();
            String codigoModalidad="%";
            if(pedModalidad!=null){
                codigoModalidad=String.valueOf(String.valueOf(pedModalidad.getModCodigo()));
            }*/
         
        
           //Parámetro Nivel
            Integer pedNivelMalla=posRepResultadoController.getPedNivelMalla();
            String codigoNivel="%";
            if(pedNivelMalla!=null){
                codigoNivel=String.valueOf(String.valueOf(pedNivelMalla));
            }
          
          
            //Parámetro GthPersona
            GthPersona gthPersona=posRepResultadoController.getGthPersona();
            String codigoPersona="%";
            if(gthPersona!=null){
                codigoPersona=String.valueOf(gthPersona.getPerCodigo());
            }
        
            
            //Parámetro Asignatura
            PedMalla pedMalla=posRepResultadoController.getPedMalla();
            String malCodigo="%";
            if(pedMalla!=null){
                malCodigo=String.valueOf(pedMalla.getMalCodigo());
            }
            //Parámetro Grupo
            OfeGrupo ofeGrupo=posRepResultadoController.getOfeGrupo();
            String gruCodigo="%";
            if(ofeGrupo!=null){
                gruCodigo=String.valueOf(ofeGrupo.getGruCodigo());
            }    
            String pagado= posRepResultadoController.getPafPagado();
              
            
            
            System.out.println("codigoEstructura"+codigoEstructura);
            System.out.println("pn_pel_codigo"+codigoPeriodo);
            System.out.println("pv_per_codigo"+codigoPersona);
            System.out.println("pv_mal_codigo"+malCodigo);
            System.out.println("pv_mal_nivel"+codigoNivel);
            System.out.println("pv_gru_codigo"+gruCodigo);
             System.out.println("pv_pee_nivel"+codigoNivel);
               System.out.println("pagado"+pagado);
            
            
            //Definición de Parámetros
            ReportParamBuilder rpb =
                            ReportParamBuilder.create("pv_usuario", Faces.getRemoteUser())
                                            .add(JRParameter.REPORT_LOCALE, new Locale("es","ES"));                                            
            rpb.add("pn_est_codigo", codigoEstructura);            
            rpb.add("pn_pel_codigo", codigoPeriodo);
            rpb.add("pn_pel_codigo_fin", codigoPeriodoFin);
          //  rpb.add("pv_mod_codigo", codigoModalidad);   
            rpb.add("pv_per_codigo", codigoPersona);  
            rpb.add("pv_mal_codigo", malCodigo);
            rpb.add("pv_gru_codigo", gruCodigo);
            rpb.add("pv_mal_nivel", codigoNivel);
            rpb.add("pv_pee_nivel", codigoNivel);
            rpb.add("pv_paf_pagado", pagado);

            //Definición de Formato de Archivo
            switch(formato){
                case "pdf":
                    evaReporteController.generarReporte(ReportType.PDF,".pdf",nombreArchivo,nombreReporte, rpb);
                    break;
                case "xlsx":
                    evaReporteController.generarReporte(ReportType.XLSX,".xlsx",nombreArchivo,nombreReporte, rpb);
                    break;
                default:
                 throw new IllegalArgumentException("No se ha identificado el formato del archivo: " + formato);
            }   
        }
    }           
    
}
