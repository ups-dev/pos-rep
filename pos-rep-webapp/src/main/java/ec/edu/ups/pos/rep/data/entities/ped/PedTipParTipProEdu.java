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
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIP_PAR_TIP_PRO_EDU", schema = "PED",
		uniqueConstraints = @UniqueConstraint(columnNames = { "TPP_CODIGO", "TPE_CODIGO" }))
public class PedTipParTipProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TPT_CODIGO", nullable = false, updatable = false)
	private Long tptCodigo;

	@Column(name = "TPT_ORDEN")
	private Integer tptOrden;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TPT_TIENE_ANEXO", nullable = false, length = 1)
	private String tptTieneAnexo;

	@Size(max = 2)
	@Column(name = "TPT_TIPO_PERTENECE", length = 2)
	private String tptTipoPertenece;

	@JoinColumn(name = "TPP_CODIGO", referencedColumnName = "TPP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipParProEdu pedTipParProEdu;

	@JoinColumn(name = "TPE_CODIGO", referencedColumnName = "TPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoProyectoEducacion pedTipoProyectoEducacion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipParTipProEdu")
	private Collection<PedParProEdu> pedParProEduCollection;

	public PedTipParTipProEdu() {
	}

	public PedTipParTipProEdu(Long tptCodigo) {
		this.tptCodigo = tptCodigo;
	}

	public PedTipParTipProEdu(Long tptCodigo, String tptTieneAnexo) {
		this.tptCodigo = tptCodigo;
		this.tptTieneAnexo = tptTieneAnexo;
	}

	public Long getTptCodigo() {
		return this.tptCodigo;
	}

	public void setTptCodigo(Long tptCodigo) {
		this.tptCodigo = tptCodigo;
	}

	public Integer getTptOrden() {
		return this.tptOrden;
	}

	public void setTptOrden(Integer tptOrden) {
		this.tptOrden = tptOrden;
	}

	public String getTptTieneAnexo() {
		return this.tptTieneAnexo;
	}

	public void setTptTieneAnexo(String tptTieneAnexo) {
		this.tptTieneAnexo = tptTieneAnexo;
	}

	public PedTipParProEdu getPedTipParProEdu() {
		return this.pedTipParProEdu;
	}

	public void setPedTipParProEdu(PedTipParProEdu pedTipParProEdu) {
		this.pedTipParProEdu = pedTipParProEdu;
	}

	public PedTipoProyectoEducacion getPedTipoProyectoEducacion() {
		return this.pedTipoProyectoEducacion;
	}

	public void setPedTipoProyectoEducacion(PedTipoProyectoEducacion pedTipoProyectoEducacion) {
		this.pedTipoProyectoEducacion = pedTipoProyectoEducacion;
	}

	public Collection<PedParProEdu> getPedParProEduCollection() {
		return this.pedParProEduCollection;
	}

	public void setPedParProEduCollection(Collection<PedParProEdu> pedParProEduCollection) {
		this.pedParProEduCollection = pedParProEduCollection;
	}

	public String getTptTipoPertenece() {
		return this.tptTipoPertenece;
	}

	public void setTptTipoPertenece(String tptTipoPertenece) {
		this.tptTipoPertenece = tptTipoPertenece;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipParTipProEdu)) {
			return false;
		}
		PedTipParTipProEdu other = (PedTipParTipProEdu) object;
		if ((this.tptCodigo == null && other.tptCodigo != null)
				|| (this.tptCodigo != null && !this.tptCodigo.equals(other.tptCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tptCodigo != null) ? this.tptCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipParTipProEdu[ tptCodigo=" + this.tptCodigo + " ]";
	}

}
