//Entidad
package ec.edu.ups.pos.rep.data.entities.wrapper;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Description.
 *
 * @author ups .
 */
@Entity
public class InsAlumnoWrapper implements Serializable {

	@Id
	private Long aluCodigo;

	private String cllcRuc;

	private String aluNombres;

	public InsAlumnoWrapper() {
	}

	public InsAlumnoWrapper(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public InsAlumnoWrapper(Long aluCodigo, String cllcRuc, String aluNombres) {
		this.aluCodigo = aluCodigo;
		this.cllcRuc = cllcRuc;
		this.aluNombres = aluNombres;
	}

	public Long getAluCodigo() {
		return this.aluCodigo;
	}

	public void setAluCodigo(Long aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	public String getCllcRuc() {
		return this.cllcRuc;
	}

	public void setCllcRuc(String cllcRuc) {
		this.cllcRuc = cllcRuc;
	}

	public String getAluNombres() {
		return this.aluNombres;
	}

	public void setAluNombres(String aluNombres) {
		this.aluNombres = aluNombres;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsAlumnoWrapper)) {
			return false;
		}
		InsAlumnoWrapper other = (InsAlumnoWrapper) object;
		if ((this.aluCodigo == null && other.aluCodigo != null)
				|| (this.aluCodigo != null && !this.aluCodigo.equals(other.aluCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.aluCodigo != null) ? this.aluCodigo.hashCode() : 0);
		return hash;
	}

}
