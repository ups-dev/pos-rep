package ec.edu.ups.pos.rep.view.controllers.rep;

import javax.inject.Inject;

import ec.edu.ups.pos.rep.data.entities.rep.RepEmisionCertificado;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepEmisionCertificadoFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

public class RepEmisionCertificadoController extends AbstractController<RepEmisionCertificado> {

	@Inject
	private RepEmisionCertificadoFacade repEmisionCertificadoFacade;

	public RepEmisionCertificadoController() {
		super(RepEmisionCertificado.class);
	}

	public void registraEmisionCertificado(Long numCertificado, Long aluCodigo, Long estCodigo, Long pelCodigo,
			Long ticCodigo) {

		RepEmisionCertificado emisionCertificado = new RepEmisionCertificado();

		emisionCertificado.setEmcNumCertificado(numCertificado);
		emisionCertificado.setTicCodigo(ticCodigo);
		emisionCertificado.setAluCodigo(aluCodigo);
		emisionCertificado.setPelCodigo(pelCodigo);
		emisionCertificado.setEstCodigo(estCodigo);

		this.repEmisionCertificadoFacade.createRecord(emisionCertificado);

	}

}
