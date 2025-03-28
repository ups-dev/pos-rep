package ec.edu.ups.pos.rep.data.entities.sol;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "SOL_SOLICITUD_PDF", schema = "SOL")
public class SolSolicitudPdf extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "SOL_CODIGO", nullable = false, precision = 0, scale = -127)
	private Long solCodigo;

	@Basic(optional = false, fetch = FetchType.LAZY)
	@NotNull
	@Lob
	@Column(name = "SOP_PDF", nullable = false)
	private byte[] sopPdf;

	@JoinColumn(name = "SOL_CODIGO", referencedColumnName = "SOL_CODIGO", nullable = false, insertable = false,
			updatable = false)
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private SolSolicitud solSolicitud;

	public SolSolicitudPdf() {
	}

	public SolSolicitudPdf(Long solCodigo) {
		this.solCodigo = solCodigo;
	}

	public Long getSolCodigo() {
		return this.solCodigo;
	}

	public void setSolCodigo(Long solCodigo) {
		this.solCodigo = solCodigo;
	}

	public byte[] getSopPdf() {
		return this.sopPdf;
	}

	public void setSopPdf(byte[] sopPdf) {
		this.sopPdf = sopPdf;
	}

	public SolSolicitud getSolSolicitud() {
		return this.solSolicitud;
	}

	public void setSolSolicitud(SolSolicitud solSolicitud) {
		this.solSolicitud = solSolicitud;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SolSolicitudPdf)) {
			return false;
		}
		SolSolicitudPdf other = (SolSolicitudPdf) object;
		if ((this.solCodigo == null && other.solCodigo != null)
				|| (this.solCodigo != null && !this.solCodigo.equals(other.solCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.solCodigo != null) ? this.solCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "SolSolicitudPdf[ solCodigo=" + this.solCodigo + " ]";
	}

}
