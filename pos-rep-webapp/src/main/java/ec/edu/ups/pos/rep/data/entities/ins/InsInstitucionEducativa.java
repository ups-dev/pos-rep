package ec.edu.ups.pos.rep.data.entities.ins;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_INSTITUCION_EDUCATIVA", schema = "INS")
public class InsInstitucionEducativa extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "INE_CODIGO", nullable = false)
	private Long ineCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ARG_CODIGO", nullable = false)
	private Long argCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "INE_DESCRIPCION", nullable = false, length = 200)
	private String ineDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "INE_NIVEL", nullable = false, length = 1)
	private String ineNivel;

	@Size(max = 200)
	@Column(name = "INE_DIRECCION", length = 200)
	private String ineDireccion;

	@Size(max = 10)
	@Column(name = "INE_NUMERO_DIRECCION", length = 10)
	private String ineNumeroDireccion;

	@Size(max = 10)
	@Column(name = "INE_TELEFONO", length = 10)
	private String ineTelefono;

	@Column(name = "INE_PENSION")
	private BigDecimal inePension;

	@Size(max = 1)
	@Column(name = "INE_VIGENTE", length = 1)
	private String ineVigente;

	@Size(max = 1)
	@Column(name = "INE_NACIONAL", length = 1)
	private String ineNacional;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insInstitucionEducativa", fetch = FetchType.LAZY)
	private Collection<InsAluInsEdu> insAluInsEduCollection;

	@JoinColumn(name = "CAC_CODIGO", referencedColumnName = "CAC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsCategoriaColegio insCategoriaColegio;

	@JoinColumn(name = "TIE_CODIGO", referencedColumnName = "TIE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsTipInsEdu insTipInsEdu;

	@Column(name = "PEL_CODIGO_INI")
	private Long pelCodigoIni;

	@Column(name = "PEL_CODIGO_FIN")
	private Long pelCodigoFin;

	@OneToMany(mappedBy = "insInstitucionEducativa")
	private Collection<InsCarreraInstitucion> insCarreraInstitucionCollection;

	@JoinColumn(name = "IME_CODIGO", referencedColumnName = "IME_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsInstitucionMinisterioEdu insInstitucionMinisterioEdu;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "INE_CONFIRMADO", nullable = false, length = 1)
	private String ineConfirmado;

	@Column(name = "PER_CODIGO")
	private Long perCodigo;

	@Column(name = "INE_FECHA_CONFIRMADO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ineFechaConfirmado;

	@Transient
	private Boolean validaAprobacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insInstiEducativa", fetch = FetchType.LAZY)
	private Collection<InsSancion> insSancionCollection;

	public InsInstitucionEducativa() {
	}

	public InsInstitucionEducativa(Long ineCodigo) {
		this.ineCodigo = ineCodigo;
	}

	public String getIneNacional() {
		return this.ineNacional;
	}

	public void setIneNacional(String ineNacional) {
		this.ineNacional = ineNacional;
	}

	public Long getIneCodigo() {
		return this.ineCodigo;
	}

	public void setIneCodigo(Long ineCodigo) {
		this.ineCodigo = ineCodigo;
	}

	public Long getArgCodigo() {
		return this.argCodigo;
	}

	public void setArgCodigo(Long argCodigo) {
		this.argCodigo = argCodigo;
	}

	public String getIneDescripcion() {
		return this.ineDescripcion;
	}

	public void setIneDescripcion(String ineDescripcion) {
		this.ineDescripcion = ineDescripcion;
	}

	public String getIneNivel() {
		return this.ineNivel;
	}

	public void setIneNivel(String ineNivel) {
		this.ineNivel = ineNivel;
	}

	public String getIneDireccion() {
		return this.ineDireccion;
	}

	public void setIneDireccion(String ineDireccion) {
		this.ineDireccion = ineDireccion;
	}

	public String getIneNumeroDireccion() {
		return this.ineNumeroDireccion;
	}

	public void setIneNumeroDireccion(String ineNumeroDireccion) {
		this.ineNumeroDireccion = ineNumeroDireccion;
	}

	public String getIneTelefono() {
		return this.ineTelefono;
	}

	public void setIneTelefono(String ineTelefono) {
		this.ineTelefono = ineTelefono;
	}

	public BigDecimal getInePension() {
		return this.inePension;
	}

	public void setInePension(BigDecimal inePension) {
		this.inePension = inePension;
	}

	public String getIneVigente() {
		return this.ineVigente;
	}

	public void setIneVigente(String ineVigente) {
		this.ineVigente = ineVigente;
	}

	public InsCategoriaColegio getInsCategoriaColegio() {
		return this.insCategoriaColegio;
	}

	public void setInsCategoriaColegio(InsCategoriaColegio insCategoriaColegio) {
		this.insCategoriaColegio = insCategoriaColegio;
	}

	public InsTipInsEdu getInsTipInsEdu() {
		return this.insTipInsEdu;
	}

	public void setInsTipInsEdu(InsTipInsEdu insTipInsEdu) {
		this.insTipInsEdu = insTipInsEdu;
	}

	public Collection<InsAluInsEdu> getInsAluInsEduCollection() {
		return this.insAluInsEduCollection;
	}

	public void setInsAluInsEduCollection(Collection<InsAluInsEdu> insAluInsEduCollection) {
		this.insAluInsEduCollection = insAluInsEduCollection;
	}

	public Collection<InsCarreraInstitucion> getInsCarreraInstitucionCollection() {
		return this.insCarreraInstitucionCollection;
	}

	public void setInsCarreraInstitucionCollection(Collection<InsCarreraInstitucion> insCarreraInstitucionCollection) {
		this.insCarreraInstitucionCollection = insCarreraInstitucionCollection;
	}

	public Long getPelCodigoIni() {
		return this.pelCodigoIni;
	}

	public void setPelCodigoIni(Long pelCodigoIni) {
		this.pelCodigoIni = pelCodigoIni;
	}

	public Long getPelCodigoFin() {
		return this.pelCodigoFin;
	}

	public void setPelCodigoFin(Long pelCodigoFin) {
		this.pelCodigoFin = pelCodigoFin;
	}

	public InsInstitucionMinisterioEdu getInsInstitucionMinisterioEdu() {
		return this.insInstitucionMinisterioEdu;
	}

	public void setInsInstitucionMinisterioEdu(InsInstitucionMinisterioEdu insInstitucionMinisterioEdu) {
		this.insInstitucionMinisterioEdu = insInstitucionMinisterioEdu;
	}

	public String getIneConfirmado() {
		return this.ineConfirmado;
	}

	public void setIneConfirmado(String ineConfirmado) {
		this.ineConfirmado = ineConfirmado;
	}

	public Boolean getValidaAprobacion() {
		return this.ineConfirmado != null && this.ineConfirmado.equals("S");
	}

	public void setValidaAprobacion(Boolean validaAprobacion) {
		this.validaAprobacion = validaAprobacion;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Date getIneFechaConfirmado() {
		return this.ineFechaConfirmado;
	}

	public void setIneFechaConfirmado(Date ineFechaConfirmado) {
		this.ineFechaConfirmado = ineFechaConfirmado;
	}

	public Collection<InsSancion> getInsSancionCollection() {
		return this.insSancionCollection;
	}

	public void setInsSancionCollection(Collection<InsSancion> insSancionCollection) {
		this.insSancionCollection = insSancionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsInstitucionEducativa)) {
			return false;
		}
		InsInstitucionEducativa other = (InsInstitucionEducativa) object;
		if ((this.ineCodigo == null && other.ineCodigo != null)
				|| (this.ineCodigo != null && !this.ineCodigo.equals(other.ineCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ineCodigo != null) ? this.ineCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsInstitucionEducativa{" + "ineCodigo=" + this.ineCodigo + ", ineDescripcion='" + this.ineDescripcion
				+ '\'' + ", ineDireccion='" + this.ineDireccion + '\'' + '}';
	}

}
