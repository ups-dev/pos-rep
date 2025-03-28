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
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIPO_TITULACION", schema = "PED")
public class PedTipoTitulacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIT_CODIGO", nullable = false)
	private Long titCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "TIT_DESCRIPCION", nullable = false, length = 500)
	private String titDescripcion;

	@JoinColumn(name = "NED_CODIGO", referencedColumnName = "NED_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedNivelEducacion pedNivelEducacion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoTitulacion", fetch = FetchType.LAZY)
	private Collection<PedTptTipTit> pedTptTipTitCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoTitulacion", fetch = FetchType.LAZY)
	private Collection<PedCamConTipTit> pedCamConTipTitCollection;

	public PedTipoTitulacion() {
	}

	public PedTipoTitulacion(Long titCodigo) {
		this.titCodigo = titCodigo;
	}

	public PedTipoTitulacion(Long titCodigo, String titDescripcion) {
		this.titCodigo = titCodigo;
		this.titDescripcion = titDescripcion;
	}

	public Long getTitCodigo() {
		return this.titCodigo;
	}

	public void setTitCodigo(Long titCodigo) {
		this.titCodigo = titCodigo;
	}

	public String getTitDescripcion() {
		return this.titDescripcion;
	}

	public void setTitDescripcion(String titDescripcion) {
		this.titDescripcion = titDescripcion;
	}

	public PedNivelEducacion getPedNivelEducacion() {
		return this.pedNivelEducacion;
	}

	public void setPedNivelEducacion(PedNivelEducacion pedNivelEducacion) {
		this.pedNivelEducacion = pedNivelEducacion;
	}

	public Collection<PedTptTipTit> getPedTptTipTitCollection() {
		return this.pedTptTipTitCollection;
	}

	public void setPedTptTipTitCollection(Collection<PedTptTipTit> pedTptTipTitCollection) {
		this.pedTptTipTitCollection = pedTptTipTitCollection;
	}

	public Collection<PedCamConTipTit> getPedCamConTipTitCollection() {
		return this.pedCamConTipTitCollection;
	}

	public void setPedCamConTipTitCollection(Collection<PedCamConTipTit> pedCamConTipTitCollection) {
		this.pedCamConTipTitCollection = pedCamConTipTitCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoTitulacion)) {
			return false;
		}
		PedTipoTitulacion other = (PedTipoTitulacion) object;
		if ((this.titCodigo == null && other.titCodigo != null)
				|| (this.titCodigo != null && !this.titCodigo.equals(other.titCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.titCodigo != null) ? this.titCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoTitulacion[ titCodigo=" + this.titCodigo + " ]";
	}

}
