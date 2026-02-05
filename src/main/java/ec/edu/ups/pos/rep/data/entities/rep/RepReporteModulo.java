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
@Table(name = "REP_REPORTE_MODULO", catalog = "", schema = "REP")
public class RepReporteModulo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "RRM_CODIGO", nullable = false)
	private Long rrmCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MOD_CODIGO", nullable = false)
	private Long modCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "RES_CODIGO", nullable = false)
	private Long resCodigo;

	@Column(name = "RRM_ORDEN")
	private Long rrmOrden;

	@JoinColumn(name = "MOD_CODIGO", referencedColumnName = "MOD_CODIGO", nullable = false, insertable = false,
			updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepModulo repModulo;

	@JoinColumn(name = "RES_CODIGO", referencedColumnName = "RES_CODIGO", nullable = false, insertable = false,
			updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepReportesSistema repReportesSistema;

	public RepReporteModulo() {
	}

	public RepReporteModulo(Long rrmCodigo) {
		this.rrmCodigo = rrmCodigo;
	}

	public RepReporteModulo(Long rrmCodigo, Long modCodigo, Long resCodigo) {
		this.rrmCodigo = rrmCodigo;
		this.modCodigo = modCodigo;
		this.resCodigo = resCodigo;
	}

	public Long getRrmCodigo() {
		return this.rrmCodigo;
	}

	public void setRrmCodigo(Long rrmCodigo) {
		this.rrmCodigo = rrmCodigo;
	}

	public Long getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Long modCodigo) {
		this.modCodigo = modCodigo;
	}

	public Long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public Long getRrmOrden() {
		return this.rrmOrden;
	}

	public void setRrmOrden(Long rrmOrden) {
		this.rrmOrden = rrmOrden;
	}

	public RepModulo getRepModulo() {
		return this.repModulo;
	}

	public void setRepModulo(RepModulo repModulo) {
		this.repModulo = repModulo;
	}

	public RepReportesSistema getRepReportesSistema() {
		return this.repReportesSistema;
	}

	public void setRepReportesSistema(RepReportesSistema repReportesSistema) {
		this.repReportesSistema = repReportesSistema;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RepReporteModulo)) {
			return false;
		}
		RepReporteModulo other = (RepReporteModulo) object;
		if ((this.rrmCodigo == null && other.rrmCodigo != null)
				|| (this.rrmCodigo != null && !this.rrmCodigo.equals(other.rrmCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.rrmCodigo != null) ? this.rrmCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepReporteModulo[ rrmCodigo=" + this.rrmCodigo + " ]";
	}

}
