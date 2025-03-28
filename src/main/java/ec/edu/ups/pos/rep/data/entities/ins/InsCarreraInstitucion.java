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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_CARRERA_INSTITUCION", schema = "INS")
@SequenceGenerator(name = "INS_CARRERA_INSTITUCION_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsCarreraInstitucion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_CARRERA_INSTITUCION_SQ")
	@Basic(optional = false)
	@NotNull
	@Column(name = "CAI_CODIGO", nullable = false)
	private Long caiCodigo;

	@Basic(optional = true)
	@Column(name = "CAI_CODIGO_LEG", nullable = true)
	private long caiCodigoLeg;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "CAI_DESCRIPCION", length = 100)
	private String caiDescripcion;

	@JoinColumn(name = "INE_CODIGO", referencedColumnName = "INE_CODIGO")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInstitucionEducativa insInstitucionEducativa;

	public InsCarreraInstitucion() {
	}

	public InsCarreraInstitucion(Long cinCodigo) {
		this.caiCodigoLeg = cinCodigo;
	}

	public InsCarreraInstitucion(Long cinCodigo, String caiDescripcion) {
		this.caiCodigoLeg = cinCodigo;
		// this.caiCodigo = caiCodigo;
		this.caiDescripcion = caiDescripcion;
	}

	public long getCaiCodigo() {
		return this.caiCodigo;
	}

	public void setCaiCodigo(long caiCodigo) {
		this.caiCodigo = caiCodigo;
	}

	public String getCaiDescripcion() {
		return this.caiDescripcion;
	}

	public void setCaiDescripcion(String caiDescripcion) {
		this.caiDescripcion = caiDescripcion;
	}

	public Long getCaiCodigoLeg() {
		return this.caiCodigoLeg;
	}

	public void setCaiCodigoLeg(Long cinCodigo) {
		this.caiCodigoLeg = cinCodigo;
	}

	public InsInstitucionEducativa getInsInstitucionEducativa() {
		return this.insInstitucionEducativa;
	}

	public void setInsInstitucionEducativa(InsInstitucionEducativa insInstitucionEducativa) {
		this.insInstitucionEducativa = insInstitucionEducativa;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsCarreraInstitucion)) {
			return false;
		}
		InsCarreraInstitucion other = (InsCarreraInstitucion) object;
		if ((this.caiCodigo == null && other.caiCodigo != null)
				|| (this.caiCodigo != null && !this.caiCodigo.equals(other.caiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.caiCodigo != null) ? this.caiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsCarreraInstitucion[ caiCodigo = " + this.caiCodigo + " ]";
	}

}
