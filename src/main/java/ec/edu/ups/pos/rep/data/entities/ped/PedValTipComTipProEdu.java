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
@Table(name = "PED_VAL_TIP_COM_TIP_PRO_EDU", schema = "PED")
public class PedValTipComTipProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "VTC_CODIGO", nullable = false)
	private Long vtcCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "VTC_DESCRIPCION", nullable = false, length = 100)
	private String vtcDescripcion;

	@JoinColumn(name = "TCT_CODIGO", referencedColumnName = "TCT_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedTipComTipProEdu pedTipComTipProEdu;

	public PedValTipComTipProEdu() {
	}

	public PedValTipComTipProEdu(Long vtcCodigo) {
		this.vtcCodigo = vtcCodigo;
	}

	public PedValTipComTipProEdu(Long vtcCodigo, String vtcDescripcion) {
		this.vtcCodigo = vtcCodigo;
		this.vtcDescripcion = vtcDescripcion;
	}

	public Long getVtcCodigo() {
		return this.vtcCodigo;
	}

	public void setVtcCodigo(Long vtcCodigo) {
		this.vtcCodigo = vtcCodigo;
	}

	public String getVtcDescripcion() {
		return this.vtcDescripcion;
	}

	public void setVtcDescripcion(String vtcDescripcion) {
		this.vtcDescripcion = vtcDescripcion;
	}

	public PedTipComTipProEdu getPedTipComTipProEdu() {
		return this.pedTipComTipProEdu;
	}

	public void setPedTipComTipProEdu(PedTipComTipProEdu pedTipComTipProEdu) {
		this.pedTipComTipProEdu = pedTipComTipProEdu;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedValTipComTipProEdu)) {
			return false;
		}
		PedValTipComTipProEdu other = (PedValTipComTipProEdu) object;
		if ((this.vtcCodigo == null && other.vtcCodigo != null)
				|| (this.vtcCodigo != null && !this.vtcCodigo.equals(other.vtcCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.vtcCodigo != null) ? this.vtcCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedValTipComTipProEdu[ vtcCodigo=" + this.vtcCodigo + " ]";
	}

}
