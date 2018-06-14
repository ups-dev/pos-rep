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
@Table(name = "EVA_TIPO_CLASIFICACION", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaTipoClasificacion extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIC_CODIGO", nullable = false)
    private Long ticCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIC_DESCRIPCION", nullable = false, length = 100)
    private String ticDescripcion;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaTipoClasificacion", fetch = FetchType.LAZY)
    private Collection<EvaClasificacion> evaClasificacionCollection;

    public EvaTipoClasificacion() {
    }

    public EvaTipoClasificacion(Long ticCodigo) {
        this.ticCodigo = ticCodigo;
    }

    public EvaTipoClasificacion(Long ticCodigo, String ticDescripcion) {
        this.ticCodigo = ticCodigo;
        this.ticDescripcion = ticDescripcion;        
    }

    public Long getTicCodigo() {
        return ticCodigo;
    }

    public void setTicCodigo(Long ticCodigo) {
        this.ticCodigo = ticCodigo;
    }

    public String getTicDescripcion() {
        return ticDescripcion;
    }

    public void setTicDescripcion(String ticDescripcion) {
        this.ticDescripcion = ticDescripcion;
    }    

    @XmlTransient
    public Collection<EvaClasificacion> getEvaClasificacionCollection() {
        return evaClasificacionCollection;
    }

    public void setEvaClasificacionCollection(Collection<EvaClasificacion> evaClasificacionCollection) {
        this.evaClasificacionCollection = evaClasificacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticCodigo != null ? ticCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaTipoClasificacion)) {
            return false;
        }
        EvaTipoClasificacion other = (EvaTipoClasificacion) object;
        if ((this.ticCodigo == null && other.ticCodigo != null) || (this.ticCodigo != null && !this.ticCodigo.equals(other.ticCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaTipoClasificacion[ ticCodigo=" + ticCodigo + " ]";
    }
    
}
