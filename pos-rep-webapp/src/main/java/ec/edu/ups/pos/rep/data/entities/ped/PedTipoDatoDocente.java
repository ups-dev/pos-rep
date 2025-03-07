package ec.edu.ups.pos.rep.data.entities.ped;

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
@Table(name = "PED_TIPO_DATO_DOCENTE", schema = "PED")
public class PedTipoDatoDocente extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TDD_CODIGO", nullable = false)
	private Long tddCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TDD_DESCRIPCION", nullable = false, length = 100)
	private String tddDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TDD_TIPO", nullable = false, length = 1)
	private String tddTipo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoDatoDocente", fetch = FetchType.LAZY)
	private Collection<PedDocMalTdm> pedDocMalTdmCollection;

	public PedTipoDatoDocente() {
	}

	public PedTipoDatoDocente(Long tddCodigo) {
		this.tddCodigo = tddCodigo;
	}

	public PedTipoDatoDocente(Long tddCodigo, String tddDescripcion, String tddTipo) {
		this.tddCodigo = tddCodigo;
		this.tddDescripcion = tddDescripcion;
		this.tddTipo = tddTipo;
	}

	public Long getTddCodigo() {
		return this.tddCodigo;
	}

	public void setTddCodigo(Long tddCodigo) {
		this.tddCodigo = tddCodigo;
	}

	public String getTddDescripcion() {
		return this.tddDescripcion;
	}

	public void setTddDescripcion(String tddDescripcion) {
		this.tddDescripcion = tddDescripcion;
	}

	public String getTddTipo() {
		return this.tddTipo;
	}

	public void setTddTipo(String tddTipo) {
		this.tddTipo = tddTipo;
	}

	public Collection<PedDocMalTdm> getPedDocMalTdmCollection() {
		return this.pedDocMalTdmCollection;
	}

	public void setPedDocMalTdmCollection(Collection<PedDocMalTdm> pedDocMalTdmCollection) {
		this.pedDocMalTdmCollection = pedDocMalTdmCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoDatoDocente)) {
			return false;
		}
		PedTipoDatoDocente other = (PedTipoDatoDocente) object;
		if ((this.tddCodigo == null && other.tddCodigo != null)
				|| (this.tddCodigo != null && !this.tddCodigo.equals(other.tddCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tddCodigo != null) ? this.tddCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoDatoDocente[ tddCodigo=" + this.tddCodigo + " ]";
	}

}
