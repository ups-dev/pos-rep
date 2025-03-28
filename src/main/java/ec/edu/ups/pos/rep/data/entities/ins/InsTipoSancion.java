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

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_TIPO_SANCION", schema = "INS")
public class InsTipoSancion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "TSA_CODIGO", nullable = false)
	private Long tsaCodigo;

	@Column(name = "TSA_DESCRIPCION", length = 200)
	private String tsaDescripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insTipoSancion", fetch = FetchType.LAZY)
	private Collection<InsSancion> insSancionCollection;

	public InsTipoSancion() {
	}

	public InsTipoSancion(Long tsaCodigo) {
		this.tsaCodigo = tsaCodigo;
	}

	public Long getTsaCodigo() {
		return this.tsaCodigo;
	}

	public void setTsaCodigo(Long tsaCodigo) {
		this.tsaCodigo = tsaCodigo;
	}

	public String getTsaDescripcion() {
		return this.tsaDescripcion;
	}

	public void setTsaDescripcion(String tsaDescripcion) {
		this.tsaDescripcion = tsaDescripcion;
	}

	public Collection<InsSancion> getInsSancionCollection() {
		return this.insSancionCollection;
	}

	public void setInsSancionCollection(Collection<InsSancion> insSancionCollection) {
		this.insSancionCollection = insSancionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsTipoSancion)) {
			return false;
		}
		InsTipoSancion other = (InsTipoSancion) object;
		if ((this.tsaCodigo == null && other.tsaCodigo != null)
				|| (this.tsaCodigo != null && !this.tsaCodigo.equals(other.tsaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tsaCodigo != null) ? this.tsaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsTipoSancion[ tsaCodigo=" + this.tsaCodigo + " ]";
	}

}
