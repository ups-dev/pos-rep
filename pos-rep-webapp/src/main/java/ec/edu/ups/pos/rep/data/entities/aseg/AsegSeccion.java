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
@Table(name = "ASEG_SECCION", schema = "ASEG",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "SEC_NOMBRE_CLAVE" }) })
public class AsegSeccion extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "SEC_CODIGO", nullable = false)
	private Long secCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "SEC_NOMBRE_CLAVE", nullable = false, length = 100)
	private String secNombreClave;

	@Size(max = 250)
	@Column(name = "SEC_PARAMETRO", length = 250)
	private String secParametro;

	@Size(min = 1, max = 200)
	@Column(name = "SEC_RUTA", length = 200)
	private String secRuta;

	@Size(min = 1, max = 200)
	@Column(name = "SEC_COMPONENTE", length = 200)
	private String secComponente;

	@OneToMany(mappedBy = "asegSeccionPadre", fetch = FetchType.LAZY)
	private Collection<AsegSeccion> asegSeccionCollection;

	@JoinColumn(name = "SEC_CODIGO_PADRE", referencedColumnName = "SEC_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private AsegSeccion asegSeccionPadre;

	@JoinColumn(name = "APL_CODIGO", referencedColumnName = "APL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private AsegAplicacion asegAplicacion;

	@OneToMany(mappedBy = "asegSeccion", fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Collection<AsegPermiso> asegPermisoCollection;

	@OneToMany(mappedBy = "asegSeccion", fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Collection<AsegMenu> asegMenuCollection;

	public AsegSeccion() {
		// default implementation ignored
	}

	public AsegSeccion(Long secCodigo, String secNombreClave, String secRuta) {
		this.secCodigo = secCodigo;
		this.secNombreClave = secNombreClave;
		this.secRuta = secRuta;
	}

	public Long getSecCodigo() {
		return this.secCodigo;
	}

	public void setSecCodigo(Long secCodigo) {
		this.secCodigo = secCodigo;
	}

	public String getSecNombreClave() {
		return this.secNombreClave;
	}

	public void setSecNombreClave(String secNombreClave) {
		this.secNombreClave = secNombreClave;
	}

	public String getSecParametro() {
		return this.secParametro;
	}

	public void setSecParametro(String secParametro) {
		this.secParametro = secParametro;
	}

	public String getSecRuta() {
		return this.secRuta;
	}

	public void setSecRuta(String secRuta) {
		this.secRuta = secRuta;
	}

	public AsegAplicacion getAsegAplicacion() {
		return this.asegAplicacion;
	}

	public void setAsegAplicacion(AsegAplicacion asegAplicacion) {
		this.asegAplicacion = asegAplicacion;
	}

	public AsegSeccion getAsegSeccionPadre() {
		return this.asegSeccionPadre;
	}

	public void setAsegSeccionPadre(AsegSeccion asegSeccionPadre) {
		this.asegSeccionPadre = asegSeccionPadre;
	}

	public String getSecComponente() {
		return this.secComponente;
	}

	public void setSecComponente(String secComponente) {
		this.secComponente = secComponente;
	}

	public Collection<AsegPermiso> getAsegPermisoCollection() {
		return this.asegPermisoCollection;
	}

	public void setAsegPermisoCollection(Collection<AsegPermiso> asegPermisoCollection) {
		this.asegPermisoCollection = asegPermisoCollection;
	}

	public Collection<AsegMenu> getAsegMenuCollection() {
		return this.asegMenuCollection;
	}

	public void setAsegMenuCollection(Collection<AsegMenu> asegMenuCollection) {
		this.asegMenuCollection = asegMenuCollection;
	}

	public Collection<AsegSeccion> getAsegSeccionCollection() {
		return this.asegSeccionCollection;
	}

	public void setAsegSeccionCollection(Collection<AsegSeccion> asegSeccionCollection) {
		this.asegSeccionCollection = asegSeccionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegSeccion)) {
			return false;
		}
		AsegSeccion other = (AsegSeccion) object;
		return !((this.secCodigo == null && other.secCodigo != null)
				|| (this.secCodigo != null && !this.secCodigo.equals(other.secCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.secCodigo != null) ? this.secCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegSeccion[%d]", this.secCodigo);
	}

}
