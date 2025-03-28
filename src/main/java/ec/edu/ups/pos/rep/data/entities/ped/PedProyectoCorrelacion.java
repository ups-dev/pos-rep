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
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_PROYECTO_CORRELACION", schema = "PED")
public class PedProyectoCorrelacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRC_CODIGO", nullable = false)
	private Long prcCodigo;

	@Size(max = 1)
	@Column(name = "PRC_VIGENTE", length = 1)
	private String prcVigente;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	@JoinColumn(name = "PRE_NUMERO_CORRELACION", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacionCorrelacion;

	public PedProyectoCorrelacion() {
	}

	public PedProyectoCorrelacion(Long prcCodigo) {
		this.prcCodigo = prcCodigo;
	}

	public PedProyectoCorrelacion(Long prcCodigo, String prcVigente) {
		this.prcCodigo = prcCodigo;
		this.prcVigente = prcVigente;
	}

	public Long getPrcCodigo() {
		return this.prcCodigo;
	}

	public void setPrcCodigo(Long prcCodigo) {
		this.prcCodigo = prcCodigo;
	}

	public String getPrcVigente() {
		return this.prcVigente;
	}

	public void setPrcVigente(String prcVigente) {
		this.prcVigente = prcVigente;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	public PedProyectoEducacion getPedProyectoEducacionCorrelacion() {
		return this.pedProyectoEducacionCorrelacion;
	}

	public void setPedProyectoEducacionCorrelacion(PedProyectoEducacion pedProyectoEducacionCorrelacion) {
		this.pedProyectoEducacionCorrelacion = pedProyectoEducacionCorrelacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedProyectoCorrelacion)) {
			return false;
		}
		PedProyectoCorrelacion other = (PedProyectoCorrelacion) object;
		if ((this.prcCodigo == null && other.prcCodigo != null)
				|| (this.prcCodigo != null && !this.prcCodigo.equals(other.prcCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.prcCodigo != null) ? this.prcCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedProyectoCorrelacion[ prcCodigo=" + this.prcCodigo + " ]";
	}

}
