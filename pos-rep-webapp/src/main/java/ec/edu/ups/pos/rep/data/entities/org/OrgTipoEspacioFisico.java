package ec.edu.ups.pos.rep.data.entities.org;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_TIPO_ESPACIO_FISICO", schema = "ORG")
public class OrgTipoEspacioFisico extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TEF_CODIGO", nullable = false, updatable = false)
	private Long tefCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TEF_DESCRIPCION", nullable = false, length = 100)
	private String tefDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgTipoEspacioFisico")
	private Collection<OrgEspacioFisico> orgEspacioFisicoCollection;

	public OrgTipoEspacioFisico() {
	}

	public OrgTipoEspacioFisico(Long tefCodigo) {
		this.tefCodigo = tefCodigo;
	}

	public OrgTipoEspacioFisico(Long tefCodigo, String tefDescripcion) {
		this.tefCodigo = tefCodigo;
		this.tefDescripcion = tefDescripcion;
	}

	public Long getTefCodigo() {
		return this.tefCodigo;
	}

	public void setTefCodigo(Long tefCodigo) {
		this.tefCodigo = tefCodigo;
	}

	public String getTefDescripcion() {
		return this.tefDescripcion;
	}

	public void setTefDescripcion(String tefDescripcion) {
		this.tefDescripcion = tefDescripcion;
	}

	public Collection<OrgEspacioFisico> getOrgEspacioFisicoCollection() {
		return this.orgEspacioFisicoCollection;
	}

	public void setOrgEspacioFisicoCollection(Collection<OrgEspacioFisico> orgEspacioFisicoCollection) {
		this.orgEspacioFisicoCollection = orgEspacioFisicoCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgTipoEspacioFisico)) {
			return false;
		}
		OrgTipoEspacioFisico other = (OrgTipoEspacioFisico) object;
		return (this.tefCodigo != null || other.tefCodigo == null)
				&& (this.tefCodigo == null || this.tefCodigo.equals(other.tefCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tefCodigo != null) ? this.tefCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "tefCodigo = " + this.tefCodigo + ")";
	}

}
