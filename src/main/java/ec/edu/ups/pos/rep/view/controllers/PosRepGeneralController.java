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
import ec.edu.ups.pos.rep.data.entities.rep.RepSecretarioGeneral;
import ec.edu.ups.pos.rep.data.entities.rep.RepTipCerRepSis;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
import ec.edu.ups.pos.rep.data.entities.wrapper.PosgradoAlumnoWrapper;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepTipCerRepSisFacade;
import ec.edu.ups.pos.rep.view.controller.rep.RepEmisionCertificadoController;
import ec.edu.ups.pos.rep.view.controller.rep.RepNumeroCertificadoController;
import ec.edu.ups.pos.rep.view.controller.rep.RepSecretarioGeneralController;
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
    PosReporteController posReporteController;
         
    @Inject
    InsAlumnoController insAlumnoController;
    
    @Inject
    RepReportesSistemaController repReportesSistemaController;
    
    @Inject
    PosRepResultadoController posRepResultadoController;
    
    @Inject
    PosRepPosgradosController posRepPosgradosController;
    
    @Inject
    RepSecretarioGeneralController repSecretarioGeneralController;
    
    @Inject
    RepNumeroCertificadoController repNumeroCertificadoController;
    
    @Inject
    RepEmisionCertificadoController repEmisionCertificadoController;
    
    @Inject
    RepTipCerRepSis repTipCerRepSis;
            
    @Inject
    RepTipCerRepSisFacade repTipCerRepSisFacade;  
    
    

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
            
            //System.out.println("nombreArchivo   "+nombreArchivo);
            
            //Identificar la estructura seleccionada para el reporte
            OrgEstructura orgEstructura = posReporteController.identificarEstructura();
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
            PedModalidad pedModalidad=posRepResultadoController.getPedModalidad();
            String codigoModalidad="%";
            if(pedModalidad!=null){
                codigoModalidad=String.valueOf(String.valueOf(pedModalidad.getModCodigo()));
            }
        
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
           /* System.out.println("codigoEstructura"+codigoEstructura);
            System.out.println("pn_pel_codigo"+codigoPeriodo);
            System.out.println("pv_per_codigo"+codigoPersona);
            System.out.println("pv_mal_codigo"+malCodigo);
            System.out.println("pv_mal_nivel"+codigoNivel);
            System.out.println("pv_gru_codigo"+gruCodigo);*/
            
            
            //Definición de Parámetros
            ReportParamBuilder rpb =
                            ReportParamBuilder.create("pv_usuario", Faces.getRemoteUser())
                                            .add(JRParameter.REPORT_LOCALE, new Locale("es","ES"));                                            
            rpb.add("pn_est_codigo", codigoEstructura);            
            rpb.add("pn_pel_codigo", codigoPeriodo);
            rpb.add("pn_pel_codigo_fin", codigoPeriodoFin);
            rpb.add("pv_mod_codigo", codigoModalidad);   
            rpb.add("pv_per_codigo", codigoPersona);  
            rpb.add("pv_mal_codigo", malCodigo);
            rpb.add("pv_gru_codigo", gruCodigo);
            rpb.add("pv_mal_nivel", codigoNivel);

            //Definición de Formato de Archivo
            switch(formato){
                case "pdf":
                    posReporteController.generarReporte(ReportType.PDF,".pdf",nombreArchivo,nombreReporte, rpb);
                    break;
                case "xlsx":
                    posReporteController.generarReporte(ReportType.XLSX,".xlsx",nombreArchivo,nombreReporte, rpb);
                    break;
                default:
                 throw new IllegalArgumentException("No se ha identificado el formato del archivo: " + formato);
            }   
        }
    }           
    
      /**
     * Generar reporte Certificados.
     * @param formato  Extensión del archivo a obtener ej: "pdf" , "xlsx".
     */
    public void generar_reporte_certificado(String formato,boolean certificacion){ 
            
       //System.out.println("generar_reporte_certificado");
                
       RepReportesSistema repReportesSistema=repReportesSistemaController.getSelected();   
        
       RepTipCerRepSis repTipCerRepSis = repTipCerRepSisFacade.consultaTipoCertificado(repReportesSistema.getResCodigo());
        
  
        
        
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
            String nombreReporte = "/WEB-INF/reportes/posRep_certificado/"+nombre;        
            String nombreArchivo = repReportesSistema.getResReporte();    
            
            //System.out.println("nombreArchivo   "+nombreArchivo);
            
            
            //Parámetro Alumno
            InsAlumnoWrapper insAlumnoWrapper=posRepPosgradosController.getInsAlumnoWrapper();
            Integer codigoAlumno=null;
            if(insAlumnoWrapper!=null){
                codigoAlumno=Integer.valueOf(String.valueOf(insAlumnoWrapper.getAluCodigo()));
            }    
            
            //Parámetro Semestre
            String nivelPeriodoEstructura = posRepPosgradosController.getMatNivelPeriodoEstructura();
            String codigoNivel="";
            if(nivelPeriodoEstructura!=null){
                codigoNivel=nivelPeriodoEstructura;
            }
                     
           //Parámetro Periodo
            PosgradoAlumnoWrapper posAlumnoWrapper=posRepPosgradosController.getPosgradoAlumnoWrapper();
            Integer codigoPeriodo = null;
            Integer estCampus = null;
            Integer estPosgrado = null;
            Long estSede = null;
            String tituloPosgrado = null;
            
            if(posAlumnoWrapper!=null){
                codigoPeriodo=Integer.valueOf(String.valueOf(posAlumnoWrapper.getCodPeriodo()));
                estCampus = Integer.valueOf(String.valueOf(posAlumnoWrapper.getEstCampus()));
                estPosgrado=Integer.valueOf(String.valueOf(posAlumnoWrapper.getEstPosgrado())); 
                estSede =Long.valueOf(posAlumnoWrapper.getEstSede());
                tituloPosgrado=String.valueOf(posAlumnoWrapper.getTitulo());
            }    
            
            
            //Parámetro Sede Factura
            String sedeFactura=posRepPosgradosController.getSedeFactura();
            Integer numSedeFactura=null;
            if(sedeFactura!=null){
                numSedeFactura= Integer.valueOf(sedeFactura);
            } 
             //Parámetro Punto de Facturación
            String puntoFacturacion=posRepPosgradosController.getPuntoFacturacion();
            Integer numPuntoFacturacion=null;
            if(puntoFacturacion!=null){
                numPuntoFacturacion= Integer.valueOf(puntoFacturacion);
            } 
            
             //Parámetro Número de Factura
            String numeroFactura=posRepPosgradosController.getNumFactura();
            Integer numFactura=null;
            if(numeroFactura!=null){
                numFactura= Integer.valueOf(numeroFactura);
            } 
            
            //Parámetro Secretaria General
            RepSecretarioGeneral secreGeneral= repSecretarioGeneralController.getSecretarioSeleccionado() ;
            Integer secretarioGeneral=1;
            if(secreGeneral!=null){    
                secretarioGeneral=Integer.valueOf(String.valueOf(secreGeneral.getSegCodigo()));
                
            } 
            
            //Parámetro opcion Certificación
            Integer opcion=posRepPosgradosController.opcionCertificacion();
            Integer opcionCert= 0;
            if(opcion!=null){
                opcionCert= opcion;
            } 
            
             //Parámetro Secuencia
            Integer numSecuenciaCertificado = 0;
           // Integer certificadoSemestre =1L;
            
            if ((estSede != null) && (certificacion == true)){      
              numSecuenciaCertificado = repNumeroCertificadoController.obtieneSecuenciaCertificado(estSede, posAlumnoWrapper.getCodPeriodo(), repTipCerRepSis.getTicCodigo());
          
            }
            System.out.println("pn_alu_codigo"+codigoAlumno);
            System.out.println("pv_nivel_matricula"+codigoNivel);
            System.out.println("numSedeFactura"+numSedeFactura);
            System.out.println("numPuntoFacturacion"+numPuntoFacturacion);
            System.out.println("numFactura"+numFactura);
            System.out.println("secretarioGeneral "+secretarioGeneral);
            System.out.println("codPeriodo"+codigoPeriodo);
            System.out.println("estCampus"+estCampus);
            System.out.println("estPosgrado"+estPosgrado);
            System.out.println("numSecuenciaCertificado"+numSecuenciaCertificado);
            System.out.println("opcionCert"+opcionCert);
            System.out.println("posAlumnoWrapper.getEstPosgrado()"+posAlumnoWrapper.getEstPosgrado());
 
 
            //Definición de Parámetros
            ReportParamBuilder rpb =
                            ReportParamBuilder.create("pv_usuario", Faces.getRemoteUser())
                                            .add(JRParameter.REPORT_LOCALE, new Locale("es","ES"));                                            
            rpb.add("pn_alu_codigo", codigoAlumno);            
            rpb.add("pn_pel_codigo", codigoPeriodo);
            rpb.add("pv_nivel", codigoNivel);
            rpb.add("pn_est_codigo", estPosgrado);  
            rpb.add("pn_campus", estCampus);
            rpb.add("pn_certificacion",opcionCert);  
            rpb.add("pn_seg_codigo", secretarioGeneral);
            rpb.add("pn_sedeFacturacion", numSedeFactura);  
            rpb.add("pn_puntoFacturacion", numPuntoFacturacion);  
            rpb.add("pn_numFactura", numFactura);
            rpb.add("pn_secuencia", numSecuenciaCertificado);
            rpb.add("pv_tituloPosgrado", tituloPosgrado);
            
           if ((estSede != null) && (certificacion == true)){     
             repEmisionCertificadoController.registraEmisionCertificado(Long.valueOf(numSecuenciaCertificado), Long.valueOf(codigoAlumno), Long.valueOf(posAlumnoWrapper.getEstPosgrado()), posAlumnoWrapper.getCodPeriodo(), repTipCerRepSis.getTicCodigo());
         
            }
           
            //Definición de Formato de Archivo
            switch(formato){
                case "pdf":
                    posReporteController.generarReporte(ReportType.PDF,".pdf",nombreArchivo,nombreReporte, rpb);
                    break;
                case "xlsx":
                    posReporteController.generarReporte(ReportType.XLSX,".xlsx",nombreArchivo,nombreReporte, rpb);
                    break;
                default:
                 throw new IllegalArgumentException("No se ha identificado el formato del archivo: " + formato);
            }  
        }
    } 
    
}
