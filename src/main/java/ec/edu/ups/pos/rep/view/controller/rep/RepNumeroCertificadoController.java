package ec.edu.ups.pos.rep.view.controller.rep;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.inject.Inject;

import ec.edu.ups.pos.rep.data.entities.rep.RepNumeroCertificado;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepNumeroCertificadoFacade;
import ec.edu.ups.pos.rep.view.controllers.AbstractController;

public class RepNumeroCertificadoController extends AbstractController<RepNumeroCertificado> {

	@Inject
	private RepNumeroCertificadoFacade repNumeroCertificadoFacade;

	public RepNumeroCertificadoController() {
		super(RepNumeroCertificado.class);
	}

	public Integer obtieneSecuenciaCertificado(Long estCodigo, Long pelCodigo, Long ticCodigo) {
		RepNumeroCertificado secuencia;
		Long anio = 0L;
		if (ticCodigo <= 2) {

			secuencia = this.repNumeroCertificadoFacade.consultaSecuenciaCertificado(estCodigo, pelCodigo, ticCodigo);

		}
		else {

			Calendar c = new GregorianCalendar();
			String annio = Integer.toString(c.get(Calendar.YEAR));
			anio = Long.valueOf(annio);
			secuencia = this.repNumeroCertificadoFacade.consultaSecuenciaCertificadoAnio(estCodigo, pelCodigo,
					ticCodigo, anio);

		}

		if (secuencia == null) {

			RepNumeroCertificado numCertificado = new RepNumeroCertificado();

			numCertificado.setNceNumeroCertificado(1L);
			numCertificado.setPelCodigo(pelCodigo);
			numCertificado.setEstCodigo(estCodigo);
			numCertificado.setTicCodigo(ticCodigo);
			numCertificado.setNceAnio(anio);
			this.repNumeroCertificadoFacade.createRecord(numCertificado);
			return Integer.valueOf(String.valueOf(numCertificado.getNceNumeroCertificado()));

		}
		else {
			long secCert = secuencia.getNceNumeroCertificado();

			secuencia.setNceNumeroCertificado(secCert + 1);
			this.repNumeroCertificadoFacade.editRecord(secuencia);
			return Integer.valueOf(String.valueOf(secuencia.getNceNumeroCertificado()));
		}

	}

}
