package ec.edu.ups.pos.rep.data.entities.ins;

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
@Table(name = "INS_TIPO_APROBACION", schema = "INS")
public class InsTipoAprobacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIA_CODIGO", nullable = false)
	private Long tiaCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "TIA_DESCRIPCION", nullable = false, length = 50)
	private String tiaDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insTipoAprobacion", fetch = FetchType.LAZY)
	private Collection<InsTipAprIns> insTipAprInsCollection;

	public InsTipoAprobacion() {
	}

	public InsTipoAprobacion(Long tiaCodigo) {
		this.tiaCodigo = tiaCodigo;
	}

	public InsTipoAprobacion(Long tiaCodigo, String tiaDescripcion) {
		this.tiaCodigo = tiaCodigo;
		this.tiaDescripcion = tiaDescripcion;
	}

	public Long getTiaCodigo() {
		return this.tiaCodigo;
	}

	public void setTiaCodigo(Long tiaCodigo) {
		this.tiaCodigo = tiaCodigo;
	}

	public String getTiaDescripcion() {
		return this.tiaDescripcion;
	}

	public void setTiaDescripcion(String tiaDescripcion) {
		this.tiaDescripcion = tiaDescripcion;
	}

	public Collection<InsTipAprIns> getInsTipAprInsCollection() {
		return this.insTipAprInsCollection;
	}

	public void setInsTipAprInsCollection(Collection<InsTipAprIns> insTipAprInsCollection) {
		this.insTipAprInsCollection = insTipAprInsCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsTipoAprobacion)) {
			return false;
		}
		InsTipoAprobacion other = (InsTipoAprobacion) object;
		if ((this.tiaCodigo == null && other.tiaCodigo != null)
				|| (this.tiaCodigo != null && !this.tiaCodigo.equals(other.tiaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tiaCodigo != null) ? this.tiaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsTipoAprobacion[ tiaCodigo=" + this.tiaCodigo + " ]";
	}

}
