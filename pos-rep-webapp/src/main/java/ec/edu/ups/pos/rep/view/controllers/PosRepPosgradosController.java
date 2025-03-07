/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.view.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.omnifaces.util.Utils;
import org.primefaces.PrimeFaces;

import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.entities.rep.RepParametroReporte;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
import ec.edu.ups.pos.rep.data.entities.wrapper.PosgradoAlumnoWrapper;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.logic.sessions.ins.InsAlumnoFacade;
import ec.edu.ups.pos.rep.logic.sessions.mat.MatMatriculaFacade;
import ec.edu.ups.pos.rep.logic.sessions.org.OrgEstructuraFacade;
import ec.edu.ups.pos.rep.logic.sessions.rep.PosRepPosgradosFacade;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepParametroReporteFacade;

/**
 * Description.
 *
 * @author UPS .
 */

@Named("posRepPosgradosController")
@ViewScoped

public class PosRepPosgradosController implements Serializable {

	@Inject
	private InsAlumnoFacade insAlumnoFacade;

	@Inject
	private PosRepPosgradosFacade posRepPosgradosFacade;

	@Inject
	private RepParametroReporteFacade repParametroReporteFacade;

	@Inject
	private MatMatriculaFacade matMatriculaFacade;

	@Inject
	private OrgEstructuraFacade orgEstructuraFacade;

	@Inject
	private PosRepResultadoController posRepResultadoController;

	private List<PosgradoAlumnoWrapper> listadoPosgrados;

	private PosgradoAlumnoWrapper posgradoAlumnoWrapper;

	private InsAlumnoWrapper insAlumnoWrapper;

	private List<InsAlumnoWrapper> listadoAlumnos;

	private Long aluCodigo;

	private boolean certificacion;

	private List<String> listSecretariaGeneral;

	private List<String> matNivelPeriodoEstructuraList;

	private String matNivelPeriodoEstructura;

	private String sedeFactura;

	private String puntoFacturacion;

	private String numFactura;

	private String filtro = "";

	private int maxResult = 10;

	OrgEstructura posgrado;

	OrgEstructura campus;

	OrgEstructura sede;

	/**
	 * Devuelve el objeto usado por primeFaces con opciones para poder modificar la
	 * respuesta de una solicitud.
	 * @return la instancia de requestContext usada por primeFaces.
	 */
	public PrimeFaces getRequestContext() {
		return PrimeFaces.current();
	}

	public void callEventAjaxOrgEstructura() {

		PrimeFaces.current().ajax().update("PosReportesCerForm:PosReportesCerSistemaDataTable");
		PrimeFaces.current().ajax().update("PosReportesCerForm:PosRepCerExportToolbar");
		PrimeFaces.current().ajax().update("PosReportesCerForm:PosRepCerFiltroPanel");

	}

	// public void cargarNiveles(){
	//
	// matNivelPeriodoEstructuraList=
	// matMatriculaFacade.obtieneSemestre(insAlumnoWrapper.getAluCodigo());
	// //System.out.println("insAlumnoWrapper.getAluCodigo()" +
	// insAlumnoWrapper.getAluCodigo());
	// actualizaCamposFac();
	//
	// }

	public void cargarValidaciones(RepReportesSistema repReportesSistema) {

		// System.out.println("repReportesSistema.getResCodigo()myyyy " +
		// repReportesSistema.getResCodigo());
		// System.out.println("PosRepConstants.REPORTE_SISTEMA_RECORD_ACADEMICO_GRADUADOS"
		// + PosRepConstants.REPORTE_SISTEMA_RECORD_ACADEMICO_GRADUADOS);
		if (repReportesSistema.getResCodigo().equals(PosRepConstants.REPORTE_SISTEMA_CALIFICACIONES_SEMESTRE)) {

			this.matNivelPeriodoEstructuraList = this.matMatriculaFacade
				.obtieneSemestre(this.insAlumnoWrapper.getAluCodigo());
			// System.out.println("insAlumnoWrapper.getAluCodigo()" +
			// insAlumnoWrapper.getAluCodigo());

		}
		else if (repReportesSistema.getResCodigo().equals(PosRepConstants.REPORTE_SISTEMA_RECORD_ACADEMICO_GRADUADOS)) {

			if (getPosgradoAlumnoWrapper().getActaGrado().equalsIgnoreCase("N")) {

				Messages.addGlobalWarn("El estudiante no posee Acta de Grado en el Programa y Proyecto seleccionado.");

			}

		}
		actualizaCamposFac();

		// aqui se va a cargar valores por defecto para sede y campus emision
		cargarEstructuraEmisionDefecto();
		// System.out.println("Carga por defecto");

	}

