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
@Table(name = "PED_MECANISMO_TITULACION", schema = "PED")
public class PedMecanismoTitulacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MET_CODIGO", nullable = false)
	private Long metCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "MET_DESCRIPCION", nullable = false, length = 200)
	private String metDescripcion;

	@JoinColumn(name = "TPE_CODIGO", referencedColumnName = "TPE_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedTipoProyectoEducacion pedTipoProyectoEducacion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMecanismoTitulacion", fetch = FetchType.LAZY)
	private Collection<PedEstructuraMecanismo> pedEstructuraMecanismoCollection;

	public PedMecanismoTitulacion() {
	}

	public PedMecanismoTitulacion(Long metCodigo) {
		this.metCodigo = metCodigo;
	}

	public PedMecanismoTitulacion(Long metCodigo, String metDescripcion) {
		this.metCodigo = metCodigo;
		this.metDescripcion = metDescripcion;
	}

	public Long getMetCodigo() {
		return this.metCodigo;
	}

	public void setMetCodigo(Long metCodigo) {
		this.metCodigo = metCodigo;
	}

	public String getMetDescripcion() {
		return this.metDescripcion;
	}

	public void setMetDescripcion(String metDescripcion) {
		this.metDescripcion = metDescripcion;
	}

	public PedTipoProyectoEducacion getPedTipoProyectoEducacion() {
		return this.pedTipoProyectoEducacion;
	}

	public void setPedTipoProyectoEducacion(PedTipoProyectoEducacion pedTipoProyectoEducacion) {
		this.pedTipoProyectoEducacion = pedTipoProyectoEducacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMecanismoTitulacion)) {
			return false;
		}
		PedMecanismoTitulacion other = (PedMecanismoTitulacion) object;
		if ((this.metCodigo == null && other.metCodigo != null)
				|| (this.metCodigo != null && !this.metCodigo.equals(other.metCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.metCodigo != null) ? this.metCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMecanismoTitulacion[ metCodigo=" + this.metCodigo + " ]";
	}

	public Collection<PedEstructuraMecanismo> getPedEstructuraMecanismoCollection() {
		return this.pedEstructuraMecanismoCollection;
	}

	public void setPedEstructuraMecanismoCollection(
			Collection<PedEstructuraMecanismo> pedEstructuraMecanismoCollection) {
		this.pedEstructuraMecanismoCollection = pedEstructuraMecanismoCollection;
	}

}
