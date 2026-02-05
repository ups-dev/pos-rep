package ec.edu.ups.pos.rep.data.entities.ped;

import java.io.Serializable;

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
@Table(name = "PED_ARCHIVO_ANEXO", schema = "PED")
public class PedArchivoAnexo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PPE_CODIGO", nullable = false, updatable = false)
	private Long ppeCodigo;

	@Lob
	@Column(name = "ARA_ARCHIVO")
	private Serializable araArchivo;

	@JoinColumn(name = "PPE_CODIGO", referencedColumnName = "PPE_CODIGO", nullable = false, insertable = false,
			updatable = false)
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private PedParProEdu pedParProEdu;

	public PedArchivoAnexo() {
	}

	public PedArchivoAnexo(Long ppeCodigo) {
		this.ppeCodigo = ppeCodigo;
	}

	public Long getPpeCodigo() {
		return this.ppeCodigo;
	}

	public void setPpeCodigo(Long ppeCodigo) {
		this.ppeCodigo = ppeCodigo;
	}

	public Serializable getAraArchivo() {
		return this.araArchivo;
	}

	public void setAraArchivo(Serializable araArchivo) {
		this.araArchivo = araArchivo;
	}

	public PedParProEdu getPedParProEdu() {
		return this.pedParProEdu;
	}

	public void setPedParProEdu(PedParProEdu pedParProEdu) {
		this.pedParProEdu = pedParProEdu;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedArchivoAnexo)) {
			return false;
		}
		PedArchivoAnexo other = (PedArchivoAnexo) object;
		if ((this.ppeCodigo == null && other.ppeCodigo != null)
				|| (this.ppeCodigo != null && !this.ppeCodigo.equals(other.ppeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ppeCodigo != null) ? this.ppeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedArchivoAnexo[ ppeCodigo=" + this.ppeCodigo + " ]";
	}

}
