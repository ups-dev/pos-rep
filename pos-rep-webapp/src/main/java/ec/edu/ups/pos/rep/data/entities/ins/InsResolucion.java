package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_RESOLUCION", schema = "INS")
public class InsResolucion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "RES_CODIGO", nullable = false)
	private Long resCodigo;

	@Column(name = "RES_NUM_RESOLUCION", length = 40)
	private String resNumResolucion;

	@Column(name = "RES_EMITIDO_POR", length = 200)
	private String resEmitidoPor;

	@Column(name = "RES_FECHA_EMICION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date resFechaEmicion;

	@Column(name = "RES_APELLIDOS", nullable = false, length = 50)
	private String resApellidos;

	@Column(name = "RES_NOMBRES", nullable = false, length = 50)
	private String resNombres;

	@Column(name = "RES_RUC", nullable = false, length = 20)
	private String resRuc;

	@Column(name = "RES_GENERO", nullable = false, length = 20)
	private String resGenero;

	@Column(name = "ALU_CODIGO", nullable = false)
	private Long aluCodigo;

	@Column(name = "RES_OBSERVACIONES", length = 4000)
	private String resObservaciones;

	@OneToMany(mappedBy = "insResolucion", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	public InsResolucion() {
	}

	public InsResolucion(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public Long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public String getResNumResolucion() {
		return this.resNumResolucion;
	}

	public void setResNumResolucion(String resNumResolucion) {
		this.resNumResolucion = resNumResolucion;
	}

	public String getResEmitidoPor() {
		return this.resEmitidoPor;
	}

	public void setResEmitidoPor(String resEmitidoPor) {
		this.resEmitidoPor = resEmitidoPor;
	}

	public Date getResFechaEmicion() {
		return this.resFechaEmicion;
	}

	public void setResFechaEmicion(Date resFechaEmicion) {
		this.resFechaEmicion = resFechaEmicion;
	}

	public String getResObservaciones() {
		return this.resObservaciones;
	}

	public void setResObservaciones(String resObservaciones) {
		this.resObservaciones = resObservaciones;
	}

	public String getResApellidos() {
		return this.resApellidos;
	}

	public void setResApellidos(String resApellidos) {
		this.resApellidos = resApellidos;
	}

	public String getResNombres() {
		return this.resNombres;
	}

	public void setResNombres(String resNombres) {
		this.resNombres = resNombres;
	}

	public String getResRuc() {
		return this.resRuc;
	}

	public void setResRuc(String resRuc) {
		this.resRuc = resRuc;
	}

	public Long getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public Collection<InsAlumno> getInsAlumnoCollection() {
		return this.insAlumnoCollection;
	}

	public String getResGenero() {
		return this.resGenero;
	}

	public void setResGenero(String resGenero) {
		this.resGenero = resGenero;
	}

	public void setInsAlumnoCollection(Collection<InsAlumno> insAlumnoCollection) {
		this.insAlumnoCollection = insAlumnoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsResolucion)) {
			return false;
		}
		InsResolucion other = (InsResolucion) object;
		if ((this.resCodigo == null && other.resCodigo != null)
				|| (this.resCodigo != null && !this.resCodigo.equals(other.resCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.resCodigo != null) ? this.resCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsResolucion[ resCodigo=" + this.resCodigo + " ]";
	}

}
