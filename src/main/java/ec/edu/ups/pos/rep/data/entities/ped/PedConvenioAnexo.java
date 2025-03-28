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
@Table(name = "PED_CONVENIO_ANEXO", schema = "PED")
public class PedConvenioAnexo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COA_CODIGO", nullable = false)
	private Long coaCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "COA_ARCHIVO", nullable = false)
	private byte[] coaArchivo;

	@JoinColumn(name = "CON_CODIGO", referencedColumnName = "CON_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedConvenio pedConvenio;

	public PedConvenioAnexo() {
	}

	public PedConvenioAnexo(Long coaCodigo) {
		this.coaCodigo = coaCodigo;
	}

	public PedConvenioAnexo(Long coaCodigo, byte[] coaArchivo) {
		this.coaCodigo = coaCodigo;
		this.coaArchivo = coaArchivo;
	}

	public Long getCoaCodigo() {
		return this.coaCodigo;
	}

	public void setCoaCodigo(Long coaCodigo) {
		this.coaCodigo = coaCodigo;
	}

	public byte[] getCoaArchivo() {
		return this.coaArchivo;
	}

	public void setCoaArchivo(byte[] coaArchivo) {
		this.coaArchivo = coaArchivo;
	}

	public PedConvenio getPedConvenio() {
		return this.pedConvenio;
	}

	public void setPedConvenio(PedConvenio pedConvenio) {
		this.pedConvenio = pedConvenio;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedConvenioAnexo)) {
			return false;
		}
		PedConvenioAnexo other = (PedConvenioAnexo) object;
		if ((this.coaCodigo == null && other.coaCodigo != null)
				|| (this.coaCodigo != null && !this.coaCodigo.equals(other.coaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.coaCodigo != null) ? this.coaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedConvenioAnexo[ coaCodigo=" + this.coaCodigo + " ]";
	}

}
