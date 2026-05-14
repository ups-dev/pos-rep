package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIPO_CAMPO_CONOCIMIENTO", schema = "PED")
public class PedTipoCampoConocimiento extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TCC_CODIGO", nullable = false)
	private Long tccCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TCC_DESCRIPCION", nullable = false, length = 200)
	private String tccDescripcion;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TCC_NIVEL", nullable = false)
	private Integer tccNivel;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoCampoConocimiento", fetch = FetchType.LAZY)
	private Collection<PedCampoConocimiento> pedCampoConocimientoCollection;

	public PedTipoCampoConocimiento() {
	}

	public PedTipoCampoConocimiento(Long tccCodigo) {
		this.tccCodigo = tccCodigo;
	}

	public PedTipoCampoConocimiento(Long tccCodigo, String tccDescripcion, Integer tccNivel) {
		this.tccCodigo = tccCodigo;
		this.tccDescripcion = tccDescripcion;
		this.tccNivel = tccNivel;
	}

	public Long getTccCodigo() {
		return this.tccCodigo;
	}

	public void setTccCodigo(Long tccCodigo) {
		this.tccCodigo = tccCodigo;
	}

	public String getTccDescripcion() {
		return this.tccDescripcion;
	}

	public void setTccDescripcion(String tccDescripcion) {
		this.tccDescripcion = tccDescripcion;
	}

	public Integer getTccNivel() {
		return this.tccNivel;
	}

	public void setTccNivel(Integer tccNivel) {
		this.tccNivel = tccNivel;
	}

	public Collection<PedCampoConocimiento> getPedCampoConocimientoCollection() {
		return this.pedCampoConocimientoCollection;
	}

	public void setPedCampoConocimientoCollection(Collection<PedCampoConocimiento> pedCampoConocimientoCollection) {
		this.pedCampoConocimientoCollection = pedCampoConocimientoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoCampoConocimiento)) {
			return false;
		}
		PedTipoCampoConocimiento other = (PedTipoCampoConocimiento) object;
		if ((this.tccCodigo == null && other.tccCodigo != null)
				|| (this.tccCodigo != null && !this.tccCodigo.equals(other.tccCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tccCodigo != null) ? this.tccCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoCampoConocimiento[ tccCodigo=" + this.tccCodigo + " ]";
	}

}
