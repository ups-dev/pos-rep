package ec.edu.ups.pos.rep.data.entities.rep;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "REP_REPORTES_SISTEMA", catalog = "", schema = "REP")
public class RepReportesSistema extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "RES_CODIGO", nullable = false)
	private Long resCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "RES_SISTEMA", nullable = false, length = 50)
	private String resSistema;

	@Size(max = 30)
	@Column(name = "RES_APLICACION", length = 30)
	private String resAplicacion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "RES_REPORTE", nullable = false, length = 50)
	private String resReporte;

	@Size(max = 30)
	@Column(name = "RES_ARCHIVO", length = 30)
	private String resArchivo;

	@Size(max = 30)
	@Column(name = "RES_ARCHIVO_EXCEL", length = 30)
	private String resArchivoExcel;

	@Size(max = 30)
	@Column(name = "RES_FORMATO", length = 30)
	private String resFormato;

	@Size(max = 100)
	@Column(name = "RES_AUTOR", length = 100)
	private String resAutor;

	@Size(max = 500)
	@Column(name = "RES_OBSERVACIONES", length = 500)
	private String resObservaciones;

	@Size(max = 100)
	@Column(name = "RES_MODULO", length = 100)
	private String resModulo;

	@Lob
	@Column(name = "RES_JASPER_PDF")
	private byte[] resArchivoJasperPd;

	@Lob
	@Column(name = "RES_JASPER_XLSX")
	private byte[] resArchivoJasperExcel;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "repReportesSistema", fetch = FetchType.LAZY)
	private Collection<RepReporteRol> repReporteRolCollection;

	public RepReportesSistema() {
	}

	public RepReportesSistema(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public RepReportesSistema(Long resCodigo, String resSistema, String resReporte) {
		this.resCodigo = resCodigo;
		this.resSistema = resSistema;
		this.resReporte = resReporte;
	}

	public Long getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(Long resCodigo) {
		this.resCodigo = resCodigo;
	}

	public String getResSistema() {
		return this.resSistema;
	}

	public void setResSistema(String resSistema) {
		this.resSistema = resSistema;
	}

	public String getResAplicacion() {
		return this.resAplicacion;
	}

	public void setResAplicacion(String resAplicacion) {
		this.resAplicacion = resAplicacion;
	}

	public String getResReporte() {
		return this.resReporte;
	}

	public void setResReporte(String resReporte) {
		this.resReporte = resReporte;
	}

	public String getResArchivo() {
		return this.resArchivo;
	}

	public void setResArchivo(String resArchivo) {
		this.resArchivo = resArchivo;
	}

	public String getResArchivoExcel() {
		return this.resArchivoExcel;
	}

	public void setResArchivoExcel(String resArchivoExcel) {
		this.resArchivoExcel = resArchivoExcel;
	}

	public String getResFormato() {
		return this.resFormato;
	}

	public void setResFormato(String resFormato) {
		this.resFormato = resFormato;
	}

	public String getResAutor() {
		return this.resAutor;
	}

	public void setResAutor(String resAutor) {
		this.resAutor = resAutor;
	}

	public String getResObservaciones() {
		return this.resObservaciones;
	}

	public void setResObservaciones(String resObservaciones) {
		this.resObservaciones = resObservaciones;
	}

	public String getResModulo() {
		return this.resModulo;
	}

	public void setResModulo(String ResModulo) {
		this.resModulo = ResModulo;
	}

	public byte[] getResArchivoJasperPd() {
		return this.resArchivoJasperPd;
	}

	public void setResArchivoJasperPd(byte[] resArchivoJasperPd) {
		this.resArchivoJasperPd = resArchivoJasperPd;
	}

	public byte[] getResArchivoJasperExcel() {
		return this.resArchivoJasperExcel;
	}

	public void setResArchivoJasperExcel(byte[] resArchivoJasperExcel) {
		this.resArchivoJasperExcel = resArchivoJasperExcel;
	}

	public Collection<RepReporteRol> getRepReporteRolCollection() {
		return this.repReporteRolCollection;
	}

	public void setRepReporteRolCollection(Collection<RepReporteRol> repReporteRolCollection) {
		this.repReporteRolCollection = repReporteRolCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RepReportesSistema)) {
			return false;
		}
		RepReportesSistema other = (RepReportesSistema) object;
		return (this.resCodigo != null || other.resCodigo == null)
				&& (this.resCodigo == null || this.resCodigo.equals(other.resCodigo));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.resCodigo != null) ? this.resCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "RepReportesSistema{" + "resCodigo=" + this.resCodigo + ", resSistema='" + this.resSistema + '\''
				+ ", resAplicacion='" + this.resAplicacion + '\'' + ", resReporte='" + this.resReporte + '\''
				+ ", resArchivo='" + this.resArchivo + '\'' + ", resArchivoExcel='" + this.resArchivoExcel + '\''
				+ ", resFormato='" + this.resFormato + '\'' + ", resAutor='" + this.resAutor + '\''
				+ ", resObservaciones='" + this.resObservaciones + '\'' + ", resModulo='" + this.resModulo + '\'' + '}';
	}

}
