package ec.edu.ups.pos.rep.view.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Utils;
import org.primefaces.PrimeFaces;

import ec.edu.ups.jsf.security.ups.util.TipoEstructura;
import ec.edu.ups.jsf.security.ups.web.session.SecOrgEstructuraController;
import ec.edu.ups.pos.rep.data.entities.gth.GthPersona;
import ec.edu.ups.pos.rep.data.entities.ofe.OfeGrupo;
import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoEstructura;
import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoLectivo;
import ec.edu.ups.pos.rep.data.entities.ped.PedMalla;
import ec.edu.ups.pos.rep.data.entities.ped.PedModalidad;
import ec.edu.ups.pos.rep.data.entities.rep.RepParametroReporte;
import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
import ec.edu.ups.pos.rep.data.utils.PosRepConstants;
import ec.edu.ups.pos.rep.logic.sessions.gth.GthPersonaFacade;
import ec.edu.ups.pos.rep.logic.sessions.ins.InsAlumnoFacade;
import ec.edu.ups.pos.rep.logic.sessions.ofe.OfeGrupoFacade;
import ec.edu.ups.pos.rep.logic.sessions.org.OrgEstructuraFacade;
import ec.edu.ups.pos.rep.logic.sessions.org.OrgPeriodoEstructuraFacade;
import ec.edu.ups.pos.rep.logic.sessions.ped.PedMallaFacade;
import ec.edu.ups.pos.rep.logic.sessions.ped.PedModalidadFacade;
import ec.edu.ups.pos.rep.logic.sessions.rep.RepParametroReporteFacade;
import ec.edu.ups.pos.rep.view.controllers.rep.RepReportesSistemaController;

@Named("posRepResultadoController")
@ViewScoped
public class PosRepResultadoController implements Serializable {

	private OrgEstructura orgEstructuraSede;

	private OrgEstructura orgEstructuraCampus;

	private OrgEstructura orgEstructuraCarrera;

	private OrgEstructura orgEstructuraSedeEmision;

	private OrgEstructura orgEstructuraCampusEmision;

	private OrgPeriodoLectivo orgPeriodoInicial;

	private OrgPeriodoLectivo orgPeriodoFinal;

	private PedModalidad pedModalidad;

	private GthPersona gthPersona;

	private PedMalla pedMalla;

	private OfeGrupo ofeGrupo;

	private List<OrgEstructura> orgEstructuraSedeList;

	private List<OrgEstructura> orgEstructuraCampusList;

	private List<OrgEstructura> orgEstructuraCarreraList;

	private List<OrgEstructura> orgEstructuraSedeEmisionList;

	private List<OrgEstructura> orgEstructuraCampusEmisionList;

	private List<OrgPeriodoLectivo> orgPeriodoLectivoList;

	private List<PedModalidad> pedModalidadList;

	private List<RepReportesSistema> repReportesSistemaList;

	private List<GthPersona> gthPersonaList;

	private List<PedMalla> pedMallaList;

	private List<OfeGrupo> ofeGrupoList;

	private List<Integer> pedMallaNivelList;

	private Integer pedNivelMalla;

	private String pafPagado;

	private InsAlumnoWrapper insAlumnoWrapper;

	private List<InsAlumnoWrapper> listadoAlumnos;

	private Long aluCodigo;

	private String Anio;

	private List<String> listadoAnio;

	@Inject
	private SecOrgEstructuraController secOrgEstructuraController;

	@Inject
	private OrgEstructuraFacade orgEstructuraFacade;

	@Inject
	private RepReportesSistemaController repReportesSistemaController;

	@Inject
	private OrgPeriodoEstructuraFacade orgPeriodoEstructuraFacade;

	@Inject
	private GthPersonaFacade gthPersonaFacade;

	@Inject
	private PedMallaFacade pedMallaFacade;

	@Inject
	private OfeGrupoFacade ofeGrupoFacade;

	@Inject
	private RepParametroReporteFacade repParametroReporteFacade;

	@Inject
	private PedModalidadFacade pedModalidadFacade;

	@Inject
	private InsAlumnoFacade insAlumnoFacade;

	private String filtro = "";

	private int maxResult = 10;

