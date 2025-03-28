package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_RESULTADO_UNIDAD", schema = "PED")
public class PedResultadoUnidad extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "REU_CODIGO", nullable = false)
	private Long reuCodigo;

	@Lob
	@Column(name = "REU_DESCRIPCION")
	private String reuDescripcion;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "REA_CODIGO", referencedColumnName = "REA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedResultadoAprendizaje pedResultadoAprendizaje;

	@JoinColumn(name = "UNC_CODIGO", referencedColumnName = "UNC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedUnidadCurricular pedUnidadCurricular;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedResultadoUnidad", fetch = FetchType.LAZY)
	private Collection<PedIndicadorLogro> pedIndicadorLogroCollection;

	public PedResultadoUnidad() {
	}

	public PedResultadoUnidad(Long reuCodigo) {
		this.reuCodigo = reuCodigo;
	}

	public Long getReuCodigo() {
		return this.reuCodigo;
	}

	public void setReuCodigo(Long reuCodigo) {
		this.reuCodigo = reuCodigo;
	}

	public String getReuDescripcion() {
		return this.reuDescripcion;
	}

	public void setReuDescripcion(String reuDescripcion) {
		this.reuDescripcion = reuDescripcion;
	}

	public Long getPelCodigoInicio() {
		return this.pelCodigoInicio;
	}

	public void setPelCodigoInicio(Long pelCodigoInicio) {
		this.pelCodigoInicio = pelCodigoInicio;
	}

	public Long getPelCodigoFinal() {
		return this.pelCodigoFinal;
	}

	public void setPelCodigoFinal(Long pelCodigoFinal) {
		this.pelCodigoFinal = pelCodigoFinal;
	}

	public PedResultadoAprendizaje getPedResultadoAprendizaje() {
		return this.pedResultadoAprendizaje;
	}

	public void setPedResultadoAprendizaje(PedResultadoAprendizaje pedResultadoAprendizaje) {
		this.pedResultadoAprendizaje = pedResultadoAprendizaje;
	}

	public PedUnidadCurricular getPedUnidadCurricular() {
		return this.pedUnidadCurricular;
	}

	public void setPedUnidadCurricular(PedUnidadCurricular pedUnidadCurricular) {
		this.pedUnidadCurricular = pedUnidadCurricular;
	}

	public Collection<PedIndicadorLogro> getPedIndicadorLogroCollection() {
		return this.pedIndicadorLogroCollection;
	}

	public void setPedIndicadorLogroCollection(Collection<PedIndicadorLogro> pedIndicadorLogroCollection) {
		this.pedIndicadorLogroCollection = pedIndicadorLogroCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedResultadoUnidad)) {
			return false;
		}
		PedResultadoUnidad other = (PedResultadoUnidad) object;
		if ((this.reuCodigo == null && other.reuCodigo != null)
				|| (this.reuCodigo != null && !this.reuCodigo.equals(other.reuCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.reuCodigo != null) ? this.reuCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedResultadoUnidad[ reuCodigo=" + this.reuCodigo + " ]";
	}

}
