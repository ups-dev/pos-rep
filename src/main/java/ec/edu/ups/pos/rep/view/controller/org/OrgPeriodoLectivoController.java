package ec.edu.ups.pos.rep.view.controller.org;

import ec.edu.ups.org.common.data.entities.OrgPeriodoLectivo;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import ec.edu.ups.util.jpa.search.DefaultParamOrderSearch;
import ec.edu.ups.util.jpa.search.SearchOrder;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "orgPeriodoLectivoController")
@ViewScoped
public class OrgPeriodoLectivoController extends AbstractController<OrgPeriodoLectivo> {

    public OrgPeriodoLectivoController() {
        super(OrgPeriodoLectivo.class);
    }
    
    @Override
    public List<OrgPeriodoLectivo> getItemsNotDisabled() {
        if (isRefreshCache()) {
            setItemsNotDisabled(getEjbFacade().findRecordsNoDisabled(SearchBuilder.create(new DefaultParamOrderSearch("pelCodigo", SearchOrder.DESC)).getParams()));
        } else {
            setItemsNotDisabled(getEjbFacade().findRecordsNoDisabled(SearchBuilder.create(new DefaultParamOrderSearch("pelCodigo", SearchOrder.DESC)).getParams()));
        }
        setRefreshCache(false);
        return super.getItemsNotDisabled();
    }

}
