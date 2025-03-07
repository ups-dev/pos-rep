package ec.edu.ups.pos.rep.data.entities.ped;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_COMPONENTE", schema = "PED")
public class PedComponente extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COM_CODIGO", nullable = false, updatable = false)
	private Long comCodigo;

	@Lob
	@Column(name = "COM_CONTENIDO")
	private String comContenido;

	@Lob
	@Column(name = "COM_ARCHIVO")
	private Serializable comArchivo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "COM_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date comFechaInicio;

	@Column(name = "COM_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date comFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "COM_VIGENTE", nullable = false, length = 1)
	private String comVigente;

	@JoinColumn(name = "TCT_CODIGO", referencedColumnName = "TCT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipComTipProEdu pedTipComTipProEdu;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	public PedComponente() {
	}

	public PedComponente(Long comCodigo) {
		this.comCodigo = comCodigo;
	}

	public PedComponente(Long comCodigo, Date comFechaInicio, String comVigente) {
		this.comCodigo = comCodigo;
		this.comFechaInicio = comFechaInicio;
		this.comVigente = comVigente;
	}

	public Long getComCodigo() {
		return this.comCodigo;
	}

	public void setComCodigo(Long comCodigo) {
		this.comCodigo = comCodigo;
	}

	public String getComContenido() {
		return this.comContenido;
	}

	public void setComContenido(String comContenido) {
		this.comContenido = comContenido;
	}

	public Serializable getComArchivo() {
		return this.comArchivo;
	}

	public void setComArchivo(Serializable comArchivo) {
		this.comArchivo = comArchivo;
	}

	public Date getComFechaInicio() {
		return this.comFechaInicio;
	}

	public void setComFechaInicio(Date comFechaInicio) {
		this.comFechaInicio = comFechaInicio;
	}

	public Date getComFechaFin() {
		return this.comFechaFin;
	}

	public void setComFechaFin(Date comFechaFin) {
		this.comFechaFin = comFechaFin;
	}

	public String getComVigente() {
		return this.comVigente;
	}

	public void setComVigente(String comVigente) {
		this.comVigente = comVigente;
	}

	public PedTipComTipProEdu getPedTipComTipProEdu() {
		return this.pedTipComTipProEdu;
	}

	public void setPedTipComTipProEdu(PedTipComTipProEdu pedTipComTipProEdu) {
		this.pedTipComTipProEdu = pedTipComTipProEdu;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedComponente)) {
			return false;
		}
		PedComponente other = (PedComponente) object;
		if ((this.comCodigo == null && other.comCodigo != null)
				|| (this.comCodigo != null && !this.comCodigo.equals(other.comCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.comCodigo != null) ? this.comCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedComponente[ comCodigo=" + this.comCodigo + " ]";
	}

}
