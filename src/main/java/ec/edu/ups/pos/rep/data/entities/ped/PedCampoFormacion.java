package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_CAMPO_FORMACION", schema = "PED")
public class PedCampoFormacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CAF_CODIGO", nullable = false)
	private Long cafCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "CAF_DESCRIPCION", nullable = false, length = 100)
	private String cafDescripcion;

	@JoinColumn(name = "NED_CODIGO", referencedColumnName = "NED_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedNivelEducacion pedNivelEducacion;

	@OneToMany(mappedBy = "pedCampoFormacion")
	private Collection<PedMalla> pedMallaCollection;

	public PedCampoFormacion() {
	}

	public PedCampoFormacion(Long cafCodigo) {
		this.cafCodigo = cafCodigo;
	}

	public PedCampoFormacion(Long cafCodigo, String cafDescripcion) {
		this.cafCodigo = cafCodigo;
		this.cafDescripcion = cafDescripcion;
	}

	public Long getCafCodigo() {
		return this.cafCodigo;
	}

	public void setCafCodigo(Long cafCodigo) {
		this.cafCodigo = cafCodigo;
	}

	public String getCafDescripcion() {
		return this.cafDescripcion;
	}

	public void setCafDescripcion(String cafDescripcion) {
		this.cafDescripcion = cafDescripcion;
	}

	public PedNivelEducacion getPedNivelEducacion() {
		return this.pedNivelEducacion;
	}

	public void setPedNivelEducacion(PedNivelEducacion pedNivelEducacion) {
		this.pedNivelEducacion = pedNivelEducacion;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCampoFormacion)) {
			return false;
		}
		PedCampoFormacion other = (PedCampoFormacion) object;
		if ((this.cafCodigo == null && other.cafCodigo != null)
				|| (this.cafCodigo != null && !this.cafCodigo.equals(other.cafCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cafCodigo != null) ? this.cafCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCampoFormacion[ cafCodigo=" + this.cafCodigo + " ]";
	}

}
