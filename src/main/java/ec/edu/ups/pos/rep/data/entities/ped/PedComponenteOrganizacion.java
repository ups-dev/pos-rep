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
@Table(name = "PED_COMPONENTE_ORGANIZACION", schema = "PED")
public class PedComponenteOrganizacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COO_CODIGO", nullable = false)
	private Long cooCodigo;

	@JoinColumn(name = "COA_CODIGO", referencedColumnName = "COA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedComponenteAprendizaje pedComponenteAprendizaje;

	@JoinColumn(name = "ORA_CODIGO", referencedColumnName = "ORA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedOrganizacionAprendizaje pedOrganizacionAprendizaje;

	public PedComponenteOrganizacion() {
	}

	public PedComponenteOrganizacion(Long cooCodigo) {
		this.cooCodigo = cooCodigo;
	}

	public Long getCooCodigo() {
		return this.cooCodigo;
	}

	public void setCooCodigo(Long cooCodigo) {
		this.cooCodigo = cooCodigo;
	}

	public PedComponenteAprendizaje getPedComponenteAprendizaje() {
		return this.pedComponenteAprendizaje;
	}

	public void setPedComponenteAprendizaje(PedComponenteAprendizaje pedComponenteAprendizaje) {
		this.pedComponenteAprendizaje = pedComponenteAprendizaje;
	}

	public PedOrganizacionAprendizaje getPedOrganizacionAprendizaje() {
		return this.pedOrganizacionAprendizaje;
	}

	public void setPedOrganizacionAprendizaje(PedOrganizacionAprendizaje pedOrganizacionAprendizaje) {
		this.pedOrganizacionAprendizaje = pedOrganizacionAprendizaje;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedComponenteOrganizacion)) {
			return false;
		}
		PedComponenteOrganizacion other = (PedComponenteOrganizacion) object;
		if ((this.cooCodigo == null && other.cooCodigo != null)
				|| (this.cooCodigo != null && !this.cooCodigo.equals(other.cooCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cooCodigo != null) ? this.cooCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedComponenteOrganizacion[ cooCodigo=" + this.cooCodigo + " ]";
	}

}
