package ec.edu.ups.pos.rep.view.controller.rep;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.primefaces.PrimeFaces;

import ec.edu.ups.pos.rep.data.entities.aseg.AsegRol;
import ec.edu.ups.pos.rep.data.entities.rep.RepReporteRol;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.logic.sessions.aseg.AsegRolFacade;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepReporteRolFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;
import ec.edu.ups.pos.rep.view.controllers.PosRepGestorArchivosController;

@Named("posRepReporteRolController")
@ViewScoped
public class PosRepReporteRolController extends AbstractController<RepReporteRol> {

	private List<AsegRol> asegRolList;

	private List<AsegRol> allRol;

	private List<AsegRol> filterAsegRolList;

	private AsegRol manageSelectedRol;

	private RepReporteRol repReporteRol;

	@Inject
	private AsegRolFacade asegRolFacade;

	@Inject
	private PosRepGestorArchivosController posRepGestorArchivosController;

	@Inject
	private RepReporteRolFacade repReporteRolFacade;

	public PosRepReporteRolController() {
		super(RepReporteRol.class);
		this.repReporteRol = new RepReporteRol();
	}

	public List<AsegRol> getAsegRolList() {
		return this.asegRolList;
	}

	public void setAsegRolList(List<AsegRol> asegRolList) {
		this.asegRolList = asegRolList;
	}

	public AsegRol getManageSelectedRol() {
		return this.manageSelectedRol;
	}

	public void setManageSelectedRol(AsegRol manageSelectedRol) {
		this.manageSelectedRol = manageSelectedRol;
	}

	public RepReporteRol getRepReporteRol() {
		return this.repReporteRol;
	}

	public void setRepReporteRol(RepReporteRol repReporteRol) {
		this.repReporteRol = repReporteRol;
	}

	public List<AsegRol> getAllRol() {
		return this.allRol;
	}

	public void setAllRol(List<AsegRol> allRol) {
		this.allRol = allRol;
	}

	public List<AsegRol> getFilterAsegRolList() {
		return this.filterAsegRolList;
	}

	public void setFilterAsegRolList(List<AsegRol> filterAsegRolList) {
		this.filterAsegRolList = filterAsegRolList;
	}

	public void actualizarTabla(RepReportesSistema repReportesSistema) {
		setAsegRolList(repReportesSistema.getRepReporteRolCollection()
			.stream()
			.map(RepReporteRol::getAsegRol)
			.collect(Collectors.toList()));
		this.repReporteRol.setRepReportesSistema(repReportesSistema);
		addRol();
	}

	public void addRol() {
		setManageSelectedRol(null);
		List<AsegRol> allRolList = this.asegRolFacade.findAll();
		Set<Long> existingRolCodes = getAsegRolList().stream().map(AsegRol::getRolCodigo).collect(Collectors.toSet());
		this.allRol = allRolList.stream()
			.filter((asegRol) -> !existingRolCodes.contains(asegRol.getRolCodigo()))
			.collect(Collectors.toList());
	}

	@Override
	public RepReporteRol prepareCreate(ActionEvent event) {
		addRol();
		return super.prepareCreate(event);
	}

	@Override
	public void saveNew(ActionEvent event) {
		this.repReporteRol.setRepPerCodigo(this.repReporteRolFacade.findSequence());
		this.setSelectedToEdit(this.repReporteRol);
		super.saveNew(event);
		this.manageSelectedRol = new AsegRol();
		if (!Faces.isValidationFailed()) {
			this.posRepGestorArchivosController.setItems(null);
			PrimeFaces.current().ajax().update("PosReportesForm:rolesPanelGroup");
			PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable");
			PrimeFaces.current().ajax().update("posRepGestorArchivosController.items");
			PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable2");
			PrimeFaces.current().ajax().update("PosReportesForm:messages");
		}
	}

	@Override
	public void delete(ActionEvent event) {
		super.delete(event);
		this.manageSelectedRol = new AsegRol();
		if (!Faces.isValidationFailed()) {
			this.posRepGestorArchivosController.setItems(null);
			PrimeFaces.current().ajax().update("PosReportesForm:messagesRol");
			PrimeFaces.current().ajax().update("PosReportesForm:rolesPanelGroup");
			PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable2");
		}
	}

}
