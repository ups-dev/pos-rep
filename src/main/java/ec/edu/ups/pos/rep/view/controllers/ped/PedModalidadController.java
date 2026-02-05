package ec.edu.ups.pos.rep.view.controllers.ped;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.edu.ups.pos.rep.data.entities.ped.PedModalidad;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

@Named("pedModalidadController")
@ViewScoped
public class PedModalidadController extends AbstractController<PedModalidad> {

	public PedModalidadController() {
		super(PedModalidad.class);
	}

	@Override
	public List<PedModalidad> getItemsNotDisabled() {

		return super.getItemsNotDisabled();
	}

}
