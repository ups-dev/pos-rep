package ec.edu.ups.pos.rep.data.entities.org;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_ESTRUCTURA", schema = "ORG")
public class OrgEstructura extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO_REFERENCIAL", nullable = false)
	private Long estCodigoReferencial;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_NIVEL", nullable = false)
	private Integer estNivel;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "EST_ACTIVADO", nullable = false, length = 1)
	private String estActivado;

	@Column(name = "EST_SED_LEG")
	private Long estSedLeg;

	@Column(name = "EST_CAM_LEG")
	private Long estCamLeg;

	@Column(name = "EST_FAC_LEG")
	private Long estFacLeg;

	@Column(name = "EST_CAR_LEG")
	private Long estCarLeg;

	@Size(max = 2)
	@Column(name = "ELIS_CODIGO", length = 2)
	private String elisCodigo;

	@Column(name = "NCTB_CDG")
	private Integer nctbCdg;

	@Column(name = "EMPR_CDG")
	private Integer emprCdg;

	@Column(name = "NCTB_ANIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nctbAnio;

	@Size(max = 3)
	@Column(name = "NCTB_CDG_NIVEL", length = 3)
	private String nctbCdgNivel;

	@Column(name = "CARR_CDG")
	private Long carrCdg;

	@Column(name = "PER_CODIGO")
	private Long perCodigo;

	@Column(name = "AEC_CODIGO")
	private Long aecCodigo;

	@Column(name = "EMPR_CDG_CCOSTO")
	private Short emprCdgCcosto;

	@Size(max = 200)
	@Column(name = "EST_DIRECCION", length = 200)
	private String estDireccion;

	@Size(max = 12)
	@Column(name = "CODI_CODIGO", length = 12)
	private String codiCodigo;

	@Size(max = 6)
	@Column(name = "SUFA_CODIGO", length = 6)
	private String sufaCodigo;

	@Size(max = 100)
	@Column(name = "EST_CODIFICACION", length = 100)
	private String estCodificacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orgEstructura")
	private Collection<OrgPeriodoEstructura> orgPeriodoEstructuraCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orgEstructura")
	private Collection<OrgBloque> orgBloqueCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orgEstructura")
	private Collection<OrgParametroEstructura> orgParametroEstructuraCollection;

	@OneToMany(mappedBy = "orgEstructuraPadre")
	private Collection<OrgEstructura> orgEstructuraCollection;

	@JoinColumn(name = "EST_CODIGO_PADRE", referencedColumnName = "EST_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgEstructura orgEstructuraPadre;

	@JoinColumn(name = "DEE_CODIGO", referencedColumnName = "DEE_CODIGO", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgDescripcionEstructura orgDescripcionEstructura;

	@JoinColumn(name = "ARG_CODIGO", referencedColumnName = "ARG_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgAreaGeografica orgAreaGeografica;

	public OrgEstructura() {
	}

	public OrgEstructura(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getEstCodigoReferencial() {
		return this.estCodigoReferencial;
	}

	public void setEstCodigoReferencial(Long estCodigoReferencial) {
		this.estCodigoReferencial = estCodigoReferencial;
	}

	public Integer getEstNivel() {
		return this.estNivel;
	}

	public void setEstNivel(Integer estNivel) {
		this.estNivel = estNivel;
	}

	public String getEstActivado() {
		return this.estActivado;
	}

	public void setEstActivado(String estActivado) {
		this.estActivado = estActivado;
	}

	public Long getEstSedLeg() {
		return this.estSedLeg;
	}

	public void setEstSedLeg(Long estSedLeg) {
		this.estSedLeg = estSedLeg;
	}

	public Long getEstCamLeg() {
		return this.estCamLeg;
	}

	public void setEstCamLeg(Long estCamLeg) {
		this.estCamLeg = estCamLeg;
	}

	public Long getEstFacLeg() {
		return this.estFacLeg;
	}

	public void setEstFacLeg(Long estFacLeg) {
		this.estFacLeg = estFacLeg;
	}

	public Long getEstCarLeg() {
		return this.estCarLeg;
	}

	public void setEstCarLeg(Long estCarLeg) {
		this.estCarLeg = estCarLeg;
	}

	public String getElisCodigo() {
		return this.elisCodigo;
	}

	public void setElisCodigo(String elisCodigo) {
		this.elisCodigo = elisCodigo;
	}

	public Integer getNctbCdg() {
		return this.nctbCdg;
	}

	public void setNctbCdg(Integer nctbCdg) {
		this.nctbCdg = nctbCdg;
	}

	public Integer getEmprCdg() {
		return this.emprCdg;
	}

	public void setEmprCdg(Integer emprCdg) {
		this.emprCdg = emprCdg;
	}

	public Date getNctbAnio() {
		return this.nctbAnio;
	}

	public void setNctbAnio(Date nctbAnio) {
		this.nctbAnio = nctbAnio;
	}

	public String getNctbCdgNivel() {
		return this.nctbCdgNivel;
	}

	public void setNctbCdgNivel(String nctbCdgNivel) {
		this.nctbCdgNivel = nctbCdgNivel;
	}

	public Long getCarrCdg() {
		return this.carrCdg;
	}

	public void setCarrCdg(Long carrCdg) {
		this.carrCdg = carrCdg;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Long getAecCodigo() {
		return this.aecCodigo;
	}

	public void setAecCodigo(Long aecCodigo) {
		this.aecCodigo = aecCodigo;
	}

	public Short getEmprCdgCcosto() {
		return this.emprCdgCcosto;
	}

	public void setEmprCdgCcosto(Short emprCdgCcosto) {
		this.emprCdgCcosto = emprCdgCcosto;
	}

	public String getEstDireccion() {
		return this.estDireccion;
	}

	public void setEstDireccion(String estDireccion) {
		this.estDireccion = estDireccion;
	}

	public String getCodiCodigo() {
		return this.codiCodigo;
	}

	public void setCodiCodigo(String codiCodigo) {
		this.codiCodigo = codiCodigo;
	}

	public String getSufaCodigo() {
		return this.sufaCodigo;
	}

	public void setSufaCodigo(String sufaCodigo) {
		this.sufaCodigo = sufaCodigo;
	}

	public String getEstCodificacion() {
		return this.estCodificacion;
	}

	public void setEstCodificacion(String estCodificacion) {
		this.estCodificacion = estCodificacion;
	}

	public Collection<OrgPeriodoEstructura> getOrgPeriodoEstructuraCollection() {
		return this.orgPeriodoEstructuraCollection;
	}

	public void setOrgPeriodoEstructuraCollection(Collection<OrgPeriodoEstructura> orgPeriodoEstructuraCollection) {
		this.orgPeriodoEstructuraCollection = orgPeriodoEstructuraCollection;
	}

	public Collection<OrgBloque> getOrgBloqueCollection() {
		return this.orgBloqueCollection;
	}

	public void setOrgBloqueCollection(Collection<OrgBloque> orgBloqueCollection) {
		this.orgBloqueCollection = orgBloqueCollection;
	}

	public Collection<OrgParametroEstructura> getOrgParametroEstructuraCollection() {
		return this.orgParametroEstructuraCollection;
	}

	public void setOrgParametroEstructuraCollection(
			Collection<OrgParametroEstructura> orgParametroEstructuraCollection) {
		this.orgParametroEstructuraCollection = orgParametroEstructuraCollection;
	}

	public Collection<OrgEstructura> getOrgEstructuraCollection() {
		return this.orgEstructuraCollection;
	}

	public void setOrgEstructuraCollection(Collection<OrgEstructura> orgEstructuraCollection) {
		this.orgEstructuraCollection = orgEstructuraCollection;
	}

	public OrgEstructura getOrgEstructuraPadre() {
		return this.orgEstructuraPadre;
	}

	public void setOrgEstructuraPadre(OrgEstructura orgEstructuraPadre) {
		this.orgEstructuraPadre = orgEstructuraPadre;
	}

	public OrgDescripcionEstructura getOrgDescripcionEstructura() {
		return this.orgDescripcionEstructura;
	}

	public void setOrgDescripcionEstructura(OrgDescripcionEstructura orgDescripcionEstructura) {
		this.orgDescripcionEstructura = orgDescripcionEstructura;
	}

	public OrgAreaGeografica getOrgAreaGeografica() {
		return this.orgAreaGeografica;
	}

	public void setOrgAreaGeografica(OrgAreaGeografica orgAreaGeografica) {
		this.orgAreaGeografica = orgAreaGeografica;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgEstructura)) {
			return false;
		}
		OrgEstructura other = (OrgEstructura) object;
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
		return "OrgEstructura{" + "estCodigo=" + this.estCodigo + '}';
	}

}
