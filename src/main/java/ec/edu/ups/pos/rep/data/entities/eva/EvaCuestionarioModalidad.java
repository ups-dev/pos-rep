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
@Table(name = "EVA_CUESTIONARIO_MODALIDAD", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaCuestionarioModalidad extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUM_CODIGO", nullable = false)
    private Long cumCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_CODIGO", nullable = false)
    private Long modCodigo;    
    @Column(name = "CUV_CODIGO_LEG")
    private Long cuvCodigoLeg;
    @JoinColumn(name = "CUE_CODIGO", referencedColumnName = "CUE_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaCuestionario evaCuestionario;

    public EvaCuestionarioModalidad() {
    }

    public EvaCuestionarioModalidad(Long cumCodigo) {
        this.cumCodigo = cumCodigo;
    }

    public EvaCuestionarioModalidad(Long cumCodigo, Long modCodigo) {
        this.cumCodigo = cumCodigo;
        this.modCodigo = modCodigo;        
    }

    public Long getCumCodigo() {
        return cumCodigo;
    }

    public void setCumCodigo(Long cumCodigo) {
        this.cumCodigo = cumCodigo;
    }

    public Long getModCodigo() {
        return modCodigo;
    }

    public void setModCodigo(Long modCodigo) {
        this.modCodigo = modCodigo;
    }    

    public Long getCuvCodigoLeg() {
        return cuvCodigoLeg;
    }

    public void setCuvCodigoLeg(Long cuvCodigoLeg) {
        this.cuvCodigoLeg = cuvCodigoLeg;
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
        hash += (cumCodigo != null ? cumCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaCuestionarioModalidad)) {
            return false;
        }
        EvaCuestionarioModalidad other = (EvaCuestionarioModalidad) object;
        if ((this.cumCodigo == null && other.cumCodigo != null) || (this.cumCodigo != null && !this.cumCodigo.equals(other.cumCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaCuestionarioModalidad[ cumCodigo=" + cumCodigo + " ]";
    }
    
}
