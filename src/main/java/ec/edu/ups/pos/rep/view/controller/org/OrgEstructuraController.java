package ec.edu.ups.pos.rep.view.controller.org;

import ec.edu.ups.pos.rep.logic.sessions.org.OrgEstructuraFacade;
import ec.edu.ups.org.common.data.entities.OrgEstructura;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import ec.edu.ups.jsf.security.ups.web.session.SecOrgEstructuraController;
import ec.edu.ups.pos.rep.data.utils.EvaRepConstants;

import ec.edu.ups.util.jpa.search.DefaultParamOrderSearch;
import ec.edu.ups.util.jpa.search.DefaultParamSearch;
import ec.edu.ups.util.jpa.search.SearchCondition;
import ec.edu.ups.util.jpa.search.SearchOrder;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.omnifaces.util.Faces;

@Named(value = "orgEstructuraController")
@ViewScoped
public class OrgEstructuraController extends AbstractController<OrgEstructura> {

    private List<OrgEstructura> orgEstructuraSedeList;
    private List<OrgEstructura> orgEstructuraCampusList;
    private List<OrgEstructura> orgEstructuraCarreraList;

    private List<OrgEstructura> orgEstructuraList;
    
    
    private OrgEstructura orgEstructuraSede;
    private OrgEstructura orgEstructuraCampus;
    private OrgEstructura orgEstructuraCarrera;

    @Inject
    private SecOrgEstructuraController secOrgEstructuraController;
   
    public OrgEstructuraController() {
        super(OrgEstructura.class);
    }

    public void updateSedeList() {        
        if (secOrgEstructuraController.getOrgEstructuraSede().getEstCodigo().equals(EvaRepConstants.TODAS_SEDES)) {
            orgEstructuraSedeList = getEjbFacade()
                    .findRecords(SearchBuilder.create(new DefaultParamSearch("orgEstructuraPadre.estCodigo", EvaRepConstants.CERO, SearchCondition.EQUAL))
                            .addParam(new DefaultParamOrderSearch("estCodigo", SearchOrder.ASC)));
        } else {
            setOrgEstructuraSedeList(Arrays.asList(secOrgEstructuraController.getOrgEstructuraSede()));
        }
//        setOrgEstructuraSede(getOrgEstructuraSedeList().get(0));
        updateCampusList();
    }

    public void updateCampusList() {
        if (orgEstructuraSede != null && !orgEstructuraSede.getOrgEstructuraCollection().isEmpty()) {
            setOrgEstructuraCampusList(new ArrayList(orgEstructuraSede.getOrgEstructuraCollection()));
            if (!secOrgEstructuraController.getOrgEstructuraCampus().getEstCodigo().equals(EvaRepConstants.TODOS_CAMPUS)) {
                getOrgEstructuraCampusList().retainAll(Arrays.asList(secOrgEstructuraController.getOrgEstructuraCampus()));
            }
            //setOrgEstructuraCampus(getOrgEstructuraCampusList().get(0));
            updateCarreraList();
        }
    }

    public void updateCarreraList() {
        if (orgEstructuraCampus != null && !orgEstructuraCampus.getOrgEstructuraCollection().isEmpty()) {
            setOrgEstructuraCarreraList(new ArrayList(orgEstructuraCampus.getOrgEstructuraCollection()));
            //setOrgEstructuraCarreraList(orgEstructuraFacade.lisEstructuraTipo(orgEstructuraCampus, secOrgEstructuraController.getTipoEstructura().getTieCodigo()));
            if (!secOrgEstructuraController.getOrgEstructuraCarrera().getEstCodigo().equals(EvaRepConstants.TODAS_CARRERAS)) {
                getOrgEstructuraCarreraList().retainAll(Arrays.asList(secOrgEstructuraController.getOrgEstructuraCarrera()));
            }
            //setOrgEstructuraCarrera(getOrgEstructuraCarreraList().get(0));
        }
    }

    
    
    
    @Override
    public OrgEstructura getSelectedToEdit() {
        if (orgEstructuraCarrera != null) {
            return orgEstructuraCarrera;
        } else if (orgEstructuraCampus != null) {
            return orgEstructuraCampus;
        } else if (orgEstructuraSede != null) {
            return orgEstructuraSede;
        } else {
            return getEjbFacade().find(EvaRepConstants.CERO);
        }
    }

