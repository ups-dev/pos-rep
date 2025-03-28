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
@Table(name = "PED_NIVEL_EDUCACION", schema = "PED")
public class PedNivelEducacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "NED_CODIGO", nullable = false, updatable = false)
	private Long nedCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NED_DESCRIPCION", nullable = false, length = 50)
	private String nedDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedNivelEducacion")
	private Collection<PedProyectoEducacion> pedProyectoEducacionCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedNivelEducacion", fetch = FetchType.LAZY)
	private Collection<PedTipoTitulacion> pedTipoTitulacionCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedNivelEducacion")
	private Collection<PedCampoFormacion> pedCampoFormacionCollection;

	public PedNivelEducacion() {
	}

	public PedNivelEducacion(Long nedCodigo) {
		this.nedCodigo = nedCodigo;
	}

	public PedNivelEducacion(Long nedCodigo, String nedDescripcion) {
		this.nedCodigo = nedCodigo;
		this.nedDescripcion = nedDescripcion;
	}

	public Long getNedCodigo() {
		return this.nedCodigo;
	}

	public void setNedCodigo(Long nedCodigo) {
		this.nedCodigo = nedCodigo;
	}

	public String getNedDescripcion() {
		return this.nedDescripcion;
	}

	public void setNedDescripcion(String nedDescripcion) {
		this.nedDescripcion = nedDescripcion;
	}

	public Collection<PedProyectoEducacion> getPedProyectoEducacionCollection() {
		return this.pedProyectoEducacionCollection;
	}

	public void setPedProyectoEducacionCollection(Collection<PedProyectoEducacion> pedProyectoEducacionCollection) {
		this.pedProyectoEducacionCollection = pedProyectoEducacionCollection;
	}

	public Collection<PedTipoTitulacion> getPedTipoTitulacionCollection() {
		return this.pedTipoTitulacionCollection;
	}

	public void setPedTipoTitulacionCollection(Collection<PedTipoTitulacion> pedTipoTitulacionCollection) {
		this.pedTipoTitulacionCollection = pedTipoTitulacionCollection;
	}

	public Collection<PedCampoFormacion> getPedCampoFormacionCollection() {
		return this.pedCampoFormacionCollection;
	}

	public void setPedCampoFormacionCollection(Collection<PedCampoFormacion> pedCampoFormacionCollection) {
		this.pedCampoFormacionCollection = pedCampoFormacionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedNivelEducacion)) {
			return false;
		}
		PedNivelEducacion other = (PedNivelEducacion) object;
		if ((this.nedCodigo == null && other.nedCodigo != null)
				|| (this.nedCodigo != null && !this.nedCodigo.equals(other.nedCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.nedCodigo != null) ? this.nedCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedNivelEducacion[ nedCodigo=" + this.nedCodigo + " ]";
	}

}
