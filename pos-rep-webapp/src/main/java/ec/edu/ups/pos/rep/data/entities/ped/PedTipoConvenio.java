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
@Table(name = "PED_TIPO_CONVENIO", schema = "PED")
public class PedTipoConvenio extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIC_CODIGO", nullable = false)
	private Long ticCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TIC_DESCRIPCION", nullable = false, length = 200)
	private String ticDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoConvenio", fetch = FetchType.LAZY)
	private Collection<PedConvenio> pedConvenioCollection;

	public PedTipoConvenio() {
	}

	public PedTipoConvenio(Long ticCodigo) {
		this.ticCodigo = ticCodigo;
	}

	public PedTipoConvenio(Long ticCodigo, String ticDescripcion) {
		this.ticCodigo = ticCodigo;
		this.ticDescripcion = ticDescripcion;
	}

	public Long getTicCodigo() {
		return this.ticCodigo;
	}

	public void setTicCodigo(Long ticCodigo) {
		this.ticCodigo = ticCodigo;
	}

	public String getTicDescripcion() {
		return this.ticDescripcion;
	}

	public void setTicDescripcion(String ticDescripcion) {
		this.ticDescripcion = ticDescripcion;
	}

	public Collection<PedConvenio> getPedConvenioCollection() {
		return this.pedConvenioCollection;
	}

	public void setPedConvenioCollection(Collection<PedConvenio> pedConvenioCollection) {
		this.pedConvenioCollection = pedConvenioCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoConvenio)) {
			return false;
		}
		PedTipoConvenio other = (PedTipoConvenio) object;
		if ((this.ticCodigo == null && other.ticCodigo != null)
				|| (this.ticCodigo != null && !this.ticCodigo.equals(other.ticCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ticCodigo != null) ? this.ticCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoConvenio[ ticCodigo=" + this.ticCodigo + " ]";
	}

}
