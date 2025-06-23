package ec.edu.ups.pos.rep.view.controllers;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.sf.jasperreports.engine.JRParameter;
import org.omnifaces.util.Faces;
import org.primefaces.model.StreamedContent;

import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.data.entities.ofe.OfeGrupo;
import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoLectivo;
import ec.edu.ups.pos.rep.data.entities.ped.PedMalla;
import ec.edu.ups.pos.rep.data.entities.ped.PedModalidad;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.data.entities.rep.RepSecretarioGeneral;
import ec.edu.ups.pos.rep.data.entities.rep.RepTipCerRepSis;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
import ec.edu.ups.pos.rep.data.entities.wrapper.PosgradoAlumnoWrapper;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepTipCerRepSisFacade;
import ec.edu.ups.pos.rep.view.controller.ins.InsAlumnoController;
import ec.edu.ups.pos.rep.view.controller.rep.RepEmisionCertificadoController;
import ec.edu.ups.pos.rep.view.controller.rep.RepNumeroCertificadoController;
import ec.edu.ups.pos.rep.view.controller.rep.RepReportesSistemaController;
import ec.edu.ups.pos.rep.view.controller.rep.RepSecretarioGeneralController;
import ec.edu.ups.util.jasper.ReportParamBuilder;
import ec.edu.ups.util.jasper.ReportType;

/**
 * Description.
 *
 * @author ups .
 */
@Named("posRepGeneralController")
@ViewScoped
public class PosRepGeneralController implements Serializable {

	@Inject
	PosReporteController posReporteController;

	@Inject
	InsAlumnoController insAlumnoController;

	@Inject
	RepReportesSistemaController repReportesSistemaController;

	@Inject
	PosRepResultadoController posRepResultadoController;

	@Inject
	PosRepPosgradosController posRepPosgradosController;

	@Inject
	RepSecretarioGeneralController repSecretarioGeneralController;

	@Inject
	RepNumeroCertificadoController repNumeroCertificadoController;

	@Inject
	RepEmisionCertificadoController repEmisionCertificadoController;

	@Inject
	RepTipCerRepSisFacade repTipCerRepSisFacade;

	@Inject
	PosRepLogController posRepLogController;

