package ec.edu.ups.pos.rep.data.entities.ins;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_EXAMEN", schema = "INS")
@SequenceGenerator(name = "INS_EXAMEN_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsExamen extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_EXAMEN_SQ")
	@NotNull
	@Column(name = "EXA_CODIGO", nullable = false)
	private Long exaCodigo;

	@Column(name = "EXA_NRO_VECES")
	private Long exaNroVeces;

	@Column(name = "EXA_NOTA_FINAL")
	private BigDecimal exaNotaFinal;

	@Size(max = 1)
	@Column(name = "EXA_APROBADO", length = 1)
	private String exaAprobado;

	@Size(max = 1)
	@Column(name = "EXA_AUTORIZADO", length = 1)
	private String exaAutorizado;

	@Size(max = 200)
	@Column(name = "EXA_AUTORIZADO_POR", length = 200)
	private String exaAutorizadoPor;

	@Column(name = "EXA_FECHA_AUTORIZADO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date exaFechaAutorizado;

	@Transient
	private Boolean exaBoolAutorizado;

	@JoinColumn(name = "REE_CODIGO", referencedColumnName = "REE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsReservaExamen insReservaExamen;

	@JoinColumn(name = "INS_CODIGO", referencedColumnName = "INS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInscripcion insInscripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insExamen", fetch = FetchType.LAZY)
	private Collection<InsCalificacionExamen> insCalificacionExamenCollection;

	public InsExamen() {
	}

	public InsExamen(Long exaCodigo) {
		this.exaCodigo = exaCodigo;
	}

	public InsReservaExamen getInsReservaExamen() {
		return this.insReservaExamen;
	}

	public void setInsReservaExamen(InsReservaExamen insReservaExamen) {
		this.insReservaExamen = insReservaExamen;
	}

	public InsInscripcion getInsInscripcion() {
		return this.insInscripcion;
	}

	public void setInsInscripcion(InsInscripcion insInscripcion) {
		this.insInscripcion = insInscripcion;
	}

	public Long getExaCodigo() {
		return this.exaCodigo;
	}

	public void setExaCodigo(Long exaCodigo) {
		this.exaCodigo = exaCodigo;
	}

	public Long getExaNroVeces() {
		return this.exaNroVeces;
	}

	public void setExaNroVeces(Long exaNroVeces) {
		this.exaNroVeces = exaNroVeces;
	}

	public BigDecimal getExaNotaFinal() {
		return this.exaNotaFinal;
	}

	public void setExaNotaFinal(BigDecimal exaNotaFinal) {
		this.exaNotaFinal = exaNotaFinal;
	}

	public String getExaAprobado() {
		return this.exaAprobado;
	}

	public void setExaAprobado(String exaAprobado) {
		this.exaAprobado = exaAprobado;
	}

	public String getExaAutorizado() {
		return this.exaAutorizado;
	}

	public void setExaAutorizado(String exaAutorizado) {
		this.exaAutorizado = exaAutorizado;
	}

	public boolean isExaBoolAutorizado() {
		if (this.exaAutorizado != null) {
			return this.exaAutorizado.equals("S");
		}
		else {
			return false;
		}
	}

	public void setExaBoolAutorizado(Boolean exaBoolAutorizado) {
		this.exaBoolAutorizado = exaBoolAutorizado;
	}

	public String getExaAutorizadoPor() {
		return this.exaAutorizadoPor;
	}

	public void setExaAutorizadoPor(String exaAutorizadoPor) {
		this.exaAutorizadoPor = exaAutorizadoPor;
	}

	public Date getExaFechaAutorizado() {
		return this.exaFechaAutorizado;
	}

	public void setExaFechaAutorizado(Date exaFechaAutorizado) {
		this.exaFechaAutorizado = exaFechaAutorizado;
	}

	public Collection<InsCalificacionExamen> getInsCalificacionExamenCollection() {
		return this.insCalificacionExamenCollection;
	}

	public void setInsCalificacionExamenCollection(Collection<InsCalificacionExamen> insCalificacionExamenCollection) {
		this.insCalificacionExamenCollection = insCalificacionExamenCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsExamen)) {
			return false;
		}
		InsExamen other = (InsExamen) object;
		if ((this.exaCodigo == null && other.exaCodigo != null)
				|| (this.exaCodigo != null && !this.exaCodigo.equals(other.exaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.exaCodigo != null) ? this.exaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsExamen[ exaCodigo=" + this.exaCodigo + " ]";
	}

}
