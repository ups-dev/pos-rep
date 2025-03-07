package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MATERIA", schema = "PED")
public class PedMateria extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAT_CODIGO", nullable = false, updatable = false)
	private Long matCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "MAT_DESCRIPCION", nullable = false, length = 300)
	private String matDescripcion;

	@Size(max = 10)
	@Column(name = "MAT_ABREVIATURA", length = 10)
	private String matAbreviatura;

	@Column(name = "MAT_CODIGO_LEG")
	private Long matCodigoLeg;

	@Size(max = 300)
	@Column(name = "MAT_DESCRIPCION_LEGAL", length = 300)
	private String matDescripcionLegal;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAT_VIGENTE", nullable = false, length = 1)
	private String matVigente;

	@Column(name = "CUP_CODIGO_LEG")
	private Long cupCodigoLeg;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMateria")
	private Collection<PedMalla> pedMallaCollection;

	@OneToMany(mappedBy = "pedMateriaPadre")
	private Collection<PedMateria> pedMateriaCollection;

	@JoinColumn(name = "TIM_CODIGO", referencedColumnName = "TIM_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoMateria pedTipoMateria;

	@JoinColumn(name = "MAT_CODIGO_PADRE", referencedColumnName = "MAT_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedMateria pedMateriaPadre;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedMateria", fetch = FetchType.LAZY)
	private Collection<PedProSufLen> pedProSufLenCollection;

	public PedMateria() {
	}

	public PedMateria(Long matCodigo) {
		this.matCodigo = matCodigo;
	}

	public PedMateria(Long matCodigo, String matDescripcion, String matVigente) {
		this.matCodigo = matCodigo;
		this.matDescripcion = matDescripcion;
		this.matVigente = matVigente;
	}

	public Long getMatCodigo() {
		return this.matCodigo;
	}

	public void setMatCodigo(Long matCodigo) {
		this.matCodigo = matCodigo;
	}

	public String getMatDescripcion() {
		return this.matDescripcion;
	}

	public void setMatDescripcion(String matDescripcion) {
		this.matDescripcion = matDescripcion;
	}

	public String getMatAbreviatura() {
		return this.matAbreviatura;
	}

	public void setMatAbreviatura(String matAbreviatura) {
		this.matAbreviatura = matAbreviatura;
	}

	public Long getMatCodigoLeg() {
		return this.matCodigoLeg;
	}

	public void setMatCodigoLeg(Long matCodigoLeg) {
		this.matCodigoLeg = matCodigoLeg;
	}

	public String getMatDescripcionLegal() {
		return this.matDescripcionLegal;
	}

	public void setMatDescripcionLegal(String matDescripcionLegal) {
		this.matDescripcionLegal = matDescripcionLegal;
	}

	public String getMatVigente() {
		return this.matVigente;
	}

	public void setMatVigente(String matVigente) {
		this.matVigente = matVigente;
	}

	public Long getCupCodigoLeg() {
		return this.cupCodigoLeg;
	}

	public void setCupCodigoLeg(Long cupCodigoLeg) {
		this.cupCodigoLeg = cupCodigoLeg;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
	}

	public Collection<PedMateria> getPedMateriaCollection() {
		return this.pedMateriaCollection;
	}

	public void setPedMateriaCollection(Collection<PedMateria> pedMateriaCollection) {
		this.pedMateriaCollection = pedMateriaCollection;
	}

	public PedTipoMateria getPedTipoMateria() {
		return this.pedTipoMateria;
	}

	public void setPedTipoMateria(PedTipoMateria pedTipoMateria) {
		this.pedTipoMateria = pedTipoMateria;
	}

	public PedMateria getPedMateriaPadre() {
		return this.pedMateriaPadre;
	}

	public void setPedMateriaPadre(PedMateria pedMateriaPadre) {
		this.pedMateriaPadre = pedMateriaPadre;
	}

	public Collection<PedProSufLen> getPedProSufLenCollection() {
		return this.pedProSufLenCollection;
	}

	public void setPedProSufLenCollection(Collection<PedProSufLen> pedProSufLenCollection) {
		this.pedProSufLenCollection = pedProSufLenCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMateria)) {
			return false;
		}
		PedMateria other = (PedMateria) object;
		if ((this.matCodigo == null && other.matCodigo != null)
				|| (this.matCodigo != null && !this.matCodigo.equals(other.matCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.matCodigo != null) ? this.matCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMateria[ matCodigo=" + this.matCodigo + " ]";
	}

}
