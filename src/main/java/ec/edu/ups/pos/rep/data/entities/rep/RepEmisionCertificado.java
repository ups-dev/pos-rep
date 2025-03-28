package ec.edu.ups.pos.rep.data.entities.rep;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

/**
 * Description.
 *
 * @author UPS .
 */
@Entity
@Table(name = "REP_EMISION_CERTIFICADO", catalog = "", schema = "REP")
public class RepEmisionCertificado extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "EMC_CODIGO", nullable = false)
	private Long emcCodigo;

	@Column(name = "EMC_NUM_CERTIFICADO")
	private Long emcNumCertificado;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ALU_CODIGO", nullable = false)
	private Long aluCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO", nullable = false)
	private Long pelCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TIC_CODIGO", nullable = false)
	private Long ticCodigo;

	public RepEmisionCertificado() {
	}

	public RepEmisionCertificado(Long emcCodigo) {
		this.emcCodigo = emcCodigo;
	}

	public RepEmisionCertificado(Long emcCodigo, Long emcNumCertificado, Long aluCodigo, Long pelCodigo, Long estCodigo,
			Long ticCodigo) {
		this.emcCodigo = emcCodigo;
		this.emcNumCertificado = emcNumCertificado;
		this.aluCodigo = aluCodigo;
		this.pelCodigo = pelCodigo;
		this.estCodigo = estCodigo;
		this.ticCodigo = ticCodigo;
	}

	public Long getEmcCodigo() {
		return this.emcCodigo;
	}

	public void setEmcCodigo(Long emcCodigo) {
		this.emcCodigo = emcCodigo;
	}

	public Long getEmcNumCertificado() {
		return this.emcNumCertificado;
	}

	public void setEmcNumCertificado(Long emcNumCertificado) {
		this.emcNumCertificado = emcNumCertificado;
	}

	public Long getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getTicCodigo() {
		return this.ticCodigo;
	}

	public void setTicCodigo(Long ticCodigo) {
		this.ticCodigo = ticCodigo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RepEmisionCertificado)) {
			return false;
		}
		RepEmisionCertificado other = (RepEmisionCertificado) object;
		if ((this.emcCodigo == null && other.emcCodigo != null)
				|| (this.emcCodigo != null && !this.emcCodigo.equals(other.emcCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.emcCodigo != null) ? this.emcCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepEmisionCertificado[ emcCodigo=" + this.emcCodigo + " ]";
	}

}
