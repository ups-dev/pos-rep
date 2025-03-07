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
@Table(name = "INS_TIPO_INSCRIPCION", schema = "INS")
public class InsTipoInscripcion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TII_CODIGO", nullable = false)
	private Long tiiCodigo;

	@Column(name = "TPE_CODIGO")
	private Long tpeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "TII_DESCRIPCION", nullable = false, length = 50)
	private String tiiDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insTipoInscripcion", fetch = FetchType.LAZY)
	private Collection<InsRequisitoEstructura> insRequisitoEstructuraCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insTipoInscripcion", fetch = FetchType.LAZY)
	private Collection<InsTipAprIns> insTipAprInsCollection;

	public InsTipoInscripcion() {
	}

	public InsTipoInscripcion(Long tiiCodigo) {
		this.tiiCodigo = tiiCodigo;
	}

	public InsTipoInscripcion(Long tiiCodigo, String tiiDescripcion) {
		this.tiiCodigo = tiiCodigo;
		this.tiiDescripcion = tiiDescripcion;
	}

	public Long getTiiCodigo() {
		return this.tiiCodigo;
	}

	public void setTiiCodigo(Long tiiCodigo) {
		this.tiiCodigo = tiiCodigo;
	}

	public Long getTpeCodigo() {
		return this.tpeCodigo;
	}

	public void setTpeCodigo(Long tpeCodigo) {
		this.tpeCodigo = tpeCodigo;
	}

	public String getTiiDescripcion() {
		return this.tiiDescripcion;
	}

	public void setTiiDescripcion(String tiiDescripcion) {
		this.tiiDescripcion = tiiDescripcion;
	}

	public Collection<InsRequisitoEstructura> getInsRequisitoEstructuraCollection() {
		return this.insRequisitoEstructuraCollection;
	}

	public void setInsRequisitoEstructuraCollection(
			Collection<InsRequisitoEstructura> insRequisitoEstructuraCollection) {
		this.insRequisitoEstructuraCollection = insRequisitoEstructuraCollection;
	}

	public Collection<InsTipAprIns> getInsTipAprInsCollection() {
		return this.insTipAprInsCollection;
	}

	public void setInsTipAprInsCollection(Collection<InsTipAprIns> insTipAprInsCollection) {
		this.insTipAprInsCollection = insTipAprInsCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsTipoInscripcion)) {
			return false;
		}
		InsTipoInscripcion other = (InsTipoInscripcion) object;
		if ((this.tiiCodigo == null && other.tiiCodigo != null)
				|| (this.tiiCodigo != null && !this.tiiCodigo.equals(other.tiiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tiiCodigo != null) ? this.tiiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsTipoInscripcion[ tiiCodigo=" + this.tiiCodigo + " ]";
	}

}
