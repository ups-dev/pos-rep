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
@Table(name = "PED_TPT_TIP_TIT", schema = "PED")
public class PedTptTipTit extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TTT_CODIGO", nullable = false)
	private Long tttCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TTT_ORDEN", nullable = false)
	private Integer tttOrden;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TTT_TIENE_ANEXO", nullable = false, length = 1)
	private String tttTieneAnexo;

	@Size(max = 100)
	@Column(name = "TTT_DESCRIPCION_TEXTO", length = 100)
	private String tttDescripcionTexto;

	@Column(name = "TTT_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal tttDescripcionNumero;

	@Column(name = "TTT_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tttDescripcionFecha;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TTT_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tttFechaInicio;

	@Column(name = "TTT_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tttFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TTT_VIGENTE", nullable = false, length = 1)
	private String tttVigente;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTptTipTit", fetch = FetchType.LAZY)
	private Collection<PedTipoTitulacionArchivo> pedTipoTitulacionArchivoCollection;

	@JoinColumn(name = "TIT_CODIGO", referencedColumnName = "TIT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoTitulacion pedTipoTitulacion;

	@JoinColumn(name = "TPT_CODIGO", referencedColumnName = "TPT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipParTipTit pedTipParTipTit;

	public PedTptTipTit() {
	}

	public PedTptTipTit(Long tttCodigo) {
		this.tttCodigo = tttCodigo;
	}

	public PedTptTipTit(Long tttCodigo, Integer tttOrden, String tttTieneAnexo, Date tttFechaInicio,
			String tttVigente) {
		this.tttCodigo = tttCodigo;
		this.tttOrden = tttOrden;
		this.tttTieneAnexo = tttTieneAnexo;
		this.tttFechaInicio = tttFechaInicio;
		this.tttVigente = tttVigente;
	}

	public Long getTttCodigo() {
		return this.tttCodigo;
	}

	public void setTttCodigo(Long tttCodigo) {
		this.tttCodigo = tttCodigo;
	}

	public Integer getTttOrden() {
		return this.tttOrden;
	}

	public void setTttOrden(Integer tttOrden) {
		this.tttOrden = tttOrden;
	}

	public String getTttTieneAnexo() {
		return this.tttTieneAnexo;
	}

	public void setTttTieneAnexo(String tttTieneAnexo) {
		this.tttTieneAnexo = tttTieneAnexo;
	}

	public String getTttDescripcionTexto() {
		return this.tttDescripcionTexto;
	}

	public void setTttDescripcionTexto(String tttDescripcionTexto) {
		this.tttDescripcionTexto = tttDescripcionTexto;
	}

	public BigDecimal getTttDescripcionNumero() {
		return this.tttDescripcionNumero;
	}

	public void setTttDescripcionNumero(BigDecimal tttDescripcionNumero) {
		this.tttDescripcionNumero = tttDescripcionNumero;
	}

	public Date getTttDescripcionFecha() {
		return this.tttDescripcionFecha;
	}

	public void setTttDescripcionFecha(Date tttDescripcionFecha) {
		this.tttDescripcionFecha = tttDescripcionFecha;
	}

	public Date getTttFechaInicio() {
		return this.tttFechaInicio;
	}

	public void setTttFechaInicio(Date tttFechaInicio) {
		this.tttFechaInicio = tttFechaInicio;
	}

	public Date getTttFechaFin() {
		return this.tttFechaFin;
	}

	public void setTttFechaFin(Date tttFechaFin) {
		this.tttFechaFin = tttFechaFin;
	}

	public String getTttVigente() {
		return this.tttVigente;
	}

	public void setTttVigente(String tttVigente) {
		this.tttVigente = tttVigente;
	}

	public Collection<PedTipoTitulacionArchivo> getPedTipoTitulacionArchivoCollection() {
		return this.pedTipoTitulacionArchivoCollection;
	}

	public void setPedTipoTitulacionArchivoCollection(
			Collection<PedTipoTitulacionArchivo> pedTipoTitulacionArchivoCollection) {
		this.pedTipoTitulacionArchivoCollection = pedTipoTitulacionArchivoCollection;
	}

	public PedTipoTitulacion getPedTipoTitulacion() {
		return this.pedTipoTitulacion;
	}

	public void setPedTipoTitulacion(PedTipoTitulacion pedTipoTitulacion) {
		this.pedTipoTitulacion = pedTipoTitulacion;
	}

	public PedTipParTipTit getPedTipParTipTit() {
		return this.pedTipParTipTit;
	}

	public void setPedTipParTipTit(PedTipParTipTit pedTipParTipTit) {
		this.pedTipParTipTit = pedTipParTipTit;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTptTipTit)) {
			return false;
		}
		PedTptTipTit other = (PedTptTipTit) object;
		if ((this.tttCodigo == null && other.tttCodigo != null)
				|| (this.tttCodigo != null && !this.tttCodigo.equals(other.tttCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tttCodigo != null) ? this.tttCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTptTipTit[ tttCodigo=" + this.tttCodigo + " ]";
	}

}
