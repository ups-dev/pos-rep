package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_PRO_EDU_TIT", schema = "PED")
public class PedProEduTit extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PET_CODIGO", nullable = false, updatable = false)
	private Long petCodigo;

	@JoinColumn(name = "TIT_CODIGO", referencedColumnName = "TIT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTitulo pedTitulo;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	public PedProEduTit() {
	}

	public PedProEduTit(Long petCodigo) {
		this.petCodigo = petCodigo;
	}

	public Long getPetCodigo() {
		return this.petCodigo;
	}

	public void setPetCodigo(Long petCodigo) {
		this.petCodigo = petCodigo;
	}

	public PedTitulo getPedTitulo() {
		return this.pedTitulo;
	}

	public void setPedTitulo(PedTitulo pedTitulo) {
		this.pedTitulo = pedTitulo;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedProEduTit)) {
			return false;
		}
		PedProEduTit other = (PedProEduTit) object;
		if ((this.petCodigo == null && other.petCodigo != null)
				|| (this.petCodigo != null && !this.petCodigo.equals(other.petCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.petCodigo != null) ? this.petCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedProEduTit[ petCodigo=" + this.petCodigo + " ]";
	}

}
