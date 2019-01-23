package ec.edu.ups.pos.rep.view.controllers;


import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.data.entities.ofe.OfeGrupo;
import ec.edu.ups.pos.rep.data.entities.rep.RepParametroReporte;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.logic.sessions.gth.GthPersonaFacade;
import ec.edu.ups.pos.rep.logic.sessions.ofe.OfeGrupoFacade;
import ec.edu.ups.pos.rep.logic.sessions.org.OrgEstructuraFacade;
import ec.edu.ups.pos.rep.logic.sessions.org.OrgPeriodoEstructuraFacade;
import ec.edu.ups.pos.rep.logic.sessions.ped.PedMallaFacade;
import ec.edu.ups.pos.rep.logic.sessions.ped.PedModalidadFacade;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepParametroReporteFacade;
import ec.edu.ups.pos.rep.view.controller.rep.RepReportesSistemaController;
import ec.edu.ups.jsf.security.ups.util.TipoEstructura;
import ec.edu.ups.jsf.security.ups.web.session.SecOrgEstructuraController;
import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.org.common.data.entities.OrgPeriodoLectivo;
import ec.edu.ups.ped.common.data.entities.PedMalla;
import ec.edu.ups.ped.common.data.entities.PedModalidad;
//import ec.edu.ups.pos.rep.data.entities.sigac.ClienteLocal;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
import ec.edu.ups.pos.rep.logic.sessions.ins.InsAlumnoFacade;
import ec.edu.ups.util.jpa.search.DefaultParamOrderSearch;
import ec.edu.ups.util.jpa.search.SearchOrder;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.CacheStoreMode;
import org.omnifaces.util.Utils;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;

@Named(value = "posRepResultadoController")
@ViewScoped
public class PosRepResultadoController implements Serializable{

    private OrgEstructura orgEstructuraSede;
    private OrgEstructura orgEstructuraCampus;
    private OrgEstructura orgEstructuraCarrera;
     
    private OrgPeriodoLectivo orgPeriodoInicial;
    private OrgPeriodoLectivo orgPeriodoFinal;
    private PedModalidad pedModalidad;
    private GthPersona gthPersona;
    private PedMalla pedMalla;
    private OfeGrupo ofeGrupo;
    private List<OrgEstructura> orgEstructuraSedeList;
    private List<OrgEstructura> orgEstructuraCampusList;
    private List<OrgEstructura> orgEstructuraCarreraList;
  
    private List<OrgPeriodoLectivo> orgPeriodoLectivoList;
    private List<RepReportesSistema> repReportesSistemaList;
    private List<GthPersona> gthPersonaList;
    private List<PedMalla> pedMallaList;
    private List<OfeGrupo> ofeGrupoList;
    private List<Integer> pedMallaNivelList;
    private Integer pedNivelMalla;
    private List<InsAlumnoWrapper> listadoAlumnos;
    private String pafPagado;
      
    private InsAlumnoWrapper insAlumnoWrapper;
    
      
    @Inject
    private SecOrgEstructuraController secOrgEstructuraController;
    @Inject
    private OrgEstructuraFacade orgEstructuraFacade;
    @Inject
    private RepReportesSistemaController repReportesSistemaController;  
    @Inject
    private OrgPeriodoEstructuraFacade orgPeriodoEstructuraFacade;
    @Inject
    private GthPersonaFacade gthPersonaFacade;
    @Inject
    private PedMallaFacade pedMallaFacade;
    @Inject
    private OfeGrupoFacade ofeGrupoFacade;
    @Inject
    private RepParametroReporteFacade repParametroReporteFacade;
    @Inject
    private PedModalidadFacade pedModalidadFacade;
    
    @Inject
    private InsAlumnoFacade insAlumnoFacade; 
 
             
          
    
    
    private String filtro = "";
    private int maxResult = 10;
    private boolean validaSeleccionEstructuraSeguridadSede=false;
    private boolean validaSeleccionEstructuraSeguridadCampus=false;
    private boolean validaSeleccionEstructuraSeguridadCarrProg=false;
    
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
        actualizaFiltros();   
        
        PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable");
        PrimeFaces.current().ajax().update("PosReportesForm:PosRepExportToolbar");
        PrimeFaces.current().ajax().update("PosReportesForm:PosRepFiltroPanel09"); 
        
