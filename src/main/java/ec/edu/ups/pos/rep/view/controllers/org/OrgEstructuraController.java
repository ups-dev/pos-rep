package ec.edu.ups.pos.rep.view.controllers.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.jsf.security.ups.web.session.SecOrgEstructuraController;
import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.logic.sessions.org.OrgEstructuraFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

@Named("orgEstructuraController")
@ViewScoped
public class OrgEstructuraController extends AbstractController<OrgEstructura> {

	@Inject
	private OrgEstructuraFacade orgEstructuraFacade;

	private List<OrgEstructura> orgEstructuraSedeList;

	private List<OrgEstructura> orgEstructuraCampusList;

	private List<OrgEstructura> orgEstructuraCarreraList;

	private List<OrgEstructura> orgEstructuraList;

	private OrgEstructura orgEstructuraSede;

	private OrgEstructura orgEstructuraCampus;

	private OrgEstructura orgEstructuraCarrera;

	private OrgEstructura orgEstructura;

	@Inject
	private SecOrgEstructuraController secOrgEstructuraController;

	public OrgEstructuraController() {
		super(OrgEstructura.class);
	}

	public void updateSedeList() {
		if (this.secOrgEstructuraController.getEstructuraSede().getEstCodigo().equals(PosRepConstants.TODAS_SEDES)) {
			// Utilizar el método creado en la fachada para obtener los registros
			this.orgEstructuraSedeList = getEjbFacade().findRecordsByParentCode(String.valueOf(PosRepConstants.CERO));
		}
		else {
			// Obtener una única sede basándose en el código de estructura
			setOrgEstructuraSedeList(Arrays.asList(
					this.orgEstructuraFacade.find(this.secOrgEstructuraController.getEstructuraSede().getEstCodigo())));
		}
		// setOrgEstructuraSede(getOrgEstructuraSedeList().get(0));
		updateCampusList();
	}

	public void updateCampusList() {
		if (this.orgEstructuraSede != null && !this.orgEstructuraSede.getOrgEstructuraCollection().isEmpty()) {
			setOrgEstructuraCampusList(new ArrayList<>(this.orgEstructuraSede.getOrgEstructuraCollection()));
			if (!this.secOrgEstructuraController.getEstructuraCampus()
				.getEstCodigo()
				.equals(PosRepConstants.TODOS_CAMPUS)) {
				getOrgEstructuraCampusList()
					.retainAll(Arrays.asList(this.secOrgEstructuraController.getEstructuraCampus()));
			}
			// setOrgEstructuraCampus(getOrgEstructuraCampusList().get(0));
			updateCarreraList();
		}
	}

	public void updateCarreraList() {
		if (this.orgEstructuraCampus != null && !this.orgEstructuraCampus.getOrgEstructuraCollection().isEmpty()) {
			setOrgEstructuraCarreraList(new ArrayList<>(this.orgEstructuraCampus.getOrgEstructuraCollection()));
			if (!this.secOrgEstructuraController.getEstructuraCarrera()
				.getEstCodigo()
				.equals(PosRepConstants.TODAS_CARRERAS)) {
				getOrgEstructuraCarreraList()
					.retainAll(Arrays.asList(this.secOrgEstructuraController.getEstructuraCarrera()));
			}
			// setOrgEstructuraCarrera(getOrgEstructuraCarreraList().get(0));
		}
	}

	@Override
	public OrgEstructura getSelectedToEdit() {
		if (this.orgEstructuraCarrera != null) {
			return this.orgEstructuraCarrera;
		}
		else if (this.orgEstructuraCampus != null) {
			return this.orgEstructuraCampus;
		}
		else if (this.orgEstructuraSede != null) {
			return this.orgEstructuraSede;
		}
		else {
			return getEjbFacade().find(PosRepConstants.CERO);
		}
	}

	public List<OrgEstructura> getOrgEstructuraSedeList() {
		if (this.orgEstructuraSedeList == null) {
			updateSedeList();
		}
		return this.orgEstructuraSedeList;
	}

	public void setOrgEstructuraSedeList(List<OrgEstructura> orgEstructuraSedeList) {
		this.orgEstructuraSedeList = orgEstructuraSedeList;
	}

	public List<OrgEstructura> getOrgEstructuraCampusList() {
		return this.orgEstructuraCampusList;
	}

