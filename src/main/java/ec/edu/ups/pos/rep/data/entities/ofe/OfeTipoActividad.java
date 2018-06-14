package ec.edu.ups.pos.rep.data.entities.ofe;

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
@Table(name = "OFE_TIPO_ACTIVIDAD", catalog = "", schema = "OFE")
@XmlRootElement
public class OfeTipoActividad extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIA_CODIGO", nullable = false)
    private Long tiaCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIA_DESCRIPCION", nullable = false, length = 100)
    private String tiaDescripcion;    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiaCodigo", fetch = FetchType.LAZY)
//    private Collection<OfeDedicacionTipoRol> ofeDedicacionTipoRolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofeTipoActividad", fetch = FetchType.LAZY)
    private Collection<OfeActividad> ofeActividadCollection;

    public OfeTipoActividad() {
    }

    public OfeTipoActividad(Long tiaCodigo) {
        this.tiaCodigo = tiaCodigo;
    }

    public OfeTipoActividad(Long tiaCodigo, String tiaDescripcion) {
        this.tiaCodigo = tiaCodigo;
        this.tiaDescripcion = tiaDescripcion;        
    }

    public Long getTiaCodigo() {
        return tiaCodigo;
    }

    public void setTiaCodigo(Long tiaCodigo) {
        this.tiaCodigo = tiaCodigo;
    }

    public String getTiaDescripcion() {
        return tiaDescripcion;
    }

    public void setTiaDescripcion(String tiaDescripcion) {
        this.tiaDescripcion = tiaDescripcion;
    }    

//    @XmlTransient
//    public Collection<OfeDedicacionTipoRol> getOfeDedicacionTipoRolCollection() {
//        return ofeDedicacionTipoRolCollection;
//    }
//
//    public void setOfeDedicacionTipoRolCollection(Collection<OfeDedicacionTipoRol> ofeDedicacionTipoRolCollection) {
//        this.ofeDedicacionTipoRolCollection = ofeDedicacionTipoRolCollection;
//    }

    @XmlTransient
    public Collection<OfeActividad> getOfeActividadCollection() {
        return ofeActividadCollection;
    }

    public void setOfeActividadCollection(Collection<OfeActividad> ofeActividadCollection) {
        this.ofeActividadCollection = ofeActividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiaCodigo != null ? tiaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfeTipoActividad)) {
            return false;
        }
        OfeTipoActividad other = (OfeTipoActividad) object;
        if ((this.tiaCodigo == null && other.tiaCodigo != null) || (this.tiaCodigo != null && !this.tiaCodigo.equals(other.tiaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfeTipoActividad[ tiaCodigo=" + tiaCodigo + " ]";
    }
    
}
