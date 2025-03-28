package ec.edu.ups.pos.rep.data.entities.ins;

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
@Table(name = "INS_CATEGORIA_COLEGIO", schema = "INS")
public class InsCategoriaColegio extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CAC_CODIGO", nullable = false)
	private Long cacCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "CAC_DESCRIPCION", nullable = false, length = 50)
	private String cacDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insCategoriaColegio", fetch = FetchType.LAZY)
	private Collection<InsInstitucionEducativa> insInstitucionEducativaCollection;

	public InsCategoriaColegio() {
	}

	public InsCategoriaColegio(Long cacCodigo) {
		this.cacCodigo = cacCodigo;
	}

	public InsCategoriaColegio(Long cacCodigo, String cacDescripcion) {
		this.cacCodigo = cacCodigo;
		this.cacDescripcion = cacDescripcion;
	}

	public Long getCacCodigo() {
		return this.cacCodigo;
	}

	public void setCacCodigo(Long cacCodigo) {
		this.cacCodigo = cacCodigo;
	}

	public String getCacDescripcion() {
		return this.cacDescripcion;
	}

	public void setCacDescripcion(String cacDescripcion) {
		this.cacDescripcion = cacDescripcion;
	}

	public Collection<InsInstitucionEducativa> getInsInstitucionEducativaCollection() {
		return this.insInstitucionEducativaCollection;
	}

	public void setInsInstitucionEducativaCollection(
			Collection<InsInstitucionEducativa> insInstitucionEducativaCollection) {
		this.insInstitucionEducativaCollection = insInstitucionEducativaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsCategoriaColegio)) {
			return false;
		}
		InsCategoriaColegio other = (InsCategoriaColegio) object;
		if ((this.cacCodigo == null && other.cacCodigo != null)
				|| (this.cacCodigo != null && !this.cacCodigo.equals(other.cacCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cacCodigo != null) ? this.cacCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsCategoriaColegio[ cacCodigo=" + this.cacCodigo + " ]";
	}

}
