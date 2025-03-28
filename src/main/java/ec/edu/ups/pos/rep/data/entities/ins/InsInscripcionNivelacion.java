package ec.edu.ups.pos.rep.data.entities.ins;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_INSCRIPCION_NIVELACION", schema = "INS")
public class InsInscripcionNivelacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "INN_CODIGO", nullable = false)
	private Long innCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "INN_PROMEDIO_PONDERADO", nullable = false, precision = 10, scale = 2)
	private BigDecimal innPromedioPonderado;

	@JoinColumn(name = "INS_CODIGO", referencedColumnName = "INS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInscripcion insInscripcion;

	public InsInscripcionNivelacion() {
	}

	public InsInscripcionNivelacion(Long innCodigo) {
		this.innCodigo = innCodigo;
	}

	public InsInscripcionNivelacion(Long innCodigo, BigDecimal innPromedioPonderado) {
		this.innCodigo = innCodigo;
		this.innPromedioPonderado = innPromedioPonderado;
	}

	public Long getInnCodigo() {
		return this.innCodigo;
	}

	public void setInnCodigo(Long innCodigo) {
		this.innCodigo = innCodigo;
	}

	public BigDecimal getInnPromedioPonderado() {
		return this.innPromedioPonderado;
	}

	public void setInnPromedioPonderado(BigDecimal innPromedioPonderado) {
		this.innPromedioPonderado = innPromedioPonderado;
	}

	public InsInscripcion getInsInscripcion() {
		return this.insInscripcion;
	}

	public void setInsInscripcion(InsInscripcion insInscripcion) {
		this.insInscripcion = insInscripcion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsInscripcionNivelacion)) {
			return false;
		}
		InsInscripcionNivelacion other = (InsInscripcionNivelacion) object;
		if ((this.innCodigo == null && other.innCodigo != null)
				|| (this.innCodigo != null && !this.innCodigo.equals(other.innCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.innCodigo != null) ? this.innCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsInscripcionNivelacion[ innCodigo=" + this.innCodigo + " ]";
	}

}
