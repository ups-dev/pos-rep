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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_EVALUACION", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEvaluacion extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVA_CODIGO", nullable = false)
    private Long evaCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EVA_DESCRIPCION", nullable = false, length = 100)
    private String evaDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EVA_VIGENTE", nullable = false, length = 1)
    private String evaVigente;    
    @Column(name = "EVA_CODIGO_LEG")
    private Long evaCodigoLeg;
    @JoinColumn(name = "EQU_CODIGO", referencedColumnName = "EQU_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEquivalencia evaEquivalencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEvaluacion", fetch = FetchType.LAZY)
    private Collection<EvaEvaluacionCuestionario> evaEvaluacionCuestionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEvaluacion", fetch = FetchType.LAZY)
    private Collection<EvaEvaluacionFecha> evaEvaluacionFechaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEvaluacion", fetch = FetchType.LAZY)
    private Collection<EvaColTipInf> evaColTipInfCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEvaluacion", fetch = FetchType.LAZY)
    private Collection<EvaEvaFecInf> evaEvaFecInfCollection;

    public EvaEvaluacion() {
    }

    public EvaEvaluacion(Long evaCodigo) {
        this.evaCodigo = evaCodigo;
    }

    public EvaEvaluacion(Long evaCodigo, String evaDescripcion, String evaVigente) {
        this.evaCodigo = evaCodigo;
        this.evaDescripcion = evaDescripcion;
        this.evaVigente = evaVigente;        
    }

    public Long getEvaCodigo() {
        return evaCodigo;
    }

    public void setEvaCodigo(Long evaCodigo) {
        this.evaCodigo = evaCodigo;
    }

    public String getEvaDescripcion() {
        return evaDescripcion;
    }

    public void setEvaDescripcion(String evaDescripcion) {
        this.evaDescripcion = evaDescripcion;
    }

    public String getEvaVigente() {
        return evaVigente;
    }

    public void setEvaVigente(String evaVigente) {
        this.evaVigente = evaVigente;
    }    

    public Long getEvaCodigoLeg() {
        return evaCodigoLeg;
    }

    public void setEvaCodigoLeg(Long evaCodigoLeg) {
        this.evaCodigoLeg = evaCodigoLeg;
    }

    public EvaEquivalencia getEvaEquivalencia() {
        return evaEquivalencia;
    }

    public void setEvaEquivalencia(EvaEquivalencia evaEquivalencia) {
        this.evaEquivalencia = evaEquivalencia;
    }    

    @XmlTransient
    public Collection<EvaEvaluacionCuestionario> getEvaEvaluacionCuestionarioCollection() {
        return evaEvaluacionCuestionarioCollection;
    }

    public void setEvaEvaluacionCuestionarioCollection(Collection<EvaEvaluacionCuestionario> evaEvaluacionCuestionarioCollection) {
        this.evaEvaluacionCuestionarioCollection = evaEvaluacionCuestionarioCollection;
    }

    @XmlTransient
    public Collection<EvaEvaluacionFecha> getEvaEvaluacionFechaCollection() {
        return evaEvaluacionFechaCollection;
    }

    public void setEvaEvaluacionFechaCollection(Collection<EvaEvaluacionFecha> evaEvaluacionFechaCollection) {
        this.evaEvaluacionFechaCollection = evaEvaluacionFechaCollection;
    }

    @XmlTransient
    public Collection<EvaColTipInf> getEvaColTipInfCollection() {
        return evaColTipInfCollection;
    }

    public void setEvaColTipInfCollection(Collection<EvaColTipInf> evaColTipInfCollection) {
        this.evaColTipInfCollection = evaColTipInfCollection;
    }

    @XmlTransient
    public Collection<EvaEvaFecInf> getEvaEvaFecInfCollection() {
        return evaEvaFecInfCollection;
    }

    public void setEvaEvaFecInfCollection(Collection<EvaEvaFecInf> evaEvaFecInfCollection) {
        this.evaEvaFecInfCollection = evaEvaFecInfCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaCodigo != null ? evaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEvaluacion)) {
            return false;
        }
        EvaEvaluacion other = (EvaEvaluacion) object;
        if ((this.evaCodigo == null && other.evaCodigo != null) || (this.evaCodigo != null && !this.evaCodigo.equals(other.evaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEvaluacion[ evaCodigo=" + evaCodigo + " ]";
    }
    
}
