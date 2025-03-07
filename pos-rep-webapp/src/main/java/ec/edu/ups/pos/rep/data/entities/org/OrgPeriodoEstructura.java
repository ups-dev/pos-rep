package ec.edu.ups.pos.rep.data.entities.org;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_PERIODO_ESTRUCTURA", schema = "ORG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "PEL_CODIGO", "EST_CODIGO", "PEE_NIVEL" }) })
public class OrgPeriodoEstructura extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PEE_CODIGO", nullable = false, updatable = false)
	private Long peeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEE_ABIERTO", nullable = false, length = 1)
	private String peeAbierto;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEE_VIGENTE", nullable = false, length = 1)
	private String peeVigente;

	@Size(max = 1)
	@Column(name = "PEE_HABILITADO", length = 1)
	private String peeHabilitado;

	@Column(name = "PEE_FECHA_INICIO_CLASE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaInicioClase;

	@Column(name = "PEE_FECHA_FIN_CLASES")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaFinClases;

	@Column(name = "PEE_FECHA_INICIO_CLASE_NUEVOS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaInicioClaseNuevos;

	@Column(name = "PEE_FECHA_FIN_CLASES_NUEVOS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaFinClasesNuevos;

	@Column(name = "PEE_FECHA_INICIO_ROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaInicioRol;

	@Column(name = "PEE_FECHA_FIN_ROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaFinRol;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEE_FECHA_INICIAL", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaInicial;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEE_FECHA_FINAL", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaFinal;

	@Column(name = "PEE_FECHA_INICIAL_COHORTE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaInicialCohorte;

	@Column(name = "PEE_FECHA_FINAL_COHORTE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date peeFechaFinalCohorte;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEE_FICHA_REQUERIDA", nullable = false, length = 1)
	private String peeFichaRequerida;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEE_FICHA_WEB_REQUERIDA", nullable = false, length = 1)
	private String peeFichaWebRequerida;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEE_NIVEL", nullable = false)
	private Integer peeNivel;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEE_HABILITADO_INSCRIPCION", nullable = false, length = 1)
	private String peeHabilitadoInscripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEE_VIGENTE_MATRICULA", nullable = false, length = 1)
	private String peeVigenteMatricula;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEE_TIPO", nullable = false, length = 1)
	private String peeTipo;

	@JoinColumn(name = "PEL_CODIGO", referencedColumnName = "PEL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgPeriodoLectivo orgPeriodoLectivo;

	@JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgEstructura orgEstructura;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orgPeriodoEstructura", fetch = FetchType.LAZY)
	private Collection<OrgPeriodoEstructuraAlumno> orgPeriodoEstructuraAlumnoCollection;

	public OrgPeriodoEstructura() {
	}

	public OrgPeriodoEstructura(Long peeCodigo) {
		this.peeCodigo = peeCodigo;
	}

	public OrgPeriodoEstructura(Long peeCodigo, String peeAbierto, String peeVigente, String peeFichaRequerida,
			String peeFichaWebRequerida) {
		this.peeCodigo = peeCodigo;
		this.peeAbierto = peeAbierto;
		this.peeVigente = peeVigente;
		this.peeFichaRequerida = peeFichaRequerida;
		this.peeFichaWebRequerida = peeFichaWebRequerida;
	}

	public Long getPeeCodigo() {
		return this.peeCodigo;
	}

	public void setPeeCodigo(Long peeCodigo) {
		this.peeCodigo = peeCodigo;
	}

	public String getPeeAbierto() {
		return this.peeAbierto;
	}

	public void setPeeAbierto(String peeAbierto) {
		this.peeAbierto = peeAbierto;
	}

	public String getPeeVigente() {
		return this.peeVigente;
	}

	public void setPeeVigente(String peeVigente) {
		this.peeVigente = peeVigente;
	}

	public String getPeeHabilitado() {
		return this.peeHabilitado;
	}

	public void setPeeHabilitado(String peeHabilitado) {
		this.peeHabilitado = peeHabilitado;
	}

	public Date getPeeFechaInicioClase() {
		return this.peeFechaInicioClase;
	}

	public void setPeeFechaInicioClase(Date peeFechaInicioClase) {
		this.peeFechaInicioClase = peeFechaInicioClase;
	}

	public Date getPeeFechaInicioClaseNuevos() {
		return this.peeFechaInicioClaseNuevos;
	}

	public void setPeeFechaInicioClaseNuevos(Date peeFechaInicioClaseNuevos) {
		this.peeFechaInicioClaseNuevos = peeFechaInicioClaseNuevos;
	}

	public Date getPeeFechaFinClasesNuevos() {
		return this.peeFechaFinClasesNuevos;
	}

	public void setPeeFechaFinClasesNuevos(Date peeFechaFinClasesNuevos) {
		this.peeFechaFinClasesNuevos = peeFechaFinClasesNuevos;
	}

	public Date getPeeFechaFinClases() {
		return this.peeFechaFinClases;
	}

	public void setPeeFechaFinClases(Date peeFechaFinClases) {
		this.peeFechaFinClases = peeFechaFinClases;
	}

	public Date getPeeFechaInicioRol() {
		return this.peeFechaInicioRol;
	}

	public void setPeeFechaInicioRol(Date peeFechaInicioRol) {
		this.peeFechaInicioRol = peeFechaInicioRol;
	}

	public Date getPeeFechaFinRol() {
		return this.peeFechaFinRol;
	}

	public void setPeeFechaFinRol(Date peeFechaFinRol) {
		this.peeFechaFinRol = peeFechaFinRol;
	}

	public Date getPeeFechaInicial() {
		return this.peeFechaInicial;
	}

	public void setPeeFechaInicial(Date peeFechaInicial) {
		this.peeFechaInicial = peeFechaInicial;
	}

	public Date getPeeFechaFinal() {
		return this.peeFechaFinal;
	}

	public void setPeeFechaFinal(Date peeFechaFinal) {
		this.peeFechaFinal = peeFechaFinal;
	}

	public Date getPeeFechaInicialCohorte() {
		return this.peeFechaInicialCohorte;
	}

	public void setPeeFechaInicialCohorte(Date peeFechaInicialCohorte) {
		this.peeFechaInicialCohorte = peeFechaInicialCohorte;
	}

	public Date getPeeFechaFinalCohorte() {
		return this.peeFechaFinalCohorte;
	}

	public void setPeeFechaFinalCohorte(Date peeFechaFinalCohorte) {
		this.peeFechaFinalCohorte = peeFechaFinalCohorte;
	}

	public String getPeeFichaRequerida() {
		return this.peeFichaRequerida;
	}

	public void setPeeFichaRequerida(String peeFichaRequerida) {
		this.peeFichaRequerida = peeFichaRequerida;
	}

	public String getPeeFichaWebRequerida() {
		return this.peeFichaWebRequerida;
	}

	public void setPeeFichaWebRequerida(String peeFichaWebRequerida) {
		this.peeFichaWebRequerida = peeFichaWebRequerida;
	}

	public Integer getPeeNivel() {
		return this.peeNivel;
	}

	public void setPeeNivel(Integer peeNivel) {
		this.peeNivel = peeNivel;
	}

	public String getPeeHabilitadoInscripcion() {
		return this.peeHabilitadoInscripcion;
	}

	public void setPeeHabilitadoInscripcion(String peeHabilitadoInscripcion) {
		this.peeHabilitadoInscripcion = peeHabilitadoInscripcion;
	}

	public String getPeeVigenteMatricula() {
		return this.peeVigenteMatricula;
	}

	public void setPeeVigenteMatricula(String peeVigenteMatricula) {
		this.peeVigenteMatricula = peeVigenteMatricula;
	}

	public String getPeeTipo() {
		return this.peeTipo;
	}

	public void setPeeTipo(String peeTipo) {
		this.peeTipo = peeTipo;
	}

	public OrgPeriodoLectivo getOrgPeriodoLectivo() {
		return this.orgPeriodoLectivo;
	}

	public void setOrgPeriodoLectivo(OrgPeriodoLectivo orgPeriodoLectivo) {
		this.orgPeriodoLectivo = orgPeriodoLectivo;
	}

	public OrgEstructura getOrgEstructura() {
		return this.orgEstructura;
	}

	public void setOrgEstructura(OrgEstructura orgEstructura) {
		this.orgEstructura = orgEstructura;
	}

	public Collection<OrgPeriodoEstructuraAlumno> getOrgPeriodoEstructuraAlumnoCollection() {
		return this.orgPeriodoEstructuraAlumnoCollection;
	}

	public void setOrgPeriodoEstructuraAlumnoCollection(
			Collection<OrgPeriodoEstructuraAlumno> orgPeriodoEstructuraAlumnoCollection) {
		this.orgPeriodoEstructuraAlumnoCollection = orgPeriodoEstructuraAlumnoCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgPeriodoEstructura)) {
			return false;
		}
		OrgPeriodoEstructura other = (OrgPeriodoEstructura) object;
		return (this.peeCodigo != null || other.peeCodigo == null)
				&& (this.peeCodigo == null || this.peeCodigo.equals(other.peeCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.peeCodigo != null) ? this.peeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "peeCodigo = " + this.peeCodigo + ")";
	}

}
