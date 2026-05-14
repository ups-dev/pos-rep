package ec.edu.ups.pos.rep.data.entities.ins;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_REQUISITO_DIGITAL", schema = "INS")
@SequenceGenerator(name = "INS_REQUISITO_DIGITAL_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsRequisitoDigital extends EntitySuperclass implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_REQUISITO_DIGITAL_SQ")
	@NotNull
	@Column(name = "REQ_CODIGO")
	private Long reqCodigo;

	@Transient
	private byte[] reqArchivo;

	@Basic(optional = true)
	@Size(max = 200)
	@Column(name = "REQ_NOMBRE")
	private String reqNombre;

	@Basic(optional = true)
	@Size(max = 1024)
	@Column(name = "REQ_URL_DSPACE")
	private String reqUrlDspace;

	@Basic(optional = true)
	@Size(max = 500)
	@Column(name = "REQ_UUID_BITSTREAM")
	private String reqUuidBitStream;

	@Basic(optional = true)
	@Size(max = 500)
	@Column(name = "REQ_CONTACTO_ENTIDAD")
	private String reqContactoEntidad;

	@Basic(optional = true)
	@Size(max = 100)
	@Column(name = "REQ_EMAIL_ENTIDAD")
	private String reqEmailEntidad;

	@Basic(optional = true)
	@Size(max = 50)
	@Column(name = "REQ_TELEFONO_ENTIDAD")
	private String reqTelefonoEntidad;

	@Basic(optional = true)
	@Size(max = 500)
	@Column(name = "REQ_NOMBRE_INSTITUCION")
	private String reqNombreInstitucion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "REQ_ESTADO", nullable = false, length = 1)
	private String reqEstado;

	@Column(name = "REQ_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reqFecha;

	@Size(max = 600)
	@Column(name = "REQ_OBSERVACION", length = 600)
	private String reqObservacion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "REQ_VIGENTE", nullable = false, length = 1)
	private String reqVigente;

	@JoinColumn(name = "REI_CODIGO", referencedColumnName = "REI_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsReqEstIns insReqEstIns;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "REQ_ESTADO_EST", nullable = false, length = 1)
	private String reqEstadoEst;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "REQ_MOSTRAR_SECRE", nullable = false, length = 1)
	private String reqMostrarSecre;

	public InsRequisitoDigital() {
	}

	public InsRequisitoDigital(Long reqCodigo) {
		this.reqCodigo = reqCodigo;
	}

	public Long getReqCodigo() {
		return this.reqCodigo;
	}

	public void setReqCodigo(Long reqCodigo) {
		this.reqCodigo = reqCodigo;
	}

	public String getReqNombre() {
		return this.reqNombre;
	}

	public void setReqNombre(String reqNombre) {
		this.reqNombre = reqNombre;
	}

	public InsReqEstIns getInsReqEstIns() {
		return this.insReqEstIns;
	}

	public void setInsReqEstIns(InsReqEstIns insReqEstIns) {
		this.insReqEstIns = insReqEstIns;
	}

	public String getReqUrlDspace() {
		return this.reqUrlDspace;
	}

	public void setReqUrlDspace(String reqUrlDspace) {
		this.reqUrlDspace = reqUrlDspace;
	}

	public String getReqUuidBitStream() {
		return this.reqUuidBitStream;
	}

	public void setReqUuidBitStream(String reqUuidBitStream) {
		this.reqUuidBitStream = reqUuidBitStream;
	}

	public String getReqContactoEntidad() {
		return this.reqContactoEntidad;
	}

	public void setReqContactoEntidad(String reqContactoEntidad) {
		this.reqContactoEntidad = reqContactoEntidad;
	}

	public String getReqEmailEntidad() {
		return this.reqEmailEntidad;
	}

	public void setReqEmailEntidad(String reqEmailEntidad) {
		this.reqEmailEntidad = reqEmailEntidad;
	}

	public String getReqTelefonoEntidad() {
		return this.reqTelefonoEntidad;
	}

	public void setReqTelefonoEntidad(String reqTelefonoEntidad) {
		this.reqTelefonoEntidad = reqTelefonoEntidad;
	}

	public String getReqNombreInstitucion() {
		return this.reqNombreInstitucion;
	}

	public void setReqNombreInstitucion(String reqNombreInstitucion) {
		this.reqNombreInstitucion = reqNombreInstitucion;
	}

	public String getReqEstado() {
		return this.reqEstado;
	}

	public void setReqEstado(String reqEstado) {
		this.reqEstado = reqEstado;
	}

	public Date getReqFecha() {
		return this.reqFecha;
	}

	public void setReqFecha(Date reqFecha) {
		this.reqFecha = reqFecha;
	}

	public String getReqObservacion() {
		return this.reqObservacion;
	}

	public void setReqObservacion(String reqObservacion) {
		this.reqObservacion = reqObservacion;
	}

	public String getReqVigente() {
		return this.reqVigente;
	}

	public void setReqVigente(String reqVigente) {
		this.reqVigente = reqVigente;
	}

	public byte[] getReqArchivo() {
		return this.reqArchivo;
	}

	public void setReqArchivo(byte[] reqArchivo) {
		this.reqArchivo = reqArchivo;
	}

	public String getReqEstadoEst() {
		return this.reqEstadoEst;
	}

	public void setReqEstadoEst(String reqEstadoEst) {
		this.reqEstadoEst = reqEstadoEst;
	}

	public String getReqMostrarSecre() {
		return this.reqMostrarSecre;
	}

	public void setReqMostrarSecre(String reqMostrarSecre) {
		this.reqMostrarSecre = reqMostrarSecre;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsRequisitoDigital)) {
			return false;
		}
		InsRequisitoDigital other = (InsRequisitoDigital) object;
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
		return "ec.edu.ups.ins.prueba.InsRequisitoDigital[ reqCodigo=" + this.reqCodigo + " ]";
	}

}
