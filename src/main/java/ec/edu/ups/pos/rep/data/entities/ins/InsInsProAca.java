package ec.edu.ups.pos.rep.data.entities.ins;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_INS_PRO_ACA", schema = "INS")
public class InsInsProAca extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "IPA_CODIGO", nullable = false)
	private Long ipaCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MPE_CODIGO", nullable = false)
	private long mpeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "IPA_VIGENTE", nullable = false, length = 1)
	private String ipaVigente;

	@Column(name = "IPA_FECHA_INICIO_VIGENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ipaFechaInicioVigencia;

	@Column(name = "IPA_FECHA_FIN_VIGENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ipaFechaFinVigencia;

	@Column(name = "MXI_CODIGO_LEG")
	private Long mxiCodigoLeg;

	@Size(max = 10)
	@Column(name = "INA_NUMERO_LEG", length = 10)
	private String inaNumeroLeg;

	@Column(name = "SED_CODIGO_LEG")
	private Long sedCodigoLeg;

	@Column(name = "PEL_CODIGO_LEG")
	private Long pelCodigoLeg;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insInsProAca", fetch = FetchType.LAZY)
	private Collection<InsIpaCdd> insIpaCddInsCollection;

	@JoinColumn(name = "INS_CODIGO", referencedColumnName = "INS_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private InsInscripcion insInscripcion;

	@Column(name = "HIE_CODIGO")
	private Long hieCodigo;

	@Column(name = "PEL_CODIGO_INICIO_PROYECTO")
	private Long pelCodigoInicioProyecto;

	public InsInsProAca() {
	}

	public InsInsProAca(Long ipaCodigo) {
		this.ipaCodigo = ipaCodigo;
	}

	public InsInsProAca(Long ipaCodigo, long mpeCodigo, String ipaVigente) {
		this.ipaCodigo = ipaCodigo;
		this.mpeCodigo = mpeCodigo;
		this.ipaVigente = ipaVigente;
	}

	public Long getIpaCodigo() {
		return this.ipaCodigo;
	}

	public void setIpaCodigo(Long ipaCodigo) {
		this.ipaCodigo = ipaCodigo;
	}

	public long getMpeCodigo() {
		return this.mpeCodigo;
	}

	public void setMpeCodigo(long mpeCodigo) {
		this.mpeCodigo = mpeCodigo;
	}

	public String getIpaVigente() {
		return this.ipaVigente;
	}

	public void setIpaVigente(String ipaVigente) {
		this.ipaVigente = ipaVigente;
	}

	public Date getIpaFechaInicioVigencia() {
		return this.ipaFechaInicioVigencia;
	}

	public void setIpaFechaInicioVigencia(Date ipaFechaInicioVigencia) {
		this.ipaFechaInicioVigencia = ipaFechaInicioVigencia;
	}

	public Date getIpaFechaFinVigencia() {
		return this.ipaFechaFinVigencia;
	}

	public void setIpaFechaFinVigencia(Date ipaFechaFinVigencia) {
		this.ipaFechaFinVigencia = ipaFechaFinVigencia;
	}

	public Long getMxiCodigoLeg() {
		return this.mxiCodigoLeg;
	}

	public void setMxiCodigoLeg(Long mxiCodigoLeg) {
		this.mxiCodigoLeg = mxiCodigoLeg;
	}

	public String getInaNumeroLeg() {
		return this.inaNumeroLeg;
	}

	public void setInaNumeroLeg(String inaNumeroLeg) {
		this.inaNumeroLeg = inaNumeroLeg;
	}

	public Long getSedCodigoLeg() {
		return this.sedCodigoLeg;
	}

	public void setSedCodigoLeg(Long sedCodigoLeg) {
		this.sedCodigoLeg = sedCodigoLeg;
	}

	public Long getPelCodigoLeg() {
		return this.pelCodigoLeg;
	}

	public void setPelCodigoLeg(Long pelCodigoLeg) {
		this.pelCodigoLeg = pelCodigoLeg;
	}

	public InsInscripcion getInsInscripcion() {
		return this.insInscripcion;
	}

	public void setInsInscripcion(InsInscripcion insInscripcion) {
		this.insInscripcion = insInscripcion;
	}

	public Collection<InsIpaCdd> getInsIpaCddInsCollection() {
		return this.insIpaCddInsCollection;
	}

	public void setInsIpaCddInsCollection(Collection<InsIpaCdd> insIpaCddInsCollection) {
		this.insIpaCddInsCollection = insIpaCddInsCollection;
	}

	public Long getHieCodigo() {
		return this.hieCodigo;
	}

	public void setHieCodigo(Long hieCodigo) {
		this.hieCodigo = hieCodigo;
	}

	public Long getPelCodigoInicioProyecto() {
		return this.pelCodigoInicioProyecto;
	}

	public void setPelCodigoInicioProyecto(Long pelCodigoInicioProyecto) {
		this.pelCodigoInicioProyecto = pelCodigoInicioProyecto;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsInsProAca)) {
			return false;
		}
		InsInsProAca other = (InsInsProAca) object;
		if ((this.ipaCodigo == null && other.ipaCodigo != null)
				|| (this.ipaCodigo != null && !this.ipaCodigo.equals(other.ipaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ipaCodigo != null) ? this.ipaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsInsProAca[ ipaCodigo=" + this.ipaCodigo + " ]";
	}

}
