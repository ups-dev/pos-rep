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
@Table(name = "PED_MALLA_MODALIDAD", schema = "PED")
public class PedMallaModalidad extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAM_CODIGO", nullable = false)
	private Long mamCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO_INICIAL", nullable = false)
	private Long pelCodigoInicial;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAM_VIGENTE", nullable = false, length = 1)
	private String mamVigente;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@JoinColumn(name = "MOD_CODIGO", referencedColumnName = "MOD_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedModalidad pedModalidad;

	public PedMallaModalidad() {
	}

	public PedMallaModalidad(Long mamCodigo) {
		this.mamCodigo = mamCodigo;
	}

	public PedMallaModalidad(Long mamCodigo, long estCodigo, long pelCodigoInicial, String mamVigente) {
		this.mamCodigo = mamCodigo;
		this.estCodigo = estCodigo;
		this.pelCodigoInicial = pelCodigoInicial;
		this.mamVigente = mamVigente;
	}

	public Long getMamCodigo() {
		return this.mamCodigo;
	}

	public void setMamCodigo(Long mamCodigo) {
		this.mamCodigo = mamCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
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

	public String getMamVigente() {
		return this.mamVigente;
	}

	public void setMamVigente(String mamVigente) {
		this.mamVigente = mamVigente;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public PedModalidad getPedModalidad() {
		return this.pedModalidad;
	}

	public void setPedModalidad(PedModalidad pedModalidad) {
		this.pedModalidad = pedModalidad;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMallaModalidad)) {
			return false;
		}
		PedMallaModalidad other = (PedMallaModalidad) object;
		if ((this.mamCodigo == null && other.mamCodigo != null)
				|| (this.mamCodigo != null && !this.mamCodigo.equals(other.mamCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mamCodigo != null) ? this.mamCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaModalidad[ mamCodigo=" + this.mamCodigo + " ]";
	}

}
