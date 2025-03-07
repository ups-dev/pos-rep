package ec.edu.ups.pos.rep.data.entities.org;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_TIPO_DESIGNACION", schema = "ORG")
public class OrgTipoDesignacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TID_CODIGO", nullable = false)
	private Long tidCodigo;

	@Basic(optional = false)
	@Column(name = "TID_DESCRIPCION", nullable = false)
	private String tidDescripcion;

	@JoinColumn(name = "TIE_CODIGO", referencedColumnName = "TIE_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private OrgTipoEstructura orgTipoEstructura;

	public OrgTipoDesignacion() {
	}

	public OrgTipoDesignacion(Long tidCodigo) {
		this.tidCodigo = tidCodigo;
	}

	public OrgTipoDesignacion(Long tidCodigo, String tidDescripcion) {
		this.tidCodigo = tidCodigo;
		this.tidDescripcion = tidDescripcion;
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

	public OrgTipoEstructura getOrgTipoEstructura() {
		return this.orgTipoEstructura;
	}

	public void setOrgTipoEstructura(OrgTipoEstructura orgTipoEstructura) {
		this.orgTipoEstructura = orgTipoEstructura;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OrgTipoDesignacion)) {
			return false;
		}
		OrgTipoDesignacion other = (OrgTipoDesignacion) object;
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
