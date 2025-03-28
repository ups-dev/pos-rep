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
@Table(name = "PED_PARAMETRO_DETALLE", schema = "PED")
public class PedParametroDetalle extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PAD_CODIGO", nullable = false)
	private Long padCodigo;

	@Column(name = "PAD_NUM_HORAS_PER_EXT")
	private Integer padNumHorasPerExt;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2)
	@Column(name = "PAD_TIPO", nullable = false, length = 2)
	private String padTipo;

	@JoinColumn(name = "PPE_CODIGO", referencedColumnName = "PPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedParProEdu pedParProEdu;

	public PedParametroDetalle() {
	}

	public PedParametroDetalle(Long padCodigo) {
		this.padCodigo = padCodigo;
	}

	public PedParametroDetalle(Long padCodigo, String padTipo) {
		this.padCodigo = padCodigo;
		this.padTipo = padTipo;
	}

	public Long getPadCodigo() {
		return this.padCodigo;
	}

	public void setPadCodigo(Long padCodigo) {
		this.padCodigo = padCodigo;
	}

	public Integer getPadNumHorasPerExt() {
		return this.padNumHorasPerExt;
	}

	public void setPadNumHorasPerExt(Integer padNumHorasPerExt) {
		this.padNumHorasPerExt = padNumHorasPerExt;
	}

	public String getPadTipo() {
		return this.padTipo;
	}

	public void setPadTipo(String padTipo) {
		this.padTipo = padTipo;
	}

	public PedParProEdu getPedParProEdu() {
		return this.pedParProEdu;
	}

	public void setPedParProEdu(PedParProEdu pedParProEdu) {
		this.pedParProEdu = pedParProEdu;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedParametroDetalle)) {
			return false;
		}
		PedParametroDetalle other = (PedParametroDetalle) object;
		if ((this.padCodigo == null && other.padCodigo != null)
				|| (this.padCodigo != null && !this.padCodigo.equals(other.padCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.padCodigo != null) ? this.padCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedParametroDetalle[ padCodigo=" + this.padCodigo + " ]";
	}

}
