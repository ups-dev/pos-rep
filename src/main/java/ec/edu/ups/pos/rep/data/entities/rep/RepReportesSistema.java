package ec.edu.ups.pos.rep.data.entities.rep;

import ec.edu.ups.util.jpa.EntitySuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "REP_REPORTES_SISTEMA", catalog = "", schema = "REP")
@XmlRootElement
public class RepReportesSistema extends EntitySuperclass{

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
        return resCodigo;
    }

    public void setResCodigo(Long resCodigo) {
        this.resCodigo = resCodigo;
    }

    public String getResSistema() {
        return resSistema;
    }

    public void setResSistema(String resSistema) {
        this.resSistema = resSistema;
    }

    public String getResAplicacion() {
        return resAplicacion;
    }

    public void setResAplicacion(String resAplicacion) {
        this.resAplicacion = resAplicacion;
    }

    public String getResReporte() {
        return resReporte;
    }

    public void setResReporte(String resReporte) {
        this.resReporte = resReporte;
    }

    public String getResArchivo() {
        return resArchivo;
    }

    public void setResArchivo(String resArchivo) {
        this.resArchivo = resArchivo;
    }


    public String getResArchivoExcel() {
        return resArchivoExcel;
    }

    public void setResArchivoExcel(String resArchivoExcel) {
        this.resArchivoExcel = resArchivoExcel;
    }
    public String getResFormato() {
        return resFormato;
    }

    public void setResFormato(String resFormato) {
        this.resFormato = resFormato;
    }

    public String getResAutor() {
        return resAutor;
    }

    public void setResAutor(String resAutor) {
        this.resAutor = resAutor;
    }

    public String getResObservaciones() {
        return resObservaciones;
    }

    public void setResObservaciones(String resObservaciones) {
        this.resObservaciones = resObservaciones;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resCodigo != null ? resCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepReportesSistema)) {
            return false;
        }
        RepReportesSistema other = (RepReportesSistema) object;
        if ((this.resCodigo == null && other.resCodigo != null) || (this.resCodigo != null && !this.resCodigo.equals(other.resCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RepReportesSistema[ resCodigo=" + resCodigo + " ]";
    }
    
}
