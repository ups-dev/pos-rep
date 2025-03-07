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
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_AUTORIZACION", schema = "ORG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "PEL_CODIGO", "CLLC_CDG", "AUT_USUARIO" }) })
public class OrgAutorizacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "AUT_CODIGO", nullable = false)
	private Long autCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CLLC_CDG", nullable = false)
	private Long cllcCdg;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "AUT_USUARIO", nullable = false, length = 100)
	private String autUsuario;

	@Size(max = 250)
	@Column(name = "AUT_OBSERVACION", length = 250)
	private String autObservacion;

	@JoinColumn(name = "PEL_CODIGO", referencedColumnName = "PEL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgPeriodoLectivo orgPeriodoLectivo;

	public OrgAutorizacion() {
	}

	public OrgAutorizacion(Long autCodigo) {
		this.autCodigo = autCodigo;
	}

	public OrgAutorizacion(Long autCodigo, Long cllcCdg, String autUsuario) {
		this.autCodigo = autCodigo;
		this.cllcCdg = cllcCdg;
		this.autUsuario = autUsuario;
	}

	public Long getAutCodigo() {
		return this.autCodigo;
	}

	public void setAutCodigo(Long autCodigo) {
		this.autCodigo = autCodigo;
	}

	public Long getCllcCdg() {
		return this.cllcCdg;
	}

	public void setCllcCdg(Long cllcCdg) {
		this.cllcCdg = cllcCdg;
	}

	public String getAutUsuario() {
		return this.autUsuario;
	}

	public void setAutUsuario(String autUsuario) {
		this.autUsuario = autUsuario;
	}

	public String getAutObservacion() {
		return this.autObservacion;
	}

	public void setAutObservacion(String autObservacion) {
		this.autObservacion = autObservacion;
	}

	public OrgPeriodoLectivo getOrgPeriodoLectivo() {
		return this.orgPeriodoLectivo;
	}

	public void setOrgPeriodoLectivo(OrgPeriodoLectivo orgPeriodoLectivo) {
		this.orgPeriodoLectivo = orgPeriodoLectivo;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgAutorizacion)) {
			return false;
		}
		OrgAutorizacion other = (OrgAutorizacion) object;
		return (this.autCodigo != null || other.autCodigo == null)
				&& (this.autCodigo == null || this.autCodigo.equals(other.autCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.autCodigo != null) ? this.autCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "autCodigo = " + this.autCodigo + ")";
	}

}
