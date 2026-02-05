package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "PED_UNI_ORG_CUR", schema = "PED")
public class PedUniOrgCur extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "UOC_CODIGO", nullable = false)
	private Long uocCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "UOC_DESCRIPCION", nullable = false, length = 100)
	private String uocDescripcion;

	@OneToMany(mappedBy = "pedUniOrgCur", fetch = FetchType.LAZY)
	private Collection<PedMalla> pedMallaCollection;

	public PedUniOrgCur() {
	}

	public PedUniOrgCur(Long uocCodigo) {
		this.uocCodigo = uocCodigo;
	}

	public PedUniOrgCur(Long uocCodigo, String uocDescripcion) {
		this.uocCodigo = uocCodigo;
		this.uocDescripcion = uocDescripcion;
	}

	public Long getUocCodigo() {
		return this.uocCodigo;
	}

	public void setUocCodigo(Long uocCodigo) {
		this.uocCodigo = uocCodigo;
	}

	public String getUocDescripcion() {
		return this.uocDescripcion;
	}

	public void setUocDescripcion(String uocDescripcion) {
		this.uocDescripcion = uocDescripcion;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedUniOrgCur)) {
			return false;
		}
		PedUniOrgCur other = (PedUniOrgCur) object;
		if ((this.uocCodigo == null && other.uocCodigo != null)
				|| (this.uocCodigo != null && !this.uocCodigo.equals(other.uocCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.uocCodigo != null) ? this.uocCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedUniOrgCur[ uocCodigo=" + this.uocCodigo + " ]";
	}

}
