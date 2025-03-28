package ec.edu.ups.pos.rep.data.entities.ped;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_HIS_PRO_ANA", schema = "PED")
public class PedHisProAna extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "HPA_CODIGO", nullable = false)
	private Long hpaCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO_INICIO", nullable = false)
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@Lob
	@Column(name = "HPA_ARCHIVO")
	private Serializable hpaArchivo;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	public PedHisProAna() {
	}

	public PedHisProAna(Long hpaCodigo) {
		this.hpaCodigo = hpaCodigo;
	}

	public PedHisProAna(Long hpaCodigo, Long pelCodigoInicio, Long pelCodigoFinal) {
		this.hpaCodigo = hpaCodigo;
		this.pelCodigoInicio = pelCodigoInicio;
		this.pelCodigoFinal = pelCodigoFinal;
	}

	public Long getHpaCodigo() {
		return this.hpaCodigo;
	}

	public void setHpaCodigo(Long hpaCodigo) {
		this.hpaCodigo = hpaCodigo;
	}

	public Long getPelCodigoInicio() {
		return this.pelCodigoInicio;
	}

	public void setPelCodigoInicio(Long pelCodigoInicio) {
		this.pelCodigoInicio = pelCodigoInicio;
	}

	public Long getPelCodigoFinal() {
		return this.pelCodigoFinal;
	}

	public void setPelCodigoFinal(Long pelCodigoFinal) {
		this.pelCodigoFinal = pelCodigoFinal;
	}

	public Serializable getHpaArchivo() {
		return this.hpaArchivo;
	}

	public void setHpaArchivo(Serializable hpaArchivo) {
		this.hpaArchivo = hpaArchivo;
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
		if (!(object instanceof PedHisProAna)) {
			return false;
		}
		PedHisProAna other = (PedHisProAna) object;
		if ((this.hpaCodigo == null && other.hpaCodigo != null)
				|| (this.hpaCodigo != null && !this.hpaCodigo.equals(other.hpaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.hpaCodigo != null) ? this.hpaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedHisProAna[ hpaCodigo=" + this.hpaCodigo + " ]";
	}

}
