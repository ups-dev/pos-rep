package ec.edu.ups.pos.rep.data.entities.ped;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "PED_COM_INF_EMP", schema = "PED")
public class PedComInfEmp extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CIE_CODIGO", nullable = false)
	private Long cieCodigo;

	@Column(name = "CIE_ORDEN")
	private Integer cieOrden;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "CIE_TIENE_ANEXO", nullable = false, length = 1)
	private String cieTieneAnexo;

	@Size(max = 100)
	@Column(name = "CIE_DESCRIPCION_TEXTO", length = 100)
	private String cieDescripcionTexto;

	@Column(name = "CIE_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal cieDescripcionNumero;

	@Column(name = "CIE_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cieDescripcionFecha;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CIE_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cieFechaInicio;

	@Column(name = "CIE_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cieFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "CIE_VIGENTE", nullable = false, length = 1)
	private String cieVigente;

	@OneToMany(mappedBy = "pedComInfEmp", fetch = FetchType.LAZY)
	private Collection<PedComInfArc> pedComInfArcCollection;

	@JoinColumn(name = "TCI_CODIGO", referencedColumnName = "TCI_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipComInfPro pedTipComInfPro;

	@JoinColumn(name = "EMP_CODIGO", referencedColumnName = "EMP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedEstModProEdu pedEstModProEdu;

	public PedComInfEmp() {
	}

	public PedComInfEmp(Long cieCodigo) {
		this.cieCodigo = cieCodigo;
	}

	public PedComInfEmp(Long cieCodigo, String cieTieneAnexo, Date cieFechaInicio, String cieVigente) {
		this.cieCodigo = cieCodigo;
		this.cieTieneAnexo = cieTieneAnexo;
		this.cieFechaInicio = cieFechaInicio;
		this.cieVigente = cieVigente;
	}

	public Long getCieCodigo() {
		return this.cieCodigo;
	}

	public void setCieCodigo(Long cieCodigo) {
		this.cieCodigo = cieCodigo;
	}

	public Integer getCieOrden() {
		return this.cieOrden;
	}

	public void setCieOrden(Integer cieOrden) {
		this.cieOrden = cieOrden;
	}

	public String getCieTieneAnexo() {
		return this.cieTieneAnexo;
	}

	public void setCieTieneAnexo(String cieTieneAnexo) {
		this.cieTieneAnexo = cieTieneAnexo;
	}

	public String getCieDescripcionTexto() {
		return this.cieDescripcionTexto;
	}

	public void setCieDescripcionTexto(String cieDescripcionTexto) {
		this.cieDescripcionTexto = cieDescripcionTexto;
	}

	public BigDecimal getCieDescripcionNumero() {
		return this.cieDescripcionNumero;
	}

	public void setCieDescripcionNumero(BigDecimal cieDescripcionNumero) {
		this.cieDescripcionNumero = cieDescripcionNumero;
	}

	public Date getCieDescripcionFecha() {
		return this.cieDescripcionFecha;
	}

	public void setCieDescripcionFecha(Date cieDescripcionFecha) {
		this.cieDescripcionFecha = cieDescripcionFecha;
	}

	public Date getCieFechaInicio() {
		return this.cieFechaInicio;
	}

	public void setCieFechaInicio(Date cieFechaInicio) {
		this.cieFechaInicio = cieFechaInicio;
	}

	public Date getCieFechaFin() {
		return this.cieFechaFin;
	}

	public void setCieFechaFin(Date cieFechaFin) {
		this.cieFechaFin = cieFechaFin;
	}

	public String getCieVigente() {
		return this.cieVigente;
	}

	public void setCieVigente(String cieVigente) {
		this.cieVigente = cieVigente;
	}

	public Collection<PedComInfArc> getPedComInfArcCollection() {
		return this.pedComInfArcCollection;
	}

	public void setPedComInfArcCollection(Collection<PedComInfArc> pedComInfArcCollection) {
		this.pedComInfArcCollection = pedComInfArcCollection;
	}

	public PedTipComInfPro getPedTipComInfPro() {
		return this.pedTipComInfPro;
	}

	public void setPedTipComInfPro(PedTipComInfPro pedTipComInfPro) {
		this.pedTipComInfPro = pedTipComInfPro;
	}

	public PedEstModProEdu getPedEstModProEdu() {
		return this.pedEstModProEdu;
	}

	public void setPedEstModProEdu(PedEstModProEdu pedEstModProEdu) {
		this.pedEstModProEdu = pedEstModProEdu;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedComInfEmp)) {
			return false;
		}
		PedComInfEmp other = (PedComInfEmp) object;
		if ((this.cieCodigo == null && other.cieCodigo != null)
				|| (this.cieCodigo != null && !this.cieCodigo.equals(other.cieCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cieCodigo != null) ? this.cieCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedComInfEmp[ cieCodigo=" + this.cieCodigo + " ]";
	}

}
