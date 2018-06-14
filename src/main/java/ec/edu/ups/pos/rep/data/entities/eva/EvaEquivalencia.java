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
@Table(name = "EVA_EQUIVALENCIA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEquivalencia extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQU_CODIGO", nullable = false)
    private Long equCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EQU_DESCRIPCION", nullable = false, length = 100)
    private String equDescripcion;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEquivalencia", fetch = FetchType.LAZY)
    private Collection<EvaEvaluacion> evaEvaluacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEquivalencia", fetch = FetchType.LAZY)
    private Collection<EvaEquivalenciaDetalle> evaEquivalenciaDetalleCollection;

    public EvaEquivalencia() {
    }

    public EvaEquivalencia(Long equCodigo) {
        this.equCodigo = equCodigo;
    }

    public EvaEquivalencia(Long equCodigo, String equDescripcion) {
        this.equCodigo = equCodigo;
        this.equDescripcion = equDescripcion;        
    }

    public Long getEquCodigo() {
        return equCodigo;
    }

    public void setEquCodigo(Long equCodigo) {
        this.equCodigo = equCodigo;
    }

    public String getEquDescripcion() {
        return equDescripcion;
    }

    public void setEquDescripcion(String equDescripcion) {
        this.equDescripcion = equDescripcion;
    }    

    @XmlTransient
    public Collection<EvaEvaluacion> getEvaEvaluacionCollection() {
        return evaEvaluacionCollection;
    }

    public void setEvaEvaluacionCollection(Collection<EvaEvaluacion> evaEvaluacionCollection) {
        this.evaEvaluacionCollection = evaEvaluacionCollection;
    }

    @XmlTransient
    public Collection<EvaEquivalenciaDetalle> getEvaEquivalenciaDetalleCollection() {
        return evaEquivalenciaDetalleCollection;
    }

    public void setEvaEquivalenciaDetalleCollection(Collection<EvaEquivalenciaDetalle> evaEquivalenciaDetalleCollection) {
        this.evaEquivalenciaDetalleCollection = evaEquivalenciaDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equCodigo != null ? equCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEquivalencia)) {
            return false;
        }
        EvaEquivalencia other = (EvaEquivalencia) object;
        if ((this.equCodigo == null && other.equCodigo != null) || (this.equCodigo != null && !this.equCodigo.equals(other.equCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEquivalencia[ equCodigo=" + equCodigo + " ]";
    }
    
}
