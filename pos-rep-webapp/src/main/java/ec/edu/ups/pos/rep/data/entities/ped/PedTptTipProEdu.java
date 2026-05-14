package ec.edu.ups.pos.rep.data.entities.ped;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "PED_TPT_TIP_PRO_EDU", schema = "PED")
public class PedTptTipProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TTP_CODIGO", nullable = false)
	private Long ttpCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TTP_ORDEN", nullable = false)
	private Integer ttpOrden;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TTP_TIENE_ANEXO", nullable = false, length = 1)
	private String ttpTieneAnexo;

	@Size(max = 100)
	@Column(name = "TTP_DESCRIPCION_TEXTO", length = 100)
	private String ttpDescripcionTexto;

	@Column(name = "TTP_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal ttpDescripcionNumero;

	@Column(name = "TTP_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ttpDescripcionFecha;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TTP_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ttpFechaInicio;

	@Column(name = "TTP_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ttpFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TTP_VIGENTE", nullable = false, length = 1)
	private String ttpVigente;

	@Size(max = 2)
	@Column(name = "TTP_TIPO_PERTENECE", length = 2)
	private String ttpTipoPertenece;

	@JoinColumn(name = "TPE_CODIGO", referencedColumnName = "TPE_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedTipoProyectoEducacion pedTipoProyectoEducacion;

	@JoinColumn(name = "TPT_CODIGO", referencedColumnName = "TPT_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedTipParTipPro pedTipParTipPro;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedTptTipProEdu")
	private Collection<PedTipoProyectoArchivo> pedTipoProyectoArchivoCollection;

	public PedTptTipProEdu() {
	}

	public PedTptTipProEdu(Long ttpCodigo) {
		this.ttpCodigo = ttpCodigo;
	}

	public PedTptTipProEdu(Long ttpCodigo, int ttpOrden, String ttpTieneAnexo, Date ttpFechaInicio, String ttpVigente) {
		this.ttpCodigo = ttpCodigo;
		this.ttpOrden = ttpOrden;
		this.ttpTieneAnexo = ttpTieneAnexo;
		this.ttpFechaInicio = ttpFechaInicio;
		this.ttpVigente = ttpVigente;
	}

	public Long getTtpCodigo() {
		return this.ttpCodigo;
	}

	public void setTtpCodigo(Long ttpCodigo) {
		this.ttpCodigo = ttpCodigo;
	}

	public Integer getTtpOrden() {
		return this.ttpOrden;
	}

	public void setTtpOrden(Integer ttpOrden) {
		this.ttpOrden = ttpOrden;
	}

	public String getTtpTieneAnexo() {
		return this.ttpTieneAnexo;
	}

	public void setTtpTieneAnexo(String ttpTieneAnexo) {
		this.ttpTieneAnexo = ttpTieneAnexo;
	}

	public String getTtpDescripcionTexto() {
		return this.ttpDescripcionTexto;
	}

	public void setTtpDescripcionTexto(String ttpDescripcionTexto) {
		this.ttpDescripcionTexto = ttpDescripcionTexto;
	}

	public BigDecimal getTtpDescripcionNumero() {
		return this.ttpDescripcionNumero;
	}

	public void setTtpDescripcionNumero(BigDecimal ttpDescripcionNumero) {
		this.ttpDescripcionNumero = ttpDescripcionNumero;
	}

	public Date getTtpDescripcionFecha() {
		return this.ttpDescripcionFecha;
	}

	public void setTtpDescripcionFecha(Date ttpDescripcionFecha) {
		this.ttpDescripcionFecha = ttpDescripcionFecha;
	}

	public Date getTtpFechaInicio() {
		return this.ttpFechaInicio;
	}

	public void setTtpFechaInicio(Date ttpFechaInicio) {
		this.ttpFechaInicio = ttpFechaInicio;
	}

	public Date getTtpFechaFin() {
		return this.ttpFechaFin;
	}

	public void setTtpFechaFin(Date ttpFechaFin) {
		this.ttpFechaFin = ttpFechaFin;
	}

	public String getTtpVigente() {
		return this.ttpVigente;
	}

	public void setTtpVigente(String ttpVigente) {
		this.ttpVigente = ttpVigente;
	}

	public String getTtpTipoPertenece() {
		return this.ttpTipoPertenece;
	}

	public void setTtpTipoPertenece(String ttpTipoPertenece) {
		this.ttpTipoPertenece = ttpTipoPertenece;
	}

	public PedTipoProyectoEducacion getPedTipoProyectoEducacion() {
		return this.pedTipoProyectoEducacion;
	}

	public void setPedTipoProyectoEducacion(PedTipoProyectoEducacion pedTipoProyectoEducacion) {
		this.pedTipoProyectoEducacion = pedTipoProyectoEducacion;
	}

	public PedTipParTipPro getPedTipParTipPro() {
		return this.pedTipParTipPro;
	}

	public void setPedTipParTipPro(PedTipParTipPro pedTipParTipPro) {
		this.pedTipParTipPro = pedTipParTipPro;
	}

	public Collection<PedTipoProyectoArchivo> getPedTipoProyectoArchivoCollection() {
		return this.pedTipoProyectoArchivoCollection;
	}

	public void setPedTipoProyectoArchivoCollection(
			Collection<PedTipoProyectoArchivo> pedTipoProyectoArchivoCollection) {
		this.pedTipoProyectoArchivoCollection = pedTipoProyectoArchivoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTptTipProEdu)) {
			return false;
		}
		PedTptTipProEdu other = (PedTptTipProEdu) object;
		if ((this.ttpCodigo == null && other.ttpCodigo != null)
				|| (this.ttpCodigo != null && !this.ttpCodigo.equals(other.ttpCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ttpCodigo != null) ? this.ttpCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTptTipProEdu[ ttpCodigo=" + this.ttpCodigo + " ]";
	}

}
