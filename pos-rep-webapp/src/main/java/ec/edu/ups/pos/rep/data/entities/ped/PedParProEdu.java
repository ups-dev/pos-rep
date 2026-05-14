package ec.edu.ups.pos.rep.data.entities.ped;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_PAR_PRO_EDU", schema = "PED")
public class PedParProEdu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PPE_CODIGO", nullable = false, updatable = false)
	private Long ppeCodigo;

	@Size(max = 100)
	@Column(name = "PPE_DESCRIPCION_TEXTO", length = 100)
	private String ppeDescripcionTexto;

	@Column(name = "PPE_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal ppeDescripcionNumero;

	@Column(name = "PPE_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ppeDescripcionFecha;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PPE_FECHA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ppeFechaInicio;

	@Column(name = "PPE_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ppeFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PPE_VIGENTE", nullable = false, length = 1)
	private String ppeVigente;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedParProEdu", fetch = FetchType.LAZY)
	private PedArchivoAnexo pedArchivoAnexo;

	@Column(name = "EST_CODIGO")
	private Long estCodigo;

	@Column(name = "PEL_CODIGO")
	private Long pelCodigo;

	@Column(name = "PEL_CODIGO_FIN")
	private Long pelCodigoFin;

	@Size(max = 200)
	@Column(name = "PPE_OBSERVACION", length = 200)
	private String ppeObservacion;

	@JoinColumn(name = "TPT_CODIGO", referencedColumnName = "TPT_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipParTipProEdu pedTipParTipProEdu;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	@JoinColumn(name = "NSR_CODIGO", referencedColumnName = "NSR_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedNivSufRef pedNivSufRef;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedParProEdu", fetch = FetchType.LAZY)
	private Collection<PedParametroDetalle> pedParametroDetalleCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedParProEdu", fetch = FetchType.LAZY)
	private Collection<PedItinerario> pedItinerarioCollection;

	public PedParProEdu() {
	}

	public PedParProEdu(Long ppeCodigo) {
		this.ppeCodigo = ppeCodigo;
	}

	public PedParProEdu(Long ppeCodigo, Date ppeFechaInicio, String ppeVigente) {
		this.ppeCodigo = ppeCodigo;
		this.ppeFechaInicio = ppeFechaInicio;
		this.ppeVigente = ppeVigente;
	}

	public Long getPpeCodigo() {
		return this.ppeCodigo;
	}

	public void setPpeCodigo(Long ppeCodigo) {
		this.ppeCodigo = ppeCodigo;
	}

	public String getPpeDescripcionTexto() {
		return this.ppeDescripcionTexto;
	}

	public void setPpeDescripcionTexto(String ppeDescripcionTexto) {
		this.ppeDescripcionTexto = ppeDescripcionTexto;
	}

	public BigDecimal getPpeDescripcionNumero() {
		return this.ppeDescripcionNumero;
	}

	public void setPpeDescripcionNumero(BigDecimal ppeDescripcionNumero) {
		this.ppeDescripcionNumero = ppeDescripcionNumero;
	}

	public Date getPpeDescripcionFecha() {
		return this.ppeDescripcionFecha;
	}

	public void setPpeDescripcionFecha(Date ppeDescripcionFecha) {
		this.ppeDescripcionFecha = ppeDescripcionFecha;
	}

	public Date getPpeFechaInicio() {
		return this.ppeFechaInicio;
	}

	public void setPpeFechaInicio(Date ppeFechaInicio) {
		this.ppeFechaInicio = ppeFechaInicio;
	}

	public Date getPpeFechaFin() {
		return this.ppeFechaFin;
	}

	public void setPpeFechaFin(Date ppeFechaFin) {
		this.ppeFechaFin = ppeFechaFin;
	}

	public String getPpeVigente() {
		return this.ppeVigente;
	}

	public void setPpeVigente(String ppeVigente) {
		this.ppeVigente = ppeVigente;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getPelCodigoFin() {
		return this.pelCodigoFin;
	}

	public void setPelCodigoFin(Long pelCodigoFin) {
		this.pelCodigoFin = pelCodigoFin;
	}

	public String getPpeObservacion() {
		return this.ppeObservacion;
	}

	public void setPpeObservacion(String ppeObservacion) {
		this.ppeObservacion = ppeObservacion;
	}

	public PedArchivoAnexo getPedArchivoAnexo() {
		return this.pedArchivoAnexo;
	}

	public void setPedArchivoAnexo(PedArchivoAnexo pedArchivoAnexo) {
		this.pedArchivoAnexo = pedArchivoAnexo;
	}

	public PedTipParTipProEdu getPedTipParTipProEdu() {
		return this.pedTipParTipProEdu;
	}

	public void setPedTipParTipProEdu(PedTipParTipProEdu pedTipParTipProEdu) {
		this.pedTipParTipProEdu = pedTipParTipProEdu;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	public PedNivSufRef getPedNivSufRef() {
		return this.pedNivSufRef;
	}

	public void setPedNivSufRef(PedNivSufRef pedNivSufRef) {
		this.pedNivSufRef = pedNivSufRef;
	}

	public Collection<PedParametroDetalle> getPedParametroDetalleCollection() {
		return this.pedParametroDetalleCollection;
	}

	public void setPedParametroDetalleCollection(Collection<PedParametroDetalle> pedParametroDetalleCollection) {
		this.pedParametroDetalleCollection = pedParametroDetalleCollection;
	}

	public Collection<PedItinerario> getPedItinerarioCollection() {
		return this.pedItinerarioCollection;
	}

	public void setPedItinerarioCollection(Collection<PedItinerario> pedItinerarioCollection) {
		this.pedItinerarioCollection = pedItinerarioCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedParProEdu)) {
			return false;
		}
		PedParProEdu other = (PedParProEdu) object;
		if ((this.ppeCodigo == null && other.ppeCodigo != null)
				|| (this.ppeCodigo != null && !this.ppeCodigo.equals(other.ppeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ppeCodigo != null) ? this.ppeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedParProEdu[ ppeCodigo=" + this.ppeCodigo + " ]";
	}

}
