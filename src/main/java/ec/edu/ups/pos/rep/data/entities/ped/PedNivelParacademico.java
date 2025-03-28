package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_NIVEL_PARACADEMICO", schema = "PED",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "NIP_DESCRIPCION", "DEE_CODIGO" }) })
public class PedNivelParacademico extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "NIP_CODIGO", nullable = false)
	private Long nipCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "TIP_CODIGO", nullable = false)
	private Long tipCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "NIP_NIVEL", nullable = false)
	private Integer nipNivel;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 300)
	@Column(name = "NIP_DESCRIPCION", nullable = false, length = 300)
	private String nipDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "NIP_VIGENCIA", nullable = false, length = 1)
	private String nipVigencia;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "NIP_ACTIVADO", nullable = false, length = 1)
	private String nipActivado;

	@Size(max = 10)
	@Column(name = "NIP_ABREVIATURA", length = 10)
	private String nipAbreviatura;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DEE_CODIGO", nullable = false)
	private Long deeCodigo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedNivelParacademico", fetch = FetchType.LAZY)
	private Collection<PedDetalleNivelSuficiencia> pedDetalleNivelSuficienciaCollection;

	public PedNivelParacademico() {
	}

	public PedNivelParacademico(Long nipCodigo) {
		this.nipCodigo = nipCodigo;
	}

	public PedNivelParacademico(Long nipCodigo, Long tipCodigo, Integer nipNivel, String nipDescripcion,
			String nipVigencia, String nipActivado) {
		this.nipCodigo = nipCodigo;
		this.tipCodigo = tipCodigo;
		this.nipNivel = nipNivel;
		this.nipDescripcion = nipDescripcion;
		this.nipVigencia = nipVigencia;
		this.nipActivado = nipActivado;
	}

	public Long getNipCodigo() {
		return this.nipCodigo;
	}

	public void setNipCodigo(Long nipCodigo) {
		this.nipCodigo = nipCodigo;
	}

	public Long getTipCodigo() {
		return this.tipCodigo;
	}

	public void setTipCodigo(Long tipCodigo) {
		this.tipCodigo = tipCodigo;
	}

	public Integer getNipNivel() {
		return this.nipNivel;
	}

	public void setNipNivel(Integer nipNivel) {
		this.nipNivel = nipNivel;
	}

	public String getNipDescripcion() {
		return this.nipDescripcion;
	}

	public void setNipDescripcion(String nipDescripcion) {
		this.nipDescripcion = nipDescripcion;
	}

	public String getNipVigencia() {
		return this.nipVigencia;
	}

	public void setNipVigencia(String nipVigencia) {
		this.nipVigencia = nipVigencia;
	}

	public String getNipActivado() {
		return this.nipActivado;
	}

	public void setNipActivado(String nipActivado) {
		this.nipActivado = nipActivado;
	}

	public String getNipAbreviatura() {
		return this.nipAbreviatura;
	}

	public void setNipAbreviatura(String nipAbreviatura) {
		this.nipAbreviatura = nipAbreviatura;
	}

	public Long getDeeCodigo() {
		return this.deeCodigo;
	}

	public void setDeeCodigo(Long deeCodigo) {
		this.deeCodigo = deeCodigo;
	}

	public Collection<PedDetalleNivelSuficiencia> getPedDetalleNivelSuficienciaCollection() {
		return this.pedDetalleNivelSuficienciaCollection;
	}

	public void setPedDetalleNivelSuficienciaCollection(
			Collection<PedDetalleNivelSuficiencia> pedDetalleNivelSuficienciaCollection) {
		this.pedDetalleNivelSuficienciaCollection = pedDetalleNivelSuficienciaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedNivelParacademico)) {
			return false;
		}
		PedNivelParacademico other = (PedNivelParacademico) object;
		if ((this.nipCodigo == null && other.nipCodigo != null)
				|| (this.nipCodigo != null && !this.nipCodigo.equals(other.nipCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.nipCodigo != null) ? this.nipCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedNivelParacademico[ nipCodigo=" + this.nipCodigo + " ]";
	}

}
