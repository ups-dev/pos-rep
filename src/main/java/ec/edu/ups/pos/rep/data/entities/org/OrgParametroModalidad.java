package ec.edu.ups.pos.rep.data.entities.org;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_PARAMETRO_MODALIDAD", schema = "ORG")
public class OrgParametroModalidad extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PAM_CODIGO", nullable = false)
	private Long pamCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MOD_CODIGO", nullable = false)
	private Long modCodigo;

	@JoinColumn(name = "PAR_CODIGO", referencedColumnName = "PAR_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgParametro orgParametro;

	public OrgParametroModalidad() {
	}

	public OrgParametroModalidad(Long pamCodigo) {
		this.pamCodigo = pamCodigo;
	}

	public OrgParametroModalidad(Long pamCodigo, Long modCodigo) {
		this.pamCodigo = pamCodigo;
		this.modCodigo = modCodigo;
	}

	public Long getPamCodigo() {
		return this.pamCodigo;
	}

	public void setPamCodigo(Long pamCodigo) {
		this.pamCodigo = pamCodigo;
	}

	public Long getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Long modCodigo) {
		this.modCodigo = modCodigo;
	}

	public OrgParametro getOrgParametro() {
		return this.orgParametro;
	}

	public void setOrgParametro(OrgParametro orgParametro) {
		this.orgParametro = orgParametro;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgParametroModalidad)) {
			return false;
		}
		OrgParametroModalidad other = (OrgParametroModalidad) object;
		return (this.pamCodigo != null || other.pamCodigo == null)
				&& (this.pamCodigo == null || this.pamCodigo.equals(other.pamCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.pamCodigo != null) ? this.pamCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "pamCodigo = " + this.pamCodigo + ")";
	}

}
