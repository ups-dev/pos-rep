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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_ORGANIZACION_APRENDIZAJE", schema = "PED")
public class PedOrganizacionAprendizaje extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ORA_CODIGO", nullable = false, updatable = false)
	private Long oraCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "ORA_DESCRIPCION", nullable = false, length = 200)
	private String oraDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedOrganizacionAprendizaje")
	private Collection<PedMalla> pedMallaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedOrganizacionAprendizaje", fetch = FetchType.LAZY)
	private Collection<PedModOrgApr> pedModOrgAprCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedOrganizacionAprendizaje", fetch = FetchType.LAZY)
	private Collection<PedComponenteOrganizacion> pedComponenteOrganizacionCollection;

	public PedOrganizacionAprendizaje() {
	}

	public PedOrganizacionAprendizaje(Long oraCodigo) {
		this.oraCodigo = oraCodigo;
	}

	public PedOrganizacionAprendizaje(Long oraCodigo, String oraDescripcion) {
		this.oraCodigo = oraCodigo;
		this.oraDescripcion = oraDescripcion;
	}

	public Long getOraCodigo() {
		return this.oraCodigo;
	}

	public void setOraCodigo(Long oraCodigo) {
		this.oraCodigo = oraCodigo;
	}

	public String getOraDescripcion() {
		return this.oraDescripcion;
	}

	public void setOraDescripcion(String oraDescripcion) {
		this.oraDescripcion = oraDescripcion;
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

	public Collection<PedComponenteOrganizacion> getPedComponenteOrganizacionCollection() {
		return this.pedComponenteOrganizacionCollection;
	}

	public void setPedComponenteOrganizacionCollection(
			Collection<PedComponenteOrganizacion> pedComponenteOrganizacionCollection) {
		this.pedComponenteOrganizacionCollection = pedComponenteOrganizacionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedOrganizacionAprendizaje)) {
			return false;
		}
		PedOrganizacionAprendizaje other = (PedOrganizacionAprendizaje) object;
		if ((this.oraCodigo == null && other.oraCodigo != null)
				|| (this.oraCodigo != null && !this.oraCodigo.equals(other.oraCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.oraCodigo != null) ? this.oraCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedOrganizacionAprendizaje[ oraCodigo=" + this.oraCodigo + " ]";
	}

}
