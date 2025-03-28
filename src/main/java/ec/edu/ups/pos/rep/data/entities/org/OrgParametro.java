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
@Table(name = "ORG_PARAMETRO", schema = "ORG")
public class OrgParametro extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PAR_CODIGO", nullable = false, updatable = false)
	private Long parCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "PAR_DESCRIPCION", nullable = false, length = 200)
	private String parDescripcion;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PAR_TIPO", nullable = false)
	private Integer parTipo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgParametro")
	private Collection<OrgParametroEstructura> orgParametroEstructuraCollection;

	@JoinColumn(name = "TIP_CODIGO", referencedColumnName = "TIP_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgTipoProceso orgTipoProceso;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgParametro", fetch = FetchType.LAZY)
	private Collection<OrgParametroModalidad> orgParametroModalidadCollection;

	public OrgParametro() {
	}

	public OrgParametro(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public OrgParametro(Long parCodigo, String parDescripcion, Integer parTipo) {
		this.parCodigo = parCodigo;
		this.parDescripcion = parDescripcion;
		this.parTipo = parTipo;
	}

	public Long getParCodigo() {
		return this.parCodigo;
	}

	public void setParCodigo(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public String getParDescripcion() {
		return this.parDescripcion;
	}

	public void setParDescripcion(String parDescripcion) {
		this.parDescripcion = parDescripcion;
	}

	public Integer getParTipo() {
		return this.parTipo;
	}

	public void setParTipo(Integer parTipo) {
		this.parTipo = parTipo;
	}

	public Collection<OrgParametroEstructura> getOrgParametroEstructuraCollection() {
		return this.orgParametroEstructuraCollection;
	}

	public void setOrgParametroEstructuraCollection(
			Collection<OrgParametroEstructura> orgParametroEstructuraCollection) {
		this.orgParametroEstructuraCollection = orgParametroEstructuraCollection;
	}

	public OrgTipoProceso getOrgTipoProceso() {
		return this.orgTipoProceso;
	}

	public void setOrgTipoProceso(OrgTipoProceso orgTipoProceso) {
		this.orgTipoProceso = orgTipoProceso;
	}

	public Collection<OrgParametroModalidad> getOrgParametroModalidadCollection() {
		return this.orgParametroModalidadCollection;
	}

	public void setOrgParametroModalidadCollection(Collection<OrgParametroModalidad> orgParametroModalidadCollection) {
		this.orgParametroModalidadCollection = orgParametroModalidadCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgParametro)) {
			return false;
		}
		OrgParametro other = (OrgParametro) object;
		return (this.parCodigo != null || other.parCodigo == null)
				&& (this.parCodigo == null || this.parCodigo.equals(other.parCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.parCodigo != null) ? this.parCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "parCodigo = " + this.parCodigo + ")";
	}

}
