package ec.edu.ups.pos.rep.data.entities.org;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_MOTIVO_SALIDA", schema = "ORG")
@XmlRootElement
public class OrgMotivoSalida extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MOS_CODIGO", nullable = false)
	private Long mosCodigo;

	@Basic(optional = false)
	@Column(name = "MOS_DESCRIPCION", nullable = false)
	private String mosDescripcion;

	public OrgMotivoSalida() {
	}

	public OrgMotivoSalida(Long mosCodigo) {
		this.mosCodigo = mosCodigo;
	}

	public OrgMotivoSalida(Long mosCodigo, String mosDescripcion) {
		this.mosCodigo = mosCodigo;
		this.mosDescripcion = mosDescripcion;
	}

	public Long getMosCodigo() {
		return this.mosCodigo;
	}

	public void setMosCodigo(Long mosCodigo) {
		this.mosCodigo = mosCodigo;
	}

	public String getMosDescripcion() {
		return this.mosDescripcion;
	}

	public void setMosDescripcion(String mosDescripcion) {
		this.mosDescripcion = mosDescripcion;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgMotivoSalida)) {
			return false;
		}
		OrgMotivoSalida other = (OrgMotivoSalida) object;
		return (this.mosCodigo != null || other.mosCodigo == null)
				&& (this.mosCodigo == null || this.mosCodigo.equals(other.mosCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mosCodigo != null) ? this.mosCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "mosCodigo = " + this.mosCodigo + ")";
	}

}
