package ec.edu.ups.pos.rep.view.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pos.rep.data.entities.rep.RepLog;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepLogFacade;
import ec.edu.ups.pos.rep.view.controller.rep.RepReportesSistemaController;

/**
 * Description. Optimized version of PosRepLogController.
 *
 * @author UPS .
 */
@Named("posRepLogController")
@RequestScoped // O cambiar a @ViewScoped si se necesita persistencia en la vista
public class PosRepLogController extends AbstractController<RepLog> {

	@Inject
	private RepLogFacade repLogFacade;

	@Inject
	private RepReportesSistemaController repReportesSistemaController;

	private RepLog repLog;

	private StringBuilder parameters;

	@PostConstruct
	public void init() {
		prepareCreate(null);
	}

	public RepLog getRepLog() {
		return this.repLog;
	}

	public void setRepLog(RepLog repLog) {
		this.repLog = repLog;
	}

	public PosRepLogController() {
		super(RepLog.class);
		this.repLog = new RepLog();
		this.parameters = new StringBuilder();
	}

	@Override
	public RepLog prepareCreate(ActionEvent event) {
		this.repLog = new RepLog();
		this.parameters = new StringBuilder(); // Asegura reinicialización
		return super.prepareCreate(event);
	}

	@Override
	public void saveNew(ActionEvent event) {
		if (this.repReportesSistemaController.getSelected() != null) {
			this.repLog.setResCodigo(this.repReportesSistemaController.getSelected().getResCodigo().toString());
		}
		else {
			throw new IllegalStateException("No hay un reporte seleccionado.");
		}

		this.repLog.setLogParametro(this.parameters.toString());
		this.repLog.setLogCodigo(this.repLogFacade.findSequence());
		this.setSelectedToEdit(this.repLog);
		super.saveNew(event);
	}

	public void appendParametro(String nombreParametro, Object valor) {
		if (valor != null) {
			this.parameters.append(" (").append(nombreParametro).append("): ").append(valor.toString()).append("; ");
		}
	}

}
