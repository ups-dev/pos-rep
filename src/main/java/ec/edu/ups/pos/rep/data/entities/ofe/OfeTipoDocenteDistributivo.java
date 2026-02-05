package ec.edu.ups.pos.rep.data.entities.ofe;

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
@Table(name = "OFE_TIPO_DOCENTE_DISTRIBUTIVO", catalog = "", schema = "OFE")
public class OfeTipoDocenteDistributivo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TDD_CODIGO", nullable = false)
	private Long tddCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "TDD_DESCRIPCION", nullable = false, length = 100)
	private String tddDescripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ofeTipoDocenteDistributivo", fetch = FetchType.LAZY)
	private Collection<OfeDistributivo> ofeDistributivoCollection;

	public OfeTipoDocenteDistributivo() {
	}

	public OfeTipoDocenteDistributivo(Long tddCodigo) {
		this.tddCodigo = tddCodigo;
	}

	public OfeTipoDocenteDistributivo(Long tddCodigo, String tddDescripcion) {
		this.tddCodigo = tddCodigo;
		this.tddDescripcion = tddDescripcion;
	}

	public Long getTddCodigo() {
		return this.tddCodigo;
	}

	public void setTddCodigo(Long tddCodigo) {
		this.tddCodigo = tddCodigo;
	}

	public String getTddDescripcion() {
		return this.tddDescripcion;
	}

	public void setTddDescripcion(String tddDescripcion) {
		this.tddDescripcion = tddDescripcion;
	}

	public Collection<OfeDistributivo> getOfeDistributivoCollection() {
		return this.ofeDistributivoCollection;
	}

	public void setOfeDistributivoCollection(Collection<OfeDistributivo> ofeDistributivoCollection) {
		this.ofeDistributivoCollection = ofeDistributivoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof OfeTipoDocenteDistributivo)) {
			return false;
		}
		OfeTipoDocenteDistributivo other = (OfeTipoDocenteDistributivo) object;
		if ((this.tddCodigo == null && other.tddCodigo != null)
				|| (this.tddCodigo != null && !this.tddCodigo.equals(other.tddCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.tddCodigo != null) ? this.tddCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "OfeTipoDocenteDistributivo[ tddCodigo=" + this.tddCodigo + " ]";
	}

}
