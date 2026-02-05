package ec.edu.ups.pos.rep.data.entities.ins;

import javax.persistence.Basic;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_ALUMNO_RED_SOCIAL", schema = "INS",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "ALU_CODIGO", "RES_CODIGO" }) })
@SequenceGenerator(name = "INS_ALU_RED_SOCIAL_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsAlumnoRedSocial extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_ALU_RED_SOCIAL_SQ")
	@NotNull
	@Column(name = "ARS_CODIGO", nullable = false)
	private Long arsCodigo;

	@Size(max = 200)
	@Column(name = "ARS_DESCRIPCION", length = 200)
	private String arsDescripcion;

	@JoinColumn(name = "ALU_CODIGO", referencedColumnName = "ALU_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsAlumno insAlumno;

	@JoinColumn(name = "RES_CODIGO", referencedColumnName = "RES_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsRedSocial insRedSocial;

	public InsAlumnoRedSocial() {
	}

	public InsAlumnoRedSocial(Long arsCodigo) {
		this.arsCodigo = arsCodigo;
	}

	public InsAlumnoRedSocial(Long arsCodigo, String arsDescripcion) {
		this.arsCodigo = arsCodigo;
		this.arsDescripcion = arsDescripcion;
	}

	public Long getArsCodigo() {
		return this.arsCodigo;
	}

	public void setArsCodigo(Long arsCodigo) {
		this.arsCodigo = arsCodigo;
	}

	// public String getArsDatosActualizados() {
	// return arsDatosActualizados;
	// }
	//
	// public void setArsDatosActualizados(String arsDatosActualizados) {
	// this.arsDatosActualizados = arsDatosActualizados;
	// }

	public String getArsDescripcion() {
		return this.arsDescripcion;
	}

	public void setArsDescripcion(String arsDescripcion) {
		this.arsDescripcion = arsDescripcion;
	}

	public InsAlumno getInsAlumno() {
		return this.insAlumno;
	}

	public void setInsAlumno(InsAlumno insAlumno) {
		this.insAlumno = insAlumno;
	}

	public InsRedSocial getInsRedSocial() {
		return this.insRedSocial;
	}

	public void setInsRedSocial(InsRedSocial insRedSocial) {
		this.insRedSocial = insRedSocial;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsAlumnoRedSocial)) {
			return false;
		}
		InsAlumnoRedSocial other = (InsAlumnoRedSocial) object;
		if ((this.arsCodigo == null && other.arsCodigo != null)
				|| (this.arsCodigo != null && !this.arsCodigo.equals(other.arsCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.arsCodigo != null) ? this.arsCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsAlumnoRedSocial[ arsCodigo=" + this.arsCodigo + " ]";
	}

}
