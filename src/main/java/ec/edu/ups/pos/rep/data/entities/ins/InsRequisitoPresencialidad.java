package ec.edu.ups.pos.rep.data.entities.ins;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.data.entities.org.OrgPeriodoLectivo;
import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_REQUISITO_PRESENCIALIDAD", schema = "INS")
@SequenceGenerator(name = "INS_REQUISITO_PRESENCIALIDAD_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsRequisitoPresencialidad extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_REQUISITO_PRESENCIALIDAD_SQ")
	@NotNull
	@Column(name = "REQ_CODIGO", nullable = false)
	private Long reqCodigo;

	@Size(max = 200)
	@Column(name = "REQ_NOMBRE", length = 200)
	private String reqNombre;

	@Size(max = 1024)
	@Column(name = "REQ_URL_DSPACE", length = 1024)
	private String reqUrlDspace;

	@Size(max = 500)
	@Column(name = "REQ_UUID_BITSTREAM", length = 500)
	private String reqUuidBitstream;

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

	@Size(max = 600)
	@Column(name = "REQ_DECLARACION", length = 600)
	private String reqDeclaracion;

	@Column(name = "REQ_FECHA_SOLICITUD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reqFechaSolicitud;

	@JoinColumn(name = "INS_CODIGO", referencedColumnName = "INS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInscripcion insInscripcion;

	@Size(max = 60)
	@Column(name = "REQ_CONFIRMADO_USUARIO", length = 60)
	private String reqConfirmadoUsuario;

	@JoinColumn(name = "EST_CODIGO", referencedColumnName = "EST_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private OrgEstructura estCodigoCarrera;

	@JoinColumn(name = "PEL_CODIGO", referencedColumnName = "PEL_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private OrgPeriodoLectivo orgPeriodoLectivo;

	public InsRequisitoPresencialidad() {
	}

	public InsRequisitoPresencialidad(Long reqCodigo) {
		this.reqCodigo = reqCodigo;
	}

	public InsRequisitoPresencialidad(Long reqCodigo, String reqEstado, String reqVigente) {
		this.reqCodigo = reqCodigo;
		this.reqEstado = reqEstado;
		this.reqVigente = reqVigente;
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

	public String getReqUrlDspace() {
		return this.reqUrlDspace;
	}

	public void setReqUrlDspace(String reqUrlDspace) {
		this.reqUrlDspace = reqUrlDspace;
	}

	public String getReqUuidBitstream() {
		return this.reqUuidBitstream;
	}

	public void setReqUuidBitstream(String reqUuidBitstream) {
		this.reqUuidBitstream = reqUuidBitstream;
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

	public String getReqDeclaracion() {
		return this.reqDeclaracion;
	}

	public void setReqDeclaracion(String reqDeclaracion) {
		this.reqDeclaracion = reqDeclaracion;
	}

	public Date getReqFechaSolicitud() {
		return this.reqFechaSolicitud;
	}

	public void setReqFechaSolicitud(Date reqFechaSolicitud) {
		this.reqFechaSolicitud = reqFechaSolicitud;
	}

	public InsInscripcion getInsInscripcion() {
		return this.insInscripcion;
	}

	public void setInsInscripcion(InsInscripcion insInscripcion) {
		this.insInscripcion = insInscripcion;
	}

	public String getReqConfirmadoUsuario() {
		return this.reqConfirmadoUsuario;
	}

	public void setReqConfirmadoUsuario(String reqConfirmadoUsuario) {
		this.reqConfirmadoUsuario = reqConfirmadoUsuario;
	}

	public OrgEstructura getEstCodigoCarrera() {
		return this.estCodigoCarrera;
	}

	public void setEstCodigoCarrera(OrgEstructura estCodigoCarrera) {
		this.estCodigoCarrera = estCodigoCarrera;
	}

	public OrgPeriodoLectivo getOrgPeriodoLectivo() {
		return this.orgPeriodoLectivo;
	}

	public void setOrgPeriodoLectivo(OrgPeriodoLectivo orgPeriodoLectivo) {
		this.orgPeriodoLectivo = orgPeriodoLectivo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsRequisitoPresencialidad)) {
			return false;
		}
		InsRequisitoPresencialidad other = (InsRequisitoPresencialidad) object;
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
		return "InsRequisitoPresencialidad[ reqCodigo=" + this.reqCodigo + " ]";
	}

}
