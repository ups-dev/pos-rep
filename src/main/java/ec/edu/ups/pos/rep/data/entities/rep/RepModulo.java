package ec.edu.ups.pos.rep.data.entities.rep;

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
@Table(name = "REP_MODULO", catalog = "", schema = "REP")
public class RepModulo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MOD_CODIGO", nullable = false)
	private Long modCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 120)
	@Column(name = "MOD_NOMBRE", nullable = false, length = 120)
	private String modNombre;

	@Size(max = 500)
	@Column(name = "MOD_DESCRIPCION", length = 500)
	private String modDescripcion;

	@Size(max = 80)
	@Column(name = "MOD_ICONO", length = 80)
	private String modIcono;

	@Column(name = "MOD_ORDEN")
	private Long modOrden;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "repModulo", fetch = FetchType.LAZY)
	private Collection<RepReporteModulo> repReporteModuloCollection;

	public RepModulo() {
	}

	public RepModulo(Long modCodigo) {
		this.modCodigo = modCodigo;
	}

	public RepModulo(Long modCodigo, String modNombre) {
		this.modCodigo = modCodigo;
		this.modNombre = modNombre;
	}

	public Long getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Long modCodigo) {
		this.modCodigo = modCodigo;
	}

	public String getModNombre() {
		return this.modNombre;
	}

	public void setModNombre(String modNombre) {
		this.modNombre = modNombre;
	}

	public String getModDescripcion() {
		return this.modDescripcion;
	}

	public void setModDescripcion(String modDescripcion) {
		this.modDescripcion = modDescripcion;
	}

	public String getModIcono() {
		return this.modIcono;
	}

	public void setModIcono(String modIcono) {
		this.modIcono = modIcono;
	}

	public Long getModOrden() {
		return this.modOrden;
	}

	public void setModOrden(Long modOrden) {
		this.modOrden = modOrden;
	}

	public Collection<RepReporteModulo> getRepReporteModuloCollection() {
		return this.repReporteModuloCollection;
	}

	public void setRepReporteModuloCollection(Collection<RepReporteModulo> repReporteModuloCollection) {
		this.repReporteModuloCollection = repReporteModuloCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RepModulo)) {
			return false;
		}
		RepModulo other = (RepModulo) object;
		if ((this.modCodigo == null && other.modCodigo != null)
				|| (this.modCodigo != null && !this.modCodigo.equals(other.modCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.modCodigo != null) ? this.modCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepModulo[ modCodigo=" + this.modCodigo + " ]";
	}

}
