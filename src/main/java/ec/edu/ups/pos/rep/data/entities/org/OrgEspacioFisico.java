package ec.edu.ups.pos.rep.data.entities.org;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "ORG_ESPACIO_FISICO", schema = "ORG")
public class OrgEspacioFisico extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ESF_CODIGO", nullable = false, updatable = false)
	private Long esfCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "ESF_DESCRIPCION", nullable = false, length = 250)
	private String esfDescripcion;

	@Column(name = "ESF_NUMERO")
	private Integer esfNumero;

	@Column(name = "ESF_CAPACIDAD")
	private Integer esfCapacidad;

	@Column(name = "ESF_ALTO", precision = 6, scale = 2)
	private BigDecimal esfAlto;

	@Column(name = "ESF_ANCHO", precision = 6, scale = 2)
	private BigDecimal esfAncho;

	@Column(name = "ESF_LARGO", precision = 6, scale = 2)
	private BigDecimal esfLargo;

	@Column(name = "ESF_PISO")
	private Integer esfPiso;

	@Column(name = "ESF_CODIGO_LEG")
	private Long esfCodigoLeg;

	@Column(name = "ESF_AFORO")
	private Integer esfAforo;

	@JoinColumn(name = "BLO_CODIGO", referencedColumnName = "BLO_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgBloque orgBloque;

	@OneToMany(mappedBy = "orgEspacioFisicoPadre")
	private Collection<OrgEspacioFisico> orgEspacioFisicoCollection;

	@JoinColumn(name = "ESF_PADRE", referencedColumnName = "ESF_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgEspacioFisico orgEspacioFisicoPadre;

	@JoinColumn(name = "TEF_CODIGO", referencedColumnName = "TEF_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipoEspacioFisico orgTipoEspacioFisico;

	public OrgEspacioFisico() {
	}

	public OrgEspacioFisico(Long esfCodigo) {
		this.esfCodigo = esfCodigo;
	}

	public OrgEspacioFisico(Long esfCodigo, String esfDescripcion) {
		this.esfCodigo = esfCodigo;
		this.esfDescripcion = esfDescripcion;
	}

	public Long getEsfCodigo() {
		return this.esfCodigo;
	}

	public void setEsfCodigo(Long esfCodigo) {
		this.esfCodigo = esfCodigo;
	}

	public String getEsfDescripcion() {
		return this.esfDescripcion;
	}

	public void setEsfDescripcion(String esfDescripcion) {
		this.esfDescripcion = esfDescripcion;
	}

	public Integer getEsfNumero() {
		return this.esfNumero;
	}

	public void setEsfNumero(Integer esfNumero) {
		this.esfNumero = esfNumero;
	}

	public Integer getEsfCapacidad() {
		return this.esfCapacidad;
	}

	public void setEsfCapacidad(Integer esfCapacidad) {
		this.esfCapacidad = esfCapacidad;
	}

	public BigDecimal getEsfAlto() {
		return this.esfAlto;
	}

	public void setEsfAlto(BigDecimal esfAlto) {
		this.esfAlto = esfAlto;
	}

	public BigDecimal getEsfAncho() {
		return this.esfAncho;
	}

	public void setEsfAncho(BigDecimal esfAncho) {
		this.esfAncho = esfAncho;
	}

	public BigDecimal getEsfLargo() {
		return this.esfLargo;
	}

	public void setEsfLargo(BigDecimal esfLargo) {
		this.esfLargo = esfLargo;
	}

	public Integer getEsfPiso() {
		return this.esfPiso;
	}

	public void setEsfPiso(Integer esfPiso) {
		this.esfPiso = esfPiso;
	}

	public Long getEsfCodigoLeg() {
		return this.esfCodigoLeg;
	}

	public void setEsfCodigoLeg(Long esfCodigoLeg) {
		this.esfCodigoLeg = esfCodigoLeg;
	}

	public Integer getEsfAforo() {
		return this.esfAforo;
	}

	public void setEsfAforo(Integer esfAforo) {
		this.esfAforo = esfAforo;
	}

	public OrgBloque getOrgBloque() {
		return this.orgBloque;
	}

	public void setOrgBloque(OrgBloque orgBloque) {
		this.orgBloque = orgBloque;
	}

	public Collection<OrgEspacioFisico> getOrgEspacioFisicoCollection() {
		return this.orgEspacioFisicoCollection;
	}

	public void setOrgEspacioFisicoCollection(Collection<OrgEspacioFisico> orgEspacioFisicoCollection) {
		this.orgEspacioFisicoCollection = orgEspacioFisicoCollection;
	}

	public OrgEspacioFisico getOrgEspacioFisicoPadre() {
		return this.orgEspacioFisicoPadre;
	}

	public void setOrgEspacioFisicoPadre(OrgEspacioFisico orgEspacioFisicoPadre) {
		this.orgEspacioFisicoPadre = orgEspacioFisicoPadre;
	}

	public OrgTipoEspacioFisico getOrgTipoEspacioFisico() {
		return this.orgTipoEspacioFisico;
	}

	public void setOrgTipoEspacioFisico(OrgTipoEspacioFisico orgTipoEspacioFisico) {
		this.orgTipoEspacioFisico = orgTipoEspacioFisico;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgEspacioFisico)) {
			return false;
		}
		OrgEspacioFisico other = (OrgEspacioFisico) object;
		return (this.esfCodigo != null || other.esfCodigo == null)
				&& (this.esfCodigo == null || this.esfCodigo.equals(other.esfCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.esfCodigo != null) ? this.esfCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "esfCodigo = " + this.esfCodigo + ")";
	}

}
