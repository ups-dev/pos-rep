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
@Table(name = "PED_CONTENIDO_MINIMO", schema = "PED")
public class PedContenidoMinimo extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COM_CODIGO", nullable = false)
	private Long comCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "COM_DESCRIPCION", nullable = false)
	private String comDescripcion;

	@Column(name = "COM_ITEM")
	private Long comItem;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	public PedContenidoMinimo() {
	}

	public PedContenidoMinimo(Long comCodigo) {
		this.comCodigo = comCodigo;
	}

	public PedContenidoMinimo(Long comCodigo, String comDescripcion, Long comItem) {
		this.comCodigo = comCodigo;
		this.comDescripcion = comDescripcion;
		this.comItem = comItem;
	}

	public Long getComCodigo() {
		return this.comCodigo;
	}

	public void setComCodigo(Long comCodigo) {
		this.comCodigo = comCodigo;
	}

	public String getComDescripcion() {
		return this.comDescripcion;
	}

	public void setComDescripcion(String comDescripcion) {
		this.comDescripcion = comDescripcion;
	}

	public Long getComItem() {
		return this.comItem;
	}

	public void setComItem(Long comItem) {
		this.comItem = comItem;
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

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedContenidoMinimo)) {
			return false;
		}
		PedContenidoMinimo other = (PedContenidoMinimo) object;
		if ((this.comCodigo == null && other.comCodigo != null)
				|| (this.comCodigo != null && !this.comCodigo.equals(other.comCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.comCodigo != null) ? this.comCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedContenidoMinimo[ comCodigo=" + this.comCodigo + " ]";
	}

}
