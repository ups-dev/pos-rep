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
@Table(name = "INS_ESTADO_CIVIL", schema = "INS")
public class InsEstadoCivil extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ESC_CODIGO", nullable = false)
	private Long escCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "ESC_DESCRIPCION", nullable = false, length = 15)
	private String escDescripcion;

	@Size(max = 10)
	@Column(name = "ESC_ABREVIATURA", length = 10)
	private String escAbreviatura;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insEstadoCivil", fetch = FetchType.LAZY)
	private Collection<InsAlumno> insAlumnoCollection;

	public InsEstadoCivil() {
	}

	public InsEstadoCivil(Long escCodigo) {
		this.escCodigo = escCodigo;
	}

	public InsEstadoCivil(Long escCodigo, String escDescripcion) {
		this.escCodigo = escCodigo;
		this.escDescripcion = escDescripcion;
	}

	public Long getEscCodigo() {
		return this.escCodigo;
	}

	public void setEscCodigo(Long escCodigo) {
		this.escCodigo = escCodigo;
	}

	public String getEscDescripcion() {
		return this.escDescripcion;
	}

	public void setEscDescripcion(String escDescripcion) {
		this.escDescripcion = escDescripcion;
	}

	public String getEscAbreviatura() {
		return this.escAbreviatura;
	}

	public void setEscAbreviatura(String escAbreviatura) {
		this.escAbreviatura = escAbreviatura;
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
		if (!(object instanceof InsEstadoCivil)) {
			return false;
		}
		InsEstadoCivil other = (InsEstadoCivil) object;
		if ((this.escCodigo == null && other.escCodigo != null)
				|| (this.escCodigo != null && !this.escCodigo.equals(other.escCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.escCodigo != null) ? this.escCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsEstadoCivil[ escCodigo=" + this.escCodigo + " ]";
	}

}
