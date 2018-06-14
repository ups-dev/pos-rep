package ec.edu.ups.pos.rep.view.controller.org;

import static ec.edu.ups.pos.rep.data.utils.EvaRepConstants.TIPO_AREA_PAIS;
import ec.edu.ups.org.common.data.entities.OrgAreaGeografica;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import ec.edu.ups.util.jpa.search.DefaultParamOrderSearch;
import ec.edu.ups.util.jpa.search.DefaultParamSearch;
import ec.edu.ups.util.jpa.search.SearchCondition;
import ec.edu.ups.util.jpa.search.SearchOrder;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.CacheStoreMode;

@Named(value = "orgAreaGeograficaController")
@ViewScoped
public class OrgAreaGeograficaController extends AbstractController<OrgAreaGeografica> {

    private List<OrgAreaGeografica> orgAreaGeograficaPaisList;
    private List<OrgAreaGeografica> orgAreaGeograficaProvinciaList;
    private List<OrgAreaGeografica> orgAreaGeograficaCiudadList;
    private List<OrgAreaGeografica> orgAreaGeograficaParroquiaList;

    private OrgAreaGeografica orgAreaGeograficaPais;
    private OrgAreaGeografica orgAreaGeograficaProvincia;
    private OrgAreaGeografica orgAreaGeograficaCiudad;
    private OrgAreaGeografica orgAreaGeograficaParroquia;

    public OrgAreaGeograficaController() {
        super(OrgAreaGeografica.class);
    }

    public void updatePaisList() {
        //orgAreaGeograficaPais = null;
        orgAreaGeograficaProvincia = null;
        orgAreaGeograficaCiudad = null;
        orgAreaGeograficaParroquia = null;
        orgAreaGeograficaPaisList = getEjbFacade()
                .findRecords(SearchBuilder.create(new DefaultParamSearch("orgTipoAreaGeografica.tagCodigo", TIPO_AREA_PAIS, SearchCondition.EQUAL))
                        .addParam(new CacheStoreModeParam(CacheStoreMode.REFRESH))
                        .addParam(new DefaultParamOrderSearch("argNombre", SearchOrder.ASC)));
        if (orgAreaGeograficaPais == null) {
            orgAreaGeograficaPais = getEjbFacade().find(64L);
        }
        if (orgAreaGeograficaPais != null) {
            updateProvinciaList();
        }
    }

    public void updateProvinciaList() {
        orgAreaGeograficaProvincia = null;
        orgAreaGeograficaCiudad = null;
        orgAreaGeograficaParroquia = null;
        orgAreaGeograficaProvinciaList = null;
        orgAreaGeograficaCiudadList = null;
        orgAreaGeograficaParroquiaList = null;
        if (orgAreaGeograficaPais != null && !orgAreaGeograficaPais.getOrgAreaGeograficaCollection().isEmpty()) {
            for (OrgAreaGeografica orgAreaGeografica : orgAreaGeograficaPais.getOrgAreaGeograficaCollection()) {
                if (!orgAreaGeografica.getOrgAreaGeograficaCollection().isEmpty()) {
                    getOrgAreaGeograficaProvinciaList().addAll(orgAreaGeografica.getOrgAreaGeograficaCollection());
                }
            }
            if (!orgAreaGeograficaProvinciaList.isEmpty()) {
                orgAreaGeograficaProvincia = getOrgAreaGeograficaProvinciaList().get(0);
                updateCiudadList();
            }
        }
    }

    public void updateCiudadList() {
        orgAreaGeograficaCiudadList = null;
        orgAreaGeograficaParroquiaList = null;
        orgAreaGeograficaCiudad = null;
        orgAreaGeograficaParroquia = null;
        if (orgAreaGeograficaProvincia != null && !orgAreaGeograficaProvincia.getOrgAreaGeograficaCollection().isEmpty()) {
            setOrgAreaGeograficaCiudadList(new ArrayList(orgAreaGeograficaProvincia.getOrgAreaGeograficaCollection()));
            if (!orgAreaGeograficaCiudadList.isEmpty() && orgAreaGeograficaCiudadList.size() > 0) {
                if (orgAreaGeograficaPais.getArgCodigo() == 64L && orgAreaGeograficaCiudadList.size() > 1) {
                    orgAreaGeograficaCiudad = getOrgAreaGeograficaCiudadList().get(1);
                } else {
                    orgAreaGeograficaCiudad = getOrgAreaGeograficaCiudadList().get(0);
                }
                updateParroquiaList();
            }
        }
    }

    public void updateParroquiaList() {
        orgAreaGeograficaParroquiaList = null;
        orgAreaGeograficaParroquia = null;
        if (orgAreaGeograficaCiudad != null && !orgAreaGeograficaCiudad.getOrgAreaGeograficaCollection().isEmpty()) {
            setOrgAreaGeograficaParroquiaList(new ArrayList(orgAreaGeograficaCiudad.getOrgAreaGeograficaCollection()));
            if (!orgAreaGeograficaParroquiaList.isEmpty()) {
                orgAreaGeograficaParroquia = getOrgAreaGeograficaParroquiaList().get(0);
            }
        }
    }

    @Override
    public OrgAreaGeografica getSelectedToEdit() {
        if (orgAreaGeograficaParroquia != null) {
            return orgAreaGeograficaParroquia;
        } else if (orgAreaGeograficaCiudad != null) {
            return orgAreaGeograficaCiudad;
        } else if (orgAreaGeograficaProvincia != null) {
            return orgAreaGeograficaProvincia;
        } else {
            return orgAreaGeograficaPais;
        }
    }

