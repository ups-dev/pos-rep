package ec.edu.ups.pos.rep.data.entities.rep;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import ec.edu.ups.util.jpa.EntitySuperclass;

/**
 * Description.
 *
 * @author ups .
 */
@Entity
@Table(name = "REP_LOG", catalog = "", schema = "REP")
@XmlRootElement
public class RepLog extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "LOG_CODIGO", nullable = false)
	private Long logCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "LOG_PARAM", nullable = false, length = 50)
	private String logParametro;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "RES_CODIGO", nullable = false, length = 50)
	private String resCodigo;

	public RepLog() {
	}

	public RepLog(Long logCodigo) {
		this.logCodigo = logCodigo;
	}

	public RepLog(Long parCodigo, String logParametro, String resCodigo) {
		this.logCodigo = parCodigo;
		this.logParametro = logParametro;
		this.resCodigo = resCodigo;

	}

	public @NotNull Long getLogCodigo() {
		return this.logCodigo;
	}

	public void setLogCodigo(@NotNull Long logCodigo) {
		this.logCodigo = logCodigo;
	}

	public @NotNull @Size(min = 1, max = 50) String getLogParametro() {
		return this.logParametro;
	}

	public void setLogParametro(@NotNull @Size(min = 1, max = 50) String logParametro) {
		this.logParametro = logParametro;
	}

	public @NotNull @Size(min = 1, max = 50) String getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(@NotNull @Size(min = 1, max = 50) String resCodigo) {
		this.resCodigo = resCodigo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RepLog repLog = (RepLog) o;
		return Objects.equals(this.logCodigo, repLog.logCodigo)
				&& Objects.equals(this.logParametro, repLog.logParametro)
				&& Objects.equals(this.resCodigo, repLog.resCodigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.logCodigo, this.logParametro, this.resCodigo);
	}

	@Override
	public String toString() {
		return "RepLog{" + "logCodigo=" + this.logCodigo + ", logParametro='" + this.logParametro + '\''
				+ ", resCodigo='" + this.resCodigo + '\'' + '}';
	}

}
