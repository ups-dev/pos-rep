package ec.edu.ups.pos.rep.data.entities.rep;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

/**
 * Description.
 *
 * @author ups .
 */
@Entity
@Table(name = "REP_PARAMETRO", catalog = "", schema = "REP")
public class RepParametro extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PAR_CODIGO", nullable = false)
	private Long parCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "PAR_DESCRIPCION", nullable = false, length = 50)
	private String parDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "PAR_NOMBRE", nullable = false, length = 50)
	private String parNombre;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "PAR_TIPO_DATO", nullable = false, length = 30)
	private String parTipoDato;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PAR_ORDEN", nullable = false)
	private Long parOrden;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "repParametro", fetch = FetchType.LAZY)
	private Collection<RepParametroReporte> repParametroReporteCollection;

	public RepParametro() {
	}

	public RepParametro(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public RepParametro(Long parCodigo, String parDescripcion, String parNombre, String parTipoDato, Long parOrden) {
		this.parCodigo = parCodigo;
		this.parDescripcion = parDescripcion;
		this.parNombre = parNombre;
		this.parTipoDato = parTipoDato;
		this.parOrden = parOrden;
	}

	public Long getParCodigo() {
		return this.parCodigo;
	}

	public void setParCodigo(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public String getParDescripcion() {
		return this.parDescripcion;
	}

	public void setParDescripcion(String parDescripcion) {
		this.parDescripcion = parDescripcion;
	}

	public String getParNombre() {
		return this.parNombre;
	}

	public void setParNombre(String parNombre) {
		this.parNombre = parNombre;
	}

	public String getParTipoDato() {
		return this.parTipoDato;
	}

	public void setParTipoDato(String parTipoDato) {
		this.parTipoDato = parTipoDato;
	}

	public Long getParOrden() {
		return this.parOrden;
	}

	public void setParOrden(Long parOrden) {
		this.parOrden = parOrden;
	}

	public Collection<RepParametroReporte> getRepParametroReporteCollection() {
		return this.repParametroReporteCollection;
	}

	public void setRepParametroReporteCollection(Collection<RepParametroReporte> repParametroReporteCollection) {
		this.repParametroReporteCollection = repParametroReporteCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RepParametro)) {
			return false;
		}
		RepParametro other = (RepParametro) object;
		if ((this.parCodigo == null && other.parCodigo != null)
				|| (this.parCodigo != null && !this.parCodigo.equals(other.parCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.parCodigo != null) ? this.parCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepParametro[ parCodigo=" + this.parCodigo + " ]";
	}

}
