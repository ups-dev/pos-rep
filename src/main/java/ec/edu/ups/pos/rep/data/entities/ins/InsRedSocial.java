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
@Table(name = "INS_RED_SOCIAL", schema = "INS")
public class InsRedSocial extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "RES_CODIGO", nullable = false)
	private Long resCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "RES_DESCRIPCION", nullable = false, length = 300)
	private String resDescripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insRedSocial", fetch = FetchType.LAZY)
	private Collection<InsAlumnoRedSocial> insAlumnoRedSocialCollection;

	public InsRedSocial() {
	}

	public InsRedSocial(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public InsRedSocial(Long resCodigo, String resDescripcion) {
		this.resCodigo = resCodigo;
		this.resDescripcion = resDescripcion;
	}

	public Long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public String getResDescripcion() {
		return this.resDescripcion;
	}

	public void setResDescripcion(String resDescripcion) {
		this.resDescripcion = resDescripcion;
	}

	public Collection<InsAlumnoRedSocial> getInsAlumnoRedSocialCollection() {
		return this.insAlumnoRedSocialCollection;
	}

	public void setInsAlumnoRedSocialCollection(Collection<InsAlumnoRedSocial> insAlumnoRedSocialCollection) {
		this.insAlumnoRedSocialCollection = insAlumnoRedSocialCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsRedSocial)) {
			return false;
		}
		InsRedSocial other = (InsRedSocial) object;
		if ((this.resCodigo == null && other.resCodigo != null)
				|| (this.resCodigo != null && !this.resCodigo.equals(other.resCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.resCodigo != null) ? this.resCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsRedSocial[ resCodigo=" + this.resCodigo + " ]";
	}

}
