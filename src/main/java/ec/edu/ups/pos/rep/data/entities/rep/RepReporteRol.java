package ec.edu.ups.pos.rep.data.entities.rep;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.pos.rep.data.entities.aseg.AsegRol;
import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "REP_REPORTE_ROL", catalog = "", schema = "REP")
public class RepReporteRol extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "RER_CODIGO", nullable = false)
	private Long repPerCodigo;

	@JoinColumn(name = "RES_CODIGO", referencedColumnName = "RES_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private RepReportesSistema repReportesSistema;

	@JoinColumn(name = "ROL_CODIGO", referencedColumnName = "ROL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegRol asegRol;

	public RepReporteRol() {
	}

	public @NotNull Long getRepPerCodigo() {
		return this.repPerCodigo;
	}

	public void setRepPerCodigo(@NotNull Long repPerCodigo) {
		this.repPerCodigo = repPerCodigo;
	}

	public RepReportesSistema getRepReportesSistema() {
		return this.repReportesSistema;
	}

	public void setRepReportesSistema(RepReportesSistema repReportesSistema) {
		this.repReportesSistema = repReportesSistema;
	}

	public AsegRol getAsegRol() {
		return this.asegRol;
	}

	public void setAsegRol(AsegRol asegRol) {
		this.asegRol = asegRol;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RepReporteRol that = (RepReporteRol) o;
		return Objects.equals(this.repPerCodigo, that.repPerCodigo);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.repPerCodigo);
	}

	@Override
	public String toString() {
		return "RepReporteRol{" + "repPerCodigo=" + this.repPerCodigo + ", repReportesSistema="
				+ this.repReportesSistema + ", asegRol=" + this.asegRol + '}';
	}

}
