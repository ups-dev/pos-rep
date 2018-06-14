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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_INF_TIP_EVA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaInfTipEva extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITE_CODIGO", nullable = false)
    private Long iteCodigo;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaInfTipEva", fetch = FetchType.LAZY)
    private Collection<EvaEvaCueInf> evaEvaCueInfCollection;
    @JoinColumn(name = "TIE_CODIGO", referencedColumnName = "TIE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaTipoEvaluacion evaTipoEvaluacion;
    @JoinColumn(name = "TII_CODIGO_INF", referencedColumnName = "TII_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaTipoInformante evaTipoInformanteInf;
    @JoinColumn(name = "TII_CODIGO_EVA", referencedColumnName = "TII_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaTipoInformante evaTipoInformanteEva;

    public EvaInfTipEva() {
    }

    public EvaInfTipEva(Long iteCodigo) {
        this.iteCodigo = iteCodigo;
    }    

    public Long getIteCodigo() {
        return iteCodigo;
    }

    public void setIteCodigo(Long iteCodigo) {
        this.iteCodigo = iteCodigo;
    }    

    @XmlTransient
    public Collection<EvaEvaCueInf> getEvaEvaCueInfCollection() {
        return evaEvaCueInfCollection;
    }

    public void setEvaEvaCueInfCollection(Collection<EvaEvaCueInf> evaEvaCueInfCollection) {
        this.evaEvaCueInfCollection = evaEvaCueInfCollection;
    }

    public EvaTipoEvaluacion getEvaTipoEvaluacion() {
        return evaTipoEvaluacion;
    }

    public void setEvaTipoEvaluacion(EvaTipoEvaluacion evaTipoEvaluacion) {
        this.evaTipoEvaluacion = evaTipoEvaluacion;
    }

    public EvaTipoInformante getEvaTipoInformanteInf() {
        return evaTipoInformanteInf;
    }

    public void setEvaTipoInformanteInf(EvaTipoInformante evaTipoInformanteInf) {
        this.evaTipoInformanteInf = evaTipoInformanteInf;
    }

    public EvaTipoInformante getEvaTipoInformanteEva() {
        return evaTipoInformanteEva;
    }

    public void setEvaTipoInformanteEva(EvaTipoInformante evaTipoInformanteEva) {
        this.evaTipoInformanteEva = evaTipoInformanteEva;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iteCodigo != null ? iteCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaInfTipEva)) {
            return false;
        }
        EvaInfTipEva other = (EvaInfTipEva) object;
        if ((this.iteCodigo == null && other.iteCodigo != null) || (this.iteCodigo != null && !this.iteCodigo.equals(other.iteCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaInfTipEva[ iteCodigo=" + iteCodigo + " ]";
    }
    
}
