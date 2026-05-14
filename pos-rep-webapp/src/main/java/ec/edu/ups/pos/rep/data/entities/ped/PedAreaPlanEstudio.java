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
@Table(name = "PED_AREA_PLAN_ESTUDIO", schema = "PED")
public class PedAreaPlanEstudio extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "APE_CODIGO", nullable = false, updatable = false)
	private Long apeCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "APE_DESCRIPCION", nullable = false, length = 200)
	private String apeDescripcion;

	@Size(max = 10)
	@Column(name = "APE_ABREVIATURA", length = 10)
	private String apeAbreviatura;

	@Column(name = "APE_CODIGO_EVA")
	private Long apeCodigoEva;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedAreaPlanEstudio")
	private Collection<PedMalla> pedMallaCollection;

	@JoinColumn(name = "TAP_CODIGO", referencedColumnName = "TAP_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoAreaPlanEstudio pedTipoAreaPlanEstudio;

	@JoinColumn(name = "TPE_CODIGO", referencedColumnName = "TPE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoProyectoEducacion pedTipoProyectoEducacion;

	public PedAreaPlanEstudio() {
	}

	public PedAreaPlanEstudio(Long apeCodigo) {
		this.apeCodigo = apeCodigo;
	}

	public PedAreaPlanEstudio(Long apeCodigo, String apeDescripcion) {
		this.apeCodigo = apeCodigo;
		this.apeDescripcion = apeDescripcion;

	}

	public Long getApeCodigo() {
		return this.apeCodigo;
	}

	public void setApeCodigo(Long apeCodigo) {
		this.apeCodigo = apeCodigo;
	}

	public String getApeDescripcion() {
		return this.apeDescripcion;
	}

	public void setApeDescripcion(String apeDescripcion) {
		this.apeDescripcion = apeDescripcion;
	}

	public String getApeAbreviatura() {
		return this.apeAbreviatura;
	}

	public void setApeAbreviatura(String apeAbreviatura) {
		this.apeAbreviatura = apeAbreviatura;
	}

	public Long getApeCodigoEva() {
		return this.apeCodigoEva;
	}

	public void setApeCodigoEva(Long apeCodigoEva) {
		this.apeCodigoEva = apeCodigoEva;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
	}

	public PedTipoAreaPlanEstudio getPedTipoAreaPlanEstudio() {
		return this.pedTipoAreaPlanEstudio;
	}

	public void setPedTipoAreaPlanEstudio(PedTipoAreaPlanEstudio pedTipoAreaPlanEstudio) {
		this.pedTipoAreaPlanEstudio = pedTipoAreaPlanEstudio;
	}

	public PedTipoProyectoEducacion getPedTipoProyectoEducacion() {
		return this.pedTipoProyectoEducacion;
	}

	public void setPedTipoProyectoEducacion(PedTipoProyectoEducacion pedTipoProyectoEducacion) {
		this.pedTipoProyectoEducacion = pedTipoProyectoEducacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedAreaPlanEstudio)) {
			return false;
		}
		PedAreaPlanEstudio other = (PedAreaPlanEstudio) object;
		if ((this.apeCodigo == null && other.apeCodigo != null)
				|| (this.apeCodigo != null && !this.apeCodigo.equals(other.apeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.apeCodigo != null) ? this.apeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedAreaPlanEstudio[ apeCodigo=" + this.apeCodigo + " ]";
	}

}
