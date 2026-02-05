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
@Table(name = "PED_TITULO", schema = "PED")
public class PedTitulo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIT_CODIGO", nullable = false, updatable = false)
	private Long titCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "TIT_DESCRIPCION", nullable = false, length = 250)
	private String titDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIT_GENERO", nullable = false, length = 1)
	private String titGenero;

	@Size(min = 1, max = 10)
	@Column(name = "TIT_SIGLA", length = 10)
	private String titSigla;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIT_NIVEL_TITULO", nullable = false, length = 1)
	private String titNivelTitulo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIT_VIGENCIA", nullable = false, length = 1)
	private String titVigencia;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIT_NIVEL_POSTGRADO", nullable = false, length = 1)
	private String titNivelPostgrado;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTitulo")
	private Collection<PedProEduTit> pedProEduTitCollection;

	public PedTitulo() {
	}

	public PedTitulo(Long titCodigo) {
		this.titCodigo = titCodigo;
	}

	public PedTitulo(Long titCodigo, String titDescripcion, String titGenero) {
		this.titCodigo = titCodigo;
		this.titDescripcion = titDescripcion;
		this.titGenero = titGenero;
	}

	public Long getTitCodigo() {
		return this.titCodigo;
	}

	public void setTitCodigo(Long titCodigo) {
		this.titCodigo = titCodigo;
	}

	public String getTitDescripcion() {
		return this.titDescripcion;
	}

	public void setTitDescripcion(String titDescripcion) {
		this.titDescripcion = titDescripcion;
	}

	public String getTitGenero() {
		return this.titGenero;
	}

	public void setTitGenero(String titGenero) {
		this.titGenero = titGenero;
	}

	public String getTitSigla() {
		return this.titSigla;
	}

	public void setTitSigla(String titSigla) {
		this.titSigla = titSigla;
	}

	public String getTitNivelTitulo() {
		return this.titNivelTitulo;
	}

	public void setTitNivelTitulo(String titNivelTitulo) {
		this.titNivelTitulo = titNivelTitulo;
	}

	public String getTitVigencia() {
		return this.titVigencia;
	}

	public void setTitVigencia(String titVigencia) {
		this.titVigencia = titVigencia;
	}

	public String getTitNivelPostgrado() {
		return this.titNivelPostgrado;
	}

	public void setTitNivelPostgrado(String titNivelPostgrado) {
		this.titNivelPostgrado = titNivelPostgrado;
	}

	public Collection<PedProEduTit> getPedProEduTitCollection() {
		return this.pedProEduTitCollection;
	}

	public void setPedProEduTitCollection(Collection<PedProEduTit> pedProEduTitCollection) {
		this.pedProEduTitCollection = pedProEduTitCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTitulo)) {
			return false;
		}
		PedTitulo other = (PedTitulo) object;
		if ((this.titCodigo == null && other.titCodigo != null)
				|| (this.titCodigo != null && !this.titCodigo.equals(other.titCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.titCodigo != null) ? this.titCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTitulo[ titCodigo=" + this.titCodigo + " ]";
	}

}
