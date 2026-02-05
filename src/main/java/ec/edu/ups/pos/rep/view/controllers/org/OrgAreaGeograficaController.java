package ec.edu.ups.pos.rep.view.controllers.org;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.edu.ups.pos.rep.data.entities.org.OrgAreaGeografica;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

@Named("orgAreaGeograficaController")
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
		// orgAreaGeograficaPais = null;
		this.orgAreaGeograficaProvincia = null;
		this.orgAreaGeograficaCiudad = null;
		this.orgAreaGeograficaParroquia = null;
		this.orgAreaGeograficaPaisList = getEjbFacade()
			.findRecordsByTipoAreaGeografica(String.valueOf(PosRepConstants.TIPO_AREA_PAIS));
		if (this.orgAreaGeograficaPais == null) {
			this.orgAreaGeograficaPais = getEjbFacade().find(64L);
		}
		if (this.orgAreaGeograficaPais != null) {
			updateProvinciaList();
		}
	}

	public void updateProvinciaList() {
		this.orgAreaGeograficaProvincia = null;
		this.orgAreaGeograficaCiudad = null;
		this.orgAreaGeograficaParroquia = null;
		this.orgAreaGeograficaProvinciaList = null;
		this.orgAreaGeograficaCiudadList = null;
		this.orgAreaGeograficaParroquiaList = null;
		if (this.orgAreaGeograficaPais != null
				&& !this.orgAreaGeograficaPais.getOrgAreaGeograficaCollection().isEmpty()) {
			for (OrgAreaGeografica orgAreaGeografica : this.orgAreaGeograficaPais.getOrgAreaGeograficaCollection()) {
				if (!orgAreaGeografica.getOrgAreaGeograficaCollection().isEmpty()) {
					getOrgAreaGeograficaProvinciaList().addAll(orgAreaGeografica.getOrgAreaGeograficaCollection());
				}
			}
			if (!this.orgAreaGeograficaProvinciaList.isEmpty()) {
				this.orgAreaGeograficaProvincia = getOrgAreaGeograficaProvinciaList().get(0);
				updateCiudadList();
			}
		}
	}

	public void updateCiudadList() {
		this.orgAreaGeograficaCiudadList = null;
		this.orgAreaGeograficaParroquiaList = null;
		this.orgAreaGeograficaCiudad = null;
		this.orgAreaGeograficaParroquia = null;
		if (this.orgAreaGeograficaProvincia != null
				&& !this.orgAreaGeograficaProvincia.getOrgAreaGeograficaCollection().isEmpty()) {
			setOrgAreaGeograficaCiudadList(
					new ArrayList<>(this.orgAreaGeograficaProvincia.getOrgAreaGeograficaCollection()));
			if (!this.orgAreaGeograficaCiudadList.isEmpty() && this.orgAreaGeograficaCiudadList.size() > 0) {
				if (this.orgAreaGeograficaPais.getArgCodigo() == 64L && this.orgAreaGeograficaCiudadList.size() > 1) {
					this.orgAreaGeograficaCiudad = getOrgAreaGeograficaCiudadList().get(1);
				}
				else {
					this.orgAreaGeograficaCiudad = getOrgAreaGeograficaCiudadList().get(0);
				}
				updateParroquiaList();
			}
		}
	}

	public void updateParroquiaList() {
		this.orgAreaGeograficaParroquiaList = null;
		this.orgAreaGeograficaParroquia = null;
		if (this.orgAreaGeograficaCiudad != null
				&& !this.orgAreaGeograficaCiudad.getOrgAreaGeograficaCollection().isEmpty()) {
			setOrgAreaGeograficaParroquiaList(
					new ArrayList<>(this.orgAreaGeograficaCiudad.getOrgAreaGeograficaCollection()));
			if (!this.orgAreaGeograficaParroquiaList.isEmpty()) {
				this.orgAreaGeograficaParroquia = getOrgAreaGeograficaParroquiaList().get(0);
			}
		}
	}

	@Override
	public OrgAreaGeografica getSelectedToEdit() {
		if (this.orgAreaGeograficaParroquia != null) {
			return this.orgAreaGeograficaParroquia;
		}
		else if (this.orgAreaGeograficaCiudad != null) {
			return this.orgAreaGeograficaCiudad;
		}
		else if (this.orgAreaGeograficaProvincia != null) {
			return this.orgAreaGeograficaProvincia;
		}
		else {
			return this.orgAreaGeograficaPais;
		}
	}

	public List<OrgAreaGeografica> getOrgAreaGeograficaPaisList() {
		if (this.orgAreaGeograficaPaisList == null) {
			updatePaisList();
		}
		return this.orgAreaGeograficaPaisList;
	}

	public void setOrgAreaGeograficaPaisList(List<OrgAreaGeografica> orgAreaGeograficaPaisList) {
		this.orgAreaGeograficaPaisList = orgAreaGeograficaPaisList;
	}

	public List<OrgAreaGeografica> getOrgAreaGeograficaProvinciaList() {
		if (this.orgAreaGeograficaProvinciaList == null) {
			this.orgAreaGeograficaProvinciaList = new ArrayList<>();
		}
		return this.orgAreaGeograficaProvinciaList;
	}

	public void setOrgAreaGeograficaProvinciaList(List<OrgAreaGeografica> orgAreaGeograficaProvinciaList) {
		this.orgAreaGeograficaProvinciaList = orgAreaGeograficaProvinciaList;
	}

	public List<OrgAreaGeografica> getOrgAreaGeograficaCiudadList() {
		return this.orgAreaGeograficaCiudadList;
	}

	public void setOrgAreaGeograficaCiudadList(List<OrgAreaGeografica> orgAreaGeograficaCiudadList) {
		this.orgAreaGeograficaCiudadList = orgAreaGeograficaCiudadList;
	}

	public List<OrgAreaGeografica> getOrgAreaGeograficaParroquiaList() {
		return this.orgAreaGeograficaParroquiaList;
	}

	public void setOrgAreaGeograficaParroquiaList(List<OrgAreaGeografica> orgAreaGeograficaParroquiaList) {
		this.orgAreaGeograficaParroquiaList = orgAreaGeograficaParroquiaList;
	}

	public OrgAreaGeografica getOrgAreaGeograficaPais() {
		return this.orgAreaGeograficaPais;
	}

	public void setOrgAreaGeograficaPais(OrgAreaGeografica orgAreaGeograficaPais) {
		this.orgAreaGeograficaPais = orgAreaGeograficaPais;
	}

	public OrgAreaGeografica getOrgAreaGeograficaProvincia() {
		return this.orgAreaGeograficaProvincia;
	}

	public void setOrgAreaGeograficaProvincia(OrgAreaGeografica orgAreaGeograficaProvincia) {
		this.orgAreaGeograficaProvincia = orgAreaGeograficaProvincia;
		if (this.orgAreaGeograficaProvincia != null) {
			if (this.orgAreaGeograficaProvinciaList == null) {
				this.orgAreaGeograficaProvinciaList = new ArrayList<>(
						this.orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
			}
			if (!this.orgAreaGeograficaProvinciaList.contains(orgAreaGeograficaProvincia)) {
				this.orgAreaGeograficaProvinciaList = new ArrayList<>(
						this.orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
			}
			if (this.orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre() != null) {
				if (this.orgAreaGeograficaPaisList == null) {
					updatePaisList();
				}
				this.orgAreaGeograficaPais = this.orgAreaGeograficaProvincia.getOrgAreaGeograficaPadre()
					.getOrgAreaGeograficaPadre();
			}
		}
	}

	public OrgAreaGeografica getOrgAreaGeograficaCiudad() {
		return this.orgAreaGeograficaCiudad;
	}

	public void setOrgAreaGeograficaCiudad(OrgAreaGeografica orgAreaGeograficaCiudad) {
		this.orgAreaGeograficaCiudad = orgAreaGeograficaCiudad;
		if (this.orgAreaGeograficaCiudad != null) {
			if (this.orgAreaGeograficaCiudadList == null) {
				this.orgAreaGeograficaCiudadList = new ArrayList<>(
						this.orgAreaGeograficaCiudad.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
			}
			if (!this.orgAreaGeograficaCiudadList.contains(this.orgAreaGeograficaCiudad)) {
				this.orgAreaGeograficaCiudadList = new ArrayList<>(
						this.orgAreaGeograficaCiudad.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
			}
			setOrgAreaGeograficaProvincia(this.orgAreaGeograficaCiudad.getOrgAreaGeograficaPadre());
		}
	}

	public OrgAreaGeografica getOrgAreaGeograficaParroquia() {
		return this.orgAreaGeograficaParroquia;
	}

	public void setOrgAreaGeograficaParroquia(OrgAreaGeografica orgAreaGeograficaParroquia) {
		this.orgAreaGeograficaParroquia = orgAreaGeograficaParroquia;
		if (this.orgAreaGeograficaParroquia != null) {
			if (this.orgAreaGeograficaParroquiaList == null) {
				this.orgAreaGeograficaParroquiaList = new ArrayList<>(
						this.orgAreaGeograficaParroquia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
			}
			if (!this.orgAreaGeograficaParroquiaList.contains(this.orgAreaGeograficaParroquia)) {
				this.orgAreaGeograficaParroquiaList = new ArrayList<>(
						this.orgAreaGeograficaParroquia.getOrgAreaGeograficaPadre().getOrgAreaGeograficaCollection());
			}
			setOrgAreaGeograficaCiudad(orgAreaGeograficaParroquia.getOrgAreaGeograficaPadre());
		}
	}

	@Override
	public void setSelectedToEdit(OrgAreaGeografica orgAreaGeografica) {
		this.orgAreaGeograficaParroquia = null;
		this.orgAreaGeograficaCiudad = null;
		this.orgAreaGeograficaProvincia = null;
		if (orgAreaGeografica.getOrgTipoAreaGeografica().getTagCodigo().equals(5L)) {
			setOrgAreaGeograficaParroquia(orgAreaGeografica);
		}
		else if (orgAreaGeografica.getOrgTipoAreaGeografica().getTagCodigo().equals(4L)) {
			setOrgAreaGeograficaCiudad(orgAreaGeografica);
		}
		else if (orgAreaGeografica.getOrgTipoAreaGeografica().getTagCodigo().equals(3L)) {
			setOrgAreaGeograficaProvincia(orgAreaGeografica);
		}
		else {
			setOrgAreaGeograficaPais(orgAreaGeografica);
		}
	}

}
