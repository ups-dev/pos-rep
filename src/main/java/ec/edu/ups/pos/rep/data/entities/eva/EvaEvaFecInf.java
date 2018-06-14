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
@Table(name = "EVA_EVA_FEC_INF", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEvaFecInf extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EFI_CODIGO", nullable = false)
    private Long efiCodigo;
    @Column(name = "PER_CODIGO")
    private Long perCodigo;
    @Column(name = "ALU_CODIGO")
    private Long aluCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EFI_FECHA_INICIAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efiFechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EFI_FECHA_FINAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date efiFechaFinal;    
    @JoinColumn(name = "EVA_CODIGO", referencedColumnName = "EVA_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEvaluacion evaEvaluacion;
    @JoinColumn(name = "TII_CODIGO", referencedColumnName = "TII_CODIGO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EvaTipoInformante evaTipoInformante;

    public EvaEvaFecInf() {
    }

    public EvaEvaFecInf(Long efiCodigo) {
        this.efiCodigo = efiCodigo;
    }

    public EvaEvaFecInf(Long efiCodigo, Date efiFechaInicial, Date efiFechaFinal) {
        this.efiCodigo = efiCodigo;
        this.efiFechaInicial = efiFechaInicial;
        this.efiFechaFinal = efiFechaFinal;        
    }

    public Long getEfiCodigo() {
        return efiCodigo;
    }

    public void setEfiCodigo(Long efiCodigo) {
        this.efiCodigo = efiCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Long getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public Date getEfiFechaInicial() {
        return efiFechaInicial;
    }

    public void setEfiFechaInicial(Date efiFechaInicial) {
        this.efiFechaInicial = efiFechaInicial;
    }

    public Date getEfiFechaFinal() {
        return efiFechaFinal;
    }

    public void setEfiFechaFinal(Date efiFechaFinal) {
        this.efiFechaFinal = efiFechaFinal;
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
        hash += (efiCodigo != null ? efiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEvaFecInf)) {
            return false;
        }
        EvaEvaFecInf other = (EvaEvaFecInf) object;
        if ((this.efiCodigo == null && other.efiCodigo != null) || (this.efiCodigo != null && !this.efiCodigo.equals(other.efiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEvaFecInf[ efiCodigo=" + efiCodigo + " ]";
    }
    
}
