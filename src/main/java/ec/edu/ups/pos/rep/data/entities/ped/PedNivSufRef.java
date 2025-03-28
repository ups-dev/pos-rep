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
@Table(name = "PED_NIV_SUF_REF", schema = "PED")
public class PedNivSufRef extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "NSR_CODIGO", nullable = false)
	private Long nsrCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "NSR_DESCRIPCION", nullable = false, length = 150)
	private String nsrDescripcion;

	@JoinColumn(name = "TNS_CODIGO", referencedColumnName = "TNS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoNivelSuficiencia pedTipoNivelSuficiencia;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedNivSufRef", fetch = FetchType.LAZY)
	private Collection<PedDetalleNivelSuficiencia> pedDetalleNivelSuficienciaCollection;

	@OneToMany(mappedBy = "pedNivSufRef", fetch = FetchType.LAZY)
	private Collection<PedParProEdu> pedParProEduCollection;

	public PedNivSufRef() {
	}

	public PedNivSufRef(Long nsrCodigo) {
		this.nsrCodigo = nsrCodigo;
	}

	public PedNivSufRef(Long nsrCodigo, String nsrDescripcion) {
		this.nsrCodigo = nsrCodigo;
		this.nsrDescripcion = nsrDescripcion;
	}

	public Long getNsrCodigo() {
		return this.nsrCodigo;
	}

	public void setNsrCodigo(Long nsrCodigo) {
		this.nsrCodigo = nsrCodigo;
	}

	public String getNsrDescripcion() {
		return this.nsrDescripcion;
	}

	public void setNsrDescripcion(String nsrDescripcion) {
		this.nsrDescripcion = nsrDescripcion;
	}

	public PedTipoNivelSuficiencia getPedTipoNivelSuficiencia() {
		return this.pedTipoNivelSuficiencia;
	}

	public void setPedTipoNivelSuficiencia(PedTipoNivelSuficiencia pedTipoNivelSuficiencia) {
		this.pedTipoNivelSuficiencia = pedTipoNivelSuficiencia;
	}

	public Collection<PedDetalleNivelSuficiencia> getPedDetalleNivelSuficienciaCollection() {
		return this.pedDetalleNivelSuficienciaCollection;
	}

	public void setPedDetalleNivelSuficienciaCollection(
			Collection<PedDetalleNivelSuficiencia> pedDetalleNivelSuficienciaCollection) {
		this.pedDetalleNivelSuficienciaCollection = pedDetalleNivelSuficienciaCollection;
	}

	public Collection<PedParProEdu> getPedParProEduCollection() {
		return this.pedParProEduCollection;
	}

	public void setPedParProEduCollection(Collection<PedParProEdu> pedParProEduCollection) {
		this.pedParProEduCollection = pedParProEduCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedNivSufRef)) {
			return false;
		}
		PedNivSufRef other = (PedNivSufRef) object;
		if ((this.nsrCodigo == null && other.nsrCodigo != null)
				|| (this.nsrCodigo != null && !this.nsrCodigo.equals(other.nsrCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.nsrCodigo != null) ? this.nsrCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedNivSufRef[ nsrCodigo=" + this.nsrCodigo + " ]";
	}

}
