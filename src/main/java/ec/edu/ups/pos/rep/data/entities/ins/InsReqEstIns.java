package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_REQ_EST_INS", schema = "INS")
@SequenceGenerator(name = "INS_REQ_EST_INS_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsReqEstIns extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_REQ_EST_INS_SQ")
	@NotNull
	@Column(name = "REI_CODIGO", nullable = false)
	private Long reiCodigo;

	@Size(max = 1)
	@Column(name = "REI_BLOQUEADO", length = 1)
	private String reiBloqueado;

	@Size(max = 1)
	@Column(name = "REI_ENTREGADO", length = 1)
	private String reiEntregado;

	@Column(name = "REI_FECHA_ENTREGA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reiFechaEntrega;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "REI_ESTADO", nullable = false, length = 1)
	private String reiEstado;

	@Size(max = 600)
	@Column(name = "REI_DECLARACION", length = 600)
	private String reiDeclaracion;

	@Basic(optional = false)
	@Size(min = 1, max = 1)
	@Column(name = "REI_CONFIRMA_REQUISITO_EST", nullable = false)
	private String reiConfirmaRequisitoEst;

	@JoinColumn(name = "REE_CODIGO", referencedColumnName = "REE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsRequisitoEstructura insRequisitoEstructura;

	@JoinColumn(name = "INS_CODIGO", referencedColumnName = "INS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInscripcion insInscripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insReqEstIns", fetch = FetchType.LAZY)
	private Collection<InsRequisitoDigital> insRequisitoDigitalCollection;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "REI_ESTADO_EST", nullable = false, length = 1)
	private String reiEstadoEst;

	public InsReqEstIns() {
	}

	public InsReqEstIns(Long reiCodigo) {
		this.reiCodigo = reiCodigo;
	}

	public Long getReiCodigo() {
		return this.reiCodigo;
	}

	public void setReiCodigo(Long reiCodigo) {
		this.reiCodigo = reiCodigo;
	}

	public String getReiBloqueado() {
		return this.reiBloqueado;
	}

	public void setReiBloqueado(String reiBloqueado) {
		this.reiBloqueado = reiBloqueado;
	}

	public String getReiEntregado() {
		return this.reiEntregado;
	}

	public void setReiEntregado(String reiEntregado) {
		this.reiEntregado = reiEntregado;
	}

	public Date getReiFechaEntrega() {
		return this.reiFechaEntrega;
	}

	public void setReiFechaEntrega(Date reiFechaEntrega) {
		this.reiFechaEntrega = reiFechaEntrega;
	}

	public String getReiEstado() {
		return this.reiEstado;
	}

	public void setReiEstado(String reiEstado) {
		this.reiEstado = reiEstado;
	}

	public String getReiDeclaracion() {
		return this.reiDeclaracion;
	}

	public void setReiDeclaracion(String reiDeclaracion) {
		this.reiDeclaracion = reiDeclaracion;
	}

	public String getReiConfirmaRequisitoEst() {
		return this.reiConfirmaRequisitoEst;
	}

	public void setReiConfirmaRequisitoEst(String reiConfirmaRequisitoEst) {
		this.reiConfirmaRequisitoEst = reiConfirmaRequisitoEst;
	}

	public InsRequisitoEstructura getInsRequisitoEstructura() {
		return this.insRequisitoEstructura;
	}

	public void setInsRequisitoEstructura(InsRequisitoEstructura insRequisitoEstructura) {
		this.insRequisitoEstructura = insRequisitoEstructura;
	}

	public InsInscripcion getInsInscripcion() {
		return this.insInscripcion;
	}

	public void setInsInscripcion(InsInscripcion insInscripcion) {
		this.insInscripcion = insInscripcion;
	}

	public Collection<InsRequisitoDigital> getInsRequisitoDigitalCollection() {
		return this.insRequisitoDigitalCollection;
	}

	public void setInsRequisitoDigitalCollection(Collection<InsRequisitoDigital> insRequisitoDigitalCollection) {
		this.insRequisitoDigitalCollection = insRequisitoDigitalCollection;
	}

	public String getReiEstadoEst() {
		return this.reiEstadoEst;
	}

	public void setReiEstadoEst(String reiEstadoEst) {
		this.reiEstadoEst = reiEstadoEst;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsReqEstIns)) {
			return false;
		}
		InsReqEstIns other = (InsReqEstIns) object;
		if ((this.reiCodigo == null && other.reiCodigo != null)
				|| (this.reiCodigo != null && !this.reiCodigo.equals(other.reiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.reiCodigo != null) ? this.reiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsReqEstIns[ reiCodigo=" + this.reiCodigo + " ]";
	}

}
