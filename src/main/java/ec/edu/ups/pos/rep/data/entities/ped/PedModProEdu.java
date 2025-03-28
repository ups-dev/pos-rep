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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MOD_PRO_EDU", schema = "PED",
		uniqueConstraints = @UniqueConstraint(columnNames = { "PRE_NUMERO", "MOD_CODIGO" }))
@NamedQueries({ @NamedQuery(name = "PedModProEdu.findAll", query = "SELECT p FROM PedModProEdu p"), @NamedQuery(
		name = "PedModProEdu.findByMpeCodigo", query = "SELECT p FROM PedModProEdu p WHERE p.mpeCodigo = :mpeCodigo") })
public class PedModProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MPE_CODIGO", nullable = false, updatable = false)
	private Long mpeCodigo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedModProEdu")
	private Collection<PedEstModProEdu> pedEstModProEduCollection;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	@JoinColumn(name = "MOD_CODIGO", referencedColumnName = "MOD_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedModalidad pedModalidad;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	public PedModProEdu() {
	}

	public PedModProEdu(Long mpeCodigo) {
		this.mpeCodigo = mpeCodigo;
	}

	public Long getMpeCodigo() {
		return this.mpeCodigo;
	}

	public void setMpeCodigo(Long mpeCodigo) {
		this.mpeCodigo = mpeCodigo;
	}

	public Collection<PedEstModProEdu> getPedEstModProEduCollection() {
		return this.pedEstModProEduCollection;
	}

	public void setPedEstModProEduCollection(Collection<PedEstModProEdu> pedEstModProEduCollection) {
		this.pedEstModProEduCollection = pedEstModProEduCollection;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	public PedModalidad getPedModalidad() {
		return this.pedModalidad;
	}

	public void setPedModalidad(PedModalidad pedModalidad) {
		this.pedModalidad = pedModalidad;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedModProEdu)) {
			return false;
		}
		PedModProEdu other = (PedModProEdu) object;
		if ((this.mpeCodigo == null && other.mpeCodigo != null)
				|| (this.mpeCodigo != null && !this.mpeCodigo.equals(other.mpeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mpeCodigo != null) ? this.mpeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedModProEdu[ mpeCodigo=" + this.mpeCodigo + " ]";
	}

}
