package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_DETALLE_NIVEL_SUFICIENCIA", schema = "PED")
public class PedDetalleNivelSuficiencia extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DNS_CODIGO", nullable = false)
	private Long dnsCodigo;

	@JoinColumn(name = "NIP_CODIGO", referencedColumnName = "NIP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedNivelParacademico pedNivelParacademico;

	@JoinColumn(name = "NSR_CODIGO", referencedColumnName = "NSR_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedNivSufRef pedNivSufRef;

	public PedDetalleNivelSuficiencia() {
	}

	public PedDetalleNivelSuficiencia(Long dnsCodigo) {
		this.dnsCodigo = dnsCodigo;
	}

	public Long getDnsCodigo() {
		return this.dnsCodigo;
	}

	public void setDnsCodigo(Long dnsCodigo) {
		this.dnsCodigo = dnsCodigo;
	}

	public PedNivelParacademico getPedNivelParacademico() {
		return this.pedNivelParacademico;
	}

	public void setPedNivelParacademico(PedNivelParacademico pedNivelParacademico) {
		this.pedNivelParacademico = pedNivelParacademico;
	}

	public PedNivSufRef getPedNivSufRef() {
		return this.pedNivSufRef;
	}

	public void setPedNivSufRef(PedNivSufRef pedNivSufRef) {
		this.pedNivSufRef = pedNivSufRef;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedDetalleNivelSuficiencia)) {
			return false;
		}
		PedDetalleNivelSuficiencia other = (PedDetalleNivelSuficiencia) object;
		if ((this.dnsCodigo == null && other.dnsCodigo != null)
				|| (this.dnsCodigo != null && !this.dnsCodigo.equals(other.dnsCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.dnsCodigo != null) ? this.dnsCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedDetalleNivelSuficiencia[ dnsCodigo=" + this.dnsCodigo + " ]";
	}

}
