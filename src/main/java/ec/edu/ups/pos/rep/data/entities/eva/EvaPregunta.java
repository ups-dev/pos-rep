package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
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
import javax.persistence.OneToOne;
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
@Table(name = "EVA_PREGUNTA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaPregunta extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_CODIGO", nullable = false)
    private Long preCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "PRE_DESCRIPCION", nullable = false, length = 500)
    private String preDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRE_ORDEN", nullable = false)
    private Short preOrden;    
    @Column(name = "PRE_CODIGO_LEG")
    private Long preCodigoLeg;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "evaPregunta", fetch = FetchType.LAZY)
    private EvaClasificacionPregunta evaClasificacionPregunta;
    @JoinColumn(name = "CUE_CODIGO", referencedColumnName = "CUE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaCuestionario evaCuestionario;
    @JoinColumn(name = "TIP_CODIGO", referencedColumnName = "TIP_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaTipoPregunta evaTipoPregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaPregunta", fetch = FetchType.LAZY)
    private Collection<EvaOpcionPregunta> evaOpcionPreguntaCollection;

    public EvaPregunta() {
    }

    public EvaPregunta(Long preCodigo) {
        this.preCodigo = preCodigo;
    }

    public EvaPregunta(Long preCodigo, String preDescripcion, Short preOrden) {
        this.preCodigo = preCodigo;
        this.preDescripcion = preDescripcion;
        this.preOrden = preOrden;        
    }

    public Long getPreCodigo() {
        return preCodigo;
    }

    public void setPreCodigo(Long preCodigo) {
        this.preCodigo = preCodigo;
    }

    public String getPreDescripcion() {
        return preDescripcion;
    }

    public void setPreDescripcion(String preDescripcion) {
        this.preDescripcion = preDescripcion;
    }

    public Short getPreOrden() {
        return preOrden;
    }

    public void setPreOrden(Short preOrden) {
        this.preOrden = preOrden;
    }    

    public Long getPreCodigoLeg() {
        return preCodigoLeg;
    }

    public void setPreCodigoLeg(Long preCodigoLeg) {
        this.preCodigoLeg = preCodigoLeg;
    }

    public EvaClasificacionPregunta getEvaClasificacionPregunta() {
        return evaClasificacionPregunta;
    }

    public void setEvaClasificacionPregunta(EvaClasificacionPregunta evaClasificacionPregunta) {
        this.evaClasificacionPregunta = evaClasificacionPregunta;
    }

    public EvaCuestionario getEvaCuestionario() {
        return evaCuestionario;
    }

    public void setEvaCuestionario(EvaCuestionario evaCuestionario) {
        this.evaCuestionario = evaCuestionario;
    }

    public EvaTipoPregunta getEvaTipoPregunta() {
        return evaTipoPregunta;
    }

    public void setEvaTipoPregunta(EvaTipoPregunta evaTipoPregunta) {
        this.evaTipoPregunta = evaTipoPregunta;
    }    

    @XmlTransient
    public Collection<EvaOpcionPregunta> getEvaOpcionPreguntaCollection() {
        return evaOpcionPreguntaCollection;
    }

    public void setEvaOpcionPreguntaCollection(Collection<EvaOpcionPregunta> evaOpcionPreguntaCollection) {
        this.evaOpcionPreguntaCollection = evaOpcionPreguntaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preCodigo != null ? preCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaPregunta)) {
            return false;
        }
        EvaPregunta other = (EvaPregunta) object;
        if ((this.preCodigo == null && other.preCodigo != null) || (this.preCodigo != null && !this.preCodigo.equals(other.preCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaPregunta[ preCodigo=" + preCodigo + " ]";
    }
    
}
