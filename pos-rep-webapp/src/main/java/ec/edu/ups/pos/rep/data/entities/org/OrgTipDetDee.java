package ec.edu.ups.pos.rep.data.entities.org;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ORG_TIP_DET_DEE", schema = "ORG")
public class OrgTipDetDee extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TDD_CODIGO", nullable = false)
	private Long tddCodigo;

	@Size(max = 2000)
	@Column(name = "TDD_DESCRIPCION_TEXTO", length = 2000)
	private String tddDescripcionTexto;

	@Column(name = "TDD_DESCRIPCION_NUMERO", precision = 10, scale = 2)
	private BigDecimal tddDescripcionNumero;

	@Column(name = "TDD_DESCRIPCION_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tddDescripcionFecha;

	@Column(name = "TDD_FECHA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tddFechaInicio;

	@Column(name = "TDD_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tddFechaFin;

	@Size(max = 1)
	@Column(name = "TDD_VIGENTE", length = 1)
	private String tddVigente;

	@JoinColumn(name = "TID_CODIGO", referencedColumnName = "TID_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipoDetalle orgTipoDetalle;

	@JoinColumn(name = "DEE_CODIGO", referencedColumnName = "DEE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgDescripcionEstructura orgDescripcionEstructura;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orgTipDetDee", fetch = FetchType.LAZY)
	private Collection<OrgAnexoDetalle> orgAnexoDetalleCollection;

	public OrgTipDetDee() {
	}

	public OrgTipDetDee(Long tddCodigo) {
		this.tddCodigo = tddCodigo;
	}

	public OrgTipDetDee(Long tddCodigo, String audEliminado, String audAdicionado, Date audFechaAdicion) {
		this.tddCodigo = tddCodigo;
	}

	public Long getTddCodigo() {
		return this.tddCodigo;
	}

	public void setTddCodigo(Long tddCodigo) {
		this.tddCodigo = tddCodigo;
	}

	public String getTddDescripcionTexto() {
		return this.tddDescripcionTexto;
	}

	public void setTddDescripcionTexto(String tddDescripcionTexto) {
		this.tddDescripcionTexto = tddDescripcionTexto;
	}

	public BigDecimal getTddDescripcionNumero() {
		return this.tddDescripcionNumero;
	}

	public void setTddDescripcionNumero(BigDecimal tddDescripcionNumero) {
		this.tddDescripcionNumero = tddDescripcionNumero;
	}

	public Date getTddDescripcionFecha() {
		return this.tddDescripcionFecha;
	}

	public void setTddDescripcionFecha(Date tddDescripcionFecha) {
		this.tddDescripcionFecha = tddDescripcionFecha;
	}

	public Date getTddFechaInicio() {
		return this.tddFechaInicio;
	}

	public void setTddFechaInicio(Date tddFechaInicio) {
		this.tddFechaInicio = tddFechaInicio;
	}

	public Date getTddFechaFin() {
		return this.tddFechaFin;
	}

	public void setTddFechaFin(Date tddFechaFin) {
		this.tddFechaFin = tddFechaFin;
	}

	public String getTddVigente() {
		return this.tddVigente;
	}

	public void setTddVigente(String tddVigente) {
		this.tddVigente = tddVigente;
	}

	public OrgTipoDetalle getOrgTipoDetalle() {
		return this.orgTipoDetalle;
	}

	public void setOrgTipoDetalle(OrgTipoDetalle orgTipoDetalle) {
		this.orgTipoDetalle = orgTipoDetalle;
	}

	public OrgDescripcionEstructura getOrgDescripcionEstructura() {
		return this.orgDescripcionEstructura;
	}

	public void setOrgDescripcionEstructura(OrgDescripcionEstructura orgDescripcionEstructura) {
		this.orgDescripcionEstructura = orgDescripcionEstructura;
	}

	public Collection<OrgAnexoDetalle> getOrgAnexoDetalleCollection() {
		return this.orgAnexoDetalleCollection;
	}

	public void setOrgAnexoDetalleCollection(Collection<OrgAnexoDetalle> orgAnexoDetalleCollection) {
		this.orgAnexoDetalleCollection = orgAnexoDetalleCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgTipDetDee)) {
			return false;
		}
		OrgTipDetDee other = (OrgTipDetDee) object;
		return (this.tddCodigo != null || other.tddCodigo == null)
				&& (this.tddCodigo == null || this.tddCodigo.equals(other.tddCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tddCodigo != null) ? this.tddCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "tddCodigo = " + this.tddCodigo + ")";
	}

}
