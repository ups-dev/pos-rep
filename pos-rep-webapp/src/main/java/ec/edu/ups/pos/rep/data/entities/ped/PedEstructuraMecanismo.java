package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_ESTRUCTURA_MECANISMO", schema = "PED")
public class PedEstructuraMecanismo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ESM_CODIGO", nullable = false)
	private Long esmCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Column(name = "RES_CODIGO")
	private Long resCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "ESM_ESTADO", nullable = false, length = 1)
	private String esmEstado;

	@JoinColumn(name = "MET_CODIGO", referencedColumnName = "MET_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedMecanismoTitulacion pedMecanismoTitulacion;

	public PedEstructuraMecanismo() {
	}

	public PedEstructuraMecanismo(Long esmCodigo) {
		this.esmCodigo = esmCodigo;
	}

	public PedEstructuraMecanismo(Long esmCodigo, long estCodigo, String esmEstado) {
		this.esmCodigo = esmCodigo;
		this.estCodigo = estCodigo;
		this.esmEstado = esmEstado;
	}

	public Long getEsmCodigo() {
		return this.esmCodigo;
	}

	public void setEsmCodigo(Long esmCodigo) {
		this.esmCodigo = esmCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public String getEsmEstado() {
		return this.esmEstado;
	}

	public void setEsmEstado(String esmEstado) {
		this.esmEstado = esmEstado;
	}

	public PedMecanismoTitulacion getPedMecanismoTitulacion() {
		return this.pedMecanismoTitulacion;
	}

	public void setPedMecanismoTitulacion(PedMecanismoTitulacion pedMecanismoTitulacion) {
		this.pedMecanismoTitulacion = pedMecanismoTitulacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedEstructuraMecanismo)) {
			return false;
		}
		PedEstructuraMecanismo other = (PedEstructuraMecanismo) object;
		if ((this.esmCodigo == null && other.esmCodigo != null)
				|| (this.esmCodigo != null && !this.esmCodigo.equals(other.esmCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.esmCodigo != null) ? this.esmCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedEstructuraMecanismo[ esmCodigo=" + this.esmCodigo + " ]";
	}

}
