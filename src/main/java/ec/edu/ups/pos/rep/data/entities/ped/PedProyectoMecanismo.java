package ec.edu.ups.pos.rep.data.entities.ped;

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
@Table(name = "PED_PROYECTO_MECANISMO", catalog = "", schema = "PED")
public class PedProyectoMecanismo extends EntitySuperclass {

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRM_CODIGO", nullable = false, updatable = false)
	private Long prmCodigo;

	@Basic(optional = false)
	@Column(name = "PRM_FECHA_INICIO_VIGENCIA", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date prmFechaInicioVigencia;

	@Basic(optional = true)
	@Column(name = "PRM_FECHA_FIN_VIGENCIA", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date prmFechaFinVigencia;

	@JoinColumn(name = "MET_CODIGO", referencedColumnName = "MET_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedMecanismoTitulacion pedMecanismoTitulacion;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false)
	private PedProyectoEducacion pedProyectoEduacion;

	public PedProyectoMecanismo() {
	}

	public PedProyectoMecanismo(Long prmCodigo) {
		this.prmCodigo = prmCodigo;
	}

	public PedProyectoMecanismo(Long prmCodigo, Date prmFechaInicioVigencia, Date prmFechaFinVigencia,
			PedMecanismoTitulacion pedMecanismoTitulacion, PedProyectoEducacion pedProyectoEduacion) {
		this.prmCodigo = prmCodigo;
		this.prmFechaInicioVigencia = prmFechaInicioVigencia;
		this.prmFechaFinVigencia = prmFechaFinVigencia;
		this.pedMecanismoTitulacion = pedMecanismoTitulacion;
		this.pedProyectoEduacion = pedProyectoEduacion;
	}

	public Long getPrmCodigo() {
		return this.prmCodigo;
	}

	public void setPrmCodigo(Long prmCodigo) {
		this.prmCodigo = prmCodigo;
	}

	public Date getPrmFechaInicioVigencia() {
		return this.prmFechaInicioVigencia;
	}

	public void setPrmFechaInicioVigencia(Date prmFechaInicioVigencia) {
		this.prmFechaInicioVigencia = prmFechaInicioVigencia;
	}

	public Date getPrmFechaFinVigencia() {
		return this.prmFechaFinVigencia;
	}

	public void setPrmFechaFinVigencia(Date prmFechaFinVigencia) {
		this.prmFechaFinVigencia = prmFechaFinVigencia;
	}

	public PedMecanismoTitulacion getPedMecanismoTitulacion() {
		return this.pedMecanismoTitulacion;
	}

	public void setPedMecanismoTitulacion(PedMecanismoTitulacion pedMecanismoTitulacion) {
		this.pedMecanismoTitulacion = pedMecanismoTitulacion;
	}

	public PedProyectoEducacion getPedProyectoEduacion() {
		return this.pedProyectoEduacion;
	}

	public void setPedProyectoEduacion(PedProyectoEducacion pedProyectoEduacion) {
		this.pedProyectoEduacion = pedProyectoEduacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedProyectoEducacion)) {
			return false;
		}
		PedProyectoMecanismo other = (PedProyectoMecanismo) object;
		return (this.prmCodigo != null || other.prmCodigo == null)
				&& (this.prmCodigo == null || this.prmCodigo.equals(other.prmCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.prmCodigo != null) ? this.prmCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "PedProyectoMecanismo{" + "prmCodigo=" + this.prmCodigo + '}';
	}

}
