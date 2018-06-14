package ec.edu.ups.pos.rep.data.entities.eva;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_CLASIFICACION_CUESTIONARIO", catalog = "", schema = "EVA", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CUE_CODIGO", "CLA_CODIGO"})})
@XmlRootElement
public class EvaClasificacionCuestionario extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLC_CODIGO", nullable = false)
    private Long clcCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLC_PONDERACION", nullable = false, precision = 5, scale = 2)
    private BigDecimal clcPonderacion;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaClasificacionCuestionario", fetch = FetchType.LAZY)
    private Collection<EvaClasificacionPregunta> evaClasificacionPreguntaCollection;
    @JoinColumn(name = "CLA_CODIGO", referencedColumnName = "CLA_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaClasificacion evaClasificacion;
    @JoinColumn(name = "CUE_CODIGO", referencedColumnName = "CUE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaCuestionario evaCuestionario;

    public EvaClasificacionCuestionario() {
    }

    public EvaClasificacionCuestionario(Long clcCodigo) {
        this.clcCodigo = clcCodigo;
    }

    public EvaClasificacionCuestionario(Long clcCodigo, BigDecimal clcPonderacion) {
        this.clcCodigo = clcCodigo;
        this.clcPonderacion = clcPonderacion;        
    }

    public Long getClcCodigo() {
        return clcCodigo;
    }

    public void setClcCodigo(Long clcCodigo) {
        this.clcCodigo = clcCodigo;
    }

    public BigDecimal getClcPonderacion() {
        return clcPonderacion;
    }

    public void setClcPonderacion(BigDecimal clcPonderacion) {
        this.clcPonderacion = clcPonderacion;
    }    

    @XmlTransient
    public Collection<EvaClasificacionPregunta> getEvaClasificacionPreguntaCollection() {
        return evaClasificacionPreguntaCollection;
    }

    public void setEvaClasificacionPreguntaCollection(Collection<EvaClasificacionPregunta> evaClasificacionPreguntaCollection) {
        this.evaClasificacionPreguntaCollection = evaClasificacionPreguntaCollection;
    }

    public EvaClasificacion getEvaClasificacion() {
        return evaClasificacion;
    }

    public void setEvaClasificacion(EvaClasificacion evaClasificacion) {
        this.evaClasificacion = evaClasificacion;
    }

    public EvaCuestionario getEvaCuestionario() {
        return evaCuestionario;
    }

    public void setEvaCuestionario(EvaCuestionario evaCuestionario) {
        this.evaCuestionario = evaCuestionario;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clcCodigo != null ? clcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaClasificacionCuestionario)) {
            return false;
        }
        EvaClasificacionCuestionario other = (EvaClasificacionCuestionario) object;
        if ((this.clcCodigo == null && other.clcCodigo != null) || (this.clcCodigo != null && !this.clcCodigo.equals(other.clcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaClasificacionCuestionario[ clcCodigo=" + clcCodigo + " ]";
    }
    
}
