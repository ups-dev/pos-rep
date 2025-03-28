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
@Table(name = "ORG_BLOQUE", schema = "ORG")
public class OrgBloque extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "BLO_CODIGO", nullable = false, updatable = false)
	private Long bloCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "BLO_DESCRIPCION", nullable = false, length = 250)
	private String bloDescripcion;

	@Size(max = 250)
	@Column(name = "BLO_UBICACION", length = 250)
	private String bloUbicacion;

	@Column(name = "BLO_NRO_PISO_SOBRE")
	private Integer bloNroPisoSobre;

	@Column(name = "BLO_NRO_PISO_BAJO")
	private Integer bloNroPisoBajo;

	@Column(name = "BLO_CODIGO_LEG")
	private Long bloCodigoLeg;

	@JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgEstructura orgEstructura;

	@JoinColumn(name = "BLO_CODIGO_PADRE", referencedColumnName = "BLO_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgBloque orgBloquePadre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orgBloque")
	private Collection<OrgEspacioFisico> orgEspacioFisicoCollection;

	@OneToMany(mappedBy = "orgBloquePadre", fetch = FetchType.LAZY)
	private Collection<OrgBloque> orgBloqueCollection;

	public OrgBloque() {
	}

	public OrgBloque(Long bloCodigo) {
		this.bloCodigo = bloCodigo;
	}

	public OrgBloque(Long bloCodigo, String bloDescripcion) {
		this.bloCodigo = bloCodigo;
		this.bloDescripcion = bloDescripcion;
	}

	public Long getBloCodigo() {
		return this.bloCodigo;
	}

	public void setBloCodigo(Long bloCodigo) {
		this.bloCodigo = bloCodigo;
	}

	public String getBloDescripcion() {
		return this.bloDescripcion;
	}

	public void setBloDescripcion(String bloDescripcion) {
		this.bloDescripcion = bloDescripcion;
	}

	public String getBloUbicacion() {
		return this.bloUbicacion;
	}

	public void setBloUbicacion(String bloUbicacion) {
		this.bloUbicacion = bloUbicacion;
	}

	public Integer getBloNroPisoSobre() {
		return this.bloNroPisoSobre;
	}

	public void setBloNroPisoSobre(Integer bloNroPisoSobre) {
		this.bloNroPisoSobre = bloNroPisoSobre;
	}

	public Integer getBloNroPisoBajo() {
		return this.bloNroPisoBajo;
	}

	public void setBloNroPisoBajo(Integer bloNroPisoBajo) {
		this.bloNroPisoBajo = bloNroPisoBajo;
	}

	public Long getBloCodigoLeg() {
		return this.bloCodigoLeg;
	}

	public void setBloCodigoLeg(Long bloCodigoLeg) {
		this.bloCodigoLeg = bloCodigoLeg;
	}

	public OrgEstructura getOrgEstructura() {
		return this.orgEstructura;
	}

	public void setOrgEstructura(OrgEstructura orgEstructura) {
		this.orgEstructura = orgEstructura;
	}

	public OrgBloque getOrgBloquePadre() {
		return this.orgBloquePadre;
	}

	public void setOrgBloquePadre(OrgBloque orgBloquePadre) {
		this.orgBloquePadre = orgBloquePadre;
	}

	public Collection<OrgEspacioFisico> getOrgEspacioFisicoCollection() {
		return this.orgEspacioFisicoCollection;
	}

	public void setOrgEspacioFisicoCollection(Collection<OrgEspacioFisico> orgEspacioFisicoCollection) {
		this.orgEspacioFisicoCollection = orgEspacioFisicoCollection;
	}

	public Collection<OrgBloque> getOrgBloqueCollection() {
		return this.orgBloqueCollection;
	}

	public void setOrgBloqueCollection(Collection<OrgBloque> orgBloqueCollection) {
		this.orgBloqueCollection = orgBloqueCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgBloque)) {
			return false;
		}
		OrgBloque other = (OrgBloque) object;
		return (this.bloCodigo != null || other.bloCodigo == null)
				&& (this.bloCodigo == null || this.bloCodigo.equals(other.bloCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.bloCodigo != null) ? this.bloCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "bloCodigo = " + this.bloCodigo + ")";
	}

}
