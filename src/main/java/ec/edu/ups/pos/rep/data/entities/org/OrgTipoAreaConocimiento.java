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
@Table(name = "ORG_TIPO_AREA_CONOCIMIENTO", schema = "ORG")
public class OrgTipoAreaConocimiento extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TAC_CODIGO", nullable = false)
	private Long tacCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TAC_DESCRIPCION", nullable = false, length = 100)
	private String tacDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgTipoAreaConocimiento", fetch = FetchType.LAZY)
	private Collection<OrgAreaConocimiento> orgAreaConocimientoCollection;

	public OrgTipoAreaConocimiento() {
	}

	public OrgTipoAreaConocimiento(Long tacCodigo) {
		this.tacCodigo = tacCodigo;
	}

	public OrgTipoAreaConocimiento(Long tacCodigo, String tacDescripcion) {
		this.tacCodigo = tacCodigo;
		this.tacDescripcion = tacDescripcion;
	}

	public Long getTacCodigo() {
		return this.tacCodigo;
	}

	public void setTacCodigo(Long tacCodigo) {
		this.tacCodigo = tacCodigo;
	}

	public String getTacDescripcion() {
		return this.tacDescripcion;
	}

	public void setTacDescripcion(String tacDescripcion) {
		this.tacDescripcion = tacDescripcion;
	}

	public Collection<OrgAreaConocimiento> getOrgAreaConocimientoCollection() {
		return this.orgAreaConocimientoCollection;
	}

	public void setOrgAreaConocimientoCollection(Collection<OrgAreaConocimiento> orgAreaConocimientoCollection) {
		this.orgAreaConocimientoCollection = orgAreaConocimientoCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgTipoAreaConocimiento)) {
			return false;
		}
		OrgTipoAreaConocimiento other = (OrgTipoAreaConocimiento) object;
		return (this.tacCodigo != null || other.tacCodigo == null)
				&& (this.tacCodigo == null || this.tacCodigo.equals(other.tacCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tacCodigo != null) ? this.tacCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "tacCodigo = " + this.tacCodigo + ")";
	}

}
