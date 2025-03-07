package ec.edu.ups.pos.rep.view.controller.ins;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pos.rep.data.entities.ins.InsAlumno;
import ec.edu.ups.pos.rep.data.entities.sigac.ClienteLocal;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.logic.sessions.ins.InsAlumnoFacade;
import ec.edu.ups.pos.rep.logic.sessions.sigac.ClienteLocalFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

@Named("insAlumnoController")
@ViewScoped
public class InsAlumnoController extends AbstractController<InsAlumno> {

	@Inject
	private InsAlumnoFacade insAlumnoFacade;

	@Inject
	private ClienteLocalFacade clienteLocalFacade;

	private String cedula; // es el campo que posee la identificacion ingresada por el

	// usuario

	private String aluApellido; // sirve para almacenar el nombre con el cual se busca a

	// los estudiantes

	private String tipoDocumento = PosRepConstants.TIPO_DOCUMENTO_DF; // Tipo de documento

	// por defecto
	// cedula

	private ClienteLocal clienteLocalToEdit = new ClienteLocal(); // variable para crear o

	// editar el
	// clienteLocal

	public InsAlumnoController() {
		super(InsAlumno.class);
	}

	@Override
	public InsAlumno prepareCreate(ActionEvent event) {
		this.clienteLocalToEdit = new ClienteLocal();
		return super.prepareCreate(event);
	}

	/**
	 * Limpiar variables de alumno.
	 * @param origen desde donde se está llamando la función.
	 */
	public void limpiarAlumno(String origen) {
		this.cedula = "";
		this.aluApellido = "";
		setSelectedToEdit(null);
	}

	/**
	 * Buscar alumnos por cédula.
	 */
	public void searchByCedulaAlu() {
		searchByCedulaFull(0);
	}

	/**
	 * Buscar alumno por cédula.
	 * @param origen desde donde se está llamando el método.
	 */
	public void searchByCedulaFull(Integer origen) { // Se usa para buscar el alumno en
		// alumno
		this.clienteLocalToEdit = this.clienteLocalFacade.findClienteLocalByCedula(this.cedula);
		InsAlumno insAlumno = super.prepareCreate(null);
		if (this.clienteLocalToEdit != null) {
			InsAlumno insAlumnoTemp = this.insAlumnoFacade.findByCllcCdg(this.clienteLocalToEdit.getCllcCdg());
			if (insAlumnoTemp != null) {
				insAlumno = insAlumnoTemp;
			}
			else {
				insAlumno = setDataAlumno(insAlumno, this.clienteLocalToEdit);
				insAlumno.setCllcCdg(this.clienteLocalToEdit.getCllcCdg());
			}
		}
		setSelectedToEdit(insAlumno);
	}

	/**
	 * Asignar valores consultados a variables de alumno.
	 * @param insAlumno alumno encontrado en ins.
	 * @param clienteLocal persona encontrada en cliente Local sna.
	 * @return alumno con datos modificados
	 */
	public InsAlumno setDataAlumno(InsAlumno insAlumno, ClienteLocal clienteLocal) {
		String[] nombres = clienteLocal.getCllcNmb().split("[\\s]+");
		if (nombres.length == 4) {
			insAlumno.setAluApellidos(nombres[0].concat(" ").concat(nombres[1]));
			insAlumno.setAluNombres(nombres[2].concat(" ").concat(nombres[3]));
		}
		else if (nombres.length == 3) {
			insAlumno.setAluApellidos(nombres[0].concat(" ").concat(nombres[1]));
			insAlumno.setAluNombres(nombres[2]);
		}
		else if (nombres.length == 2) {
			insAlumno.setAluApellidos(nombres[0]);
			insAlumno.setAluNombres(nombres[1]);
		}
		else {
			insAlumno.setAluNombres(nombres[0]);
		}
		return insAlumno;
	}

	@Override
	public void setSelectedToEdit(InsAlumno selectedToEdit) {
		if (selectedToEdit != null) {
			if (selectedToEdit.getCllcCdg() != null) {
				ClienteLocal clienteLocal = this.clienteLocalFacade.find(selectedToEdit.getCllcCdg());
				if (clienteLocal.getCllcRuc() != null) {
					this.cedula = clienteLocal.getCllcRuc();
				}
			}
		}
		super.setSelectedToEdit(selectedToEdit);
	}

	public void filtrarAlumno(String value) {
		if (value != null && !value.isEmpty()) {
			if (!value.equals(getAluApellido())) {
				super.setItemsFilter(((InsAlumnoFacade) getEjbFacade()).findByNombre(value));
			}
		}
		else {
			super.setItemsFilter(null);
		}
		setAluApellido(value);
	}

	public ClienteLocal buscarClienteLocal(Object cllcCdg) {
		if (cllcCdg == null || !(cllcCdg instanceof Long)) {
			return null;
		}
		return this.clienteLocalFacade.find(cllcCdg);
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getAluApellido() {
		return this.aluApellido;
	}

	public void setAluApellido(String aluApellido) {
		this.aluApellido = aluApellido;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public ClienteLocal getClienteLocalToEdit() {
		return this.clienteLocalToEdit;
	}

	public void setClienteLocalToEdit(ClienteLocal clienteLocalToEdit) {
		this.clienteLocalToEdit = clienteLocalToEdit;
	}

}
