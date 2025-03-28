package ec.edu.ups.pos.rep.data.entities.ped;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_DOC_MAL_TDM", schema = "PED")
public class PedDocMalTdm extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DMT_CODIGO", nullable = false)
	private Long dmtCodigo;

	@Size(max = 100)
	@Column(name = "DMT_DESCRIPCION_TEXTO", length = 100)
	private String dmtDescripcionTexto;

	@Column(name = "DMT_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal dmtDescripcionNumero;

	@Column(name = "DMT_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dmtDescripcionFecha;

	@Column(name = "DMT_FECHA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dmtFechaInicio;

	@Column(name = "DMT_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dmtFechaFin;

	@Size(max = 1)
	@Column(name = "DMT_VIGENTE", length = 1)
	private String dmtVigente;

	@JoinColumn(name = "TDD_CODIGO", referencedColumnName = "TDD_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoDatoDocente pedTipoDatoDocente;

	@JoinColumn(name = "DPE_CODIGO", referencedColumnName = "DPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedDocenteMalla pedDocenteMalla;

	public PedDocMalTdm() {
	}

	public PedDocMalTdm(Long dmtCodigo) {
		this.dmtCodigo = dmtCodigo;
	}

	public Long getDmtCodigo() {
		return this.dmtCodigo;
	}

	public void setDmtCodigo(Long dmtCodigo) {
		this.dmtCodigo = dmtCodigo;
	}

	public String getDmtDescripcionTexto() {
		return this.dmtDescripcionTexto;
	}

	public void setDmtDescripcionTexto(String dmtDescripcionTexto) {
		this.dmtDescripcionTexto = dmtDescripcionTexto;
	}

	public BigDecimal getDmtDescripcionNumero() {
		return this.dmtDescripcionNumero;
	}

	public void setDmtDescripcionNumero(BigDecimal dmtDescripcionNumero) {
		this.dmtDescripcionNumero = dmtDescripcionNumero;
	}

	public Date getDmtDescripcionFecha() {
		return this.dmtDescripcionFecha;
	}

	public void setDmtDescripcionFecha(Date dmtDescripcionFecha) {
		this.dmtDescripcionFecha = dmtDescripcionFecha;
	}

	public Date getDmtFechaInicio() {
		return this.dmtFechaInicio;
	}

	public void setDmtFechaInicio(Date dmtFechaInicio) {
		this.dmtFechaInicio = dmtFechaInicio;
	}

	public Date getDmtFechaFin() {
		return this.dmtFechaFin;
	}

	public void setDmtFechaFin(Date dmtFechaFin) {
		this.dmtFechaFin = dmtFechaFin;
	}

	public String getDmtVigente() {
		return this.dmtVigente;
	}

	public void setDmtVigente(String dmtVigente) {
		this.dmtVigente = dmtVigente;
	}

	public PedTipoDatoDocente getPedTipoDatoDocente() {
		return this.pedTipoDatoDocente;
	}

	public void setPedTipoDatoDocente(PedTipoDatoDocente pedTipoDatoDocente) {
		this.pedTipoDatoDocente = pedTipoDatoDocente;
	}

	public PedDocenteMalla getPedDocenteMalla() {
		return this.pedDocenteMalla;
	}

	public void setPedDocenteMalla(PedDocenteMalla pedDocenteMalla) {
		this.pedDocenteMalla = pedDocenteMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedDocMalTdm)) {
			return false;
		}
		PedDocMalTdm other = (PedDocMalTdm) object;
		if ((this.dmtCodigo == null && other.dmtCodigo != null)
				|| (this.dmtCodigo != null && !this.dmtCodigo.equals(other.dmtCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.dmtCodigo != null) ? this.dmtCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedDocMalTdm[ dmtCodigo=" + this.dmtCodigo + " ]";
	}

}
