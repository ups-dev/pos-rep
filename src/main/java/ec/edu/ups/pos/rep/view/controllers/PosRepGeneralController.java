package ec.edu.ups.pos.rep.view.controllers;

//import ec.edu.ups.pos.rep.data.entities.pos.EvaEvaCueInf;
//import ec.edu.ups.pos.rep.view.controllers.EvaTipoInformante;
import ec.edu.ups.pos.rep.data.entities.eva.EvaEvaluacionCuestionario;
import ec.edu.ups.pos.rep.data.entities.eva.EvaTipoInformante;
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
            PedModalidad pedModalidad=posRepResultadoController.getPedModalidad();
            String codigoModalidad="%";
            if(pedModalidad!=null){
                codigoModalidad=String.valueOf(String.valueOf(pedModalidad.getModCodigo()));
            }
            //Parámetro Cuestionario
            EvaEvaluacionCuestionario evaEvaluacionCuestionario=posRepResultadoController.getEvaEvaluacionCuestionario();
            Integer codigoCuestionario=0;
            if(evaEvaluacionCuestionario!=null){
                codigoCuestionario=Integer.valueOf(String.valueOf(evaEvaluacionCuestionario.getEvaCuestionario().getCueCodigo()));
            }
            
            //Parámetro Informante
            //EvaEvaCueInf evaEvaCueInf=posRepResultadoController.getEvaEvaCueInf();
            EvaTipoInformante evaTipoInformante = posRepResultadoController.getEvaTipoInformante();
            String codigoTipoInformante="%";
            if(evaTipoInformante!=null){
                codigoTipoInformante=String.valueOf(String.valueOf(evaTipoInformante.getTiiCodigo()));
            }

            //Parámetro Informante
            
          /*  EvaEvaCueInf evaEvaCueInf=posRepResultadoController.getEvaEvaCueInf();
            String codigoTipoInformante="%";
            System.out.println("evaEvaCueInf");
            if(evaEvaCueInf!=null){
                codigoTipoInformante=String.valueOf(String.valueOf(evaEvaCueInf.getEvaInfTipEva().getEvaTipoInformanteInf().getTiiCodigo()));
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
            System.out.println("codigoEstructura"+codigoEstructura);
            System.out.println("pn_pel_codigo"+codigoPeriodo);
            System.out.println("pv_per_codigo"+codigoPersona);
           // System.out.println("codigoTipoInformante"+codigoTipoInformante);
           // System.out.println("pn_pel_codigo_fin"+codigoPeriodoFin);
           // System.out.println("pv_mod_codigo"+codigoModalidad);
            //System.out.println("pn_cue_codigo"+codigoCuestionario);
            //System.out.println("pv_tii_codigo"+codigoTipoInformante);
            System.out.println("pv_mal_codigo"+malCodigo);
            System.out.println("pv_mal_nivel"+codigoNivel);
            System.out.println("pv_gru_codigo"+gruCodigo);
            
            
            //Definición de Parámetros
            ReportParamBuilder rpb =
                            ReportParamBuilder.create("pv_usuario", Faces.getRemoteUser())
                                            .add(JRParameter.REPORT_LOCALE, new Locale("es","ES"));                                            
            rpb.add("pn_est_codigo", codigoEstructura);            
            rpb.add("pn_pel_codigo", codigoPeriodo);
            rpb.add("pn_pel_codigo_fin", codigoPeriodoFin);
            rpb.add("pv_mod_codigo", codigoModalidad);  
            rpb.add("pn_cue_codigo", codigoCuestionario);
            rpb.add("pv_tii_codigo", codigoTipoInformante);  
            rpb.add("pv_per_codigo", codigoPersona);  
            rpb.add("pv_mal_codigo", malCodigo);
            rpb.add("pv_gru_codigo", gruCodigo);
            rpb.add("pv_mal_nivel", codigoNivel);

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
