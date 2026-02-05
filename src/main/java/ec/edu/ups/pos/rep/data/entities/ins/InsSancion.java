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

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_SANCION", schema = "INS")
public class InsSancion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "SAN_CODIGO", nullable = false)
	private Long sanCodigo;

	@Column(name = "SAN_OBSERVACION", length = 200)
	private String sanObservacion;

	@Column(name = "SAN_VIGENTE", length = 1)
	private String sanVigente;

	@Column(name = "SAN_FECHA_INICIO")
	@Temporal(TemporalType.DATE)
	private Date sanFechaInicio;

	@Column(name = "SAN_FECHA_FIN")
	@Temporal(TemporalType.DATE)
	private Date sanFechaFin;

	@JoinColumn(name = "ALU_CODIGO", referencedColumnName = "ALU_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsAlumno insAlumno;

	@JoinColumn(name = "OII_CODIGO", referencedColumnName = "OII_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private InsOfertaInscripcionInicial insOfertaInscripcionInicial;

	@JoinColumn(name = "TSA_CODIGO", referencedColumnName = "TSA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsTipoSancion insTipoSancion;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CLLC_CDG", nullable = false)
	private Long cllcCdg;

	@JoinColumn(name = "INE_CODIGO_LEG", referencedColumnName = "INE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInstitucionEducativa insInstiEducativa;

	public InsSancion() {
	}

	public InsSancion(Long sanCodigo) {
		this.sanCodigo = sanCodigo;
	}

	public Long getSanCodigo() {
		return this.sanCodigo;
	}

	public void setSanCodigo(Long sanCodigo) {
		this.sanCodigo = sanCodigo;
	}

	public String getSanObservacion() {
		return this.sanObservacion;
	}

	public void setSanObservacion(String sanObservacion) {
		this.sanObservacion = sanObservacion;
	}

	public String getSanVigente() {
		return this.sanVigente;
	}

	public void setSanVigente(String sanVigente) {
		this.sanVigente = sanVigente;
	}

	public Date getSanFechaInicio() {
		return this.sanFechaInicio;
	}

	public void setSanFechaInicio(Date sanFechaInicio) {
		this.sanFechaInicio = sanFechaInicio;
	}

	public Date getSanFechaFin() {
		return this.sanFechaFin;
	}

	public void setSanFechaFin(Date sanFechaFin) {
		this.sanFechaFin = sanFechaFin;
	}

	public InsAlumno getInsAlumno() {
		return this.insAlumno;
	}

	public void setInsAlumno(InsAlumno insAlumno) {
		this.insAlumno = insAlumno;
	}

	public InsOfertaInscripcionInicial getInsOfertaInscripcionInicial() {
		return this.insOfertaInscripcionInicial;
	}

	public void setInsOfertaInscripcionInicial(InsOfertaInscripcionInicial insOfertaInscripcionInicial) {
		this.insOfertaInscripcionInicial = insOfertaInscripcionInicial;
	}

	public InsTipoSancion getInsTipoSancion() {
		return this.insTipoSancion;
	}

	public void setInsTipoSancion(InsTipoSancion insTipoSancion) {
		this.insTipoSancion = insTipoSancion;
	}

	public Long getCllcCdg() {
		return this.cllcCdg;
	}

	public void setCllcCdg(Long cllcCdg) {
		this.cllcCdg = cllcCdg;
	}

	public InsInstitucionEducativa getInsInstiEducativa() {
		return this.insInstiEducativa;
	}

	public void setInsInstiEducativa(InsInstitucionEducativa insInstiEducativa) {
		this.insInstiEducativa = insInstiEducativa;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsSancion)) {
			return false;
		}
		InsSancion other = (InsSancion) object;
		if ((this.sanCodigo == null && other.sanCodigo != null)
				|| (this.sanCodigo != null && !this.sanCodigo.equals(other.sanCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.sanCodigo != null) ? this.sanCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsSancion{" + "sanCodigo=" + this.sanCodigo + ", sanObservacion='" + this.sanObservacion + '\''
				+ ", sanVigente='" + this.sanVigente + '\'' + ", sanFechaInicio=" + this.sanFechaInicio
				+ ", sanFechaFin=" + this.sanFechaFin + ", insAlumno=" + this.insAlumno
				+ ", insOfertaInscripcionInicial=" + this.insOfertaInscripcionInicial + ", insTipoSancion="
				+ this.insTipoSancion + ", cllcCdg=" + this.cllcCdg + '}';
	}

}