	public void setOrgEstructuraCampusList(List<OrgEstructura> orgEstructuraCampusList) {
		this.orgEstructuraCampusList = orgEstructuraCampusList;
	}

	public List<OrgEstructura> getOrgEstructuraCarreraList() {
		return this.orgEstructuraCarreraList;
	}

	public void setOrgEstructuraCarreraList(List<OrgEstructura> orgEstructuraCarreraList) {
		this.orgEstructuraCarreraList = orgEstructuraCarreraList;
	}

	public OrgEstructura getOrgEstructuraSede() {
		return this.orgEstructuraSede;
	}

	public void setOrgEstructuraSede(OrgEstructura orgEstructuraSede) {
		if (this.orgEstructuraSedeList == null) {
			this.orgEstructuraSedeList = new ArrayList<>(
					this.orgEstructuraSede.getOrgEstructuraPadre().getOrgEstructuraCollection());
		}
		if (this.orgEstructuraSede == null) {
			this.orgEstructuraCampusList = new ArrayList<>();
			setOrgEstructuraCampus(null);
		}
		this.orgEstructuraSede = orgEstructuraSede;
	}

	public OrgEstructura getOrgEstructuraCampus() {
		return this.orgEstructuraCampus;
	}

	public void setOrgEstructuraCampus(OrgEstructura orgEstructuraCampus) {
		if (this.orgEstructuraCampus != null) {
			if (this.orgEstructuraCampusList == null) {
				this.orgEstructuraCampusList = new ArrayList<>(
						orgEstructuraCampus.getOrgEstructuraPadre().getOrgEstructuraCollection());
			}
			else if (!this.orgEstructuraCampusList.contains(orgEstructuraCampus)) {
				this.orgEstructuraCampusList = new ArrayList<>(
						this.orgEstructuraCampus.getOrgEstructuraPadre().getOrgEstructuraCollection());
			}
			setOrgEstructuraSede(this.orgEstructuraCampus.getOrgEstructuraPadre());
		}
		else {
			this.orgEstructuraCarreraList = new ArrayList<>();
			setOrgEstructuraCarrera(null);
		}
		this.orgEstructuraCampus = orgEstructuraCampus;
	}

	public OrgEstructura getOrgEstructuraCarrera() {
		return this.orgEstructuraCarrera;
	}

	public void setOrgEstructuraCarrera(OrgEstructura orgEstructuraCarrera) {
		if (this.orgEstructuraCarrera != null) {
			if (this.orgEstructuraCarreraList == null) {
				this.orgEstructuraCarreraList = new ArrayList<>(
						this.orgEstructuraCarrera.getOrgEstructuraPadre().getOrgEstructuraCollection());
			}
			if (!this.orgEstructuraCarreraList.contains(this.orgEstructuraCarrera)) {
				this.orgEstructuraCarreraList = new ArrayList<>(
						orgEstructuraCarrera.getOrgEstructuraPadre().getOrgEstructuraCollection());
			}
			setOrgEstructuraCampus(this.orgEstructuraCarrera.getOrgEstructuraPadre());
		}
		this.orgEstructuraCarrera = orgEstructuraCarrera;
	}

	@Override
	public void setSelectedToEdit(OrgEstructura orgEstructura) {
		this.orgEstructuraCarrera = null;
		this.orgEstructuraCampus = null;
		this.orgEstructuraSede = null;
		if (orgEstructura.getOrgDescripcionEstructura().getOrgTipoEstructura().getTieCodigo().equals(5L)) {
			setOrgEstructuraCarrera(orgEstructura);
		}
		else if (orgEstructura.getOrgDescripcionEstructura().getOrgTipoEstructura().getTieCodigo().equals(3L)) {
			setOrgEstructuraCampus(orgEstructura);
		}
		else if (orgEstructura.getOrgDescripcionEstructura().getOrgTipoEstructura().getTieCodigo().equals(2L)) {
			setOrgEstructuraSede(orgEstructura);
		}
	}

	public List<OrgEstructura> getOrgEstructuraList() {
		return this.orgEstructuraList;
	}

	public void setOrgEstructuraList(List<OrgEstructura> orgEstructuraList) {
		this.orgEstructuraList = orgEstructuraList;
	}

	public OrgEstructura getOrgEstructura() {
		return this.orgEstructura;
	}

	public void setOrgEstructura(OrgEstructura orgEstructura) {
		this.orgEstructura = orgEstructura;
	}

}
