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
@Table(name = "PED_ITINERARIO", schema = "PED")
public class PedItinerario extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ITI_CODIGO", nullable = false, updatable = false)
	private Long itiCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "ITI_DESCRIPCION", nullable = false, length = 200)
	private String itiDescripcion;

	@Column(name = "ITI_NUMERO_ASIGNATURA")
	private Long itiNumeroAsignatura;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedItinerario", fetch = FetchType.LAZY)
	private Collection<PedItinerarioMalla> pedItinerarioMallaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "itiCodigo", fetch = FetchType.LAZY)
	private Collection<PedEstructuraItinerario> pedEstructuraItinerarioCollection;

	@JoinColumn(name = "PPE_CODIGO", referencedColumnName = "PPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedParProEdu pedParProEdu;

	public PedItinerario() {
	}

	public PedItinerario(Long itiCodigo) {
		this.itiCodigo = itiCodigo;
	}

	public PedItinerario(Long itiCodigo, String itiDescripcion) {
		this.itiCodigo = itiCodigo;
		this.itiDescripcion = itiDescripcion;
	}

	public Long getItiCodigo() {
		return this.itiCodigo;
	}

	public void setItiCodigo(Long itiCodigo) {
		this.itiCodigo = itiCodigo;
	}

	public String getItiDescripcion() {
		return this.itiDescripcion;
	}

	public void setItiDescripcion(String itiDescripcion) {
		this.itiDescripcion = itiDescripcion;
	}

	public Collection<PedItinerarioMalla> getPedItinerarioMallaCollection() {
		return this.pedItinerarioMallaCollection;
	}

	public void setPedItinerarioMallaCollection(Collection<PedItinerarioMalla> pedItinerarioMallaCollection) {
		this.pedItinerarioMallaCollection = pedItinerarioMallaCollection;
	}

	public Collection<PedEstructuraItinerario> getPedEstructuraItinerarioCollection() {
		return this.pedEstructuraItinerarioCollection;
	}

	public void setPedEstructuraItinerarioCollection(
			Collection<PedEstructuraItinerario> pedEstructuraItinerarioCollection) {
		this.pedEstructuraItinerarioCollection = pedEstructuraItinerarioCollection;
	}

	public PedParProEdu getPedParProEdu() {
		return this.pedParProEdu;
	}

	public void setPedParProEdu(PedParProEdu pedParProEdu) {
		this.pedParProEdu = pedParProEdu;
	}

	public Long getItiNumeroAsignatura() {
		return this.itiNumeroAsignatura;
	}

	public void setItiNumeroAsignatura(Long itiNumeroAsignatura) {
		this.itiNumeroAsignatura = itiNumeroAsignatura;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedItinerario)) {
			return false;
		}
		PedItinerario other = (PedItinerario) object;
		if ((this.itiCodigo == null && other.itiCodigo != null)
				|| (this.itiCodigo != null && !this.itiCodigo.equals(other.itiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.itiCodigo != null) ? this.itiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedItinerario[ itiCodigo=" + this.itiCodigo + " ]";
	}

}
