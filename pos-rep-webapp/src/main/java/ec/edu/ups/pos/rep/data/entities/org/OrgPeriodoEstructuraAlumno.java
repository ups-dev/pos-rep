package ec.edu.ups.pos.rep.data.entities.org;

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
@Table(name = "ORG_PERIODO_ESTRUCTURA_ALUMNO", schema = "ORG")
public class OrgPeriodoEstructuraAlumno extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PEA_CODIGO", nullable = false)
	private Long peaCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ALU_CODIGO", nullable = false)
	private Long aluCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "RES_CODIGO", nullable = false)
	private Long resCodigo;

	@JoinColumn(name = "PEE_CODIGO", referencedColumnName = "PEE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgPeriodoEstructura orgPeriodoEstructura;

	public OrgPeriodoEstructuraAlumno() {
	}

	public OrgPeriodoEstructuraAlumno(Long peaCodigo) {
		this.peaCodigo = peaCodigo;
	}

	public OrgPeriodoEstructuraAlumno(Long peaCodigo, Long aluCodigo, Long resCodigo) {
		this.peaCodigo = peaCodigo;
		this.aluCodigo = aluCodigo;
		this.resCodigo = resCodigo;
	}

	public Long getPeaCodigo() {
		return this.peaCodigo;
	}

	public void setPeaCodigo(Long peaCodigo) {
		this.peaCodigo = peaCodigo;
	}

	public Long getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public Long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public OrgPeriodoEstructura getOrgPeriodoEstructura() {
		return this.orgPeriodoEstructura;
	}

	public void setOrgPeriodoEstructura(OrgPeriodoEstructura orgPeriodoEstructura) {
		this.orgPeriodoEstructura = orgPeriodoEstructura;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgPeriodoEstructuraAlumno)) {
			return false;
		}
		OrgPeriodoEstructuraAlumno other = (OrgPeriodoEstructuraAlumno) object;
		return (this.peaCodigo != null || other.peaCodigo == null)
				&& (this.peaCodigo == null || this.peaCodigo.equals(other.peaCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.peaCodigo != null) ? this.peaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "peaCodigo = " + this.peaCodigo + ")";
	}

}
