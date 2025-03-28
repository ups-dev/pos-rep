package ec.edu.ups.pos.rep.data.entities.ins;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_GRUPO_ETNICO", schema = "INS")
public class InsGrupoEtnico extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "IGE_CODIGO", nullable = false)
	private Long igeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "IGE_DESCRIPCION", nullable = false, length = 50)
	private String igeDescripcion;

	@JoinColumn(name = "RAZ_CODIGO", referencedColumnName = "RAZ_CODIGO")
	@ManyToOne
	private InsRaza insRaza;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insGrupoEtnico", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	public InsGrupoEtnico() {
	}

	public InsGrupoEtnico(Long igeCodigo) {
		this.igeCodigo = igeCodigo;
	}

	public InsGrupoEtnico(Long igeCodigo, String igeDescripcion) {
		this.igeCodigo = igeCodigo;
		this.igeDescripcion = igeDescripcion;
	}

	public Long getIgeCodigo() {
		return this.igeCodigo;
	}

	public void setIgeCodigo(Long igeCodigo) {
		this.igeCodigo = igeCodigo;
	}

	public String getIgeDescripcion() {
		return this.igeDescripcion;
	}

	public void setIgeDescripcion(String igeDescripcion) {
		this.igeDescripcion = igeDescripcion;
	}

	public InsRaza getInsRaza() {
		return this.insRaza;
	}

	public void setInsRaza(InsRaza insRaza) {
		this.insRaza = insRaza;
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
		if (!(object instanceof InsGrupoEtnico)) {
			return false;
		}
		InsGrupoEtnico other = (InsGrupoEtnico) object;
		if ((this.igeCodigo == null && other.igeCodigo != null)
				|| (this.igeCodigo != null && !this.igeCodigo.equals(other.igeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.igeCodigo != null) ? this.igeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsGrupoEtnico[ igeCodigo=" + this.igeCodigo + " ]";
	}

}
