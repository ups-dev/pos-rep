package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIP_PAR_PRO_EDU", schema = "PED")
public class PedTipParProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TPP_CODIGO", nullable = false, updatable = false)
	private Long tppCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TPP_DESCRIPCION", nullable = false, length = 200)
	private String tppDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TPP_TIPO", nullable = false, length = 1)
	private String tppTipo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipParProEdu")
	private Collection<PedTipParTipProEdu> pedTipParTipProEduCollection;

	public PedTipParProEdu() {
	}

	public PedTipParProEdu(Long tppCodigo) {
		this.tppCodigo = tppCodigo;
	}

	public PedTipParProEdu(Long tppCodigo, String tppDescripcion) {
		this.tppCodigo = tppCodigo;
		this.tppDescripcion = tppDescripcion;
	}

	public Long getTppCodigo() {
		return this.tppCodigo;
	}

	public void setTppCodigo(Long tppCodigo) {
		this.tppCodigo = tppCodigo;
	}

	public String getTppDescripcion() {
		return this.tppDescripcion;
	}

	public void setTppDescripcion(String tppDescripcion) {
		this.tppDescripcion = tppDescripcion;
	}

	public String getTppTipo() {
		return this.tppTipo;
	}

	public void setTppTipo(String tppTipo) {
		this.tppTipo = tppTipo;
	}

	public Collection<PedTipParTipProEdu> getPedTipParTipProEduCollection() {
		return this.pedTipParTipProEduCollection;
	}

	public void setPedTipParTipProEduCollection(Collection<PedTipParTipProEdu> pedTipParTipProEduCollection) {
		this.pedTipParTipProEduCollection = pedTipParTipProEduCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipParProEdu)) {
			return false;
		}
		PedTipParProEdu other = (PedTipParProEdu) object;
		if ((this.tppCodigo == null && other.tppCodigo != null)
				|| (this.tppCodigo != null && !this.tppCodigo.equals(other.tppCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tppCodigo != null) ? this.tppCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipParProEdu[ tppCodigo=" + this.tppCodigo + " ]";
	}

}
