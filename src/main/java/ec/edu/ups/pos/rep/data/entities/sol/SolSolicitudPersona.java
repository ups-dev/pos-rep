package ec.edu.ups.pos.rep.data.entities.sol;

import java.io.Serializable;
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

@Entity
@Table(name = "SOL_SOLICITUD_PERSONA", schema = "SOL")
public class SolSolicitudPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "SOP_CODIGO")
	private Long sopCodigo;

	@Column(name = "PER_CODIGO")
	private Long perCodigo;

	@Column(name = "ALU_CODIGO")
	private Long aluCodigo;

	@JoinColumn(name = "SOL_CODIGO", referencedColumnName = "SOL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SolSolicitud solSolicitud;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "SOP_PRINCIPAL")
	private String sopPrincipal;

	@Column(name = "CLLC_CDG_MIG")
	private Long cllcCdgMig;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "AUD_ELIMINADO")
	private String audEliminado;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "AUD_ADICIONADO")
	private String audAdicionado;

	@Basic(optional = false)
	@NotNull
	@Column(name = "AUD_FECHA_ADICION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaAdicion;

	@Size(max = 50)
	@Column(name = "AUD_MODIFICADO")
	private String audModificado;

	@Column(name = "AUD_FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaModificacion;

	public SolSolicitudPersona() {
	}

	public SolSolicitudPersona(Long sopCodigo) {
		this.sopCodigo = sopCodigo;
	}

	public SolSolicitudPersona(Long sopCodigo, String sopPrincipal, String audEliminado, String audAdicionado,
			Date audFechaAdicion) {
		this.sopCodigo = sopCodigo;
		this.sopPrincipal = sopPrincipal;
		this.audEliminado = audEliminado;
		this.audAdicionado = audAdicionado;
		this.audFechaAdicion = audFechaAdicion;
	}

	public Long getSopCodigo() {
		return this.sopCodigo;
	}

	public void setSopCodigo(Long sopCodigo) {
		this.sopCodigo = sopCodigo;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Long getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public String getSopPrincipal() {
		return this.sopPrincipal;
	}

	public void setSopPrincipal(String sopPrincipal) {
		this.sopPrincipal = sopPrincipal;
	}

	public Long getCllcCdgMig() {
		return this.cllcCdgMig;
	}

	public void setCllcCdgMig(Long cllcCdgMig) {
		this.cllcCdgMig = cllcCdgMig;
	}

	public String getAudEliminado() {
		return this.audEliminado;
	}

	public void setAudEliminado(String audEliminado) {
		this.audEliminado = audEliminado;
	}

	public String getAudAdicionado() {
		return this.audAdicionado;
	}

	public void setAudAdicionado(String audAdicionado) {
		this.audAdicionado = audAdicionado;
	}

	public Date getAudFechaAdicion() {
		return this.audFechaAdicion;
	}

	public void setAudFechaAdicion(Date audFechaAdicion) {
		this.audFechaAdicion = audFechaAdicion;
	}

	public String getAudModificado() {
		return this.audModificado;
	}

	public void setAudModificado(String audModificado) {
		this.audModificado = audModificado;
	}

	public Date getAudFechaModificacion() {
		return this.audFechaModificacion;
	}

	public void setAudFechaModificacion(Date audFechaModificacion) {
		this.audFechaModificacion = audFechaModificacion;
	}

	public SolSolicitud getSolSolicitud() {
		return this.solSolicitud;
	}

	public void setSolSolicitud(SolSolicitud solSolicitud) {
		this.solSolicitud = solSolicitud;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SolSolicitudPersona)) {
			return false;
		}
		SolSolicitudPersona other = (SolSolicitudPersona) object;
		if ((this.sopCodigo == null && other.sopCodigo != null)
				|| (this.sopCodigo != null && !this.sopCodigo.equals(other.sopCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.sopCodigo != null) ? this.sopCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "ec.edu.ups.sse.data.entity.sol.SolSolicitudPersona[ sopCodigo=" + this.sopCodigo + " ]";
	}

}
