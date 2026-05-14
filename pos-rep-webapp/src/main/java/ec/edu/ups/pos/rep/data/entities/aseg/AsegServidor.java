package ec.edu.ups.pos.rep.data.entities.aseg;

import java.util.Collection;

import javax.persistence.Basic;
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
@Table(name = "ASEG_SERVIDOR", schema = "ASEG")
public class AsegServidor extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "SER_CODIGO", nullable = false)
	private Long serCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "SER_IP", nullable = false, length = 15)
	private String serIp;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 6)
	@Column(name = "SER_PUERTO", nullable = false, length = 6)
	private String serPuerto;

	@Size(max = 50)
	@Column(name = "SER_DESCRIPCION", length = 50)
	private String serDescripcion;

	@Size(max = 200)
	@Column(name = "SER_DNS", length = 200)
	private String serDns;

	@Size(max = 10)
	@Column(name = "SER_VERSION", length = 10)
	private String serVersion;

	@Size(max = 500)
	@Column(name = "SER_OBSERVACION", length = 500)
	private String serObservacion;

	@OneToMany(mappedBy = "asegServidorPrueba", fetch = FetchType.LAZY)
	private Collection<AsegAplicacion> asegAplicacionCollectionPrueba;

	@OneToMany(mappedBy = "asegServidorDesarrollo", fetch = FetchType.LAZY)
	private Collection<AsegAplicacion> asegAplicacionCollectionDesarrollo;

	@OneToMany(mappedBy = "asegServidorProduccion", fetch = FetchType.LAZY)
	private Collection<AsegAplicacion> asegAplicacionCollectionProduccion;

	public AsegServidor() {
		// default implementation ignored
	}

	public AsegServidor(Long serCodigo, String serIp, String serPuerto) {
		this.serCodigo = serCodigo;
		this.serIp = serIp;
		this.serPuerto = serPuerto;
	}

	public Long getSerCodigo() {
		return this.serCodigo;
	}

	public void setSerCodigo(Long serCodigo) {
		this.serCodigo = serCodigo;
	}

	public String getSerIp() {
		return this.serIp;
	}

	public void setSerIp(String serIp) {
		this.serIp = serIp;
	}

	public String getSerPuerto() {
		return this.serPuerto;
	}

	public void setSerPuerto(String serPuerto) {
		this.serPuerto = serPuerto;
	}

	public String getSerDescripcion() {
		return this.serDescripcion;
	}

	public void setSerDescripcion(String serDescripcion) {
		this.serDescripcion = serDescripcion;
	}

	public String getSerDns() {
		return this.serDns;
	}

	public void setSerDns(String serDns) {
		this.serDns = serDns;
	}

	public String getSerVersion() {
		return this.serVersion;
	}

	public void setSerVersion(String serVersion) {
		this.serVersion = serVersion;
	}

	public String getSerObservacion() {
		return this.serObservacion;
	}

	public void setSerObservacion(String serObservacion) {
		this.serObservacion = serObservacion;
	}

	public Collection<AsegAplicacion> getAsegAplicacionCollectionPrueba() {
		return this.asegAplicacionCollectionPrueba;
	}

	public void setAsegAplicacionCollectionPrueba(Collection<AsegAplicacion> asegAplicacionCollectionPrueba) {
		this.asegAplicacionCollectionPrueba = asegAplicacionCollectionPrueba;
	}

	public Collection<AsegAplicacion> getAsegAplicacionCollectionDesarrollo() {
		return this.asegAplicacionCollectionDesarrollo;
	}

	public void setAsegAplicacionCollectionDesarrollo(Collection<AsegAplicacion> asegAplicacionCollectionDesarrollo) {
		this.asegAplicacionCollectionDesarrollo = asegAplicacionCollectionDesarrollo;
	}

	public Collection<AsegAplicacion> getAsegAplicacionCollectionProduccion() {
		return this.asegAplicacionCollectionProduccion;
	}

	public void setAsegAplicacionCollectionProduccion(Collection<AsegAplicacion> asegAplicacionCollectionProduccion) {
		this.asegAplicacionCollectionProduccion = asegAplicacionCollectionProduccion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegServidor)) {
			return false;
		}
		AsegServidor other = (AsegServidor) object;
		return !((this.serCodigo == null && other.serCodigo != null)
				|| (this.serCodigo != null && !this.serCodigo.equals(other.serCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.serCodigo != null) ? this.serCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegServidor[%d]", this.serCodigo);
	}

}