	private boolean validaSeleccionEstructuraSeguridadSede = false;

	private boolean validaSeleccionEstructuraSeguridadCampus = false;

	private boolean validaSeleccionEstructuraSeguridadCarrProg = false;

	/**
	 * Devuelve el objeto usado por PrimeFaces con opciones para poder modificar la
	 * respuesta de una solicitud.
	 * @return el objeto PrimeFaces actual para la gestión de la solicitud
	 */
	public PrimeFaces getRequestContext() {
		return PrimeFaces.current();
	}

	public void callEventAjaxOrgEstructura() {
		// System.out.println("Inicie callEventAjaxOrgEstructura");
		actualizaFiltros();
		PrimeFaces.current().ajax().update("PosReportesForm:PosReportesSistemaDataTable");
		PrimeFaces.current().ajax().update("PosReportesForm:PosRepExportToolbar");

	}

	public void setRepReportesSistemaList(List<RepReportesSistema> repReportesSistemaList) {
		this.repReportesSistemaList = repReportesSistemaList;
	}

	public void updateSedeList() {

		if (this.secOrgEstructuraController.getEstructuraSede().getEstCodigo().equals(PosRepConstants.TODAS_SEDES)) {

			setValidaSeleccionEstructuraSeguridadSede(false);
			this.orgEstructuraSedeList = this.orgEstructuraFacade.listaEstructuraSedeActivo();
		}
		else {
			setValidaSeleccionEstructuraSeguridadSede(true);
			setOrgEstructuraSedeList(Arrays.asList(
					this.orgEstructuraFacade.find(this.secOrgEstructuraController.getEstructuraSede().getEstCodigo())));
			if (!this.orgEstructuraSedeList.isEmpty()) {
				setOrgEstructuraSede(getOrgEstructuraSedeList().get(0));
			}
		}
		updateCampusList();
		updateModalidadPorProgramaList();
	}

	public void updateCampusList() {

		setOrgEstructuraCampus(null);
		setOrgEstructuraCampusList(null);
		if (getOrgEstructuraSede() != null) {
			// System.out.println(this.orgEstructuraSede.toString());

			if (!Objects.equals(this.secOrgEstructuraController.getEstructuraCampus().getEstCodigo(),
					PosRepConstants.TODOS_CAMPUS)
					&& !Objects.equals(this.secOrgEstructuraController.getEstructuraSede().getEstCodigo(),
							PosRepConstants.TODAS_SEDES)) {
				this.validaSeleccionEstructuraSeguridadCampus = true;
				setOrgEstructuraCampusList(Arrays.asList(this.orgEstructuraFacade
					.find(this.secOrgEstructuraController.getEstructuraCampus().getEstCodigo())));
				if (!(this.orgEstructuraCampusList.isEmpty())) {
					setOrgEstructuraCampus(this.orgEstructuraCampusList.get(0));
				}
			}
			else {
				this.validaSeleccionEstructuraSeguridadCampus = false;
				this.orgEstructuraCampusList = this.orgEstructuraFacade
					.listaEstructuraCampusActivo(getOrgEstructuraSede());
			}
		}

		setOrgEstructuraCarrera(null);
		setOrgEstructuraCarreraList(null);
		setPedModalidad(null);
		setPedModalidadList(null);
		updateCarreraList();
		updateModalidadPorProgramaList();

	}

