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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_EVA_CUE_INF", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEvaCueInf extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ECI_CODIGO", nullable = false)
    private Long eciCodigo;    
    @JoinColumn(name = "EVC_CODIGO", referencedColumnName = "EVC_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEvaluacionCuestionario evaEvaluacionCuestionario;
    @JoinColumn(name = "ITE_CODIGO", referencedColumnName = "ITE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaInfTipEva evaInfTipEva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEvaCueInf", fetch = FetchType.LAZY)
    private Collection<EvaEncabezadoRespuesta> evaEncabezadoRespuestaCollection;

    public EvaEvaCueInf() {
    }

    public EvaEvaCueInf(Long eciCodigo) {
        this.eciCodigo = eciCodigo;
    }

    public Long getEciCodigo() {
        return eciCodigo;
    }

    public void setEciCodigo(Long eciCodigo) {
        this.eciCodigo = eciCodigo;
    }    

    public EvaEvaluacionCuestionario getEvaEvaluacionCuestionario() {
        return evaEvaluacionCuestionario;
    }

    public void setEvaEvaluacionCuestionario(EvaEvaluacionCuestionario evaEvaluacionCuestionario) {
        this.evaEvaluacionCuestionario = evaEvaluacionCuestionario;
    }

    public EvaInfTipEva getEvaInfTipEva() {
        return evaInfTipEva;
    }

    public void setEvaInfTipEva(EvaInfTipEva evaInfTipEva) {
        this.evaInfTipEva = evaInfTipEva;
    }    

    @XmlTransient
    public Collection<EvaEncabezadoRespuesta> getEvaEncabezadoRespuestaCollection() {
        return evaEncabezadoRespuestaCollection;
    }

    public void setEvaEncabezadoRespuestaCollection(Collection<EvaEncabezadoRespuesta> evaEncabezadoRespuestaCollection) {
        this.evaEncabezadoRespuestaCollection = evaEncabezadoRespuestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eciCodigo != null ? eciCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEvaCueInf)) {
            return false;
        }
        EvaEvaCueInf other = (EvaEvaCueInf) object;
        if ((this.eciCodigo == null && other.eciCodigo != null) || (this.eciCodigo != null && !this.eciCodigo.equals(other.eciCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEvaCueInf[ eciCodigo=" + eciCodigo + " ]";
    }
    
}
