package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_EQUIVALENCIA_DETALLE", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEquivalenciaDetalle extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQD_CODIGO", nullable = false)
    private Long eqdCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EQD_DESCRIPCION", nullable = false, length = 100)
    private String eqdDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQD_LIMITE_INFERIOR", nullable = false, precision = 5, scale = 2)
    private BigDecimal eqdLimiteInferior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EQD_LIMITE_SUPERIOR", nullable = false, precision = 5, scale = 2)
    private BigDecimal eqdLimiteSuperior;    
    @JoinColumn(name = "EQU_CODIGO", referencedColumnName = "EQU_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEquivalencia evaEquivalencia;

    public EvaEquivalenciaDetalle() {
    }

    public EvaEquivalenciaDetalle(Long eqdCodigo) {
        this.eqdCodigo = eqdCodigo;
    }

    public EvaEquivalenciaDetalle(Long eqdCodigo, String eqdDescripcion, BigDecimal eqdLimiteInferior, BigDecimal eqdLimiteSuperior) {
        this.eqdCodigo = eqdCodigo;
        this.eqdDescripcion = eqdDescripcion;
        this.eqdLimiteInferior = eqdLimiteInferior;
        this.eqdLimiteSuperior = eqdLimiteSuperior;        
    }

    public Long getEqdCodigo() {
        return eqdCodigo;
    }

    public void setEqdCodigo(Long eqdCodigo) {
        this.eqdCodigo = eqdCodigo;
    }

    public String getEqdDescripcion() {
        return eqdDescripcion;
    }

    public void setEqdDescripcion(String eqdDescripcion) {
        this.eqdDescripcion = eqdDescripcion;
    }

    public BigDecimal getEqdLimiteInferior() {
        return eqdLimiteInferior;
    }

    public void setEqdLimiteInferior(BigDecimal eqdLimiteInferior) {
        this.eqdLimiteInferior = eqdLimiteInferior;
    }

    public BigDecimal getEqdLimiteSuperior() {
        return eqdLimiteSuperior;
    }

    public void setEqdLimiteSuperior(BigDecimal eqdLimiteSuperior) {
        this.eqdLimiteSuperior = eqdLimiteSuperior;
    }    

    public EvaEquivalencia getEvaEquivalencia() {
        return evaEquivalencia;
    }

    public void setEvaEquivalencia(EvaEquivalencia evaEquivalencia) {
        this.evaEquivalencia = evaEquivalencia;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqdCodigo != null ? eqdCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEquivalenciaDetalle)) {
            return false;
        }
        EvaEquivalenciaDetalle other = (EvaEquivalenciaDetalle) object;
        if ((this.eqdCodigo == null && other.eqdCodigo != null) || (this.eqdCodigo != null && !this.eqdCodigo.equals(other.eqdCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEquivalenciaDetalle[ eqdCodigo=" + eqdCodigo + " ]";
    }
    
}
