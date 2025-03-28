package ec.edu.ups.pos.rep.view.controller.rep;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pos.rep.data.entities.rep.RepSecretarioGeneral;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepSecretarioGeneralFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

/**
 * Description.
 *
 * @author UPS .
 */
@Named("repSecretarioGeneralController")
@ViewScoped
public class RepSecretarioGeneralController extends AbstractController<RepSecretarioGeneral> {

	@Inject
	private RepSecretarioGeneralFacade repSecretarioGeneralFacade;

	private List<RepSecretarioGeneral> listadoSecretariaGeneral;

	private RepSecretarioGeneral secretarioSeleccionado;

	public RepSecretarioGeneralController() {
		super(RepSecretarioGeneral.class);
	}

	public void obtenerListSecretariaCert() {

		this.listadoSecretariaGeneral = this.repSecretarioGeneralFacade.obtieneSecretarioGeneral();
		// System.out.println("Cargando Lista Secretaria General");

	}

	public List<RepSecretarioGeneral> getListadoSecretariaGeneral() {
		return this.listadoSecretariaGeneral;
	}

	public void setListadoSecretariaGeneral(List<RepSecretarioGeneral> listadoSecretariaGeneral) {
		this.listadoSecretariaGeneral = listadoSecretariaGeneral;
	}

	public RepSecretarioGeneral getSecretarioSeleccionado() {
		return this.secretarioSeleccionado;
	}

	public void setSecretarioSeleccionado(RepSecretarioGeneral secretarioSeleccionado) {
		this.secretarioSeleccionado = secretarioSeleccionado;
	}

}
