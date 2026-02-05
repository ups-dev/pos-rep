package ec.edu.ups.pos.rep.data.entities.rep;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "REP_NUMERO_CERTIFICADO", catalog = "", schema = "REP")
public class RepNumeroCertificado extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "NCE_CODIGO", nullable = false)
	private Long nceCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO", nullable = false)
	private Long pelCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TIC_CODIGO", nullable = false)
	private Long ticCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "NCE_NUMERO_CERTIFICADO", nullable = false)
	private Long nceNumeroCertificado;

	@Column(name = "NCE_ANIO", nullable = true)
	private Long nceAnio;

	public RepNumeroCertificado() {
	}

	public RepNumeroCertificado(Long nceCodigo) {
		this.nceCodigo = nceCodigo;
	}

	public RepNumeroCertificado(Long nceCodigo, Long estCodigo, Long pelCodigo, Long ticCodigo,
			Long nceNumeroCertificado) {
		this.nceCodigo = nceCodigo;
		this.estCodigo = estCodigo;
		this.pelCodigo = pelCodigo;
		this.ticCodigo = ticCodigo;
		this.nceNumeroCertificado = nceNumeroCertificado;
	}

	public Long getNceCodigo() {
		return this.nceCodigo;
	}

	public void setNceCodigo(Long nceCodigo) {
		this.nceCodigo = nceCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getTicCodigo() {
		return this.ticCodigo;
	}

	public void setTicCodigo(Long ticCodigo) {
		this.ticCodigo = ticCodigo;
	}

	public Long getNceNumeroCertificado() {
		return this.nceNumeroCertificado;
	}

	public void setNceNumeroCertificado(Long nceNumeroCertificado) {
		this.nceNumeroCertificado = nceNumeroCertificado;
	}

	public Long getNceAnio() {
		return this.nceAnio;
	}

	public void setNceAnio(Long nceAnio) {
		this.nceAnio = nceAnio;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RepNumeroCertificado)) {
			return false;
		}
		RepNumeroCertificado other = (RepNumeroCertificado) object;
		if ((this.nceCodigo == null && other.nceCodigo != null)
				|| (this.nceCodigo != null && !this.nceCodigo.equals(other.nceCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.nceCodigo != null) ? this.nceCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepNumeroCertificado[ nceCodigo=" + this.nceCodigo + " ]";
	}

}
