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
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MALLA_BIBLIOGRAFIA", schema = "PED")
public class PedMallaBibliografia extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAB_CODIGO", nullable = false)
	private Long mabCodigo;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Column(name = "MAB_DESCRIPCION", nullable = false)
	private String mabDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "MAB_TIPO", nullable = false, length = 1)
	private String mabTipo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MAB_ITEM", nullable = false)
	private Long mabItem;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PedMalla pedMalla;

	public PedMallaBibliografia() {
	}

	public PedMallaBibliografia(Long mabCodigo) {
		this.mabCodigo = mabCodigo;
	}

	public PedMallaBibliografia(Long mabCodigo, String mabDescripcion, String mabTipo, Long mabItem) {
		this.mabCodigo = mabCodigo;
		this.mabDescripcion = mabDescripcion;
		this.mabTipo = mabTipo;
		this.mabItem = mabItem;
	}

	public Long getMabCodigo() {
		return this.mabCodigo;
	}

	public void setMabCodigo(Long mabCodigo) {
		this.mabCodigo = mabCodigo;
	}

	public String getMabDescripcion() {
		return this.mabDescripcion;
	}

	public void setMabDescripcion(String mabDescripcion) {
		this.mabDescripcion = mabDescripcion;
	}

	public String getMabTipo() {
		return this.mabTipo;
	}

	public void setMabTipo(String mabTipo) {
		this.mabTipo = mabTipo;
	}

	public Long getMabItem() {
		return this.mabItem;
	}

	public void setMabItem(Long mabItem) {
		this.mabItem = mabItem;
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
		if (!(object instanceof PedMallaBibliografia)) {
			return false;
		}
		PedMallaBibliografia other = (PedMallaBibliografia) object;
		if ((this.mabCodigo == null && other.mabCodigo != null)
				|| (this.mabCodigo != null && !this.mabCodigo.equals(other.mabCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mabCodigo != null) ? this.mabCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaBibliografia[ mabCodigo=" + this.mabCodigo + " ]";
	}

}
