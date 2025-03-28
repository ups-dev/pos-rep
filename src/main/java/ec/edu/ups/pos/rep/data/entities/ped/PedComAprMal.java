package ec.edu.ups.pos.rep.data.entities.ped;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_COM_APR_MAL", schema = "PED")
public class PedComAprMal extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CAM_CODIGO", nullable = false, updatable = false)
	private Long camCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CAM_NRO_HORAS", nullable = false)
	private Integer camNroHoras;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CAM_NRO_CREDITOS", nullable = false, precision = 5, scale = 2)
	private BigDecimal camNroCreditos;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CAM_NRO_HORAS_POR_SEMANA", nullable = false)
	private Integer camNroHorasPorSemana;

	@Column(name = "PEL_CODIGO_INICIO")
	private Long pelCodigoInicio;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	@JoinColumn(name = "COA_CODIGO", referencedColumnName = "COA_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedComponenteAprendizaje pedComponenteAprendizaje;

	public PedComAprMal() {
	}

	public PedComAprMal(Long camCodigo) {
		this.camCodigo = camCodigo;
	}

	public PedComAprMal(Long camCodigo, Integer camNroHoras, BigDecimal camNroCreditos, Integer camNroHorasPorSemana) {
		this.camCodigo = camCodigo;
		this.camNroHoras = camNroHoras;
		this.camNroCreditos = camNroCreditos;
		this.camNroHorasPorSemana = camNroHorasPorSemana;
	}

	public Long getCamCodigo() {
		return this.camCodigo;
	}

	public void setCamCodigo(Long camCodigo) {
		this.camCodigo = camCodigo;
	}

	public Integer getCamNroHoras() {
		return this.camNroHoras;
	}

	public void setCamNroHoras(Integer camNroHoras) {
		this.camNroHoras = camNroHoras;
	}

	public BigDecimal getCamNroCreditos() {
		return this.camNroCreditos;
	}

	public void setCamNroCreditos(BigDecimal camNroCreditos) {
		this.camNroCreditos = camNroCreditos;
	}

	public Integer getCamNroHorasPorSemana() {
		return this.camNroHorasPorSemana;
	}

	public void setCamNroHorasPorSemana(Integer camNroHorasPorSemana) {
		this.camNroHorasPorSemana = camNroHorasPorSemana;
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

	public PedComponenteAprendizaje getPedComponenteAprendizaje() {
		return this.pedComponenteAprendizaje;
	}

	public void setPedComponenteAprendizaje(PedComponenteAprendizaje pedComponenteAprendizaje) {
		this.pedComponenteAprendizaje = pedComponenteAprendizaje;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedComAprMal)) {
			return false;
		}
		PedComAprMal other = (PedComAprMal) object;
		if ((this.camCodigo == null && other.camCodigo != null)
				|| (this.camCodigo != null && !this.camCodigo.equals(other.camCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.camCodigo != null) ? this.camCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedComAprMal[ camCodigo=" + this.camCodigo + " ]";
	}

}
