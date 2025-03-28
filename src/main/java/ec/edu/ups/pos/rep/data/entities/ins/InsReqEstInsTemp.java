package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
public class InsReqEstInsTemp extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id

	private Long reiCodigo;

	private String reiBloqueado;

	private String reiEntregado;

	private Date reiFechaEntrega;

	private InsRequisitoEstructura insRequisitoEstructura;

	private InsInscripcion insInscripcion;

	private Collection<InsRequisitoDigital> insRequisitoDigitalCollection;

	public InsReqEstInsTemp() {
	}

	public InsReqEstInsTemp(Long reiCodigo) {
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

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsReqEstInsTemp)) {
			return false;
		}
		InsReqEstInsTemp other = (InsReqEstInsTemp) object;
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
