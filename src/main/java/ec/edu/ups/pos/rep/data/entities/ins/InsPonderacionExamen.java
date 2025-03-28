package ec.edu.ups.pos.rep.data.entities.ins;

import java.math.BigDecimal;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_PONDERACION_EXAMEN", schema = "INS")
public class InsPonderacionExamen extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "POE_CODIGO", nullable = false)
	private Long poeCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO")
	private Long pelCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO")
	private Long estCodigo;

	@Column(name = "POE_ITEM_NOTA")
	private Long poeItemNota;

	@Max(100)
	@Min(1)
	@Column(name = "POE_PORCENTAJE", nullable = false)
	private BigDecimal poePorcentaje;

	@Column(name = "POE_VALOR_MAXIMO")
	private BigDecimal poeValorMaximo;

	@JoinColumn(name = "TIE_CODIGO", referencedColumnName = "TIE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsTipoExamen insTipoExamen;

	@JoinColumn(name = "DPE_CODIGO", referencedColumnName = "DPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsDesPonExa insDesPonExa;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insPonderacionExamen", fetch = FetchType.LAZY)
	private Collection<InsCalificacionExamen> insCalificacionExamenCollection;

	public InsPonderacionExamen() {
	}

	public InsPonderacionExamen(Long poeCodigo) {
		this.poeCodigo = poeCodigo;
	}

	public Long getPoeCodigo() {
		return this.poeCodigo;
	}

	public void setPoeCodigo(Long poeCodigo) {
		this.poeCodigo = poeCodigo;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getPoeItemNota() {
		return this.poeItemNota;
	}

	public void setPoeItemNota(Long poeItemNota) {
		this.poeItemNota = poeItemNota;
	}

	public BigDecimal getPoePorcentaje() {
		return this.poePorcentaje;
	}

	public void setPoePorcentaje(BigDecimal poePorcentaje) {
		this.poePorcentaje = poePorcentaje;
	}

	public BigDecimal getPoeValorMaximo() {
		return this.poeValorMaximo;
	}

	public void setPoeValorMaximo(BigDecimal poeValorMaximo) {
		this.poeValorMaximo = poeValorMaximo;
	}

	public InsTipoExamen getInsTipoExamen() {
		return this.insTipoExamen;
	}

	public void setInsTipoExamen(InsTipoExamen insTipoExamen) {
		this.insTipoExamen = insTipoExamen;
	}

	public InsDesPonExa getInsDesPonExa() {
		return this.insDesPonExa;
	}

	public void setInsDesPonExa(InsDesPonExa insDesPonExa) {
		this.insDesPonExa = insDesPonExa;
	}

	public Collection<InsCalificacionExamen> getInsCalificacionExamenCollection() {
		return this.insCalificacionExamenCollection;
	}

	public void setInsCalificacionExamenCollection(Collection<InsCalificacionExamen> insCalificacionExamenCollection) {
		this.insCalificacionExamenCollection = insCalificacionExamenCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsPonderacionExamen)) {
			return false;
		}
		InsPonderacionExamen other = (InsPonderacionExamen) object;
		if ((this.poeCodigo == null && other.poeCodigo != null)
				|| (this.poeCodigo != null && !this.poeCodigo.equals(other.poeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.poeCodigo != null) ? this.poeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsPonderacionExamen[ poeCodigo=" + this.poeCodigo + " ]";
	}

}