      //  getRequestContext().update("PosReportesForm:SbeRepFiltroPanel");
//        updateSedeList();        
    }
    
    public List<RepReportesSistema> getRepReportesSistemaList() {
        if(repReportesSistemaList==null){
            return repReportesSistemaController.getEjbFacade().findRecords(
                    SearchBuilder.create(new DefaultParamOrderSearch("resCodigo", SearchOrder.ASC))
                    .addParam(new CacheStoreModeParam(CacheStoreMode.REFRESH))
                            
            );                        
        }
        return repReportesSistemaList;
    }

    public void setRepReportesSistemaList(List<RepReportesSistema> repReportesSistemaList) {
        this.repReportesSistemaList = repReportesSistemaList;
    }
    
    public void updateSedeList() {        
        if (secOrgEstructuraController.getEstructuraSede().getEstCodigo().equals(PosRepConstants.TODAS_SEDES)) {
            setValidaSeleccionEstructuraSeguridadSede(false);
            orgEstructuraSedeList = orgEstructuraFacade.listaEstructuraSedeActivo();
        } else {
            setValidaSeleccionEstructuraSeguridadSede(true);
            setOrgEstructuraSedeList(Arrays.asList(orgEstructuraFacade.find(secOrgEstructuraController.getEstructuraSede().getEstCodigo(), true)));
            if(!orgEstructuraSedeList.isEmpty()){
                setOrgEstructuraSede(getOrgEstructuraSedeList().get(0));
            }            
        }
        updateCampusList();
    }

    public void updateCampusList() {
        setOrgEstructuraCampus(null);
        setOrgEstructuraCampusList(null);        
        if (getOrgEstructuraSede() != null) {
            if (!Objects.equals(secOrgEstructuraController.getEstructuraCampus().getEstCodigo(), PosRepConstants.TODOS_CAMPUS)
                    && !Objects.equals(secOrgEstructuraController.getEstructuraSede().getEstCodigo(), PosRepConstants.TODAS_SEDES)) {
                validaSeleccionEstructuraSeguridadCampus=true;
                setOrgEstructuraCampusList(Arrays.asList(orgEstructuraFacade.find(secOrgEstructuraController.getEstructuraCampus().getEstCodigo(), true)));
                if(!(orgEstructuraCampusList.isEmpty())){
                    setOrgEstructuraCampus(orgEstructuraCampusList.get(0));
                }
            } else {
                validaSeleccionEstructuraSeguridadCampus=false;
                orgEstructuraCampusList = orgEstructuraFacade.listaEstructuraCampusActivo(getOrgEstructuraSede());
//                orgEstructuraCampusList.retainAll(secOrgEstructuraController.updateCampusList(new SecEstructuraWrapper(getOrgEstructuraSede().getEstCodigo())));                 
            }            
        }  
        updateCarreraList();
  
    }

    public void updateCarreraList() {
        
        setOrgEstructuraCarrera(null);
        setOrgEstructuraCarreraList(null);
        //updatePeriodoPorCampusList();
        updateAsignaturaList();
        setGthPersona(null);
        //setGthPersonaList(null);
        if (getOrgEstructuraCampus() != null) {
            if (secOrgEstructuraController.getTipoEstructura()==TipoEstructura.PROGRAMA) {
                if (Objects.equals(secOrgEstructuraController.getEstructuraCarrera().getEstCodigo(), PosRepConstants.TODAS_CARRERAS)) {
                    orgEstructuraCarreraList = orgEstructuraFacade.listaEstructuraPostGradoSelecActivo(getOrgEstructuraCampus());
                    //orgEstructuraCarreraList.retainAll(secOrgEstructuraController.updateCarreraList(new SecEstructuraWrapper(getOrgEstructuraCampus().getEstCodigo())));
                } else {
                    orgEstructuraCarreraList = orgEstructuraFacade.listaEstructuraPostGradoSelecActivo(getOrgEstructuraCampus());
                    if (orgEstructuraCarreraList.contains(secOrgEstructuraController.getEstructuraCarrera())) {
                        orgEstructuraCarreraList = new ArrayList<>();
                        orgEstructuraCarreraList.add(orgEstructuraFacade.find(secOrgEstructuraController.getEstructuraCarrera().getEstCodigo(), true));
                    } else {
                        orgEstructuraCarreraList = new ArrayList<>();
                    }
                }
            }
          
           
           /* if (secOrgEstructuraController.getTipoEstructura()==TipoEstructura.CARRERA) {
                if (Objects.equals(secOrgEstructuraController.getOrgEstructuraCarrera().getEstCodigo(), PosRepConstants.TODAS_CARRERAS)) {
                    validaSeleccionEstructuraSeguridadCarrProg=false;
                    orgEstructuraCarreraList = orgEstructuraFacade.listaEstructuraCarreraSelecActivo(getOrgEstructuraCampus());
                    orgEstructuraCarreraList.retainAll(secOrgEstructuraController.updateCarreraList(getOrgEstructuraCampus()));
                } else {
                    validaSeleccionEstructuraSeguridadCarrProg=true;
                    orgEstructuraCarreraList = orgEstructuraFacade.listaEstructuraCarreraSelecActivo(getOrgEstructuraCampus());
                    if (orgEstructuraCarreraList.contains(secOrgEstructuraController.getOrgEstructuraCarrera())) {
                        orgEstructuraCarreraList = new ArrayList<>();
                        orgEstructuraCarreraList.add(secOrgEstructuraController.getOrgEstructuraCarrera());
                    } else {
                        orgEstructuraCarreraList = new ArrayList<>();
                    }
                    if(!(orgEstructuraCarreraList.isEmpty())){
                        setOrgEstructuraCarrera(orgEstructuraCarreraList.get(0));
                    }
                }
            }*/
        }  
         updatePeriodoPorCampusList();
    }

    
       public void updatePeriodoPorCampusList() {
        setOrgPeriodoInicial(null);
        setOrgPeriodoFinal(null);
        setOrgPeriodoLectivoList(null);
        updateGrupoList();
        
        if (obtenerEstructura() != null) { 
             
             setOrgPeriodoLectivoList(orgPeriodoEstructuraFacade.obtieneCohortePorEstructura(obtenerEstructura()));
      
        }else{
           // System.out.println("igual a NULL");
            setOrgPeriodoLectivoList(orgPeriodoEstructuraFacade.obtienePeriodoLectivo());
        }
               
            updateNivelMallaList();
        
       }          
    
    /**
     * Actualizar lista de Asignaturas por Carrera
     */
    public void updateAsignaturaList() {  
        setPedMalla(null);
        setPedMallaList(null);
        updateGrupoList();
        Long pelCodigo = 0L;
        if (getOrgPeriodoInicial() != null)
        {
            if (getOrgPeriodoInicial().getPelCodigo() != null)
            {
                pelCodigo = getOrgPeriodoInicial().getPelCodigo();
            }
        }
        
        Long estCodigo = 0L;
        if(getOrgEstructuraCarrera()!=null){
            estCodigo = getOrgEstructuraCarrera().getEstCodigo();
        }else if(getOrgEstructuraCampus()!=null){
            estCodigo = getOrgEstructuraCampus().getEstCodigo();
        }else if(getOrgEstructuraSede()!=null){
            estCodigo = getOrgEstructuraSede().getEstCodigo();
        }            
        
        if(getGthPersona()!=null && pelCodigo != 0L){  
            setPedMallaList(pedMallaFacade.obtieneMallaDocente(estCodigo, getGthPersona(), pelCodigo));
        }
        if(getGthPersona()==null && pelCodigo != 0L){  
            setPedMallaList(null);
//            setPedMallaList(pedMallaFacade.obtieneMalla(estCodigo, pelCodigo));
        }
    }
    
    /**
     * Actualizar lista de Grupos por malla
     */
    public void updateGrupoList() {  
        setOfeGrupo(null);
        setOfeGrupoList(null);
        Long pelCodigoI = 0L;
        if (getOrgPeriodoInicial() != null)
        {
            if (getOrgPeriodoInicial().getPelCodigo() != null)
            {
                pelCodigoI = getOrgPeriodoInicial().getPelCodigo();
            }
        }

        Long pelCodigoF = 0L;
        if (getOrgPeriodoFinal()!= null)
        {
            if (getOrgPeriodoFinal().getPelCodigo() != null)
                pelCodigoF = getOrgPeriodoFinal().getPelCodigo();
            else
                pelCodigoF = pelCodigoI;
        }
        else
            pelCodigoF = pelCodigoI;
        if(getPedMalla()!=null && getOrgPeriodoInicial()!=null && getGthPersona()!=null){            
            setOfeGrupoList(ofeGrupoFacade.obtieneGrupo(getPedMalla(), pelCodigoI, pelCodigoF, getGthPersona()));
        }          
    }
   
    public OrgEstructura getOrgEstructuraSede() {
        return orgEstructuraSede;
    }

    public void setOrgEstructuraSede(OrgEstructura orgEstructuraSede) {
        this.orgEstructuraSede = orgEstructuraSede;
    }

    public OrgEstructura getOrgEstructuraCampus() {
        return orgEstructuraCampus;
    }

    public void setOrgEstructuraCampus(OrgEstructura orgEstructuraCampus) {
        this.orgEstructuraCampus = orgEstructuraCampus;
    }

    public OrgEstructura getOrgEstructuraCarrera() {
        return orgEstructuraCarrera;
    }

    public void setOrgEstructuraCarrera(OrgEstructura orgEstructuraCarrera) {
        this.orgEstructuraCarrera = orgEstructuraCarrera;
    }    

    public OrgPeriodoLectivo getOrgPeriodoInicial() {
        return orgPeriodoInicial;
    }

    public void setOrgPeriodoInicial(OrgPeriodoLectivo orgPeriodoInicial) {
        this.orgPeriodoInicial = orgPeriodoInicial;
    }

    public OrgPeriodoLectivo getOrgPeriodoFinal() {
        return orgPeriodoFinal;
    }

    public void setOrgPeriodoFinal(OrgPeriodoLectivo orgPeriodoFinal) {
        this.orgPeriodoFinal = orgPeriodoFinal;
    }       

    public PedModalidad getPedModalidad() {
        return pedModalidad;
    }

    public void setPedModalidad(PedModalidad pedModalidad) {
        this.pedModalidad = pedModalidad;
    }    

    public GthPersona getGthPersona() {
        return gthPersona;
    }

    public void setGthPersona(GthPersona gthPersona) {
        this.gthPersona = gthPersona;
    }    

    public PedMalla getPedMalla() {
        return pedMalla;
    }

    public void setPedMalla(PedMalla pedMalla) {
        this.pedMalla = pedMalla;
    }    

    public OfeGrupo getOfeGrupo() {
        return ofeGrupo;
    }

    public void setOfeGrupo(OfeGrupo ofeGrupo) {
        this.ofeGrupo = ofeGrupo;
    }    

    public List<OrgEstructura> getOrgEstructuraSedeList() {
        if(orgEstructuraSedeList==null){
            updateSedeList();
        }
        return orgEstructuraSedeList;
    }

    public void setOrgEstructuraSedeList(List<OrgEstructura> orgEstructuraSedeList) {
        this.orgEstructuraSedeList = orgEstructuraSedeList;
    }

    public List<OrgEstructura> getOrgEstructuraCampusList() {
        return orgEstructuraCampusList;
    }

    public void setOrgEstructuraCampusList(List<OrgEstructura> orgEstructuraCampusList) {
        this.orgEstructuraCampusList = orgEstructuraCampusList;
    }

    public List<OrgEstructura> getOrgEstructuraCarreraList() {
        return orgEstructuraCarreraList;
    }

    public void setOrgEstructuraCarreraList(List<OrgEstructura> orgEstructuraCarreraList) {
        this.orgEstructuraCarreraList = orgEstructuraCarreraList;
    } 

    public List<OrgPeriodoLectivo> getOrgPeriodoLectivoList() {
        //if(orgPeriodoLectivoList==null){
          //  updatePeriodoPorCampusList();
       // }
        return orgPeriodoLectivoList;
    }

    public void setOrgPeriodoLectivoList(List<OrgPeriodoLectivo> orgPeriodoLectivoList) {
        this.orgPeriodoLectivoList = orgPeriodoLectivoList;
    }        

    public List<GthPersona> getGthPersonaList() {
        Long pelCodigo = 0L;
        if (getOrgPeriodoInicial() != null)
            if (getOrgPeriodoInicial().getPelCodigo() != null)
                pelCodigo = getOrgPeriodoInicial().getPelCodigo();

        if (gthPersonaList == null) {  
            if(getOrgEstructuraCarrera()!=null){
                gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),getOrgEstructuraCarrera().getEstCodigo(), pelCodigo);
                //gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),584L,2001L);
                
            }else if(getOrgEstructuraCampus()!=null){
                gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),getOrgEstructuraCampus().getEstCodigo(), pelCodigo);
                //gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),584L,2001L);
            }else if(getOrgEstructuraSede()!=null){
                gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),getOrgEstructuraSede().getEstCodigo(), pelCodigo);
              //gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),584L,2001L);
            }else{
                gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),0L, pelCodigo);
               // gthPersonaList = gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),584L,2001L);
            }   
            System.out.println("lista" + gthPersonaList.size() );
        }
        return gthPersonaList;
    }

    public void setGthPersonaList(List<GthPersona> gthPersonaList) {
        this.gthPersonaList = gthPersonaList;
    }

    public List<PedMalla> getPedMallaList() {
        return pedMallaList;
    }

    public void setPedMallaList(List<PedMalla> pedMallaList) {
        this.pedMallaList = pedMallaList;
    }    

    public List<OfeGrupo> getOfeGrupoList() {
        return ofeGrupoList;
    }

    public void setOfeGrupoList(List<OfeGrupo> ofeGrupoList) {
        this.ofeGrupoList = ofeGrupoList;
    }    

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }    

    public List<GthPersona> completePersona(String query) {
        List<GthPersona> suggestions = new ArrayList<>();
        filtrarDocente(query.toUpperCase(Locale.getDefault()));
        for (GthPersona i : getGthPersonaList()) {
            if (suggestions.size() < maxResult && (i.getPerApellidos().contains(query.toUpperCase(Locale.getDefault()))
                                                   || i.getPerNombres().contains(query.toUpperCase(Locale.getDefault()))
                                                   || i.getPerNroIdentificacion().contains(query.toUpperCase(Locale.getDefault())))) {
                suggestions.add(i);
            }
        }
        return suggestions;
    }  
    
    public void filtrarDocente(String value) {
         System.out.println("value" +value);
        setFiltro(value);
        setGthPersonaList(null);
    }
    
    public void cambioSede(){
        setOrgEstructuraCampus(null);
        setOrgEstructuraCampusList(null);
        updateCampusList();
    }
    
    public boolean compruebaParametro(RepReportesSistema repReportesSistema, Long codigoParametro){
        List<RepParametroReporte> parametroReporteList=repParametroReporteFacade.obtieneParametroPorReporte(codigoParametro, repReportesSistema);
        return !(parametroReporteList==null || parametroReporteList.isEmpty());
    }
    
    public void actualizaFiltros(){
        setOrgEstructuraSede(null);
        setOrgEstructuraCampusList(null);
        setOrgEstructuraCampus(null);
        setOrgEstructuraCampusList(null);
        setOrgEstructuraCarrera(null);
        setOrgEstructuraCarreraList(null);
        setOrgPeriodoInicial(null);
        setOrgPeriodoFinal(null);
        setOrgPeriodoLectivoList(null);
        setPedModalidad(null);
        setPedMallaNivelList(null);
        setPedNivelMalla(null);
        setGthPersona(null);
        setGthPersonaList(null);
        setPedMalla(null);
        setPedMallaList(null);
        setOfeGrupo(null);
        setOfeGrupoList(null);
        updateSedeList();
        
    }

    public boolean isValidaSeleccionEstructuraSeguridadSede() {
        return validaSeleccionEstructuraSeguridadSede;
    }

    public void setValidaSeleccionEstructuraSeguridadSede(boolean validaSeleccionEstructuraSeguridadSede) {
        this.validaSeleccionEstructuraSeguridadSede = validaSeleccionEstructuraSeguridadSede;
    }

    public boolean isValidaSeleccionEstructuraSeguridadCampus() {
        return validaSeleccionEstructuraSeguridadCampus;
    }

    public void setValidaSeleccionEstructuraSeguridadCampus(boolean validaSeleccionEstructuraSeguridadCampus) {
        this.validaSeleccionEstructuraSeguridadCampus = validaSeleccionEstructuraSeguridadCampus;
    }

    public boolean isValidaSeleccionEstructuraSeguridadCarrProg() {
        return validaSeleccionEstructuraSeguridadCarrProg;
    }

    public void setValidaSeleccionEstructuraSeguridadCarrProg(boolean validaSeleccionEstructuraSeguridadCarrProg) {
        this.validaSeleccionEstructuraSeguridadCarrProg = validaSeleccionEstructuraSeguridadCarrProg;
    }
    
    public String obtieneModalidad(Long modCodigo){
        if(modCodigo==null){
            return "";
        }
        PedModalidad pedModalidadDes=pedModalidadFacade.find(modCodigo);
        if(pedModalidadDes!=null){
            return pedModalidadDes.getModDescripcion();
        }else{
            return "";
        }        
    }
    
    public String obtieneCampus(Long estCodigo){
        if(estCodigo==null){
            return "";
        }  
        OrgEstructura orgEstructuraDes=orgEstructuraFacade.find(estCodigo);
        if(orgEstructuraDes!=null){
            return orgEstructuraDes.getOrgDescripcionEstructura().getDeeDescripcion();
        }else{
            return "";
        }
    }
    
      public List<Integer> getPedMallaNivelList() {
        return pedMallaNivelList;
    }

    public void setPedMallaNivelList(List<Integer> pedMallaNivelList) {
        this.pedMallaNivelList = pedMallaNivelList;
    }    

    public Integer getPedNivelMalla() {
        return pedNivelMalla;
    }

    public void setPedNivelMalla(Integer pedNivelMalla) {
        this.pedNivelMalla = pedNivelMalla;
    }
      /**
     * Actualizar lista de Nivel de asignatura  revisaaaaaar
     */
    public void updateNivelMallaList() {  
        
        setPedMallaNivelList(null);
         OrgPeriodoLectivo orgPeriodoInicial=getOrgPeriodoInicial();
          //  Long codigoPeriodo= orgPeriodoInicial.getPelCodigo();
           
          
         System.out.println("getOrgEstructuraCarrera().getEstCodigo()"+getOrgEstructuraCarrera());
         System.out.println("getOrgEstructuraCampus().getEstCodigo()"+getOrgEstructuraCampus());
         System.out.println("getOrgEstructuraSede().getEstCodigo()"+getOrgEstructuraSede());
         System.out.println("periodouuuu "+getOrgPeriodoInicial());
                
        if (obtenerEstructura() != null) {
           
             pedMallaNivelList = pedMallaFacade.obtieneNivelMalla(obtenerEstructura().getEstCodigo(),2001L); 
             //pedMallaNivelList = pedMallaFacade.obtieneNivelMalla(obtenerEstructura().getEstCodigo(),getOrgPeriodoInicial().getPelCodigo());
        
        }else 
        {
            System.out.println("igual a NULL");
            pedMallaNivelList = pedMallaFacade.obtieneNivelMalla(PosRepConstants.TODAS_SEDES, 2001L);   
        }
        
    }
    public OrgEstructura obtenerEstructura(){
        
        OrgEstructura estructuraSeleccionada = null;
        
        if( getOrgEstructuraCarrera() != null){
            
            estructuraSeleccionada = getOrgEstructuraCarrera();
            
        
        }else {
        
           if (getOrgEstructuraCampus()!=null){            
           estructuraSeleccionada = getOrgEstructuraCampus();
            
            }else 
           {
               if (getOrgEstructuraSede()!=null) {
                   estructuraSeleccionada = getOrgEstructuraSede();
                   
               }
           
           }
        
        }
        return estructuraSeleccionada;

    }
    
    public String obtenerAnioPosgrado(Date fechaInicio, Date fechaFin ){
       
        Calendar fecha1 = Calendar.getInstance();
        fecha1.setTime(fechaInicio); 
        Calendar fecha2 = Calendar.getInstance();
        fecha2.setTime(fechaFin);
        int anioIni = fecha1.get(Calendar.YEAR);
        int anioFin = fecha2.get(Calendar.YEAR);
        String anio_posgrado = Integer.toString(anioIni)+" - " +Integer.toString(anioFin);
       
    return anio_posgrado;
    }

    public InsAlumnoFacade getInsAlumnoFacade() {
        return insAlumnoFacade;
    }

    public void setInsAlumnoFacade(InsAlumnoFacade insAlumnoFacade) {
        this.insAlumnoFacade = insAlumnoFacade;
    }
    
    //Metodo controller

    public List<InsAlumnoWrapper> getListadoAlumnos() {
        return listadoAlumnos;
    }

    public void setListadoAlumnos(List<InsAlumnoWrapper> listadoAlumnos) {
        this.listadoAlumnos = listadoAlumnos;
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

    public InsAlumnoWrapper getInsAlumnoWrapper() {
        return insAlumnoWrapper;
    }

    public void setInsAlumnoWrapper(InsAlumnoWrapper insAlumnoWrapper) {
        this.insAlumnoWrapper = insAlumnoWrapper;
    }

    public String getPafPagado() {
        return pafPagado;
    }

    public void setPafPagado(String pafPagado) {
        this.pafPagado = pafPagado;
    }
   
}
          