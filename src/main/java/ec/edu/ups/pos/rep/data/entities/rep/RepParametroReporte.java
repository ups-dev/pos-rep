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

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "REP_PARAMETRO_REPORTE", catalog = "", schema = "REP")
public class RepParametroReporte extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRE_CODIGO", nullable = false)
	private Long preCodigo;

	@JoinColumn(name = "PAR_CODIGO", referencedColumnName = "PAR_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepParametro repParametro;

	@JoinColumn(name = "RES_CODIGO", referencedColumnName = "RES_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepReportesSistema repReportesSistema;

	public RepParametroReporte() {
	}

	public RepParametroReporte(Long preCodigo) {
		this.preCodigo = preCodigo;
	}

	public Long getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(Long preCodigo) {
		this.preCodigo = preCodigo;
	}

	public RepParametro getRepParametro() {
		return this.repParametro;
	}

	public void setRepParametro(RepParametro repParametro) {
		this.repParametro = repParametro;
	}

	public RepReportesSistema getRepReportesSistema() {
		return this.repReportesSistema;
	}

	public void setRepReportesSistema(RepReportesSistema repReportesSistema) {
		this.repReportesSistema = repReportesSistema;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RepParametroReporte)) {
			return false;
		}
		RepParametroReporte other = (RepParametroReporte) object;
		if ((this.preCodigo == null && other.preCodigo != null)
				|| (this.preCodigo != null && !this.preCodigo.equals(other.preCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.preCodigo != null) ? this.preCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepParametroReporte[ preCodigo=" + this.preCodigo + " ]";

	}

}
