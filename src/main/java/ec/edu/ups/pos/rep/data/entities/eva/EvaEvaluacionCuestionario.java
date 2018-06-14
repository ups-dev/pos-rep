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
@Table(name = "EVA_EVALUACION_CUESTIONARIO", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEvaluacionCuestionario extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVC_CODIGO", nullable = false)
    private Long evcCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_CODIGO", nullable = false)
    private Long estCodigo;
    @Column(name = "PEL_CODIGO")
    private Long pelCodigo;
    @Column(name = "MOD_CODIGO")
    private Long modCodigo;    
    @JoinColumn(name = "CUE_CODIGO", referencedColumnName = "CUE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaCuestionario evaCuestionario;
    @JoinColumn(name = "EVA_CODIGO", referencedColumnName = "EVA_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEvaluacion evaEvaluacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEvaluacionCuestionario", fetch = FetchType.LAZY)
    private Collection<EvaEvaCueInf> evaEvaCueInfCollection;

    public EvaEvaluacionCuestionario() {
    }

    public EvaEvaluacionCuestionario(Long evcCodigo) {
        this.evcCodigo = evcCodigo;
    }

    public EvaEvaluacionCuestionario(Long evcCodigo, Long estCodigo) {
        this.evcCodigo = evcCodigo;
        this.estCodigo = estCodigo;        
    }

    public Long getEvcCodigo() {
        return evcCodigo;
    }

    public void setEvcCodigo(Long evcCodigo) {
        this.evcCodigo = evcCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public Long getModCodigo() {
        return modCodigo;
    }

    public void setModCodigo(Long modCodigo) {
        this.modCodigo = modCodigo;
    }    

    public EvaCuestionario getEvaCuestionario() {
        return evaCuestionario;
    }

    public void setEvaCuestionario(EvaCuestionario evaCuestionario) {
        this.evaCuestionario = evaCuestionario;
    }

    public EvaEvaluacion getEvaEvaluacion() {
        return evaEvaluacion;
    }

    public void setEvaEvaluacion(EvaEvaluacion evaEvaluacion) {
        this.evaEvaluacion = evaEvaluacion;
    }    

    @XmlTransient
    public Collection<EvaEvaCueInf> getEvaEvaCueInfCollection() {
        return evaEvaCueInfCollection;
    }

    public void setEvaEvaCueInfCollection(Collection<EvaEvaCueInf> evaEvaCueInfCollection) {
        this.evaEvaCueInfCollection = evaEvaCueInfCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evcCodigo != null ? evcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEvaluacionCuestionario)) {
            return false;
        }
        EvaEvaluacionCuestionario other = (EvaEvaluacionCuestionario) object;
        if ((this.evcCodigo == null && other.evcCodigo != null) || (this.evcCodigo != null && !this.evcCodigo.equals(other.evcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEvaluacionCuestionario[ evcCodigo=" + evcCodigo + " ]";
    }
    
}
