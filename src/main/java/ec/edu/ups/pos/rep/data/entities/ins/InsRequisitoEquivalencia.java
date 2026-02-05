package ec.edu.ups.pos.rep.data.entities.ins;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_REQUISITO_EQUIVALENCIA")
@SequenceGenerator(name = "INS_REQUISITO_EQUIVALENCIA_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsRequisitoEquivalencia extends EntitySuperclass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_REQUISITO_EQUIVALENCIA_SQ")
	@Column(name = "REE_CODIGO", nullable = false)
	private Integer reecodigo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "REQ_CODIGO", nullable = false)
	private InsRequisito reqCodigo;

	@ManyToOne(optional = false)
	@JoinColumn(name = "REQ_CODIGO_EQ", nullable = false)

	private InsRequisito reqCodigoEq;

	public InsRequisito getReqCodigo() {
		return this.reqCodigo;
	}

	public InsRequisito getReqCodigoEq() {
		return this.reqCodigoEq;
	}

	public void setReqCodigoEq(InsRequisito reqCodigoEq) {
		this.reqCodigoEq = reqCodigoEq;
	}

	public void setReqCodigo(InsRequisito reqCodigo) {
		this.reqCodigo = reqCodigo;
	}

	public Integer getReecodigo() {
		return this.reecodigo;
	}

	public void setReecodigo(Integer reecodigo) {
		this.reecodigo = reecodigo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(obj instanceof InsRequisitoEstructura)) {
			return false;
		}
		InsRequisitoEquivalencia other = (InsRequisitoEquivalencia) obj;
		if ((this.reecodigo == null && other.reecodigo != null)
				|| (this.reecodigo != null && !this.reecodigo.equals(other.reecodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.reecodigo != null) ? this.reecodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
