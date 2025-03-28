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
@Table(name = "ASEG_USR_EST_ROL", schema = "ASEG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "USE_CODIGO", "ROL_CODIGO" }) })
public class AsegUsrEstRol extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "UER_CODIGO")
	private Long uerCodigo;

	@JoinColumn(name = "USE_CODIGO", referencedColumnName = "USE_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private AsegUsuarioEstructura asegUsuarioEstructura;

	@JoinColumn(name = "ROL_CODIGO", referencedColumnName = "ROL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegRol asegRol;

	public AsegUsrEstRol() {

		// default implementation ignored
	}

	public Long getUerCodigo() {
		return this.uerCodigo;
	}

	public void setUerCodigo(Long uerCodigo) {
		this.uerCodigo = uerCodigo;
	}

	public AsegRol getAsegRol() {
		return this.asegRol;
	}

	public void setAsegRol(AsegRol asegRol) {
		this.asegRol = asegRol;
	}

	public AsegUsuarioEstructura getAsegUsuarioEstructura() {
		return this.asegUsuarioEstructura;
	}

	public void setAsegUsuarioEstructura(AsegUsuarioEstructura asegUsuarioEstructura) {
		this.asegUsuarioEstructura = asegUsuarioEstructura;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegUsrEstRol)) {
			return false;
		}
		AsegUsrEstRol other = (AsegUsrEstRol) object;
		return !((this.uerCodigo == null && other.uerCodigo != null)
				|| (this.uerCodigo != null && !this.uerCodigo.equals(other.uerCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.uerCodigo != null) ? this.uerCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegUsrEstRol[%d]", this.uerCodigo);
	}

}
