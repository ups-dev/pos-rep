package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_PROYECTO_EDUCACION", schema = "PED")
public class PedProyectoEducacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PRE_NUMERO", nullable = false, updatable = false)
	private Long preNumero;

	@Column(name = "PEL_CODIGO")
	private Long pelCodigo;

	@Column(name = "ARC_CODIGO")
	private Long arcCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "PRE_TITULO_PROYECTO", nullable = false, length = 500)
	private String preTituloProyecto;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "PRE_DESCRIPCION_PROYECTO", nullable = false, length = 500)
	private String preDescripcionProyecto;

	@Size(max = 1)
	@Column(name = "PRE_ESTADO", length = 1)
	private String preEstado;

	@Basic(optional = false)
	@NotNull
	@Size(max = 1)
	@Column(name = "PRE_VIGENTE", nullable = false, length = 1)
	private String preVigente;

	@Column(name = "PRA_NUMERO_LEG")
	private Long praNumeroLeg;

	@Column(name = "FAC_CODIGO_LEG")
	private Long facCodigoLeg;

	@Column(name = "CAR_CODIGO_LEG")
	private Long carCodigoLeg;

	@Size(max = 200)
	@Column(name = "PRE_CODIFICACION", length = 200)
	private String preCodificacion;

	@Column(name = "PRE_CARRERA_REDISENIO")
	private Long preCarreraRedisenio;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedProyectoEducacion")
	private Collection<PedDesEstProEdu> pedDesEstProEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedProyectoEducacion")
	private Collection<PedMalla> pedMallaCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedProyectoEducacion")
	private Collection<PedComponente> pedComponenteCollection;

	@JoinColumn(name = "TPE_CODIGO", referencedColumnName = "TPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoProyectoEducacion pedTipoProyectoEducacion;

	@JoinColumn(name = "NED_CODIGO", referencedColumnName = "NED_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedNivelEducacion pedNivelEducacion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedProyectoEducacion")
	private Collection<PedParProEdu> pedParProEduCollection;

	@OneToMany(mappedBy = "pedProyectoEducacion", fetch = FetchType.LAZY)
	private Collection<PedModProEdu> pedModProEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedProyectoEducacion")
	private Collection<PedProEduTit> pedProEduTitCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedProyectoEducacion", fetch = FetchType.LAZY)
	private Collection<PedConvenio> pedConvenioCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedProyectoEducacion", fetch = FetchType.LAZY)
	private Collection<PedProSufLen> pedProSufLenCollection;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "pedProyectoEducacion", fetch = FetchType.LAZY)
	private Collection<PedHistorialEstado> pedHistorialEstadoCollection;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "pedProyectoEducacion", fetch = FetchType.LAZY)
	private Collection<PedMallaParacademico> pedMallaParacademicoCollection;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "pedProyectoEducacion", fetch = FetchType.LAZY)
	private Collection<PedNivelMalla> pedNivelMallaCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedProyectoEducacion", fetch = FetchType.LAZY)
	private Collection<PedProyectoCorrelacion> pedProyectoCorrelacionCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedProyectoEducacionCorrelacion", fetch = FetchType.LAZY)
	private Collection<PedProyectoCorrelacion> pedProyectoCorrelacionCollection1;

	public PedProyectoEducacion() {
	}

	public PedProyectoEducacion(Long preNumero) {
		this.preNumero = preNumero;
	}

	public PedProyectoEducacion(Long preNumero, String preTituloProyecto, String preDescripcionProyecto) {
		this.preNumero = preNumero;
		this.preTituloProyecto = preTituloProyecto;
		this.preDescripcionProyecto = preDescripcionProyecto;
	}

	public Long getPreNumero() {
		return this.preNumero;
	}

	public void setPreNumero(Long preNumero) {
		this.preNumero = preNumero;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getArcCodigo() {
		return this.arcCodigo;
	}

	public void setArcCodigo(Long arcCodigo) {
		this.arcCodigo = arcCodigo;
	}

	public String getPreTituloProyecto() {
		return this.preTituloProyecto;
	}

	public void setPreTituloProyecto(String preTituloProyecto) {
		this.preTituloProyecto = preTituloProyecto;
	}

	public String getPreDescripcionProyecto() {
		return this.preDescripcionProyecto;
	}

	public void setPreDescripcionProyecto(String preDescripcionProyecto) {
		this.preDescripcionProyecto = preDescripcionProyecto;
	}

	public String getPreEstado() {
		return this.preEstado;
	}

	public void setPreEstado(String preEstado) {
		this.preEstado = preEstado;
	}

	public String getPreVigente() {
		return this.preVigente;
	}

	public void setPreVigente(String preVigente) {
		this.preVigente = preVigente;
	}

	public Long getPraNumeroLeg() {
		return this.praNumeroLeg;
	}

	public void setPraNumeroLeg(Long praNumeroLeg) {
		this.praNumeroLeg = praNumeroLeg;
	}

	public Long getFacCodigoLeg() {
		return this.facCodigoLeg;
	}

	public void setFacCodigoLeg(Long facCodigoLeg) {
		this.facCodigoLeg = facCodigoLeg;
	}

	public Long getCarCodigoLeg() {
		return this.carCodigoLeg;
	}

	public void setCarCodigoLeg(Long carCodigoLeg) {
		this.carCodigoLeg = carCodigoLeg;
	}

	public String getPreCodificacion() {
		return this.preCodificacion;
	}

	public void setPreCodificacion(String preCodificacion) {
		this.preCodificacion = preCodificacion;
	}

	public Long getPreCarreraRedisenio() {
		return this.preCarreraRedisenio;
	}

	public void setPreCarreraRedisenio(Long preCarreraRedisenio) {
		this.preCarreraRedisenio = preCarreraRedisenio;
	}

	public Collection<PedDesEstProEdu> getPedDesEstProEduCollection() {
		return this.pedDesEstProEduCollection;
	}

	public void setPedDesEstProEduCollection(Collection<PedDesEstProEdu> pedDesEstProEduCollection) {
		this.pedDesEstProEduCollection = pedDesEstProEduCollection;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
	}

	public Collection<PedComponente> getPedComponenteCollection() {
		return this.pedComponenteCollection;
	}

	public void setPedComponenteCollection(Collection<PedComponente> pedComponenteCollection) {
		this.pedComponenteCollection = pedComponenteCollection;
	}

	public PedTipoProyectoEducacion getPedTipoProyectoEducacion() {
		return this.pedTipoProyectoEducacion;
	}

	public void setPedTipoProyectoEducacion(PedTipoProyectoEducacion pedTipoProyectoEducacion) {
		this.pedTipoProyectoEducacion = pedTipoProyectoEducacion;
	}

	public PedNivelEducacion getPedNivelEducacion() {
		return this.pedNivelEducacion;
	}

	public void setPedNivelEducacion(PedNivelEducacion pedNivelEducacion) {
		this.pedNivelEducacion = pedNivelEducacion;
	}

	public Collection<PedParProEdu> getPedParProEduCollection() {
		return this.pedParProEduCollection;
	}

	public void setPedParProEduCollection(Collection<PedParProEdu> pedParProEduCollection) {
		this.pedParProEduCollection = pedParProEduCollection;
	}

	public Collection<PedModProEdu> getPedModProEduCollection() {
		return this.pedModProEduCollection;
	}

	public void setPedModProEduCollection(Collection<PedModProEdu> pedModProEduCollection) {
		this.pedModProEduCollection = pedModProEduCollection;
	}

	public Collection<PedProEduTit> getPedProEduTitCollection() {
		return this.pedProEduTitCollection;
	}

	public void setPedProEduTitCollection(Collection<PedProEduTit> pedProEduTitCollection) {
		this.pedProEduTitCollection = pedProEduTitCollection;
	}

	public Collection<PedConvenio> getPedConvenioCollection() {
		return this.pedConvenioCollection;
	}

	public void setPedConvenioCollection(Collection<PedConvenio> pedConvenioCollection) {
		this.pedConvenioCollection = pedConvenioCollection;
	}

	public Collection<PedProSufLen> getPedProSufLenCollection() {
		return this.pedProSufLenCollection;
	}

	public void setPedProSufLenCollection(Collection<PedProSufLen> pedProSufLenCollection) {
		this.pedProSufLenCollection = pedProSufLenCollection;
	}

	public Collection<PedHistorialEstado> getPedHistorialEstadoCollection() {
		return this.pedHistorialEstadoCollection;
	}

	public void setPedHistorialEstadoCollection(Collection<PedHistorialEstado> pedHistorialEstadoCollection) {
		this.pedHistorialEstadoCollection = pedHistorialEstadoCollection;
	}

	public Collection<PedMallaParacademico> getPedMallaParacademicoCollection() {
		return this.pedMallaParacademicoCollection;
	}

	public void setPedMallaParacademicoCollection(Collection<PedMallaParacademico> pedMallaParacademicoCollection) {
		this.pedMallaParacademicoCollection = pedMallaParacademicoCollection;
	}

	public Collection<PedNivelMalla> getPedNivelMallaCollection() {
		return this.pedNivelMallaCollection;
	}

	public void setPedNivelMallaCollection(Collection<PedNivelMalla> pedNivelMallaCollection) {
		this.pedNivelMallaCollection = pedNivelMallaCollection;
	}

	public Collection<PedProyectoCorrelacion> getPedProyectoCorrelacionCollection() {
		return this.pedProyectoCorrelacionCollection;
	}

	public void setPedProyectoCorrelacionCollection(
			Collection<PedProyectoCorrelacion> pedProyectoCorrelacionCollection) {
		this.pedProyectoCorrelacionCollection = pedProyectoCorrelacionCollection;
	}

	public Collection<PedProyectoCorrelacion> getPedProyectoCorrelacionCollection1() {
		return this.pedProyectoCorrelacionCollection1;
	}

	public void setPedProyectoCorrelacionCollection1(
			Collection<PedProyectoCorrelacion> pedProyectoCorrelacionCollection1) {
		this.pedProyectoCorrelacionCollection1 = pedProyectoCorrelacionCollection1;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedProyectoEducacion)) {
			return false;
		}
		PedProyectoEducacion other = (PedProyectoEducacion) object;
		if ((this.preNumero == null && other.preNumero != null)
				|| (this.preNumero != null && !this.preNumero.equals(other.preNumero))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.preNumero != null) ? this.preNumero.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedProyectoEducacion[ preNumero=" + this.preNumero + " ]";
	}

}
