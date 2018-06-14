package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_OPCION_PREGUNTA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaOpcionPregunta extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_CODIGO", nullable = false)
    private Long oppCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OPP_DESCRIPCION", nullable = false, length = 100)
    private String oppDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_PUNTUACION", nullable = false, precision = 5, scale = 2)
    private BigDecimal oppPuntuacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPP_ORDEN", nullable = false)
    private Short oppOrden;    
    @Column(name = "OPR_CODIGO_LEG")
    private Long oprCodigoLeg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaOpcionPregunta", fetch = FetchType.LAZY)
    private Collection<EvaDetalleRespuesta> evaDetalleRespuestaCollection;
    @JoinColumn(name = "PRE_CODIGO", referencedColumnName = "PRE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaPregunta evaPregunta;

    public EvaOpcionPregunta() {
    }

    public EvaOpcionPregunta(Long oppCodigo) {
        this.oppCodigo = oppCodigo;
    }

    public EvaOpcionPregunta(Long oppCodigo, String oppDescripcion, BigDecimal oppPuntuacion, Short oppOrden) {
        this.oppCodigo = oppCodigo;
        this.oppDescripcion = oppDescripcion;
        this.oppPuntuacion = oppPuntuacion;
        this.oppOrden = oppOrden;        
    }

    public Long getOppCodigo() {
        return oppCodigo;
    }

    public void setOppCodigo(Long oppCodigo) {
        this.oppCodigo = oppCodigo;
    }

    public String getOppDescripcion() {
        return oppDescripcion;
    }

    public void setOppDescripcion(String oppDescripcion) {
        this.oppDescripcion = oppDescripcion;
    }

    public BigDecimal getOppPuntuacion() {
        return oppPuntuacion;
    }

    public void setOppPuntuacion(BigDecimal oppPuntuacion) {
        this.oppPuntuacion = oppPuntuacion;
    }

    public Short getOppOrden() {
        return oppOrden;
    }

    public void setOppOrden(Short oppOrden) {
        this.oppOrden = oppOrden;
    }    

    public Long getOprCodigoLeg() {
        return oprCodigoLeg;
    }

    public void setOprCodigoLeg(Long oprCodigoLeg) {
        this.oprCodigoLeg = oprCodigoLeg;
    }

    @XmlTransient
    public Collection<EvaDetalleRespuesta> getEvaDetalleRespuestaCollection() {
        return evaDetalleRespuestaCollection;
    }

    public void setEvaDetalleRespuestaCollection(Collection<EvaDetalleRespuesta> evaDetalleRespuestaCollection) {
        this.evaDetalleRespuestaCollection = evaDetalleRespuestaCollection;
    }

    public EvaPregunta getEvaPregunta() {
        return evaPregunta;
    }

    public void setEvaPregunta(EvaPregunta evaPregunta) {
        this.evaPregunta = evaPregunta;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oppCodigo != null ? oppCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaOpcionPregunta)) {
            return false;
        }
        EvaOpcionPregunta other = (EvaOpcionPregunta) object;
        if ((this.oppCodigo == null && other.oppCodigo != null) || (this.oppCodigo != null && !this.oppCodigo.equals(other.oppCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaOpcionPregunta[ oppCodigo=" + oppCodigo + " ]";
    }
    
}
