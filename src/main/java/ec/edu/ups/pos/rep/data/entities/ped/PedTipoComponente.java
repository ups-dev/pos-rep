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
@Table(name = "PED_TIPO_COMPONENTE", schema = "PED")
public class PedTipoComponente extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIC_CODIGO", nullable = false, updatable = false)
	private Long ticCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1000)
	@Column(name = "TIC_DESCRIPCION", nullable = false, length = 1000)
	private String ticDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIC_TIPO", nullable = false, length = 1)
	private String ticTipo;

	@OneToMany(mappedBy = "pedTipoComponentePadre")
	private Collection<PedTipoComponente> pedTipoComponenteCollection;

	@JoinColumn(name = "TIC_CODIGO_PADRE", referencedColumnName = "TIC_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedTipoComponente pedTipoComponentePadre;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoComponente")
	private Collection<PedTipComTipProEdu> pedTipComTipProEduCollection;

	public PedTipoComponente() {
	}

	public PedTipoComponente(Long ticCodigo) {
		this.ticCodigo = ticCodigo;
	}

	public PedTipoComponente(Long ticCodigo, String ticDescripcion) {
		this.ticCodigo = ticCodigo;
		this.ticDescripcion = ticDescripcion;
	}

	public Long getTicCodigo() {
		return this.ticCodigo;
	}

	public void setTicCodigo(Long ticCodigo) {
		this.ticCodigo = ticCodigo;
	}

	public String getTicDescripcion() {
		return this.ticDescripcion;
	}

	public void setTicDescripcion(String ticDescripcion) {
		this.ticDescripcion = ticDescripcion;
	}

	public String getTicTipo() {
		return this.ticTipo;
	}

	public void setTicTipo(String ticTipo) {
		this.ticTipo = ticTipo;
	}

	public Collection<PedTipoComponente> getPedTipoComponenteCollection() {
		return this.pedTipoComponenteCollection;
	}

	public void setPedTipoComponenteCollection(Collection<PedTipoComponente> pedTipoComponenteCollection) {
		this.pedTipoComponenteCollection = pedTipoComponenteCollection;
	}

	public PedTipoComponente getPedTipoComponentePadre() {
		return this.pedTipoComponentePadre;
	}

	public void setPedTipoComponentePadre(PedTipoComponente pedTipoComponentePadre) {
		this.pedTipoComponentePadre = pedTipoComponentePadre;
	}

	public Collection<PedTipComTipProEdu> getPedTipComTipProEduCollection() {
		return this.pedTipComTipProEduCollection;
	}

	public void setPedTipComTipProEduCollection(Collection<PedTipComTipProEdu> pedTipComTipProEduCollection) {
		this.pedTipComTipProEduCollection = pedTipComTipProEduCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoComponente)) {
			return false;
		}
		PedTipoComponente other = (PedTipoComponente) object;
		if ((this.ticCodigo == null && other.ticCodigo != null)
				|| (this.ticCodigo != null && !this.ticCodigo.equals(other.ticCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ticCodigo != null) ? this.ticCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoComponente[ ticCodigo=" + this.ticCodigo + " ]";
	}

}