	public void updateCarreraList() {

		updateAsignaturaList();
		setGthPersona(null);

		if (getOrgEstructuraCampus() != null) {
			if (this.secOrgEstructuraController.getTipoEstructura() == TipoEstructura.PROGRAMA) {
				if (Objects.equals(this.secOrgEstructuraController.getEstructuraCarrera().getEstCodigo(),
						PosRepConstants.TODAS_CARRERAS)) {
					this.orgEstructuraCarreraList = this.orgEstructuraFacade
						.listaEstructuraPostGradoSelecActivo(getOrgEstructuraCampus());
				}
				else {
					this.orgEstructuraCarreraList = this.orgEstructuraFacade
						.listaEstructuraPostGradoSelecActivo(getOrgEstructuraCampus());
					this.orgEstructuraCarreraList = this.orgEstructuraCarreraList.stream()
						.filter((est) -> Objects.equals(est.getEstCodigo(),
								this.secOrgEstructuraController.getEstructuraCarrera().getEstCodigo()))
						.collect(Collectors.toList());
					if (!this.orgEstructuraCarreraList.isEmpty()) {
						setOrgEstructuraCarrera(this.orgEstructuraCarreraList.get(0));
					}
				}
			}
			else if (this.secOrgEstructuraController.getTipoEstructura() == TipoEstructura.DOCTORADO) {

				if (Objects.equals(this.secOrgEstructuraController.getEstructuraCarrera().getEstCodigo(),
						PosRepConstants.TODAS_CARRERAS)) {
					this.orgEstructuraCarreraList = this.orgEstructuraFacade
						.listaEstructuraDoctoradoSelecActivo(getOrgEstructuraCampus());
				}
				else {
					this.orgEstructuraCarreraList = this.orgEstructuraFacade
						.listaEstructuraDoctoradoSelecActivo(getOrgEstructuraCampus());
					this.orgEstructuraCarreraList = this.orgEstructuraCarreraList.stream()
						.filter((est) -> Objects.equals(est.getEstCodigo(),
								this.secOrgEstructuraController.getEstructuraCarrera().getEstCodigo()))
						.collect(Collectors.toList());
					if (!this.orgEstructuraCarreraList.isEmpty()) {
						setOrgEstructuraCarrera(this.orgEstructuraCarreraList.get(0));
					}
				}

			}
		}
		setPedModalidad(null);
		setPedModalidadList(null);
		updatePeriodoPorCampusList();
		updateModalidadPorProgramaList();
	}

	public void updatePeriodoPorCampusList() {
		setOrgPeriodoInicial(null);
		setOrgPeriodoFinal(null);
		setOrgPeriodoLectivoList(null);
		updateGrupoList();
		if (this.secOrgEstructuraController.getTipoEstructura() == TipoEstructura.DOCTORADO) {

			if (obtenerEstructura() != null) {

				setOrgPeriodoLectivoList(
						this.orgPeriodoEstructuraFacade.obtieneCohorteDoctoradoPorEstructura(obtenerEstructura()));
				// System.out.println("Cohorte por Estructura");
			}
			else {
				setOrgPeriodoLectivoList(this.orgPeriodoEstructuraFacade.obtienePeriodoLectivoDoctorado());
				// System.out.println("Cohorte sin Estructura");
			}

		}
		else if (this.secOrgEstructuraController.getTipoEstructura() == TipoEstructura.PROGRAMA) {
			if (obtenerEstructura() != null) {

				setOrgPeriodoLectivoList(
						this.orgPeriodoEstructuraFacade.obtieneCohortePorEstructura(obtenerEstructura()));
				// System.out.println("Cohorte por Estructura");
			}
			else {
				setOrgPeriodoLectivoList(this.orgPeriodoEstructuraFacade.obtienePeriodoLectivo());
				// System.out.println("Cohorte sin Estructura");
			}
		}

		updateNivelMallaList();
	}

	public void updateModalidadPorProgramaList() {
		setPedModalidadList(null);
		// updateGrupoList();

		if (obtenerEstructura() != null) {
			setPedModalidadList(this.pedModalidadFacade.obtieneModalidadPorEstructura(obtenerEstructura()));

		}
		else {
			setPedModalidadList(this.pedModalidadFacade.obtieneModalidad());
		}

		updateNivelMallaList();

	}

	/**
	 * Actualizar lista de asignaturas por carrera.
	 */
	public void updateAsignaturaList() {
		setPedMalla(null);
		setPedMallaList(null);
		updateGrupoList();
		Long pelCodigo = 0L;
		if (getOrgPeriodoInicial() != null) {
			if (getOrgPeriodoInicial().getPelCodigo() != null) {
				pelCodigo = getOrgPeriodoInicial().getPelCodigo();
			}
		}

		Long estCodigo = 0L;
		if (getOrgEstructuraCarrera() != null) {
			estCodigo = getOrgEstructuraCarrera().getEstCodigo();
		}
		else if (getOrgEstructuraCampus() != null) {
			estCodigo = getOrgEstructuraCampus().getEstCodigo();
		}
		else if (getOrgEstructuraSede() != null) {
			estCodigo = getOrgEstructuraSede().getEstCodigo();
		}

		if (getGthPersona() != null && pelCodigo != 0L) {
			setPedMallaList(this.pedMallaFacade.obtieneMallaDocente(estCodigo, getGthPersona(), pelCodigo));
		}
		if (getGthPersona() == null && pelCodigo != 0L) {
			setPedMallaList(null);
		}
	}

