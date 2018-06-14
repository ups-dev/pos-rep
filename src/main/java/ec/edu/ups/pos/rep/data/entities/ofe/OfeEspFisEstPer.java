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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "OFE_ESP_FIS_EST_PER", catalog = "", schema = "OFE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PEL_CODIGO", "EST_CODIGO", "ESF_CODIGO", "TPE_CODIGO"})})
@XmlRootElement
public class OfeEspFisEstPer extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EEP_CODIGO", nullable = false)
    private Long eepCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEL_CODIGO", nullable = false)
    private Long pelCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_CODIGO", nullable = false)
    private Long estCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESF_CODIGO", nullable = false)
    private Long esfCodigo;    
    @Column(name = "TPE_CODIGO")
    private Long tpeCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofeEspFisEstPer", fetch = FetchType.LAZY)
    private Collection<OfeHorario> ofeHorarioCollection;

    public OfeEspFisEstPer() {
    }

    public OfeEspFisEstPer(Long eepCodigo) {
        this.eepCodigo = eepCodigo;
    }

    public OfeEspFisEstPer(Long eepCodigo, Long pelCodigo, Long estCodigo, Long esfCodigo) {
        this.eepCodigo = eepCodigo;
        this.pelCodigo = pelCodigo;
        this.estCodigo = estCodigo;
        this.esfCodigo = esfCodigo;        
    }

    public Long getEepCodigo() {
        return eepCodigo;
    }

    public void setEepCodigo(Long eepCodigo) {
        this.eepCodigo = eepCodigo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getEsfCodigo() {
        return esfCodigo;
    }

    public void setEsfCodigo(Long esfCodigo) {
        this.esfCodigo = esfCodigo;
    }    

    public Long getTpeCodigo() {
        return tpeCodigo;
    }

    public void setTpeCodigo(Long tpeCodigo) {
        this.tpeCodigo = tpeCodigo;
    }

    @XmlTransient
    public Collection<OfeHorario> getOfeHorarioCollection() {
        return ofeHorarioCollection;
    }

    public void setOfeHorarioCollection(Collection<OfeHorario> ofeHorarioCollection) {
        this.ofeHorarioCollection = ofeHorarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eepCodigo != null ? eepCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfeEspFisEstPer)) {
            return false;
        }
        OfeEspFisEstPer other = (OfeEspFisEstPer) object;
        if ((this.eepCodigo == null && other.eepCodigo != null) || (this.eepCodigo != null && !this.eepCodigo.equals(other.eepCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfeEspFisEstPer[ eepCodigo=" + eepCodigo + " ]";
    }
    
}
