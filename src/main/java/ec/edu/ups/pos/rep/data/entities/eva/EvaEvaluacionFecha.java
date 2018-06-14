package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_EVALUACION_FECHA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEvaluacionFecha extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVF_CODIGO", nullable = false)
    private Long evfCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_CODIGO", nullable = false)
    private Long estCodigo;
    @Column(name = "PEL_CODIGO")
    private Long pelCodigo;
    @Column(name = "MOD_CODIGO")
    private Long modCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVF_FECHA_INICIAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date evfFechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVF_FECHA_FINAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date evfFechaFinal;    
    @JoinColumn(name = "AMB_CODIGO", referencedColumnName = "AMB_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaAmbito evaAmbito;
    @JoinColumn(name = "EVA_CODIGO", referencedColumnName = "EVA_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEvaluacion evaEvaluacion;

    public EvaEvaluacionFecha() {
    }

    public EvaEvaluacionFecha(Long evfCodigo) {
        this.evfCodigo = evfCodigo;
    }

    public EvaEvaluacionFecha(Long evfCodigo, Long estCodigo, Date evfFechaInicial, Date evfFechaFinal) {
        this.evfCodigo = evfCodigo;
        this.estCodigo = estCodigo;
        this.evfFechaInicial = evfFechaInicial;
        this.evfFechaFinal = evfFechaFinal;        
    }

    public Long getEvfCodigo() {
        return evfCodigo;
    }

    public void setEvfCodigo(Long evfCodigo) {
        this.evfCodigo = evfCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public Long getModCodigo() {
        return modCodigo;
    }

    public void setModCodigo(Long modCodigo) {
        this.modCodigo = modCodigo;
    }

    public Date getEvfFechaInicial() {
        return evfFechaInicial;
    }

    public void setEvfFechaInicial(Date evfFechaInicial) {
        this.evfFechaInicial = evfFechaInicial;
    }

    public Date getEvfFechaFinal() {
        return evfFechaFinal;
    }

    public void setEvfFechaFinal(Date evfFechaFinal) {
        this.evfFechaFinal = evfFechaFinal;
    }    

    public EvaAmbito getEvaAmbito() {
        return evaAmbito;
    }

    public void setEvaAmbito(EvaAmbito evaAmbito) {
        this.evaAmbito = evaAmbito;
    }

    public EvaEvaluacion getEvaEvaluacion() {
        return evaEvaluacion;
    }

    public void setEvaEvaluacion(EvaEvaluacion evaEvaluacion) {
        this.evaEvaluacion = evaEvaluacion;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evfCodigo != null ? evfCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEvaluacionFecha)) {
            return false;
        }
        EvaEvaluacionFecha other = (EvaEvaluacionFecha) object;
        if ((this.evfCodigo == null && other.evfCodigo != null) || (this.evfCodigo != null && !this.evfCodigo.equals(other.evfCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEvaluacionFecha[ evfCodigo=" + evfCodigo + " ]";
    }
    
}
