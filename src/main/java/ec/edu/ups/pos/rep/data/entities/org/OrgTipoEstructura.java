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
@Table(name = "ORG_TIPO_ESTRUCTURA", schema = "ORG")
public class OrgTipoEstructura extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIE_CODIGO", nullable = false, updatable = false)
	private Long tieCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "TIE_DESCRIPCION", nullable = false, length = 50)
	private String tieDescripcion;

	@Column(name = "TIE_NIVEL")
	private Integer tieNivel;

	@Column(name = "TIE_SECUENCIA_INICIAL")
	private Long tieSecuenciaInicial;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgTipoEstructura")
	private Collection<OrgDescripcionEstructura> orgDescripcionEstructuraCollection;

	public OrgTipoEstructura() {
	}

	public OrgTipoEstructura(Long tieCodigo) {
		this.tieCodigo = tieCodigo;
	}

	public OrgTipoEstructura(Long tieCodigo, String tieDescripcion) {
		this.tieCodigo = tieCodigo;
		this.tieDescripcion = tieDescripcion;
	}

	public Long getTieCodigo() {
		return this.tieCodigo;
	}

	public void setTieCodigo(Long tieCodigo) {
		this.tieCodigo = tieCodigo;
	}

	public String getTieDescripcion() {
		return this.tieDescripcion;
	}

	public void setTieDescripcion(String tieDescripcion) {
		this.tieDescripcion = tieDescripcion;
	}

	public Integer getTieNivel() {
		return this.tieNivel;
	}

	public void setTieNivel(Integer tieNivel) {
		this.tieNivel = tieNivel;
	}

	public Long getTieSecuenciaInicial() {
		return this.tieSecuenciaInicial;
	}

	public void setTieSecuenciaInicial(Long tieSecuenciaInicial) {
		this.tieSecuenciaInicial = tieSecuenciaInicial;
	}

	public Collection<OrgDescripcionEstructura> getOrgDescripcionEstructuraCollection() {
		return this.orgDescripcionEstructuraCollection;
	}

	public void setOrgDescripcionEstructuraCollection(
			Collection<OrgDescripcionEstructura> orgDescripcionEstructuraCollection) {
		this.orgDescripcionEstructuraCollection = orgDescripcionEstructuraCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgTipoEstructura)) {
			return false;
		}
		OrgTipoEstructura other = (OrgTipoEstructura) object;
		return (this.tieCodigo != null || other.tieCodigo == null)
				&& (this.tieCodigo == null || this.tieCodigo.equals(other.tieCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tieCodigo != null) ? this.tieCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "tieCodigo = " + this.tieCodigo + ")";
	}

}
