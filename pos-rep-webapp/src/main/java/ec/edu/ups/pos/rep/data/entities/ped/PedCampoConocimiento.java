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
@Table(name = "PED_CAMPO_CONOCIMIENTO", schema = "PED")
public class PedCampoConocimiento extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CAC_CODIGO", nullable = false)
	private Long cacCodigo;

	@Size(max = 200)
	@Column(name = "CAC_DESCRIPCION", length = 200)
	private String cacDescripcion;

	@Size(max = 200)
	@Column(name = "CAC_DESCRIPCION_FEMENINO", length = 200)
	private String cacDescripcionFemenino;

	@Size(max = 50)
	@Column(name = "CAC_CODIFICACION", length = 50)
	private String cacCodificacion;

	@Size(max = 1)
	@Column(name = "CAC_PERTENECE_MENCION", length = 1)
	private String cacPerteneceMencion;

	@Column(name = "TIT_CODIGO_LEG")
	private Long titCodigoLeg;

	@Column(name = "TIT_FEM_CODIGO_LEG")
	private Long titCodigoLegFemenino;

	@OneToMany(mappedBy = "pedCampoConocimientoPadre", fetch = FetchType.LAZY)
	private Collection<PedCampoConocimiento> pedCampoConocimientoCollection;

	@JoinColumn(name = "CAC_CODIGO_PADRE", referencedColumnName = "CAC_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedCampoConocimiento pedCampoConocimientoPadre;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedCampoConocimiento", fetch = FetchType.LAZY)
	private Collection<PedTpcCamCon> pedTpcCamConCollection;

	@JoinColumn(name = "TCC_CODIGO", referencedColumnName = "TCC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoCampoConocimiento pedTipoCampoConocimiento;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedCampoConocimiento", fetch = FetchType.LAZY)
	private Collection<PedCamConTipTit> pedCamConTipTitCollection;

	public PedCampoConocimiento() {
	}

	public PedCampoConocimiento(Long cacCodigo) {
		this.cacCodigo = cacCodigo;
	}

	public Long getCacCodigo() {
		return this.cacCodigo;
	}

	public void setCacCodigo(Long cacCodigo) {
		this.cacCodigo = cacCodigo;
	}

	public String getCacDescripcion() {
		return this.cacDescripcion;
	}

	public void setCacDescripcion(String cacDescripcion) {
		this.cacDescripcion = cacDescripcion;
	}

	public String getCacDescripcionFemenino() {
		return this.cacDescripcionFemenino;
	}

	public void setCacDescripcionFemenino(String cacDescripcionFemenino) {
		this.cacDescripcionFemenino = cacDescripcionFemenino;
	}

	public String getCacCodificacion() {
		return this.cacCodificacion;
	}

	public void setCacCodificacion(String cacCodificacion) {
		this.cacCodificacion = cacCodificacion;
	}

	public String getCacPerteneceMencion() {
		return this.cacPerteneceMencion;
	}

	public void setCacPerteneceMencion(String cacPerteneceMencion) {
		this.cacPerteneceMencion = cacPerteneceMencion;
	}

	public Collection<PedCampoConocimiento> getPedCampoConocimientoCollection() {
		return this.pedCampoConocimientoCollection;
	}

	public void setPedCampoConocimientoCollection(Collection<PedCampoConocimiento> pedCampoConocimientoCollection) {
		this.pedCampoConocimientoCollection = pedCampoConocimientoCollection;
	}

	public PedCampoConocimiento getPedCampoConocimientoPadre() {
		return this.pedCampoConocimientoPadre;
	}

	public void setPedCampoConocimientoPadre(PedCampoConocimiento pedCampoConocimientoPadre) {
		this.pedCampoConocimientoPadre = pedCampoConocimientoPadre;
	}

	public Collection<PedTpcCamCon> getPedTpcCamConCollection() {
		return this.pedTpcCamConCollection;
	}

	public void setPedTpcCamConCollection(Collection<PedTpcCamCon> pedTpcCamConCollection) {
		this.pedTpcCamConCollection = pedTpcCamConCollection;
	}

	public PedTipoCampoConocimiento getPedTipoCampoConocimiento() {
		return this.pedTipoCampoConocimiento;
	}

	public void setPedTipoCampoConocimiento(PedTipoCampoConocimiento pedTipoCampoConocimiento) {
		this.pedTipoCampoConocimiento = pedTipoCampoConocimiento;
	}

	public Long getTitCodigoLegFemenino() {
		return this.titCodigoLegFemenino;
	}

	public void setTitCodigoLegFemenino(Long titCodigoLegFemenino) {
		this.titCodigoLegFemenino = titCodigoLegFemenino;
	}

	public Long getTitCodigoLeg() {
		return this.titCodigoLeg;
	}

	public void setTitCodigoLeg(Long titCodigoLeg) {
		this.titCodigoLeg = titCodigoLeg;
	}

	public Collection<PedCamConTipTit> getPedCamConTipTitCollection() {
		return this.pedCamConTipTitCollection;
	}

	public void setPedCamConTipTitCollection(Collection<PedCamConTipTit> pedCamConTipTitCollection) {
		this.pedCamConTipTitCollection = pedCamConTipTitCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCampoConocimiento)) {
			return false;
		}
		PedCampoConocimiento other = (PedCampoConocimiento) object;
		if ((this.cacCodigo == null && other.cacCodigo != null)
				|| (this.cacCodigo != null && !this.cacCodigo.equals(other.cacCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cacCodigo != null) ? this.cacCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCampoConocimiento[ cacCodigo=" + this.cacCodigo + " ]";
	}

}
