package ec.edu.ups.pos.rep.data.entities.org;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_DESIGNACION", schema = "ORG")
public class OrgDesignacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "DES_CODIGO", nullable = false)
	private Long desCodigo;

	@Basic(optional = false)
	@Column(name = "DES_FECHA_INICIO", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date desFechaInicio;

	@Basic(optional = false)
	@Column(name = "DES_FECHA_FIN", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date desFechaFin;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DES_TIPO", nullable = false, length = 1)
	private String desTipo;

	@Basic(optional = false)
	@Column(name = "DES_VIGENCIA", nullable = false, length = 1)
	private String desVigencia;

	@Basic(optional = false)
	@Column(name = "DES_OBSERVACION", nullable = true, length = 500)
	private String desObservacion;

	@Column(name = "PER_CODIGO")
	private Long perCodigo;

	@JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private OrgEstructura orgEstructura;

	@JoinColumn(name = "TID_CODIGO", referencedColumnName = "TID_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private OrgTipoDesignacion orgTipoDesignacion;

	@JoinColumn(name = "MOS_CODIGO", referencedColumnName = "MOS_CODIGO", nullable = true)
	@ManyToOne(optional = true)
	private OrgMotivoSalida orgMotivoSalida;

	public OrgDesignacion() {
	}

	public OrgDesignacion(Long desCodigo) {
		this.desCodigo = desCodigo;
	}

	public OrgDesignacion(Long desCodigo, String estDescripcion) {
		this.desCodigo = desCodigo;
		// this.estDescripcion = estDescripcion;
	}

	public Long getDesCodigo() {
		return this.desCodigo;
	}

	public void setDesCodigo(Long desCodigo) {
		this.desCodigo = desCodigo;
	}

	public Date getDesFechaInicio() {
		return this.desFechaInicio;
	}

	public void setDesFechaInicio(Date desFechaInicio) {
		this.desFechaInicio = desFechaInicio;
	}

	public Date getDesFechaFin() {
		return this.desFechaFin;
	}

	public void setDesFechaFin(Date desFechaFin) {
		this.desFechaFin = desFechaFin;
	}

	public String getDesTipo() {
		return this.desTipo;
	}

	public void setDesTipo(String desTipo) {
		this.desTipo = desTipo;
	}

	public String getDesVigencia() {
		return this.desVigencia;
	}

	public void setDesVigencia(String desVigencia) {
		this.desVigencia = desVigencia;
	}

	public String getDesObservacion() {
		return this.desObservacion;
	}

	public void setDesObservacion(String desObservacion) {
		this.desObservacion = desObservacion;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public OrgEstructura getOrgEstructura() {
		return this.orgEstructura;
	}

	public void setOrgEstructura(OrgEstructura orgEstructura) {
		this.orgEstructura = orgEstructura;
	}

	public OrgTipoDesignacion getOrgTipoDesignacion() {
		return this.orgTipoDesignacion;
	}

	public void setOrgTipoDesignacion(OrgTipoDesignacion orgTipoDesignacion) {
		this.orgTipoDesignacion = orgTipoDesignacion;
	}

	public OrgMotivoSalida getOrgMotivoSalida() {
		return this.orgMotivoSalida;
	}

	public void setOrgMotivoSalida(OrgMotivoSalida orgMotivoSalida) {
		this.orgMotivoSalida = orgMotivoSalida;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgDesignacion)) {
			return false;
		}
		OrgDesignacion other = (OrgDesignacion) object;
		return (this.desCodigo != null || other.desCodigo == null)
				&& (this.desCodigo == null || this.desCodigo.equals(other.desCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.desCodigo != null) ? this.desCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "desCodigo = " + this.desCodigo + ")";
	}

}
