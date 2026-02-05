package ec.edu.ups.pos.rep.data.entities.ped;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_PARAMETRO_MALLA", schema = "PED")
public class PedParametroMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PAM_CODIGO", nullable = false)
	private Long pamCodigo;

	@Size(max = 200)
	@Column(name = "PAM_DESCRIPCION_TEXTO", length = 200)
	private String pamDescripcionTexto;

	@Column(name = "PAM_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal pamDescripcionNumero;

	@Column(name = "PAM_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pamDescripcionFecha;

	@Lob
	@Column(name = "PAM_DESCRIPCION_BLOB")
	private Serializable pamDescripcionBlob;

	@Lob
	@Column(name = "PAM_DESCRIPCION_TEXTO_HTML")
	private String pamDescripcionTextoHtml;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PAM_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date pamFechaInicio;

	@Column(name = "PAM_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date pamFechaFin;

	@Size(max = 100)
	@Column(name = "PAM_NOMBRE_ADJUNTO", length = 100)
	private String pamNombreAdjunto;

	@Size(max = 10)
	@Column(name = "PAM_EXTENSION_ADJUNTO", length = 10)
	private String pamExtensionAdjunto;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PAM_VIGENTE", nullable = false, length = 1)
	private String pamVigente;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PAM_ITEM", nullable = false)
	private Integer pamItem;

	@Size(max = 1024)
	@Column(name = "PAM_DESCRIPCION_URL_DSPACE", length = 1024)
	private String pamDescripcionUrlDspace;

	@Size(max = 500)
	@Column(name = "UUID_BITSTREAM", length = 500)
	private String uuidBitstream;

	@Size(max = 50)
	@Column(name = "PAM_TIPO", length = 50)
	private String pamTipo;

	@JoinColumn(name = "EMP_CODIGO", referencedColumnName = "EMP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedEstModProEdu pedEstModProEdu;

	@JoinColumn(name = "TPM_CODIGO", referencedColumnName = "TPM_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoParametroMalla pedTipoParametroMalla;

	public PedParametroMalla() {
	}

	public PedParametroMalla(Long pamCodigo) {
		this.pamCodigo = pamCodigo;
	}

	public PedParametroMalla(Long pamCodigo, String pamDescripcionTexto, BigDecimal pamDescripcionNumero,
			Date pamDescripcionFecha, Serializable pamDescripcionBlob, String pamDescripcionTextoHtml,
			Date pamFechaInicio, Date pamFechaFin, String pamNombreAdjunto, String pamExtensionAdjunto,
			String pamVigente, Integer pamItem, PedEstModProEdu pedEstModProEdu,
			PedTipoParametroMalla pedTipoParametroMalla) {
		this.pamCodigo = pamCodigo;
		this.pamDescripcionTexto = pamDescripcionTexto;
		this.pamDescripcionNumero = pamDescripcionNumero;
		this.pamDescripcionFecha = pamDescripcionFecha;
		this.pamDescripcionBlob = pamDescripcionBlob;
		this.pamDescripcionTextoHtml = pamDescripcionTextoHtml;
		this.pamFechaInicio = pamFechaInicio;
		this.pamFechaFin = pamFechaFin;
		this.pamNombreAdjunto = pamNombreAdjunto;
		this.pamExtensionAdjunto = pamExtensionAdjunto;
		this.pamVigente = pamVigente;
		this.pamItem = pamItem;
		this.pedEstModProEdu = pedEstModProEdu;
		this.pedTipoParametroMalla = pedTipoParametroMalla;
	}

	public Long getPamCodigo() {
		return this.pamCodigo;
	}

	public void setPamCodigo(Long pamCodigo) {
		this.pamCodigo = pamCodigo;
	}

	public String getPamDescripcionTexto() {
		return this.pamDescripcionTexto;
	}

	public void setPamDescripcionTexto(String pamDescripcionTexto) {
		this.pamDescripcionTexto = pamDescripcionTexto;
	}

	public BigDecimal getPamDescripcionNumero() {
		return this.pamDescripcionNumero;
	}

	public void setPamDescripcionNumero(BigDecimal pamDescripcionNumero) {
		this.pamDescripcionNumero = pamDescripcionNumero;
	}

	public Date getPamDescripcionFecha() {
		return this.pamDescripcionFecha;
	}

	public void setPamDescripcionFecha(Date pamDescripcionFecha) {
		this.pamDescripcionFecha = pamDescripcionFecha;
	}

	public Serializable getPamDescripcionBlob() {
		return this.pamDescripcionBlob;
	}

	public void setPamDescripcionBlob(Serializable pamDescripcionBlob) {
		this.pamDescripcionBlob = pamDescripcionBlob;
	}

	public String getPamDescripcionTextoHtml() {
		return this.pamDescripcionTextoHtml;
	}

	public void setPamDescripcionTextoHtml(String pamDescripcionTextoHtml) {
		this.pamDescripcionTextoHtml = pamDescripcionTextoHtml;
	}

	public Date getPamFechaInicio() {
		return this.pamFechaInicio;
	}

	public void setPamFechaInicio(Date pamFechaInicio) {
		this.pamFechaInicio = pamFechaInicio;
	}

	public Date getPamFechaFin() {
		return this.pamFechaFin;
	}

	public void setPamFechaFin(Date pamFechaFin) {
		this.pamFechaFin = pamFechaFin;
	}

	public String getPamNombreAdjunto() {
		return this.pamNombreAdjunto;
	}

	public void setPamNombreAdjunto(String pamNombreAdjunto) {
		this.pamNombreAdjunto = pamNombreAdjunto;
	}

	public String getPamExtensionAdjunto() {
		return this.pamExtensionAdjunto;
	}

	public void setPamExtensionAdjunto(String pamExtensionAdjunto) {
		this.pamExtensionAdjunto = pamExtensionAdjunto;
	}

	public String getPamVigente() {
		return this.pamVigente;
	}

	public void setPamVigente(String pamVigente) {
		this.pamVigente = pamVigente;
	}

	public Integer getPamItem() {
		return this.pamItem;
	}

	public void setPamItem(Integer pamItem) {
		this.pamItem = pamItem;
	}

	public String getPamDescripcionUrlDspace() {
		return this.pamDescripcionUrlDspace;
	}

	public void setPamDescripcionUrlDspace(String pamDescripcionUrlDspace) {
		this.pamDescripcionUrlDspace = pamDescripcionUrlDspace;
	}

	public String getUuidBitstream() {
		return this.uuidBitstream;
	}

	public void setUuidBitstream(String uuidBitstream) {
		this.uuidBitstream = uuidBitstream;
	}

	public String getPamTipo() {
		return this.pamTipo;
	}

	public void setPamTipo(String pamTipo) {
		this.pamTipo = pamTipo;
	}

	public PedEstModProEdu getPedEstModProEdu() {
		return this.pedEstModProEdu;
	}

	public void setPedEstModProEdu(PedEstModProEdu pedEstModProEdu) {
		this.pedEstModProEdu = pedEstModProEdu;
	}

	public PedTipoParametroMalla getPedTipoParametroMalla() {
		return this.pedTipoParametroMalla;
	}

	public void setPedTipoParametroMalla(PedTipoParametroMalla pedTipoParametroMalla) {
		this.pedTipoParametroMalla = pedTipoParametroMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedParametroMalla)) {
			return false;
		}
		PedParametroMalla other = (PedParametroMalla) object;
		if ((this.pamCodigo == null && other.pamCodigo != null)
				|| (this.pamCodigo != null && !this.pamCodigo.equals(other.pamCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.pamCodigo != null) ? this.pamCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedParametroMalla[ pamCodigo=" + this.pamCodigo + " ]";
	}

}
