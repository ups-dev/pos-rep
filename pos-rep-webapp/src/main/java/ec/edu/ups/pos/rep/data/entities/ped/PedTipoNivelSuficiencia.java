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
@Table(name = "PED_TIPO_NIVEL_SUFICIENCIA", schema = "PED")
public class PedTipoNivelSuficiencia extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TNS_CODIGO", nullable = false)
	private Long tnsCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TNS_DESCRIPCION", nullable = false, length = 100)
	private String tnsDescripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedTipoNivelSuficiencia", fetch = FetchType.LAZY)
	private Collection<PedNivSufRef> pedNivSufRefCollection;

	public PedTipoNivelSuficiencia() {
	}

	public PedTipoNivelSuficiencia(Long tnsCodigo) {
		this.tnsCodigo = tnsCodigo;
	}

	public PedTipoNivelSuficiencia(Long tnsCodigo, String tnsDescripcion) {
		this.tnsCodigo = tnsCodigo;
		this.tnsDescripcion = tnsDescripcion;
	}

	public Long getTnsCodigo() {
		return this.tnsCodigo;
	}

	public void setTnsCodigo(Long tnsCodigo) {
		this.tnsCodigo = tnsCodigo;
	}

	public String getTnsDescripcion() {
		return this.tnsDescripcion;
	}

	public void setTnsDescripcion(String tnsDescripcion) {
		this.tnsDescripcion = tnsDescripcion;
	}

	public Collection<PedNivSufRef> getPedNivSufRefCollection() {
		return this.pedNivSufRefCollection;
	}

	public void setPedNivSufRefCollection(Collection<PedNivSufRef> pedNivSufRefCollection) {
		this.pedNivSufRefCollection = pedNivSufRefCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoNivelSuficiencia)) {
			return false;
		}
		PedTipoNivelSuficiencia other = (PedTipoNivelSuficiencia) object;
		if ((this.tnsCodigo == null && other.tnsCodigo != null)
				|| (this.tnsCodigo != null && !this.tnsCodigo.equals(other.tnsCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tnsCodigo != null) ? this.tnsCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoNivelSuficiencia[ tnsCodigo=" + this.tnsCodigo + " ]";
	}

}
