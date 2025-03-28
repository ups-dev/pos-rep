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
@Table(name = "PED_MALLA_CORRELACION", schema = "PED")
public class PedMallaCorrelacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAC_CODIGO", nullable = false)
	private Long macCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAC_TIPO", nullable = false, length = 1)
	private String macTipo;

	@Column(name = "MAC_NIVEL")
	private Long macNivel;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAC_OBLIGATORIO", nullable = false, length = 1)
	private String macObligatorio;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@JoinColumn(name = "MAL_CODIGO_CORRELACION", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMallaCorrelaci;

	public PedMallaCorrelacion() {
	}

	public PedMallaCorrelacion(Long macCodigo) {
		this.macCodigo = macCodigo;
	}

	public PedMallaCorrelacion(Long macCodigo, String macTipo, String macObligatorio) {
		this.macCodigo = macCodigo;
		this.macTipo = macTipo;
		this.macObligatorio = macObligatorio;
	}

	public Long getMacCodigo() {
		return this.macCodigo;
	}

	public void setMacCodigo(Long macCodigo) {
		this.macCodigo = macCodigo;
	}

	public String getMacTipo() {
		return this.macTipo;
	}

	public void setMacTipo(String macTipo) {
		this.macTipo = macTipo;
	}

	public Long getMacNivel() {
		return this.macNivel;
	}

	public void setMacNivel(Long macNivel) {
		this.macNivel = macNivel;
	}

	public String getMacObligatorio() {
		return this.macObligatorio;
	}

	public void setMacObligatorio(String macObligatorio) {
		this.macObligatorio = macObligatorio;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public PedMalla getPedMallaCorrelaci() {
		return this.pedMallaCorrelaci;
	}

	public void setPedMallaCorrelaci(PedMalla pedMallaCorrelaci) {
		this.pedMallaCorrelaci = pedMallaCorrelaci;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMallaCorrelacion)) {
			return false;
		}
		PedMallaCorrelacion other = (PedMallaCorrelacion) object;
		if ((this.macCodigo == null && other.macCodigo != null)
				|| (this.macCodigo != null && !this.macCodigo.equals(other.macCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.macCodigo != null) ? this.macCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaCorrelacion[ macCodigo=" + this.macCodigo + " ]";
	}

}
