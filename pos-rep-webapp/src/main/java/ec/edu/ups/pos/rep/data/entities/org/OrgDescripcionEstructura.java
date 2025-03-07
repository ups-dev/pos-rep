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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_DESCRIPCION_ESTRUCTURA", schema = "ORG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "DEE_DESCRIPCION" }) })
public class OrgDescripcionEstructura extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DEE_CODIGO", nullable = false, updatable = false)
	private Long deeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "DEE_DESCRIPCION", nullable = false, length = 250)
	private String deeDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "DEE_DESCRIPCION_VISUAL", nullable = false, length = 250)
	private String deeDescripcionVisual;

	@Size(max = 10)
	@Column(name = "DEE_ABREVIATURA", length = 10)
	private String deeAbreviatura;

	@Column(name = "TIP_CODIGO_LEG")
	private Long tipCodigoLeg;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgDescripcionEstructura")
	private Collection<OrgEstructura> orgEstructuraCollection;

	@JoinColumn(name = "TIE_CODIGO", referencedColumnName = "TIE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipoEstructura orgTipoEstructura;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgDescripcionEstructura", fetch = FetchType.LAZY)
	private Collection<OrgTipDetDee> orgTipDetDeeCollection;

	/**
	 * Usado para obtener directamente el código de la entidad OrgTipoEstructura.
	 */
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIE_CODIGO", nullable = false, insertable = false, updatable = false)
	private Long tieCodigo;

	public OrgDescripcionEstructura() {
	}

	public OrgDescripcionEstructura(Long deeCodigo) {
		this.deeCodigo = deeCodigo;
	}

	public OrgDescripcionEstructura(Long deeCodigo, String deeDescripcion, String deeDescripcionVisual) {
		this.deeCodigo = deeCodigo;
		this.deeDescripcion = deeDescripcion;
		this.deeDescripcionVisual = deeDescripcionVisual;
	}

	public Long getDeeCodigo() {
		return this.deeCodigo;
	}

	public void setDeeCodigo(Long deeCodigo) {
		this.deeCodigo = deeCodigo;
	}

	public String getDeeDescripcion() {
		return this.deeDescripcion;
	}

	public void setDeeDescripcion(String deeDescripcion) {
		this.deeDescripcion = deeDescripcion;
	}

	public String getDeeDescripcionVisual() {
		return this.deeDescripcionVisual;
	}

	public void setDeeDescripcionVisual(String deeDescripcionVisual) {
		this.deeDescripcionVisual = deeDescripcionVisual;
	}

	public String getDeeAbreviatura() {
		return this.deeAbreviatura;
	}

	public void setDeeAbreviatura(String deeAbreviatura) {
		this.deeAbreviatura = deeAbreviatura;
	}

	public Long getTipCodigoLeg() {
		return this.tipCodigoLeg;
	}

	public void setTipCodigoLeg(Long tipCodigoLeg) {
		this.tipCodigoLeg = tipCodigoLeg;
	}

	public Collection<OrgEstructura> getOrgEstructuraCollection() {
		return this.orgEstructuraCollection;
	}

	public void setOrgEstructuraCollection(Collection<OrgEstructura> orgEstructuraCollection) {
		this.orgEstructuraCollection = orgEstructuraCollection;
	}

	public OrgTipoEstructura getOrgTipoEstructura() {
		return this.orgTipoEstructura;
	}

	public void setOrgTipoEstructura(OrgTipoEstructura orgTipoEstructura) {
		this.orgTipoEstructura = orgTipoEstructura;

		this.tieCodigo = (orgTipoEstructura != null) ? orgTipoEstructura.getTieCodigo() : null;
	}

	public Collection<OrgTipDetDee> getOrgTipDetDeeCollection() {
		return this.orgTipDetDeeCollection;
	}

	public void setOrgTipDetDeeCollection(Collection<OrgTipDetDee> orgTipDetDeeCollection) {
		this.orgTipDetDeeCollection = orgTipDetDeeCollection;
	}

	public Long getTieCodigo() {
		return this.tieCodigo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OrgDescripcionEstructura)) {
			return false;
		}
		OrgDescripcionEstructura other = (OrgDescripcionEstructura) object;
		return (this.deeCodigo != null || other.deeCodigo == null)
				&& (this.deeCodigo == null || this.deeCodigo.equals(other.deeCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.deeCodigo != null) ? this.deeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "OrgDescripcionEstructura{" + "deeCodigo=" + this.deeCodigo + '}';
	}

}
