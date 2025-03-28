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
@Table(name = "PED_MOD_ORG_APR", schema = "PED")
public class PedModOrgApr extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MOA_CODIGO", nullable = false)
	private Long moaCodigo;

	@Column(name = "MOA_NUMERO_HORAS")
	private Integer moaNumeroHoras;

	@JoinColumn(name = "MOD_CODIGO", referencedColumnName = "MOD_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedModalidad pedModalidad;

	@JoinColumn(name = "ORA_CODIGO", referencedColumnName = "ORA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedOrganizacionAprendizaje pedOrganizacionAprendizaje;

	@OneToMany(mappedBy = "pedModOrgApr", fetch = FetchType.LAZY)
	private Collection<PedMalla> pedMallaCollection;

	public PedModOrgApr() {
	}

	public PedModOrgApr(Long moaCodigo) {
		this.moaCodigo = moaCodigo;
	}

	public Long getMoaCodigo() {
		return this.moaCodigo;
	}

	public void setMoaCodigo(Long moaCodigo) {
		this.moaCodigo = moaCodigo;
	}

	public Integer getMoaNumeroHoras() {
		return this.moaNumeroHoras;
	}

	public void setMoaNumeroHoras(Integer moaNumeroHoras) {
		this.moaNumeroHoras = moaNumeroHoras;
	}

	public PedModalidad getPedModalidad() {
		return this.pedModalidad;
	}

	public void setPedModalidad(PedModalidad pedModalidad) {
		this.pedModalidad = pedModalidad;
	}

	public PedOrganizacionAprendizaje getPedOrganizacionAprendizaje() {
		return this.pedOrganizacionAprendizaje;
	}

	public void setPedOrganizacionAprendizaje(PedOrganizacionAprendizaje pedOrganizacionAprendizaje) {
		this.pedOrganizacionAprendizaje = pedOrganizacionAprendizaje;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedModOrgApr)) {
			return false;
		}
		PedModOrgApr other = (PedModOrgApr) object;
		if ((this.moaCodigo == null && other.moaCodigo != null)
				|| (this.moaCodigo != null && !this.moaCodigo.equals(other.moaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.moaCodigo != null) ? this.moaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedModOrgApr[ moaCodigo=" + this.moaCodigo + " ]";
	}

}
