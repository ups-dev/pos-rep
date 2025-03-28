package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_HISTORIAL_ESTADO", schema = "PED")
public class PedHistorialEstado extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "HIE_CODIGO", nullable = false)
	private Long hieCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ETP_CODIGO", nullable = false)
	private Long etpCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "HIE_FECHA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date hieFecha;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "HIE_VIGENTE", nullable = false, length = 1)
	private String hieVigente;

	@Size(max = 100)
	@Column(name = "HIE_RES_ACADEMICO", length = 100)
	private String hieResAcademico;

	@Size(max = 100)
	@Column(name = "HIE_RES_SUPERIOR", length = 100)
	private String hieResSuperior;

	@Column(name = "HIE_FECHA_RESP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hieFechaResp;

	@Size(max = 100)
	@Column(name = "HIE_NUM_RES_RESP", length = 100)
	private String hieNumResResp;

	@Column(name = "HIE_FECHA_INICIO_VIGENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hieFechaInicioVigencia;

	@Column(name = "HIE_FECHA_FIN_VIGENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hieFechaFinVigencia;

	@Column(name = "HIE_FECHA_PLAZO_PROYECTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hieFechaPlazoProyecto;

	@Column(name = "PEL_CODIGO")
	private Long pelCodigo;

	@Size(max = 1)
	@Column(name = "HIE_TIPO_APROBACION", length = 1)
	private String hieTipoAprobacion;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	@JoinColumn(name = "EMP_CODIGO", referencedColumnName = "EMP_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedEstModProEdu pedEstModProEdu;

	public PedHistorialEstado() {
	}

	public PedHistorialEstado(Long hieCodigo) {
		this.hieCodigo = hieCodigo;
	}

	public PedHistorialEstado(Long hieCodigo, Long etpCodigo, Date hieFecha, String hieVigente) {
		this.hieCodigo = hieCodigo;
		this.etpCodigo = etpCodigo;
		this.hieFecha = hieFecha;
		this.hieVigente = hieVigente;
	}

	public Long getHieCodigo() {
		return this.hieCodigo;
	}

	public void setHieCodigo(Long hieCodigo) {
		this.hieCodigo = hieCodigo;
	}

	public Long getEtpCodigo() {
		return this.etpCodigo;
	}

	public void setEtpCodigo(Long etpCodigo) {
		this.etpCodigo = etpCodigo;
	}

	public Date getHieFecha() {
		return this.hieFecha;
	}

	public void setHieFecha(Date hieFecha) {
		this.hieFecha = hieFecha;
	}

	public String getHieVigente() {
		return this.hieVigente;
	}

	public void setHieVigente(String hieVigente) {
		this.hieVigente = hieVigente;
	}

	public String getHieResAcademico() {
		return this.hieResAcademico;
	}

	public void setHieResAcademico(String hieResAcademico) {
		this.hieResAcademico = hieResAcademico;
	}

	public String getHieResSuperior() {
		return this.hieResSuperior;
	}

	public void setHieResSuperior(String hieResSuperior) {
		this.hieResSuperior = hieResSuperior;
	}

	public Date getHieFechaResp() {
		return this.hieFechaResp;
	}

	public void setHieFechaResp(Date hieFechaResp) {
		this.hieFechaResp = hieFechaResp;
	}

	public String getHieNumResResp() {
		return this.hieNumResResp;
	}

	public void setHieNumResResp(String hieNumResResp) {
		this.hieNumResResp = hieNumResResp;
	}

	public Date getHieFechaInicioVigencia() {
		return this.hieFechaInicioVigencia;
	}

	public void setHieFechaInicioVigencia(Date hieFechaInicioVigencia) {
		this.hieFechaInicioVigencia = hieFechaInicioVigencia;
	}

	public Date getHieFechaFinVigencia() {
		return this.hieFechaFinVigencia;
	}

	public void setHieFechaFinVigencia(Date hieFechaFinVigencia) {
		this.hieFechaFinVigencia = hieFechaFinVigencia;
	}

	public Date getHieFechaPlazoProyecto() {
		return this.hieFechaPlazoProyecto;
	}

	public void setHieFechaPlazoProyecto(Date hieFechaPlazoProyecto) {
		this.hieFechaPlazoProyecto = hieFechaPlazoProyecto;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public String getHieTipoAprobacion() {
		return this.hieTipoAprobacion;
	}

	public void setHieTipoAprobacion(String hieTipoAprobacion) {
		this.hieTipoAprobacion = hieTipoAprobacion;
	}

	public Long getPelCodigoFinal() {
		return this.pelCodigoFinal;
	}

	public void setPelCodigoFinal(Long pelCodigoFinal) {
		this.pelCodigoFinal = pelCodigoFinal;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	public PedEstModProEdu getPedEstModProEdu() {
		return this.pedEstModProEdu;
	}

	public void setPedEstModProEdu(PedEstModProEdu pedEstModProEdu) {
		this.pedEstModProEdu = pedEstModProEdu;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedHistorialEstado)) {
			return false;
		}
		PedHistorialEstado other = (PedHistorialEstado) object;
		if ((this.hieCodigo == null && other.hieCodigo != null)
				|| (this.hieCodigo != null && !this.hieCodigo.equals(other.hieCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.hieCodigo != null) ? this.hieCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedHistorialEstado[ hieCodigo=" + this.hieCodigo + " ]";
	}

}
