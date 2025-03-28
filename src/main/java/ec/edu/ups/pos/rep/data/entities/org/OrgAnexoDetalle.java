package ec.edu.ups.pos.rep.data.entities.org;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_ANEXO_DETALLE", schema = "ORG")
public class OrgAnexoDetalle extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "AND_CODIGO", nullable = false)
	private Long andCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "AND_ARCHIVO", nullable = false)
	private byte[] andArchivo;

	@JoinColumn(name = "TDD_CODIGO", referencedColumnName = "TDD_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipDetDee orgTipDetDee;

	public OrgAnexoDetalle() {
	}

	public OrgAnexoDetalle(Long andCodigo) {
		this.andCodigo = andCodigo;
	}

	public OrgAnexoDetalle(Long andCodigo, byte[] andArchivo) {
		this.andCodigo = andCodigo;
		this.andArchivo = andArchivo;
	}

	public Long getAndCodigo() {
		return this.andCodigo;
	}

	public void setAndCodigo(Long andCodigo) {
		this.andCodigo = andCodigo;
	}

	public byte[] getAndArchivo() {
		return this.andArchivo;
	}

	public void setAndArchivo(byte[] andArchivo) {
		this.andArchivo = andArchivo;
	}

	public OrgTipDetDee getOrgTipDetDee() {
		return this.orgTipDetDee;
	}

	public void setOrgTipDetDee(OrgTipDetDee orgTipDetDee) {
		this.orgTipDetDee = orgTipDetDee;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgAnexoDetalle)) {
			return false;
		}
		OrgAnexoDetalle other = (OrgAnexoDetalle) object;
		return (this.andCodigo != null || other.andCodigo == null)
				&& (this.andCodigo == null || this.andCodigo.equals(other.andCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.andCodigo != null) ? this.andCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "andCodigo = " + this.andCodigo + ")";
	}

}
