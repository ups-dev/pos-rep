package ec.edu.ups.pos.rep.data.entities.aseg;

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
@Table(name = "ASEG_OPERACION", schema = "ASEG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "OPE_DESCRIPCION" }) })
public class AsegOperacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "OPE_CODIGO", nullable = false)
	private Long opeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "OPE_DESCRIPCION", nullable = false, length = 50)
	private String opeDescripcion;

	@OneToMany(mappedBy = "asegOperacion", fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Collection<AsegPermiso> asegPermisoCollection;

	public AsegOperacion() {
		// default implementation ignored
	}

	public AsegOperacion(Long opeCodigo, String opeDescripcion) {
		this.opeCodigo = opeCodigo;
		this.opeDescripcion = opeDescripcion;
	}

	public Long getOpeCodigo() {
		return this.opeCodigo;
	}

	public void setOpeCodigo(Long opeCodigo) {
		this.opeCodigo = opeCodigo;
	}

	public String getOpeDescripcion() {
		return this.opeDescripcion;
	}

	public void setOpeDescripcion(String opeDescripcion) {
		this.opeDescripcion = opeDescripcion;
	}

	public Collection<AsegPermiso> getAsegPermisoCollection() {
		return this.asegPermisoCollection;
	}

	public void setAsegPermisoCollection(Collection<AsegPermiso> asegPermisoCollection) {
		this.asegPermisoCollection = asegPermisoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegOperacion)) {
			return false;
		}
		AsegOperacion other = (AsegOperacion) object;
		return !((this.opeCodigo == null && other.opeCodigo != null)
				|| (this.opeCodigo != null && !this.opeCodigo.equals(other.opeCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.opeCodigo != null) ? this.opeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegOperacion[%d]", this.opeCodigo);
	}

}
