package ec.edu.ups.pos.rep.data.entities.aseg;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ASEG_USUARIO", schema = "ASEG", uniqueConstraints = { @UniqueConstraint(columnNames = { "USU_EMAIL" }) })
public class AsegUsuario extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "USU_CODIGO", nullable = false)
	private Long usuCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "USU_EMAIL", nullable = false, length = 50)
	private String usuEmail;

	@Size(max = 50)
	@Column(name = "USU_NOMBRE", length = 50)
	private String usuNombre;

	@Size(max = 50)
	@Column(name = "USU_APELLIDO", length = 50)
	private String usuApellido;

	@Size(max = 4)
	@Column(name = "VEND_CODIGO", length = 4)
	private String vendCodigo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "asegUsuario")
	private Collection<AsegUsuarioEstructura> asegUsuarioEstructuraCollection;

	public AsegUsuario() {
	}

	public AsegUsuario(Long usuCodigo, String usuEmail) {
		this.usuCodigo = usuCodigo;
		this.usuEmail = usuEmail;
	}

	public Long getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Long usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public String getUsuEmail() {
		return this.usuEmail;
	}

	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}

	public String getUsuNombre() {
		return this.usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public String getUsuApellido() {
		return this.usuApellido;
	}

	public void setUsuApellido(String usuApellido) {
		this.usuApellido = usuApellido;
	}

	public String getVendCodigo() {
		return this.vendCodigo;
	}

	public void setVendCodigo(String vendCodigo) {
		this.vendCodigo = vendCodigo;
	}

	public Collection<AsegUsuarioEstructura> getAsegUsuarioEstructuraCollection() {
		return this.asegUsuarioEstructuraCollection;
	}

	public void setAsegUsuarioEstructuraCollection(Collection<AsegUsuarioEstructura> asegUsuarioEstructuraCollection) {
		this.asegUsuarioEstructuraCollection = asegUsuarioEstructuraCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegUsuario)) {
			return false;
		}
		AsegUsuario other = (AsegUsuario) object;
		return !((this.usuCodigo == null && other.usuCodigo != null)
				|| (this.usuCodigo != null && !this.usuCodigo.equals(other.usuCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.usuCodigo != null) ? this.usuCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegUsuario[%d]", this.usuCodigo);
	}

}
