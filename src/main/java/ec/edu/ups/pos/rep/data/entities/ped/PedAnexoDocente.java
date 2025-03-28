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
@Table(name = "PED_ANEXO_DOCENTE", schema = "PED")
public class PedAnexoDocente extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "AND_CODIGO", nullable = false)
	private Long andCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "AND_ARCHIVO", nullable = false)
	private byte[] andArchivo;

	@JoinColumn(name = "DPE_CODIGO", referencedColumnName = "DPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedDocenteMalla pedDocenteMalla;

	public PedAnexoDocente() {
	}

	public PedAnexoDocente(Long andCodigo) {
		this.andCodigo = andCodigo;
	}

	public PedAnexoDocente(Long andCodigo, byte[] andArchivo) {
		this.andCodigo = andCodigo;
		this.andArchivo = andArchivo;
	}

	public Long getAndCodigo() {
		return this.andCodigo;
	}

	public void setAndCodigo(Long andCodigo) {
		this.andCodigo = andCodigo;
	}

	public byte[] getAndArchivo() {
		return this.andArchivo;
	}

	public void setAndArchivo(byte[] andArchivo) {
		this.andArchivo = andArchivo;
	}

	public PedDocenteMalla getPedDocenteMalla() {
		return this.pedDocenteMalla;
	}

	public void setPedDocenteMalla(PedDocenteMalla pedDocenteMalla) {
		this.pedDocenteMalla = pedDocenteMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedAnexoDocente)) {
			return false;
		}
		PedAnexoDocente other = (PedAnexoDocente) object;
		if ((this.andCodigo == null && other.andCodigo != null)
				|| (this.andCodigo != null && !this.andCodigo.equals(other.andCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.andCodigo != null) ? this.andCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedAnexoDocente[ andCodigo=" + this.andCodigo + " ]";
	}

}