    public List<OrgEstructura> getOrgEstructuraSedeList() {
        if (orgEstructuraSedeList == null) {
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

    public OrgEstructura getOrgEstructuraSede() {
        return orgEstructuraSede;
    }

    public void setOrgEstructuraSede(OrgEstructura orgEstructuraSede) {
        if (orgEstructuraSedeList == null) {
            orgEstructuraSedeList = new ArrayList(orgEstructuraSede.getOrgEstructuraPadre().getOrgEstructuraCollection());
        }
        if (orgEstructuraSede == null) {
            orgEstructuraCampusList = new ArrayList<>();
            setOrgEstructuraCampus(null);
        }
        this.orgEstructuraSede = orgEstructuraSede;
    }

    public OrgEstructura getOrgEstructuraCampus() {
        return orgEstructuraCampus;
    }

    public void setOrgEstructuraCampus(OrgEstructura orgEstructuraCampus) {
        if (orgEstructuraCampus != null) {
            if (orgEstructuraCampusList == null) {
                orgEstructuraCampusList = new ArrayList(orgEstructuraCampus.getOrgEstructuraPadre().getOrgEstructuraCollection());
            } else if (!orgEstructuraCampusList.contains(orgEstructuraCampus)) {
                orgEstructuraCampusList = new ArrayList(orgEstructuraCampus.getOrgEstructuraPadre().getOrgEstructuraCollection());
            }
            setOrgEstructuraSede(orgEstructuraCampus.getOrgEstructuraPadre());
        } else {
            orgEstructuraCarreraList = new ArrayList<>();
            setOrgEstructuraCarrera(null);
        }
        this.orgEstructuraCampus = orgEstructuraCampus;
    }

    public OrgEstructura getOrgEstructuraCarrera() {
        return orgEstructuraCarrera;
    }

    public void setOrgEstructuraCarrera(OrgEstructura orgEstructuraCarrera) {
        if (orgEstructuraCarrera != null) {
            if (orgEstructuraCarreraList == null) {
                orgEstructuraCarreraList = new ArrayList(orgEstructuraCarrera.getOrgEstructuraPadre().getOrgEstructuraCollection());
            }
            if (!orgEstructuraCarreraList.contains(orgEstructuraCarrera)) {
                orgEstructuraCarreraList = new ArrayList(orgEstructuraCarrera.getOrgEstructuraPadre().getOrgEstructuraCollection());
            }
            setOrgEstructuraCampus(orgEstructuraCarrera.getOrgEstructuraPadre());
        }
        this.orgEstructuraCarrera = orgEstructuraCarrera;
    }

    @Override
    public void setSelectedToEdit(OrgEstructura orgEstructura) {
        orgEstructuraCarrera = null;
        orgEstructuraCampus = null;
        orgEstructuraSede = null;
        if (orgEstructura.getOrgDescripcionEstructura().getOrgTipoEstructura().getTieCodigo().equals(5L)) {
            setOrgEstructuraCarrera(orgEstructura);
        } else if (orgEstructura.getOrgDescripcionEstructura().getOrgTipoEstructura().getTieCodigo().equals(3L)) {
            setOrgEstructuraCampus(orgEstructura);
        } else if (orgEstructura.getOrgDescripcionEstructura().getOrgTipoEstructura().getTieCodigo().equals(2L)) {
            setOrgEstructuraSede(orgEstructura);
        }
    }

    public List<OrgEstructura> getOrgEstructuraList() {
        return orgEstructuraList;
    }

    public void setOrgEstructuraList(List<OrgEstructura> orgEstructuraList) {
        this.orgEstructuraList = orgEstructuraList;
    }

}
