package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_INSCRIPCION", schema = "INS")
@SequenceGenerator(name = "INS_INSCRIPCION_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsInscripcion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_INSCRIPCION_SQ")
	@NotNull
	@Column(name = "INS_CODIGO", nullable = false)
	private Long insCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "INS_FECHA_INSCRIPCION", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date insFechaInscripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "INS_APROBADO", nullable = false)
	private String insAprobado;

	@Transient
	private Boolean validaAprobacion;

	@Column(name = "INS_INA_NUMERO_LEG")
	private Long insNumeroLeg;

	@Column(name = "INS_FECHA_APROBACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insFechaAprobacion;

	@Size(max = 1)
	@Column(name = "INS_ANULADO", length = 1)
	private String insAnulado;

	@Size(max = 1)
	@Column(name = "INS_VIGENCIA", length = 1)
	private String insVigencia;

	@Basic(optional = false)
	@Size(max = 1)
	@Column(name = "INS_FICHA", length = 1, nullable = false, insertable = false)
	private String insFicha;

	@Size(max = 50)
	@Column(name = "INS_INSCRITO_POR", length = 1)
	private String insInscritoPor;

	@Size(max = 50)
	@Column(name = "INS_APROBADO_POR", length = 1)
	private String insAprobadoPor;

	@Column(name = "INS_ANTICIPO", length = 1)
	private String insanticipo;

	@Basic(optional = false)
	@Size(min = 1, max = 1)
	@Column(name = "INS_CONFIRMADO", nullable = false)
	private String insConfirmado;

	@Basic(optional = false)
	@Size(min = 1, max = 1)
	@Column(name = "INS_FICHA_CONFIRMACION", nullable = false)
	private String insFichaConfirmacion;

	@Size(max = 50)
	@Column(name = "INS_CONFIRMADO_POR")
	private String insConfirmadoPor;

	@Column(name = "INS_FECHA_CONFIRMADO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insFechaConfirmado;

	@Column(name = "PRE_NUMERO")
	private Long preNumero;

	@Size(max = 1)
	@Column(name = "INS_MATRICULA_INTERNET", length = 1)
	private String insMatriculaInternet;

	@Column(name = "INS_FECHA_INICIO_CARRERA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insFechaInicioCarrera;

	@Basic(optional = false)
	@Size(min = 1, max = 1)
	@Column(name = "INS_CONFIRMA_CORREO_REQUISITO", nullable = false)
	private String insConfirmaCorreoRequisito;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insInscripcion", fetch = FetchType.LAZY)
	private Collection<InsExamen> insExamenCollection;

	@OneToMany(mappedBy = "insInscripcion", fetch = FetchType.LAZY)
	private Collection<InsInscripcionNivelacion> insInscripcionNivelacionCollection;

	@OneToMany(mappedBy = "insInscripcion", fetch = FetchType.LAZY)
	private Collection<InsReqEstIns> insReqEstInsCollection;

	@OneToMany(mappedBy = "insInscripcion", fetch = FetchType.LAZY)
	private Collection<InsInsProAca> insProAcaInsCollection;

	@OneToMany(mappedBy = "insInscripcion", fetch = FetchType.LAZY)
	private Collection<InsRequisitoPresencialidad> insRequisitoPresencialidadCollection;

	@JoinColumn(name = "OII_CODIGO", referencedColumnName = "OII_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private InsOfertaInscripcionInicial insOfertaInscripcionInicial;

	@JoinColumn(name = "ALU_CODIGO", referencedColumnName = "ALU_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsAlumno insAlumno;

	@JoinColumn(name = "TAI_CODIGO", referencedColumnName = "TAI_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private InsTipAprIns insTipAprIns;

	@Size(max = 500)
	@Column(name = "INS_AUT_MATRICULA")
	private String insAutMatricula;

	@Size(max = 500)
	@Column(name = "INS_EMPRESA")
	private String insEmpresa;

	@Column(name = "PAR_CODIGO")
	private Long parCodigo;

	@Basic(optional = false)
	@Size(min = 1, max = 1)
	@Column(name = "INS_ESTUDIANTE_UPS")
	private String insEstudianteUps;

	@Basic(optional = false)
	@Column(name = "RAF_CODIGO")
	private Long rafCodigo;

	@Size(min = 1, max = 1)
	@Column(name = "INS_COMUNIDAD_UPS")
	private String insComunidadUps;

	@Basic(optional = true)
	@Size(min = 1, max = 1)
	@Column(name = "INS_ESTADO")
	private String insEstado;

	@Basic(optional = true)
	@Size(min = 1, max = 1)
	@Column(name = "INS_ENTREVISTADO")
	private String insEntrevistado;

	@Transient
	private Date fechaInicioCarrera;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insInscripcion", fetch = FetchType.LAZY)
	private Collection<InsInsProAca> insInsProAcaCollection;

	@OneToMany(mappedBy = "insInscripcion")
	private Collection<InsAutJorIns> insAutJorInsCollection;

	@Basic(optional = true)
	@Size(min = 1, max = 1)
	@Column(name = "INS_ENVIO_NOTIFICACION")
	private String insEnvioNotificacion;

	@Basic(optional = true)
	@Size(min = 1, max = 500)
	@Column(name = "INS_ENTREVISTA")
	private String insEntrevista;

	@Basic(optional = true)
	@Column(name = "INS_FECHA_NOTIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insFechaNotificacion;

	@Basic(optional = true)
	@Size(min = 1, max = 1)
	@Column(name = "INS_ACEPTACION_CUPO")
	private String insAceptacionCupos;

	@Basic(optional = true)
	@Size(min = 0, max = 500)
	@Column(name = "INS_LIBERA_CUPOS_OBSERVA")
	private String insLiberaCuposObserva;

	@Basic(optional = true)
	@Size(min = 1, max = 1)
	@Column(name = "INS_SUFICIENCIA_IDIOMA")
	private String insSuficienciaIdioma;

	@Basic(optional = true)
	@Size(min = 1, max = 1)
	@Column(name = "INS_EXAMEN_CONOCIMIENTO")
	private String insExamenConocimiento;

	@Transient
	private Boolean validaLiberacion;

	public InsInscripcion() {
	}

	public InsInscripcion(Long insCodigo) {
		this.insCodigo = insCodigo;
	}

	public Long getInsCodigo() {
		return this.insCodigo;
	}

	public void setInsCodigo(Long insCodigo) {
		this.insCodigo = insCodigo;
	}

	public Long getPreNumero() {
		return this.preNumero;
	}

	public void setPreNumero(Long preNumero) {
		this.preNumero = preNumero;
	}

	public String getInsMatriculaInternet() {
		return this.insMatriculaInternet;
	}

	public void setInsMatriculaInternet(String insMatriculaInternet) {
		this.insMatriculaInternet = insMatriculaInternet;
	}

	public Date getInsFechaInicioCarrera() {
		return this.insFechaInicioCarrera;
	}

	public void setInsFechaInicioCarrera(Date insFechaInicioCarrera) {
		this.insFechaInicioCarrera = insFechaInicioCarrera;
	}

	public String getInsConfirmaCorreoRequisito() {
		return this.insConfirmaCorreoRequisito;
	}

	public void setInsConfirmaCorreoRequisito(String insConfirmaCorreoRequisito) {
		this.insConfirmaCorreoRequisito = insConfirmaCorreoRequisito;
	}

	public Date getInsFechaInscripcion() {
		return this.insFechaInscripcion;
	}

	public void setInsFechaInscripcion(Date insFechaInscripcion) {
		this.insFechaInscripcion = insFechaInscripcion;
	}

	public String getInsAprobado() {
		return this.insAprobado;
	}

	public void setInsAprobado(String insAprobado) {
		this.insAprobado = insAprobado;
	}

	public Date getInsFechaAprobacion() {
		return this.insFechaAprobacion;
	}

	public void setInsFechaAprobacion(Date insFechaAprobacion) {
		this.insFechaAprobacion = insFechaAprobacion;
	}

	public String getInsAnulado() {
		return this.insAnulado;
	}

	public void setInsAnulado(String insAnulado) {
		this.insAnulado = insAnulado;
	}

	public String getInsVigencia() {
		return this.insVigencia;
	}

	public void setInsVigencia(String insVigencia) {
		this.insVigencia = insVigencia;
	}

	public String getInsFicha() {
		return this.insFicha;
	}

	public void setInsFicha(String insFicha) {
		this.insFicha = insFicha;
	}

	public Collection<InsExamen> getInsExamenCollection() {
		return this.insExamenCollection;
	}

	public void setInsExamenCollection(Collection<InsExamen> insExamenCollection) {
		this.insExamenCollection = insExamenCollection;
	}

	public Collection<InsInscripcionNivelacion> getInsInscripcionNivelacionCollection() {
		return this.insInscripcionNivelacionCollection;
	}

	public void setInsInscripcionNivelacionCollection(
			Collection<InsInscripcionNivelacion> insInscripcionNivelacionCollection) {
		this.insInscripcionNivelacionCollection = insInscripcionNivelacionCollection;
	}

	public Collection<InsReqEstIns> getInsReqEstInsCollection() {
		return this.insReqEstInsCollection;
	}

	public void setInsReqEstInsCollection(Collection<InsReqEstIns> insReqEstInsCollection) {
		this.insReqEstInsCollection = insReqEstInsCollection;
	}

	public InsOfertaInscripcionInicial getInsOfertaInscripcionInicial() {
		return this.insOfertaInscripcionInicial;
	}

	public void setInsOfertaInscripcionInicial(InsOfertaInscripcionInicial insOfertaInscripcionInicial) {
		this.insOfertaInscripcionInicial = insOfertaInscripcionInicial;
	}

	public InsAlumno getInsAlumno() {
		return this.insAlumno;
	}

	public void setInsAlumno(InsAlumno insAlumno) {
		this.insAlumno = insAlumno;
	}

	public InsTipAprIns getInsTipAprIns() {
		return this.insTipAprIns;
	}

	public void setInsTipAprIns(InsTipAprIns insTipAprIns) {
		this.insTipAprIns = insTipAprIns;
	}

	public String getInsInscritoPor() {
		return this.insInscritoPor;
	}

	public void setInsInscritoPor(String insInscritoPor) {
		this.insInscritoPor = insInscritoPor;
	}

	public String getInsAprobadoPor() {
		return this.insAprobadoPor;
	}

	public void setInsAprobadoPor(String insAprobadoPor) {
		this.insAprobadoPor = insAprobadoPor;
	}

	public String getInsConfirmado() {
		return this.insConfirmado;
	}

	public void setInsConfirmado(String insConfirmado) {
		this.insConfirmado = insConfirmado;
	}

	public Long getParCodigo() {
		return this.parCodigo;
	}

	public void setParCodigo(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public Boolean getValidaAprobacion() {
		return this.insAprobado != null && this.insAprobado.equals("S") && this.insConfirmado != null
				&& this.insConfirmado.equals("S");
	}

	public void setValidaAprobacion(Boolean validaAprobacion) {
		this.validaAprobacion = validaAprobacion;
	}

	public Boolean getValidaLiberacion() {
		return this.insAceptacionCupos != null && this.insAceptacionCupos.equals("S");

	}

	public void setValidaLiberacion(Boolean validaLiberacion) {
		this.validaLiberacion = validaLiberacion;
	}

	public Collection<InsAutJorIns> getInsAutJorInsCollection() {
		return this.insAutJorInsCollection;
	}

	public void setInsAutJorInsCollection(Collection<InsAutJorIns> insAutJorInsCollection) {
		this.insAutJorInsCollection = insAutJorInsCollection;
	}

	public String getInsConfirmadoPor() {
		return this.insConfirmadoPor;
	}

	public void setInsConfirmadoPor(String insConfirmadoPor) {
		this.insConfirmadoPor = insConfirmadoPor;
	}

	public Date getInsFechaConfirmado() {
		return this.insFechaConfirmado;
	}

	public void setInsFechaConfirmado(Date insFechaConfirmado) {
		this.insFechaConfirmado = insFechaConfirmado;
	}

	public String getInsAutMatricula() {
		return this.insAutMatricula;
	}

	public void setInsAutMatricula(String insAutMatricula) {
		this.insAutMatricula = insAutMatricula;
	}

	public Collection<InsInsProAca> getInsInsProAcaCollection() {
		return this.insInsProAcaCollection;
	}

	public void setInsInsProAcaCollection(Collection<InsInsProAca> insInsProAcaCollection) {
		this.insInsProAcaCollection = insInsProAcaCollection;
	}

	public Date getFechaInicioCarrera() {
		return this.fechaInicioCarrera;
	}

	public void setFechaInicioCarrera(Date fechaInicioCarrera) {
		this.fechaInicioCarrera = fechaInicioCarrera;
	}

	public Collection<InsInsProAca> getInsProAcaInsCollection() {
		return this.insProAcaInsCollection;
	}

	public void setInsProAcaInsCollection(Collection<InsInsProAca> insProAcaInsCollection) {
		this.insProAcaInsCollection = insProAcaInsCollection;
	}

	public Collection<InsRequisitoPresencialidad> getInsRequisitoPresencialidadCollection() {
		return this.insRequisitoPresencialidadCollection;
	}

	public void setInsRequisitoPresencialidadCollection(
			Collection<InsRequisitoPresencialidad> insRequisitoPresencialidadCollection) {
		this.insRequisitoPresencialidadCollection = insRequisitoPresencialidadCollection;
	}

	public String getInsEstudianteUps() {
		return this.insEstudianteUps;
	}

	public void setInsEstudianteUps(String insEstudianteUps) {
		this.insEstudianteUps = insEstudianteUps;
	}

	public String getInsanticipo() {
		return this.insanticipo;
	}

	public void setInsanticipo(String insanticipo) {
		this.insanticipo = insanticipo;
	}

	public String getInsFichaConfirmacion() {
		return this.insFichaConfirmacion;
	}

	public void setInsFichaConfirmacion(String insFichaConfirmacion) {
		this.insFichaConfirmacion = insFichaConfirmacion;
	}

	public Long getRafCodigo() {
		return this.rafCodigo;
	}

	public void setRafCodigo(Long rafCodigo) {
		this.rafCodigo = rafCodigo;
	}

	public String getInsComunidadUps() {
		return this.insComunidadUps;
	}

	public void setInsComunidadUps(String insComunidadUps) {
		this.insComunidadUps = insComunidadUps;
	}

	public String getInsEstado() {
		return this.insEstado;
	}

	public void setInsEstado(String insEstado) {
		this.insEstado = insEstado;
	}

	public String getInsEmpresa() {
		return this.insEmpresa;
	}

	public void setInsEmpresa(String insEmpresa) {
		this.insEmpresa = insEmpresa;
	}

	public String getInsEntrevistado() {
		return this.insEntrevistado;
	}

	public void setInsEntrevistado(String insEntrevistado) {
		this.insEntrevistado = insEntrevistado;
	}

	public String getInsEnvioNotificacion() {
		return this.insEnvioNotificacion;
	}

	public void setInsEnvioNotificacion(String insEnvioNotificacion) {
		this.insEnvioNotificacion = insEnvioNotificacion;
	}

	public String getInsEntrevista() {
		return this.insEntrevista;
	}

	public void setInsEntrevista(String insEntrevista) {
		this.insEntrevista = insEntrevista;
	}

	public Date getInsFechaNotificacion() {
		return this.insFechaNotificacion;
	}

	public void setInsFechaNotificacion(Date insFechaNotificacion) {
		this.insFechaNotificacion = insFechaNotificacion;
	}

	public String getInsAceptacionCupos() {
		return this.insAceptacionCupos;
	}

	public void setInsAceptacionCupos(String insAceptacionCupos) {
		this.insAceptacionCupos = insAceptacionCupos;
	}

	public String getInsLiberaCuposObserva() {
		return this.insLiberaCuposObserva;
	}

	public void setInsLiberaCuposObserva(String insLiberaCuposObserva) {
		this.insLiberaCuposObserva = insLiberaCuposObserva;
	}

	public String getInsSuficienciaIdioma() {
		return this.insSuficienciaIdioma;
	}

	public void setInsSuficienciaIdioma(String insSuficienciaIdioma) {
		this.insSuficienciaIdioma = insSuficienciaIdioma;
	}

	public String getInsExamenConocimiento() {
		return this.insExamenConocimiento;
	}

	public void setInsExamenConocimiento(String insExamenConocimiento) {
		this.insExamenConocimiento = insExamenConocimiento;
	}

	public Long getInsNumeroLeg() {
		return this.insNumeroLeg;
	}

	public void setInsNumeroLeg(Long insNumeroLeg) {
		this.insNumeroLeg = insNumeroLeg;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsInscripcion)) {
			return false;
		}
		InsInscripcion other = (InsInscripcion) object;
		if ((this.insCodigo == null && other.insCodigo != null)
				|| (this.insCodigo != null && !this.insCodigo.equals(other.insCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.insCodigo != null) ? this.insCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsInscripcion[ insCodigo=" + this.insCodigo + " ]";
	}

}
