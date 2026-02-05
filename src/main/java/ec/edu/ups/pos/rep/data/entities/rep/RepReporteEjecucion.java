package ec.edu.ups.pos.rep.data.entities.rep;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "REP_REPORTE_EJECUCION", catalog = "", schema = "REP")
public class RepReporteEjecucion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "RRE_CODIGO", nullable = false)
	private Long rreCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "RES_CODIGO", nullable = false)
	private Long resCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "USUARIO_EJECUTA", nullable = false, length = 50)
	private String usuarioEjecuta;

	@Basic(optional = false)
	@NotNull
	@Column(name = "FECHA_INICIO", nullable = false)
	private java.util.Date fechaInicio;

	@Column(name = "FECHA_FIN")
	private java.util.Date fechaFin;

	@Size(max = 20)
	@Column(name = "ESTADO", length = 20)
	private String estado;

	@Lob
	@Column(name = "PARAMETROS_JSON")
	private String parametrosJson;

	@JoinColumn(name = "RES_CODIGO", referencedColumnName = "RES_CODIGO", nullable = false, insertable = false,
			updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepReportesSistema repReportesSistema;

	public RepReporteEjecucion() {
	}

	public RepReporteEjecucion(Long rreCodigo) {
		this.rreCodigo = rreCodigo;
	}

	public RepReporteEjecucion(Long rreCodigo, Long resCodigo, String usuarioEjecuta, java.util.Date fechaInicio) {
		this.rreCodigo = rreCodigo;
		this.resCodigo = resCodigo;
		this.usuarioEjecuta = usuarioEjecuta;
		this.fechaInicio = fechaInicio;
	}

	public Long getRreCodigo() {
		return this.rreCodigo;
	}

	public void setRreCodigo(Long rreCodigo) {
		this.rreCodigo = rreCodigo;
	}

	public Long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public String getUsuarioEjecuta() {
		return this.usuarioEjecuta;
	}

	public void setUsuarioEjecuta(String usuarioEjecuta) {
		this.usuarioEjecuta = usuarioEjecuta;
	}

	public java.util.Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public java.util.Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getParametrosJson() {
		return this.parametrosJson;
	}

	public void setParametrosJson(String parametrosJson) {
		this.parametrosJson = parametrosJson;
	}

	public RepReportesSistema getRepReportesSistema() {
		return this.repReportesSistema;
	}

	public void setRepReportesSistema(RepReportesSistema repReportesSistema) {
		this.repReportesSistema = repReportesSistema;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RepReporteEjecucion)) {
			return false;
		}
		RepReporteEjecucion other = (RepReporteEjecucion) object;
		if ((this.rreCodigo == null && other.rreCodigo != null)
				|| (this.rreCodigo != null && !this.rreCodigo.equals(other.rreCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.rreCodigo != null) ? this.rreCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepReporteEjecucion[ rreCodigo=" + this.rreCodigo + " ]";
	}

}
