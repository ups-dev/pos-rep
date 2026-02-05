package ec.edu.ups.pos.rep.data.entities.sol;

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
@Table(name = "SOL_SOLICITUD_EVENTO", schema = "SOL")
public class SolSolicitudEvento extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "SOE_CODIGO", nullable = false)
	private Long soeCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PER_CODIGO", nullable = false)
	private Long perCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "SOE_FECHA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date soeFecha;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "SOE_ESTADO", nullable = false, length = 1)
	private String soeEstado;

	@Size(max = 3000)
	@Column(name = "SOE_OBSERVACION", length = 3000)
	private String soeObservacion;

	@JoinColumn(name = "SOL_CODIGO", referencedColumnName = "SOL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SolSolicitud solSolicitud;

	public SolSolicitudEvento() {
	}

	public SolSolicitudEvento(Long soeCodigo) {
		this.soeCodigo = soeCodigo;
	}

	public Long getSoeCodigo() {
		return this.soeCodigo;
	}

	public void setSoeCodigo(Long soeCodigo) {
		this.soeCodigo = soeCodigo;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Date getSoeFecha() {
		return this.soeFecha;
	}

	public void setSoeFecha(Date soeFecha) {
		this.soeFecha = soeFecha;
	}

	public String getSoeEstado() {
		return this.soeEstado;
	}

	public void setSoeEstado(String soeEstado) {
		this.soeEstado = soeEstado;
	}

	public String getSoeObservacion() {
		return this.soeObservacion;
	}

	public void setSoeObservacion(String soeObservacion) {
		this.soeObservacion = soeObservacion;
	}

	public SolSolicitud getSolSolicitud() {
		return this.solSolicitud;
	}

	public void setSolSolicitud(SolSolicitud solSolicitud) {
		this.solSolicitud = solSolicitud;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SolSolicitudEvento)) {
			return false;
		}
		SolSolicitudEvento other = (SolSolicitudEvento) object;
		if ((this.soeCodigo == null && other.soeCodigo != null)
				|| (this.soeCodigo != null && !this.soeCodigo.equals(other.soeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.soeCodigo != null) ? this.soeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "SolSolicitudEvento[ soeCodigo=" + this.soeCodigo + " ]";
	}

}
