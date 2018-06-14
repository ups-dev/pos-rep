package ec.edu.ups.pos.rep.view.controller.rep;

import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepReportesSistemaFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import ec.edu.ups.util.jpa.search.DefaultParamSearch;
import ec.edu.ups.util.jpa.search.SearchCondition;
import ec.edu.ups.util.jpa.search.builder.ParamBuilder;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.CacheStoreMode;
import org.omnifaces.util.Faces;

@Named(value = "repReportesSistemaController")
@ViewScoped
public class RepReportesSistemaController extends AbstractController<RepReportesSistema> {

    @Inject
    private RepReportesSistemaFacade repReportesSistemaFacade;
       
    public RepReportesSistemaController() {
        super(RepReportesSistema.class);
    }    

//    @Override
//    protected List<RepReportesSistema> findItems() {
//        return getEjbFacade().findRecords(SearchBuilder.create(new DefaultParamSearch("audEliminado",
//                        "N", SearchCondition.EQUAL)),
//                        ParamBuilder.create(new CacheStoreModeParam(CacheStoreMode.REFRESH)).get());
//    }
    @Override
    protected List<RepReportesSistema> findItems() {
        return repReportesSistemaFacade.listaReportesAutorizados(Faces.getRemoteUser(), "POS-REP");
    }

}
