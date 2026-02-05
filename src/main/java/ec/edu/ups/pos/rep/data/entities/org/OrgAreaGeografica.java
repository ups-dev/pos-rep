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
@Table(name = "ORG_AREA_GEOGRAFICA", schema = "ORG")
public class OrgAreaGeografica extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ARG_CODIGO", nullable = false, updatable = false)
	private Long argCodigo;

	@Size(max = 250)
	@Column(name = "ARG_NOMBRE", length = 250)
	private String argNombre;

	@Size(max = 10)
	@Column(name = "ARG_CODIGO_ESTANDAR", length = 10)
	private String argCodigoEstandar;

	@Size(max = 3)
	@Column(name = "ARG_ABREVIATURA", length = 3)
	private String argAbreviatura;

	@Size(max = 2)
	@Column(name = "ARG_DOMINIO", length = 2)
	private String argDominio;

	@Size(max = 10)
	@Column(name = "ARG_CODIGO_AREA", length = 10)
	private String argCodigoArea;

	@Size(max = 50)
	@Column(name = "ARG_NACIONALIDAD", length = 50)
	private String argNacionalidad;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgAreaGeografica")
	private Collection<OrgEstructura> orgEstructuraCollection;

	@OneToMany(mappedBy = "orgAreaGeograficaPadre")
	private Collection<OrgAreaGeografica> orgAreaGeograficaCollection;

	@JoinColumn(name = "ARG_CODIGO_PADRE", referencedColumnName = "ARG_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgAreaGeografica orgAreaGeograficaPadre;

	@JoinColumn(name = "TAG_CODIGO", referencedColumnName = "TAG_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipoAreaGeografica orgTipoAreaGeografica;

	public OrgAreaGeografica() {
	}

	public OrgAreaGeografica(Long argCodigo) {
		this.argCodigo = argCodigo;
	}

	public OrgAreaGeografica(Long argCodigo, String argNombre) {
		this.argCodigo = argCodigo;
		this.argNombre = argNombre;
	}

	public Long getArgCodigo() {
		return this.argCodigo;
	}

	public void setArgCodigo(Long argCodigo) {
		this.argCodigo = argCodigo;
	}

	public String getArgNombre() {
		return this.argNombre;
	}

	public void setArgNombre(String argNombre) {
		this.argNombre = argNombre;
	}

	public String getArgCodigoEstandar() {
		return this.argCodigoEstandar;
	}

	public void setArgCodigoEstandar(String argCodigoEstandar) {
		this.argCodigoEstandar = argCodigoEstandar;
	}

	public String getArgAbreviatura() {
		return this.argAbreviatura;
	}

	public void setArgAbreviatura(String argAbreviatura) {
		this.argAbreviatura = argAbreviatura;
	}

	public String getArgDominio() {
		return this.argDominio;
	}

	public void setArgDominio(String argDominio) {
		this.argDominio = argDominio;
	}

	public String getArgCodigoArea() {
		return this.argCodigoArea;
	}

	public void setArgCodigoArea(String argCodigoArea) {
		this.argCodigoArea = argCodigoArea;
	}

	public String getArgNacionalidad() {
		return this.argNacionalidad;
	}

	public void setArgNacionalidad(String argNacionalidad) {
		this.argNacionalidad = argNacionalidad;
	}

	public Collection<OrgEstructura> getOrgEstructuraCollection() {
		return this.orgEstructuraCollection;
	}

	public void setOrgEstructuraCollection(Collection<OrgEstructura> orgEstructuraCollection) {
		this.orgEstructuraCollection = orgEstructuraCollection;
	}

	public Collection<OrgAreaGeografica> getOrgAreaGeograficaCollection() {
		return this.orgAreaGeograficaCollection;
	}

	public void setOrgAreaGeograficaCollection(Collection<OrgAreaGeografica> orgAreaGeograficaCollection) {
		this.orgAreaGeograficaCollection = orgAreaGeograficaCollection;
	}

	public OrgAreaGeografica getOrgAreaGeograficaPadre() {
		return this.orgAreaGeograficaPadre;
	}

	public void setOrgAreaGeograficaPadre(OrgAreaGeografica orgAreaGeograficaPadre) {
		this.orgAreaGeograficaPadre = orgAreaGeograficaPadre;
	}

	public OrgTipoAreaGeografica getOrgTipoAreaGeografica() {
		return this.orgTipoAreaGeografica;
	}

	public void setOrgTipoAreaGeografica(OrgTipoAreaGeografica orgTipoAreaGeografica) {
		this.orgTipoAreaGeografica = orgTipoAreaGeografica;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgAreaGeografica)) {
			return false;
		}
		OrgAreaGeografica other = (OrgAreaGeografica) object;
		return (this.argCodigo != null || other.argCodigo == null)
				&& (this.argCodigo == null || this.argCodigo.equals(other.argCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.argCodigo != null) ? this.argCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "argCodigo = " + this.argCodigo + ")";
	}

}