	/**
	 * Generar reporte general.
	 * @param formato extensión del archivo a obtener ej: "pdf" , "xlsx".
	 * @return description.
	 */
	public StreamedContent generar_reporte_generico(String formato) {
		StreamedContent result = null;
		RepReportesSistema repReportesSistema = this.repReportesSistemaController.getSelected();
		this.posRepLogController.prepareCreate(null);

		if (repReportesSistema != null) {
			String nombre = ""; // "repReportesSistema.getResArchivo();";
			if (formato.equals("pdf")) {
				nombre = repReportesSistema.getResArchivo();
			}
			else if (formato.equals("xlsx")) {
				nombre = repReportesSistema.getResArchivoExcel();
			}

			// Definición de nombre de: reporte y archivo
			String nombreReporte = "/WEB-INF/reportes/posRep_generico/" + nombre;

			System.out.println(" reporte : " + nombreReporte);
			String nombreArchivo = repReportesSistema.getResReporte();

			// Parámetro Alumno
			InsAlumnoWrapper insAlumnoWrapper = this.posRepResultadoController.getInsAlumnoWrapper();

			Integer codigoAlumno = null;
			if (insAlumnoWrapper != null) {
				codigoAlumno = Integer.valueOf(String.valueOf(insAlumnoWrapper.getAluCodigo()));
			}

			this.posRepLogController.appendParametro("ALUMNO", codigoAlumno);

			// Identificar la estructura seleccionada para el reporte
			OrgEstructura orgEstructura = this.posReporteController.identificarEstructura();
			Integer codigoEstructura = Integer.valueOf(String.valueOf(orgEstructura.getEstCodigo()));
			this.posRepLogController.appendParametro("SEDE",
					this.posRepResultadoController.getOrgEstructuraSede().getOrgDescripcionEstructura().getDeeCodigo());
			this.posRepLogController.appendParametro("CAMPUS",
					this.posRepResultadoController.getOrgEstructuraCampus()
						.getOrgDescripcionEstructura()
						.getDeeCodigo());
			this.posRepLogController.appendParametro("CARRERA",
					this.posRepResultadoController.getOrgEstructuraCarrera()
						.getOrgDescripcionEstructura()
						.getDeeCodigo());

			// Parámetro Periodo Inicial
			OrgPeriodoLectivo orgPeriodoInicial = this.posRepResultadoController.getOrgPeriodoInicial();
			Integer codigoPeriodo = 0;
			if (orgPeriodoInicial != null) {
				codigoPeriodo = Integer.valueOf(String.valueOf(orgPeriodoInicial.getPelCodigo()));
			}
			this.posRepLogController.appendParametro("PERIODO INICIAL", codigoPeriodo);
			// Parámetro Periodo Final
			OrgPeriodoLectivo orgPeriodoFinal = this.posRepResultadoController.getOrgPeriodoFinal();
			Integer codigoPeriodoFin = 0;
			if (orgPeriodoFinal != null) {
				codigoPeriodoFin = Integer.valueOf(String.valueOf(orgPeriodoFinal.getPelCodigo()));
			}
			this.posRepLogController.appendParametro("PERIODO FINAL", codigoPeriodoFin);

			// Parámetro Periodo Final
			OrgPeriodoLectivo orgCohorteT = this.posRepResultadoController.getOrgPeriodoInicial();
			String codigoPeriodCohorte = "%";
			if (orgCohorteT != null) {
				codigoPeriodCohorte = String.valueOf(String.valueOf(orgPeriodoInicial.getPelCodigo()));
			}

			this.posRepLogController.appendParametro("COHORTE_T", codigoPeriodCohorte);

			// Parámetro Modalidad
			PedModalidad pedModalidad = this.posRepResultadoController.getPedModalidad();
			String codigoModalidad = "%";
			if (pedModalidad != null) {
				codigoModalidad = String.valueOf(String.valueOf(pedModalidad.getModCodigo()));
			}
			this.posRepLogController.appendParametro("MODALIDAD", codigoModalidad);

			// Parámetro Nivel
			Integer pedNivelMalla = this.posRepResultadoController.getPedNivelMalla();
			String codigoNivel = "%";
			if (pedNivelMalla != null) {
				codigoNivel = String.valueOf(String.valueOf(pedNivelMalla));
			}
			this.posRepLogController.appendParametro("NIVEL", codigoNivel);

			// Parámetro GthPersona
			GthPersona gthPersona = this.posRepResultadoController.getGthPersona();
			String codigoPersona = "%";
			if (gthPersona != null) {
				codigoPersona = String.valueOf(gthPersona.getPerCodigo());
			}
			this.posRepLogController.appendParametro("DOCENTE", codigoPersona);

			// Parámetro Asignatura
			PedMalla pedMalla = this.posRepResultadoController.getPedMalla();
			String malCodigo = "%";
			if (pedMalla != null) {
				malCodigo = String.valueOf(pedMalla.getMalCodigo());
			}
			this.posRepLogController.appendParametro("ASIGNATURA", malCodigo);

			// Parámetro Grupo
			OfeGrupo ofeGrupo = this.posRepResultadoController.getOfeGrupo();
			String gruCodigo = "%";
			if (ofeGrupo != null) {
				gruCodigo = String.valueOf(ofeGrupo.getGruCodigo());
			}
			this.posRepLogController.appendParametro("GRUPO", gruCodigo);

			String pagado = this.posRepResultadoController.getPafPagado();
			this.posRepLogController.appendParametro("PAGADO", pagado);

			String pv_anio = this.posRepResultadoController.getAnio();
			this.posRepLogController.appendParametro("ANIO", pv_anio);

			// Definición de Parámetros
			ReportParamBuilder rpb = ReportParamBuilder.create("pv_usuario", Faces.getRemoteUser())
				.add(JRParameter.REPORT_LOCALE, new Locale("es", "ES"));
			rpb.add("pn_est_codigo", codigoEstructura);
			rpb.add("pn_pel_codigo", codigoPeriodo);
			rpb.add("pn_pel_codigo_fin", codigoPeriodoFin);
			rpb.add("pv_pel_codigo", codigoPeriodCohorte);
			rpb.add("pv_mod_codigo", codigoModalidad);
			rpb.add("pv_per_codigo", codigoPersona);
			rpb.add("pv_mal_codigo", malCodigo);
			rpb.add("pv_gru_codigo", gruCodigo);
			rpb.add("pv_mal_nivel", codigoNivel);
			rpb.add("pv_pee_nivel", codigoNivel);
			rpb.add("pv_paf_pagado", pagado);
			rpb.add("pn_alu_codigo", codigoAlumno);
			rpb.add("pv_anio", pv_anio);

			switch (formato) {
				case "pdf":
					// System.out.println("nombreArchivo : " + nombreArchivo);
					// System.out.println("nombreReporte : " + nombreReporte);
					result = this.posReporteController.generarStreamedReporte(ReportType.PDF, ".pdf", nombreArchivo,
							nombreReporte, rpb);
					break;
				case "xlsx":
					result = this.posReporteController.generarStreamedReporte(ReportType.XLSX, ".xlsx", nombreArchivo,
							nombreReporte, rpb);
					break;
				default:
					throw new IllegalArgumentException("No se ha identificado el formato del archivo: " + formato);
			}
		}
		return result;
	}

