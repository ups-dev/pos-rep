package ec.edu.ups.pos.rep.view.controllers;

import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.pos.rep.view.controllers.util.JsfUtil;
import ec.edu.ups.pos.rep.view.controllers.util.ViewMode;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import java.util.ResourceBundle;
import ec.edu.ups.util.helpers.IStateHelper;
import ec.edu.ups.util.helpers.DefaultStateHelper;
import ec.edu.ups.util.jpa.search.builder.ParamBuilder;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import ec.edu.ups.util.jsf.JSFUtils;
import javax.ejb.EJBException;
import javax.persistence.CacheStoreMode;
import org.primefaces.context.RequestContext;

/**
 * Clase abstracta usada por las vistas que componen una aplicaciÃ³n.
 *
 * @param <T> indica la Entidad que va a manipular el controller.
 */
public abstract class AbstractController<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AbstractFacade<T> ejbFacade;
    private Class<T> itemClass;
    private T selected;
    private T selectedToEdit;
    private List<T> items;
    private List<T> itemsFilter;
    private List<T> itemsNotDisabled;
    private boolean refreshCache = false;
    private boolean searchActivated;
    private IStateHelper stateHelperSearch;
    private IStateHelper stateHelperFilter;
    private transient ResourceBundle resourceBundle;
    //---- Interfaz
    private ViewMode viewMode = ViewMode.LIST;

    protected enum PersistAction {

        CREATE,
        DELETE,
        UPDATE,
        ACTIVATE,
        DEACTIVATE
    }

    public AbstractController() {
    }

    public AbstractController(Class<T> itemClass) {
        this.itemClass = itemClass;
    }

    public AbstractFacade<T> getEjbFacade() {
        return ejbFacade;
    }

    /**
     * Devuelve el registro seleccionado.
     *
     * @return el valor seleccionado de la lista.
     */
    public T getSelected() {
        return selected;
    }

    /**
     * Setea el registro seleccionado.
     *
     * @param selected Es el registro que estÃ¡ seleccionado de la lista.
     */
    public void setSelected(T selected) {
        this.selected = selected;
    }

    /**
     * Devuelve el registro seleccionado, usado para la ediciÃ³n.
     *
     * @return el valor seleccionado para ediciÃ³n.
     */
    public T getSelectedToEdit() {
        return selectedToEdit;
    }

    /**
     * Setea el registro seleccionado, usado para la ediciÃ³n.
     *
     * @param selectedToEdit Indica el valor seleccionado para ediciÃ³n.
     */
    public void setSelectedToEdit(T selectedToEdit) {
        this.selectedToEdit = selectedToEdit;
    }

    protected void setEmbeddableKeys() {
        // Nothing to do if entity does not have any embeddable key.
    }

    protected void initializeEmbeddableKey() {
        // Nothing to do if entity does not have any embeddable key.
    }

    /**
     * Realiza la bÃºsqueda de los registros.
     *
     * @return la lista de items encontrados.
     */
    protected List<T> findItems() {
        if (isRefreshCache()) {
            return ejbFacade.findRecords(
                    ParamBuilder.create(new CacheStoreModeParam(CacheStoreMode.REFRESH)).get());
        }

        return ejbFacade.findRecords();
    }

    /**
     * Devuelve todos los registros, para modificar la bÃºsqueda se recomienda
     * sobreescribir el mÃ©todo findItems().
     *
     * @return la lista de registros.
     */
    public List<T> getItems() {
        if (items == null) {
            setItems(findItems());
            //Verifica si ya existia un item seleccionado y lo actualiza para evitar inconsistencias
            if (getSelected() != null) {
                if (!items.contains(getSelected())) {
                    setSelected(null);
                } else {
                    setSelected(this.ejbFacade.find(this.ejbFacade.getIdentifier(getSelected())));
                }
            }
            setRefreshCache(false);
        }
        return items;
    }

    /**
     * Setea la lista de registros.
     *
     * @param items Lista de registros.
     */
    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItemsFilter() {
        return itemsFilter;
    }

    public void setItemsFilter(List<T> itemsFilter) {
        this.itemsFilter = itemsFilter;
    }

    public List<T> getItemsNotDisabled() {
        if (isRefreshCache()) {
            itemsNotDisabled = ejbFacade.findRecordsNoDisabled(ParamBuilder.create(new CacheStoreModeParam(CacheStoreMode.REFRESH)).get());
            setRefreshCache(false);
        }

        if (itemsNotDisabled == null) {
            itemsNotDisabled = ejbFacade.findRecordsNoDisabled();
        }

        return itemsNotDisabled;
    }

    public void setItemsNotDisabled(List<T> itemsNotDisabled) {
        this.itemsNotDisabled = itemsNotDisabled;
    }

    public boolean isRefreshCache() {
        return refreshCache;
    }

    public void setRefreshCache(boolean refreshCache) {
        this.refreshCache = refreshCache;
    }

    /**
     * Nos devuelve el valor que indica si se debe o no mostrar el panel de
     * bÃºsqueda avanzada.
     *
     * @return {@code true} si el panel de bÃºsqueda avanzada esta activado, caso
     * contrario {@code false}.
     */
    public boolean isSearchActivated() {
        return searchActivated;
    }

    /**
     * Setea el valor que indica si se debe o no mostrar el panel de bÃºsqueda
     * avanzada.
     *
     * @param searchActivated Indica el estado del panel de bÃºsqueda avanzada.
     */
    public void setSearchActivated(boolean searchActivated) {
        this.searchActivated = searchActivated;
    }

    /**
     * Devuelve un objeto utilitario para almacenar los valores de los campos de
     * bÃºsqueda avanzada.
     *
     * @return un IStateHelper que permite almacenar los estados de los
     * componentes de bÃºsqueda.
     */
    protected IStateHelper getStateHelperSearch() {
        if (stateHelperSearch == null) {
            stateHelperSearch = new DefaultStateHelper();
        }
        return stateHelperSearch;
    }

    /**
     * Setea un objeto utilitario para almacenar los valores de los campos de
     * bÃºsqueda avanzada.
     *
     * @param stateHelper Instancia de IStateHelper para almacenar los estados
     * de los componentes de bÃºsqueda.
     */
    protected void setStateHelperSearch(IStateHelper stateHelper) {
        this.stateHelperSearch = stateHelper;
    }

    /**
     * Devuelve un objeto utilitario para almacenar los valores de los filtros.
     *
     * @return un IStateHelper que permite almacenar los estados de los
     * componentes usados como filtros.
     */
    protected IStateHelper getStateHelperFilter() {
        if (stateHelperFilter == null) {
            stateHelperFilter = new DefaultStateHelper();
        }
        return stateHelperFilter;
    }

    /**
     * Setea un objeto utilitario para almacenar los valores de los filtros.
     *
     * @param stateHelper Instancia de IStateHelper para almacenar los estados
     * de los componentes usados como filtros.
     */
    protected void setStateHelperFilter(IStateHelper stateHelper) {
        this.stateHelperFilter = stateHelper;
    }

    /**
     * Devuelve el archivo de recursos por defecto para la aplicaciÃ³n.
     *
     * @return un ResourceBundle que permite tener acceso al archivo Bundle de
     * la aplicaciÃ³n.
     */
    public ResourceBundle getResourceBundle() {
        if (resourceBundle == null) {
            resourceBundle = JSFUtils.getResourceBundle("/SbeRepBundle");
        }

        return resourceBundle;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }

    public void setViewMode(ViewMode viewMode) {
        this.viewMode = viewMode;
    }

    /**
     * Devuelve el objeto usado por PrimeFaces con opciones para poder modificar
     * la respuesta de una solicitud.
     *
     * @return un RequestContext que permite tener acceso a operaciones de
     * PrimeFaces para solicitudes ajax.
     */
    public RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }

    /**
     * Actualiza la lista de registros.
     */
    public void updateList() {
        setItems(null);
        setItemsFilter(null);
        setSelected(null);
        setSelectedToEdit(null);
    }

    /**
     * Actualiza la lista de registros de la base de datos.
     */
    public void updateListFromDB() {
        updateList();
        setRefreshCache(true);
    }

    /**
     * Reliza la bÃºsqueda de registros, segÃºn los campos del panel de bÃºsqueda
     * avanzada.
     */
    public void searchRecord() {
        updateList();
    }

    /**
     * Resetea o limpia una bÃºsqueda.
     */
    public void resetSearch() {
        setStateHelperSearch(null);
        searchRecord();
    }

    /**
     * Guarda el nuevo registro en la base de datos.
     *
     * @param event evento ActionEvent generado por el componente.
     */
    public void saveNew(ActionEvent event) {
        persistRunnable(PersistAction.CREATE, null, new Runnable() {
            @Override
            public void run() {
                ejbFacade.createRecord(getSelectedToEdit());
            }
        });
    }

    /**
     * Aplica los cambios hechos a un registro en la base datos.
     *
     * @param event evento ActionEvent generado por el componente.
     */
    public void save(ActionEvent event) {
        persistRunnable(PersistAction.UPDATE, null, new Runnable() {
            @Override
            public void run() {
                ejbFacade.editRecord(getSelectedToEdit());
            }
        });
    }

    /**
     * Elimina fÃ­sicamente un registro de la base de datos.
     *
     * @param event evento ActionEvent generado por el componente.
     */
    public void delete(ActionEvent event) {
        persistRunnable(PersistAction.DELETE, null, new Runnable() {
            @Override
            public void run() {
                ejbFacade.removeRecord(getSelected());
            }
        });
    }

    /**
     * Desactiva (eliminado lÃ³gico) el registro seleccionado.
     *
     */
    public void blockRecord() {
        persistRunnable(PersistAction.DEACTIVATE, null, new Runnable() {
            @Override
            public void run() {
                ejbFacade.disableRecord(getSelected());
            }
        });
    }

    /**
     * Activa el registro seleccionado.
     *
     */
    public void unblockRecord() {
        persistRunnable(PersistAction.ACTIVATE, null, new Runnable() {
            @Override
            public void run() {
                ejbFacade.enableRecord(getSelected());
            }
        });
    }

    protected void persistRunnable(PersistAction persistAction, String successMessage, Runnable runnable) {
        this.setEmbeddableKeys();

        try {
            runnable.run();

            String msg = null;
            switch (persistAction) {
                case CREATE:
                    msg = getResourceBundle().getString(itemClass.getSimpleName() + "Created");
                    break;
                case UPDATE:
                    msg = getResourceBundle().getString(itemClass.getSimpleName() + "Updated");
                    break;
                case DELETE:
                    msg = getResourceBundle().getString(itemClass.getSimpleName() + "Deleted");

                    setSelected(null);
                    setSelectedToEdit(null);
                    break;
                case DEACTIVATE:
                    msg = getResourceBundle().getString(itemClass.getSimpleName() + "Disabled");
                    break;
                case ACTIVATE:
                    msg = getResourceBundle().getString(itemClass.getSimpleName() + "Enabled");
                    break;
            }

            JsfUtil.addSuccessMessage(successMessage == null ? msg : successMessage);
            setItems(null);
            setItemsFilter(null);
        } catch (EJBException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "EJBException", ex);
            JsfUtil.addErrorMessage(ex, getResourceBundle().getString("PersistenceErrorOccured"));
        }
    }

    /**
     * Crea una nueva instancia de la entidad y la asigna a la propiedad
     * selectedToEdit.
     *
     * @param event evento ActionEvent generado por el componente.
     * @return el objeto creado.
     */
    public T prepareCreate(ActionEvent event) {
        T newItem;
        try {
            newItem = itemClass.newInstance();
            setSelectedToEdit(newItem);
            initializeEmbeddableKey();
            setViewMode(ViewMode.CREATE);
            return newItem;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Verifica la propiedad selected y la asigna a selectedToEdit, si no es
     * {@code null} actualiza la entidad de la base de datos antes de realizar
     * la asignaciÃ³n.
     *
     * @param event evento ActionEvent generado por el componente.
     * @return un valor para realizar navegaciÃ³n en llamadas desde la propiedad
     * action.
     */
    public String prepareEdit(ActionEvent event) {
        if (getSelected() == null) {
            setSelectedToEdit(null);
        } else {
            setSelectedToEdit(this.ejbFacade.find(this.ejbFacade.getIdentifier(getSelected())));
        }
        setViewMode(ViewMode.EDIT);
        return null;
    }

    /**
     * Verifica la propiedad selected y la asigna a selectedToEdit, si no es
     * {@code null} actualiza la entidad de la base de datos antes de realizar
     * la asignaciÃ³n.
     *
     * @return un valor para realizar navegaciÃ³n en llamadas desde la propiedad
     * action.
     */
    public String prepareView() {
        if (getSelected() == null) {
            setSelectedToEdit(null);
        } else {
            setSelectedToEdit(ejbFacade.find(ejbFacade.getIdentifier(getSelected())));
        }
        setViewMode(ViewMode.VIEW);
        return null;
    }

    public String getSimpleName() {
        return itemClass.getSimpleName();
    }

}
