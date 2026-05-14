package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_INDICADOR_LOGRO", schema = "PED")
public class PedIndicadorLogro extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "INL_CODIGO", nullable = false)
	private Long inlCodigo;

	@Lob
	@Column(name = "INL_DESCRIPCION")
	private String inlDescripcion;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "REU_CODIGO", referencedColumnName = "REU_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedResultadoUnidad pedResultadoUnidad;

	public PedIndicadorLogro() {
	}

	public PedIndicadorLogro(Long inlCodigo) {
		this.inlCodigo = inlCodigo;
	}

	public Long getInlCodigo() {
		return this.inlCodigo;
	}

	public void setInlCodigo(Long inlCodigo) {
		this.inlCodigo = inlCodigo;
	}

	public String getInlDescripcion() {
		return this.inlDescripcion;
	}

	public void setInlDescripcion(String inlDescripcion) {
		this.inlDescripcion = inlDescripcion;
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

	public PedResultadoUnidad getPedResultadoUnidad() {
		return this.pedResultadoUnidad;
	}

	public void setPedResultadoUnidad(PedResultadoUnidad pedResultadoUnidad) {
		this.pedResultadoUnidad = pedResultadoUnidad;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedIndicadorLogro)) {
			return false;
		}
		PedIndicadorLogro other = (PedIndicadorLogro) object;
		if ((this.inlCodigo == null && other.inlCodigo != null)
				|| (this.inlCodigo != null && !this.inlCodigo.equals(other.inlCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.inlCodigo != null) ? this.inlCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedIndicadorLogro[ inlCodigo=" + this.inlCodigo + " ]";
	}

}
