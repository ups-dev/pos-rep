package ec.edu.ups.pos.rep.data.entities.ins;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.pos.rep.data.entities.sol.SolSolicitud;
import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_IPA_CDD", schema = "INS")
public class InsIpaCdd extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "IIC_CODIGO", nullable = false)
	private Long iicCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CDD_CODIGO", nullable = false)
	private long cddCodigo;

	@Column(name = "IIC_FECHA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date iicFechaInicio;

	@Column(name = "IIC_FECHA_EGRESA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date iicFechaEgresa;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "IIC_EGRESADO", nullable = false, length = 1)
	private String iicEgresado;

	@Column(name = "IIC_FECHA_ENTREGA_TITULO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date iicFechaEntregaTitulo;

	@Size(max = 1)
	@Column(name = "IIC_TIPO_ENTREGA_TITULO", length = 1)
	private String iicTipoEntregaTitulo;

	@Column(name = "TXI_CODIGO_LEG")
	private Long txiCodigoLeg;

	@JoinColumn(name = "IPA_CODIGO", referencedColumnName = "IPA_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private InsInsProAca insInsProAca;

	@JoinColumn(name = "SOL_CODIGO", referencedColumnName = "SOL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SolSolicitud solSolicitud;

	public InsIpaCdd() {
	}

	public InsIpaCdd(Long iicCodigo) {
		this.iicCodigo = iicCodigo;
	}

	public InsIpaCdd(Long iicCodigo, long cddCodigo, String iicEgresado) {
		this.iicCodigo = iicCodigo;
		this.cddCodigo = cddCodigo;
		this.iicEgresado = iicEgresado;
	}

	public Long getIicCodigo() {
		return this.iicCodigo;
	}

	public void setIicCodigo(Long iicCodigo) {
		this.iicCodigo = iicCodigo;
	}

	public long getCddCodigo() {
		return this.cddCodigo;
	}

	public void setCddCodigo(long cddCodigo) {
		this.cddCodigo = cddCodigo;
	}

	public Date getIicFechaInicio() {
		return this.iicFechaInicio;
	}

	public void setIicFechaInicio(Date iicFechaInicio) {
		this.iicFechaInicio = iicFechaInicio;
	}

	public Date getIicFechaEgresa() {
		return this.iicFechaEgresa;
	}

	public void setIicFechaEgresa(Date iicFechaEgresa) {
		this.iicFechaEgresa = iicFechaEgresa;
	}

	public String getIicEgresado() {
		return this.iicEgresado;
	}

	public void setIicEgresado(String iicEgresado) {
		this.iicEgresado = iicEgresado;
	}

	public Date getIicFechaEntregaTitulo() {
		return this.iicFechaEntregaTitulo;
	}

	public void setIicFechaEntregaTitulo(Date iicFechaEntregaTitulo) {
		this.iicFechaEntregaTitulo = iicFechaEntregaTitulo;
	}

	public String getIicTipoEntregaTitulo() {
		return this.iicTipoEntregaTitulo;
	}

	public void setIicTipoEntregaTitulo(String iicTipoEntregaTitulo) {
		this.iicTipoEntregaTitulo = iicTipoEntregaTitulo;
	}

	public Long getTxiCodigoLeg() {
		return this.txiCodigoLeg;
	}

	public void setTxiCodigoLeg(Long txiCodigoLeg) {
		this.txiCodigoLeg = txiCodigoLeg;
	}

	public InsInsProAca getInsInsProAca() {
		return this.insInsProAca;
	}

	public void setInsInsProAca(InsInsProAca insInsProAca) {
		this.insInsProAca = insInsProAca;
	}

	public SolSolicitud getSolSolicitud() {
		return this.solSolicitud;
	}

	public void setSolSolicitud(SolSolicitud solSolicitud) {
		this.solSolicitud = solSolicitud;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsIpaCdd)) {
			return false;
		}
		InsIpaCdd other = (InsIpaCdd) object;
		if ((this.iicCodigo == null && other.iicCodigo != null)
				|| (this.iicCodigo != null && !this.iicCodigo.equals(other.iicCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.iicCodigo != null) ? this.iicCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsIpaCdd[ iicCodigo=" + this.iicCodigo + " ]";
	}

}
