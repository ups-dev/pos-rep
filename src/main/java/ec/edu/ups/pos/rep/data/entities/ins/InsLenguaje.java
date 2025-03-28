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
@Table(name = "INS_LENGUAJE", schema = "INS")
public class InsLenguaje extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "LEN_CODIGO", nullable = false)
	private Long lenCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "LEN_DESCRIPCION", nullable = false, length = 50)
	private String lenDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insLenguaje", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	public InsLenguaje() {
	}

	public InsLenguaje(Long lenCodigo) {
		this.lenCodigo = lenCodigo;
	}

	public Long getLenCodigo() {
		return this.lenCodigo;
	}

	public void setLenCodigo(Long lenCodigo) {
		this.lenCodigo = lenCodigo;
	}

	public String getLenDescripcion() {
		return this.lenDescripcion;
	}

	public void setLenDescripcion(String lenDescripcion) {
		this.lenDescripcion = lenDescripcion;
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
		if (!(object instanceof InsLenguaje)) {
			return false;
		}
		InsLenguaje other = (InsLenguaje) object;
		if ((this.lenCodigo == null && other.lenCodigo != null)
				|| (this.lenCodigo != null && !this.lenCodigo.equals(other.lenCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.lenCodigo != null) ? this.lenCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsLenguaje[ lenCodigo=" + this.lenCodigo + " ]";
	}

}
