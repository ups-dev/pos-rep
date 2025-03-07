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
@Table(name = "PED_COM_INF_ARC", schema = "PED")
public class PedComInfArc extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CIA_CODIGO", nullable = false)
	private Long ciaCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "CIA_ARCHIVO", nullable = false)
	private byte[] ciaArchivo;

	@JoinColumn(name = "TCI_CODIGO", referencedColumnName = "TCI_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedTipComInfPro pedTipComInfPro;

	@JoinColumn(name = "CIE_CODIGO", referencedColumnName = "CIE_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedComInfEmp pedComInfEmp;

	public PedComInfArc() {
	}

	public PedComInfArc(Long ciaCodigo) {
		this.ciaCodigo = ciaCodigo;
	}

	public PedComInfArc(Long ciaCodigo, byte[] ciaArchivo) {
		this.ciaCodigo = ciaCodigo;
		this.ciaArchivo = ciaArchivo;
	}

	public Long getCiaCodigo() {
		return this.ciaCodigo;
	}

	public void setCiaCodigo(Long ciaCodigo) {
		this.ciaCodigo = ciaCodigo;
	}

	public byte[] getCiaArchivo() {
		return this.ciaArchivo;
	}

	public void setCiaArchivo(byte[] ciaArchivo) {
		this.ciaArchivo = ciaArchivo;
	}

	public PedTipComInfPro getPedTipComInfPro() {
		return this.pedTipComInfPro;
	}

	public void setPedTipComInfPro(PedTipComInfPro pedTipComInfPro) {
		this.pedTipComInfPro = pedTipComInfPro;
	}

	public PedComInfEmp getPedComInfEmp() {
		return this.pedComInfEmp;
	}

	public void setPedComInfEmp(PedComInfEmp pedComInfEmp) {
		this.pedComInfEmp = pedComInfEmp;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedComInfArc)) {
			return false;
		}
		PedComInfArc other = (PedComInfArc) object;
		if ((this.ciaCodigo == null && other.ciaCodigo != null)
				|| (this.ciaCodigo != null && !this.ciaCodigo.equals(other.ciaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ciaCodigo != null) ? this.ciaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedComInfArc[ ciaCodigo=" + this.ciaCodigo + " ]";
	}

}
