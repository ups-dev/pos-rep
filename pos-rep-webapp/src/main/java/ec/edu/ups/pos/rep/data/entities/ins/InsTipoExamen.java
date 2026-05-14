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
@Table(name = "INS_TIPO_EXAMEN", schema = "INS")
public class InsTipoExamen extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIE_CODIGO", nullable = false)
	private Long tieCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "TIE_DESCRIPCION", nullable = false, length = 50)
	private String tieDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insTipoExamen", fetch = FetchType.LAZY)
	private Collection<InsPonderacionExamen> insPonderacionExamenCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insTipoExamen", fetch = FetchType.LAZY)
	private Collection<InsReservaExamen> insReservaExamenCollection;

	public InsTipoExamen() {
	}

	public InsTipoExamen(Long tieCodigo) {
		this.tieCodigo = tieCodigo;
	}

	public InsTipoExamen(Long tieCodigo, String tieDescripcion) {
		this.tieCodigo = tieCodigo;
		this.tieDescripcion = tieDescripcion;
	}

	public Long getTieCodigo() {
		return this.tieCodigo;
	}

	public void setTieCodigo(Long tieCodigo) {
		this.tieCodigo = tieCodigo;
	}

	public String getTieDescripcion() {
		return this.tieDescripcion;
	}

	public void setTieDescripcion(String tieDescripcion) {
		this.tieDescripcion = tieDescripcion;
	}

	public Collection<InsPonderacionExamen> getInsPonderacionExamenCollection() {
		return this.insPonderacionExamenCollection;
	}

	public void setInsPonderacionExamenCollection(Collection<InsPonderacionExamen> insPonderacionExamenCollection) {
		this.insPonderacionExamenCollection = insPonderacionExamenCollection;
	}

	public Collection<InsReservaExamen> getInsReservaExamenCollection() {
		return this.insReservaExamenCollection;
	}

	public void setInsReservaExamenCollection(Collection<InsReservaExamen> insReservaExamenCollection) {
		this.insReservaExamenCollection = insReservaExamenCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsTipoExamen)) {
			return false;
		}
		InsTipoExamen other = (InsTipoExamen) object;
		if ((this.tieCodigo == null && other.tieCodigo != null)
				|| (this.tieCodigo != null && !this.tieCodigo.equals(other.tieCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tieCodigo != null) ? this.tieCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsTipoExamen[ tieCodigo=" + this.tieCodigo + " ]";
	}

}
