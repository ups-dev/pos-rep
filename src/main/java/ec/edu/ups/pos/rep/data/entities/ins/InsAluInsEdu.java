package ec.edu.ups.pos.rep.data.entities.ins;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_ALU_INS_EDU", schema = "INS")
@SequenceGenerator(name = "INS_ALU_INS_EDU_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsAluInsEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_ALU_INS_EDU_SQ")
	@NotNull
	@Column(name = "AIE_CODIGO", nullable = false)
	private Long aieCodigo;

	@Column(name = "AIE_FECHA_GRADUACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date aieFechaGraduacion;

	@Column(name = "AIE_CALIFICACION_GRADUACION")
	private BigDecimal aieCalificacionGraduacion;

	@Column(name = "AIE_CALIFICACION_SOBRE")
	private Integer aieCalificacionSobre;

	@Size(max = 100)
	@Column(name = "AIE_NRO_ACUERDO_MINISTERIAL", length = 100)
	private String aieNroAcuerdoMinisterial;

	@Size(max = 200)
	@Column(name = "AIE_DES_TITULO_RECONOCIDO", length = 200)
	private String aieDesTituloReconocido;

	@Column(name = "AIE_FECHA_ACUERDO_MINISTERIAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date aieFechaAcuerdoMinisterial;

	@JoinColumn(name = "INE_CODIGO", referencedColumnName = "INE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInstitucionEducativa insInstitucionEducativa;

	@JoinColumn(name = "ALU_CODIGO", referencedColumnName = "ALU_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsAlumno insAlumno;

	@Basic(optional = false)
	@Column(name = "TIT_CODIGO")
	private Long titCodigo;

	// @Size(max = 250)
	@Column(name = "AIE_INSTITUCION_OTRO", length = 250)
	private String aieInstitucionOtro;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "AIE_INSTITUCION_CONFIRMADO", length = 1)
	private String aieInstitucionConfirmado;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "AIE_VIGENTE", nullable = false, length = 1)
	private String aieVigente;

	@Column(name = "PER_CODIGO")
	private Long perCodigo;

	public InsAluInsEdu() {
	}

	public InsAluInsEdu(Long aieCodigo) {
		this.aieCodigo = aieCodigo;
	}

	public Long getAieCodigo() {
		return this.aieCodigo;
	}

	public void setAieCodigo(Long aieCodigo) {
		this.aieCodigo = aieCodigo;
	}

	/**
	 * Devuelve el código que hace referencia a PedTitulo.
	 * @return el código que hace referencia a PedTitulo
	 */
	public Long getTitCodigo() {
		return this.titCodigo;
	}

	/**
	 * Asigna el código que hace referencia a PedTitulo.
	 * @param titCodigo el código que hace referencia a PedTitulo
	 */
	public void setTitCodigo(Long titCodigo) {
		this.titCodigo = titCodigo;
	}

	public Date getAieFechaGraduacion() {
		return this.aieFechaGraduacion;
	}

	public void setAieFechaGraduacion(Date aieFechaGraduacion) {
		this.aieFechaGraduacion = aieFechaGraduacion;
	}

	public BigDecimal getAieCalificacionGraduacion() {
		return this.aieCalificacionGraduacion;
	}

	public void setAieCalificacionGraduacion(BigDecimal aieCalificacionGraduacion) {
		this.aieCalificacionGraduacion = aieCalificacionGraduacion;
	}

	public Integer getAieCalificacionSobre() {
		return this.aieCalificacionSobre;
	}

	public void setAieCalificacionSobre(Integer aieCalificacionSobre) {
		this.aieCalificacionSobre = aieCalificacionSobre;
	}

	public String getAieNroAcuerdoMinisterial() {
		return this.aieNroAcuerdoMinisterial;
	}

	public void setAieNroAcuerdoMinisterial(String aieNroAcuerdoMinisterial) {
		this.aieNroAcuerdoMinisterial = aieNroAcuerdoMinisterial;
	}

	public String getAieDesTituloReconocido() {
		return this.aieDesTituloReconocido;
	}

	public void setAieDesTituloReconocido(String aieDesTituloReconocido) {
		this.aieDesTituloReconocido = aieDesTituloReconocido;
	}

	public Date getAieFechaAcuerdoMinisterial() {
		return this.aieFechaAcuerdoMinisterial;
	}

	public void setAieFechaAcuerdoMinisterial(Date aieFechaAcuerdoMinisterial) {
		this.aieFechaAcuerdoMinisterial = aieFechaAcuerdoMinisterial;
	}

	public InsInstitucionEducativa getInsInstitucionEducativa() {
		return this.insInstitucionEducativa;
	}

	public void setInsInstitucionEducativa(InsInstitucionEducativa insInstitucionEducativa) {
		this.insInstitucionEducativa = insInstitucionEducativa;
	}

	public InsAlumno getInsAlumno() {
		return this.insAlumno;
	}

	public void setInsAlumno(InsAlumno insAlumno) {
		this.insAlumno = insAlumno;
	}

	public String getAieInstitucionOtro() {
		return this.aieInstitucionOtro;
	}

	public void setAieInstitucionOtro(String aieInstitucionOtro) {
		this.aieInstitucionOtro = aieInstitucionOtro;
	}

	public String getAieInstitucionConfirmado() {
		return this.aieInstitucionConfirmado;
	}

	public void setAieInstitucionConfirmado(String aieInstitucionConfirmado) {
		this.aieInstitucionConfirmado = aieInstitucionConfirmado;
	}

	public String getAieVigente() {
		return this.aieVigente;
	}

	public void setAieVigente(String aieVigente) {
		this.aieVigente = aieVigente;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsAluInsEdu)) {
			return false;
		}
		InsAluInsEdu other = (InsAluInsEdu) object;
		if ((this.aieCodigo == null && other.aieCodigo != null)
				|| (this.aieCodigo != null && !this.aieCodigo.equals(other.aieCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.aieCodigo != null) ? this.aieCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsAluInsEdu{" + "aieCodigo=" + this.aieCodigo + ", aieFechaGraduacion=" + this.aieFechaGraduacion
				+ ", aieCalificacionGraduacion=" + this.aieCalificacionGraduacion + ", aieCalificacionSobre="
				+ this.aieCalificacionSobre + ", aieNroAcuerdoMinisterial='" + this.aieNroAcuerdoMinisterial + '\''
				+ ", aieDesTituloReconocido='" + this.aieDesTituloReconocido + '\'' + ", aieFechaAcuerdoMinisterial="
				+ this.aieFechaAcuerdoMinisterial + ", insInstitucionEducativa=" + this.insInstitucionEducativa
				+ ", insAlumno=" + this.insAlumno + ", titCodigo=" + this.titCodigo + ", aieInstitucionOtro='"
				+ this.aieInstitucionOtro + '\'' + ", aieInstitucionConfirmado='" + this.aieInstitucionConfirmado + '\''
				+ ", aieVigente='" + this.aieVigente + '\'' + ", perCodigo=" + this.perCodigo + '}';
	}

}
