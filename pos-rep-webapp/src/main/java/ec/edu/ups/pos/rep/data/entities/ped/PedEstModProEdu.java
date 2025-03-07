package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_EST_MOD_PRO_EDU", schema = "PED",
		uniqueConstraints = @UniqueConstraint(columnNames = { "MPE_CODIGO", "EST_CODIGO" }))
public class PedEstModProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "EMP_CODIGO", nullable = false, updatable = false)
	private Long empCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Size(max = 1)
	@Column(name = "EMP_TIPO_PROYECTO", length = 1)
	private String empTipoProyecto;

	@Column(name = "EMP_CARRERA_REDISENIO")
	private Long empCarreraRedisenio;

	@Size(max = 1)
	@Column(name = "MPC_ACTIVADO_LEG", length = 1)
	private String mpcActivadoLeg;

	@Size(max = 1)
	@Column(name = "MPC_VIGENCIA_LEG", length = 1)
	private String mpcVigenciaLeg;

	@Size(max = 1)
	@Column(name = "MPC_UNIFICAR_HORAS_LEG", length = 1)
	private String mpcUnificarHorasLeg;

	@Column(name = "MPC_ESCUELA_CONESUP_LEG")
	private Short mpcEscuelaConesupLeg;

	@Column(name = "MPC_CARRERA_CONESUP_LEG")
	private Short mpcCarreraConesupLeg;

	@Size(max = 1)
	@Column(name = "EMP_ACTIVADO_PARACADEMICO", length = 1)
	private String empActivadoParacademico;

	@Size(max = 1)
	@Column(name = "EMP_VIGENCIA_PARACADEMICO", length = 1)
	private String empVigenciaParacademico;

	@JoinColumn(name = "MPE_CODIGO", referencedColumnName = "MPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedModProEdu pedModProEdu;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedEstModProEdu", fetch = FetchType.LAZY)
	private Collection<PedComInfEmp> pedComInfEmpCollection;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "pedEstModProEdu", fetch = FetchType.LAZY)
	private Collection<PedHistorialEstado> pedHistorialEstadoCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedEstModProEdu", fetch = FetchType.LAZY)
	private Collection<PedParametroMalla> pedParametroMallaCollection;

	public PedEstModProEdu() {
	}

	public PedEstModProEdu(Long empCodigo) {
		this.empCodigo = empCodigo;
	}

	public Long getEmpCodigo() {
		return this.empCodigo;
	}

	public void setEmpCodigo(Long empCodigo) {
		this.empCodigo = empCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public PedModProEdu getPedModProEdu() {
		return this.pedModProEdu;
	}

	public void setPedModProEdu(PedModProEdu pedModProEdu) {
		this.pedModProEdu = pedModProEdu;
	}

	public String getEmpTipoProyecto() {
		return this.empTipoProyecto;
	}

	public void setEmpTipoProyecto(String empTipoProyecto) {
		this.empTipoProyecto = empTipoProyecto;
	}

	public Collection<PedComInfEmp> getPedComInfEmpCollection() {
		return this.pedComInfEmpCollection;
	}

	public void setPedComInfEmpCollection(Collection<PedComInfEmp> pedComInfEmpCollection) {
		this.pedComInfEmpCollection = pedComInfEmpCollection;
	}

	public Long getEmpCarreraRedisenio() {
		return this.empCarreraRedisenio;
	}

	public void setEmpCarreraRedisenio(Long empCarreraRedisenio) {
		this.empCarreraRedisenio = empCarreraRedisenio;
	}

	public String getMpcActivadoLeg() {
		return this.mpcActivadoLeg;
	}

	public void setMpcActivadoLeg(String mpcActivadoLeg) {
		this.mpcActivadoLeg = mpcActivadoLeg;
	}

	public String getMpcVigenciaLeg() {
		return this.mpcVigenciaLeg;
	}

	public void setMpcVigenciaLeg(String mpcVigenciaLeg) {
		this.mpcVigenciaLeg = mpcVigenciaLeg;
	}

	public String getMpcUnificarHorasLeg() {
		return this.mpcUnificarHorasLeg;
	}

	public void setMpcUnificarHorasLeg(String mpcUnificarHorasLeg) {
		this.mpcUnificarHorasLeg = mpcUnificarHorasLeg;
	}

	public Short getMpcEscuelaConesupLeg() {
		return this.mpcEscuelaConesupLeg;
	}

	public void setMpcEscuelaConesupLeg(Short mpcEscuelaConesupLeg) {
		this.mpcEscuelaConesupLeg = mpcEscuelaConesupLeg;
	}

	public Short getMpcCarreraConesupLeg() {
		return this.mpcCarreraConesupLeg;
	}

	public void setMpcCarreraConesupLeg(Short mpcCarreraConesupLeg) {
		this.mpcCarreraConesupLeg = mpcCarreraConesupLeg;
	}

	public String getEmpActivadoParacademico() {
		return this.empActivadoParacademico;
	}

	public void setEmpActivadoParacademico(String empActivadoParacademico) {
		this.empActivadoParacademico = empActivadoParacademico;
	}

	public String getEmpVigenciaParacademico() {
		return this.empVigenciaParacademico;
	}

	public void setEmpVigenciaParacademico(String empVigenciaParacademico) {
		this.empVigenciaParacademico = empVigenciaParacademico;
	}

	public Collection<PedHistorialEstado> getPedHistorialEstadoCollection() {
		return this.pedHistorialEstadoCollection;
	}

	public void setPedHistorialEstadoCollection(Collection<PedHistorialEstado> pedHistorialEstadoCollection) {
		this.pedHistorialEstadoCollection = pedHistorialEstadoCollection;
	}

	public Collection<PedParametroMalla> getPedParametroMallaCollection() {
		return this.pedParametroMallaCollection;
	}

	public void setPedParametroMallaCollection(Collection<PedParametroMalla> pedParametroMallaCollection) {
		this.pedParametroMallaCollection = pedParametroMallaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedEstModProEdu)) {
			return false;
		}
		PedEstModProEdu other = (PedEstModProEdu) object;
		if ((this.empCodigo == null && other.empCodigo != null)
				|| (this.empCodigo != null && !this.empCodigo.equals(other.empCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.empCodigo != null) ? this.empCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedEstModProEdu[ empCodigo=" + this.empCodigo + " ]";
	}

}
