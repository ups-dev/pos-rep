package ec.edu.ups.pos.rep.data.entities.ins;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INS_INSTITUCION_MINISTERIO_EDU", schema = "INS")
public class InsInstitucionMinisterioEdu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "IME_CODIGO")
	private Long imeCodigo;

	@Basic(optional = false)
	@Column(name = "IME_PERIODO")
	private String imePeriodo;

	@Basic(optional = false)
	@Column(name = "IME_ZONA")
	private String imeZona;

	@Basic(optional = false)
	@Column(name = "IME_COD_DISTRITO")
	private String imeCodDistrito;

	@Basic(optional = false)
	@Column(name = "IME_DISTRITO")
	private String imeDistrito;

	@Basic(optional = false)
	@Column(name = "IME_COD_PROVINCIA")
	private String imeCodProvincia;

	@Basic(optional = false)
	@Column(name = "IME_PROVINCIA")
	private String imeProvincia;

	@Basic(optional = false)
	@Column(name = "IME_COD_CANTON")
	private String imeCodCanton;

	@Basic(optional = false)
	@Column(name = "IME_CANTON")
	private String imeCanton;

	@Basic(optional = false)
	@Column(name = "IME_COD_PARROQUIA")
	private String imeCodParroquia;

	@Basic(optional = false)
	@Column(name = "IME_PARROQUIA")
	private String imeParroquia;

	@Basic(optional = false)
	@Column(name = "IME_COD_INSTITUCION")
	private String imeCodInstitucion;

	@Basic(optional = false)
	@Column(name = "IME_INSTITUCION")
	private String imeInstitucion;

	@Basic(optional = false)
	@Column(name = "IME_DIRECCION_INSTITUCION")
	private String imeDireccionInstitucion;

	@Basic(optional = false)
	@Column(name = "IME_VALOR_PENSION")
	private String imeValorPension;

	@Basic(optional = false)
	@Column(name = "IME_TIPO_EDUCACION")
	private String imeTipoEducacion;

	@Basic(optional = false)
	@Column(name = "IME_NIVEL_EDUCACION")
	private String imeNivelEducacion;

	@Basic(optional = false)
	@Column(name = "IME_SOSTENIMIENTO")
	private String imeSostenimiento;

	@Basic(optional = false)
	@Column(name = "IME_ZONA_INEC")
	private String imeZonaInec;

	@Basic(optional = false)
	@Column(name = "IME_REGIMEN_ESCOLAR")
	private String imeRegimenEscolar;

	@Basic(optional = false)
	@Column(name = "IME_JURISDICCION")
	private String imeJurisdiccion;

	@Basic(optional = false)
	@Column(name = "IME_MODALLIDAD")
	private String imeModallidad;

	@Basic(optional = false)
	@Column(name = "IME_JORNADA")
	private String imeJornada;

	@Basic(optional = false)
	@Column(name = "IME_ACCESO_EDIFICIO")
	private String imeAccesoEdificio;

	@Column(name = "IME_TENENCIA_INMUEBLE_EDIFICIO")
	private String imeTenenciaInmuebleEdificio;

	@Basic(optional = false)
	@Column(name = "AUD_ADICIONADO")
	private String audAdicionado;

	@Basic(optional = false)
	@Column(name = "AUD_FECHA_ADICION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaAdicion;

	@Column(name = "AUD_MODIFICADO")
	private String audModificado;

	@Column(name = "AUD_FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaModificacion;

	public InsInstitucionMinisterioEdu() {
	}

	public InsInstitucionMinisterioEdu(Long imeCodigo) {
		this.imeCodigo = imeCodigo;
	}

	public InsInstitucionMinisterioEdu(Long imeCodigo, String imePeriodo, String imeZona, String imeCodDistrito,
			String imeDistrito, String imeCodProvincia, String imeProvincia, String imeCodCanton, String imeCanton,
			String imeCodParroquia, String imeParroquia, String imeCodInstitucion, String imeInstitucion,
			String imeDireccionInstitucion, String imeValorPension, String imeTipoEducacion, String imeNivelEducacion,
			String imeSostenimiento, String imeZonaInec, String imeRegimenEscolar, String imeJurisdiccion,
			String imeModallidad, String imeJornada, String imeAccesoEdificio, String audAdicionado,
			Date audFechaAdicion) {
		this.imeCodigo = imeCodigo;
		this.imePeriodo = imePeriodo;
		this.imeZona = imeZona;
		this.imeCodDistrito = imeCodDistrito;
		this.imeDistrito = imeDistrito;
		this.imeCodProvincia = imeCodProvincia;
		this.imeProvincia = imeProvincia;
		this.imeCodCanton = imeCodCanton;
		this.imeCanton = imeCanton;
		this.imeCodParroquia = imeCodParroquia;
		this.imeParroquia = imeParroquia;
		this.imeCodInstitucion = imeCodInstitucion;
		this.imeInstitucion = imeInstitucion;
		this.imeDireccionInstitucion = imeDireccionInstitucion;
		this.imeValorPension = imeValorPension;
		this.imeTipoEducacion = imeTipoEducacion;
		this.imeNivelEducacion = imeNivelEducacion;
		this.imeSostenimiento = imeSostenimiento;
		this.imeZonaInec = imeZonaInec;
		this.imeRegimenEscolar = imeRegimenEscolar;
		this.imeJurisdiccion = imeJurisdiccion;
		this.imeModallidad = imeModallidad;
		this.imeJornada = imeJornada;
		this.imeAccesoEdificio = imeAccesoEdificio;
		this.audAdicionado = audAdicionado;
		this.audFechaAdicion = audFechaAdicion;
	}

	public Long getImeCodigo() {
		return this.imeCodigo;
	}

	public void setImeCodigo(Long imeCodigo) {
		this.imeCodigo = imeCodigo;
	}

	public String getImePeriodo() {
		return this.imePeriodo;
	}

	public void setImePeriodo(String imePeriodo) {
		this.imePeriodo = imePeriodo;
	}

	public String getImeZona() {
		return this.imeZona;
	}

	public void setImeZona(String imeZona) {
		this.imeZona = imeZona;
	}

	public String getImeCodDistrito() {
		return this.imeCodDistrito;
	}

	public void setImeCodDistrito(String imeCodDistrito) {
		this.imeCodDistrito = imeCodDistrito;
	}

	public String getImeDistrito() {
		return this.imeDistrito;
	}

	public void setImeDistrito(String imeDistrito) {
		this.imeDistrito = imeDistrito;
	}

	public String getImeCodProvincia() {
		return this.imeCodProvincia;
	}

	public void setImeCodProvincia(String imeCodProvincia) {
		this.imeCodProvincia = imeCodProvincia;
	}

	public String getImeProvincia() {
		return this.imeProvincia;
	}

	public void setImeProvincia(String imeProvincia) {
		this.imeProvincia = imeProvincia;
	}

	public String getImeCodCanton() {
		return this.imeCodCanton;
	}

	public void setImeCodCanton(String imeCodCanton) {
		this.imeCodCanton = imeCodCanton;
	}

	public String getImeCanton() {
		return this.imeCanton;
	}

	public void setImeCanton(String imeCanton) {
		this.imeCanton = imeCanton;
	}

	public String getImeCodParroquia() {
		return this.imeCodParroquia;
	}

	public void setImeCodParroquia(String imeCodParroquia) {
		this.imeCodParroquia = imeCodParroquia;
	}

	public String getImeParroquia() {
		return this.imeParroquia;
	}

	public void setImeParroquia(String imeParroquia) {
		this.imeParroquia = imeParroquia;
	}

	public String getImeCodInstitucion() {
		return this.imeCodInstitucion;
	}

	public void setImeCodInstitucion(String imeCodInstitucion) {
		this.imeCodInstitucion = imeCodInstitucion;
	}

	public String getImeInstitucion() {
		return this.imeInstitucion;
	}

	public void setImeInstitucion(String imeInstitucion) {
		this.imeInstitucion = imeInstitucion;
	}

	public String getImeDireccionInstitucion() {
		return this.imeDireccionInstitucion;
	}

	public void setImeDireccionInstitucion(String imeDireccionInstitucion) {
		this.imeDireccionInstitucion = imeDireccionInstitucion;
	}

	public String getImeValorPension() {
		return this.imeValorPension;
	}

	public void setImeValorPension(String imeValorPension) {
		this.imeValorPension = imeValorPension;
	}

	public String getImeTipoEducacion() {
		return this.imeTipoEducacion;
	}

	public void setImeTipoEducacion(String imeTipoEducacion) {
		this.imeTipoEducacion = imeTipoEducacion;
	}

	public String getImeNivelEducacion() {
		return this.imeNivelEducacion;
	}

	public void setImeNivelEducacion(String imeNivelEducacion) {
		this.imeNivelEducacion = imeNivelEducacion;
	}

	public String getImeSostenimiento() {
		return this.imeSostenimiento;
	}

	public void setImeSostenimiento(String imeSostenimiento) {
		this.imeSostenimiento = imeSostenimiento;
	}

	public String getImeZonaInec() {
		return this.imeZonaInec;
	}

	public void setImeZonaInec(String imeZonaInec) {
		this.imeZonaInec = imeZonaInec;
	}

	public String getImeRegimenEscolar() {
		return this.imeRegimenEscolar;
	}

	public void setImeRegimenEscolar(String imeRegimenEscolar) {
		this.imeRegimenEscolar = imeRegimenEscolar;
	}

	public String getImeJurisdiccion() {
		return this.imeJurisdiccion;
	}

	public void setImeJurisdiccion(String imeJurisdiccion) {
		this.imeJurisdiccion = imeJurisdiccion;
	}

	public String getImeModallidad() {
		return this.imeModallidad;
	}

	public void setImeModallidad(String imeModallidad) {
		this.imeModallidad = imeModallidad;
	}

	public String getImeJornada() {
		return this.imeJornada;
	}

	public void setImeJornada(String imeJornada) {
		this.imeJornada = imeJornada;
	}

	public String getImeAccesoEdificio() {
		return this.imeAccesoEdificio;
	}

	public void setImeAccesoEdificio(String imeAccesoEdificio) {
		this.imeAccesoEdificio = imeAccesoEdificio;
	}

	public String getImeTenenciaInmuebleEdificio() {
		return this.imeTenenciaInmuebleEdificio;
	}

	public void setImeTenenciaInmuebleEdificio(String imeTenenciaInmuebleEdificio) {
		this.imeTenenciaInmuebleEdificio = imeTenenciaInmuebleEdificio;
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

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsInstitucionMinisterioEdu)) {
			return false;
		}
		InsInstitucionMinisterioEdu other = (InsInstitucionMinisterioEdu) object;
		if ((this.imeCodigo == null && other.imeCodigo != null)
				|| (this.imeCodigo != null && !this.imeCodigo.equals(other.imeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.imeCodigo != null) ? this.imeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "ups.edu.model.InsInstitucionMinisterioEdu[ imeCodigo=" + this.imeCodigo + " ]";
	}

}
