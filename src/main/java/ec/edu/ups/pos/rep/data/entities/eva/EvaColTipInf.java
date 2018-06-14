package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_COL_TIP_INF", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaColTipInf extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTI_CODIGO", nullable = false)
    private Long ctiCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGO", nullable = false)
    private Long perCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_CODIGO", nullable = false)
    private Long estCodigo;
    @Column(name = "APE_CODIGO")
    private Long apeCodigo;    
    @JoinColumn(name = "EVA_CODIGO", referencedColumnName = "EVA_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEvaluacion evaEvaluacion;
    @JoinColumn(name = "TII_CODIGO", referencedColumnName = "TII_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaTipoInformante evaTipoInformante;

    public EvaColTipInf() {
    }

    public EvaColTipInf(Long ctiCodigo) {
        this.ctiCodigo = ctiCodigo;
    }

    public EvaColTipInf(Long ctiCodigo, Long perCodigo, Long estCodigo) {
        this.ctiCodigo = ctiCodigo;
        this.perCodigo = perCodigo;
        this.estCodigo = estCodigo;        
    }

    public Long getCtiCodigo() {
        return ctiCodigo;
    }

    public void setCtiCodigo(Long ctiCodigo) {
        this.ctiCodigo = ctiCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getApeCodigo() {
        return apeCodigo;
    }

    public void setApeCodigo(Long apeCodigo) {
        this.apeCodigo = apeCodigo;
    }     

    public EvaEvaluacion getEvaEvaluacion() {
        return evaEvaluacion;
    }

    public void setEvaEvaluacion(EvaEvaluacion evaEvaluacion) {
        this.evaEvaluacion = evaEvaluacion;
    }

    public EvaTipoInformante getEvaTipoInformante() {
        return evaTipoInformante;
    }

    public void setEvaTipoInformante(EvaTipoInformante evaTipoInformante) {
        this.evaTipoInformante = evaTipoInformante;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctiCodigo != null ? ctiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaColTipInf)) {
            return false;
        }
        EvaColTipInf other = (EvaColTipInf) object;
        if ((this.ctiCodigo == null && other.ctiCodigo != null) || (this.ctiCodigo != null && !this.ctiCodigo.equals(other.ctiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaColTipInf[ ctiCodigo=" + ctiCodigo + " ]";
    }
    
}
