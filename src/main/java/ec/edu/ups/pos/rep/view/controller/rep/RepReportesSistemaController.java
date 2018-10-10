package ec.edu.ups.pos.rep.view.controller.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepReportesSistemaFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.omnifaces.util.Faces;

@Named(value = "repReportesSistemaController")
@ViewScoped
public class RepReportesSistemaController extends AbstractController<RepReportesSistema> {

    private String modulo;
    
    @Inject
    private RepReportesSistemaFacade repReportesSistemaFacade;
       
    public RepReportesSistemaController() {
        super(RepReportesSistema.class);
    }    

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    
    public void preRenderView(String valor_modulo) {
        if (!Faces.isPostback()) {
            modulo = valor_modulo;
        }
    } 
    
//    @Override
//    protected List<RepReportesSistema> findItems() {
//        return getEjbFacade().findRecords(SearchBuilder.create(new DefaultParamSearch("audEliminado",
//                        "N", SearchCondition.EQUAL)),
//                        ParamBuilder.create(new CacheStoreModeParam(CacheStoreMode.REFRESH)).get());
//    }
    @Override
    protected List<RepReportesSistema> findItems() {
        return repReportesSistemaFacade.listaReportesAutorizados(Faces.getRemoteUser(), "POS-REP",modulo);
    }
    
    
 

}
