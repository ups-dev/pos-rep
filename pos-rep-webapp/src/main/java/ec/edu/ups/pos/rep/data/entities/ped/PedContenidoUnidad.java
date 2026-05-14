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
@Table(name = "PED_CONTENIDO_UNIDAD", schema = "PED")
public class PedContenidoUnidad extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COU_CODIGO", nullable = false)
	private Long couCodigo;

	@Lob
	@Column(name = "COU_DESCRIPCION")
	private String couDescripcion;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "UNC_CODIGO", referencedColumnName = "UNC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedUnidadCurricular pedUnidadCurricular;

	public PedContenidoUnidad() {
	}

	public PedContenidoUnidad(Long couCodigo) {
		this.couCodigo = couCodigo;
	}

	public Long getCouCodigo() {
		return this.couCodigo;
	}

	public void setCouCodigo(Long couCodigo) {
		this.couCodigo = couCodigo;
	}

	public String getCouDescripcion() {
		return this.couDescripcion;
	}

	public void setCouDescripcion(String couDescripcion) {
		this.couDescripcion = couDescripcion;
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

	public PedUnidadCurricular getPedUnidadCurricular() {
		return this.pedUnidadCurricular;
	}

	public void setPedUnidadCurricular(PedUnidadCurricular pedUnidadCurricular) {
		this.pedUnidadCurricular = pedUnidadCurricular;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedContenidoUnidad)) {
			return false;
		}
		PedContenidoUnidad other = (PedContenidoUnidad) object;
		if ((this.couCodigo == null && other.couCodigo != null)
				|| (this.couCodigo != null && !this.couCodigo.equals(other.couCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.couCodigo != null) ? this.couCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedContenidoUnidad[ couCodigo=" + this.couCodigo + " ]";
	}

}
