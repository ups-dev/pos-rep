package ec.edu.ups.pos.rep.view.controllers.rep;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import ec.edu.ups.jsf.security.ups.util.TipoEstructura;
import ec.edu.ups.jsf.security.ups.web.session.SecOrgEstructuraController;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepReportesSistemaFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

@Named("repReportesSistemaController")
@ViewScoped
public class RepReportesSistemaController extends AbstractController<RepReportesSistema> {

	private String modulo;

	@Inject
	private RepReportesSistemaFacade repReportesSistemaFacade;

	@Inject
	private SecOrgEstructuraController secOrgEstructuraController;

	public RepReportesSistemaController() {
		super(RepReportesSistema.class);
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public void preRenderView(String valor_modulo) {
		if (!Faces.isPostback()) {

			if (valor_modulo.equals(PosRepConstants.REP_PARAMETRO_MODULO_DOCTORADOS)) {
				this.secOrgEstructuraController.setTipoEstructura(TipoEstructura.DOCTORADO);
			}
			else if (valor_modulo.equals(PosRepConstants.REP_PARAMETRO_MODULO_REPORTES)) {
				this.secOrgEstructuraController.setTipoEstructura(TipoEstructura.PROGRAMA);
			}
			this.modulo = valor_modulo;

		}
	}

	@Override
	protected List<RepReportesSistema> findItems() {
		return this.repReportesSistemaFacade.listaReportesAutorizados(Faces.getRemoteUser(), "POS-REP", this.modulo);
	}

	protected List<RepReportesSistema> findRoles() {
		return this.repReportesSistemaFacade.listaReportesAutorizados(Faces.getRemoteUser(), "POS-REP", this.modulo);
	}

	@Override
	public void saveNew(ActionEvent event) {

		super.saveNew(event);
	}

}
