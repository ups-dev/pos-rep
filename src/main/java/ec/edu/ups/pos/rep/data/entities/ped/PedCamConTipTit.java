package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_CAM_CON_TIP_TIT", schema = "PED")
public class PedCamConTipTit extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CCT_CODIGO", nullable = false)
	private Long cctCodigo;

	@OneToMany(mappedBy = "pedCamConTipTit", fetch = FetchType.LAZY)
	private Collection<PedCamDesEst> pedCamDesEstCollection;

	@JoinColumn(name = "CAC_CODIGO", referencedColumnName = "CAC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedCampoConocimiento pedCampoConocimiento;

	@JoinColumn(name = "TIT_CODIGO", referencedColumnName = "TIT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoTitulacion pedTipoTitulacion;

	public PedCamConTipTit() {
	}

	public PedCamConTipTit(Long cctCodigo) {
		this.cctCodigo = cctCodigo;
	}

	public Long getCctCodigo() {
		return this.cctCodigo;
	}

	public void setCctCodigo(Long cctCodigo) {
		this.cctCodigo = cctCodigo;
	}

	public Collection<PedCamDesEst> getPedCamDesEstCollection() {
		return this.pedCamDesEstCollection;
	}

	public void setPedCamDesEstCollection(Collection<PedCamDesEst> pedCamDesEstCollection) {
		this.pedCamDesEstCollection = pedCamDesEstCollection;
	}

	public PedCampoConocimiento getPedCampoConocimiento() {
		return this.pedCampoConocimiento;
	}

	public void setPedCampoConocimiento(PedCampoConocimiento pedCampoConocimiento) {
		this.pedCampoConocimiento = pedCampoConocimiento;
	}

	public PedTipoTitulacion getPedTipoTitulacion() {
		return this.pedTipoTitulacion;
	}

	public void setPedTipoTitulacion(PedTipoTitulacion pedTipoTitulacion) {
		this.pedTipoTitulacion = pedTipoTitulacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCamConTipTit)) {
			return false;
		}
		PedCamConTipTit other = (PedCamConTipTit) object;
		if ((this.cctCodigo == null && other.cctCodigo != null)
				|| (this.cctCodigo != null && !this.cctCodigo.equals(other.cctCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cctCodigo != null) ? this.cctCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCamConTipTit[ cctCodigo=" + this.cctCodigo + " ]";
	}

}
