package ec.edu.ups.pos.rep.data.entities.aseg;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ASEG_APLICACION", schema = "ASEG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "APL_ABREVIACION" }) })
public class AsegAplicacion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "APL_CODIGO", nullable = false)
	private Long aplCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "APL_ABREVIACION", nullable = false, length = 20)
	private String aplAbreviacion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "APL_DESCRIPCION", nullable = false, length = 50)
	private String aplDescripcion;

	@Basic(optional = false)
	@NotNull
	@Column(name = "APL_TIPO", nullable = false, length = 1)
	private String aplTipo;

	@OneToMany(mappedBy = "asegAplicacion", fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Collection<AsegRol> asegRolCollection;

	@OneToMany(mappedBy = "asegAplicacion", fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Collection<AsegSeccion> asegSeccionCollection;

	@JoinColumn(name = "SER_PRUEBA", referencedColumnName = "SER_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private AsegServidor asegServidorPrueba;

	@JoinColumn(name = "SER_DESARROLLO", referencedColumnName = "SER_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private AsegServidor asegServidorDesarrollo;

	@JoinColumn(name = "SER_PRODUCCION", referencedColumnName = "SER_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegServidor asegServidorProduccion;

	public AsegAplicacion() {
		// default implementation ignored
	}

	public Long getAplCodigo() {
		return this.aplCodigo;
	}

	public void setAplCodigo(Long aplCodigo) {
		this.aplCodigo = aplCodigo;
	}

	public String getAplAbreviacion() {
		return this.aplAbreviacion;
	}

	public void setAplAbreviacion(String aplAbreviacion) {
		this.aplAbreviacion = aplAbreviacion;
	}

	public String getAplDescripcion() {
		return this.aplDescripcion;
	}

	public void setAplDescripcion(String aplDescripcion) {
		this.aplDescripcion = aplDescripcion;
	}

	public Collection<AsegRol> getAsegRolCollection() {
		return this.asegRolCollection;
	}

	public void setAsegRolCollection(Collection<AsegRol> asegRolCollection) {
		this.asegRolCollection = asegRolCollection;
	}

	public Collection<AsegSeccion> getAsegSeccionCollection() {
		return this.asegSeccionCollection;
	}

	public void setAsegSeccionCollection(Collection<AsegSeccion> asegSeccionCollection) {
		this.asegSeccionCollection = asegSeccionCollection;
	}

	public AsegServidor getAsegServidorPrueba() {
		return this.asegServidorPrueba;
	}

	public void setAsegServidorPrueba(AsegServidor asegServidorPrueba) {
		this.asegServidorPrueba = asegServidorPrueba;
	}

	public AsegServidor getAsegServidorDesarrollo() {
		return this.asegServidorDesarrollo;
	}

	public void setAsegServidorDesarrollo(AsegServidor asegServidorDesarrollo) {
		this.asegServidorDesarrollo = asegServidorDesarrollo;
	}

	public AsegServidor getAsegServidorProduccion() {
		return this.asegServidorProduccion;
	}

	public void setAsegServidorProduccion(AsegServidor asegServidorProduccion) {
		this.asegServidorProduccion = asegServidorProduccion;
	}

	public String getAplTipo() {
		return this.aplTipo;
	}

	public void setAplTipo(String aplTipo) {
		this.aplTipo = aplTipo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegAplicacion)) {
			return false;
		}
		AsegAplicacion other = (AsegAplicacion) object;
		return !((this.aplCodigo == null && other.aplCodigo != null)
				|| (this.aplCodigo != null && !this.aplCodigo.equals(other.aplCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.aplCodigo != null) ? this.aplCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegAplicacion[%d]", this.aplCodigo);
	}

}
