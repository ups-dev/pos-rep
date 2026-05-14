package ec.edu.ups.pos.rep.data.entities.org;

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
@Table(name = "ORG_TIPO_DETALLE", schema = "ORG")
public class OrgTipoDetalle extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TID_CODIGO", nullable = false)
	private Long tidCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TID_DESCRIPCION", nullable = false, length = 200)
	private String tidDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TID_TIPO", nullable = false, length = 1)
	private String tidTipo;

	@OneToMany(mappedBy = "orgTipoDetallePadre", fetch = FetchType.EAGER)
	private Collection<OrgTipoDetalle> orgTipoDetalleCollection;

	@JoinColumn(name = "TID_CODIGO_PADRE", referencedColumnName = "TID_CODIGO")
	@ManyToOne(fetch = FetchType.EAGER)
	private OrgTipoDetalle orgTipoDetallePadre;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgTipoDetalle", fetch = FetchType.LAZY)
	private Collection<OrgTipDetDee> orgTipDetDeeCollection;

	public OrgTipoDetalle() {
	}

	public OrgTipoDetalle(Long tidCodigo) {
		this.tidCodigo = tidCodigo;
	}

	public OrgTipoDetalle(Long tidCodigo, String tidDescripcion, String tidTipo) {
		this.tidCodigo = tidCodigo;
		this.tidDescripcion = tidDescripcion;
		this.tidTipo = tidTipo;
	}

	public Long getTidCodigo() {
		return this.tidCodigo;
	}

	public void setTidCodigo(Long tidCodigo) {
		this.tidCodigo = tidCodigo;
	}

	public String getTidDescripcion() {
		return this.tidDescripcion;
	}

	public void setTidDescripcion(String tidDescripcion) {
		this.tidDescripcion = tidDescripcion;
	}

	public String getTidTipo() {
		return this.tidTipo;
	}

	public void setTidTipo(String tidTipo) {
		this.tidTipo = tidTipo;
	}

	public Collection<OrgTipoDetalle> getOrgTipoDetalleCollection() {
		return this.orgTipoDetalleCollection;
	}

	public void setOrgTipoDetalleCollection(Collection<OrgTipoDetalle> orgTipoDetalleCollection) {
		this.orgTipoDetalleCollection = orgTipoDetalleCollection;
	}

	public OrgTipoDetalle getOrgTipoDetallePadre() {
		return this.orgTipoDetallePadre;
	}

	public void setOrgTipoDetallePadre(OrgTipoDetalle orgTipoDetallePadre) {
		this.orgTipoDetallePadre = orgTipoDetallePadre;
	}

	public Collection<OrgTipDetDee> getOrgTipDetDeeCollection() {
		return this.orgTipDetDeeCollection;
	}

	public void setOrgTipDetDeeCollection(Collection<OrgTipDetDee> orgTipDetDeeCollection) {
		this.orgTipDetDeeCollection = orgTipDetDeeCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OrgTipoDetalle)) {
			return false;
		}
		OrgTipoDetalle other = (OrgTipoDetalle) object;
		return (this.tidCodigo != null || other.tidCodigo == null)
				&& (this.tidCodigo == null || this.tidCodigo.equals(other.tidCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tidCodigo != null) ? this.tidCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "tidCodigo = " + this.tidCodigo + ")";
	}

}
