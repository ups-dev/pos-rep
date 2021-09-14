/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.view.controllers;

import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.pos.rep.data.entities.rep.RepParametroReporte;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
import ec.edu.ups.pos.rep.data.entities.wrapper.PosgradoAlumnoWrapper;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.logic.sessions.ins.InsAlumnoFacade;
import ec.edu.ups.pos.rep.logic.sessions.mat.MatMatriculaFacade;
import ec.edu.ups.pos.rep.logic.sessions.org.OrgEstructuraFacade;
import ec.edu.ups.pos.rep.logic.sessions.rep.PosRepPosgradosFacade;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepParametroReporteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;
import org.omnifaces.util.Utils;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

/**
 *
 * @author UPS
 */

@Named(value = "posRepPosgradosController")
@ViewScoped

public class PosRepPosgradosController implements Serializable{
    
    @Inject
    private InsAlumnoFacade insAlumnoFacade; 
    @Inject
    private PosRepPosgradosFacade posRepPosgradosFacade;
    @Inject
    private RepParametroReporteFacade repParametroReporteFacade;
    @Inject
    private MatMatriculaFacade matMatriculaFacade;
    
    @Inject
    private OrgEstructuraFacade orgEstructuraFacade; 
    @Inject
    private PosRepResultadoController posRepResultadoController; 
    
    
   
    private List<PosgradoAlumnoWrapper> listadoPosgrados;
    private PosgradoAlumnoWrapper posgradoAlumnoWrapper;
    private InsAlumnoWrapper insAlumnoWrapper;
    private List<InsAlumnoWrapper> listadoAlumnos;
    private Long aluCodigo;
      
    private boolean certificacion;
    private List<String> listSecretariaGeneral;  
    
    private List<String> matNivelPeriodoEstructuraList; 
    private String matNivelPeriodoEstructura;
     
    private String sedeFactura;
    private String puntoFacturacion;
    private String numFactura;
    
        
    private String filtro = "";
    private int maxResult = 10;
    
    OrgEstructura posgrado;
    OrgEstructura campus;
    OrgEstructura sede ;
      
    /**
     * Devuelve el objeto usado por PrimeFaces con opciones para poder modificar
     * la respuesta de una solicitud.
     *
     * @return la instancia de RequestContext usada por PrimeFaces.
     */
    public RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }
    
    
    public void callEventAjaxOrgEstructura() {
        
        PrimeFaces.current().ajax().update("PosReportesCerForm:PosReportesCerSistemaDataTable");
        PrimeFaces.current().ajax().update("PosReportesCerForm:PosRepCerExportToolbar");
        PrimeFaces.current().ajax().update("PosReportesCerForm:PosRepCerFiltroPanel"); 
        
            
    }
    
