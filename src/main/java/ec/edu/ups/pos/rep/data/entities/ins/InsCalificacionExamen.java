package ec.edu.ups.pos.rep.data.entities.ins;

import java.math.BigDecimal;

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

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_CALIFICACION_EXAMEN", schema = "INS")
@SequenceGenerator(name = "INS_CALIFICACION_EXAMEN_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsCalificacionExamen extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_CALIFICACION_EXAMEN_SQ")
	@NotNull
	@Column(name = "CAE_CODIGO", nullable = false)
	private Long caeCodigo;

	@Column(name = "CAE_VALOR")
	private BigDecimal caeValor;

	@JoinColumn(name = "POE_CODIGO", referencedColumnName = "POE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsPonderacionExamen insPonderacionExamen;

	@JoinColumn(name = "EXA_CODIGO", referencedColumnName = "EXA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsExamen insExamen;

	public InsCalificacionExamen() {
	}

	public InsCalificacionExamen(Long caeCodigo) {
		this.caeCodigo = caeCodigo;
	}

	public InsCalificacionExamen(Long caeCodigo, BigDecimal caeValor, InsPonderacionExamen insPonderacionExamen,
			InsExamen insExamen) {
		this.caeCodigo = caeCodigo;
		this.caeValor = caeValor;
		this.insPonderacionExamen = insPonderacionExamen;
		this.insExamen = insExamen;
	}

	public InsPonderacionExamen getInsPonderacionExamen() {
		return this.insPonderacionExamen;
	}

	public void setInsPonderacionExamen(InsPonderacionExamen insPonderacionExamen) {
		this.insPonderacionExamen = insPonderacionExamen;
	}

	public InsExamen getInsExamen() {
		return this.insExamen;
	}

	public void setInsExamen(InsExamen insExamen) {
		this.insExamen = insExamen;
	}

	public Long getCaeCodigo() {
		return this.caeCodigo;
	}

	public void setCaeCodigo(Long caeCodigo) {
		this.caeCodigo = caeCodigo;
	}

	public BigDecimal getCaeValor() {
		return this.caeValor;
	}

	public void setCaeValor(BigDecimal caeValor) {
		this.caeValor = caeValor;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsCalificacionExamen)) {
			return false;
		}
		InsCalificacionExamen other = (InsCalificacionExamen) object;
		if ((this.caeCodigo == null && other.caeCodigo != null)
				|| (this.caeCodigo != null && !this.caeCodigo.equals(other.caeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.caeCodigo != null) ? this.caeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsCalificacionExamen[ caeCodigo=" + this.caeCodigo + " ]";
	}

}
