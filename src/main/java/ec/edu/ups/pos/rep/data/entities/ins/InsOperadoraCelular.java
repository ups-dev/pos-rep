package ec.edu.ups.pos.rep.data.entities.ins;

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

@Entity
@Table(name = "INS_OPERADORA_CELULAR", schema = "INS")
public class InsOperadoraCelular extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "OPC_CODIGO", nullable = false)
	private Long opcCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "OPC_DESCRIPCION", nullable = false, length = 30)
	private String opcDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insOperadoraCelular", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	public InsOperadoraCelular() {
	}

	public InsOperadoraCelular(Long opcCodigo) {
		this.opcCodigo = opcCodigo;
	}

	public InsOperadoraCelular(Long opcCodigo, String opcDescripcion) {
		this.opcCodigo = opcCodigo;
		this.opcDescripcion = opcDescripcion;
	}

	public Long getOpcCodigo() {
		return this.opcCodigo;
	}

	public void setOpcCodigo(Long opcCodigo) {
		this.opcCodigo = opcCodigo;
	}

	public String getOpcDescripcion() {
		return this.opcDescripcion;
	}

	public void setOpcDescripcion(String opcDescripcion) {
		this.opcDescripcion = opcDescripcion;
	}

	public Collection<InsAlumno> getInsAlumnoCollection() {
		return this.insAlumnoCollection;
	}

	public void setInsAlumnoCollection(Collection<InsAlumno> insAlumnoCollection) {
		this.insAlumnoCollection = insAlumnoCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsOperadoraCelular)) {
			return false;
		}
		InsOperadoraCelular other = (InsOperadoraCelular) object;
		if ((this.opcCodigo == null && other.opcCodigo != null)
				|| (this.opcCodigo != null && !this.opcCodigo.equals(other.opcCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.opcCodigo != null) ? this.opcCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsOperadoraCelular[ opcCodigo=" + this.opcCodigo + " ]";
	}

}
