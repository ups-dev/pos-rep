package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_CATEGORIA_TIPO_PROYECTO", schema = "PED")
public class PedCategoriaTipoProyecto extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CTP_CODIGO", nullable = false)
	private Long ctpCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "CTP_DESCRIPCION", nullable = false, length = 100)
	private String ctpDescripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedCategoriaTipoProyecto", fetch = FetchType.LAZY)
	private Collection<PedTipoProyectoEducacion> pedTipoProyectoEducacionCollection;

	public PedCategoriaTipoProyecto() {
	}

	public PedCategoriaTipoProyecto(Long ctpCodigo) {
		this.ctpCodigo = ctpCodigo;
	}

	public PedCategoriaTipoProyecto(Long ctpCodigo, String ctpDescripcion) {
		this.ctpCodigo = ctpCodigo;
		this.ctpDescripcion = ctpDescripcion;
	}

	public Long getCtpCodigo() {
		return this.ctpCodigo;
	}

	public void setCtpCodigo(Long ctpCodigo) {
		this.ctpCodigo = ctpCodigo;
	}

	public String getCtpDescripcion() {
		return this.ctpDescripcion;
	}

	public void setCtpDescripcion(String ctpDescripcion) {
		this.ctpDescripcion = ctpDescripcion;
	}

	public Collection<PedTipoProyectoEducacion> getPedTipoProyectoEducacionCollection() {
		return this.pedTipoProyectoEducacionCollection;
	}

	public void setPedTipoProyectoEducacionCollection(
			Collection<PedTipoProyectoEducacion> pedTipoProyectoEducacionCollection) {
		this.pedTipoProyectoEducacionCollection = pedTipoProyectoEducacionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCategoriaTipoProyecto)) {
			return false;
		}
		PedCategoriaTipoProyecto other = (PedCategoriaTipoProyecto) object;
		if ((this.ctpCodigo == null && other.ctpCodigo != null)
				|| (this.ctpCodigo != null && !this.ctpCodigo.equals(other.ctpCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ctpCodigo != null) ? this.ctpCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCategoriaTipoProyecto[ ctpCodigo=" + this.ctpCodigo + " ]";
	}

}
