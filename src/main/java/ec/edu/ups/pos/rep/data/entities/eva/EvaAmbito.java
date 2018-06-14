package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "EVA_AMBITO", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaAmbito extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMB_CODIGO", nullable = false)
    private Long ambCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AMB_DESCRIPCION", nullable = false, length = 100)
    private String ambDescripcion;    
    @Column(name = "AMB_CODIGO_LEG")
    private Long ambCodigoLeg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaAmbito", fetch = FetchType.LAZY)
    private Collection<EvaEvaluacionFecha> evaEvaluacionFechaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaAmbito", fetch = FetchType.LAZY)
    private Collection<EvaCuestionario> evaCuestionarioCollection;

    public EvaAmbito() {
    }

    public EvaAmbito(Long ambCodigo) {
        this.ambCodigo = ambCodigo;
    }

    public EvaAmbito(Long ambCodigo, String ambDescripcion) {
        this.ambCodigo = ambCodigo;
        this.ambDescripcion = ambDescripcion;        
    }

    public Long getAmbCodigo() {
        return ambCodigo;
    }

    public void setAmbCodigo(Long ambCodigo) {
        this.ambCodigo = ambCodigo;
    }

    public String getAmbDescripcion() {
        return ambDescripcion;
    }

    public void setAmbDescripcion(String ambDescripcion) {
        this.ambDescripcion = ambDescripcion;
    }    

    public Long getAmbCodigoLeg() {
        return ambCodigoLeg;
    }

    public void setAmbCodigoLeg(Long ambCodigoLeg) {
        this.ambCodigoLeg = ambCodigoLeg;
    }

    @XmlTransient
    public Collection<EvaEvaluacionFecha> getEvaEvaluacionFechaCollection() {
        return evaEvaluacionFechaCollection;
    }

    public void setEvaEvaluacionFechaCollection(Collection<EvaEvaluacionFecha> evaEvaluacionFechaCollection) {
        this.evaEvaluacionFechaCollection = evaEvaluacionFechaCollection;
    }

    @XmlTransient
    public Collection<EvaCuestionario> getEvaCuestionarioCollection() {
        return evaCuestionarioCollection;
    }

    public void setEvaCuestionarioCollection(Collection<EvaCuestionario> evaCuestionarioCollection) {
        this.evaCuestionarioCollection = evaCuestionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ambCodigo != null ? ambCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaAmbito)) {
            return false;
        }
        EvaAmbito other = (EvaAmbito) object;
        if ((this.ambCodigo == null && other.ambCodigo != null) || (this.ambCodigo != null && !this.ambCodigo.equals(other.ambCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaAmbito[ ambCodigo=" + ambCodigo + " ]";
    }
    
}
