package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "PED_NIVEL_MALLA", schema = "PED")
public class PedNivelMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "NIM_CODIGO", nullable = false)
	private Long nimCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "NIM_DESCRIPCION", nullable = false, length = 500)
	private String nimDescripcion;

	@Basic(optional = false)
	@NotNull
	@Column(name = "NIM_NIVEL", nullable = false)
	private Integer nimNivel;

	@Basic(optional = false)
	@NotNull
	@Column(name = "NIM_NRO_MATRICULABLE", nullable = false)
	private Integer nimNroMatriculable;

	@OneToMany(mappedBy = "pedNivelMalla", fetch = FetchType.LAZY)
	private Collection<PedMalla> pedMallaCollection;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	public PedNivelMalla() {
	}

	public PedNivelMalla(Long nimCodigo) {
		this.nimCodigo = nimCodigo;
	}

	public PedNivelMalla(Long nimCodigo, String nimDescripcion, Integer nimNivel, Integer nimNroMatriculable) {
		this.nimCodigo = nimCodigo;
		this.nimDescripcion = nimDescripcion;
		this.nimNivel = nimNivel;
		this.nimNroMatriculable = nimNroMatriculable;
	}

	public Long getNimCodigo() {
		return this.nimCodigo;
	}

	public void setNimCodigo(Long nimCodigo) {
		this.nimCodigo = nimCodigo;
	}

	public String getNimDescripcion() {
		return this.nimDescripcion;
	}

	public void setNimDescripcion(String nimDescripcion) {
		this.nimDescripcion = nimDescripcion;
	}

	public Integer getNimNivel() {
		return this.nimNivel;
	}

	public void setNimNivel(Integer nimNivel) {
		this.nimNivel = nimNivel;
	}

	public Integer getNimNroMatriculable() {
		return this.nimNroMatriculable;
	}

	public void setNimNroMatriculable(Integer nimNroMatriculable) {
		this.nimNroMatriculable = nimNroMatriculable;
	}

	public Collection<PedMalla> getPedMallaCollection() {
		return this.pedMallaCollection;
	}

	public void setPedMallaCollection(Collection<PedMalla> pedMallaCollection) {
		this.pedMallaCollection = pedMallaCollection;
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
		if (!(object instanceof PedNivelMalla)) {
			return false;
		}
		PedNivelMalla other = (PedNivelMalla) object;
		if ((this.nimCodigo == null && other.nimCodigo != null)
				|| (this.nimCodigo != null && !this.nimCodigo.equals(other.nimCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.nimCodigo != null) ? this.nimCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedNivelMalla[ nimCodigo=" + this.nimCodigo + " ]";
	}

}
