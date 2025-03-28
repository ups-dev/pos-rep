package ec.edu.ups.pos.rep.data.entities.ofe;

import java.math.BigInteger;
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
@Table(name = "OFE_DISTRIBUTIVO", catalog = "", schema = "OFE")
public class OfeDistributivo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DIS_CODIGO", nullable = false)
	private Long disCodigo;

	@Column(name = "PER_CODIGO")
	private Long perCodigo;

	@Column(name = "CAM_CODIGO")
	private Long camCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DIS_HORAS", nullable = false)
	private Integer disHoras;

	@Size(max = 500)
	@Column(name = "DIS_OBSERVACIONES", length = 500)
	private String disObservaciones;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "DIS_OFERTA_INTERNET", nullable = false, length = 1)
	private String disOfertaInternet;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "DIS_ACTIVO", nullable = false, length = 1)
	private String disActivo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DIS_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date disFechaInicio;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DIS_FECHA_FIN", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date disFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "DIS_ACUMULADAS", nullable = false, length = 1)
	private String disAcumuladas;

	@Column(name = "DIS_INTERNET")
	private BigInteger disInternet;

	@Column(name = "PEL_CODIGO")
	private Long pelCodigo;

	@Column(name = "EST_CODIGO")
	private Long estCodigo;

	@Size(max = 1)
	@Column(name = "DIS_TIPO", length = 1)
	private String disTipo;

	@Column(name = "DID_CODIGO_LEG")
	private Long didCodigoLeg;

	@Size(max = 1)
	@Column(name = "DID_ESTADO_LEG", length = 1)
	private String didEstadoLeg;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ofeDistributivo", fetch = FetchType.LAZY)
	private Collection<OfeHorario> ofeHorarioCollection;

	@JoinColumn(name = "ACT_CODIGO", referencedColumnName = "ACT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OfeActividad ofeActividad;

	@JoinColumn(name = "GRU_CODIGO", referencedColumnName = "GRU_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OfeGrupo ofeGrupo;

	@JoinColumn(name = "TDD_CODIGO", referencedColumnName = "TDD_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OfeTipoDocenteDistributivo ofeTipoDocenteDistributivo;

	public OfeDistributivo() {
	}

	public OfeDistributivo(Long disCodigo) {
		this.disCodigo = disCodigo;
	}

	public OfeDistributivo(Long disCodigo, Integer disHoras, String disOfertaInternet, String disActivo,
			Date disFechaInicio, Date disFechaFin, String disAcumuladas) {
		this.disCodigo = disCodigo;
		this.disHoras = disHoras;
		this.disOfertaInternet = disOfertaInternet;
		this.disActivo = disActivo;
		this.disFechaInicio = disFechaInicio;
		this.disFechaFin = disFechaFin;
		this.disAcumuladas = disAcumuladas;
	}

	public Long getDisCodigo() {
		return this.disCodigo;
	}

	public void setDisCodigo(Long disCodigo) {
		this.disCodigo = disCodigo;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Long getCamCodigo() {
		return this.camCodigo;
	}

	public void setCamCodigo(Long camCodigo) {
		this.camCodigo = camCodigo;
	}

	public Integer getDisHoras() {
		return this.disHoras;
	}

	public void setDisHoras(Integer disHoras) {
		this.disHoras = disHoras;
	}

	public String getDisObservaciones() {
		return this.disObservaciones;
	}

	public void setDisObservaciones(String disObservaciones) {
		this.disObservaciones = disObservaciones;
	}

	public String getDisOfertaInternet() {
		return this.disOfertaInternet;
	}

	public void setDisOfertaInternet(String disOfertaInternet) {
		this.disOfertaInternet = disOfertaInternet;
	}

	public String getDisActivo() {
		return this.disActivo;
	}

	public void setDisActivo(String disActivo) {
		this.disActivo = disActivo;
	}

	public Date getDisFechaInicio() {
		return this.disFechaInicio;
	}

	public void setDisFechaInicio(Date disFechaInicio) {
		this.disFechaInicio = disFechaInicio;
	}

	public Date getDisFechaFin() {
		return this.disFechaFin;
	}

	public void setDisFechaFin(Date disFechaFin) {
		this.disFechaFin = disFechaFin;
	}

	public String getDisAcumuladas() {
		return this.disAcumuladas;
	}

	public void setDisAcumuladas(String disAcumuladas) {
		this.disAcumuladas = disAcumuladas;
	}

	public BigInteger getDisInternet() {
		return this.disInternet;
	}

	public void setDisInternet(BigInteger disInternet) {
		this.disInternet = disInternet;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getDisTipo() {
		return this.disTipo;
	}

	public void setDisTipo(String disTipo) {
		this.disTipo = disTipo;
	}

	public Long getDidCodigoLeg() {
		return this.didCodigoLeg;
	}

	public void setDidCodigoLeg(Long didCodigoLeg) {
		this.didCodigoLeg = didCodigoLeg;
	}

	public String getDidEstadoLeg() {
		return this.didEstadoLeg;
	}

	public void setDidEstadoLeg(String didEstadoLeg) {
		this.didEstadoLeg = didEstadoLeg;
	}

	public Collection<OfeHorario> getOfeHorarioCollection() {
		return this.ofeHorarioCollection;
	}

	public void setOfeHorarioCollection(Collection<OfeHorario> ofeHorarioCollection) {
		this.ofeHorarioCollection = ofeHorarioCollection;
	}

	public OfeActividad getOfeActividad() {
		return this.ofeActividad;
	}

	public void setOfeActividad(OfeActividad ofeActividad) {
		this.ofeActividad = ofeActividad;
	}

	public OfeGrupo getOfeGrupo() {
		return this.ofeGrupo;
	}

	public void setOfeGrupo(OfeGrupo ofeGrupo) {
		this.ofeGrupo = ofeGrupo;
	}

	public OfeTipoDocenteDistributivo getOfeTipoDocenteDistributivo() {
		return this.ofeTipoDocenteDistributivo;
	}

	public void setOfeTipoDocenteDistributivo(OfeTipoDocenteDistributivo ofeTipoDocenteDistributivo) {
		this.ofeTipoDocenteDistributivo = ofeTipoDocenteDistributivo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OfeDistributivo)) {
			return false;
		}
		OfeDistributivo other = (OfeDistributivo) object;
		if ((this.disCodigo == null && other.disCodigo != null)
				|| (this.disCodigo != null && !this.disCodigo.equals(other.disCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.disCodigo != null) ? this.disCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "OfeDistributivo[ disCodigo=" + this.disCodigo + " ]";
	}

}
