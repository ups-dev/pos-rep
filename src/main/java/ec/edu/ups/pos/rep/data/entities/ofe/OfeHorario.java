package ec.edu.ups.pos.rep.data.entities.ofe;

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

/**
 * Description.
 *
 * @author ups .
 */
@Entity
@Table(name = "OFE_HORARIO", catalog = "", schema = "OFE", uniqueConstraints = { @UniqueConstraint(
		columnNames = { "DIS_CODIGO", "HOR_HORA_INICIO", "HOR_DIA", "HOR_FECHA_INICIO", "HOR_FECHA_FIN" }) })
public class OfeHorario extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "HOR_CODIGO", nullable = false)
	private Long horCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "HOR_HORA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horHoraInicio;

	@Basic(optional = false)
	@NotNull
	@Column(name = "HOR_HORA_FIN", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horHoraFin;

	@Basic(optional = false)
	@NotNull
	@Column(name = "HOR_DIA", nullable = false)
	private Integer horDia;

	@Basic(optional = false)
	@NotNull
	@Column(name = "HOR_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horFechaInicio;

	@Basic(optional = false)
	@NotNull
	@Column(name = "HOR_FECHA_FIN", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horFechaFin;

	@Size(max = 1)
	@Column(name = "HOR_TIPO", length = 1)
	private String horTipo;

	@Size(max = 1)
	@Column(name = "HOR_ACUMULA", length = 1)
	private String horAcumula;

	@Column(name = "DIA_CODIGO")
	private Long diaCodigo;

	@Column(name = "HDD_CODIGO_LEG")
	private Long hddCodigoLeg;

	@JoinColumn(name = "DIS_CODIGO", referencedColumnName = "DIS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OfeDistributivo ofeDistributivo;

	@JoinColumn(name = "EEP_CODIGO", referencedColumnName = "EEP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OfeEspFisEstPer ofeEspFisEstPer;

	public OfeHorario() {
	}

	public OfeHorario(Long horCodigo) {
		this.horCodigo = horCodigo;
	}

	public OfeHorario(Long horCodigo, Date horHoraInicio, Date horHoraFin, Integer horDia, Date horFechaInicio,
			Date horFechaFin) {
		this.horCodigo = horCodigo;
		this.horHoraInicio = horHoraInicio;
		this.horHoraFin = horHoraFin;
		this.horDia = horDia;
		this.horFechaInicio = horFechaInicio;
		this.horFechaFin = horFechaFin;
	}

	public Long getHorCodigo() {
		return this.horCodigo;
	}

	public void setHorCodigo(Long horCodigo) {
		this.horCodigo = horCodigo;
	}

	public Date getHorHoraInicio() {
		return this.horHoraInicio;
	}

	public void setHorHoraInicio(Date horHoraInicio) {
		this.horHoraInicio = horHoraInicio;
	}

	public Date getHorHoraFin() {
		return this.horHoraFin;
	}

	public void setHorHoraFin(Date horHoraFin) {
		this.horHoraFin = horHoraFin;
	}

	public Integer getHorDia() {
		return this.horDia;
	}

	public void setHorDia(Integer horDia) {
		this.horDia = horDia;
	}

	public Date getHorFechaInicio() {
		return this.horFechaInicio;
	}

	public void setHorFechaInicio(Date horFechaInicio) {
		this.horFechaInicio = horFechaInicio;
	}

	public Date getHorFechaFin() {
		return this.horFechaFin;
	}

	public void setHorFechaFin(Date horFechaFin) {
		this.horFechaFin = horFechaFin;
	}

	public String getHorTipo() {
		return this.horTipo;
	}

	public void setHorTipo(String horTipo) {
		this.horTipo = horTipo;
	}

	public String getHorAcumula() {
		return this.horAcumula;
	}

	public void setHorAcumula(String horAcumula) {
		this.horAcumula = horAcumula;
	}

	public Long getDiaCodigo() {
		return this.diaCodigo;
	}

	public void setDiaCodigo(Long diaCodigo) {
		this.diaCodigo = diaCodigo;
	}

	public Long getHddCodigoLeg() {
		return this.hddCodigoLeg;
	}

	public void setHddCodigoLeg(Long hddCodigoLeg) {
		this.hddCodigoLeg = hddCodigoLeg;
	}

	public OfeDistributivo getOfeDistributivo() {
		return this.ofeDistributivo;
	}

	public void setOfeDistributivo(OfeDistributivo ofeDistributivo) {
		this.ofeDistributivo = ofeDistributivo;
	}

	public OfeEspFisEstPer getOfeEspFisEstPer() {
		return this.ofeEspFisEstPer;
	}

	public void setOfeEspFisEstPer(OfeEspFisEstPer ofeEspFisEstPer) {
		this.ofeEspFisEstPer = ofeEspFisEstPer;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OfeHorario)) {
			return false;
		}
		OfeHorario other = (OfeHorario) object;
		if ((this.horCodigo == null && other.horCodigo != null)
				|| (this.horCodigo != null && !this.horCodigo.equals(other.horCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.horCodigo != null) ? this.horCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "OfeHorario[ horCodigo=" + this.horCodigo + " ]";
	}

}
