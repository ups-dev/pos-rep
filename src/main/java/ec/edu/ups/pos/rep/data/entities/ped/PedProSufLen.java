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
@Table(name = "PED_PRO_SUF_LEN", schema = "PED")
public class PedProSufLen extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PSL_CODIGO", nullable = false)
	private Long pslCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PSL_NIVEL", nullable = false)
	private Integer pslNivel;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	@JoinColumn(name = "MAT_CODIGO", referencedColumnName = "MAT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMateria pedMateria;

	public PedProSufLen() {
	}

	public PedProSufLen(Long pslCodigo) {
		this.pslCodigo = pslCodigo;
	}

	public PedProSufLen(Long pslCodigo, Integer pslNivel) {
		this.pslCodigo = pslCodigo;
		this.pslNivel = pslNivel;
	}

	public Long getPslCodigo() {
		return this.pslCodigo;
	}

	public void setPslCodigo(Long pslCodigo) {
		this.pslCodigo = pslCodigo;
	}

	public Integer getPslNivel() {
		return this.pslNivel;
	}

	public void setPslNivel(Integer pslNivel) {
		this.pslNivel = pslNivel;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	public PedMateria getPedMateria() {
		return this.pedMateria;
	}

	public void setPedMateria(PedMateria pedMateria) {
		this.pedMateria = pedMateria;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedProSufLen)) {
			return false;
		}
		PedProSufLen other = (PedProSufLen) object;
		if ((this.pslCodigo == null && other.pslCodigo != null)
				|| (this.pslCodigo != null && !this.pslCodigo.equals(other.pslCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.pslCodigo != null) ? this.pslCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedProSufLen[ pslCodigo=" + this.pslCodigo + " ]";
	}

}
