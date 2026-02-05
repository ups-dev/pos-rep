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
@Table(name = "PED_UNIDAD_CURRICULAR", schema = "PED")
public class PedUnidadCurricular extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "UNC_CODIGO", nullable = false)
	private Long uncCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "UNC_ITEM", nullable = false)
	private Long uncItem;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 700)
	@Column(name = "UNC_DESCRIPCION", nullable = false, length = 700)
	private String uncDescripcion;

	@Column(name = "UNC_TOTAL_HORAS_UNIDAD")
	private Short uncTotalHorasUnidad;

	@Column(name = "UNC_HORAS_CD")
	private Short uncHorasCd;

	@Column(name = "UNC_HORAS_CPAE")
	private Short uncHorasCpae;

	@Column(name = "UNC_HORAS_CAT")
	private Short uncHorasCat;

	@Column(name = "UNC_HORAS_CAA")
	private Short uncHorasCaa;

	@Column(name = "UNC_HORAS_CAC")
	private Short uncHorasCac;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedUnidadCurricular", fetch = FetchType.LAZY)
	private Collection<PedResultadoUnidad> pedResultadoUnidadCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedUnidadCurricular", fetch = FetchType.LAZY)
	private Collection<PedContenidoUnidad> pedContenidoUnidadCollection;

	public PedUnidadCurricular() {
	}

	public PedUnidadCurricular(Long uncCodigo) {
		this.uncCodigo = uncCodigo;
	}

	public PedUnidadCurricular(Long uncCodigo, Long uncItem, String uncDescripcion) {
		this.uncCodigo = uncCodigo;
		this.uncItem = uncItem;
		this.uncDescripcion = uncDescripcion;
	}

	public Long getUncCodigo() {
		return this.uncCodigo;
	}

	public void setUncCodigo(Long uncCodigo) {
		this.uncCodigo = uncCodigo;
	}

	public Long getUncItem() {
		return this.uncItem;
	}

	public void setUncItem(Long uncItem) {
		this.uncItem = uncItem;
	}

	public String getUncDescripcion() {
		return this.uncDescripcion;
	}

	public void setUncDescripcion(String uncDescripcion) {
		this.uncDescripcion = uncDescripcion;
	}

	public Short getUncTotalHorasUnidad() {
		return this.uncTotalHorasUnidad;
	}

	public void setUncTotalHorasUnidad(Short uncTotalHorasUnidad) {
		this.uncTotalHorasUnidad = uncTotalHorasUnidad;
	}

	public Short getUncHorasCd() {
		return this.uncHorasCd;
	}

	public void setUncHorasCd(Short uncHorasCd) {
		this.uncHorasCd = uncHorasCd;
	}

	public Short getUncHorasCpae() {
		return this.uncHorasCpae;
	}

	public void setUncHorasCpae(Short uncHorasCpae) {
		this.uncHorasCpae = uncHorasCpae;
	}

	public Short getUncHorasCat() {
		return this.uncHorasCat;
	}

	public void setUncHorasCat(Short uncHorasCat) {
		this.uncHorasCat = uncHorasCat;
	}

	public Short getUncHorasCaa() {
		return this.uncHorasCaa;
	}

	public void setUncHorasCaa(Short uncHorasCaa) {
		this.uncHorasCaa = uncHorasCaa;
	}

	public Short getUncHorasCac() {
		return this.uncHorasCac;
	}

	public void setUncHorasCac(Short uncHorasCac) {
		this.uncHorasCac = uncHorasCac;
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

	public Collection<PedContenidoUnidad> getPedContenidoUnidadCollection() {
		return this.pedContenidoUnidadCollection;
	}

	public void setPedContenidoUnidadCollection(Collection<PedContenidoUnidad> pedContenidoUnidadCollection) {
		this.pedContenidoUnidadCollection = pedContenidoUnidadCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedUnidadCurricular)) {
			return false;
		}
		PedUnidadCurricular other = (PedUnidadCurricular) object;
		if ((this.uncCodigo == null && other.uncCodigo != null)
				|| (this.uncCodigo != null && !this.uncCodigo.equals(other.uncCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.uncCodigo != null) ? this.uncCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedUnidadCurricular[ uncCodigo=" + this.uncCodigo + " ]";
	}

}