	/**
	 * Actualizar lista de grupos por malla.
	 */
	public void updateGrupoList() {
		setOfeGrupo(null);
		setOfeGrupoList(null);
		Long pelCodigoI = 0L;
		if (getOrgPeriodoInicial() != null) {
			if (getOrgPeriodoInicial().getPelCodigo() != null) {
				pelCodigoI = getOrgPeriodoInicial().getPelCodigo();
			}
		}

		Long pelCodigoF = 0L;
		if (getOrgPeriodoFinal() != null) {
			if (getOrgPeriodoFinal().getPelCodigo() != null) {
				pelCodigoF = getOrgPeriodoFinal().getPelCodigo();
			}
			else {
				pelCodigoF = pelCodigoI;
			}
		}
		else {
			pelCodigoF = pelCodigoI;
		}

		Long estCodigo = 0L;
		if (getOrgEstructuraCarrera() != null) {
			estCodigo = getOrgEstructuraCarrera().getEstCodigo();
		}
		else if (getOrgEstructuraCampus() != null) {
			estCodigo = getOrgEstructuraCampus().getEstCodigo();
		}
		else if (getOrgEstructuraSede() != null) {
			estCodigo = getOrgEstructuraSede().getEstCodigo();
		}

		if (getPedMalla() != null && getOrgPeriodoInicial() != null && getGthPersona() != null) {
			setOfeGrupoList(this.ofeGrupoFacade.obtieneGrupo(getPedMalla(), pelCodigoI, pelCodigoF, getGthPersona(),
					estCodigo));
		}
	}

	public OrgEstructura getOrgEstructuraSede() {
		return this.orgEstructuraSede;
	}

	public void setOrgEstructuraSede(OrgEstructura orgEstructuraSede) {
		this.orgEstructuraSede = orgEstructuraSede;
	}

	public OrgEstructura getOrgEstructuraCampus() {
		return this.orgEstructuraCampus;
	}

	public void setOrgEstructuraCampus(OrgEstructura orgEstructuraCampus) {
		this.orgEstructuraCampus = orgEstructuraCampus;
	}

	public OrgEstructura getOrgEstructuraCarrera() {
		return this.orgEstructuraCarrera;
	}

	public void setOrgEstructuraCarrera(OrgEstructura orgEstructuraCarrera) {
		this.orgEstructuraCarrera = orgEstructuraCarrera;
	}

	public OrgPeriodoLectivo getOrgPeriodoInicial() {
		return this.orgPeriodoInicial;
	}

	public void setOrgPeriodoInicial(OrgPeriodoLectivo orgPeriodoInicial) {
		this.orgPeriodoInicial = orgPeriodoInicial;
	}

	public OrgPeriodoLectivo getOrgPeriodoFinal() {
		return this.orgPeriodoFinal;
	}

	public void setOrgPeriodoFinal(OrgPeriodoLectivo orgPeriodoFinal) {
		this.orgPeriodoFinal = orgPeriodoFinal;
	}

	public PedModalidad getPedModalidad() {
		return this.pedModalidad;
	}

	public void setPedModalidad(PedModalidad pedModalidad) {
		this.pedModalidad = pedModalidad;
	}

	public GthPersona getGthPersona() {
		return this.gthPersona;
	}

