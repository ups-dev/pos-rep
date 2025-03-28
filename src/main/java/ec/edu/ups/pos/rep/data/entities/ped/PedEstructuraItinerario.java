package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_ESTRUCTURA_ITINERARIO", schema = "PED")
public class PedEstructuraItinerario extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ESI_CODIGO")
	private Long esiCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO")
	private Long estCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "ESI_HABILITADO")
	private String esiHabilitado;

	@JoinColumn(name = "ITI_CODIGO", referencedColumnName = "ITI_CODIGO")
	@ManyToOne(optional = false)
	private PedItinerario itiCodigo;

	@Column(name = "PEL_CODIGO_INICIAL")
	private Long pelCodigoInicial;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	public PedEstructuraItinerario() {
	}

	public PedEstructuraItinerario(Long esiCodigo) {
		this.esiCodigo = esiCodigo;
	}

	public Long getEsiCodigo() {
		return this.esiCodigo;
	}

	public void setEsiCodigo(Long esiCodigo) {
		this.esiCodigo = esiCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getEsiHabilitado() {
		return this.esiHabilitado;
	}

	public void setEsiHabilitado(String esiHabilitado) {
		this.esiHabilitado = esiHabilitado;
	}

	public PedItinerario getItiCodigo() {
		return this.itiCodigo;
	}

	public void setItiCodigo(PedItinerario itiCodigo) {
		this.itiCodigo = itiCodigo;
	}

	public Long getPelCodigoInicial() {
		return this.pelCodigoInicial;
	}

	public void setPelCodigoInicial(Long pelCodigoInicial) {
		this.pelCodigoInicial = pelCodigoInicial;
	}

	public Long getPelCodigoFinal() {
		return this.pelCodigoFinal;
	}

	public void setPelCodigoFinal(Long pelCodigoFinal) {
		this.pelCodigoFinal = pelCodigoFinal;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedEstructuraItinerario)) {
			return false;
		}
		PedEstructuraItinerario other = (PedEstructuraItinerario) object;
		if ((this.esiCodigo == null && other.esiCodigo != null)
				|| (this.esiCodigo != null && !this.esiCodigo.equals(other.esiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.esiCodigo != null) ? this.esiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "ec.edu.ups.ped.data.entities.PedEstructuraItinerario[ esiCodigo=" + this.esiCodigo + " ]";
	}

}
