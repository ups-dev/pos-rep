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
@Table(name = "PED_TIPO_AREA_PLAN_ESTUDIO", schema = "PED")
public class PedTipoAreaPlanEstudio extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TAP_CODIGO", nullable = false, updatable = false)
	private Long tapCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TAP_DESCRIPCION", nullable = false, length = 200)
	private String tapDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoAreaPlanEstudio")
	private Collection<PedAreaPlanEstudio> pedAreaPlanEstudioCollection;

	public PedTipoAreaPlanEstudio() {
	}

	public PedTipoAreaPlanEstudio(Long tapCodigo) {
		this.tapCodigo = tapCodigo;
	}

	public PedTipoAreaPlanEstudio(Long tapCodigo, String tapDescripcion) {
		this.tapCodigo = tapCodigo;
		this.tapDescripcion = tapDescripcion;
	}

	public Long getTapCodigo() {
		return this.tapCodigo;
	}

	public void setTapCodigo(Long tapCodigo) {
		this.tapCodigo = tapCodigo;
	}

	public String getTapDescripcion() {
		return this.tapDescripcion;
	}

	public void setTapDescripcion(String tapDescripcion) {
		this.tapDescripcion = tapDescripcion;
	}

	public Collection<PedAreaPlanEstudio> getPedAreaPlanEstudioCollection() {
		return this.pedAreaPlanEstudioCollection;
	}

	public void setPedAreaPlanEstudioCollection(Collection<PedAreaPlanEstudio> pedAreaPlanEstudioCollection) {
		this.pedAreaPlanEstudioCollection = pedAreaPlanEstudioCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoAreaPlanEstudio)) {
			return false;
		}
		PedTipoAreaPlanEstudio other = (PedTipoAreaPlanEstudio) object;
		if ((this.tapCodigo == null && other.tapCodigo != null)
				|| (this.tapCodigo != null && !this.tapCodigo.equals(other.tapCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tapCodigo != null) ? this.tapCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoAreaPlanEstudio[ tapCodigo=" + this.tapCodigo + " ]";
	}

}
