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
@Table(name = "PED_MALLA_AREA", schema = "PED")
public class PedMallaArea extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAA_CODIGO", nullable = false)
	private Long maaCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ARC_CODIGO", nullable = false)
	private Long arcCodigo;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	public PedMallaArea() {
	}

	public PedMallaArea(Long maaCodigo) {
		this.maaCodigo = maaCodigo;
	}

	public PedMallaArea(Long maaCodigo, Long arcCodigo) {
		this.maaCodigo = maaCodigo;
		this.arcCodigo = arcCodigo;
	}

	public Long getMaaCodigo() {
		return this.maaCodigo;
	}

	public void setMaaCodigo(Long maaCodigo) {
		this.maaCodigo = maaCodigo;
	}

	public Long getArcCodigo() {
		return this.arcCodigo;
	}

	public void setArcCodigo(Long arcCodigo) {
		this.arcCodigo = arcCodigo;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMallaArea)) {
			return false;
		}
		PedMallaArea other = (PedMallaArea) object;
		if ((this.maaCodigo == null && other.maaCodigo != null)
				|| (this.maaCodigo != null && !this.maaCodigo.equals(other.maaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.maaCodigo != null) ? this.maaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaArea[ maaCodigo=" + this.maaCodigo + " ]";
	}

}
