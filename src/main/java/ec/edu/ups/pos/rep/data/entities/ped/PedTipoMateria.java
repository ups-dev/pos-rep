package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "PED_TIPO_MATERIA", schema = "PED")
public class PedTipoMateria extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIM_CODIGO", nullable = false)
	private Long timCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TIM_DESCRIPCION", nullable = false, length = 200)
	private String timDescripcion;

	@OneToMany(mappedBy = "pedTipoMateria", fetch = FetchType.LAZY)
	private Collection<PedMateria> pedMateriaCollection;

	public PedTipoMateria() {
	}

	public PedTipoMateria(Long timCodigo) {
		this.timCodigo = timCodigo;
	}

	public PedTipoMateria(Long timCodigo, String timDescripcion) {
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

	public Collection<PedMateria> getPedMateriaCollection() {
		return this.pedMateriaCollection;
	}

	public void setPedMateriaCollection(Collection<PedMateria> pedMateriaCollection) {
		this.pedMateriaCollection = pedMateriaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoMateria)) {
			return false;
		}
		PedTipoMateria other = (PedTipoMateria) object;
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
		return "PedTipoMateria[ timCodigo=" + this.timCodigo + " ]";
	}

}
