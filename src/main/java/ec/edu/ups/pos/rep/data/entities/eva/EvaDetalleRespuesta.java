package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_DETALLE_RESPUESTA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaDetalleRespuesta extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DER_CODIGO", nullable = false)
    private Long derCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DER_PUNTUACION", nullable = false, precision = 5, scale = 2)
    private BigDecimal derPuntuacion;
    @Lob
    @Column(name = "DER_TEXTO_LARGO")
    private String derTextoLargo;    
    @JoinColumn(name = "ENR_CODIGO", referencedColumnName = "ENR_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEncabezadoRespuesta evaEncabezadoRespuesta;
    @JoinColumn(name = "OPP_CODIGO", referencedColumnName = "OPP_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaOpcionPregunta evaOpcionPregunta;

    public EvaDetalleRespuesta() {
    }

    public EvaDetalleRespuesta(Long derCodigo) {
        this.derCodigo = derCodigo;
    }

    public EvaDetalleRespuesta(Long derCodigo, BigDecimal derPuntuacion) {
        this.derCodigo = derCodigo;
        this.derPuntuacion = derPuntuacion;        
    }

    public Long getDerCodigo() {
        return derCodigo;
    }

    public void setDerCodigo(Long derCodigo) {
        this.derCodigo = derCodigo;
    }

    public BigDecimal getDerPuntuacion() {
        return derPuntuacion;
    }

    public void setDerPuntuacion(BigDecimal derPuntuacion) {
        this.derPuntuacion = derPuntuacion;
    }

    public String getDerTextoLargo() {
        return derTextoLargo;
    }

    public void setDerTextoLargo(String derTextoLargo) {
        this.derTextoLargo = derTextoLargo;
    }    

    public EvaEncabezadoRespuesta getEvaEncabezadoRespuesta() {
        return evaEncabezadoRespuesta;
    }

    public void setEvaEncabezadoRespuesta(EvaEncabezadoRespuesta evaEncabezadoRespuesta) {
        this.evaEncabezadoRespuesta = evaEncabezadoRespuesta;
    }

    public EvaOpcionPregunta getEvaOpcionPregunta() {
        return evaOpcionPregunta;
    }

    public void setEvaOpcionPregunta(EvaOpcionPregunta evaOpcionPregunta) {
        this.evaOpcionPregunta = evaOpcionPregunta;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (derCodigo != null ? derCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaDetalleRespuesta)) {
            return false;
        }
        EvaDetalleRespuesta other = (EvaDetalleRespuesta) object;
        if ((this.derCodigo == null && other.derCodigo != null) || (this.derCodigo != null && !this.derCodigo.equals(other.derCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaDetalleRespuesta[ derCodigo=" + derCodigo + " ]";
    }
    
}
