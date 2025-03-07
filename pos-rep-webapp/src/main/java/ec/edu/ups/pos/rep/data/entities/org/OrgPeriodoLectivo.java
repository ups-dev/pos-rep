package ec.edu.ups.pos.rep.data.entities.org;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_PERIODO_LECTIVO", schema = "ORG")
public class OrgPeriodoLectivo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO", nullable = false, updatable = false)
	private Long pelCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "PEL_DESCRIPCION", nullable = false, length = 50)
	private String pelDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEL_ABIERTO", nullable = false, length = 1)
	private String pelAbierto;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEL_VIGENTE", nullable = false, length = 1)
	private String pelVigente;

	@Column(name = "PEL_FECHA_INICIO")
	@Temporal(TemporalType.DATE)
	private Date pelFechaInicio;

	@Column(name = "PEL_FECHA_FIN")
	@Temporal(TemporalType.DATE)
	private Date pelFechaFin;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEL_TIPO", nullable = false, length = 1)
	private String pelTipo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "PEL_CODIFICACION", nullable = false, length = 150)
	private String pelCodificacion;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO_REFERENCIA", nullable = false)
	private Long pelCodigoReferencia;

	@Size(max = 50)
	@Column(name = "PEL_DESCRIPCION_VISUAL", length = 50)
	private String pelDescripcionVisual;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PEL_SUB_PERIODO", nullable = false, length = 1)
	private String pelSubPeriodo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgPeriodoLectivo")
	private Collection<OrgPeriodoEstructura> orgPeriodoEstructuraCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgPeriodoLectivo")
	private Collection<OrgParametroEstructura> orgParametroEstructuraCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "orgPeriodoLectivo", fetch = FetchType.LAZY)
	private Collection<OrgAutorizacion> orgAutorizacionCollection;

	public OrgPeriodoLectivo() {
	}

	public OrgPeriodoLectivo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public OrgPeriodoLectivo(Long pelCodigo, String pelDescripcion, String pelAbierto, String pelVigente,
			String pelTipo, String pelCodificacion, Long pelCodigoReferencia) {
		this.pelCodigo = pelCodigo;
		this.pelDescripcion = pelDescripcion;
		this.pelAbierto = pelAbierto;
		this.pelVigente = pelVigente;
		this.pelTipo = pelTipo;
		this.pelCodificacion = pelCodificacion;
		this.pelCodigoReferencia = pelCodigoReferencia;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public String getPelDescripcion() {
		return this.pelDescripcion;
	}

	public void setPelDescripcion(String pelDescripcion) {
		this.pelDescripcion = pelDescripcion;
	}

	public String getPelAbierto() {
		return this.pelAbierto;
	}

	public void setPelAbierto(String pelAbierto) {
		this.pelAbierto = pelAbierto;
	}

	public String getPelVigente() {
		return this.pelVigente;
	}

	public void setPelVigente(String pelVigente) {
		this.pelVigente = pelVigente;
	}

	public Date getPelFechaInicio() {
		return this.pelFechaInicio;
	}

	public void setPelFechaInicio(Date pelFechaInicio) {
		this.pelFechaInicio = pelFechaInicio;
	}

	public Date getPelFechaFin() {
		return this.pelFechaFin;
	}

	public void setPelFechaFin(Date pelFechaFin) {
		this.pelFechaFin = pelFechaFin;
	}

	public String getPelTipo() {
		return this.pelTipo;
	}

	public void setPelTipo(String pelTipo) {
		this.pelTipo = pelTipo;
	}

	public String getPelCodificacion() {
		return this.pelCodificacion;
	}

	public void setPelCodificacion(String pelCodificacion) {
		this.pelCodificacion = pelCodificacion;
	}

	public Long getPelCodigoReferencia() {
		return this.pelCodigoReferencia;
	}

	public void setPelCodigoReferencia(Long pelCodigoReferencia) {
		this.pelCodigoReferencia = pelCodigoReferencia;
	}

	public String getPelDescripcionVisual() {
		return this.pelDescripcionVisual;
	}

	public void setPelDescripcionVisual(String pelDescripcionVisual) {
		this.pelDescripcionVisual = pelDescripcionVisual;
	}

	public String getPelSubPeriodo() {
		return this.pelSubPeriodo;
	}

	public void setPelSubPeriodo(String pelSubPeriodo) {
		this.pelSubPeriodo = pelSubPeriodo;
	}

	public Collection<OrgPeriodoEstructura> getOrgPeriodoEstructuraCollection() {
		return this.orgPeriodoEstructuraCollection;
	}

	public void setOrgPeriodoEstructuraCollection(Collection<OrgPeriodoEstructura> orgPeriodoEstructuraCollection) {
		this.orgPeriodoEstructuraCollection = orgPeriodoEstructuraCollection;
	}

	public Collection<OrgParametroEstructura> getOrgParametroEstructuraCollection() {
		return this.orgParametroEstructuraCollection;
	}

	public void setOrgParametroEstructuraCollection(
			Collection<OrgParametroEstructura> orgParametroEstructuraCollection) {
		this.orgParametroEstructuraCollection = orgParametroEstructuraCollection;
	}

	public Collection<OrgAutorizacion> getOrgAutorizacionCollection() {
		return this.orgAutorizacionCollection;
	}

	public void setOrgAutorizacionCollection(Collection<OrgAutorizacion> orgAutorizacionCollection) {
		this.orgAutorizacionCollection = orgAutorizacionCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgPeriodoLectivo)) {
			return false;
		}
		OrgPeriodoLectivo other = (OrgPeriodoLectivo) object;
		return (this.pelCodigo != null || other.pelCodigo == null)
				&& (this.pelCodigo == null || this.pelCodigo.equals(other.pelCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.pelCodigo != null) ? this.pelCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "pelCodigo = " + this.pelCodigo + ")";
	}

}