	public void setGthPersona(GthPersona gthPersona) {
		this.gthPersona = gthPersona;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public OfeGrupo getOfeGrupo() {
		return this.ofeGrupo;
	}

	public void setOfeGrupo(OfeGrupo ofeGrupo) {
		this.ofeGrupo = ofeGrupo;
	}

	public List<OrgEstructura> getOrgEstructuraSedeList() {
		if (this.orgEstructuraSedeList == null) {
			updateSedeList();
		}
		return this.orgEstructuraSedeList;
	}

	public void setOrgEstructuraSedeList(List<OrgEstructura> orgEstructuraSedeList) {
		this.orgEstructuraSedeList = orgEstructuraSedeList;
	}

	public List<OrgEstructura> getOrgEstructuraCampusList() {
		return this.orgEstructuraCampusList;
	}

	public void setOrgEstructuraCampusList(List<OrgEstructura> orgEstructuraCampusList) {
		this.orgEstructuraCampusList = orgEstructuraCampusList;
	}

	public List<OrgEstructura> getOrgEstructuraCarreraList() {
		return this.orgEstructuraCarreraList;
	}

	public void setOrgEstructuraCarreraList(List<OrgEstructura> orgEstructuraCarreraList) {
		this.orgEstructuraCarreraList = orgEstructuraCarreraList;
	}

	public List<OrgPeriodoLectivo> getOrgPeriodoLectivoList() {
		// if(orgPeriodoLectivoList==null){
		// updatePeriodoPorCampusList();
		// }
		return this.orgPeriodoLectivoList;
	}

	public void setOrgPeriodoLectivoList(List<OrgPeriodoLectivo> orgPeriodoLectivoList) {
		this.orgPeriodoLectivoList = orgPeriodoLectivoList;
	}

	public String getAnio() {
		return this.Anio;
	}

	public void setAnio(String Anio) {
		this.Anio = Anio;
	}

	public List<GthPersona> getGthPersonaList() {
		Long pelCodigo = 0L;
		if (getOrgPeriodoInicial() != null) {
			if (getOrgPeriodoInicial().getPelCodigo() != null) {
				pelCodigo = getOrgPeriodoInicial().getPelCodigo();
			}
		}

		if (this.gthPersonaList == null) {
			if (getOrgEstructuraCarrera() != null) {
				this.gthPersonaList = this.gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),
						getOrgEstructuraCarrera().getEstCodigo(), pelCodigo);

			}
			else if (getOrgEstructuraCampus() != null) {
				this.gthPersonaList = this.gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),
						getOrgEstructuraCampus().getEstCodigo(), pelCodigo);

			}
			else if (getOrgEstructuraSede() != null) {
				this.gthPersonaList = this.gthPersonaFacade.listaGthPersonaFiltro(getFiltro(),
						getOrgEstructuraSede().getEstCodigo(), pelCodigo);

			}
			else {
				this.gthPersonaList = this.gthPersonaFacade.listaGthPersonaFiltro(getFiltro(), 0L, pelCodigo);
			}
			// System.out.println("lista" + gthPersonaList.size() );
		}
		return this.gthPersonaList;
	}

	public void setGthPersonaList(List<GthPersona> gthPersonaList) {
		this.gthPersonaList = gthPersonaList;
	}

	public List<PedMalla> getPedMallaList() {
		return this.pedMallaList;
	}

	public void setPedMallaList(List<PedMalla> pedMallaList) {
		this.pedMallaList = pedMallaList;
	}

	public List<OfeGrupo> getOfeGrupoList() {
		return this.ofeGrupoList;
	}

	public void setOfeGrupoList(List<OfeGrupo> ofeGrupoList) {
		this.ofeGrupoList = ofeGrupoList;
	}

	public void setAnioList(List<String> listadoAnio) {
		this.listadoAnio = listadoAnio;
	}

	public List<String> getAnioList() {
		this.listadoAnio = new ArrayList<>();
		for (int years = Calendar.getInstance().get(Calendar.YEAR); years >= Calendar.getInstance().get(Calendar.YEAR)
				- 10; years--) {
			this.listadoAnio.add(years + "");
		}
		return this.listadoAnio;
	}

	public String getFiltro() {
		return this.filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<GthPersona> completePersona(String query) {
		List<GthPersona> suggestions = new ArrayList<>();
		filtrarDocente(query.toUpperCase(Locale.getDefault()));
		for (GthPersona i : getGthPersonaList()) {
			if (suggestions.size() < this.maxResult
					&& (i.getPerApellidos().contains(query.toUpperCase(Locale.getDefault()))
							|| i.getPerNombres().contains(query.toUpperCase(Locale.getDefault()))
							|| i.getPerNroIdentificacion().contains(query.toUpperCase(Locale.getDefault())))) {
				suggestions.add(i);
			}
		}
		return suggestions;
	}

	public void filtrarDocente(String value) {
		setFiltro(value);
		setGthPersonaList(null);
	}

	public void cambioSede() {
		setOrgEstructuraCampus(null);
		setOrgEstructuraCampusList(null);
		updateCampusList();
	}

	public boolean compruebaParametro(RepReportesSistema repReportesSistema, Long codigoParametro) {
		List<RepParametroReporte> parametroReporteList = this.repParametroReporteFacade
			.obtieneParametroPorReporte(codigoParametro, repReportesSistema);
		return !(parametroReporteList == null || parametroReporteList.isEmpty());
	}

	public void actualizaFiltros() {
		setOrgEstructuraSede(null);
		setOrgEstructuraSedeList(null);
		setOrgEstructuraCampus(null);
		setOrgEstructuraCampusList(null);
		setOrgEstructuraCarrera(null);
		setOrgEstructuraCarreraList(null);
		setOrgPeriodoInicial(null);
		setOrgPeriodoFinal(null);
		setOrgPeriodoLectivoList(null);
		setPedModalidad(null);
		setPedModalidadList(null);
		setPedMallaNivelList(null);
		setPedNivelMalla(null);
		setGthPersona(null);
		setGthPersonaList(null);
		setPedMalla(null);
		setPedMallaList(null);
		setOfeGrupo(null);
		setOfeGrupoList(null);
		updateSedeList();
		setInsAlumnoWrapper(null);
		// PrimeFaces.current().ajax().update("PosReportesForm:PosRepFiltroPanel");

	}

	public boolean isValidaSeleccionEstructuraSeguridadSede() {
		return this.validaSeleccionEstructuraSeguridadSede;
	}

	public void setValidaSeleccionEstructuraSeguridadSede(boolean validaSeleccionEstructuraSeguridadSede) {
		this.validaSeleccionEstructuraSeguridadSede = validaSeleccionEstructuraSeguridadSede;
	}

	public boolean isValidaSeleccionEstructuraSeguridadCampus() {
		return this.validaSeleccionEstructuraSeguridadCampus;
	}

	public void setValidaSeleccionEstructuraSeguridadCampus(boolean validaSeleccionEstructuraSeguridadCampus) {
		this.validaSeleccionEstructuraSeguridadCampus = validaSeleccionEstructuraSeguridadCampus;
	}

	public boolean isValidaSeleccionEstructuraSeguridadCarrProg() {
		return this.validaSeleccionEstructuraSeguridadCarrProg;
	}

	public void setValidaSeleccionEstructuraSeguridadCarrProg(boolean validaSeleccionEstructuraSeguridadCarrProg) {
		this.validaSeleccionEstructuraSeguridadCarrProg = validaSeleccionEstructuraSeguridadCarrProg;
	}

	public String obtieneModalidad(Long modCodigo) {
		if (modCodigo == null) {
			return "";
		}
		PedModalidad pedModalidadDes = this.pedModalidadFacade.find(modCodigo);
		if (pedModalidadDes != null) {
			return pedModalidadDes.getModDescripcion();
		}
		else {
			return "";
		}
	}

	public String obtieneCampus(Long estCodigo) {
		if (estCodigo == null) {
			return "";
		}
		OrgEstructura orgEstructuraDes = this.orgEstructuraFacade.find(estCodigo);
		if (orgEstructuraDes != null) {
			return orgEstructuraDes.getOrgDescripcionEstructura().getDeeDescripcion();
		}
		else {
			return "";
		}
	}

	public List<Integer> getPedMallaNivelList() {
		return this.pedMallaNivelList;
	}

	public void setPedMallaNivelList(List<Integer> pedMallaNivelList) {
		this.pedMallaNivelList = pedMallaNivelList;
	}

	public Integer getPedNivelMalla() {
		return this.pedNivelMalla;
	}

	public void setPedNivelMalla(Integer pedNivelMalla) {
		this.pedNivelMalla = pedNivelMalla;
	}

	/**
	 * Actualizar lista de nivel de asignatura revisaaaaaar.
	 */
	public void updateNivelMallaList() {

		setPedMallaNivelList(null);
		OrgPeriodoLectivo orgPeriodoInicial = getOrgPeriodoInicial();

		if (orgPeriodoInicial != null) {

			if (obtenerEstructura() != null) {
				this.pedMallaNivelList = this.pedMallaFacade.obtieneNivelMalla(obtenerEstructura().getEstCodigo(),
						getOrgPeriodoInicial().getPelCodigo());
			}
			else {
				this.pedMallaNivelList = this.pedMallaFacade.obtieneNivelMalla(PosRepConstants.TODAS_SEDES,
						getOrgPeriodoInicial().getPelCodigo());
			}
		}

	}

	public OrgEstructura obtenerEstructura() {

		OrgEstructura estructuraSeleccionada = null;
		if (getOrgEstructuraCarrera() != null) {
			estructuraSeleccionada = getOrgEstructuraCarrera();
		}
		else {
			if (getOrgEstructuraCampus() != null) {
				estructuraSeleccionada = getOrgEstructuraCampus();
			}
			else {
				if (getOrgEstructuraSede() != null) {
					estructuraSeleccionada = getOrgEstructuraSede();
				}
			}

		}
		return estructuraSeleccionada;

	}

	// public String obtenerAnioPosgrado(Date fechaInicio, Date fechaFin ) {
	// nuevo cambio en metodo en PosREPResultadoControler
	public String obtenerAnioPosgrado(OrgPeriodoLectivo periodoLec) {

		Date fechaInicio = new Date();
		Date fechaFin = new Date();

		if (getOrgEstructuraCarrera() != null) {

			OrgPeriodoEstructura periodoEst = this.orgPeriodoEstructuraFacade
				.obtieneCohorteEstructura(getOrgEstructuraCarrera().getEstCodigo(), periodoLec.getPelCodigo());

			fechaInicio = periodoEst.getPeeFechaInicialCohorte(); // .getPeeFechaInicial();//
			// getFechaa Inicial
			// Cohorte EStructura;
			// -- campo hay que
			// subir

			// System.out.println("fechaInicio"+fechaInicio);
			fechaFin = periodoEst.getPeeFechaFinalCohorte(); // ---falta
			// System.out.println("fechaFin"+fechaFin);
		}
		else {
			fechaInicio = periodoLec.getPelFechaInicio();

			fechaFin = periodoLec.getPelFechaFin();
		}
		Calendar fecha1 = Calendar.getInstance();
		fecha1.setTime(fechaInicio);
		Calendar fecha2 = Calendar.getInstance();
		fecha2.setTime(fechaFin);
		int anioIni = fecha1.get(Calendar.YEAR);
		int anioFin = fecha2.get(Calendar.YEAR);
		String anio_posgrado = Integer.toString(anioIni) + " - " + Integer.toString(anioFin);

		return anio_posgrado;
	}

	public InsAlumnoFacade getInsAlumnoFacade() {
		return this.insAlumnoFacade;
	}

	public void setInsAlumnoFacade(InsAlumnoFacade insAlumnoFacade) {
		this.insAlumnoFacade = insAlumnoFacade;
	}

	// Metodo controllers
	public List<InsAlumnoWrapper> getListadoAlumnos() {
		return this.listadoAlumnos;
	}

	public void setListadoAlumnos(List<InsAlumnoWrapper> listadoAlumnos) {
		this.listadoAlumnos = listadoAlumnos;
	}

	public List<InsAlumnoWrapper> autoCompleteAlumnos(String query) {
		List<InsAlumnoWrapper> suggestions = new ArrayList<>();

		if (!Utils.isEmpty(query)) {
			String replace = query.replace(" ", "%%");
			suggestions = this.insAlumnoFacade.findAlumnoWrapper(replace);
		}
		System.out.println(suggestions);
		setListadoAlumnos(suggestions);
		return suggestions;
	}

	public InsAlumnoWrapper getInsAlumnoWrapper() {
		return this.insAlumnoWrapper;
	}

	public void setInsAlumnoWrapper(InsAlumnoWrapper insAlumnoWrapper) {
		this.insAlumnoWrapper = insAlumnoWrapper;
	}

	public String getPafPagado() {
		return this.pafPagado;
	}

	public void setPafPagado(String pafPagado) {
		this.pafPagado = pafPagado;
	}

	public List<PedModalidad> getPedModalidadList() {
		return this.pedModalidadList;
	}

	public void setPedModalidadList(List<PedModalidad> pedModalidadList) {
		this.pedModalidadList = pedModalidadList;
	}

	// Sede de Emision
	public void updateSedeEmisionList() {

		if (this.secOrgEstructuraController.getEstructuraSede().getEstCodigo().equals(PosRepConstants.TODAS_SEDES)) {
			setValidaSeleccionEstructuraSeguridadSede(false);
			this.orgEstructuraSedeEmisionList = this.orgEstructuraFacade.listaEstructuraSedeActivo();
		}
		else {
			setValidaSeleccionEstructuraSeguridadSede(true);
			setOrgEstructuraSedeEmisionList(Arrays.asList(
					this.orgEstructuraFacade.find(this.secOrgEstructuraController.getEstructuraSede().getEstCodigo())));
			if (!this.orgEstructuraSedeEmisionList.isEmpty()) {
				setOrgEstructuraSedeEmision(getOrgEstructuraSedeEmisionList().get(0));
			}
		}
		updateCampusEmisionList();
	}

	// Campus de Emision
	public void updateCampusEmisionList() {

		if (getOrgEstructuraSedeEmision() != null) {
			// System.out.println("campus Emision diferente de null");

			if (!Objects.equals(this.secOrgEstructuraController.getEstructuraCampus().getEstCodigo(),
					PosRepConstants.TODOS_CAMPUS)
					&& !Objects.equals(this.secOrgEstructuraController.getEstructuraSede().getEstCodigo(),
							PosRepConstants.TODAS_SEDES)) {
				this.validaSeleccionEstructuraSeguridadCampus = true;
				setOrgEstructuraCampusEmisionList(Arrays.asList(this.orgEstructuraFacade
					.find(this.secOrgEstructuraController.getEstructuraCampus().getEstCodigo())));

				if (!(this.orgEstructuraCampusEmisionList.isEmpty())) {
					setOrgEstructuraCampusEmision(this.orgEstructuraCampusEmisionList.get(0));
					// System.out.println("campus 2");
				}
			}
			else {
				this.validaSeleccionEstructuraSeguridadCampus = false;
				this.orgEstructuraCampusEmisionList = this.orgEstructuraFacade
					.listaEstructuraCampusActivo(getOrgEstructuraSedeEmision());

			}
		}

	}

	public OrgEstructura getOrgEstructuraSedeEmision() {
		return this.orgEstructuraSedeEmision;
	}

	public void setOrgEstructuraSedeEmision(OrgEstructura orgEstructuraSedeEmision) {
		this.orgEstructuraSedeEmision = orgEstructuraSedeEmision;
	}

	public OrgEstructura getOrgEstructuraCampusEmision() {
		return this.orgEstructuraCampusEmision;
	}

	public void setOrgEstructuraCampusEmision(OrgEstructura orgEstructuraCampusEmision) {
		this.orgEstructuraCampusEmision = orgEstructuraCampusEmision;
	}

	public List<OrgEstructura> getOrgEstructuraSedeEmisionList() {
		if (this.orgEstructuraSedeEmisionList == null) {
			updateSedeEmisionList();
		}
		return this.orgEstructuraSedeEmisionList;
	}

	public void setOrgEstructuraSedeEmisionList(List<OrgEstructura> orgEstructuraSedeEmisionList) {
		this.orgEstructuraSedeEmisionList = orgEstructuraSedeEmisionList;
	}

	public List<OrgEstructura> getOrgEstructuraCampusEmisionList() {
		return this.orgEstructuraCampusEmisionList;
	}

	public void setOrgEstructuraCampusEmisionList(List<OrgEstructura> orgEstructuraCampusEmisionList) {
		this.orgEstructuraCampusEmisionList = orgEstructuraCampusEmisionList;
	}

}
