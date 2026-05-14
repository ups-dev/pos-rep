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
@Table(name = "PED_PRERREQUISITO", schema = "PED")
public class PedPrerrequisito extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRE_CODIGO", nullable = false, updatable = false)
	private Long preCodigo;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@JoinColumn(name = "MAL_CODIGO_PRERREQUISITO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PedMalla pedMallaPrerrequisito;

	public PedPrerrequisito() {
	}

	public PedPrerrequisito(Long preCodigo) {
		this.preCodigo = preCodigo;
	}

	public Long getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(Long preCodigo) {
		this.preCodigo = preCodigo;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public PedMalla getPedMallaPrerrequisito() {
		return this.pedMallaPrerrequisito;
	}

	public void setPedMallaPrerrequisito(PedMalla pedMallaPrerrequisito) {
		this.pedMallaPrerrequisito = pedMallaPrerrequisito;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedPrerrequisito)) {
			return false;
		}
		PedPrerrequisito other = (PedPrerrequisito) object;
		if ((this.preCodigo == null && other.preCodigo != null)
				|| (this.preCodigo != null && !this.preCodigo.equals(other.preCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.preCodigo != null) ? this.preCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedPrerrequisito[ preCodigo=" + this.preCodigo + " ]";
	}

}
