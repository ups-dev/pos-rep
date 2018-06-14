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
@Table(name = "EVA_TIPO_INFORMANTE", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaTipoInformante extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TII_CODIGO", nullable = false)
    private Long tiiCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TII_DESCRIPCION", nullable = false, length = 100)
    private String tiiDescripcion;    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaTipoInformante", fetch = FetchType.LAZY)
    private Collection<EvaColTipInf> evaColTipInfCollection;
    @OneToMany(mappedBy = "evaTipoInformante", fetch = FetchType.LAZY)
    private Collection<EvaEvaFecInf> evaEvaFecInfCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaTipoInformanteInf", fetch = FetchType.LAZY)
    private Collection<EvaInfTipEva> evaInfTipEvaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaTipoInformanteEva", fetch = FetchType.LAZY)
    private Collection<EvaInfTipEva> evaInfTipEvaCollection1;

    public EvaTipoInformante() {
    }

    public EvaTipoInformante(Long tiiCodigo) {
        this.tiiCodigo = tiiCodigo;
    }

    public EvaTipoInformante(Long tiiCodigo, String tiiDescripcion) {
        this.tiiCodigo = tiiCodigo;
        this.tiiDescripcion = tiiDescripcion;        
    }

    public Long getTiiCodigo() {
        return tiiCodigo;
    }

    public void setTiiCodigo(Long tiiCodigo) {
        this.tiiCodigo = tiiCodigo;
    }

    public String getTiiDescripcion() {
        return tiiDescripcion;
    }

    public void setTiiDescripcion(String tiiDescripcion) {
        this.tiiDescripcion = tiiDescripcion;
    }    

    @XmlTransient
    public Collection<EvaColTipInf> getEvaColTipInfCollection() {
        return evaColTipInfCollection;
    }

    public void setEvaColTipInfCollection(Collection<EvaColTipInf> evaColTipInfCollection) {
        this.evaColTipInfCollection = evaColTipInfCollection;
    }

    @XmlTransient
    public Collection<EvaEvaFecInf> getEvaEvaFecInfCollection() {
        return evaEvaFecInfCollection;
    }

    public void setEvaEvaFecInfCollection(Collection<EvaEvaFecInf> evaEvaFecInfCollection) {
        this.evaEvaFecInfCollection = evaEvaFecInfCollection;
    }

    @XmlTransient
    public Collection<EvaInfTipEva> getEvaInfTipEvaCollection() {
        return evaInfTipEvaCollection;
    }

    public void setEvaInfTipEvaCollection(Collection<EvaInfTipEva> evaInfTipEvaCollection) {
        this.evaInfTipEvaCollection = evaInfTipEvaCollection;
    }

    @XmlTransient
    public Collection<EvaInfTipEva> getEvaInfTipEvaCollection1() {
        return evaInfTipEvaCollection1;
    }

    public void setEvaInfTipEvaCollection1(Collection<EvaInfTipEva> evaInfTipEvaCollection1) {
        this.evaInfTipEvaCollection1 = evaInfTipEvaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiiCodigo != null ? tiiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaTipoInformante)) {
            return false;
        }
        EvaTipoInformante other = (EvaTipoInformante) object;
        if ((this.tiiCodigo == null && other.tiiCodigo != null) || (this.tiiCodigo != null && !this.tiiCodigo.equals(other.tiiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaTipoInformante[ tiiCodigo=" + tiiCodigo + " ]";
    }
    
}