	public boolean validarParametros(RepReportesSistema repReportesSistema) {

		if (repReportesSistema.getResCodigo().equals(PosRepConstants.REPORTE_SISTEMA_CALIFICACIONES_SEMESTRE)) {

			if (this.matNivelPeriodoEstructuraList != null) {

				if (this.matNivelPeriodoEstructuraList.size() > 0 && this.matNivelPeriodoEstructura == null) {

					Messages.addGlobalWarn("Seleccione el Semestre del Programa.");
					return false;
				}
			}

		}
		return true;
	}

	public List<InsAlumnoWrapper> autoCompleteAlumnos(String query) {
		List<InsAlumnoWrapper> suggestions = new ArrayList<>();

		if (!Utils.isEmpty(query)) {
			String replace = query.replace(" ", "%%");
			suggestions = this.insAlumnoFacade.findAlumnoWrapper(replace);
		}

		setListadoAlumnos(suggestions);

		return suggestions;
	}

	public void cargarLista() {
		// System.out.println("insAlumnio: "+insAlumnoWrapper);
		actualizaFiltros();

		if (this.insAlumnoWrapper != null) {
			this.listadoPosgrados = this.posRepPosgradosFacade.listaPosgrados(this.insAlumnoWrapper.getAluCodigo());

		}

	}

	public void limpiarFiltros() {

		setInsAlumnoWrapper(null);
		setAluCodigo(null);
		setPosgradoAlumnoWrapper(null);
		setMatNivelPeriodoEstructuraList(null);
		setMatNivelPeriodoEstructura(null);
		setListSecretariaGeneral(null);
		setCertificacion(false);
		setNumFactura(null);
		setPuntoFacturacion(null);
		setSedeFactura(null);
	}

	public void actualizaFiltros() {

		setPosgradoAlumnoWrapper(null);
		setMatNivelPeriodoEstructuraList(null);
		setMatNivelPeriodoEstructura(null);
		setListSecretariaGeneral(null);
		setCertificacion(false);
		setNumFactura(null);
		setPuntoFacturacion(null);
		setSedeFactura(null);
		setAluCodigo(null);

		this.posgrado = null;
		this.campus = null;
		this.sede = null;

	}

	public void actualizaCamposFac() {

		setCertificacion(false);
		setListSecretariaGeneral(null);
		setNumFactura(null);
		setPuntoFacturacion(null);
		setSedeFactura(null);
		this.posgrado = null;
		this.campus = null;
		this.sede = null;

	}

	/////
	public void cargarEstructuraEmisionDefecto() {
		/*
		 * OrgEstructura posgrado = null; OrgEstructura campus =null; OrgEstructura sede =
		 * null;
		 */
		this.posRepResultadoController.setOrgEstructuraCampusEmisionList(null);
		this.posRepResultadoController.setOrgEstructuraSedeEmisionList(null);

		// System.out.println("insAlumnoWrapper" + insAlumnoWrapper);

		if (this.insAlumnoWrapper != null) {

			List<OrgEstructura> estructuraEmision = this.orgEstructuraFacade
				.obtenerEstructuraPosgradoAlumno(this.insAlumnoWrapper.getAluCodigo().toString());

			if (estructuraEmision.isEmpty()) {

				Messages.addGlobalWarn("El estudiante no posee una inscripción válida.");
			}
			else {

				this.posgrado = estructuraEmision.get(0);
				this.campus = this.posgrado.getOrgEstructuraPadre();
				this.sede = this.posgrado.getOrgEstructuraPadre().getOrgEstructuraPadre();

				this.posRepResultadoController.setOrgEstructuraSedeEmision(this.sede);
				// System.out.println("sede inscripcion :"+sede);

				this.posRepResultadoController.setOrgEstructuraCampusEmision(this.campus);
				// System.out.println("campus inscripcion :"+campus);

			}
		}

	}

