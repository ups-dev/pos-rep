package ec.edu.ups.pos.rep.view.controller.rep;

import ec.edu.ups.jsf.security.ups.util.TipoEstructura;
import ec.edu.ups.jsf.security.ups.web.session.SecOrgEstructuraController;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
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
    @Inject
    private SecOrgEstructuraController secOrgEstructuraController;
        
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
               secOrgEstructuraController.setTipoEstructura(TipoEstructura.PROGRAMA);
        }
    } 
       
    @Override
    protected List<RepReportesSistema> findItems() {
        return repReportesSistemaFacade.listaReportesAutorizados(Faces.getRemoteUser(), "POS-REP",modulo);
    }
    

}
