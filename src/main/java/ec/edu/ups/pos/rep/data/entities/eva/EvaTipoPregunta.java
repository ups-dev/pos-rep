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
@Table(name = "EVA_TIPO_PREGUNTA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaTipoPregunta extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIP_CODIGO", nullable = false)
    private Long tipCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIP_DESCRIPCION", nullable = false, length = 100)
    private String tipDescripcion;    
    @Column(name = "TIR_CODIGO_LEG")
    private Long tirCodigoLeg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaTipoPregunta", fetch = FetchType.LAZY)
    private Collection<EvaPregunta> evaPreguntaCollection;

    public EvaTipoPregunta() {
    }

    public EvaTipoPregunta(Long tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public EvaTipoPregunta(Long tipCodigo, String tipDescripcion) {
        this.tipCodigo = tipCodigo;
        this.tipDescripcion = tipDescripcion;        
    }

    public Long getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(Long tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipDescripcion() {
        return tipDescripcion;
    }

    public void setTipDescripcion(String tipDescripcion) {
        this.tipDescripcion = tipDescripcion;
    }    

    public Long getTirCodigoLeg() {
        return tirCodigoLeg;
    }

    public void setTirCodigoLeg(Long tirCodigoLeg) {
        this.tirCodigoLeg = tirCodigoLeg;
    }

    @XmlTransient
    public Collection<EvaPregunta> getEvaPreguntaCollection() {
        return evaPreguntaCollection;
    }

    public void setEvaPreguntaCollection(Collection<EvaPregunta> evaPreguntaCollection) {
        this.evaPreguntaCollection = evaPreguntaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaTipoPregunta)) {
            return false;
        }
        EvaTipoPregunta other = (EvaTipoPregunta) object;
        if ((this.tipCodigo == null && other.tipCodigo != null) || (this.tipCodigo != null && !this.tipCodigo.equals(other.tipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaTipoPregunta[ tipCodigo=" + tipCodigo + " ]";
    }
    
}
