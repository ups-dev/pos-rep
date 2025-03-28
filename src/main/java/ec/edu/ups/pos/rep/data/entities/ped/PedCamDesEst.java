package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_CAM_DES_EST", schema = "PED")
public class PedCamDesEst extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CDE_CODIGO", nullable = false)
	private Long cdeCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DEE_CODIGO", nullable = false)
	private Long deeCodigo;

	@Size(max = 500)
	@Column(name = "CDE_DES_TIT_OPCIONAL", length = 500)
	private String cdeDesTitOpcional;

	@JoinColumn(name = "CCT_CODIGO", referencedColumnName = "CCT_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedCamConTipTit pedCamConTipTit;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedCamDesEst", fetch = FetchType.LAZY)
	private Collection<PedCdeDep> pedCdeDepCollection;

	public PedCamDesEst() {
	}

	public PedCamDesEst(Long cdeCodigo) {
		this.cdeCodigo = cdeCodigo;
	}

	public PedCamDesEst(Long cdeCodigo, Long deeCodigo) {
		this.cdeCodigo = cdeCodigo;
		this.deeCodigo = deeCodigo;
	}

	public Long getCdeCodigo() {
		return this.cdeCodigo;
	}

	public void setCdeCodigo(Long cdeCodigo) {
		this.cdeCodigo = cdeCodigo;
	}

	public Long getDeeCodigo() {
		return this.deeCodigo;
	}

	public void setDeeCodigo(Long deeCodigo) {
		this.deeCodigo = deeCodigo;
	}

	public String getCdeDesTitOpcional() {
		return this.cdeDesTitOpcional;
	}

	public void setCdeDesTitOpcional(String cdeDesTitOpcional) {
		this.cdeDesTitOpcional = cdeDesTitOpcional;
	}

	public PedCamConTipTit getPedCamConTipTit() {
		return this.pedCamConTipTit;
	}

	public void setPedCamConTipTit(PedCamConTipTit pedCamConTipTit) {
		this.pedCamConTipTit = pedCamConTipTit;
	}

	public Collection<PedCdeDep> getPedCdeDepCollection() {
		return this.pedCdeDepCollection;
	}

	public void setPedCdeDepCollection(Collection<PedCdeDep> pedCdeDepCollection) {
		this.pedCdeDepCollection = pedCdeDepCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCamDesEst)) {
			return false;
		}
		PedCamDesEst other = (PedCamDesEst) object;
		if ((this.cdeCodigo == null && other.cdeCodigo != null)
				|| (this.cdeCodigo != null && !this.cdeCodigo.equals(other.cdeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cdeCodigo != null) ? this.cdeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCamDesEst[ cdeCodigo=" + this.cdeCodigo + " ]";
	}

}
