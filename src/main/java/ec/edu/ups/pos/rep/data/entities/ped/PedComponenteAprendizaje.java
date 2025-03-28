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
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_COMPONENTE_APRENDIZAJE", schema = "PED")
public class PedComponenteAprendizaje extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COA_CODIGO", nullable = false, updatable = false)
	private Long coaCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "COA_DESCRIPCION", nullable = false, length = 200)
	private String coaDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "COA_TIENE_HORARIO", nullable = false, length = 1)
	private String coaTieneHorario;

	@JoinColumn(name = "TPE_CODIGO", referencedColumnName = "TPE_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedTipoProyectoEducacion pedTipoProyectoEducacion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedComponenteAprendizaje")
	private Collection<PedComAprMal> pedComAprMalCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedComponenteAprendizaje", fetch = FetchType.LAZY)
	private Collection<PedComponenteOrganizacion> pedComponenteOrganizacionCollection;

	public PedComponenteAprendizaje() {
	}

	public PedComponenteAprendizaje(Long coaCodigo) {
		this.coaCodigo = coaCodigo;
	}

	public PedComponenteAprendizaje(Long coaCodigo, String coaDescripcion, String coaTieneHorario) {
		this.coaCodigo = coaCodigo;
		this.coaDescripcion = coaDescripcion;
		this.coaTieneHorario = coaTieneHorario;
	}

	public Long getCoaCodigo() {
		return this.coaCodigo;
	}

	public void setCoaCodigo(Long coaCodigo) {
		this.coaCodigo = coaCodigo;
	}

	public String getCoaDescripcion() {
		return this.coaDescripcion;
	}

	public void setCoaDescripcion(String coaDescripcion) {
		this.coaDescripcion = coaDescripcion;
	}

	public String getCoaTieneHorario() {
		return this.coaTieneHorario;
	}

	public void setCoaTieneHorario(String coaTieneHorario) {
		this.coaTieneHorario = coaTieneHorario;
	}

	public PedTipoProyectoEducacion getPedTipoProyectoEducacion() {
		return this.pedTipoProyectoEducacion;
	}

	public void setPedTipoProyectoEducacion(PedTipoProyectoEducacion pedTipoProyectoEducacion) {
		this.pedTipoProyectoEducacion = pedTipoProyectoEducacion;
	}

	public Collection<PedComAprMal> getPedComAprMalCollection() {
		return this.pedComAprMalCollection;
	}

	public void setPedComAprMalCollection(Collection<PedComAprMal> pedComAprMalCollection) {
		this.pedComAprMalCollection = pedComAprMalCollection;
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
		if (!(object instanceof PedComponenteAprendizaje)) {
			return false;
		}
		PedComponenteAprendizaje other = (PedComponenteAprendizaje) object;
		if ((this.coaCodigo == null && other.coaCodigo != null)
				|| (this.coaCodigo != null && !this.coaCodigo.equals(other.coaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.coaCodigo != null) ? this.coaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedComponenteAprendizaje[ coaCodigo=" + this.coaCodigo + " ]";
	}

}
