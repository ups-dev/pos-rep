package ec.edu.ups.pos.rep.data.entities.org;

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
@Table(name = "ORG_TIPO_PROCESO", schema = "ORG")
public class OrgTipoProceso extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIP_CODIGO", nullable = false, updatable = false)
	private Long tipCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TIP_DESCRIPCION", nullable = false, length = 100)
	private String tipDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgTipoProceso")
	private Collection<OrgParametroEstructura> orgParametroEstructuraCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgTipoProceso", fetch = FetchType.LAZY)
	private Collection<OrgEstadoTipoProceso> orgEstadoTipoProcesoCollection;

	@OneToMany(mappedBy = "orgTipoProceso", fetch = FetchType.LAZY)
	private Collection<OrgParametro> orgParametroCollection;

	public OrgTipoProceso() {
	}

	public OrgTipoProceso(Long tipCodigo) {
		this.tipCodigo = tipCodigo;
	}

	public OrgTipoProceso(Long tipCodigo, String tipDescripcion) {
		this.tipCodigo = tipCodigo;
		this.tipDescripcion = tipDescripcion;
	}

	public Long getTipCodigo() {
		return this.tipCodigo;
	}

	public void setTipCodigo(Long tipCodigo) {
		this.tipCodigo = tipCodigo;
	}

	public String getTipDescripcion() {
		return this.tipDescripcion;
	}

	public void setTipDescripcion(String tipDescripcion) {
		this.tipDescripcion = tipDescripcion;
	}

	public Collection<OrgParametroEstructura> getOrgParametroEstructuraCollection() {
		return this.orgParametroEstructuraCollection;
	}

	public void setOrgParametroEstructuraCollection(
			Collection<OrgParametroEstructura> orgParametroEstructuraCollection) {
		this.orgParametroEstructuraCollection = orgParametroEstructuraCollection;
	}

	public Collection<OrgEstadoTipoProceso> getOrgEstadoTipoProcesoCollection() {
		return this.orgEstadoTipoProcesoCollection;
	}

	public void setOrgEstadoTipoProcesoCollection(Collection<OrgEstadoTipoProceso> orgEstadoTipoProcesoCollection) {
		this.orgEstadoTipoProcesoCollection = orgEstadoTipoProcesoCollection;
	}

	public Collection<OrgParametro> getOrgParametroCollection() {
		return this.orgParametroCollection;
	}

	public void setOrgParametroCollection(Collection<OrgParametro> orgParametroCollection) {
		this.orgParametroCollection = orgParametroCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgTipoProceso)) {
			return false;
		}
		OrgTipoProceso other = (OrgTipoProceso) object;
		return (this.tipCodigo != null || other.tipCodigo == null)
				&& (this.tipCodigo == null || this.tipCodigo.equals(other.tipCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tipCodigo != null) ? this.tipCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "tipCodigo = " + this.tipCodigo + ")";
	}

}
