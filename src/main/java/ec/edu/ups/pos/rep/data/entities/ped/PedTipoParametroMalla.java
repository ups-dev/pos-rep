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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIPO_PARAMETRO_MALLA", schema = "PED")
public class PedTipoParametroMalla extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TPM_CODIGO", nullable = false)
	private Long tpmCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "TPM_DESCRIPCION", nullable = false, length = 500)
	private String tpmDescripcion;

	@Size(max = 1)
	@Column(name = "TPM_TIPO", length = 1)
	private String tpmTipo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TPM_OBLIGATORIO", nullable = false, length = 1)
	private String tpmObligatorio;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedTipoParametroMalla", fetch = FetchType.LAZY)
	private Collection<PedParametroMalla> pedParametroMallaCollection;

	public PedTipoParametroMalla() {
	}

	public PedTipoParametroMalla(Long tpmCodigo) {
		this.tpmCodigo = tpmCodigo;
	}

	public PedTipoParametroMalla(Long tpmCodigo, String tpmDescripcion, String tpmObligatorio) {
		this.tpmCodigo = tpmCodigo;
		this.tpmDescripcion = tpmDescripcion;
		this.tpmObligatorio = tpmObligatorio;
	}

	public Long getTpmCodigo() {
		return this.tpmCodigo;
	}

	public void setTpmCodigo(Long tpmCodigo) {
		this.tpmCodigo = tpmCodigo;
	}

	public String getTpmDescripcion() {
		return this.tpmDescripcion;
	}

	public void setTpmDescripcion(String tpmDescripcion) {
		this.tpmDescripcion = tpmDescripcion;
	}

	public String getTpmTipo() {
		return this.tpmTipo;
	}

	public void setTpmTipo(String tpmTipo) {
		this.tpmTipo = tpmTipo;
	}

	public String getTpmObligatorio() {
		return this.tpmObligatorio;
	}

	public void setTpmObligatorio(String tpmObligatorio) {
		this.tpmObligatorio = tpmObligatorio;
	}

	public Collection<PedParametroMalla> getPedParametroMallaCollection() {
		return this.pedParametroMallaCollection;
	}

	public void setPedParametroMallaCollection(Collection<PedParametroMalla> pedParametroMallaCollection) {
		this.pedParametroMallaCollection = pedParametroMallaCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipoParametroMalla)) {
			return false;
		}
		PedTipoParametroMalla other = (PedTipoParametroMalla) object;
		if ((this.tpmCodigo == null && other.tpmCodigo != null)
				|| (this.tpmCodigo != null && !this.tpmCodigo.equals(other.tpmCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tpmCodigo != null) ? this.tpmCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipoParametroMalla[ tpmCodigo=" + this.tpmCodigo + " ]";
	}

}
