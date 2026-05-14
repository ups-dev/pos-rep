package ec.edu.ups.pos.rep.data.entities.sol;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "SOL_TIPO_SOLICITUD", schema = "SOL")
public class SolTipoSolicitud extends EntitySuperclass {

	@Size(max = 200)
	@Column(name = "TIS_PLANTILLA_PDF", length = 200)
	private String tisPlantillaPdf;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "AUD_ELIMINADO", nullable = false, length = 1)
	private String audEliminado;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "AUD_ADICIONADO", nullable = false, length = 50)
	private String audAdicionado;

	@Basic(optional = false)
	@NotNull
	@Column(name = "AUD_FECHA_ADICION", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaAdicion;

	@Size(max = 50)
	@Column(name = "AUD_MODIFICADO", length = 50)
	private String audModificado;

	@Column(name = "AUD_FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaModificacion;

	@Size(max = 20)
	@Column(name = "TIS_PLANTILLA", length = 20)
	private String tisPlantilla;

	@Size(max = 250)
	@Column(name = "TIS_FECHA_RECEPCION", length = 250)
	private String tisFechaRecepcion;

	@Lob
	@Column(name = "TIS_RESTRICCIONES")
	private String tisRestricciones;

	@Lob
	@Column(name = "TIS_DETALLE_DERECHO")
	private String tisDetalleDerecho;

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TIS_CODIGO", nullable = false)
	private Long tisCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "TIS_CODIGO_PROCEDIMIENTO", nullable = false, length = 10)
	private String tisCodigoProcedimiento;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "TIS_DESCRIPCION", nullable = false, length = 150)
	private String tisDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIS_TIPO_RECEPCION", nullable = false, length = 1)
	private String tisTipoRecepcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIS_TIENE_COMPROBANTE", nullable = false, length = 1)
	private String tisTieneComprobante;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TIS_TIENE_ADJUNTO", nullable = false, length = 1)
	private String tisTieneAdjunto;

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "TIS_DETALLE_ADJUNTOS")
	private String tisDetalleAdjuntos;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "solTipoSolicitud", fetch = FetchType.LAZY)
	private Collection<SolSolicitud> solSolicitudCollection;

	public SolTipoSolicitud() {
	}

	public SolTipoSolicitud(Long tisCodigo) {
		this.tisCodigo = tisCodigo;
	}

	public Long getTisCodigo() {
		return this.tisCodigo;
	}

	public void setTisCodigo(Long tisCodigo) {
		this.tisCodigo = tisCodigo;
	}

	public String getTisCodigoProcedimiento() {
		return this.tisCodigoProcedimiento;
	}

	public void setTisCodigoProcedimiento(String tisCodigoProcedimiento) {
		this.tisCodigoProcedimiento = tisCodigoProcedimiento;
	}

	public String getTisDescripcion() {
		return this.tisDescripcion;
	}

	public void setTisDescripcion(String tisDescripcion) {
		this.tisDescripcion = tisDescripcion;
	}

	public String getTisTipoRecepcion() {
		return this.tisTipoRecepcion;
	}

	public void setTisTipoRecepcion(String tisTipoRecepcion) {
		this.tisTipoRecepcion = tisTipoRecepcion;
	}

	public String getTisTieneComprobante() {
		return this.tisTieneComprobante;
	}

	public void setTisTieneComprobante(String tisTieneComprobante) {
		this.tisTieneComprobante = tisTieneComprobante;
	}

	public String getTisTieneAdjunto() {
		return this.tisTieneAdjunto;
	}

	public void setTisTieneAdjunto(String tisTieneAdjunto) {
		this.tisTieneAdjunto = tisTieneAdjunto;
	}

	public String getTisDetalleAdjuntos() {
		return this.tisDetalleAdjuntos;
	}

	public void setTisDetalleAdjuntos(String tisDetalleAdjuntos) {
		this.tisDetalleAdjuntos = tisDetalleAdjuntos;
	}

	public Collection<SolSolicitud> getSolSolicitudCollection() {
		return this.solSolicitudCollection;
	}

	public void setSolSolicitudCollection(Collection<SolSolicitud> solSolicitudCollection) {
		this.solSolicitudCollection = solSolicitudCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SolTipoSolicitud)) {
			return false;
		}
		SolTipoSolicitud other = (SolTipoSolicitud) object;
		if ((this.tisCodigo == null && other.tisCodigo != null)
				|| (this.tisCodigo != null && !this.tisCodigo.equals(other.tisCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tisCodigo != null) ? this.tisCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "SolTipoSolicitud[ tisCodigo=" + this.tisCodigo + " ]";
	}

	public String getAudEliminado() {
		return this.audEliminado;
	}

	public void setAudEliminado(String audEliminado) {
		this.audEliminado = audEliminado;
	}

	public String getAudAdicionado() {
		return this.audAdicionado;
	}

	public void setAudAdicionado(String audAdicionado) {
		this.audAdicionado = audAdicionado;
	}

	public Date getAudFechaAdicion() {
		return this.audFechaAdicion;
	}

	public void setAudFechaAdicion(Date audFechaAdicion) {
		this.audFechaAdicion = audFechaAdicion;
	}

	public String getAudModificado() {
		return this.audModificado;
	}

	public void setAudModificado(String audModificado) {
		this.audModificado = audModificado;
	}

	public Date getAudFechaModificacion() {
		return this.audFechaModificacion;
	}

	public void setAudFechaModificacion(Date audFechaModificacion) {
		this.audFechaModificacion = audFechaModificacion;
	}

	public String getTisPlantilla() {
		return this.tisPlantilla;
	}

	public void setTisPlantilla(String tisPlantilla) {
		this.tisPlantilla = tisPlantilla;
	}

	public String getTisFechaRecepcion() {
		return this.tisFechaRecepcion;
	}

	public void setTisFechaRecepcion(String tisFechaRecepcion) {
		this.tisFechaRecepcion = tisFechaRecepcion;
	}

	public String getTisRestricciones() {
		return this.tisRestricciones;
	}

	public void setTisRestricciones(String tisRestricciones) {
		this.tisRestricciones = tisRestricciones;
	}

	public String getTisDetalleDerecho() {
		return this.tisDetalleDerecho;
	}

	public void setTisDetalleDerecho(String tisDetalleDerecho) {
		this.tisDetalleDerecho = tisDetalleDerecho;
	}

	public String getTisPlantillaPdf() {
		return this.tisPlantillaPdf;
	}

	public void setTisPlantillaPdf(String tisPlantillaPdf) {
		this.tisPlantillaPdf = tisPlantillaPdf;
	}

}
