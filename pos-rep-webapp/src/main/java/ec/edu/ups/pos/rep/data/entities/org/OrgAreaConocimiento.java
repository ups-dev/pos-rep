package ec.edu.ups.pos.rep.data.entities.org;

import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "ORG_AREA_CONOCIMIENTO", schema = "ORG")
public class OrgAreaConocimiento extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ARC_CODIGO", nullable = false, updatable = false)
	private Long arcCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "ARC_DESCRIPCION", nullable = false, length = 250)
	private String arcDescripcion;

	@Size(max = 100)
	@Column(name = "ARC_CODIFICACION", length = 100)
	private String arcCodificacion;

	@Column(name = "ACU_CODIGO_LEG")
	private Long acuCodigoLeg;

	@OneToMany(mappedBy = "orgAreaConocimientoPadre", fetch = FetchType.LAZY)
	private Collection<OrgAreaConocimiento> orgAreaConocimientoCollection;

	@JoinColumn(name = "ARC_CODIGO_PADRE", referencedColumnName = "ARC_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private OrgAreaConocimiento orgAreaConocimientoPadre;

	@JoinColumn(name = "TAC_CODIGO", referencedColumnName = "TAC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private OrgTipoAreaConocimiento orgTipoAreaConocimiento;

	public OrgAreaConocimiento() {
	}

	public OrgAreaConocimiento(Long arcCodigo) {
		this.arcCodigo = arcCodigo;
	}

	public OrgAreaConocimiento(Long arcCodigo, String arcDescripcion) {
		this.arcCodigo = arcCodigo;
		this.arcDescripcion = arcDescripcion;
	}

	public Long getArcCodigo() {
		return this.arcCodigo;
	}

	public void setArcCodigo(Long arcCodigo) {
		this.arcCodigo = arcCodigo;
	}

	public String getArcDescripcion() {
		return this.arcDescripcion;
	}

	public void setArcDescripcion(String arcDescripcion) {
		this.arcDescripcion = arcDescripcion;
	}

	public String getArcCodificacion() {
		return this.arcCodificacion;
	}

	public void setArcCodificacion(String arcCodificacion) {
		this.arcCodificacion = arcCodificacion;
	}

	public Long getAcuCodigoLeg() {
		return this.acuCodigoLeg;
	}

	public void setAcuCodigoLeg(Long acuCodigoLeg) {
		this.acuCodigoLeg = acuCodigoLeg;
	}

	public OrgAreaConocimiento getOrgAreaConocimientoPadre() {
		return this.orgAreaConocimientoPadre;
	}

	public void setOrgAreaConocimientoPadre(OrgAreaConocimiento orgAreaConocimientoPadre) {
		this.orgAreaConocimientoPadre = orgAreaConocimientoPadre;
	}

	public OrgTipoAreaConocimiento getOrgTipoAreaConocimiento() {
		return this.orgTipoAreaConocimiento;
	}

	public void setOrgTipoAreaConocimiento(OrgTipoAreaConocimiento orgTipoAreaConocimiento) {
		this.orgTipoAreaConocimiento = orgTipoAreaConocimiento;
	}

	public Collection<OrgAreaConocimiento> getOrgAreaConocimientoCollection() {
		return this.orgAreaConocimientoCollection;
	}

	public void setOrgAreaConocimientoCollection(Collection<OrgAreaConocimiento> orgAreaConocimientoCollection) {
		this.orgAreaConocimientoCollection = orgAreaConocimientoCollection;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrgAreaConocimiento)) {
			return false;
		}
		OrgAreaConocimiento other = (OrgAreaConocimiento) object;
		return (this.arcCodigo != null || other.arcCodigo == null)
				&& (this.arcCodigo == null || this.arcCodigo.equals(other.arcCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.arcCodigo != null) ? this.arcCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + "arcCodigo = " + this.arcCodigo + ")";
	}

}
