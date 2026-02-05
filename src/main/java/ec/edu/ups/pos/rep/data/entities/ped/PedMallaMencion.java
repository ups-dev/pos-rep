package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MALLA_MENCION", schema = "PED",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "CDD_CODIGO", "MAL_CODIGO" }) })
public class PedMallaMencion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAM_CODIGO", nullable = false)
	private Long mamCodigo;

	@JoinColumn(name = "CDD_CODIGO", referencedColumnName = "CDD_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PedCdeDep pedCdeDep;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PedMalla pedMalla;

	public PedMallaMencion() {
	}

	public PedMallaMencion(Long mamCodigo) {
		this.mamCodigo = mamCodigo;
	}

	public Long getMamCodigo() {
		return this.mamCodigo;
	}

	public void setMamCodigo(Long mamCodigo) {
		this.mamCodigo = mamCodigo;
	}

	public PedCdeDep getPedCdeDep() {
		return this.pedCdeDep;
	}

	public void setPedCdeDep(PedCdeDep pedCdeDep) {
		this.pedCdeDep = pedCdeDep;
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
		if (!(object instanceof PedMallaMencion)) {
			return false;
		}
		PedMallaMencion other = (PedMallaMencion) object;
		if ((this.mamCodigo == null && other.mamCodigo != null)
				|| (this.mamCodigo != null && !this.mamCodigo.equals(other.mamCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mamCodigo != null) ? this.mamCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaMencion[ mamCodigo=" + this.mamCodigo + " ]";
	}

}
