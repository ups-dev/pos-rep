package ec.edu.ups.pos.rep.data.entities.ped;

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

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_DOCENTE_MALLA", schema = "PED")
public class PedDocenteMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DPE_CODIGO", nullable = false, updatable = false)
	private Long dpeCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PER_CODIGO", nullable = false)
	private Long perCodigo;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedDocenteMalla", fetch = FetchType.LAZY)
	private Collection<PedDocMalTdm> pedDocMalTdmCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedDocenteMalla", fetch = FetchType.LAZY)
	private Collection<PedAnexoDocente> pedAnexoDocenteCollection;

	public PedDocenteMalla() {
	}

	public PedDocenteMalla(Long dpeCodigo) {
		this.dpeCodigo = dpeCodigo;
	}

	public Long getDpeCodigo() {
		return this.dpeCodigo;
	}

	public void setDpeCodigo(Long dpeCodigo) {
		this.dpeCodigo = dpeCodigo;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public Collection<PedDocMalTdm> getPedDocMalTdmCollection() {
		return this.pedDocMalTdmCollection;
	}

	public void setPedDocMalTdmCollection(Collection<PedDocMalTdm> pedDocMalTdmCollection) {
		this.pedDocMalTdmCollection = pedDocMalTdmCollection;
	}

	public Collection<PedAnexoDocente> getPedAnexoDocenteCollection() {
		return this.pedAnexoDocenteCollection;
	}

	public void setPedAnexoDocenteCollection(Collection<PedAnexoDocente> pedAnexoDocenteCollection) {
		this.pedAnexoDocenteCollection = pedAnexoDocenteCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedDocenteMalla)) {
			return false;
		}
		PedDocenteMalla other = (PedDocenteMalla) object;
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
		return "PedDocenteMalla[ dpeCodigo=" + this.dpeCodigo + " ]";
	}

}
