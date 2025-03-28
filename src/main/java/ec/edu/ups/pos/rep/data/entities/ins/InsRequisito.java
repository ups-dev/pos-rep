package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_REQUISITO", schema = "INS")
public class InsRequisito extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "REQ_CODIGO", nullable = false)
	private Long reqCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "REQ_DESCRIPCION", nullable = false, length = 400)
	private String reqDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insRequisito", fetch = FetchType.LAZY)
	private Collection<InsRequisitoEstructura> insRequisitoEstructuraCollection;

	@Transient
	private String entregado;

	public InsRequisito() {
	}

	public InsRequisito(Long reqCodigo) {
		this.reqCodigo = reqCodigo;
	}

	public InsRequisito(Long reqCodigo, String reqDescripcion) {
		this.reqCodigo = reqCodigo;
		this.reqDescripcion = reqDescripcion;
	}

	public Long getReqCodigo() {
		return this.reqCodigo;
	}

	public void setReqCodigo(Long reqCodigo) {
		this.reqCodigo = reqCodigo;
	}

	public String getReqDescripcion() {
		return this.reqDescripcion;
	}

	public void setReqDescripcion(String reqDescripcion) {
		this.reqDescripcion = reqDescripcion;
	}

	public String getEntregado() {
		return this.entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public Collection<InsRequisitoEstructura> getInsRequisitoEstructuraCollection() {
		return this.insRequisitoEstructuraCollection;
	}

	public void setInsRequisitoEstructuraCollection(
			Collection<InsRequisitoEstructura> insRequisitoEstructuraCollection) {
		this.insRequisitoEstructuraCollection = insRequisitoEstructuraCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsRequisito)) {
			return false;
		}
		InsRequisito other = (InsRequisito) object;
		if ((this.reqCodigo == null && other.reqCodigo != null)
				|| (this.reqCodigo != null && !this.reqCodigo.equals(other.reqCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.reqCodigo != null) ? this.reqCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsRequisito[ reqCodigo=" + this.reqCodigo + " ]";
	}

}
