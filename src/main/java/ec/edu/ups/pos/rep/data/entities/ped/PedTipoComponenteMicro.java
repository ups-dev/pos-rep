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
@Table(name = "PED_TIPO_COMPONENTE_MICRO", schema = "PED")
public class PedTipoComponenteMicro extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TCM_CODIGO", nullable = false, updatable = false)
	private Long tcmCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TCM_DESCRIPCION", nullable = false, length = 200)
	private String tcmDescripcion;

	@OneToMany(mappedBy = "pedTipoComponenteMicroPadre")
	private Collection<PedTipoComponenteMicro> pedTipoComponenteMicroCollection;

	@JoinColumn(name = "TCM_CODIGO_PADRE", referencedColumnName = "TCM_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedTipoComponenteMicro pedTipoComponenteMicroPadre;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoComponenteMicro")
	private Collection<PedTipComMicTipProEdu> pedTipComMicTipProEduCollection;

	public PedTipoComponenteMicro() {
	}

	public PedTipoComponenteMicro(Long tcmCodigo) {
		this.tcmCodigo = tcmCodigo;
	}

	public PedTipoComponenteMicro(Long tcmCodigo, String tcmDescripcion) {
		this.tcmCodigo = tcmCodigo;
		this.tcmDescripcion = tcmDescripcion;
	}

	public Long getTcmCodigo() {
		return this.tcmCodigo;
	}

	public void setTcmCodigo(Long tcmCodigo) {
		this.tcmCodigo = tcmCodigo;
	}

	public String getTcmDescripcion() {
		return this.tcmDescripcion;
	}

	public void setTcmDescripcion(String tcmDescripcion) {
		this.tcmDescripcion = tcmDescripcion;
	}

	public Collection<PedTipoComponenteMicro> getPedTipoComponenteMicroCollection() {
		return this.pedTipoComponenteMicroCollection;
	}

	public void setPedTipoComponenteMicroCollection(
			Collection<PedTipoComponenteMicro> pedTipoComponenteMicroCollection) {
		this.pedTipoComponenteMicroCollection = pedTipoComponenteMicroCollection;
	}

	public PedTipoComponenteMicro getPedTipoComponenteMicroPadre() {
		return this.pedTipoComponenteMicroPadre;
	}

	public void setPedTipoComponenteMicroPadre(PedTipoComponenteMicro pedTipoComponenteMicroPadre) {
		this.pedTipoComponenteMicroPadre = pedTipoComponenteMicroPadre;
	}

	public Collection<PedTipComMicTipProEdu> getPedTipComMicTipProEduCollection() {
		return this.pedTipComMicTipProEduCollection;
	}

	public void setPedTipComMicTipProEduCollection(Collection<PedTipComMicTipProEdu> pedTipComMicTipProEduCollection) {
		this.pedTipComMicTipProEduCollection = pedTipComMicTipProEduCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoComponenteMicro)) {
			return false;
		}
		PedTipoComponenteMicro other = (PedTipoComponenteMicro) object;
		if ((this.tcmCodigo == null && other.tcmCodigo != null)
				|| (this.tcmCodigo != null && !this.tcmCodigo.equals(other.tcmCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tcmCodigo != null) ? this.tcmCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoComponenteMicro[ tcmCodigo=" + this.tcmCodigo + " ]";
	}

}