	/**
	 * Generar reporte Certificados.
	 * @param formato extensión del archivo a obtener ej: "pdf" , "xlsx".
	 * @param certificacion .
	 * @return description .
	 */
	public StreamedContent generar_reporte_certificado(String formato, boolean certificacion) {
		StreamedContent result = null;

		this.posRepLogController.prepareCreate(null);

		RepReportesSistema repReportesSistema = this.repReportesSistemaController.getSelected();

		RepTipCerRepSis repTipCerRepSis = this.repTipCerRepSisFacade
			.consultaTipoCertificado(repReportesSistema.getResCodigo());

		boolean variable = this.posRepPosgradosController.validarParametros(repReportesSistema);

		if (!variable) {
			return null;
		}

		String nombre = ""; // "repReportesSistema.getResArchivo();";
		if (formato.equals("pdf")) {
			nombre = repReportesSistema.getResArchivo();
		}
		else if (formato.equals("xlsx")) {
			nombre = repReportesSistema.getResArchivoExcel();
		}

		// Definición de nombre de: reporte y archivo
		String nombreReporte = "/WEB-INF/reportes/posRep_certificado/" + nombre;
		String nombreArchivo = repReportesSistema.getResReporte();
		// System.out.println("nombreArchivo "+nombreArchivo);

		// Parámetro Alumno
		InsAlumnoWrapper insAlumnoWrapper = this.posRepPosgradosController.getInsAlumnoWrapper();
		Integer codigoAlumno = null;
		if (insAlumnoWrapper != null) {
			codigoAlumno = Integer.valueOf(String.valueOf(insAlumnoWrapper.getAluCodigo()));
		}
		this.posRepLogController.appendParametro("ALUMNO", codigoAlumno);

		// Parámetro Semestre
		String nivelPeriodoEstructura = this.posRepPosgradosController.getMatNivelPeriodoEstructura();
		String codigoNivel = "";
		if (nivelPeriodoEstructura != null) {
			codigoNivel = nivelPeriodoEstructura;
		}
		this.posRepLogController.appendParametro("SEMESTRE", codigoNivel);

		// Parámetro Periodo
		PosgradoAlumnoWrapper posAlumnoWrapper = this.posRepPosgradosController.getPosgradoAlumnoWrapper();
		Integer codigoPeriodo = null;
		Integer estCampus = null;
		Integer estPosgrado = null;
		Long estSede = null;
		String tituloPosgrado = null;
		String mencionEstudiante = null;
		Integer totalMenciones = null;
		String cddCodigo = null;
		Integer preNumero = null;
		Integer imprimeTitulo = 0;

		if (posAlumnoWrapper != null) {
			codigoPeriodo = Integer.valueOf(String.valueOf(posAlumnoWrapper.getCodPeriodo()));
			estSede = (this.posRepResultadoController.getOrgEstructuraSedeEmision() != null)
					? this.posRepResultadoController.getOrgEstructuraSedeEmision().getEstCodigo() : null;
			estCampus = Integer
				.valueOf(String.valueOf((this.posRepResultadoController.getOrgEstructuraCampusEmision() != null)
						? this.posRepResultadoController.getOrgEstructuraCampusEmision().getEstCodigo() : null));
			estPosgrado = Integer.valueOf(String.valueOf(posAlumnoWrapper.getEstPosgrado()));

			tituloPosgrado = String.valueOf(posAlumnoWrapper.getTitulo());
			mencionEstudiante = String.valueOf(posAlumnoWrapper.getTieneMencionEst());
			totalMenciones = Integer.valueOf(String.valueOf(posAlumnoWrapper.getTotalMenciones()));

			cddCodigo = String.valueOf(posAlumnoWrapper.getCodMencionEstudiante());
			preNumero = Integer.valueOf(String.valueOf(posAlumnoWrapper.getPreCodigo()));

			if (mencionEstudiante.equals("S") || (totalMenciones == 1)) {
				imprimeTitulo = 1;
			}
			else {
				imprimeTitulo = 0;
			}
		}

		// Parámetro Sede Factura
		String sedeFactura = this.posRepPosgradosController.getSedeFactura();
		Integer numSedeFactura = null;
		if (sedeFactura != null) {
			numSedeFactura = Integer.valueOf(sedeFactura);
		}
		// Parámetro Punto de Facturación
		String puntoFacturacion = this.posRepPosgradosController.getPuntoFacturacion();
		Integer numPuntoFacturacion = null;
		if (puntoFacturacion != null) {
			numPuntoFacturacion = Integer.valueOf(puntoFacturacion);
		}

		// Parámetro Número de Factura
		String numeroFactura = this.posRepPosgradosController.getNumFactura();
		Integer numFactura = null;
		if (numeroFactura != null) {
			numFactura = Integer.valueOf(numeroFactura);
		}

		// Parámetro Secretaria General
		RepSecretarioGeneral secreGeneral = this.repSecretarioGeneralController.getSecretarioSeleccionado();
		Integer secretarioGeneral = 1;
		if (secreGeneral != null) {
			secretarioGeneral = Integer.valueOf(String.valueOf(secreGeneral.getSegCodigo()));

		}

		// Parámetro opcion Certificación
		Integer opcion = this.posRepPosgradosController.opcionCertificacion();
		Integer opcionCert = 0;
		if (opcion != null) {
			opcionCert = opcion;
		}

		// Parámetro Secuencia
		Integer numSecuenciaCertificado = 0;
		// Integer certificadoSemestre =1L;

		if ((estSede != null) && (certificacion)) {
			numSecuenciaCertificado = this.repNumeroCertificadoController.obtieneSecuenciaCertificado(estSede,
					posAlumnoWrapper.getCodPeriodo(), repTipCerRepSis.getTicCodigo());

		}

		// Definición de Parámetros
		ReportParamBuilder rpb = ReportParamBuilder.create("pv_usuario", Faces.getRemoteUser())
			.add(JRParameter.REPORT_LOCALE, new Locale("es", "ES"));
		rpb.add("pn_alu_codigo", codigoAlumno);
		rpb.add("pn_pel_codigo", codigoPeriodo);
		rpb.add("pv_nivel", codigoNivel);
		rpb.add("pn_est_codigo", estPosgrado);
		rpb.add("pn_campus", estCampus);
		rpb.add("pn_certificacion", opcionCert);
		rpb.add("pn_seg_codigo", secretarioGeneral); // revisar tabla
		rpb.add("pn_sedeFacturacion", numSedeFactura); // revisar tabla
		rpb.add("pn_puntoFacturacion", numPuntoFacturacion); // revisar tabla
		rpb.add("pn_numFactura", numFactura); // revisar tabla
		rpb.add("pn_secuencia", numSecuenciaCertificado); // revisar tabla
		rpb.add("pv_tituloPosgrado", tituloPosgrado); // revisar tabla
		rpb.add("pn_imprimeTitulo", imprimeTitulo); // revisar tabla
		rpb.add("pv_cdd_codigo", cddCodigo); // revisar tabla
		rpb.add("pn_pre_numero", preNumero); // revisar tabla

		if ((estSede != null) && (certificacion)) {
			this.repEmisionCertificadoController.registraEmisionCertificado(Long.valueOf(numSecuenciaCertificado),
					Long.valueOf(codigoAlumno), Long.valueOf(posAlumnoWrapper.getEstPosgrado()),
					posAlumnoWrapper.getCodPeriodo(), repTipCerRepSis.getTicCodigo());

		}
		this.posRepLogController.appendParametro("PERIODO INICIAL", codigoPeriodo);
		this.posRepLogController.appendParametro("PN_EST_CODIGO", estPosgrado);
		this.posRepLogController.appendParametro("CAMPUS", estCampus);
		this.posRepLogController.appendParametro("CERTIFICACION", opcionCert);
		this.posRepLogController.appendParametro("pn_seg_codigo", secretarioGeneral);
		this.posRepLogController.appendParametro("pn_sedeFacturacion", numSedeFactura);
		this.posRepLogController.appendParametro("pn_puntoFacturacion", numPuntoFacturacion);
		this.posRepLogController.appendParametro("pn_sedeFacturacion", numFactura);
		this.posRepLogController.appendParametro("pn_secuencia", numSecuenciaCertificado);
		this.posRepLogController.appendParametro("pv_tituloPosgrado", tituloPosgrado);
		this.posRepLogController.appendParametro("pn_imprimeTitulo", imprimeTitulo);
		this.posRepLogController.appendParametro("pv_cdd_codigo", cddCodigo);
		this.posRepLogController.appendParametro("pn_pre_numero", preNumero);

		// Definición de Formato de Archivo
		switch (formato) {
			case "pdf":
				result = this.posReporteController.generarStreamedReporte(ReportType.PDF, ".pdf", nombreArchivo,
						nombreReporte, rpb);
				break;
			case "xlsx":
				result = this.posReporteController.generarStreamedReporte(ReportType.XLSX, ".xlsx", nombreArchivo,
						nombreReporte, rpb);
				break;
			default:
				throw new IllegalArgumentException("No se ha identificado el formato del archivo: " + formato);
		}
		this.posRepLogController.saveNew(null);
		return result;
	}

}
