package ec.edu.ups.pos.rep.data.entities.org;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_ESTADO_TIPO_PROCESO", schema = "ORG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "TIP_CODIGO", "EST_CODIGO" }) })
public class OrgEstadoTipoProceso extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ETP_CODIGO", nullable = false)
	private Long etpCodigo;

	@JoinColumn(name = "TIP_CODIGO", referencedColumnName = "TIP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipoProceso orgTipoProceso;

	@JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgEstado orgEstado;

	public OrgEstadoTipoProceso() {
	}

	public OrgEstadoTipoProceso(Long etpCodigo) {
		this.etpCodigo = etpCodigo;
	}

	public Long getEtpCodigo() {
		return this.etpCodigo;
	}

	public void setEtpCodigo(Long etpCodigo) {
		this.etpCodigo = etpCodigo;
	}

	public OrgTipoProceso getOrgTipoProceso() {
		return this.orgTipoProceso;
	}

	public void setOrgTipoProceso(OrgTipoProceso orgTipoProceso) {
		this.orgTipoProceso = orgTipoProceso;
	}

	public OrgEstado getOrgEstado() {
		return this.orgEstado;
	}

	public void setOrgEstado(OrgEstado orgEstado) {
		this.orgEstado = orgEstado;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgEstadoTipoProceso)) {
			return false;
		}
		OrgEstadoTipoProceso other = (OrgEstadoTipoProceso) object;
		return (this.etpCodigo != null || other.etpCodigo == null)
				&& (this.etpCodigo == null || this.etpCodigo.equals(other.etpCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.etpCodigo != null) ? this.etpCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "etpCodigo = " + this.etpCodigo + ")";
	}

}
