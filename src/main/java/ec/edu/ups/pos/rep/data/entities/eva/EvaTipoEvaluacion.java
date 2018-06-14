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
@Table(name = "EVA_TIPO_EVALUACION", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaTipoEvaluacion extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIE_CODIGO", nullable = false)
    private Long tieCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIE_DESCRIPCION", nullable = false, length = 100)
    private String tieDescripcion;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaTipoEvaluacion", fetch = FetchType.LAZY)
    private Collection<EvaInfTipEva> evaInfTipEvaCollection;

    public EvaTipoEvaluacion() {
    }

    public EvaTipoEvaluacion(Long tieCodigo) {
        this.tieCodigo = tieCodigo;
    }

    public EvaTipoEvaluacion(Long tieCodigo, String tieDescripcion) {
        this.tieCodigo = tieCodigo;
        this.tieDescripcion = tieDescripcion;        
    }

    public Long getTieCodigo() {
        return tieCodigo;
    }

    public void setTieCodigo(Long tieCodigo) {
        this.tieCodigo = tieCodigo;
    }

    public String getTieDescripcion() {
        return tieDescripcion;
    }

    public void setTieDescripcion(String tieDescripcion) {
        this.tieDescripcion = tieDescripcion;
    }    

    @XmlTransient
    public Collection<EvaInfTipEva> getEvaInfTipEvaCollection() {
        return evaInfTipEvaCollection;
    }

    public void setEvaInfTipEvaCollection(Collection<EvaInfTipEva> evaInfTipEvaCollection) {
        this.evaInfTipEvaCollection = evaInfTipEvaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tieCodigo != null ? tieCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaTipoEvaluacion)) {
            return false;
        }
        EvaTipoEvaluacion other = (EvaTipoEvaluacion) object;
        if ((this.tieCodigo == null && other.tieCodigo != null) || (this.tieCodigo != null && !this.tieCodigo.equals(other.tieCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaTipoEvaluacion[ tieCodigo=" + tieCodigo + " ]";
    }
    
}
