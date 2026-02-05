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
@Table(name = "INS_DES_PON_EXA", schema = "INS")
public class InsDesPonExa extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DPE_CODIGO", nullable = false)
	private Long dpeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "DPE_DESCRIPCION", nullable = false, length = 100)
	private String dpeDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insDesPonExa", fetch = FetchType.LAZY)
	private Collection<InsPonderacionExamen> insPonderacionExamenCollection;

	public InsDesPonExa() {
	}

	public InsDesPonExa(Long dpeCodigo) {
		this.dpeCodigo = dpeCodigo;
	}

	public InsDesPonExa(Long dpeCodigo, String dpeDescripcion) {
		this.dpeCodigo = dpeCodigo;
		this.dpeDescripcion = dpeDescripcion;
	}

	public Long getDpeCodigo() {
		return this.dpeCodigo;
	}

	public void setDpeCodigo(Long dpeCodigo) {
		this.dpeCodigo = dpeCodigo;
	}

	public String getDpeDescripcion() {
		return this.dpeDescripcion;
	}

	public void setDpeDescripcion(String dpeDescripcion) {
		this.dpeDescripcion = dpeDescripcion;
	}

	public Collection<InsPonderacionExamen> getInsPonderacionExamenCollection() {
		return this.insPonderacionExamenCollection;
	}

	public void setInsPonderacionExamenCollection(Collection<InsPonderacionExamen> insPonderacionExamenCollection) {
		this.insPonderacionExamenCollection = insPonderacionExamenCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsDesPonExa)) {
			return false;
		}
		InsDesPonExa other = (InsDesPonExa) object;
		if ((this.dpeCodigo == null && other.dpeCodigo != null)
				|| (this.dpeCodigo != null && !this.dpeCodigo.equals(other.dpeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.dpeCodigo != null) ? this.dpeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsDesPonExa[ dpeCodigo=" + this.dpeCodigo + " ]";
	}

}
