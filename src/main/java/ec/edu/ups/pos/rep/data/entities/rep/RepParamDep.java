package ec.edu.ups.pos.rep.data.entities.rep;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "REP_PARAM_DEP", catalog = "", schema = "REP")
public class RepParamDep extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PPD_CODIGO", nullable = false)
	private Long ppdCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PRE_HIJO_CODIGO", nullable = false)
	private Long preHijoCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PRE_PADRE_CODIGO", nullable = false)
	private Long prePadreCodigo;

	@Size(max = 80)
	@Column(name = "PPD_PLACEHOLDER", length = 80)
	private String ppdPlaceholder;

	@JoinColumn(name = "PRE_HIJO_CODIGO", referencedColumnName = "PRE_CODIGO", nullable = false, insertable = false,
			updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepParametroReporte repParametroReporteByPreHijoCodigo;

	@JoinColumn(name = "PRE_PADRE_CODIGO", referencedColumnName = "PRE_CODIGO", nullable = false, insertable = false,
			updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepParametroReporte repParametroReporteByPrePadreCodigo;

	public RepParamDep() {
	}

	public RepParamDep(Long ppdCodigo) {
		this.ppdCodigo = ppdCodigo;
	}

	public RepParamDep(Long ppdCodigo, Long preHijoCodigo, Long prePadreCodigo) {
		this.ppdCodigo = ppdCodigo;
		this.preHijoCodigo = preHijoCodigo;
		this.prePadreCodigo = prePadreCodigo;
	}

	public Long getPpdCodigo() {
		return this.ppdCodigo;
	}

	public void setPpdCodigo(Long ppdCodigo) {
		this.ppdCodigo = ppdCodigo;
	}

	public Long getPreHijoCodigo() {
		return this.preHijoCodigo;
	}

	public void setPreHijoCodigo(Long preHijoCodigo) {
		this.preHijoCodigo = preHijoCodigo;
	}

	public Long getPrePadreCodigo() {
		return this.prePadreCodigo;
	}

	public void setPrePadreCodigo(Long prePadreCodigo) {
		this.prePadreCodigo = prePadreCodigo;
	}

	public String getPpdPlaceholder() {
		return this.ppdPlaceholder;
	}

	public void setPpdPlaceholder(String ppdPlaceholder) {
		this.ppdPlaceholder = ppdPlaceholder;
	}

	public RepParametroReporte getRepParametroReporteByPreHijoCodigo() {
		return this.repParametroReporteByPreHijoCodigo;
	}

	public void setRepParametroReporteByPreHijoCodigo(RepParametroReporte repParametroReporteByPreHijoCodigo) {
		this.repParametroReporteByPreHijoCodigo = repParametroReporteByPreHijoCodigo;
	}

	public RepParametroReporte getRepParametroReporteByPrePadreCodigo() {
		return this.repParametroReporteByPrePadreCodigo;
	}

	public void setRepParametroReporteByPrePadreCodigo(RepParametroReporte repParametroReporteByPrePadreCodigo) {
		this.repParametroReporteByPrePadreCodigo = repParametroReporteByPrePadreCodigo;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RepParamDep)) {
			return false;
		}
		RepParamDep other = (RepParamDep) object;
		if ((this.ppdCodigo == null && other.ppdCodigo != null)
				|| (this.ppdCodigo != null && !this.ppdCodigo.equals(other.ppdCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.ppdCodigo != null) ? this.ppdCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepParamDep[ ppdCodigo=" + this.ppdCodigo + " ]";
	}

}
