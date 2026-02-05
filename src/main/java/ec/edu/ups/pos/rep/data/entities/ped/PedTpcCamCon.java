package ec.edu.ups.pos.rep.data.entities.ped;

import java.math.BigDecimal;
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
@Table(name = "PED_TPC_CAM_CON", schema = "PED")
public class PedTpcCamCon extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TCC_CODIGO", nullable = false)
	private Long tccCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TPC_ORDEN", nullable = false)
	private Integer tpcOrden;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TPC_TIENE_ANEXO", nullable = false, length = 1)
	private String tpcTieneAnexo;

	@Size(max = 100)
	@Column(name = "TCC_DESCRIPCION_TEXTO", length = 100)
	private String tccDescripcionTexto;

	@Column(name = "TCC_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal tccDescripcionNumero;

	@Column(name = "TCC_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tccDescripcionFecha;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TCC_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tccFechaInicio;

	@Column(name = "TCC_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tccFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TCC_VIGENTE", nullable = false, length = 1)
	private String tccVigente;

	@JoinColumn(name = "TPC_CODIGO", referencedColumnName = "TPC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipParCamCon pedTipParCamCon;

	@JoinColumn(name = "CAC_CODIGO", referencedColumnName = "CAC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedCampoConocimiento pedCampoConocimiento;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTpcCamCon", fetch = FetchType.LAZY)
	private Collection<PedCampoArchivo> pedCampoArchivoCollection;

	public PedTpcCamCon() {
	}

	public PedTpcCamCon(Long tccCodigo) {
		this.tccCodigo = tccCodigo;
	}

	public PedTpcCamCon(Long tccCodigo, Integer tpcOrden, String tpcTieneAnexo, Date tccFechaInicio,
			String tccVigente) {
		this.tccCodigo = tccCodigo;
		this.tpcOrden = tpcOrden;
		this.tpcTieneAnexo = tpcTieneAnexo;
		this.tccFechaInicio = tccFechaInicio;
		this.tccVigente = tccVigente;
	}

	public Long getTccCodigo() {
		return this.tccCodigo;
	}

	public void setTccCodigo(Long tccCodigo) {
		this.tccCodigo = tccCodigo;
	}

	public Integer getTpcOrden() {
		return this.tpcOrden;
	}

	public void setTpcOrden(Integer tpcOrden) {
		this.tpcOrden = tpcOrden;
	}

	public String getTpcTieneAnexo() {
		return this.tpcTieneAnexo;
	}

	public void setTpcTieneAnexo(String tpcTieneAnexo) {
		this.tpcTieneAnexo = tpcTieneAnexo;
	}

	public String getTccDescripcionTexto() {
		return this.tccDescripcionTexto;
	}

	public void setTccDescripcionTexto(String tccDescripcionTexto) {
		this.tccDescripcionTexto = tccDescripcionTexto;
	}

	public BigDecimal getTccDescripcionNumero() {
		return this.tccDescripcionNumero;
	}

	public void setTccDescripcionNumero(BigDecimal tccDescripcionNumero) {
		this.tccDescripcionNumero = tccDescripcionNumero;
	}

	public Date getTccDescripcionFecha() {
		return this.tccDescripcionFecha;
	}

	public void setTccDescripcionFecha(Date tccDescripcionFecha) {
		this.tccDescripcionFecha = tccDescripcionFecha;
	}

	public Date getTccFechaInicio() {
		return this.tccFechaInicio;
	}

	public void setTccFechaInicio(Date tccFechaInicio) {
		this.tccFechaInicio = tccFechaInicio;
	}

	public Date getTccFechaFin() {
		return this.tccFechaFin;
	}

	public void setTccFechaFin(Date tccFechaFin) {
		this.tccFechaFin = tccFechaFin;
	}

	public String getTccVigente() {
		return this.tccVigente;
	}

	public void setTccVigente(String tccVigente) {
		this.tccVigente = tccVigente;
	}

	public PedTipParCamCon getPedTipParCamCon() {
		return this.pedTipParCamCon;
	}

	public void setPedTipParCamCon(PedTipParCamCon pedTipParCamCon) {
		this.pedTipParCamCon = pedTipParCamCon;
	}

	public PedCampoConocimiento getPedCampoConocimiento() {
		return this.pedCampoConocimiento;
	}

	public void setPedCampoConocimiento(PedCampoConocimiento pedCampoConocimiento) {
		this.pedCampoConocimiento = pedCampoConocimiento;
	}

	public Collection<PedCampoArchivo> getPedCampoArchivoCollection() {
		return this.pedCampoArchivoCollection;
	}

	public void setPedCampoArchivoCollection(Collection<PedCampoArchivo> pedCampoArchivoCollection) {
		this.pedCampoArchivoCollection = pedCampoArchivoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTpcCamCon)) {
			return false;
		}
		PedTpcCamCon other = (PedTpcCamCon) object;
		if ((this.tccCodigo == null && other.tccCodigo != null)
				|| (this.tccCodigo != null && !this.tccCodigo.equals(other.tccCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tccCodigo != null) ? this.tccCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTpcCamCon[ tccCodigo=" + this.tccCodigo + " ]";
	}

}
