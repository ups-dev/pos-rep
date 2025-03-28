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
@Table(name = "INS_TIPO_SANGRE", schema = "INS")
public class InsTipoSangre extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIS_CODIGO", nullable = false)
	private Long tisCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "TIS_DESCRIPCION", nullable = false, length = 10)
	private String tisDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insTipoSangre", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	public InsTipoSangre() {
	}

	public InsTipoSangre(Long tisCodigo) {
		this.tisCodigo = tisCodigo;
	}

	public InsTipoSangre(Long tisCodigo, String tisDescripcion) {
		this.tisCodigo = tisCodigo;
		this.tisDescripcion = tisDescripcion;
	}

	public Long getTisCodigo() {
		return this.tisCodigo;
	}

	public void setTisCodigo(Long tisCodigo) {
		this.tisCodigo = tisCodigo;
	}

	public String getTisDescripcion() {
		return this.tisDescripcion;
	}

	public void setTisDescripcion(String tisDescripcion) {
		this.tisDescripcion = tisDescripcion;
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
		if (!(object instanceof InsTipoSangre)) {
			return false;
		}
		InsTipoSangre other = (InsTipoSangre) object;
		if ((this.tisCodigo == null && other.tisCodigo != null)
				|| (this.tisCodigo != null && !this.tisCodigo.equals(other.tisCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tisCodigo != null) ? this.tisCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsTipoSangre[ tisCodigo=" + this.tisCodigo + " ]";
	}

}
