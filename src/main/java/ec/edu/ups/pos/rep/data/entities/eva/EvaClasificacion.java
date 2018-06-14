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
@Table(name = "EVA_CLASIFICACION", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaClasificacion extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLA_CODIGO", nullable = false)
    private Long claCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CLA_DESCRIPCION", nullable = false, length = 100)
    private String claDescripcion;
    @Size(max = 500)
    @Column(name = "CLA_OBSERVACION", length = 500)
    private String claObservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLA_ORDEN", nullable = false)
    private Short claOrden;    
    @Column(name = "CODIGO_LEG")
    private Long codigoLeg;
    @OneToMany(mappedBy = "evaClasificacionPadre", fetch = FetchType.LAZY)
    private Collection<EvaClasificacion> evaClasificacionCollection;
    @JoinColumn(name = "CLA_CODIGO_PADRE", referencedColumnName = "CLA_CODIGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EvaClasificacion evaClasificacionPadre;
    @JoinColumn(name = "TIC_CODIGO", referencedColumnName = "TIC_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaTipoClasificacion evaTipoClasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaClasificacion", fetch = FetchType.LAZY)
    private Collection<EvaClasificacionCuestionario> evaClasificacionCuestionarioCollection;

    public EvaClasificacion() {
    }

    public EvaClasificacion(Long claCodigo) {
        this.claCodigo = claCodigo;
    }

    public EvaClasificacion(Long claCodigo, String claDescripcion, Short claOrden) {
        this.claCodigo = claCodigo;
        this.claDescripcion = claDescripcion;
        this.claOrden = claOrden;        
    }

    public Long getClaCodigo() {
        return claCodigo;
    }

    public void setClaCodigo(Long claCodigo) {
        this.claCodigo = claCodigo;
    }

    public String getClaDescripcion() {
        return claDescripcion;
    }

    public void setClaDescripcion(String claDescripcion) {
        this.claDescripcion = claDescripcion;
    }

    public String getClaObservacion() {
        return claObservacion;
    }

    public void setClaObservacion(String claObservacion) {
        this.claObservacion = claObservacion;
    }

    public Short getClaOrden() {
        return claOrden;
    }

    public void setClaOrden(Short claOrden) {
        this.claOrden = claOrden;
    }    

    public Long getCodigoLeg() {
        return codigoLeg;
    }

    public void setCodigoLeg(Long codigoLeg) {
        this.codigoLeg = codigoLeg;
    }

    @XmlTransient
    public Collection<EvaClasificacion> getEvaClasificacionCollection() {
        return evaClasificacionCollection;
    }

    public void setEvaClasificacionCollection(Collection<EvaClasificacion> evaClasificacionCollection) {
        this.evaClasificacionCollection = evaClasificacionCollection;
    }

    public EvaClasificacion getEvaClasificacionPadre() {
        return evaClasificacionPadre;
    }

    public void setEvaClasificacionPadre(EvaClasificacion evaClasificacionPadre) {
        this.evaClasificacionPadre = evaClasificacionPadre;
    }

    public EvaTipoClasificacion getEvaTipoClasificacion() {
        return evaTipoClasificacion;
    }

    public void setEvaTipoClasificacion(EvaTipoClasificacion evaTipoClasificacion) {
        this.evaTipoClasificacion = evaTipoClasificacion;
    }    

    @XmlTransient
    public Collection<EvaClasificacionCuestionario> getEvaClasificacionCuestionarioCollection() {
        return evaClasificacionCuestionarioCollection;
    }

    public void setEvaClasificacionCuestionarioCollection(Collection<EvaClasificacionCuestionario> evaClasificacionCuestionarioCollection) {
        this.evaClasificacionCuestionarioCollection = evaClasificacionCuestionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claCodigo != null ? claCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaClasificacion)) {
            return false;
        }
        EvaClasificacion other = (EvaClasificacion) object;
        if ((this.claCodigo == null && other.claCodigo != null) || (this.claCodigo != null && !this.claCodigo.equals(other.claCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaClasificacion[ claCodigo=" + claCodigo + " ]";
    }
    
}