	public boolean compruebaParametro(RepReportesSistema repReportesSistema, Long codigoParametro) {
		List<RepParametroReporte> parametroReporteList = this.repParametroReporteFacade
			.obtieneParametroPorReporte(codigoParametro, repReportesSistema);
		return !(parametroReporteList == null || parametroReporteList.isEmpty());
	}

	public Integer opcionCertificacion() {
		Integer opcionSeleccionada = 0;

		if (this.certificacion) {
			opcionSeleccionada = 1;
		}
		return opcionSeleccionada;

	}

	public List<PosgradoAlumnoWrapper> getListadoPosgrados() {
		return this.listadoPosgrados;
	}

	public void setListadoPosgrados(List<PosgradoAlumnoWrapper> listadoPosgrados) {
		this.listadoPosgrados = listadoPosgrados;
	}

	public PosgradoAlumnoWrapper getPosgradoAlumnoWrapper() {
		return this.posgradoAlumnoWrapper;
	}

	public void setPosgradoAlumnoWrapper(PosgradoAlumnoWrapper posgradoAlumnoWrapper) {
		this.posgradoAlumnoWrapper = posgradoAlumnoWrapper;
	}

	public InsAlumnoWrapper getInsAlumnoWrapper() {
		return this.insAlumnoWrapper;
	}

	public void setInsAlumnoWrapper(InsAlumnoWrapper insAlumnoWrapper) {
		this.insAlumnoWrapper = insAlumnoWrapper;
	}

	public List<InsAlumnoWrapper> getListadoAlumnos() {
		return this.listadoAlumnos;
	}

	public void setListadoAlumnos(List<InsAlumnoWrapper> listadoAlumnos) {
		this.listadoAlumnos = listadoAlumnos;
	}

	public Long getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public boolean isCertificacion() {
		return this.certificacion;
	}

	public void setCertificacion(boolean certificacion) {
		this.certificacion = certificacion;
	}

	public List<String> getListSecretariaGeneral() {
		return this.listSecretariaGeneral;
	}

	public void setListSecretariaGeneral(List<String> listSecretariaGeneral) {
		this.listSecretariaGeneral = listSecretariaGeneral;
	}

	public List<String> getMatNivelPeriodoEstructuraList() {
		return this.matNivelPeriodoEstructuraList;
	}

	public void setMatNivelPeriodoEstructuraList(List<String> matNivelPeriodoEstructuraList) {
		this.matNivelPeriodoEstructuraList = matNivelPeriodoEstructuraList;
	}

	public String getMatNivelPeriodoEstructura() {
		return this.matNivelPeriodoEstructura;
	}

	public void setMatNivelPeriodoEstructura(String matNivelPeriodoEstructura) {
		this.matNivelPeriodoEstructura = matNivelPeriodoEstructura;
	}

	public InsAlumnoFacade getInsAlumnoFacade() {
		return this.insAlumnoFacade;
	}

	public void setInsAlumnoFacade(InsAlumnoFacade insAlumnoFacade) {
		this.insAlumnoFacade = insAlumnoFacade;
	}

	public String getSedeFactura() {
		return this.sedeFactura;
	}

	public void setSedeFactura(String sedeFactura) {
		this.sedeFactura = sedeFactura;
	}

	public String getPuntoFacturacion() {
		return this.puntoFacturacion;
	}

	public void setPuntoFacturacion(String puntoFacturacion) {
		this.puntoFacturacion = puntoFacturacion;
	}

	public String getNumFactura() {
		return this.numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

}
