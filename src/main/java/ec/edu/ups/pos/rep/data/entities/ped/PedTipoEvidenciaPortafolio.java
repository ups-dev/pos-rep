package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIPO_EVIDENCIA_PORTAFOLIO", schema = "PED")
public class PedTipoEvidenciaPortafolio extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TEP_CODIGO", nullable = false, updatable = false)
	private Long tepCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TEP_DESCRIPCION", nullable = false, length = 200)
	private String tepDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoEvidenciaPortafolio")
	private Collection<PedEvidenciaPortafolioMalla> pedEvidenciaPortafolioMallaCollection;

	public PedTipoEvidenciaPortafolio() {
	}

	public PedTipoEvidenciaPortafolio(Long tepCodigo) {
		this.tepCodigo = tepCodigo;
	}

	public PedTipoEvidenciaPortafolio(Long tepCodigo, String tepDescripcion) {
		this.tepCodigo = tepCodigo;
		this.tepDescripcion = tepDescripcion;
	}

	public Long getTepCodigo() {
		return this.tepCodigo;
	}

	public void setTepCodigo(Long tepCodigo) {
		this.tepCodigo = tepCodigo;
	}

	public String getTepDescripcion() {
		return this.tepDescripcion;
	}

	public void setTepDescripcion(String tepDescripcion) {
		this.tepDescripcion = tepDescripcion;
	}

	public Collection<PedEvidenciaPortafolioMalla> getPedEvidenciaPortafolioMallaCollection() {
		return this.pedEvidenciaPortafolioMallaCollection;
	}

	public void setPedEvidenciaPortafolioMallaCollection(
			Collection<PedEvidenciaPortafolioMalla> pedEvidenciaPortafolioMallaCollection) {
		this.pedEvidenciaPortafolioMallaCollection = pedEvidenciaPortafolioMallaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoEvidenciaPortafolio)) {
			return false;
		}
		PedTipoEvidenciaPortafolio other = (PedTipoEvidenciaPortafolio) object;
		if ((this.tepCodigo == null && other.tepCodigo != null)
				|| (this.tepCodigo != null && !this.tepCodigo.equals(other.tepCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tepCodigo != null) ? this.tepCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoEvidenciaPortafolio[ tepCodigo=" + this.tepCodigo + " ]";
	}

}
