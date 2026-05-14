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
@Table(name = "INS_RELIGION", schema = "INS")
public class InsReligion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "REL_CODIGO", nullable = false)
	private Long relCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "REL_DESCRIPCION", nullable = false, length = 100)
	private String relDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insReligion", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	public InsReligion() {
	}

	public InsReligion(Long relCodigo) {
		this.relCodigo = relCodigo;
	}

	public InsReligion(Long relCodigo, String relDescripcion) {
		this.relCodigo = relCodigo;
		this.relDescripcion = relDescripcion;
	}

	public Long getRelCodigo() {
		return this.relCodigo;
	}

	public void setRelCodigo(Long relCodigo) {
		this.relCodigo = relCodigo;
	}

	public String getRelDescripcion() {
		return this.relDescripcion;
	}

	public void setRelDescripcion(String relDescripcion) {
		this.relDescripcion = relDescripcion;
	}

	public Collection<InsAlumno> getInsAlumnoCollection() {
		return this.insAlumnoCollection;
	}

	public void setInsAlumnoCollection(Collection<InsAlumno> insAlumnoCollection) {
		this.insAlumnoCollection = insAlumnoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsReligion)) {
			return false;
		}
		InsReligion other = (InsReligion) object;
		if ((this.relCodigo == null && other.relCodigo != null)
				|| (this.relCodigo != null && !this.relCodigo.equals(other.relCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.relCodigo != null) ? this.relCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsReligion[ relCodigo=" + this.relCodigo + " ]";
	}

}
