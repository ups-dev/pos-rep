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
@Table(name = "PED_RESULTADO_APRENDIZAJE", schema = "PED")
public class PedResultadoAprendizaje extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "REA_CODIGO", nullable = false)
	private Long reaCodigo;

	@Lob
	@Column(name = "REA_DESCRIPCION")
	private String reaDescripcion;

	@Column(name = "REA_ITEM")
	private Long reaItem;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedResultadoAprendizaje", fetch = FetchType.LAZY)
	private Collection<PedResultadoUnidad> pedResultadoUnidadCollection;

	public PedResultadoAprendizaje() {
	}

	public PedResultadoAprendizaje(Long reaCodigo) {
		this.reaCodigo = reaCodigo;
	}

	public Long getReaCodigo() {
		return this.reaCodigo;
	}

	public void setReaCodigo(Long reaCodigo) {
		this.reaCodigo = reaCodigo;
	}

	public String getReaDescripcion() {
		return this.reaDescripcion;
	}

	public void setReaDescripcion(String reaDescripcion) {
		this.reaDescripcion = reaDescripcion;
	}

	public Long getReaItem() {
		return this.reaItem;
	}

	public void setReaItem(Long reaItem) {
		this.reaItem = reaItem;
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

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public Collection<PedResultadoUnidad> getPedResultadoUnidadCollection() {
		return this.pedResultadoUnidadCollection;
	}

	public void setPedResultadoUnidadCollection(Collection<PedResultadoUnidad> pedResultadoUnidadCollection) {
		this.pedResultadoUnidadCollection = pedResultadoUnidadCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedResultadoAprendizaje)) {
			return false;
		}
		PedResultadoAprendizaje other = (PedResultadoAprendizaje) object;
		if ((this.reaCodigo == null && other.reaCodigo != null)
				|| (this.reaCodigo != null && !this.reaCodigo.equals(other.reaCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.reaCodigo != null) ? this.reaCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedResultadoAprendizaje[ reaCodigo=" + this.reaCodigo + " ]";
	}

}
