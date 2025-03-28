package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MODALIDAD", schema = "PED",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "MOD_DESCRIPCION" }) })
public class PedModalidad extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MOD_CODIGO", nullable = false, updatable = false)
	private Long modCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "MOD_DESCRIPCION", nullable = false, length = 100)
	private String modDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedModalidad")
	private Collection<PedModProEdu> pedModProEduCollection;

	@OneToMany(mappedBy = "pedModalidad", fetch = FetchType.LAZY)
	private Collection<PedMalla> pedMallaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedModalidad", fetch = FetchType.LAZY)
	private Collection<PedModOrgApr> pedModOrgAprCollection;

	public PedModalidad() {
	}

	public PedModalidad(Long modCodigo) {
		this.modCodigo = modCodigo;
	}

	public PedModalidad(Long modCodigo, String modDescripcion) {
		this.modCodigo = modCodigo;
		this.modDescripcion = modDescripcion;
	}

	public Long getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Long modCodigo) {
		this.modCodigo = modCodigo;
	}

	public String getModDescripcion() {
		return this.modDescripcion;
	}

	public void setModDescripcion(String modDescripcion) {
		this.modDescripcion = modDescripcion;
	}

	public Collection<PedModProEdu> getPedModProEduCollection() {
		return this.pedModProEduCollection;
	}

	public void setPedModProEduCollection(Collection<PedModProEdu> pedModProEduCollection) {
		this.pedModProEduCollection = pedModProEduCollection;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
	}

	public Collection<PedModOrgApr> getPedModOrgAprCollection() {
		return this.pedModOrgAprCollection;
	}

	public void setPedModOrgAprCollection(Collection<PedModOrgApr> pedModOrgAprCollection) {
		this.pedModOrgAprCollection = pedModOrgAprCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedModalidad)) {
			return false;
		}
		PedModalidad other = (PedModalidad) object;
		if ((this.modCodigo == null && other.modCodigo != null)
				|| (this.modCodigo != null && !this.modCodigo.equals(other.modCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.modCodigo != null) ? this.modCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedModalidad[ modCodigo=" + this.modCodigo + " ]";
	}

}
