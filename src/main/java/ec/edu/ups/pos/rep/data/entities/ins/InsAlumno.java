package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_ALUMNO", schema = "INS", uniqueConstraints = { @UniqueConstraint(columnNames = { "CLLC_CDG" }) })
@SequenceGenerator(name = "INS_ALUMNO_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsAlumno extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_ALUMNO_SQ")
	@NotNull
	@Column(name = "ALU_CODIGO", nullable = false)
	private Long aluCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CLLC_CDG", nullable = false)
	private Long cllcCdg;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ARG_CODIGO_NAC", nullable = false)
	private Long argCodigoNac;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ARG_CODIGO_DOM")
	private Long argCodigoDom;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "ALU_APELLIDOS", nullable = false, length = 50)
	private String aluApellidos;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "ALU_NOMBRES", nullable = false, length = 50)
	private String aluNombres;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "ALU_GENERO", nullable = false, length = 1)
	private String aluGenero;

	@Column(name = "ALU_FECHA_NACIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date aluFechaNacimiento;

	@Size(max = 100)
	@Column(name = "ALU_DIRECCION_CALLE_SEC", length = 100)
	private String aluDireccionCalleSec;

	@Size(max = 100)
	@Column(name = "ALU_DIRECCION_DATO_ADI", length = 100)
	private String aluDireccionDatoAdi;

	@Size(max = 12)
	@Column(name = "ALU_CEDULA_MILITAR", length = 12)
	private String aluCedulaMilitar;

	@Size(max = 1)
	@Column(name = "ALU_TIPO_DOCUMENTO_MILITAR", length = 1)
	private String aluTipoDocumentoMilitar;

	@Size(max = 20)
	@Column(name = "ALU_NUMERO_AFILIACION_IESS", length = 20)
	private String aluNumeroAfiliacionIess;

	@Size(max = 1)
	@Column(name = "ALU_VIGENCIA", length = 1)
	private String aluVigencia;

	@Size(max = 250)
	@Column(name = "ALU_EMAIL", length = 250)
	private String aluEmail;

	@Column(name = "ALU_EMAIL_STATUS")
	private Integer aluEmailStatus;

	@Size(max = 1)
	@Column(name = "ALU_NOTIFICACION_SMS", length = 1)
	private String aluNotificacionSms;

	@Size(max = 200)
	@Column(name = "ALU_BARRIO", length = 200)
	private String aluBarrio;

	@Size(max = 200)
	@Column(name = "ALU_NOMBRE_PERSONA_CONTACTO", length = 200)
	private String aluNombrePersonaContacto;

	@Size(max = 100)
	@Column(name = "ALU_TELEFONO_PERSONA_CONTACTO", length = 100)
	private String aluTelefonoPersonaContacto;

	@Size(max = 100)
	@Column(name = "ALU_NACIONALIDAD", length = 100)
	private String aluNacionalidad;

	@Size(max = 1)
	@Column(name = "ALU_PRESENTAR_CLAVE", length = 1)
	private String aluPresentarClave;

	@Size(max = 1)
	@Column(name = "ALU_TIPO_DOCUMENTO", length = 1)
	private String aluTipoDocumento;

	@Size(max = 30)
	@Column(name = "ALU_CLAVE", length = 30)
	private String aluClave;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "ALU_DATOS_ACTUALIZADOS", nullable = false, length = 1)
	private String aluDatosActualizados;

	@Column(name = "ALU_FECHA_ACTUALIZACION_DATOS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date aluFechaActualizacionDatos;

	@JoinColumn(name = "TIS_CODIGO", referencedColumnName = "TIS_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsTipoSangre insTipoSangre;

	@JoinColumn(name = "REL_CODIGO", referencedColumnName = "REL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsReligion insReligion;

	@JoinColumn(name = "RAZ_CODIGO", referencedColumnName = "RAZ_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsRaza insRaza;

	@JoinColumn(name = "OPC_CODIGO", referencedColumnName = "OPC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsOperadoraCelular insOperadoraCelular;

	@JoinColumn(name = "LEN_CODIGO", referencedColumnName = "LEN_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsLenguaje insLenguaje;

	@JoinColumn(name = "ESC_CODIGO", referencedColumnName = "ESC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsEstadoCivil insEstadoCivil;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insAlumno", fetch = FetchType.LAZY)
	private Collection<InsInscripcion> insInscripcionCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insAlumno", fetch = FetchType.LAZY)
	private Collection<InsAluInsEdu> insAluInsEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insAlumno", fetch = FetchType.LAZY)
	private Collection<InsSancion> insSancionCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insAlumno", fetch = FetchType.LAZY)
	private Collection<InsAlumnoRedSocial> insAlumnoRedSocialCollection;

	@JoinColumn(name = "RES_CODIGO", referencedColumnName = "RES_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private InsResolucion insResolucion;

	@JoinColumn(name = "IGE_CODIGO", referencedColumnName = "IGE_CODIGO")
	@ManyToOne(optional = true)
	private InsGrupoEtnico insGrupoEtnico;

	@Column(name = "ALU_CIUDAD_NAC_OTRO", length = 250, nullable = true)
	private String aluCiudadNacOtro;

	@Column(name = "ALU_PROVINCIA_NAC_OTRO", length = 250, nullable = true)
	private String aluProvinciaNacOtro;

	@Column(name = "ALU_PARROQUIA_NAC_OTRO", length = 250, nullable = true)
	private String aluParroquiaNacOtro;

	@Column(name = "ALU_CIUDAD_DOM_OTRO", length = 250, nullable = true)
	private String aluCiudadDomOtro;

	@Column(name = "ALU_PROVINCIA_DOM_OTRO", length = 250, nullable = true)
	private String aluProvinciaDomOtro;

	@Column(name = "ALU_PARROQUIA_DOM_OTRO", length = 250, nullable = true)
	private String aluParroquiaDomOtro;

	public InsAlumno() {
	}

	public InsAlumno(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public Long getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public Long getCllcCdg() {
		return this.cllcCdg;
	}

	public void setCllcCdg(Long cllcCdg) {
		this.cllcCdg = cllcCdg;
	}

	public Long getArgCodigoNac() {
		return this.argCodigoNac;
	}

	public void setArgCodigoNac(Long argCodigoNac) {
		this.argCodigoNac = argCodigoNac;
	}

	public Long getArgCodigoDom() {
		return this.argCodigoDom;
	}

	public void setArgCodigoDom(Long argCodigoDom) {
		this.argCodigoDom = argCodigoDom;
	}

	public String getAluApellidos() {
		return this.aluApellidos;
	}

	public void setAluApellidos(String aluApellidos) {
		this.aluApellidos = aluApellidos;
	}

	public String getAluNombres() {
		return this.aluNombres;
	}

	public void setAluNombres(String aluNombres) {
		this.aluNombres = aluNombres;
	}

	public String getAluGenero() {
		return this.aluGenero;
	}

	public void setAluGenero(String aluGenero) {
		this.aluGenero = aluGenero;
	}

	public Date getAluFechaNacimiento() {
		return this.aluFechaNacimiento;
	}

	public void setAluFechaNacimiento(Date aluFechaNacimiento) {
		this.aluFechaNacimiento = aluFechaNacimiento;
	}

	public String getAluDireccionCalleSec() {
		return this.aluDireccionCalleSec;
	}

	public void setAluDireccionCalleSec(String aluDireccionCalleSec) {
		this.aluDireccionCalleSec = aluDireccionCalleSec;
	}

	public String getAluDireccionDatoAdi() {
		return this.aluDireccionDatoAdi;
	}

	public void setAluDireccionDatoAdi(String aluDireccionDatoAdi) {
		this.aluDireccionDatoAdi = aluDireccionDatoAdi;
	}

	public String getAluCedulaMilitar() {
		return this.aluCedulaMilitar;
	}

	public void setAluCedulaMilitar(String aluCedulaMilitar) {
		this.aluCedulaMilitar = aluCedulaMilitar;
	}

	public String getAluTipoDocumentoMilitar() {
		return this.aluTipoDocumentoMilitar;
	}

	public void setAluTipoDocumentoMilitar(String aluTipoDocumentoMilitar) {
		this.aluTipoDocumentoMilitar = aluTipoDocumentoMilitar;
	}

	public String getAluNumeroAfiliacionIess() {
		return this.aluNumeroAfiliacionIess;
	}

	public void setAluNumeroAfiliacionIess(String aluNumeroAfiliacionIess) {
		this.aluNumeroAfiliacionIess = aluNumeroAfiliacionIess;
	}

	public String getAluVigencia() {
		return this.aluVigencia;
	}

	public void setAluVigencia(String aluVigencia) {
		this.aluVigencia = aluVigencia;
	}

	public String getAluEmail() {
		return this.aluEmail;
	}

	public void setAluEmail(String aluEmail) {
		this.aluEmail = aluEmail;
	}

	public Integer getAluEmailStatus() {
		return this.aluEmailStatus;
	}

	public void setAluEmailStatus(Integer aluEmailStatus) {
		this.aluEmailStatus = aluEmailStatus;
	}

	public String getAluNotificacionSms() {
		return this.aluNotificacionSms;
	}

	public void setAluNotificacionSms(String aluNotificacionSms) {
		this.aluNotificacionSms = aluNotificacionSms;
	}

	public String getAluBarrio() {
		return this.aluBarrio;
	}

	public void setAluBarrio(String aluBarrio) {
		this.aluBarrio = aluBarrio;
	}

	public String getAluNombrePersonaContacto() {
		return this.aluNombrePersonaContacto;
	}

	public void setAluNombrePersonaContacto(String aluNombrePersonaContacto) {
		this.aluNombrePersonaContacto = aluNombrePersonaContacto;
	}

	public String getAluTelefonoPersonaContacto() {
		return this.aluTelefonoPersonaContacto;
	}

	public void setAluTelefonoPersonaContacto(String aluTelefonoPersonaContacto) {
		this.aluTelefonoPersonaContacto = aluTelefonoPersonaContacto;
	}

	public String getAluNacionalidad() {
		return this.aluNacionalidad;
	}

	public void setAluNacionalidad(String aluNacionalidad) {
		this.aluNacionalidad = aluNacionalidad;
	}

	public String getAluPresentarClave() {
		return this.aluPresentarClave;
	}

	public void setAluPresentarClave(String aluPresentarClave) {
		this.aluPresentarClave = aluPresentarClave;
	}

	public String getAluTipoDocumento() {
		return this.aluTipoDocumento;
	}

	public void setAluTipoDocumento(String aluTipoDocumento) {
		this.aluTipoDocumento = aluTipoDocumento;
	}

	public Collection<InsAluInsEdu> getInsAluInsEduCollection() {

		return this.insAluInsEduCollection;
	}

	public void setInsAluInsEduCollection(List<InsAluInsEdu> insAluInsEduCollection) {
		this.insAluInsEduCollection = insAluInsEduCollection;
	}

	public Collection<InsInscripcion> getInsInscripcionCollection() {
		return this.insInscripcionCollection;
	}

	public void setInsInscripcionCollection(List<InsInscripcion> insInscripcionCollection) {
		this.insInscripcionCollection = insInscripcionCollection;
	}

	public Collection<InsSancion> getInsSancionCollection() {
		return this.insSancionCollection;
	}

	public void setInsSancionCollection(List<InsSancion> insSancionCollection) {
		this.insSancionCollection = insSancionCollection;
	}

	public Collection<InsAlumnoRedSocial> getInsAlumnoRedSocialCollection() {
		return this.insAlumnoRedSocialCollection;
	}

	public void setInsAlumnoRedSocialCollection(Collection<InsAlumnoRedSocial> insAlumnoRedSocialCollection) {
		this.insAlumnoRedSocialCollection = insAlumnoRedSocialCollection;
	}

	public InsTipoSangre getInsTipoSangre() {
		return this.insTipoSangre;
	}

	public void setInsTipoSangre(InsTipoSangre insTipoSangre) {
		this.insTipoSangre = insTipoSangre;
	}

	public InsReligion getInsReligion() {
		return this.insReligion;
	}

	public void setInsReligion(InsReligion insReligion) {
		this.insReligion = insReligion;
	}

	public InsRaza getInsRaza() {
		return this.insRaza;
	}

	public void setInsRaza(InsRaza insRaza) {
		this.insRaza = insRaza;
	}

	public InsOperadoraCelular getInsOperadoraCelular() {
		return this.insOperadoraCelular;
	}

	public void setInsOperadoraCelular(InsOperadoraCelular insOperadoraCelular) {
		this.insOperadoraCelular = insOperadoraCelular;
	}

	public InsLenguaje getInsLenguaje() {
		return this.insLenguaje;
	}

	public void setInsLenguaje(InsLenguaje insLenguaje) {
		this.insLenguaje = insLenguaje;
	}

	public InsEstadoCivil getInsEstadoCivil() {
		return this.insEstadoCivil;
	}

	public void setInsEstadoCivil(InsEstadoCivil insEstadoCivil) {
		this.insEstadoCivil = insEstadoCivil;
	}

	public String getAluClave() {
		return this.aluClave;
	}

	public void setAluClave(String aluClave) {
		this.aluClave = aluClave;
	}

	public InsResolucion getInsResolucion() {
		return this.insResolucion;
	}

	public void setInsResolucion(InsResolucion insResolucion) {
		this.insResolucion = insResolucion;
	}

	public InsGrupoEtnico getInsGrupoEtnico() {
		return this.insGrupoEtnico;
	}

	public void setInsGrupoEtnico(InsGrupoEtnico insGrupoEtnico) {
		this.insGrupoEtnico = insGrupoEtnico;
	}

	public String getAluDatosActualizados() {
		return this.aluDatosActualizados;
	}

	public void setAluDatosActualizados(String aluDatosActualizados) {
		this.aluDatosActualizados = aluDatosActualizados;
	}

	public Date getAluFechaActualizacionDatos() {
		return this.aluFechaActualizacionDatos;
	}

	public void setAluFechaActualizacionDatos(Date aluFechaActualizacionDatos) {
		this.aluFechaActualizacionDatos = aluFechaActualizacionDatos;
	}

	public String getAluCiudadNacOtro() {
		return this.aluCiudadNacOtro;
	}

	public void setAluCiudadNacOtro(String aluCiudadNacOtro) {
		this.aluCiudadNacOtro = aluCiudadNacOtro;
	}

	public String getAluProvinciaNacOtro() {
		return this.aluProvinciaNacOtro;
	}

	public void setAluProvinciaNacOtro(String aluProvinciaNacOtro) {
		this.aluProvinciaNacOtro = aluProvinciaNacOtro;
	}

	public String getAluParroquiaNacOtro() {
		return this.aluParroquiaNacOtro;
	}

	public void setAluParroquiaNacOtro(String aluParroquiaNacOtro) {
		this.aluParroquiaNacOtro = aluParroquiaNacOtro;
	}

	public String getAluCiudadDomOtro() {
		return this.aluCiudadDomOtro;
	}

	public void setAluCiudadDomOtro(String aluCiudadDomOtro) {
		this.aluCiudadDomOtro = aluCiudadDomOtro;
	}

	public String getAluProvinciaDomOtro() {
		return this.aluProvinciaDomOtro;
	}

	public void setAluProvinciaDomOtro(String aluProvinciaDomOtro) {
		this.aluProvinciaDomOtro = aluProvinciaDomOtro;
	}

	public String getAluParroquiaDomOtro() {
		return this.aluParroquiaDomOtro;
	}

	public void setAluParroquiaDomOtro(String aluParroquiaDomOtro) {
		this.aluParroquiaDomOtro = aluParroquiaDomOtro;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsAlumno)) {
			return false;
		}
		InsAlumno other = (InsAlumno) object;
		if ((this.aluCodigo == null && other.aluCodigo != null)
				|| (this.aluCodigo != null && !this.aluCodigo.equals(other.aluCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.aluCodigo != null) ? this.aluCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsAlumno[ aluCodigo=" + this.aluCodigo + " ]";
	}

}
