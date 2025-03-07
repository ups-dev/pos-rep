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
@Table(name = "ORG_ESTADO", schema = "ORG")
public class OrgEstado extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "EST_DESCRIPCION", nullable = false, length = 200)
	private String estDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgEstado", fetch = FetchType.LAZY)
	private Collection<OrgEstadoTipoProceso> orgEstadoTipoProcesoCollection;

	public OrgEstado() {
	}

	public OrgEstado(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public OrgEstado(Long estCodigo, String estDescripcion) {
		this.estCodigo = estCodigo;
		this.estDescripcion = estDescripcion;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getEstDescripcion() {
		return this.estDescripcion;
	}

	public void setEstDescripcion(String estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

	public Collection<OrgEstadoTipoProceso> getOrgEstadoTipoProcesoCollection() {
		return this.orgEstadoTipoProcesoCollection;
	}

	public void setOrgEstadoTipoProcesoCollection(Collection<OrgEstadoTipoProceso> orgEstadoTipoProcesoCollection) {
		this.orgEstadoTipoProcesoCollection = orgEstadoTipoProcesoCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgEstado)) {
			return false;
		}
		OrgEstado other = (OrgEstado) object;
		return (this.estCodigo != null || other.estCodigo == null)
				&& (this.estCodigo == null || this.estCodigo.equals(other.estCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.estCodigo != null) ? this.estCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "estCodigo = " + this.estCodigo + ")";
	}

}
