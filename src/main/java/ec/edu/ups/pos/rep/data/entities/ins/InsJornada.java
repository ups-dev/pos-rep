package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_JORNADA", schema = "INS")
public class InsJornada extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "JOR_CODIGO", nullable = false)
	private Long jorCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "JOR_DESCRIPCION", nullable = false, length = 50)
	private String jorDescripcion;

	@Column(name = "JOR_HORA_INICIAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date jorHoraInicial;

	@Column(name = "JOR_HORA_FINAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date jorHoraFinal;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insJornada", fetch = FetchType.LAZY)
	private Collection<InsReservaExamen> insReservaExamenCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insJornada", fetch = FetchType.LAZY)
	private Collection<InsOfertaInscripcionInicial> insOfertaInscripcionInicialCollection;

	@OneToMany(mappedBy = "insJornada")
	private Collection<InsAutJorIns> insAutJorInsCollection;

	public InsJornada() {
	}

	public InsJornada(Long jorCodigo) {
		this.jorCodigo = jorCodigo;
	}

	public Long getJorCodigo() {
		return this.jorCodigo;
	}

	public void setJorCodigo(Long jorCodigo) {
		this.jorCodigo = jorCodigo;
	}

	public String getJorDescripcion() {
		return this.jorDescripcion;
	}

	public void setJorDescripcion(String jorDescripcion) {
		this.jorDescripcion = jorDescripcion;
	}

	public Date getJorHoraInicial() {
		return this.jorHoraInicial;
	}

	public void setJorHoraInicial(Date jorHoraInicial) {
		this.jorHoraInicial = jorHoraInicial;
	}

	public Date getJorHoraFinal() {
		return this.jorHoraFinal;
	}

	public void setJorHoraFinal(Date jorHoraFinal) {
		this.jorHoraFinal = jorHoraFinal;
	}

	public Collection<InsOfertaInscripcionInicial> getInsOfertaInscripcionInicialCollection() {
		return this.insOfertaInscripcionInicialCollection;
	}

	public void setInsOfertaInscripcionInicialCollection(
			Collection<InsOfertaInscripcionInicial> insOfertaInscripcionInicialCollection) {
		this.insOfertaInscripcionInicialCollection = insOfertaInscripcionInicialCollection;
	}

	public Collection<InsReservaExamen> getInsReservaExamenCollection() {
		return this.insReservaExamenCollection;
	}

	public void setInsReservaExamenCollection(Collection<InsReservaExamen> insReservaExamenCollection) {
		this.insReservaExamenCollection = insReservaExamenCollection;
	}

	public Collection<InsAutJorIns> getInsAutJorInsCollection() {
		return this.insAutJorInsCollection;
	}

	public void setInsAutJorInsCollection(Collection<InsAutJorIns> insAutJorInsCollection) {
		this.insAutJorInsCollection = insAutJorInsCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsJornada)) {
			return false;
		}
		InsJornada other = (InsJornada) object;
		if ((this.jorCodigo == null && other.jorCodigo != null)
				|| (this.jorCodigo != null && !this.jorCodigo.equals(other.jorCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.jorCodigo != null) ? this.jorCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsJornada[ jorCodigo=" + this.jorCodigo + " ]";
	}

}
