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
@Table(name = "EVA_CUESTIONARIO", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaCuestionario extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUE_CODIGO", nullable = false)
    private Long cueCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CUE_DESCRIPCION", nullable = false, length = 200)
    private String cueDescripcion;
    @Size(max = 500)
    @Column(name = "CUE_INSTRUCCIONES", length = 500)
    private String cueInstrucciones;
    @Size(max = 100)
    @Column(name = "CUE_NUMERO_RESOLUCION", length = 100)
    private String cueNumeroResolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CUE_ESTADO", nullable = false, length = 1)
    private String cueEstado;    
    @Column(name = "CUE_CODIGO_LEG")
    private Long cueCodigoLeg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaCuestionario", fetch = FetchType.LAZY)
    private Collection<EvaEvaluacionCuestionario> evaEvaluacionCuestionarioCollection;
    @JoinColumn(name = "AMB_CODIGO", referencedColumnName = "AMB_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaAmbito evaAmbito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaCuestionario", fetch = FetchType.LAZY)
    private Collection<EvaCuestionarioModalidad> evaCuestionarioModalidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaCuestionario", fetch = FetchType.LAZY)
    private Collection<EvaPregunta> evaPreguntaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaCuestionario", fetch = FetchType.LAZY)
    private Collection<EvaClasificacionCuestionario> evaClasificacionCuestionarioCollection;

    public EvaCuestionario() {
    }

    public EvaCuestionario(Long cueCodigo) {
        this.cueCodigo = cueCodigo;
    }

    public EvaCuestionario(Long cueCodigo, String cueDescripcion, String cueEstado) {
        this.cueCodigo = cueCodigo;
        this.cueDescripcion = cueDescripcion;
        this.cueEstado = cueEstado;        
    }

    public Long getCueCodigo() {
        return cueCodigo;
    }

    public void setCueCodigo(Long cueCodigo) {
        this.cueCodigo = cueCodigo;
    }

    public String getCueDescripcion() {
        return cueDescripcion;
    }

    public void setCueDescripcion(String cueDescripcion) {
        this.cueDescripcion = cueDescripcion;
    }

    public String getCueInstrucciones() {
        return cueInstrucciones;
    }

    public void setCueInstrucciones(String cueInstrucciones) {
        this.cueInstrucciones = cueInstrucciones;
    }

    public String getCueNumeroResolucion() {
        return cueNumeroResolucion;
    }

    public void setCueNumeroResolucion(String cueNumeroResolucion) {
        this.cueNumeroResolucion = cueNumeroResolucion;
    }

    public String getCueEstado() {
        return cueEstado;
    }

    public void setCueEstado(String cueEstado) {
        this.cueEstado = cueEstado;
    }    

    public Long getCueCodigoLeg() {
        return cueCodigoLeg;
    }

    public void setCueCodigoLeg(Long cueCodigoLeg) {
        this.cueCodigoLeg = cueCodigoLeg;
    }

    @XmlTransient
    public Collection<EvaEvaluacionCuestionario> getEvaEvaluacionCuestionarioCollection() {
        return evaEvaluacionCuestionarioCollection;
    }

    public void setEvaEvaluacionCuestionarioCollection(Collection<EvaEvaluacionCuestionario> evaEvaluacionCuestionarioCollection) {
        this.evaEvaluacionCuestionarioCollection = evaEvaluacionCuestionarioCollection;
    }

    public EvaAmbito getEvaAmbito() {
        return evaAmbito;
    }

    public void setEvaAmbito(EvaAmbito evaAmbito) {
        this.evaAmbito = evaAmbito;
    }    

    @XmlTransient
    public Collection<EvaCuestionarioModalidad> getEvaCuestionarioModalidadCollection() {
        return evaCuestionarioModalidadCollection;
    }

    public void setEvaCuestionarioModalidadCollection(Collection<EvaCuestionarioModalidad> evaCuestionarioModalidadCollection) {
        this.evaCuestionarioModalidadCollection = evaCuestionarioModalidadCollection;
    }

    @XmlTransient
    public Collection<EvaPregunta> getEvaPreguntaCollection() {
        return evaPreguntaCollection;
    }

    public void setEvaPreguntaCollection(Collection<EvaPregunta> evaPreguntaCollection) {
        this.evaPreguntaCollection = evaPreguntaCollection;
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
        hash += (cueCodigo != null ? cueCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaCuestionario)) {
            return false;
        }
        EvaCuestionario other = (EvaCuestionario) object;
        if ((this.cueCodigo == null && other.cueCodigo != null) || (this.cueCodigo != null && !this.cueCodigo.equals(other.cueCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaCuestionario[ cueCodigo=" + cueCodigo + " ]";
    }
    
}
