package ec.edu.ups.pos.rep.data.entities.aseg;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ASEG_USUARIO_ESTRUCTURA", schema = "ASEG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "EST_CODIGO", "USU_CODIGO" }) })
public class AsegUsuarioEstructura extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "USE_CODIGO", nullable = false)
	private Long useCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO")
	private Long estCodigo;

	@JoinColumn(name = "USU_CODIGO", referencedColumnName = "USU_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegUsuario asegUsuario;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "asegUsuarioEstructura")
	private Collection<AsegUsrEstRol> asegUsrEstRolCollection;

	public AsegUsuarioEstructura() {
		// default implementation ignored
	}

	public Long getUseCodigo() {
		return this.useCodigo;
	}

	public void setUseCodigo(Long useCodigo) {
		this.useCodigo = useCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public AsegUsuario getAsegUsuario() {
		return this.asegUsuario;
	}

	public void setAsegUsuario(AsegUsuario asegUsuario) {
		this.asegUsuario = asegUsuario;
	}

	public Collection<AsegUsrEstRol> getAsegUsrEstRolCollection() {
		return this.asegUsrEstRolCollection;
	}

	public void setAsegUsrEstRolCollection(Collection<AsegUsrEstRol> asegUsrEstRolCollection) {
		this.asegUsrEstRolCollection = asegUsrEstRolCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegUsuarioEstructura)) {
			return false;
		}
		AsegUsuarioEstructura other = (AsegUsuarioEstructura) object;
		return !((this.useCodigo == null && other.useCodigo != null)
				|| (this.useCodigo != null && !this.useCodigo.equals(other.useCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.useCodigo != null) ? this.useCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegUsuarioEstructura[%d]", this.useCodigo);
	}

}
