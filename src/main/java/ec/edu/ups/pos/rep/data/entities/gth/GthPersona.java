package ec.edu.ups.pos.rep.data.entities.gth;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "GTH_PERSONA", catalog = "", schema = "GTH", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PER_NRO_SEGURO_SOCIAL"}),
    @UniqueConstraint(columnNames = {"PER_NRO_IDENTIFICACION"}),
    @UniqueConstraint(columnNames = {"PER_NRO_PASAPORTE"})})
@XmlRootElement
public class GthPersona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGO", nullable = false)
    private Long perCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PER_NRO_IDENTIFICACION", nullable = false, length = 32)
    private String perNroIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_APELLIDOS", nullable = false, length = 50)
    private String perApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_NOMBRES", nullable = false, length = 50)
    private String perNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PER_GENERO", nullable = false, length = 1)
    private String perGenero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_CALLE_PRINCIPAL", nullable = false, length = 50)
    private String perCallePrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PER_NRO_CASA", nullable = false, length = 10)
    private String perNroCasa;
    @Size(max = 50)
    @Column(name = "PER_CALLE_SECUNDARIA", length = 50)
    private String perCalleSecundaria;
    @Size(max = 250)
    @Column(name = "PER_REFERENCIA", length = 250)
    private String perReferencia;
    @Size(max = 32)
    @Column(name = "PER_NRO_PASAPORTE", length = 32)
    private String perNroPasaporte;
    @Column(name = "PER_PAS_FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perPasFechaEmision;
    @Column(name = "PER_PAS_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perPasFechaVencimiento;
    @Size(max = 20)
    @Column(name = "PER_CASILLA", length = 20)
    private String perCasilla;
    @Size(max = 20)
    @Column(name = "PER_NRO_SEGURO_SOCIAL", length = 20)
    private String perNroSeguroSocial;
    @Column(name = "PER_FECHA_AFILIACION_SEGURO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaAfiliacionSeguro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PER_ELIMINADO", nullable = false, length = 1)
    private String perEliminado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PER_ADICIONADO", nullable = false, length = 30)
    private String perAdicionado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_FECHA_ADICION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaAdicion;
    @Size(max = 30)
    @Column(name = "PER_MODIFICADO", length = 30)
    private String perModificado;
    @Column(name = "PER_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaModificacion;

    /*
    @JoinColumn(name = "TII_CODIGO", referencedColumnName = "TII_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GthTipoIdentificacion gthTipoIdentificacion;
    @JoinColumn(name = "REL_CODIGO", referencedColumnName = "REL_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GthReligion gthReligion;
    @JoinColumn(name = "ESC_CODIGO", referencedColumnName = "ESC_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GthEstadoCivil gthEstadoCivil;
    @JoinColumn(name = "TIS_CODIGO", referencedColumnName = "TIS_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GthTipoSangre gthTipoSangre;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private GthFirmaDigital gthFirmaDigital;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private GthFoto gthFoto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthBienInmueble> gthBienInmuebleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthBienMueble> gthBienMuebleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthCuentaBancaria> gthCuentaBancariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthDependiente> gthDependienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthDiscapacidadPersona> gthDiscapacidadPersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthEducacionFormal> gthEducacionFormalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthEducacionInformal> gthEducacionInformalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthEmergencia> gthEmergenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthExperienciaInvestigacion> gthExperienciaInvestigacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthExperienciaLaboral> gthExperienciaLaboralCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthHobby> gthHobbyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthIdiomaPersona> gthIdiomaPersonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthLicenciaConducir> gthLicenciaConducirCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthMail> gthMailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthReferencia> gthReferenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthSeniaParticular> gthSeniaParticularCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthServicioMilitar> gthServicioMilitarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthTelefono> gthTelefonoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthVehiculo> gthVehiculoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gthPersona", fetch = FetchType.LAZY)
    private Collection<GthVisa> gthVisaCollection;
     */
    public GthPersona() {
    }

    public GthPersona(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerNroIdentificacion() {
        return perNroIdentificacion;
    }

    public void setPerNroIdentificacion(String perNroIdentificacion) {
        this.perNroIdentificacion = perNroIdentificacion;
    }

    public String getPerApellidos() {
        return perApellidos;
    }

    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerCallePrincipal() {
        return perCallePrincipal;
    }

    public void setPerCallePrincipal(String perCallePrincipal) {
        this.perCallePrincipal = perCallePrincipal;
    }

    public String getPerNroCasa() {
        return perNroCasa;
    }

    public void setPerNroCasa(String perNroCasa) {
        this.perNroCasa = perNroCasa;
    }

    public String getPerCalleSecundaria() {
        return perCalleSecundaria;
    }

    public void setPerCalleSecundaria(String perCalleSecundaria) {
        this.perCalleSecundaria = perCalleSecundaria;
    }

    public String getPerReferencia() {
        return perReferencia;
    }

    public void setPerReferencia(String perReferencia) {
        this.perReferencia = perReferencia;
    }

    public String getPerNroPasaporte() {
        return perNroPasaporte;
    }

    public void setPerNroPasaporte(String perNroPasaporte) {
        this.perNroPasaporte = perNroPasaporte;
    }

    public Date getPerPasFechaEmision() {
        return perPasFechaEmision;
    }

    public void setPerPasFechaEmision(Date perPasFechaEmision) {
        this.perPasFechaEmision = perPasFechaEmision;
    }

    public Date getPerPasFechaVencimiento() {
        return perPasFechaVencimiento;
    }

    public void setPerPasFechaVencimiento(Date perPasFechaVencimiento) {
        this.perPasFechaVencimiento = perPasFechaVencimiento;
    }

    public String getPerCasilla() {
        return perCasilla;
    }

    public void setPerCasilla(String perCasilla) {
        this.perCasilla = perCasilla;
    }

    public String getPerNroSeguroSocial() {
        return perNroSeguroSocial;
    }

    public void setPerNroSeguroSocial(String perNroSeguroSocial) {
        this.perNroSeguroSocial = perNroSeguroSocial;
    }

    public Date getPerFechaAfiliacionSeguro() {
        return perFechaAfiliacionSeguro;
    }

    public void setPerFechaAfiliacionSeguro(Date perFechaAfiliacionSeguro) {
        this.perFechaAfiliacionSeguro = perFechaAfiliacionSeguro;
    }

    public String getPerEliminado() {
        return perEliminado;
    }

    public void setPerEliminado(String perEliminado) {
        this.perEliminado = perEliminado;
    }

    public String getPerAdicionado() {
        return perAdicionado;
    }

    public void setPerAdicionado(String perAdicionado) {
        this.perAdicionado = perAdicionado;
    }

    public Date getPerFechaAdicion() {
        return perFechaAdicion;
    }

    public void setPerFechaAdicion(Date perFechaAdicion) {
        this.perFechaAdicion = perFechaAdicion;
    }

    public String getPerModificado() {
        return perModificado;
    }

    public void setPerModificado(String perModificado) {
        this.perModificado = perModificado;
    }

    public Date getPerFechaModificacion() {
        return perFechaModificacion;
    }

    public void setPerFechaModificacion(Date perFechaModificacion) {
        this.perFechaModificacion = perFechaModificacion;
    }

    /*
    public GthTipoIdentificacion getGthTipoIdentificacion() {
        return gthTipoIdentificacion;
    }

    public void setGthTipoIdentificacion(GthTipoIdentificacion gthTipoIdentificacion) {
        this.gthTipoIdentificacion = gthTipoIdentificacion;
    }

    public GthReligion getGthReligion() {
        return gthReligion;
    }

    public void setGthReligion(GthReligion gthReligion) {
        this.gthReligion = gthReligion;
    }

    public GthEstadoCivil getGthEstadoCivil() {
        return gthEstadoCivil;
    }

    public void setGthEstadoCivil(GthEstadoCivil gthEstadoCivil) {
        this.gthEstadoCivil = gthEstadoCivil;
    }

    public GthTipoSangre getGthTipoSangre() {
        return gthTipoSangre;
    }

    public void setGthTipoSangre(GthTipoSangre gthTipoSangre) {
        this.gthTipoSangre = gthTipoSangre;
    }

    public GthFirmaDigital getGthFirmaDigital() {
        return gthFirmaDigital;
    }

    public void setGthFirmaDigital(GthFirmaDigital gthFirmaDigital) {
        this.gthFirmaDigital = gthFirmaDigital;
    }

    public GthFoto getGthFoto() {
        return gthFoto;
    }

    public void setGthFoto(GthFoto gthFoto) {
        this.gthFoto = gthFoto;
    }

    @XmlTransient
    public Collection<GthBienInmueble> getGthBienInmuebleCollection() {
        return gthBienInmuebleCollection;
    }

    public void setGthBienInmuebleCollection(Collection<GthBienInmueble> gthBienInmuebleCollection) {
        this.gthBienInmuebleCollection = gthBienInmuebleCollection;
    }

    @XmlTransient
    public Collection<GthBienMueble> getGthBienMuebleCollection() {
        return gthBienMuebleCollection;
    }

    public void setGthBienMuebleCollection(Collection<GthBienMueble> gthBienMuebleCollection) {
        this.gthBienMuebleCollection = gthBienMuebleCollection;
    }

    @XmlTransient
    public Collection<GthCuentaBancaria> getGthCuentaBancariaCollection() {
        return gthCuentaBancariaCollection;
    }

    public void setGthCuentaBancariaCollection(Collection<GthCuentaBancaria> gthCuentaBancariaCollection) {
        this.gthCuentaBancariaCollection = gthCuentaBancariaCollection;
    }

    @XmlTransient
    public Collection<GthDependiente> getGthDependienteCollection() {
        return gthDependienteCollection;
    }

    public void setGthDependienteCollection(Collection<GthDependiente> gthDependienteCollection) {
        this.gthDependienteCollection = gthDependienteCollection;
    }

    @XmlTransient
    public Collection<GthDiscapacidadPersona> getGthDiscapacidadPersonaCollection() {
        return gthDiscapacidadPersonaCollection;
    }

    public void setGthDiscapacidadPersonaCollection(Collection<GthDiscapacidadPersona> gthDiscapacidadPersonaCollection) {
        this.gthDiscapacidadPersonaCollection = gthDiscapacidadPersonaCollection;
    }

    @XmlTransient
    public Collection<GthEducacionFormal> getGthEducacionFormalCollection() {
        return gthEducacionFormalCollection;
    }

    public void setGthEducacionFormalCollection(Collection<GthEducacionFormal> gthEducacionFormalCollection) {
        this.gthEducacionFormalCollection = gthEducacionFormalCollection;
    }

    @XmlTransient
    public Collection<GthEducacionInformal> getGthEducacionInformalCollection() {
        return gthEducacionInformalCollection;
    }

    public void setGthEducacionInformalCollection(Collection<GthEducacionInformal> gthEducacionInformalCollection) {
        this.gthEducacionInformalCollection = gthEducacionInformalCollection;
    }

    @XmlTransient
    public Collection<GthEmergencia> getGthEmergenciaCollection() {
        return gthEmergenciaCollection;
    }

    public void setGthEmergenciaCollection(Collection<GthEmergencia> gthEmergenciaCollection) {
        this.gthEmergenciaCollection = gthEmergenciaCollection;
    }

    @XmlTransient
    public Collection<GthExperienciaInvestigacion> getGthExperienciaInvestigacionCollection() {
        return gthExperienciaInvestigacionCollection;
    }

    public void setGthExperienciaInvestigacionCollection(Collection<GthExperienciaInvestigacion> gthExperienciaInvestigacionCollection) {
        this.gthExperienciaInvestigacionCollection = gthExperienciaInvestigacionCollection;
    }

    @XmlTransient
    public Collection<GthExperienciaLaboral> getGthExperienciaLaboralCollection() {
        return gthExperienciaLaboralCollection;
    }

    public void setGthExperienciaLaboralCollection(Collection<GthExperienciaLaboral> gthExperienciaLaboralCollection) {
        this.gthExperienciaLaboralCollection = gthExperienciaLaboralCollection;
    }

    @XmlTransient
    public Collection<GthHobby> getGthHobbyCollection() {
        return gthHobbyCollection;
    }

    public void setGthHobbyCollection(Collection<GthHobby> gthHobbyCollection) {
        this.gthHobbyCollection = gthHobbyCollection;
    }

    @XmlTransient
    public Collection<GthIdiomaPersona> getGthIdiomaPersonaCollection() {
        return gthIdiomaPersonaCollection;
    }

    public void setGthIdiomaPersonaCollection(Collection<GthIdiomaPersona> gthIdiomaPersonaCollection) {
        this.gthIdiomaPersonaCollection = gthIdiomaPersonaCollection;
    }

    @XmlTransient
    public Collection<GthLicenciaConducir> getGthLicenciaConducirCollection() {
        return gthLicenciaConducirCollection;
    }

    public void setGthLicenciaConducirCollection(Collection<GthLicenciaConducir> gthLicenciaConducirCollection) {
        this.gthLicenciaConducirCollection = gthLicenciaConducirCollection;
    }

    @XmlTransient
    public Collection<GthMail> getGthMailCollection() {
        return gthMailCollection;
    }

    public void setGthMailCollection(Collection<GthMail> gthMailCollection) {
        this.gthMailCollection = gthMailCollection;
    }

    @XmlTransient
    public Collection<GthReferencia> getGthReferenciaCollection() {
        return gthReferenciaCollection;
    }

    public void setGthReferenciaCollection(Collection<GthReferencia> gthReferenciaCollection) {
        this.gthReferenciaCollection = gthReferenciaCollection;
    }

    @XmlTransient
    public Collection<GthSeniaParticular> getGthSeniaParticularCollection() {
        return gthSeniaParticularCollection;
    }

    public void setGthSeniaParticularCollection(Collection<GthSeniaParticular> gthSeniaParticularCollection) {
        this.gthSeniaParticularCollection = gthSeniaParticularCollection;
    }

    @XmlTransient
    public Collection<GthServicioMilitar> getGthServicioMilitarCollection() {
        return gthServicioMilitarCollection;
    }

    public void setGthServicioMilitarCollection(Collection<GthServicioMilitar> gthServicioMilitarCollection) {
        this.gthServicioMilitarCollection = gthServicioMilitarCollection;
    }

    @XmlTransient
    public Collection<GthTelefono> getGthTelefonoCollection() {
        return gthTelefonoCollection;
    }

    public void setGthTelefonoCollection(Collection<GthTelefono> gthTelefonoCollection) {
        this.gthTelefonoCollection = gthTelefonoCollection;
    }

    @XmlTransient
    public Collection<GthVehiculo> getGthVehiculoCollection() {
        return gthVehiculoCollection;
    }

    public void setGthVehiculoCollection(Collection<GthVehiculo> gthVehiculoCollection) {
        this.gthVehiculoCollection = gthVehiculoCollection;
    }

    @XmlTransient
    public Collection<GthVisa> getGthVisaCollection() {
        return gthVisaCollection;
    }

    public void setGthVisaCollection(Collection<GthVisa> gthVisaCollection) {
        this.gthVisaCollection = gthVisaCollection;
    }
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GthPersona)) {
            return false;
        }
        GthPersona other = (GthPersona) object;
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GthPersona[ perCodigo=" + perCodigo + " ]";
    }

}
