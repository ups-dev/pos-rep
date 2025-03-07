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
@Table(name = "ORG_TIPO_AREA_GEOGRAFICA", schema = "ORG")
public class OrgTipoAreaGeografica extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TAG_CODIGO", nullable = false, updatable = false)
	private Long tagCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "TAG_DESCRIPCION", nullable = false, length = 50)
	private String tagDescripcion;

	@Size(max = 10)
	@Column(name = "TAG_ABREVIATURA", length = 10)
	private String tagAbreviatura;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgTipoAreaGeografica")
	private Collection<OrgAreaGeografica> orgAreaGeograficaCollection;

	public OrgTipoAreaGeografica() {
	}

	public OrgTipoAreaGeografica(Long tagCodigo) {
		this.tagCodigo = tagCodigo;
	}

	public OrgTipoAreaGeografica(Long tagCodigo, String tagDescripcion) {
		this.tagCodigo = tagCodigo;
		this.tagDescripcion = tagDescripcion;
	}

	public Long getTagCodigo() {
		return this.tagCodigo;
	}

	public void setTagCodigo(Long tagCodigo) {
		this.tagCodigo = tagCodigo;
	}

	public String getTagDescripcion() {
		return this.tagDescripcion;
	}

	public void setTagDescripcion(String tagDescripcion) {
		this.tagDescripcion = tagDescripcion;
	}

	public String getTagAbreviatura() {
		return this.tagAbreviatura;
	}

	public void setTagAbreviatura(String tagAbreviatura) {
		this.tagAbreviatura = tagAbreviatura;
	}

	public Collection<OrgAreaGeografica> getOrgAreaGeograficaCollection() {
		return this.orgAreaGeograficaCollection;
	}

	public void setOrgAreaGeograficaCollection(Collection<OrgAreaGeografica> orgAreaGeograficaCollection) {
		this.orgAreaGeograficaCollection = orgAreaGeograficaCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgTipoAreaGeografica)) {
			return false;
		}
		OrgTipoAreaGeografica other = (OrgTipoAreaGeografica) object;
		return (this.tagCodigo != null || other.tagCodigo == null)
				&& (this.tagCodigo == null || this.tagCodigo.equals(other.tagCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tagCodigo != null) ? this.tagCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "tagCodigo = " + this.tagCodigo + ")";
	}

}
