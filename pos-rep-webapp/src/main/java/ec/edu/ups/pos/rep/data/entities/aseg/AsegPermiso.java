package ec.edu.ups.pos.rep.data.entities.aseg;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ASEG_PERMISO", schema = "ASEG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "PER_DESCRIPCION" }) })
public class AsegPermiso extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PER_CODIGO", nullable = false)
	private Long perCodigo;

	@JoinColumn(name = "OPE_CODIGO", referencedColumnName = "OPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegOperacion asegOperacion;

	@JoinColumn(name = "ROL_CODIGO", referencedColumnName = "ROL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegRol asegRol;

	@JoinColumn(name = "SEC_CODIGO", referencedColumnName = "SEC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegSeccion asegSeccion;

	public AsegPermiso() {
		// default implementation ignored
	}

	public AsegPermiso(Long perCodigo) {
		this.perCodigo = perCodigo;

	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public AsegOperacion getAsegOperacion() {
		return this.asegOperacion;
	}

	public void setAsegOperacion(AsegOperacion asegOperacion) {
		this.asegOperacion = asegOperacion;
	}

	public AsegRol getAsegRol() {
		return this.asegRol;
	}

	public void setAsegRol(AsegRol asegRol) {
		this.asegRol = asegRol;
	}

	public AsegSeccion getAsegSeccion() {
		return this.asegSeccion;
	}

	public void setAsegSeccion(AsegSeccion asegSeccion) {
		this.asegSeccion = asegSeccion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegPermiso)) {
			return false;
		}
		AsegPermiso other = (AsegPermiso) object;
		return !((this.perCodigo == null && other.perCodigo != null)
				|| (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.perCodigo != null) ? this.perCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegPermiso[%d]", this.perCodigo);
	}

}
