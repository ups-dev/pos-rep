package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MALLA_PARACADEMICO", schema = "PED",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "PRE_NUMERO", "MAL_CODIGO" }) })
public class PedMallaParacademico extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MAP_CODIGO", nullable = false)
	private Long mapCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MAP_NIVEL", nullable = false)
	private Integer mapNivel;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MAP_NUMERO_HORAS", nullable = false)
	private Integer mapNumeroHoras;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MAP_NUMERO_CREDITOS", nullable = false)
	private Integer mapNumeroCreditos;

	@Size(max = 1)
	@Column(name = "MPI_MAS_IDIOMA_LEG", length = 1)
	private String mpiMasIdiomaLeg;

	@Column(name = "DMP_CODIGO_LEG")
	private Long dmpCodigoLeg;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PedMalla pedMalla;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PedProyectoEducacion pedProyectoEducacion;

	public PedMallaParacademico() {
	}

	public PedMallaParacademico(Long mapCodigo) {
		this.mapCodigo = mapCodigo;
	}

	public PedMallaParacademico(Long mapCodigo, Integer mapNivel, Integer mapNumeroHoras, Integer mapNumeroCreditos) {
		this.mapCodigo = mapCodigo;
		this.mapNivel = mapNivel;
		this.mapNumeroHoras = mapNumeroHoras;
		this.mapNumeroCreditos = mapNumeroCreditos;
	}

	public Long getMapCodigo() {
		return this.mapCodigo;
	}

	public void setMapCodigo(Long mapCodigo) {
		this.mapCodigo = mapCodigo;
	}

	public Integer getMapNivel() {
		return this.mapNivel;
	}

	public void setMapNivel(Integer mapNivel) {
		this.mapNivel = mapNivel;
	}

	public Integer getMapNumeroHoras() {
		return this.mapNumeroHoras;
	}

	public void setMapNumeroHoras(Integer mapNumeroHoras) {
		this.mapNumeroHoras = mapNumeroHoras;
	}

	public Integer getMapNumeroCreditos() {
		return this.mapNumeroCreditos;
	}

	public void setMapNumeroCreditos(Integer mapNumeroCreditos) {
		this.mapNumeroCreditos = mapNumeroCreditos;
	}

	public String getMpiMasIdiomaLeg() {
		return this.mpiMasIdiomaLeg;
	}

	public void setMpiMasIdiomaLeg(String mpiMasIdiomaLeg) {
		this.mpiMasIdiomaLeg = mpiMasIdiomaLeg;
	}

	public Long getDmpCodigoLeg() {
		return this.dmpCodigoLeg;
	}

	public void setDmpCodigoLeg(Long dmpCodigoLeg) {
		this.dmpCodigoLeg = dmpCodigoLeg;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMallaParacademico)) {
			return false;
		}
		PedMallaParacademico other = (PedMallaParacademico) object;
		if ((this.mapCodigo == null && other.mapCodigo != null)
				|| (this.mapCodigo != null && !this.mapCodigo.equals(other.mapCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mapCodigo != null) ? this.mapCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaParacademico[ mapCodigo=" + this.mapCodigo + " ]";
	}

}
