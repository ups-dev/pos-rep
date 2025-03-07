package ec.edu.ups.pos.rep.data.entities.org;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_PARAMETRO_ESTRUCTURA", schema = "ORG", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "TIP_CODIGO", "PAR_CODIGO", "EST_CODIGO", "PEL_CODIGO", "MOD_CODIGO" }) })
public class OrgParametroEstructura extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PAE_CODIGO", nullable = false, updatable = false)
	private Long paeCodigo;

	@Column(name = "PAE_DECIMAL", precision = 10, scale = 2)
	private BigDecimal paeDecimal;

	@Column(name = "PAE_ENTERO")
	private Long paeEntero;

	@Column(name = "PAE_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paeFecha;

	@Column(name = "PAE_FECHA_HORA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paeFechaHora;

	@Size(max = 50)
	@Column(name = "PAE_TEXTO", length = 50)
	private String paeTexto;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PAE_FECHA_INICIO_VIGENCIA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date paeFechaInicioVigencia;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PAE_FECHA_FIN_VIGENCIA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date paeFechaFinVigencia;

	@Column(name = "MOD_CODIGO")
	private Long modCodigo;

	@JoinColumn(name = "TIP_CODIGO", referencedColumnName = "TIP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipoProceso orgTipoProceso;

	@JoinColumn(name = "PEL_CODIGO", referencedColumnName = "PEL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgPeriodoLectivo orgPeriodoLectivo;

	@JoinColumn(name = "PAR_CODIGO", referencedColumnName = "PAR_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgParametro orgParametro;

	@JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgEstructura orgEstructura;

	public OrgParametroEstructura() {
	}

	public OrgParametroEstructura(Long paeCodigo) {
		this.paeCodigo = paeCodigo;
	}

	public OrgParametroEstructura(Long paeCodigo, Date paeFechaInicioVigencia, Date paeFechaFinVigencia) {
		this.paeCodigo = paeCodigo;
		this.paeFechaInicioVigencia = paeFechaInicioVigencia;
		this.paeFechaFinVigencia = paeFechaFinVigencia;
	}

	public Long getPaeCodigo() {
		return this.paeCodigo;
	}

	public void setPaeCodigo(Long paeCodigo) {
		this.paeCodigo = paeCodigo;
	}

	public BigDecimal getPaeDecimal() {
		return this.paeDecimal;
	}

	public void setPaeDecimal(BigDecimal paeDecimal) {
		this.paeDecimal = paeDecimal;
	}

	public Long getPaeEntero() {
		return this.paeEntero;
	}

	public void setPaeEntero(Long paeEntero) {
		this.paeEntero = paeEntero;
	}

	public Date getPaeFecha() {
		return this.paeFecha;
	}

	public void setPaeFecha(Date paeFecha) {
		this.paeFecha = paeFecha;
	}

	public Date getPaeFechaHora() {
		return this.paeFechaHora;
	}

	public void setPaeFechaHora(Date paeFechaHora) {
		this.paeFechaHora = paeFechaHora;
	}

	public String getPaeTexto() {
		return this.paeTexto;
	}

	public void setPaeTexto(String paeTexto) {
		this.paeTexto = paeTexto;
	}

	public Date getPaeFechaInicioVigencia() {
		return this.paeFechaInicioVigencia;
	}

	public void setPaeFechaInicioVigencia(Date paeFechaInicioVigencia) {
		this.paeFechaInicioVigencia = paeFechaInicioVigencia;
	}

	public Date getPaeFechaFinVigencia() {
		return this.paeFechaFinVigencia;
	}

	public void setPaeFechaFinVigencia(Date paeFechaFinVigencia) {
		this.paeFechaFinVigencia = paeFechaFinVigencia;
	}

	public Long getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Long modCodigo) {
		this.modCodigo = modCodigo;
	}

	public OrgTipoProceso getOrgTipoProceso() {
		return this.orgTipoProceso;
	}

	public void setOrgTipoProceso(OrgTipoProceso orgTipoProceso) {
		this.orgTipoProceso = orgTipoProceso;
	}

	public OrgPeriodoLectivo getOrgPeriodoLectivo() {
		return this.orgPeriodoLectivo;
	}

	public void setOrgPeriodoLectivo(OrgPeriodoLectivo orgPeriodoLectivo) {
		this.orgPeriodoLectivo = orgPeriodoLectivo;
	}

	public OrgParametro getOrgParametro() {
		return this.orgParametro;
	}

	public void setOrgParametro(OrgParametro orgParametro) {
		this.orgParametro = orgParametro;
	}

	public OrgEstructura getOrgEstructura() {
		return this.orgEstructura;
	}

	public void setOrgEstructura(OrgEstructura orgEstructura) {
		this.orgEstructura = orgEstructura;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgParametroEstructura)) {
			return false;
		}
		OrgParametroEstructura other = (OrgParametroEstructura) object;
		return (this.paeCodigo != null || other.paeCodigo == null)
				&& (this.paeCodigo == null || this.paeCodigo.equals(other.paeCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.paeCodigo != null) ? this.paeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "paeCodigo = " + this.paeCodigo + ")";
	}

}
