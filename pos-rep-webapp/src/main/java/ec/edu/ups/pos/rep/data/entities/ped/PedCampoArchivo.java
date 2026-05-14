package ec.edu.ups.pos.rep.data.entities.ped;

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
@Table(name = "PED_CAMPO_ARCHIVO", schema = "PED")
public class PedCampoArchivo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CAA_CODIGO", nullable = false)
	private Long caaCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "CAA_ARCHIVO", nullable = false)
	private byte[] caaArchivo;

	@JoinColumn(name = "TCC_CODIGO", referencedColumnName = "TCC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTpcCamCon pedTpcCamCon;

	public PedCampoArchivo() {
	}

	public PedCampoArchivo(Long caaCodigo) {
		this.caaCodigo = caaCodigo;
	}

	public PedCampoArchivo(Long caaCodigo, byte[] caaArchivo) {
		this.caaCodigo = caaCodigo;
		this.caaArchivo = caaArchivo;
	}

	public Long getCaaCodigo() {
		return this.caaCodigo;
	}

	public void setCaaCodigo(Long caaCodigo) {
		this.caaCodigo = caaCodigo;
	}

	public byte[] getCaaArchivo() {
		return this.caaArchivo;
	}

	public void setCaaArchivo(byte[] caaArchivo) {
		this.caaArchivo = caaArchivo;
	}

	public PedTpcCamCon getPedTpcCamCon() {
		return this.pedTpcCamCon;
	}

	public void setPedTpcCamCon(PedTpcCamCon pedTpcCamCon) {
		this.pedTpcCamCon = pedTpcCamCon;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCampoArchivo)) {
			return false;
		}
		PedCampoArchivo other = (PedCampoArchivo) object;
		if ((this.caaCodigo == null && other.caaCodigo != null)
				|| (this.caaCodigo != null && !this.caaCodigo.equals(other.caaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.caaCodigo != null) ? this.caaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCampoArchivo[ caaCodigo=" + this.caaCodigo + " ]";
	}

}
