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
@Table(name = "PED_TIPO_TITULACION_ARCHIVO", schema = "PED")
public class PedTipoTitulacionArchivo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TTA_CODIGO", nullable = false)
	private Long ttaCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "TTA_ARCHIVO", nullable = false)
	private byte[] ttaArchivo;

	@JoinColumn(name = "TTT_CODIGO", referencedColumnName = "TTT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTptTipTit pedTptTipTit;

	public PedTipoTitulacionArchivo() {
	}

	public PedTipoTitulacionArchivo(Long ttaCodigo) {
		this.ttaCodigo = ttaCodigo;
	}

	public PedTipoTitulacionArchivo(Long ttaCodigo, byte[] ttaArchivo) {
		this.ttaCodigo = ttaCodigo;
		this.ttaArchivo = ttaArchivo;
	}

	public Long getTtaCodigo() {
		return this.ttaCodigo;
	}

	public void setTtaCodigo(Long ttaCodigo) {
		this.ttaCodigo = ttaCodigo;
	}

	public byte[] getTtaArchivo() {
		return this.ttaArchivo;
	}

	public void setTtaArchivo(byte[] ttaArchivo) {
		this.ttaArchivo = ttaArchivo;
	}

	public PedTptTipTit getPedTptTipTit() {
		return this.pedTptTipTit;
	}

	public void setPedTptTipTit(PedTptTipTit pedTptTipTit) {
		this.pedTptTipTit = pedTptTipTit;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoTitulacionArchivo)) {
			return false;
		}
		PedTipoTitulacionArchivo other = (PedTipoTitulacionArchivo) object;
		if ((this.ttaCodigo == null && other.ttaCodigo != null)
				|| (this.ttaCodigo != null && !this.ttaCodigo.equals(other.ttaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ttaCodigo != null) ? this.ttaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoTitulacionArchivo[ ttaCodigo=" + this.ttaCodigo + " ]";
	}

}
