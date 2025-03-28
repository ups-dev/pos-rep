package ec.edu.ups.pos.rep.data.entities.ped;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIPO_PROYECTO_ARCHIVO", schema = "PED")
public class PedTipoProyectoArchivo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TPA_CODIGO", nullable = false)
	private Long tpaCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "TPA_ARCHIVO", nullable = false)
	private Serializable tpaArchivo;

	@JoinColumn(name = "TTP_CODIGO", referencedColumnName = "TTP_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedTptTipProEdu pedTptTipProEdu;

	public PedTipoProyectoArchivo() {
	}

	public PedTipoProyectoArchivo(Long tpaCodigo) {
		this.tpaCodigo = tpaCodigo;
	}

	public PedTipoProyectoArchivo(Long tpaCodigo, Serializable tpaArchivo) {
		this.tpaCodigo = tpaCodigo;
		this.tpaArchivo = tpaArchivo;
	}

	public Long getTpaCodigo() {
		return this.tpaCodigo;
	}

	public void setTpaCodigo(Long tpaCodigo) {
		this.tpaCodigo = tpaCodigo;
	}

	public Serializable getTpaArchivo() {
		return this.tpaArchivo;
	}

	public void setTpaArchivo(Serializable tpaArchivo) {
		this.tpaArchivo = tpaArchivo;
	}

	public PedTptTipProEdu getPedTptTipProEdu() {
		return this.pedTptTipProEdu;
	}

	public void setPedTptTipProEdu(PedTptTipProEdu pedTptTipProEdu) {
		this.pedTptTipProEdu = pedTptTipProEdu;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoProyectoArchivo)) {
			return false;
		}
		PedTipoProyectoArchivo other = (PedTipoProyectoArchivo) object;
		if ((this.tpaCodigo == null && other.tpaCodigo != null)
				|| (this.tpaCodigo != null && !this.tpaCodigo.equals(other.tpaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tpaCodigo != null) ? this.tpaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoProyectoArchivo[ tpaCodigo=" + this.tpaCodigo + " ]";
	}

}
