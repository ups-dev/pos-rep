/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.data.entities.sigac;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description.
 *
 * @author DQUISI .
 */
@Entity
@Table(name = "CLIENTE_LOCAL", catalog = "", schema = "SIGAC",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "CLLC_RUC" }) })
@XmlRootElement
@SequenceGenerator(name = "SNA_CLLC_CDG_SEC", initialValue = 1, allocationSize = 1, catalog = "", schema = "SNA")

public class ClienteLocal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SNA_CLLC_CDG_SEC")
	@Column(name = "CLLC_CDG", nullable = false)
	private Long cllcCdg;

	@Basic(optional = false)
	@Size(min = 1, max = 60)
	@Column(name = "CLLC_NMB", nullable = false, length = 60)
	private String cllcNmb;

	@Basic(optional = false)
	@Column(name = "CLLC_RUT", nullable = false)
	private long cllcRut;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 1)
	@Column(name = "CLLC_RUT_DV", length = 1)
	private String cllcRutDv;

	@Size(max = 60)
	@Column(name = "CLLC_CALLE", length = 60)
	private String cllcCalle;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 12)
	@Column(name = "CLLC_NMR", length = 12)
	private String cllcNmr;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 6)
	@Column(name = "CMNS_CDG", length = 6)
	private String cmnsCdg;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 6)
	@Column(name = "CDDS_CDG", length = 6)
	private String cddsCdg;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 6)
	@Column(name = "RGNS_CDG", length = 6)
	private String rgnsCdg;

	@Size(max = 13)
	@Column(name = "CLLC_FONO", length = 13)
	private String cllcFono;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 13)
	@Column(name = "CLLC_FAX", length = 13)
	private String cllcFax;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 30)
	@Column(name = "CLLC_CONTACTO", length = 30)
	private String cllcContacto;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "ZOAC_CDG")
	private Short zoacCdg;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 2)
	@Column(name = "CLLC_RUTA", length = 2)
	private String cllcRuta;

	@Size(max = 2)
	@Column(name = "GCLL_CDG", length = 2)
	private String gcllCdg;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 2)
	@Column(name = "CNVT_CDG", length = 2)
	private String cnvtCdg;

	@Basic(optional = false, fetch = FetchType.LAZY)
	@Size(min = 1, max = 2)
	@Column(name = "TPCL_CDG", nullable = false, length = 2)
	private String tpclCdg;

	@Basic(optional = false, fetch = FetchType.LAZY)
	@Column(name = "CLLC_FCH_INGRESO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date cllcFchIngreso;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 30)
	@Column(name = "CLLC_HRA_CONSULTA", length = 30)
	private String cllcHraConsulta;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 30)
	@Column(name = "CLLC_LUG_PAGO", length = 30)
	private String cllcLugPago;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 30)
	@Column(name = "CLLC_HRA_PAGO", length = 30)
	private String cllcHraPago;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 30)
	@Column(name = "CLLC_CND_PAGO", length = 30)
	private String cllcCndPago;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 200)
	@Column(name = "CLLC_OBS", length = 200)
	private String cllcObs;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CLLC_PLAZO_PAGO")
	private Short cllcPlazoPago;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "SEQ_LPAR_CDG")
	private Integer seqLparCdg;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CLLC_CDG_REF")
	private Integer cllcCdgRef;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "VNDR_CDG")
	private Integer vndrCdg;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 3)
	@Column(name = "NCTB_CDG_NIVEL_1", length = 3)
	private String nctbCdgNivel1;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 13)
	@Column(name = "CLLC_FONO2", length = 13)
	private String cllcFono2;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 13)
	@Column(name = "CLLC_CELULAR", length = 13)
	private String cllcCelular;

	@Size(max = 50)
	@Column(name = "CLLC_EMAIL", length = 50)
	private String cllcEmail;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 50)
	@Column(name = "CLLC_WEB", length = 50)
	private String cllcWeb;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 300)
	@Column(name = "CLLC_OBSERVACIONES", length = 300)
	private String cllcObservaciones;

	@Size(max = 50)
	@Column(name = "CLLC_PERS_CONTACTO", length = 50)
	private String cllcPersContacto;

	@Size(min = 1, max = 16)
	@Column(name = "CLLC_RUC", nullable = false, length = 16)
	private String cllcRuc;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 20)
	@Column(name = "CLLC_TIPO_CONTRIB", length = 20)
	private String cllcTipoContrib;

	@Size(max = 1)
	@Column(name = "CLLC_ESTADO", length = 1)
	private String cllcEstado;

	@Size(max = 1)
	@Column(name = "CLLC_TPO_DOCUMENTO", length = 1)
	private String cllcTpoDocumento;

	@JoinColumn(name = "SCVN_CDG", referencedColumnName = "SCVN_CDG", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private SectorXZonal sectorXZonal;

	/*
	 * @OneToOne(optional = false, mappedBy = "clienteLocal", cascade =
	 * CascadeType.REFRESH, fetch = FetchType.LAZY) private InsAlumno insAlumno;
	 */

	public ClienteLocal() {
	}

	public ClienteLocal(Long cllcCdg) {
		this.cllcCdg = cllcCdg;
	}

	public ClienteLocal(Long cllcCdg, String cllcNmb, long cllcRut, String tpclCdg, Date cllcFchIngreso,
			String cllcRuc) {
		this.cllcCdg = cllcCdg;
		this.cllcNmb = cllcNmb;
		this.cllcRut = cllcRut;
		this.tpclCdg = tpclCdg;
		this.cllcFchIngreso = cllcFchIngreso;
		this.cllcRuc = cllcRuc;
	}

	public Long getCllcCdg() {
		return this.cllcCdg;
	}

	public void setCllcCdg(Long cllcCdg) {
		this.cllcCdg = cllcCdg;
	}

	public String getCllcNmb() {
		return this.cllcNmb;
	}

	public void setCllcNmb(String cllcNmb) {
		this.cllcNmb = cllcNmb;
	}

	public long getCllcRut() {
		return this.cllcRut;
	}

	public void setCllcRut(long cllcRut) {
		this.cllcRut = cllcRut;
	}

	public String getCllcRutDv() {
		return this.cllcRutDv;
	}

	public void setCllcRutDv(String cllcRutDv) {
		this.cllcRutDv = cllcRutDv;
	}

	public String getCllcCalle() {
		return this.cllcCalle;
	}

	public void setCllcCalle(String cllcCalle) {
		this.cllcCalle = cllcCalle;
	}

	public String getCllcNmr() {
		return this.cllcNmr;
	}

	public void setCllcNmr(String cllcNmr) {
		this.cllcNmr = cllcNmr;
	}

	public String getCmnsCdg() {
		return this.cmnsCdg;
	}

	public void setCmnsCdg(String cmnsCdg) {
		this.cmnsCdg = cmnsCdg;
	}

	public String getCddsCdg() {
		return this.cddsCdg;
	}

	public void setCddsCdg(String cddsCdg) {
		this.cddsCdg = cddsCdg;
	}

	public String getRgnsCdg() {
		return this.rgnsCdg;
	}

	public void setRgnsCdg(String rgnsCdg) {
		this.rgnsCdg = rgnsCdg;
	}

	public String getCllcFono() {
		return this.cllcFono;
	}

	public void setCllcFono(String cllcFono) {
		this.cllcFono = cllcFono;
	}

	public String getCllcFax() {
		return this.cllcFax;
	}

	public void setCllcFax(String cllcFax) {
		this.cllcFax = cllcFax;
	}

	public String getCllcContacto() {
		return this.cllcContacto;
	}

	public void setCllcContacto(String cllcContacto) {
		this.cllcContacto = cllcContacto;
	}

	public Short getZoacCdg() {
		return this.zoacCdg;
	}

	public void setZoacCdg(Short zoacCdg) {
		this.zoacCdg = zoacCdg;
	}

	public String getCllcRuta() {
		return this.cllcRuta;
	}

	public void setCllcRuta(String cllcRuta) {
		this.cllcRuta = cllcRuta;
	}

	public String getGcllCdg() {
		return this.gcllCdg;
	}

	public void setGcllCdg(String gcllCdg) {
		this.gcllCdg = gcllCdg;
	}

	public String getCnvtCdg() {
		return this.cnvtCdg;
	}

	public void setCnvtCdg(String cnvtCdg) {
		this.cnvtCdg = cnvtCdg;
	}

	public String getTpclCdg() {
		return this.tpclCdg;
	}

	public void setTpclCdg(String tpclCdg) {
		this.tpclCdg = tpclCdg;
	}

	public Date getCllcFchIngreso() {
		return this.cllcFchIngreso;
	}

	public void setCllcFchIngreso(Date cllcFchIngreso) {
		this.cllcFchIngreso = cllcFchIngreso;
	}

	public String getCllcHraConsulta() {
		return this.cllcHraConsulta;
	}

	public void setCllcHraConsulta(String cllcHraConsulta) {
		this.cllcHraConsulta = cllcHraConsulta;
	}

	public String getCllcLugPago() {
		return this.cllcLugPago;
	}

	public void setCllcLugPago(String cllcLugPago) {
		this.cllcLugPago = cllcLugPago;
	}

	public String getCllcHraPago() {
		return this.cllcHraPago;
	}

	public void setCllcHraPago(String cllcHraPago) {
		this.cllcHraPago = cllcHraPago;
	}

	public String getCllcCndPago() {
		return this.cllcCndPago;
	}

	public void setCllcCndPago(String cllcCndPago) {
		this.cllcCndPago = cllcCndPago;
	}

	public String getCllcObs() {
		return this.cllcObs;
	}

	public void setCllcObs(String cllcObs) {
		this.cllcObs = cllcObs;
	}

	public Short getCllcPlazoPago() {
		return this.cllcPlazoPago;
	}

	public void setCllcPlazoPago(Short cllcPlazoPago) {
		this.cllcPlazoPago = cllcPlazoPago;
	}

	public Integer getSeqLparCdg() {
		return this.seqLparCdg;
	}

	public void setSeqLparCdg(Integer seqLparCdg) {
		this.seqLparCdg = seqLparCdg;
	}

	public Integer getCllcCdgRef() {
		return this.cllcCdgRef;
	}

	public void setCllcCdgRef(Integer cllcCdgRef) {
		this.cllcCdgRef = cllcCdgRef;
	}

	public Integer getVndrCdg() {
		return this.vndrCdg;
	}

	public void setVndrCdg(Integer vndrCdg) {
		this.vndrCdg = vndrCdg;
	}

	public String getNctbCdgNivel1() {
		return this.nctbCdgNivel1;
	}

	public void setNctbCdgNivel1(String nctbCdgNivel1) {
		this.nctbCdgNivel1 = nctbCdgNivel1;
	}

	public String getCllcFono2() {
		return this.cllcFono2;
	}

	public void setCllcFono2(String cllcFono2) {
		this.cllcFono2 = cllcFono2;
	}

	public String getCllcCelular() {
		return this.cllcCelular;
	}

	public void setCllcCelular(String cllcCelular) {
		this.cllcCelular = cllcCelular;
	}

	public String getCllcEmail() {
		return this.cllcEmail;
	}

	public void setCllcEmail(String cllcEmail) {
		this.cllcEmail = cllcEmail;
	}

	public String getCllcWeb() {
		return this.cllcWeb;
	}

	public void setCllcWeb(String cllcWeb) {
		this.cllcWeb = cllcWeb;
	}

	public String getCllcObservaciones() {
		return this.cllcObservaciones;
	}

	public void setCllcObservaciones(String cllcObservaciones) {
		this.cllcObservaciones = cllcObservaciones;
	}

	public String getCllcPersContacto() {
		return this.cllcPersContacto;
	}

	public void setCllcPersContacto(String cllcPersContacto) {
		this.cllcPersContacto = cllcPersContacto;
	}

	public String getCllcRuc() {
		return this.cllcRuc;
	}

	public void setCllcRuc(String cllcRuc) {
		this.cllcRuc = cllcRuc;
	}

	public String getCllcTipoContrib() {
		return this.cllcTipoContrib;
	}

	public void setCllcTipoContrib(String cllcTipoContrib) {
		this.cllcTipoContrib = cllcTipoContrib;
	}

	public String getCllcEstado() {
		return this.cllcEstado;
	}

	public void setCllcEstado(String cllcEstado) {
		this.cllcEstado = cllcEstado;
	}

	public String getCllcTpoDocumento() {
		return this.cllcTpoDocumento;
	}

	public void setCllcTpoDocumento(String cllcTpoDocumento) {
		this.cllcTpoDocumento = cllcTpoDocumento;
	}

	public SectorXZonal getSectorXZonal() {
		return this.sectorXZonal;
	}

	public void setSectorXZonal(SectorXZonal sectorXZonal) {
		this.sectorXZonal = sectorXZonal;
	}

	/*
	 * public InsAlumno getInsAlumno() { return insAlumno; }
	 *
	 * public void setInsAlumno(InsAlumno insAlumno) { this.insAlumno = insAlumno; }
	 */

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ClienteLocal)) {
			return false;
		}
		ClienteLocal other = (ClienteLocal) object;
		if ((this.cllcCdg == null && other.cllcCdg != null)
				|| (this.cllcCdg != null && !this.cllcCdg.equals(other.cllcCdg))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.cllcCdg != null) ? this.cllcCdg.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder descripcion = new StringBuilder();
		descripcion.append(this.cllcCdg).append(" - ").append(this.cllcEmail);
		return descripcion.toString();
	}

}
