package ec.edu.ups.pos.rep.data.entities.ped;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MALLA", schema = "PED",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "MAT_CODIGO", "PRE_NUMERO" }) })
public class PedMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAL_CODIGO", nullable = false, updatable = false)
	private Long malCodigo;

	@Column(name = "MAL_NIVEL")
	private Integer malNivel;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MAL_NRO_CREDITOS", nullable = false, precision = 5, scale = 2)
	private BigDecimal malNroCreditos;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MAL_NRO_HORAS", nullable = false)
	private Integer malNroHoras;

	@Column(name = "MAL_NRO_HORAS_POR_SEMANA")
	private Integer malNroHorasPorSemana;

	@Column(name = "MAL_PORCENTAJE", precision = 5, scale = 2)
	private BigDecimal malPorcentaje;

	@Size(max = 100)
	@Column(name = "MAL_CODIGO_ASIGNATURA", length = 100)
	private String malCodigoAsignatura;

	@Size(max = 100)
	@Column(name = "MAL_CODIGO_OFERTA", length = 100)
	private String malCodigoOferta;

	@Size(max = 1)
	@Column(name = "MAL_TIPO", length = 1)
	private String malTipo;

	@Size(max = 1)
	@Column(name = "MAL_TIPO_PERIODO", length = 1)
	private String malTipoPeriodo;

	@Size(max = 1)
	@Column(name = "MAL_TIENE_PRERREQUISITO", length = 1)
	private String malTienePrerrequisito;

	@Column(name = "MAL_NRO_HORAS_PREPROFESIONAL")
	private Integer malNroHorasPreprofesional;

	@Size(max = 1)
	@Column(name = "MAL_SERVICIO_COMUNITARIO", length = 1)
	private String malServicioComunitario;

	@Size(max = 1)
	@Column(name = "MAL_TRABAJO_TITULACION", length = 1)
	private String malTrabajoTitulacion;

	@Size(max = 1)
	@Column(name = "MAL_ITINERARIO", length = 1)
	private String malItinerario;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAL_VISUALIZAR", nullable = false, length = 1)
	private String malVisualizar;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAL_TIPO_ACTIVIDAD", nullable = false, length = 1)
	private String malTipoActividad;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAL_OBLIGATORIO", nullable = false, length = 1)
	private String malObligatorio;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "MAL_NIVEL_TRABAJO_TITULACION", nullable = false, length = 20)
	private String malNivelTrabajoTitulacion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAL_TIPO_ACTIVIDAD_SECUNDARIA", nullable = false, length = 1)
	private String malTipoActividadSecundaria;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "pedMalla")
	private Collection<PedComAprMal> pedComAprMalCollection;

	@JoinColumn(name = "TIM_CODIGO", referencedColumnName = "TIM_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoMalla pedTipoMalla;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	@JoinColumn(name = "ORA_CODIGO", referencedColumnName = "ORA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedOrganizacionAprendizaje pedOrganizacionAprendizaje;

	@JoinColumn(name = "MAT_CODIGO", referencedColumnName = "MAT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMateria pedMateria;

	@JoinColumn(name = "CAF_CODIGO", referencedColumnName = "CAF_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedCampoFormacion pedCampoFormacion;

	@JoinColumn(name = "APE_CODIGO", referencedColumnName = "APE_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedAreaPlanEstudio pedAreaPlanEstudio;

	@JoinColumn(name = "MOD_CODIGO", referencedColumnName = "MOD_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedModalidad pedModalidad;

	@JoinColumn(name = "UOC_CODIGO", referencedColumnName = "UOC_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedUniOrgCur pedUniOrgCur;

	@JoinColumn(name = "MOA_CODIGO", referencedColumnName = "MOA_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedModOrgApr pedModOrgApr;

	@JoinColumn(name = "NIP_CODIGO", referencedColumnName = "NIP_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedNivelParacademico pedNivelParacademico;

	@JoinColumn(name = "NIM_CODIGO", referencedColumnName = "NIM_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedNivelMalla pedNivelMalla;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla")
	private Collection<PedDocenteMalla> pedDocenteMallaCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla")
	private Collection<PedItinerarioMalla> pedItinerarioMallaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla")
	private Collection<PedPrerrequisito> pedPrerrequisitoCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMallaPrerrequisito")
	private Collection<PedPrerrequisito> pedPrerrequisitoCollection1;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla")
	private Collection<PedComponenteMicro> pedComponenteMicroCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla")
	private Collection<PedEvidenciaPortafolioMalla> pedEvidenciaPortafolioMallaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla")
	private Collection<PedCorrequisito> pedCorrequisitoCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMallaCorrequisito")
	private Collection<PedCorrequisito> pedCorrequisitoCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaArea> pedMallaAreaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedUnidadCurricular> pedUnidadCurricularCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedResultadoAprendizaje> pedResultadoAprendizajeCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaParacademico> pedMallaParacademicoCollection;

	@OneToMany(mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedModProEdu> pedModProEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaBibliografia> pedMallaBibliografiaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaMencion> pedMallaMencionCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaModalidad> pedMallaModalidadCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedContenidoMinimo> pedContenidoMinimoCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedHisProAna> pedHisProAnaCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaCorrelacion> pedMallaCorrelacionCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMallaCorrelaci", fetch = FetchType.LAZY)
	private Collection<PedMallaCorrelacion> pedMallaCorrelacionCollection1;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaPeriodoHabilitante> pedMallaPeriodoHabilitanteCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedMalla", fetch = FetchType.LAZY)
	private Collection<PedMallaTipoOferta> pedMallaTipoOfertaCollection;

	@Transient
	private String notaUnicaAsignaturaPracticaPreprofesional;

	public PedMalla() {
	}

	public PedMalla(Long malCodigo) {
		this.malCodigo = malCodigo;
	}

	public PedMalla(Long malCodigo, BigDecimal malNroCreditos, Integer malNroHoras, Integer malNroHorasPorSemana) {
		this.malCodigo = malCodigo;
		this.malNroCreditos = malNroCreditos;
		this.malNroHoras = malNroHoras;
		this.malNroHorasPorSemana = malNroHorasPorSemana;
	}

	public Long getMalCodigo() {
		return this.malCodigo;
	}

	public void setMalCodigo(Long malCodigo) {
		this.malCodigo = malCodigo;
	}

	public Integer getMalNivel() {
		return this.malNivel;
	}

	public void setMalNivel(Integer malNivel) {
		this.malNivel = malNivel;
	}

	public BigDecimal getMalNroCreditos() {
		return this.malNroCreditos;
	}

	public void setMalNroCreditos(BigDecimal malNroCreditos) {
		this.malNroCreditos = malNroCreditos;
	}

	public Integer getMalNroHoras() {
		return this.malNroHoras;
	}

	public void setMalNroHoras(Integer malNroHoras) {
		this.malNroHoras = malNroHoras;
	}

	public Integer getMalNroHorasPorSemana() {
		return this.malNroHorasPorSemana;
	}

	public void setMalNroHorasPorSemana(Integer malNroHorasPorSemana) {
		this.malNroHorasPorSemana = malNroHorasPorSemana;
	}

	public BigDecimal getMalPorcentaje() {
		return this.malPorcentaje;
	}

	public void setMalPorcentaje(BigDecimal malPorcentaje) {
		this.malPorcentaje = malPorcentaje;
	}

	public String getMalCodigoAsignatura() {
		return this.malCodigoAsignatura;
	}

	public void setMalCodigoAsignatura(String malCodigoAsignatura) {
		this.malCodigoAsignatura = malCodigoAsignatura;
	}

	public String getMalCodigoOferta() {
		return this.malCodigoOferta;
	}

	public void setMalCodigoOferta(String malCodigoOferta) {
		this.malCodigoOferta = malCodigoOferta;
	}

	public String getMalTipo() {
		return this.malTipo;
	}

	public void setMalTipo(String malTipo) {
		this.malTipo = malTipo;
	}

	public String getMalTipoPeriodo() {
		return this.malTipoPeriodo;
	}

	public void setMalTipoPeriodo(String malTipoPeriodo) {
		this.malTipoPeriodo = malTipoPeriodo;
	}

	public String getMalTienePrerrequisito() {
		return this.malTienePrerrequisito;
	}

	public void setMalTienePrerrequisito(String malTienePrerrequisito) {
		this.malTienePrerrequisito = malTienePrerrequisito;
	}

	public Integer getMalNroHorasPreprofesional() {
		return this.malNroHorasPreprofesional;
	}

	public void setMalNroHorasPreprofesional(Integer malNroHorasPreprofesional) {
		this.malNroHorasPreprofesional = malNroHorasPreprofesional;
	}

	public String getMalServicioComunitario() {
		return this.malServicioComunitario;
	}

	public void setMalServicioComunitario(String malServicioComunitario) {
		this.malServicioComunitario = malServicioComunitario;
	}

	public String getMalTrabajoTitulacion() {
		return this.malTrabajoTitulacion;
	}

	public void setMalTrabajoTitulacion(String malTrabajoTitulacion) {
		this.malTrabajoTitulacion = malTrabajoTitulacion;
	}

	public String getMalItinerario() {
		return this.malItinerario;
	}

	public void setMalItinerario(String malItinerario) {
		this.malItinerario = malItinerario;
	}

	public String getMalVisualizar() {
		return this.malVisualizar;
	}

	public void setMalVisualizar(String malVisualizar) {
		this.malVisualizar = malVisualizar;
	}

	public String getMalTipoActividad() {
		return this.malTipoActividad;
	}

	public void setMalTipoActividad(String malTipoActividad) {
		this.malTipoActividad = malTipoActividad;
	}

	public String getMalObligatorio() {
		return this.malObligatorio;
	}

	public void setMalObligatorio(String malObligatorio) {
		this.malObligatorio = malObligatorio;
	}

	public String getMalNivelTrabajoTitulacion() {
		return this.malNivelTrabajoTitulacion;
	}

	public void setMalNivelTrabajoTitulacion(String malNivelTrabajoTitulacion) {
		this.malNivelTrabajoTitulacion = malNivelTrabajoTitulacion;
	}

	public String getMalTipoActividadSecundaria() {
		return this.malTipoActividadSecundaria;
	}

	public void setMalTipoActividadSecundaria(String malTipoActividadSecundaria) {
		this.malTipoActividadSecundaria = malTipoActividadSecundaria;
	}

	public Collection<PedComAprMal> getPedComAprMalCollection() {
		return this.pedComAprMalCollection;
	}

	public void setPedComAprMalCollection(Collection<PedComAprMal> pedComAprMalCollection) {
		this.pedComAprMalCollection = pedComAprMalCollection;
	}

	public PedTipoMalla getPedTipoMalla() {
		return this.pedTipoMalla;
	}

	public void setPedTipoMalla(PedTipoMalla pedTipoMalla) {
		this.pedTipoMalla = pedTipoMalla;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	public PedOrganizacionAprendizaje getPedOrganizacionAprendizaje() {
		return this.pedOrganizacionAprendizaje;
	}

	public void setPedOrganizacionAprendizaje(PedOrganizacionAprendizaje pedOrganizacionAprendizaje) {
		this.pedOrganizacionAprendizaje = pedOrganizacionAprendizaje;
	}

	public PedMateria getPedMateria() {
		return this.pedMateria;
	}

	public void setPedMateria(PedMateria pedMateria) {
		this.pedMateria = pedMateria;
	}

	public PedCampoFormacion getPedCampoFormacion() {
		return this.pedCampoFormacion;
	}

	public void setPedCampoFormacion(PedCampoFormacion pedCampoFormacion) {
		this.pedCampoFormacion = pedCampoFormacion;
	}

	public PedAreaPlanEstudio getPedAreaPlanEstudio() {
		return this.pedAreaPlanEstudio;
	}

	public void setPedAreaPlanEstudio(PedAreaPlanEstudio pedAreaPlanEstudio) {
		this.pedAreaPlanEstudio = pedAreaPlanEstudio;
	}

	public PedModalidad getPedModalidad() {
		return this.pedModalidad;
	}

	public void setPedModalidad(PedModalidad pedModalidad) {
		this.pedModalidad = pedModalidad;
	}

	public PedUniOrgCur getPedUniOrgCur() {
		return this.pedUniOrgCur;
	}

	public void setPedUniOrgCur(PedUniOrgCur pedUniOrgCur) {
		this.pedUniOrgCur = pedUniOrgCur;
	}

	public PedModOrgApr getPedModOrgApr() {
		return this.pedModOrgApr;
	}

	public void setPedModOrgApr(PedModOrgApr pedModOrgApr) {
		this.pedModOrgApr = pedModOrgApr;
	}

	public PedNivelParacademico getPedNivelParacademico() {
		return this.pedNivelParacademico;
	}

	public void setPedNivelParacademico(PedNivelParacademico pedNivelParacademico) {
		this.pedNivelParacademico = pedNivelParacademico;
	}

	public PedNivelMalla getPedNivelMalla() {
		return this.pedNivelMalla;
	}

	public void setPedNivelMalla(PedNivelMalla pedNivelMalla) {
		this.pedNivelMalla = pedNivelMalla;
	}

	public Collection<PedDocenteMalla> getPedDocenteMallaCollection() {
		return this.pedDocenteMallaCollection;
	}

	public void setPedDocenteMallaCollection(Collection<PedDocenteMalla> pedDocenteMallaCollection) {
		this.pedDocenteMallaCollection = pedDocenteMallaCollection;
	}

	public Collection<PedItinerarioMalla> getPedItinerarioMallaCollection() {
		return this.pedItinerarioMallaCollection;
	}

	public void setPedItinerarioMallaCollection(Collection<PedItinerarioMalla> pedItinerarioMallaCollection) {
		this.pedItinerarioMallaCollection = pedItinerarioMallaCollection;
	}

	public Collection<PedPrerrequisito> getPedPrerrequisitoCollection() {
		return this.pedPrerrequisitoCollection;
	}

	public void setPedPrerrequisitoCollection(Collection<PedPrerrequisito> pedPrerrequisitoCollection) {
		this.pedPrerrequisitoCollection = pedPrerrequisitoCollection;
	}

	public Collection<PedPrerrequisito> getPedPrerrequisitoCollection1() {
		return this.pedPrerrequisitoCollection1;
	}

	public void setPedPrerrequisitoCollection1(Collection<PedPrerrequisito> pedPrerrequisitoCollection1) {
		this.pedPrerrequisitoCollection1 = pedPrerrequisitoCollection1;
	}

	public Collection<PedComponenteMicro> getPedComponenteMicroCollection() {
		return this.pedComponenteMicroCollection;
	}

	public void setPedComponenteMicroCollection(Collection<PedComponenteMicro> pedComponenteMicroCollection) {
		this.pedComponenteMicroCollection = pedComponenteMicroCollection;
	}

	public Collection<PedEvidenciaPortafolioMalla> getPedEvidenciaPortafolioMallaCollection() {
		return this.pedEvidenciaPortafolioMallaCollection;
	}

	public void setPedEvidenciaPortafolioMallaCollection(
			Collection<PedEvidenciaPortafolioMalla> pedEvidenciaPortafolioMallaCollection) {
		this.pedEvidenciaPortafolioMallaCollection = pedEvidenciaPortafolioMallaCollection;
	}

	public Collection<PedCorrequisito> getPedCorrequisitoCollection() {
		return this.pedCorrequisitoCollection;
	}

	public void setPedCorrequisitoCollection(Collection<PedCorrequisito> pedCorrequisitoCollection) {
		this.pedCorrequisitoCollection = pedCorrequisitoCollection;
	}

	public Collection<PedCorrequisito> getPedCorrequisitoCollection1() {
		return this.pedCorrequisitoCollection1;
	}

	public void setPedCorrequisitoCollection1(Collection<PedCorrequisito> pedCorrequisitoCollection1) {
		this.pedCorrequisitoCollection1 = pedCorrequisitoCollection1;
	}

	public Collection<PedMallaArea> getPedMallaAreaCollection() {
		return this.pedMallaAreaCollection;
	}

	public void setPedMallaAreaCollection(Collection<PedMallaArea> pedMallaAreaCollection) {
		this.pedMallaAreaCollection = pedMallaAreaCollection;
	}

	public Collection<PedUnidadCurricular> getPedUnidadCurricularCollection() {
		return this.pedUnidadCurricularCollection;
	}

	public void setPedUnidadCurricularCollection(Collection<PedUnidadCurricular> pedUnidadCurricularCollection) {
		this.pedUnidadCurricularCollection = pedUnidadCurricularCollection;
	}

	public Collection<PedResultadoAprendizaje> getPedResultadoAprendizajeCollection() {
		return this.pedResultadoAprendizajeCollection;
	}

	public void setPedResultadoAprendizajeCollection(
			Collection<PedResultadoAprendizaje> pedResultadoAprendizajeCollection) {
		this.pedResultadoAprendizajeCollection = pedResultadoAprendizajeCollection;
	}

	public Collection<PedMallaParacademico> getPedMallaParacademicoCollection() {
		return this.pedMallaParacademicoCollection;
	}

	public void setPedMallaParacademicoCollection(Collection<PedMallaParacademico> pedMallaParacademicoCollection) {
		this.pedMallaParacademicoCollection = pedMallaParacademicoCollection;
	}

	public Collection<PedModProEdu> getPedModProEduCollection() {
		return this.pedModProEduCollection;
	}

	public void setPedModProEduCollection(Collection<PedModProEdu> pedModProEduCollection) {
		this.pedModProEduCollection = pedModProEduCollection;
	}

	public Collection<PedMallaBibliografia> getPedMallaBibliografiaCollection() {
		return this.pedMallaBibliografiaCollection;
	}

	public void setPedMallaBibliografiaCollection(Collection<PedMallaBibliografia> pedMallaBibliografiaCollection) {
		this.pedMallaBibliografiaCollection = pedMallaBibliografiaCollection;
	}

	public Collection<PedMallaMencion> getPedMallaMencionCollection() {
		return this.pedMallaMencionCollection;
	}

	public void setPedMallaMencionCollection(Collection<PedMallaMencion> pedMallaMencionCollection) {
		this.pedMallaMencionCollection = pedMallaMencionCollection;
	}

	public Collection<PedMallaModalidad> getPedMallaModalidadCollection() {
		return this.pedMallaModalidadCollection;
	}

	public void setPedMallaModalidadCollection(Collection<PedMallaModalidad> pedMallaModalidadCollection) {
		this.pedMallaModalidadCollection = pedMallaModalidadCollection;
	}

	public Collection<PedContenidoMinimo> getPedContenidoMinimoCollection() {
		return this.pedContenidoMinimoCollection;
	}

	public void setPedContenidoMinimoCollection(Collection<PedContenidoMinimo> pedContenidoMinimoCollection) {
		this.pedContenidoMinimoCollection = pedContenidoMinimoCollection;
	}

	public Collection<PedHisProAna> getPedHisProAnaCollection() {
		return this.pedHisProAnaCollection;
	}

	public void setPedHisProAnaCollection(Collection<PedHisProAna> pedHisProAnaCollection) {
		this.pedHisProAnaCollection = pedHisProAnaCollection;
	}

	public Collection<PedMallaCorrelacion> getPedMallaCorrelacionCollection() {
		return this.pedMallaCorrelacionCollection;
	}

	public void setPedMallaCorrelacionCollection(Collection<PedMallaCorrelacion> pedMallaCorrelacionCollection) {
		this.pedMallaCorrelacionCollection = pedMallaCorrelacionCollection;
	}

	public Collection<PedMallaCorrelacion> getPedMallaCorrelacionCollection1() {
		return this.pedMallaCorrelacionCollection1;
	}

	public void setPedMallaCorrelacionCollection1(Collection<PedMallaCorrelacion> pedMallaCorrelacionCollection1) {
		this.pedMallaCorrelacionCollection1 = pedMallaCorrelacionCollection1;
	}

	public Collection<PedMallaPeriodoHabilitante> getPedMallaPeriodoHabilitanteCollection() {
		return this.pedMallaPeriodoHabilitanteCollection;
	}

	public void setPedMallaPeriodoHabilitanteCollection(
			Collection<PedMallaPeriodoHabilitante> pedMallaPeriodoHabilitanteCollection) {
		this.pedMallaPeriodoHabilitanteCollection = pedMallaPeriodoHabilitanteCollection;
	}

	public Collection<PedMallaTipoOferta> getPedMallaTipoOfertaCollection() {
		return this.pedMallaTipoOfertaCollection;
	}

	public void setPedMallaTipoOfertaCollection(Collection<PedMallaTipoOferta> pedMallaTipoOfertaCollection) {
		this.pedMallaTipoOfertaCollection = pedMallaTipoOfertaCollection;
	}

	public String getNotaUnicaAsignaturaPracticaPreprofesional() {
		return this.notaUnicaAsignaturaPracticaPreprofesional;
	}

	public void setNotaUnicaAsignaturaPracticaPreprofesional(String notaUnicaAsignaturaPracticaPreprofesional) {
		this.notaUnicaAsignaturaPracticaPreprofesional = notaUnicaAsignaturaPracticaPreprofesional;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMalla)) {
			return false;
		}
		PedMalla other = (PedMalla) object;
		if ((this.malCodigo == null && other.malCodigo != null)
				|| (this.malCodigo != null && !this.malCodigo.equals(other.malCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.malCodigo != null) ? this.malCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMalla[ malCodigo=" + this.malCodigo + " ]";
	}

}
