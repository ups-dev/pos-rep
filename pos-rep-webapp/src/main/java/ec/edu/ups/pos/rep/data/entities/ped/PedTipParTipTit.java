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
@Table(name = "PED_TIP_PAR_TIP_TIT", schema = "PED")
public class PedTipParTipTit extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TPT_CODIGO", nullable = false)
	private Long tptCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TPT_DESCRIPCION", nullable = false, length = 200)
	private String tptDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TPT_TIPO", nullable = false, length = 1)
	private String tptTipo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipParTipTit", fetch = FetchType.LAZY)
	private Collection<PedTptTipTit> pedTptTipTitCollection;

	public PedTipParTipTit() {
	}

	public PedTipParTipTit(Long tptCodigo) {
		this.tptCodigo = tptCodigo;
	}

	public PedTipParTipTit(Long tptCodigo, String tptDescripcion, String tptTipo) {
		this.tptCodigo = tptCodigo;
		this.tptDescripcion = tptDescripcion;
		this.tptTipo = tptTipo;
	}

	public Long getTptCodigo() {
		return this.tptCodigo;
	}

	public void setTptCodigo(Long tptCodigo) {
		this.tptCodigo = tptCodigo;
	}

	public String getTptDescripcion() {
		return this.tptDescripcion;
	}

	public void setTptDescripcion(String tptDescripcion) {
		this.tptDescripcion = tptDescripcion;
	}

	public String getTptTipo() {
		return this.tptTipo;
	}

	public void setTptTipo(String tptTipo) {
		this.tptTipo = tptTipo;
	}

	public Collection<PedTptTipTit> getPedTptTipTitCollection() {
		return this.pedTptTipTitCollection;
	}

	public void setPedTptTipTitCollection(Collection<PedTptTipTit> pedTptTipTitCollection) {
		this.pedTptTipTitCollection = pedTptTipTitCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipParTipTit)) {
			return false;
		}
		PedTipParTipTit other = (PedTipParTipTit) object;
		if ((this.tptCodigo == null && other.tptCodigo != null)
				|| (this.tptCodigo != null && !this.tptCodigo.equals(other.tptCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tptCodigo != null) ? this.tptCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipParTipTit[ tptCodigo=" + this.tptCodigo + " ]";
	}

}
