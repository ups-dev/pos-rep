package ec.edu.ups.pos.rep.data.entities.ins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_INSCRIPCION_ETAPA", schema = "INS")
@SequenceGenerator(name = "INS_INSCRIPCION_ETAPA_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsInscripcionEtapa extends EntitySuperclass {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_INSCRIPCION_ETAPA_SQ")
	@NotNull
	@Column(name = "INE_CODIGO", nullable = false)
	private Long ineCodigo;

	@NotNull
	@Column(name = "INE_ESTADO", length = 1, nullable = false)
	private String ineEstado;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "INS_CODIGO_INICIAL", nullable = false)
	private InsInscripcion insCodigoInicial;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "INS_CODIGO_ETAPA", nullable = false)
	private InsInscripcion insCodigoEtapa;

	public InsInscripcion getInsCodigoEtapa() {
		return this.insCodigoEtapa;
	}

	public void setInsCodigoEtapa(InsInscripcion insCodigoEtapa) {
		this.insCodigoEtapa = insCodigoEtapa;
	}

	public InsInscripcion getInsCodigoInicial() {
		return this.insCodigoInicial;
	}

	public void setInsCodigoInicial(InsInscripcion insCodigoInicial) {
		this.insCodigoInicial = insCodigoInicial;
	}

	public String getIneEstado() {
		return this.ineEstado;
	}

	public void setIneEstado(String ineEstado) {
		this.ineEstado = ineEstado;
	}

	public Long getIneCodigo() {
		return this.ineCodigo;
	}

	public void setIneCodigo(Long ineCodigo) {
		this.ineCodigo = ineCodigo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsInscripcionEtapa)) {
			return false;
		}
		InsInscripcionEtapa other = (InsInscripcionEtapa) object;
		if ((this.ineCodigo == null && other.ineCodigo != null)
				|| (this.ineCodigo != null && !this.ineCodigo.equals(other.ineCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ineCodigo != null) ? this.ineCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsInscripcionEtapa[ ineCodigo=" + this.ineCodigo + " ]";
	}

}
