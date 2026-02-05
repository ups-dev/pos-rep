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
@Table(name = "PED_EVIDENCIA_PORTAFOLIO_MALLA", schema = "PED")
public class PedEvidenciaPortafolioMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "EPM_CODIGO", nullable = false, updatable = false)
	private Long epmCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EPM_ORDEN", nullable = false)
	private Integer epmOrden;

	@JoinColumn(name = "TEP_CODIGO", referencedColumnName = "TEP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoEvidenciaPortafolio pedTipoEvidenciaPortafolio;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	public PedEvidenciaPortafolioMalla() {
	}

	public PedEvidenciaPortafolioMalla(Long epmCodigo) {
		this.epmCodigo = epmCodigo;
	}

	public PedEvidenciaPortafolioMalla(Long epmCodigo, Integer epmOrden) {
		this.epmCodigo = epmCodigo;
		this.epmOrden = epmOrden;
	}

	public Long getEpmCodigo() {
		return this.epmCodigo;
	}

	public void setEpmCodigo(Long epmCodigo) {
		this.epmCodigo = epmCodigo;
	}

	public Integer getEpmOrden() {
		return this.epmOrden;
	}

	public void setEpmOrden(Integer epmOrden) {
		this.epmOrden = epmOrden;
	}

	public PedTipoEvidenciaPortafolio getPedTipoEvidenciaPortafolio() {
		return this.pedTipoEvidenciaPortafolio;
	}

	public void setPedTipoEvidenciaPortafolio(PedTipoEvidenciaPortafolio pedTipoEvidenciaPortafolio) {
		this.pedTipoEvidenciaPortafolio = pedTipoEvidenciaPortafolio;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedEvidenciaPortafolioMalla)) {
			return false;
		}
		PedEvidenciaPortafolioMalla other = (PedEvidenciaPortafolioMalla) object;
		if ((this.epmCodigo == null && other.epmCodigo != null)
				|| (this.epmCodigo != null && !this.epmCodigo.equals(other.epmCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.epmCodigo != null) ? this.epmCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedEvidenciaPortafolioMalla[ epmCodigo=" + this.epmCodigo + " ]";
	}

}
