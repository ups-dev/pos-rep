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
@Table(name = "PED_MALLA_PERIODO_HABILITANTE", schema = "PED")
public class PedMallaPeriodoHabilitante extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MPH_CODIGO", nullable = false)
	private Long mphCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO_INICIAL", nullable = false)
	private Long pelCodigoInicial;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	public PedMallaPeriodoHabilitante() {
	}

	public PedMallaPeriodoHabilitante(Long mphCodigo) {
		this.mphCodigo = mphCodigo;
	}

	public PedMallaPeriodoHabilitante(Long mphCodigo, Long pelCodigoInicial) {
		this.mphCodigo = mphCodigo;
		this.pelCodigoInicial = pelCodigoInicial;
	}

	public Long getMphCodigo() {
		return this.mphCodigo;
	}

	public void setMphCodigo(Long mphCodigo) {
		this.mphCodigo = mphCodigo;
	}

	public Long getPelCodigoInicial() {
		return this.pelCodigoInicial;
	}

	public void setPelCodigoInicial(Long pelCodigoInicial) {
		this.pelCodigoInicial = pelCodigoInicial;
	}

	public Long getPelCodigoFinal() {
		return this.pelCodigoFinal;
	}

	public void setPelCodigoFinal(Long pelCodigoFinal) {
		this.pelCodigoFinal = pelCodigoFinal;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMallaPeriodoHabilitante)) {
			return false;
		}
		PedMallaPeriodoHabilitante other = (PedMallaPeriodoHabilitante) object;
		if ((this.mphCodigo == null && other.mphCodigo != null)
				|| (this.mphCodigo != null && !this.mphCodigo.equals(other.mphCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mphCodigo != null) ? this.mphCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaPeriodoHabilitante[ mphCodigo=" + this.mphCodigo + " ]";
	}

}
