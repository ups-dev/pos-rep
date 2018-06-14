package ec.edu.ups.pos.rep.data.entities.ofe;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "OFE_ACTIVIDAD", catalog = "", schema = "OFE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"TIA_CODIGO", "ACT_ITEM"})})
@XmlRootElement
public class OfeActividad extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_CODIGO", nullable = false)
    private Long actCodigo;
    @Size(max = 500)
    @Column(name = "ACT_DESCRIPCION", length = 500)
    private String actDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_ITEM", nullable = false, precision = 10, scale = 2)
    private BigDecimal actItem;    
//    @OneToMany(mappedBy = "actCodigo", fetch = FetchType.LAZY)
//    private Collection<OfeDedicacionTipoRol> ofeDedicacionTipoRolCollection;
    @OneToMany(mappedBy = "ofeActividadPadre", fetch = FetchType.LAZY)
    private Collection<OfeActividad> ofeActividadCollection;
    @JoinColumn(name = "ACT_PADRE", referencedColumnName = "ACT_CODIGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private OfeActividad ofeActividadPadre;
    @JoinColumn(name = "TIA_CODIGO", referencedColumnName = "TIA_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OfeTipoActividad ofeTipoActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofeActividad", fetch = FetchType.LAZY)
    private Collection<OfeDistributivo> ofeDistributivoCollection;

    public OfeActividad() {
    }

    public OfeActividad(Long actCodigo) {
        this.actCodigo = actCodigo;
    }

    public OfeActividad(Long actCodigo, BigDecimal actItem) {
        this.actCodigo = actCodigo;
        this.actItem = actItem;        
    }

    public Long getActCodigo() {
        return actCodigo;
    }

    public void setActCodigo(Long actCodigo) {
        this.actCodigo = actCodigo;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public BigDecimal getActItem() {
        return actItem;
    }

    public void setActItem(BigDecimal actItem) {
        this.actItem = actItem;
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

    public OfeActividad getOfeActividadPadre() {
        return ofeActividadPadre;
    }

    public void setOfeActividadPadre(OfeActividad ofeActividadPadre) {
        this.ofeActividadPadre = ofeActividadPadre;
    }

    public OfeTipoActividad getOfeTipoActividad() {
        return ofeTipoActividad;
    }

    public void setOfeTipoActividad(OfeTipoActividad ofeTipoActividad) {
        this.ofeTipoActividad = ofeTipoActividad;
    }    

    @XmlTransient
    public Collection<OfeDistributivo> getOfeDistributivoCollection() {
        return ofeDistributivoCollection;
    }

    public void setOfeDistributivoCollection(Collection<OfeDistributivo> ofeDistributivoCollection) {
        this.ofeDistributivoCollection = ofeDistributivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actCodigo != null ? actCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfeActividad)) {
            return false;
        }
        OfeActividad other = (OfeActividad) object;
        if ((this.actCodigo == null && other.actCodigo != null) || (this.actCodigo != null && !this.actCodigo.equals(other.actCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfeActividad[ actCodigo=" + actCodigo + " ]";
    }
    
}
