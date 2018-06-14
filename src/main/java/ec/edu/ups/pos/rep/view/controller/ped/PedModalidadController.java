package ec.edu.ups.pos.rep.view.controller.ped;

import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import ec.edu.ups.ped.common.data.entities.PedModalidad;
import ec.edu.ups.util.jpa.search.DefaultParamOrderSearch;
import ec.edu.ups.util.jpa.search.SearchOrder;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "pedModalidadController")
@ViewScoped
public class PedModalidadController extends AbstractController<PedModalidad> {

    public PedModalidadController() {
        super(PedModalidad.class);
    }
    
    @Override
    public List<PedModalidad> getItemsNotDisabled() {
        if (isRefreshCache()) {
            setItemsNotDisabled(getEjbFacade().findRecordsNoDisabled(SearchBuilder.create(new DefaultParamOrderSearch("modCodigo", SearchOrder.ASC)).getParams()));
        } else {
            setItemsNotDisabled(getEjbFacade().findRecordsNoDisabled(SearchBuilder.create(new DefaultParamOrderSearch("modCodigo", SearchOrder.ASC)).getParams()));
        }
        setRefreshCache(false);
        return super.getItemsNotDisabled();
    }

}