    public List<OrgAreaGeografica> getOrgAreaGeograficaPaisList() {
        if (orgAreaGeograficaPaisList == null) {
            updatePaisList();
        }
        return orgAreaGeograficaPaisList;
    }

    public void setOrgAreaGeograficaPaisList(List<OrgAreaGeografica> orgAreaGeograficaPaisList) {
        this.orgAreaGeograficaPaisList = orgAreaGeograficaPaisList;
    }

    public List<OrgAreaGeografica> getOrgAreaGeograficaProvinciaList() {
        if (orgAreaGeograficaProvinciaList == null) {
            orgAreaGeograficaProvinciaList = new ArrayList();
        }
        return orgAreaGeograficaProvinciaList;
    }

    public void setOrgAreaGeograficaProvinciaList(List<OrgAreaGeografica> orgAreaGeograficaProvinciaList) {
        this.orgAreaGeograficaProvinciaList = orgAreaGeograficaProvinciaList;
    }

    public List<OrgAreaGeografica> getOrgAreaGeograficaCiudadList() {
        return orgAreaGeograficaCiudadList;
    }

    public void setOrgAreaGeograficaCiudadList(List<OrgAreaGeografica> orgAreaGeograficaCiudadList) {
        this.orgAreaGeograficaCiudadList = orgAreaGeograficaCiudadList;
    }

    public List<OrgAreaGeografica> getOrgAreaGeograficaParroquiaList() {
        return orgAreaGeograficaParroquiaList;
    }

    public void setOrgAreaGeograficaParroquiaList(List<OrgAreaGeografica> orgAreaGeograficaParroquiaList) {
        this.orgAreaGeograficaParroquiaList = orgAreaGeograficaParroquiaList;
    }

    public OrgAreaGeografica getOrgAreaGeograficaPais() {
        return orgAreaGeograficaPais;
    }

    public void setOrgAreaGeograficaPais(OrgAreaGeografica orgAreaGeograficaPais) {
        this.orgAreaGeograficaPais = orgAreaGeograficaPais;
    }

    public OrgAreaGeografica getOrgAreaGeograficaProvincia() {
        return orgAreaGeograficaProvincia;
    }

    public void setOrgAreaGeograficaProvincia(OrgAreaGeografica orgAreaGeograficaProvincia) {
        this.orgAreaGeograficaProvincia = orgAreaGeograficaProvincia;
        if (orgAreaGeograficaProvincia != null) {
            if (orgAreaGeograficaProvinciaList == null) {
                orgAreaGeograficaProvinciaList = new ArrayList(orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
            }
            if (!orgAreaGeograficaProvinciaList.contains(orgAreaGeograficaProvincia)) {
                orgAreaGeograficaProvinciaList = new ArrayList(orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
            }
            if (orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre() != null) {
                if (orgAreaGeograficaPaisList == null) {
                    updatePaisList();
                }
                orgAreaGeograficaPais = orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaPadre();
            }
        }
    }

    public OrgAreaGeografica getOrgAreaGeograficaCiudad() {
        return orgAreaGeograficaCiudad;
    }

    public void setOrgAreaGeograficaCiudad(OrgAreaGeografica orgAreaGeograficaCiudad) {
        this.orgAreaGeograficaCiudad = orgAreaGeograficaCiudad;
        if (orgAreaGeograficaCiudad != null) {
            if (orgAreaGeograficaCiudadList == null) {
                orgAreaGeograficaCiudadList = new ArrayList(orgAreaGeograficaCiudad.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
            }
            if (!orgAreaGeograficaCiudadList.contains(orgAreaGeograficaCiudad)) {
                orgAreaGeograficaCiudadList = new ArrayList(orgAreaGeograficaCiudad.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
            }
            setOrgAreaGeograficaProvincia(orgAreaGeograficaCiudad.getOrgAreaGeograficaPadre());
        }
    }

    public OrgAreaGeografica getOrgAreaGeograficaParroquia() {
        return orgAreaGeograficaParroquia;
    }

    public void setOrgAreaGeograficaParroquia(OrgAreaGeografica orgAreaGeograficaParroquia) {
        this.orgAreaGeograficaParroquia = orgAreaGeograficaParroquia;
        if (orgAreaGeograficaParroquia != null) {
            if (orgAreaGeograficaParroquiaList == null) {
                orgAreaGeograficaParroquiaList = new ArrayList(orgAreaGeograficaParroquia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
            }
            if (!orgAreaGeograficaParroquiaList.contains(orgAreaGeograficaParroquia)) {
                orgAreaGeograficaParroquiaList = new ArrayList(orgAreaGeograficaParroquia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
            }
            setOrgAreaGeograficaCiudad(orgAreaGeograficaParroquia.getOrgAreaGeograficaPadre());
        }
    }

    @Override
    public void setSelectedToEdit(OrgAreaGeografica orgAreaGeografica) {
        orgAreaGeograficaParroquia = null;
        orgAreaGeograficaCiudad = null;
        orgAreaGeograficaProvincia = null;
        if (orgAreaGeografica.getOrgTipoAreaGeografica().getTagCodigo().equals(5L)) {
            setOrgAreaGeograficaParroquia(orgAreaGeografica);
        } else if (orgAreaGeografica.getOrgTipoAreaGeografica().getTagCodigo().equals(4L)) {
            setOrgAreaGeograficaCiudad(orgAreaGeografica);
        } else if (orgAreaGeografica.getOrgTipoAreaGeografica().getTagCodigo().equals(3L)) {
            setOrgAreaGeograficaProvincia(orgAreaGeografica);
        } else {
            setOrgAreaGeograficaPais(orgAreaGeografica);
        }
    }

}
