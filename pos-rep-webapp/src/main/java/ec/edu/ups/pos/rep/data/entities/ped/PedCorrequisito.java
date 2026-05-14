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
@Table(name = "PED_CORREQUISITO", schema = "PED")
public class PedCorrequisito extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COR_CODIGO", nullable = false, updatable = false)
	private Long corCodigo;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@JoinColumn(name = "MAL_CODIGO_CORREQUISITO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PedMalla pedMallaCorrequisito;

	public PedCorrequisito() {
	}

	public PedCorrequisito(Long corCodigo) {
		this.corCodigo = corCodigo;
	}

	public Long getCorCodigo() {
		return this.corCodigo;
	}

	public void setCorCodigo(Long corCodigo) {
		this.corCodigo = corCodigo;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public PedMalla getPedMallaCorrequisito() {
		return this.pedMallaCorrequisito;
	}

	public void setPedMallaCorrequisito(PedMalla pedMallaCorrequisito) {
		this.pedMallaCorrequisito = pedMallaCorrequisito;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCorrequisito)) {
			return false;
		}
		PedCorrequisito other = (PedCorrequisito) object;
		if ((this.corCodigo == null && other.corCodigo != null)
				|| (this.corCodigo != null && !this.corCodigo.equals(other.corCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.corCodigo != null) ? this.corCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCorrequisito[ corCodigo=" + this.corCodigo + " ]";
	}

}