//    public void cargarNiveles(){
//
//        matNivelPeriodoEstructuraList= matMatriculaFacade.obtieneSemestre(insAlumnoWrapper.getAluCodigo());
//        //System.out.println("insAlumnoWrapper.getAluCodigo()" + insAlumnoWrapper.getAluCodigo());
//        actualizaCamposFac();
//
//    }
    
    public void cargarValidaciones(RepReportesSistema repReportesSistema){
        
        //System.out.println("repReportesSistema.getResCodigo() " + repReportesSistema.getResCodigo());
        // System.out.println("PosRepConstants.REPORTE_SISTEMA_RECORD_ACADEMICO_GRADUADOS" + PosRepConstants.REPORTE_SISTEMA_RECORD_ACADEMICO_GRADUADOS);
       if(repReportesSistema.getResCodigo().equals(PosRepConstants.REPORTE_SISTEMA_CALIFICACIONES_SEMESTRE)) {
            
         matNivelPeriodoEstructuraList= matMatriculaFacade.obtieneSemestre(insAlumnoWrapper.getAluCodigo());
        //System.out.println("insAlumnoWrapper.getAluCodigo()" + insAlumnoWrapper.getAluCodigo());
        
        
        }else if (repReportesSistema.getResCodigo().equals(PosRepConstants.REPORTE_SISTEMA_RECORD_ACADEMICO_GRADUADOS)){
         
            if(getPosgradoAlumnoWrapper().getActaGrado().equalsIgnoreCase("N") ){
                
                    Messages.addGlobalWarn("El estudiante no posee Acta de Grado en el Programa y Proyecto seleccionado.");

            }
        
        } 
        actualizaCamposFac();
        
        //aqui se va a cargar valores por defecto para sede y campus emision
        cargarEstructuraEmisionDefecto();
        System.out.println("Carga por defecto");

    }
      public boolean validarParametros(RepReportesSistema repReportesSistema){
            
        if(repReportesSistema.getResCodigo().equals(PosRepConstants.REPORTE_SISTEMA_CALIFICACIONES_SEMESTRE)) {
            
            if(matNivelPeriodoEstructuraList != null ){
                
                if (matNivelPeriodoEstructuraList.size()>0 && matNivelPeriodoEstructura == null){
                    
                    Messages.addGlobalWarn("Seleccione el Semestre del Programa.");
                    return false;
                }
            }
          
        }
        return true;
    }

      public List<InsAlumnoWrapper> autoCompleteAlumnos(String query) {
        List<InsAlumnoWrapper> suggestions = new ArrayList<>();

        if (!Utils.isEmpty(query)) {
            String replace = query.replace(" ", "%%");
            suggestions = insAlumnoFacade.findAlumnoWrapper(replace);
        }

        setListadoAlumnos(suggestions);

       return suggestions;
    }
    
   
    public void cargarLista(){
       // System.out.println("insAlumnio: "+insAlumnoWrapper);
        actualizaFiltros();
        
       if(insAlumnoWrapper!=null){
            listadoPosgrados=posRepPosgradosFacade.listaPosgrados(insAlumnoWrapper.getAluCodigo());   
            
            
       }      
       
       
    }
     public void limpiarFiltros(){
         
        setInsAlumnoWrapper(null);
        setAluCodigo(null);
        setPosgradoAlumnoWrapper(null);       
        setMatNivelPeriodoEstructuraList(null);
        setMatNivelPeriodoEstructura(null);
        setListSecretariaGeneral(null);
        setCertificacion(false);
        setNumFactura(null);
        setPuntoFacturacion(null);
        setSedeFactura(null);
    }  
    public void actualizaFiltros(){
       
        setAluCodigo(null);
        setPosgradoAlumnoWrapper(null);       
        setMatNivelPeriodoEstructuraList(null);
        setMatNivelPeriodoEstructura(null);
        setListSecretariaGeneral(null);
        setCertificacion(false);
        setNumFactura(null);
        setPuntoFacturacion(null);
        setSedeFactura(null);
        
        posgrado = null;
        campus = null;
        sede  =  null;
        

    }  
 
  public void actualizaCamposFac(){
       
        setCertificacion(false);
        setListSecretariaGeneral(null);
        setNumFactura(null);
        setPuntoFacturacion(null);
        setSedeFactura(null);
        posgrado = null;
        campus = null;
        sede  =  null;
        
       
    } 
  /////
  public void cargarEstructuraEmisionDefecto(){
     /* OrgEstructura posgrado = null;
      OrgEstructura campus =null;
      OrgEstructura sede  =     null; */
     posRepResultadoController.setOrgEstructuraCampusEmisionList(null);
     posRepResultadoController.setOrgEstructuraSedeEmisionList(null);
     
             System.out.println("insAlumnoWrapper" + insAlumnoWrapper);
     
      if (insAlumnoWrapper != null){
          List <OrgEstructura> estructuraEmision = orgEstructuraFacade.obtenerEstructuraPosgradoAlumno(insAlumnoWrapper.getAluCodigo().toString());
      
          
        /*   OrgEstructura posgrado= estructuraEmision.get(0);
           OrgEstructura campus = posgrado.getOrgEstructuraPadre();
           OrgEstructura sede = posgrado.getOrgEstructuraPadre().getOrgEstructuraPadre();*/
          
            posgrado= estructuraEmision.get(0);
            campus = posgrado.getOrgEstructuraPadre();
            sede = posgrado.getOrgEstructuraPadre().getOrgEstructuraPadre();
           
           posRepResultadoController.setOrgEstructuraSedeEmision(sede);
          System.out.println("sede inscripcion :"+sede);
           
           posRepResultadoController.setOrgEstructuraCampusEmision(campus);
           System.out.println("campus inscripcion :"+campus);
           
           
      }
          
       
    } 
  

    public boolean compruebaParametro(RepReportesSistema repReportesSistema, Long codigoParametro){
        List<RepParametroReporte> parametroReporteList=repParametroReporteFacade.obtieneParametroPorReporte(codigoParametro, repReportesSistema);
        return !(parametroReporteList==null || parametroReporteList.isEmpty());
    }
    
    public Integer opcionCertificacion (){
        Integer opcionSeleccionada = 0;
        
       if(certificacion){
            opcionSeleccionada = 1;
        }
       return opcionSeleccionada;
    
    } 
    
    
    public List<PosgradoAlumnoWrapper> getListadoPosgrados() {
        return listadoPosgrados;
    }

    public void setListadoPosgrados(List<PosgradoAlumnoWrapper> listadoPosgrados) {
        this.listadoPosgrados = listadoPosgrados;
    }

    public PosgradoAlumnoWrapper getPosgradoAlumnoWrapper() {
        return posgradoAlumnoWrapper;
    }

    public void setPosgradoAlumnoWrapper(PosgradoAlumnoWrapper posgradoAlumnoWrapper) {
        this.posgradoAlumnoWrapper = posgradoAlumnoWrapper;
    }

    public InsAlumnoWrapper getInsAlumnoWrapper() {
        return insAlumnoWrapper;
    }

    public void setInsAlumnoWrapper(InsAlumnoWrapper insAlumnoWrapper) {
        this.insAlumnoWrapper = insAlumnoWrapper;
    }

    public List<InsAlumnoWrapper> getListadoAlumnos() {
        return listadoAlumnos;
    }

    public void setListadoAlumnos(List<InsAlumnoWrapper> listadoAlumnos) {
        this.listadoAlumnos = listadoAlumnos;
    }
    
    public Long getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public boolean isCertificacion() {
        return certificacion;
    }

    public void setCertificacion(boolean certificacion) {
        this.certificacion = certificacion;
    }

    public List<String> getListSecretariaGeneral() {
        return listSecretariaGeneral;
    }

    public void setListSecretariaGeneral(List<String> listSecretariaGeneral) {
        this.listSecretariaGeneral = listSecretariaGeneral;
    }  

    public List<String> getMatNivelPeriodoEstructuraList() {
        return matNivelPeriodoEstructuraList;
    }

    public void setMatNivelPeriodoEstructuraList(List<String> matNivelPeriodoEstructuraList) {
        this.matNivelPeriodoEstructuraList = matNivelPeriodoEstructuraList;
    }

    public String getMatNivelPeriodoEstructura() {
        return matNivelPeriodoEstructura;
    }

    public void setMatNivelPeriodoEstructura(String matNivelPeriodoEstructura) {
        this.matNivelPeriodoEstructura = matNivelPeriodoEstructura;
    }  
    
    public InsAlumnoFacade getInsAlumnoFacade() {
        return insAlumnoFacade;
    }

    public void setInsAlumnoFacade(InsAlumnoFacade insAlumnoFacade) {
        this.insAlumnoFacade = insAlumnoFacade;
    }

    public String getSedeFactura() {
        return sedeFactura;
    }

    public void setSedeFactura(String sedeFactura) {
        this.sedeFactura = sedeFactura;
    }

    public String getPuntoFacturacion() {
        return puntoFacturacion;
    }

    public void setPuntoFacturacion(String puntoFacturacion) {
        this.puntoFacturacion = puntoFacturacion;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }
   
      
}
          



