package ec.edu.ups.pos.rep.data.entities.ins;

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

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_TIP_APR_INS", schema = "INS")
public class InsTipAprIns extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TAI_CODIGO", nullable = false)
	private Long taiCodigo;

	@JoinColumn(name = "TII_CODIGO", referencedColumnName = "TII_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsTipoInscripcion insTipoInscripcion;

	@JoinColumn(name = "TIA_CODIGO", referencedColumnName = "TIA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsTipoAprobacion insTipoAprobacion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insTipAprIns", fetch = FetchType.LAZY)
	private Collection<InsInscripcion> insInscripcionCollection;

	public InsTipAprIns() {
	}

	public InsTipAprIns(Long taiCodigo) {
		this.taiCodigo = taiCodigo;
	}

	public Long getTaiCodigo() {
		return this.taiCodigo;
	}

	public void setTaiCodigo(Long taiCodigo) {
		this.taiCodigo = taiCodigo;
	}

	public InsTipoInscripcion getInsTipoInscripcion() {
		return this.insTipoInscripcion;
	}

	public void setInsTipoInscripcion(InsTipoInscripcion insTipoInscripcion) {
		this.insTipoInscripcion = insTipoInscripcion;
	}

	public InsTipoAprobacion getInsTipoAprobacion() {
		return this.insTipoAprobacion;
	}

	public void setInsTipoAprobacion(InsTipoAprobacion insTipoAprobacion) {
		this.insTipoAprobacion = insTipoAprobacion;
	}

	public Collection<InsInscripcion> getInsInscripcionCollection() {
		return this.insInscripcionCollection;
	}

	public void setInsInscripcionCollection(Collection<InsInscripcion> insInscripcionCollection) {
		this.insInscripcionCollection = insInscripcionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsTipAprIns)) {
			return false;
		}
		InsTipAprIns other = (InsTipAprIns) object;
		if ((this.taiCodigo == null && other.taiCodigo != null)
				|| (this.taiCodigo != null && !this.taiCodigo.equals(other.taiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.taiCodigo != null) ? this.taiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsTipAprIns[ taiCodigo=" + this.taiCodigo + " ]";
	}

}
