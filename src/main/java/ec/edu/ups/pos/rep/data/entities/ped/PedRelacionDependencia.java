package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

/**
 * Description.
 *
 * @author ups .
 */
@Entity
@Table(name = "PED_RELACION_DEPENDENCIA", catalog = "", schema = "PED")
public class PedRelacionDependencia extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "RED_CODIGO", nullable = false)
	private Long redCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "RED_CODIGO_INTERNO", nullable = false)
	private String redCodigoInterno;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "RED_DESCRIPCION_INTERNO", nullable = false, length = 200)
	private String redDescripcionInterno;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "RED_CORRESPONDENCIA", nullable = false, length = 200)
	private String redCorrespondencia;

	@Basic(optional = false)
	@NotNull
	@Column(name = "RED_TIPO", nullable = false)
	private Long redTipo;

	public PedRelacionDependencia() {
	}

	public PedRelacionDependencia(Long redCodigo) {
		this.redCodigo = redCodigo;
	}

	public PedRelacionDependencia(Long redCodigo, String redCodigoInterno, String redDescripcionInterno,
			String redCorrespondencia) {
		this.redCodigo = redCodigo;
		this.redCodigoInterno = redCodigoInterno;
		this.redDescripcionInterno = redDescripcionInterno;
		this.redCorrespondencia = redCorrespondencia;
	}

	public Long getRedCodigo() {
		return this.redCodigo;
	}

	public void setRedCodigo(Long redCodigo) {
		this.redCodigo = redCodigo;
	}

	public String getRedCodigoInterno() {
		return this.redCodigoInterno;
	}

	public void setRedCodigoInterno(String redCodigoInterno) {
		this.redCodigoInterno = redCodigoInterno;
	}

	public String getRedDescripcionInterno() {
		return this.redDescripcionInterno;
	}

	public void setRedDescripcionInterno(String redDescripcionInterno) {
		this.redDescripcionInterno = redDescripcionInterno;
	}

	public String getRedCorrespondencia() {
		return this.redCorrespondencia;
	}

	public void setRedCorrespondencia(String redCorrespondencia) {
		this.redCorrespondencia = redCorrespondencia;
	}

	public Long getRedTipo() {
		return this.redTipo;
	}

	public void setRedTipo(Long redTipo) {
		this.redTipo = redTipo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedRelacionDependencia)) {
			return false;
		}
		PedRelacionDependencia other = (PedRelacionDependencia) object;
		return (this.redCodigo != null || other.redCodigo == null)
				&& (this.redCodigo == null || this.redCodigo.equals(other.redCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.redCodigo != null) ? this.redCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "PedRelacionDependencia[ redCodigo=" + this.redCodigo + " ]";
	}

}
