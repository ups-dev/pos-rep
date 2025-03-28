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
@Table(name = "PED_TIPO_PROYECTO_EDUCACION", schema = "PED")
public class PedTipoProyectoEducacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TPE_CODIGO", nullable = false, updatable = false)
	private Long tpeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "TPE_DESCRIPCION", nullable = false, length = 50)
	private String tpeDescripcion;

	@Size(max = 10)
	@Column(name = "TPE_ABREVIATURA", length = 10)
	private String tpeAbreviatura;

	@Size(max = 50)
	@Column(name = "TPE_DESCRIPCION_REPORTE", length = 50)
	private String tpeDescripcionReporte;

	@JoinColumn(name = "CTP_CODIGO", referencedColumnName = "CTP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedCategoriaTipoProyecto pedCategoriaTipoProyecto;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedTipComTipProEdu> pedTipComTipProEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedTipParTipProEdu> pedTipParTipProEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedProyectoEducacion> pedProyectoEducacionCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedTipComMicTipProEdu> pedTipComMicTipProEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedAreaPlanEstudio> pedAreaPlanEstudioCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedMecanismoTitulacion> pedMecanismoTitulacionCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedTptTipProEdu> pedTptTipProEduCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipoProyectoEducacion")
	private Collection<PedComponenteAprendizaje> pedComponenteAprendizajeCollection;

	public PedTipoProyectoEducacion() {
	}

	public PedTipoProyectoEducacion(Long tpeCodigo) {
		this.tpeCodigo = tpeCodigo;
	}

	public PedTipoProyectoEducacion(Long tpeCodigo, String tpeDescripcion) {
		this.tpeCodigo = tpeCodigo;
		this.tpeDescripcion = tpeDescripcion;
	}

	public Long getTpeCodigo() {
		return this.tpeCodigo;
	}

	public void setTpeCodigo(Long tpeCodigo) {
		this.tpeCodigo = tpeCodigo;
	}

	public String getTpeDescripcion() {
		return this.tpeDescripcion;
	}

	public void setTpeDescripcion(String tpeDescripcion) {
		this.tpeDescripcion = tpeDescripcion;
	}

	public String getTpeAbreviatura() {
		return this.tpeAbreviatura;
	}

	public void setTpeAbreviatura(String tpeAbreviatura) {
		this.tpeAbreviatura = tpeAbreviatura;
	}

	public String getTpeDescripcionReporte() {
		return this.tpeDescripcionReporte;
	}

	public void setTpeDescripcionReporte(String tpeDescripcionReporte) {
		this.tpeDescripcionReporte = tpeDescripcionReporte;
	}

	public PedCategoriaTipoProyecto getPedCategoriaTipoProyecto() {
		return this.pedCategoriaTipoProyecto;
	}

	public void setPedCategoriaTipoProyecto(PedCategoriaTipoProyecto pedCategoriaTipoProyecto) {
		this.pedCategoriaTipoProyecto = pedCategoriaTipoProyecto;
	}

	public Collection<PedTipComTipProEdu> getPedTipComTipProEduCollection() {
		return this.pedTipComTipProEduCollection;
	}

	public void setPedTipComTipProEduCollection(Collection<PedTipComTipProEdu> pedTipComTipProEduCollection) {
		this.pedTipComTipProEduCollection = pedTipComTipProEduCollection;
	}

	public Collection<PedTipParTipProEdu> getPedTipParTipProEduCollection() {
		return this.pedTipParTipProEduCollection;
	}

	public void setPedTipParTipProEduCollection(Collection<PedTipParTipProEdu> pedTipParTipProEduCollection) {
		this.pedTipParTipProEduCollection = pedTipParTipProEduCollection;
	}

	public Collection<PedProyectoEducacion> getPedProyectoEducacionCollection() {
		return this.pedProyectoEducacionCollection;
	}

	public void setPedProyectoEducacionCollection(Collection<PedProyectoEducacion> pedProyectoEducacionCollection) {
		this.pedProyectoEducacionCollection = pedProyectoEducacionCollection;
	}

	public Collection<PedTipComMicTipProEdu> getPedTipComMicTipProEduCollection() {
		return this.pedTipComMicTipProEduCollection;
	}

	public void setPedTipComMicTipProEduCollection(Collection<PedTipComMicTipProEdu> pedTipComMicTipProEduCollection) {
		this.pedTipComMicTipProEduCollection = pedTipComMicTipProEduCollection;
	}

	public Collection<PedAreaPlanEstudio> getPedAreaPlanEstudioCollection() {
		return this.pedAreaPlanEstudioCollection;
	}

	public void setPedAreaPlanEstudioCollection(Collection<PedAreaPlanEstudio> pedAreaPlanEstudioCollection) {
		this.pedAreaPlanEstudioCollection = pedAreaPlanEstudioCollection;
	}

	public Collection<PedMecanismoTitulacion> getPedMecanismoTitulacionCollection() {
		return this.pedMecanismoTitulacionCollection;
	}

	public void setPedMecanismoTitulacionCollection(
			Collection<PedMecanismoTitulacion> pedMecanismoTitulacionCollection) {
		this.pedMecanismoTitulacionCollection = pedMecanismoTitulacionCollection;
	}

	public Collection<PedTptTipProEdu> getPedTptTipProEduCollection() {
		return this.pedTptTipProEduCollection;
	}

	public void setPedTptTipProEduCollection(Collection<PedTptTipProEdu> pedTptTipProEduCollection) {
		this.pedTptTipProEduCollection = pedTptTipProEduCollection;
	}

	public Collection<PedComponenteAprendizaje> getPedComponenteAprendizajeCollection() {
		return this.pedComponenteAprendizajeCollection;
	}

	public void setPedComponenteAprendizajeCollection(
			Collection<PedComponenteAprendizaje> pedComponenteAprendizajeCollection) {
		this.pedComponenteAprendizajeCollection = pedComponenteAprendizajeCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoProyectoEducacion)) {
			return false;
		}
		PedTipoProyectoEducacion other = (PedTipoProyectoEducacion) object;
		if ((this.tpeCodigo == null && other.tpeCodigo != null)
				|| (this.tpeCodigo != null && !this.tpeCodigo.equals(other.tpeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tpeCodigo != null) ? this.tpeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoProyectoEducacion[ tpeCodigo=" + this.tpeCodigo + " ]";
	}

}
