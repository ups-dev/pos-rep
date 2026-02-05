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
@Table(name = "INS_RAZA", schema = "INS")
public class InsRaza extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "RAZ_CODIGO", nullable = false)
	private Long razCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "RAZ_DESCRIPCION", nullable = false, length = 50)
	private String razDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insRaza", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insRaza", fetch = FetchType.LAZY)
	private Collection<InsGrupoEtnico> insGrupoEtnicoCollection;

	public InsRaza() {
	}

	public InsRaza(Long razCodigo) {
		this.razCodigo = razCodigo;
	}

	public InsRaza(Long razCodigo, String razDescripcion) {
		this.razCodigo = razCodigo;
		this.razDescripcion = razDescripcion;
	}

	public Long getRazCodigo() {
		return this.razCodigo;
	}

	public void setRazCodigo(Long razCodigo) {
		this.razCodigo = razCodigo;
	}

	public String getRazDescripcion() {
		return this.razDescripcion;
	}

	public void setRazDescripcion(String razDescripcion) {
		this.razDescripcion = razDescripcion;
	}

	public Collection<InsGrupoEtnico> getInsGrupoEtnicoCollection() {
		return this.insGrupoEtnicoCollection;
	}

	public void setInsGrupoEtnicoCollection(Collection<InsGrupoEtnico> insGrupoEtnicoCollection) {
		this.insGrupoEtnicoCollection = insGrupoEtnicoCollection;
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
		if (!(object instanceof InsRaza)) {
			return false;
		}
		InsRaza other = (InsRaza) object;
		if ((this.razCodigo == null && other.razCodigo != null)
				|| (this.razCodigo != null && !this.razCodigo.equals(other.razCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.razCodigo != null) ? this.razCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsRaza[ razCodigo=" + this.razCodigo + " ]";
	}

}
