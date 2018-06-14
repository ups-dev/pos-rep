package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_CLASIFICACION_PREGUNTA", catalog = "", schema = "EVA", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PRE_CODIGO"})})
@XmlRootElement
public class EvaClasificacionPregunta extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLP_CODIGO", nullable = false)
    private Long clpCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLP_PONDERACION", nullable = false, precision = 5, scale = 2)
    private BigDecimal clpPonderacion;    
    @JoinColumn(name = "CLC_CODIGO", referencedColumnName = "CLC_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaClasificacionCuestionario evaClasificacionCuestionario;
    @JoinColumn(name = "PRE_CODIGO", referencedColumnName = "PRE_CODIGO", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private EvaPregunta evaPregunta;

    public EvaClasificacionPregunta() {
    }

    public EvaClasificacionPregunta(Long clpCodigo) {
        this.clpCodigo = clpCodigo;
    }

    public EvaClasificacionPregunta(Long clpCodigo, BigDecimal clpPonderacion) {
        this.clpCodigo = clpCodigo;
        this.clpPonderacion = clpPonderacion;        
    }

    public Long getClpCodigo() {
        return clpCodigo;
    }

    public void setClpCodigo(Long clpCodigo) {
        this.clpCodigo = clpCodigo;
    }

    public BigDecimal getClpPonderacion() {
        return clpPonderacion;
    }

    public void setClpPonderacion(BigDecimal clpPonderacion) {
        this.clpPonderacion = clpPonderacion;
    }    

    public EvaClasificacionCuestionario getEvaClasificacionCuestionario() {
        return evaClasificacionCuestionario;
    }

    public void setEvaClasificacionCuestionario(EvaClasificacionCuestionario evaClasificacionCuestionario) {
        this.evaClasificacionCuestionario = evaClasificacionCuestionario;
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
        hash += (clpCodigo != null ? clpCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaClasificacionPregunta)) {
            return false;
        }
        EvaClasificacionPregunta other = (EvaClasificacionPregunta) object;
        if ((this.clpCodigo == null && other.clpCodigo != null) || (this.clpCodigo != null && !this.clpCodigo.equals(other.clpCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaClasificacionPregunta[ clpCodigo=" + clpCodigo + " ]";
    }
    
}
