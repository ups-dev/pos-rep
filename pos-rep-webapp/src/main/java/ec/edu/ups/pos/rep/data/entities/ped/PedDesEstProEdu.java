package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

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
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_DES_EST_PRO_EDU", schema = "PED")
public class PedDesEstProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DEP_CODIGO", nullable = false, updatable = false)
	private Long depCodigo;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	@Column(name = "DEE_CODIGO")
	private Long deeCodigo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedDesEstProEdu", fetch = FetchType.LAZY)
	private Collection<PedCdeDep> pedCdeDepCollection;

	public PedDesEstProEdu() {
	}

	public PedDesEstProEdu(Long depCodigo) {
		this.depCodigo = depCodigo;
	}

	public Long getDepCodigo() {
		return this.depCodigo;
	}

	public void setDepCodigo(Long depCodigo) {
		this.depCodigo = depCodigo;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	public Long getDeeCodigo() {
		return this.deeCodigo;
	}

	public void setDeeCodigo(Long deeCodigo) {
		this.deeCodigo = deeCodigo;
	}

	public Collection<PedCdeDep> getPedCdeDepCollection() {
		return this.pedCdeDepCollection;
	}

	public void setPedCdeDepCollection(Collection<PedCdeDep> pedCdeDepCollection) {
		this.pedCdeDepCollection = pedCdeDepCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedDesEstProEdu)) {
			return false;
		}
		PedDesEstProEdu other = (PedDesEstProEdu) object;
		if ((this.depCodigo == null && other.depCodigo != null)
				|| (this.depCodigo != null && !this.depCodigo.equals(other.depCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.depCodigo != null) ? this.depCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedDesEstProEdu[ depCodigo=" + this.depCodigo + " ]";
	}

}
