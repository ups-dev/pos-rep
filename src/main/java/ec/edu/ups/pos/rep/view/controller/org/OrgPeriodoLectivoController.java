package ec.edu.ups.pos.rep.view.controller.org;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoLectivo;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

@Named("orgPeriodoLectivoController")
@ViewScoped
public class OrgPeriodoLectivoController extends AbstractController<OrgPeriodoLectivo> {

	public OrgPeriodoLectivoController() {
		super(OrgPeriodoLectivo.class);
	}

	@Override
	public List<OrgPeriodoLectivo> getItemsNotDisabled() {

		return super.getItemsNotDisabled();
	}

}
