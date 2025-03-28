package ec.edu.ups.pos.rep.data.entities.sol;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "SOL_SOLICITUD", schema = "SOL")
public class SolSolicitud extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "SOL_CODIGO", nullable = false)
	private Long solCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Size(max = 200)
	@Column(name = "SOL_ASUNTO", length = 200)
	private String solAsunto;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "SOL_CONTENIDO", nullable = false)
	private String solContenido;

	@Basic(optional = false)
	@NotNull
	@Column(name = "SOL_FECHA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date solFecha;

	@Column(name = "SOL_FECHA_ENTREGA_ADJUNTOS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date solFechaEntregaAdjuntos;

	@JoinColumn(name = "TIS_CODIGO", referencedColumnName = "TIS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SolTipoSolicitud solTipoSolicitud;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solSolicitud", fetch = FetchType.LAZY)
	private Collection<SolSolicitudEvento> solSolicitudEventoCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solSolicitud", fetch = FetchType.LAZY)
	private Collection<SolSolicitudPersona> solSolicitudPersonaCollection;

	public SolSolicitud() {
	}

	public SolSolicitud(Long solCodigo) {
		this.solCodigo = solCodigo;
	}

	public Long getSolCodigo() {
		return this.solCodigo;
	}

	public void setSolCodigo(Long solCodigo) {
		this.solCodigo = solCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getSolAsunto() {
		return this.solAsunto;
	}

	public void setSolAsunto(String solAsunto) {
		this.solAsunto = solAsunto;
	}

	public String getSolContenido() {
		return this.solContenido;
	}

	public void setSolContenido(String solContenido) {
		this.solContenido = solContenido;
	}

	public Date getSolFecha() {
		return this.solFecha;
	}

	public void setSolFecha(Date solFecha) {
		this.solFecha = solFecha;
	}

	public Date getSolFechaEntregaAdjuntos() {
		return this.solFechaEntregaAdjuntos;
	}

	public void setSolFechaEntregaAdjuntos(Date solFechaEntregaAdjuntos) {
		this.solFechaEntregaAdjuntos = solFechaEntregaAdjuntos;
	}

	public SolTipoSolicitud getSolTipoSolicitud() {
		return this.solTipoSolicitud;
	}

	public void setSolTipoSolicitud(SolTipoSolicitud solTipoSolicitud) {
		this.solTipoSolicitud = solTipoSolicitud;
	}

	public Collection<SolSolicitudEvento> getSolSolicitudEventoCollection() {
		return this.solSolicitudEventoCollection;
	}

	public void setSolSolicitudEventoCollection(Collection<SolSolicitudEvento> solSolicitudEventoCollection) {
		this.solSolicitudEventoCollection = solSolicitudEventoCollection;
	}

	public Collection<SolSolicitudPersona> getSolSolicitudPersonaCollection() {
		return this.solSolicitudPersonaCollection;
	}

	public void setSolSolicitudPersonaCollection(Collection<SolSolicitudPersona> solSolicitudPersonaCollection) {
		this.solSolicitudPersonaCollection = solSolicitudPersonaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SolSolicitud)) {
			return false;
		}
		SolSolicitud other = (SolSolicitud) object;
		if ((this.solCodigo == null && other.solCodigo != null)
				|| (this.solCodigo != null && !this.solCodigo.equals(other.solCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.solCodigo != null) ? this.solCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "SolSolicitud[ solCodigo=" + this.solCodigo + " ]";
	}

}
