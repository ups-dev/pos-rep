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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIP_COM_TIP_PRO_EDU", schema = "PED",
		uniqueConstraints = @UniqueConstraint(columnNames = { "TIC_CODIGO", "TPE_CODIGO" }))
public class PedTipComTipProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TCT_CODIGO", nullable = false, updatable = false)
	private Long tctCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TCT_ORDEN", nullable = false)
	private Integer tctOrden;

	@JoinColumn(name = "TPE_CODIGO", referencedColumnName = "TPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoProyectoEducacion pedTipoProyectoEducacion;

	@JoinColumn(name = "TIC_CODIGO", referencedColumnName = "TIC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoComponente pedTipoComponente;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipComTipProEdu")
	private Collection<PedComponente> pedComponenteCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedTipComTipProEdu")
	private Collection<PedValTipComTipProEdu> pedValTipComTipProEduCollection;

	public PedTipComTipProEdu() {
	}

	public PedTipComTipProEdu(Long tctCodigo) {
		this.tctCodigo = tctCodigo;
	}

	public PedTipComTipProEdu(Long tctCodigo, Integer tctOrden) {
		this.tctCodigo = tctCodigo;
		this.tctOrden = tctOrden;
	}

	public Long getTctCodigo() {
		return this.tctCodigo;
	}

	public void setTctCodigo(Long tctCodigo) {
		this.tctCodigo = tctCodigo;
	}

	public Integer getTctOrden() {
		return this.tctOrden;
	}

	public void setTctOrden(Integer tctOrden) {
		this.tctOrden = tctOrden;
	}

	public PedTipoProyectoEducacion getPedTipoProyectoEducacion() {
		return this.pedTipoProyectoEducacion;
	}

	public void setPedTipoProyectoEducacion(PedTipoProyectoEducacion pedTipoProyectoEducacion) {
		this.pedTipoProyectoEducacion = pedTipoProyectoEducacion;
	}

	public PedTipoComponente getPedTipoComponente() {
		return this.pedTipoComponente;
	}

	public void setPedTipoComponente(PedTipoComponente pedTipoComponente) {
		this.pedTipoComponente = pedTipoComponente;
	}

	public Collection<PedComponente> getPedComponenteCollection() {
		return this.pedComponenteCollection;
	}

	public void setPedComponenteCollection(Collection<PedComponente> pedComponenteCollection) {
		this.pedComponenteCollection = pedComponenteCollection;
	}

	public Collection<PedValTipComTipProEdu> getPedValTipComTipProEduCollection() {
		return this.pedValTipComTipProEduCollection;
	}

	public void setPedValTipComTipProEduCollection(Collection<PedValTipComTipProEdu> pedValTipComTipProEduCollection) {
		this.pedValTipComTipProEduCollection = pedValTipComTipProEduCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipComTipProEdu)) {
			return false;
		}
		PedTipComTipProEdu other = (PedTipComTipProEdu) object;
		if ((this.tctCodigo == null && other.tctCodigo != null)
				|| (this.tctCodigo != null && !this.tctCodigo.equals(other.tctCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tctCodigo != null) ? this.tctCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipComTipProEdu[ tctCodigo=" + this.tctCodigo + " ]";
	}

}
