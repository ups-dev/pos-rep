package ec.edu.ups.pos.rep.data.entities.aseg;

import java.util.Collection;
import java.util.Objects;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ASEG_ROL", schema = "ASEG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "ROL_DESCRIPCION" }) })
public class AsegRol extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ROL_CODIGO", nullable = false)
	private Long rolCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "ROL_DESCRIPCION", nullable = false, length = 100)
	private String rolDescripcion;

	@JoinColumn(name = "APL_CODIGO", referencedColumnName = "APL_CODIGO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private AsegAplicacion asegAplicacion;

	@OneToMany(mappedBy = "asegRol", fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Collection<AsegPermiso> asegPermisoCollection;

	@OneToMany(mappedBy = "asegRol", fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Collection<AsegUsrEstRol> asegUsrEstRolCollection;

	public AsegRol() {
		// default implementation ignored
	}

	public AsegRol(Long rolCodigo, String rolDescripcion) {
		this.rolCodigo = rolCodigo;
		this.rolDescripcion = rolDescripcion;
	}

	public Long getRolCodigo() {
		return this.rolCodigo;
	}

	public void setRolCodigo(Long rolCodigo) {
		this.rolCodigo = rolCodigo;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public AsegAplicacion getAsegAplicacion() {
		return this.asegAplicacion;
	}

	public void setAsegAplicacion(AsegAplicacion asegAplicacion) {
		this.asegAplicacion = asegAplicacion;
	}

	public Collection<AsegPermiso> getAsegPermisoCollection() {
		return this.asegPermisoCollection;
	}

	public void setAsegPermisoCollection(Collection<AsegPermiso> asegPermisoCollection) {
		this.asegPermisoCollection = asegPermisoCollection;
	}

	public Collection<AsegUsrEstRol> getAsegUsrEstRolCollection() {
		return this.asegUsrEstRolCollection;
	}

	public void setAsegUsrEstRolCollection(Collection<AsegUsrEstRol> asegUsrEstRolCollection) {
		this.asegUsrEstRolCollection = asegUsrEstRolCollection;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof AsegRol)) {
			return false;
		}
		AsegRol asegRol = (AsegRol) o;
		return Objects.equals(this.rolCodigo, asegRol.rolCodigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.rolCodigo);
	}

	@Override
	public String toString() {
		return String.format("AsegRol[%d]", this.rolCodigo);
	}

}
