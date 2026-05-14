package ec.edu.ups.pos.rep.data.entities.ins;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_PRO_ACA_ITI")
@SequenceGenerator(name = "INS_PRO_ACA_ITI_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsProAcaIti extends EntitySuperclass implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "IPI_CODIGO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_PRO_ACA_ITI_SQ")
	private Long ipiCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ITI_CODIGO")
	private Long itiCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "IPA_CODIGO")
	private Long ipaCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO")
	private Long pelCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "SOL_CODIGO", nullable = false)
	private Long solCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "IPI_TIPO", nullable = false, length = 1)
	private String ipiTipo;

	public InsProAcaIti() {
	}

	public InsProAcaIti(Long ipiCodigo) {
		this.ipiCodigo = ipiCodigo;
	}

	public Long getIpiCodigo() {
		return this.ipiCodigo;
	}

	public void setIpiCodigo(Long ipiCodigo) {
		this.ipiCodigo = ipiCodigo;
	}

	public Long getItiCodigo() {
		return this.itiCodigo;
	}

	public void setItiCodigo(Long itiCodigo) {
		this.itiCodigo = itiCodigo;
	}

	public Long getIpaCodigo() {
		return this.ipaCodigo;
	}

	public void setIpaCodigo(Long ipaCodigo) {
		this.ipaCodigo = ipaCodigo;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getSolCodigo() {
		return this.solCodigo;
	}

	public void setSolCodigo(Long solCodigo) {
		this.solCodigo = solCodigo;
	}

	public String getIpiTipo() {
		return this.ipiTipo;
	}

	public void setIpiTipo(String ipiTipo) {
		this.ipiTipo = ipiTipo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsProAcaIti)) {
			return false;
		}
		InsProAcaIti other = (InsProAcaIti) object;
		if ((this.ipiCodigo == null && other.ipiCodigo != null)
				|| (this.ipiCodigo != null && !this.ipiCodigo.equals(other.ipiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ipiCodigo != null) ? this.ipiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "ec.edu.ups.ins.common.data.entities.InsProAcaIti[ ipiCodigo=" + this.ipiCodigo + " ]";
	}

}
