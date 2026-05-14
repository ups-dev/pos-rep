package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIPO_MALLA", schema = "PED")
public class PedTipoMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIM_CODIGO", nullable = false, updatable = false)
	private Long timCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TIM_DESCRIPCION", nullable = false, length = 100)
	private String timDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoMalla")
	private Collection<PedMalla> pedMallaCollection;

	public PedTipoMalla() {
	}

	public PedTipoMalla(Long timCodigo) {
		this.timCodigo = timCodigo;
	}

	public PedTipoMalla(Long timCodigo, String timDescripcion) {
		this.timCodigo = timCodigo;
		this.timDescripcion = timDescripcion;
	}

	public Long getTimCodigo() {
		return this.timCodigo;
	}

	public void setTimCodigo(Long timCodigo) {
		this.timCodigo = timCodigo;
	}

	public String getTimDescripcion() {
		return this.timDescripcion;
	}

	public void setTimDescripcion(String timDescripcion) {
		this.timDescripcion = timDescripcion;
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
		if (!(object instanceof PedTipoMalla)) {
			return false;
		}
		PedTipoMalla other = (PedTipoMalla) object;
		if ((this.timCodigo == null && other.timCodigo != null)
				|| (this.timCodigo != null && !this.timCodigo.equals(other.timCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.timCodigo != null) ? this.timCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoMalla[ timCodigo=" + this.timCodigo + " ]";
	}

}
