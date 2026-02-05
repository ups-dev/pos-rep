package ec.edu.ups.pos.rep.data.entities.ped;

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
@Table(name = "PED_ITINERARIO_MALLA", schema = "PED")
public class PedItinerarioMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ITM_CODIGO", nullable = false, updatable = false)
	private Long itmCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ITM_ORDEN", nullable = false)
	private Integer itmOrden;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@JoinColumn(name = "ITI_CODIGO", referencedColumnName = "ITI_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedItinerario pedItinerario;

	public PedItinerarioMalla() {
	}

	public PedItinerarioMalla(Long itmCodigo) {
		this.itmCodigo = itmCodigo;
	}

	public PedItinerarioMalla(Long itmCodigo, Integer itmOrden) {
		this.itmCodigo = itmCodigo;
		this.itmOrden = itmOrden;
	}

	public Long getItmCodigo() {
		return this.itmCodigo;
	}

	public void setItmCodigo(Long itmCodigo) {
		this.itmCodigo = itmCodigo;
	}

	public Integer getItmOrden() {
		return this.itmOrden;
	}

	public void setItmOrden(Integer itmOrden) {
		this.itmOrden = itmOrden;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public PedItinerario getPedItinerario() {
		return this.pedItinerario;
	}

	public void setPedItinerario(PedItinerario pedItinerario) {
		this.pedItinerario = pedItinerario;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedItinerarioMalla)) {
			return false;
		}
		PedItinerarioMalla other = (PedItinerarioMalla) object;
		if ((this.itmCodigo == null && other.itmCodigo != null)
				|| (this.itmCodigo != null && !this.itmCodigo.equals(other.itmCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.itmCodigo != null) ? this.itmCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedItinerarioMalla[ itmCodigo=" + this.itmCodigo + " ]";
	}

}
