package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_ENCABEZADO_RESPUESTA", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaEncabezadoRespuesta extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENR_CODIGO", nullable = false)
    private Long enrCodigo;
    @Column(name = "MAL_CODIGO")
    private Long malCodigo;
    @Column(name = "GRU_CODIGO")
    private Long gruCodigo;
    @Column(name = "ALU_CODIGO_INF")
    private Long aluCodigoInf;
    @Column(name = "PER_CODIGO_INF")
    private Long perCodigoInf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CODIGO_EVA", nullable = false)
    private Long perCodigoEva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENR_FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date enrFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENR_PUNTUACION_TOTAL", nullable = false, precision = 5, scale = 2)
    private BigDecimal enrPuntuacionTotal;    
    @Size(max = 200)
    @Column(name = "ENR_OBSERVACION_MIG", length = 200)
    private String enrObservacionMig;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaEncabezadoRespuesta", fetch = FetchType.LAZY)
    private Collection<EvaDetalleRespuesta> evaDetalleRespuestaCollection;
    @JoinColumn(name = "ECI_CODIGO", referencedColumnName = "ECI_CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaEvaCueInf evaEvaCueInf;

    public EvaEncabezadoRespuesta() {
    }

    public EvaEncabezadoRespuesta(Long enrCodigo) {
        this.enrCodigo = enrCodigo;
    }

    public EvaEncabezadoRespuesta(Long enrCodigo, Long perCodigoEva, Date enrFecha, BigDecimal enrPuntuacionTotal) {
        this.enrCodigo = enrCodigo;
        this.perCodigoEva = perCodigoEva;
        this.enrFecha = enrFecha;
        this.enrPuntuacionTotal = enrPuntuacionTotal;        
    }

    public Long getEnrCodigo() {
        return enrCodigo;
    }

    public void setEnrCodigo(Long enrCodigo) {
        this.enrCodigo = enrCodigo;
    }

    public Long getMalCodigo() {
        return malCodigo;
    }

    public void setMalCodigo(Long malCodigo) {
        this.malCodigo = malCodigo;
    }

    public Long getGruCodigo() {
        return gruCodigo;
    }

    public void setGruCodigo(Long gruCodigo) {
        this.gruCodigo = gruCodigo;
    }

    public Long getAluCodigoInf() {
        return aluCodigoInf;
    }

    public void setAluCodigoInf(Long aluCodigoInf) {
        this.aluCodigoInf = aluCodigoInf;
    }

    public Long getPerCodigoInf() {
        return perCodigoInf;
    }

    public void setPerCodigoInf(Long perCodigoInf) {
        this.perCodigoInf = perCodigoInf;
    }

    public Long getPerCodigoEva() {
        return perCodigoEva;
    }

    public void setPerCodigoEva(Long perCodigoEva) {
        this.perCodigoEva = perCodigoEva;
    }

    public Date getEnrFecha() {
        return enrFecha;
    }

    public void setEnrFecha(Date enrFecha) {
        this.enrFecha = enrFecha;
    }

    public BigDecimal getEnrPuntuacionTotal() {
        return enrPuntuacionTotal;
    }

    public void setEnrPuntuacionTotal(BigDecimal enrPuntuacionTotal) {
        this.enrPuntuacionTotal = enrPuntuacionTotal;
    }    

    public String getEnrObservacionMig() {
        return enrObservacionMig;
    }

    public void setEnrObservacionMig(String enrObservacionMig) {
        this.enrObservacionMig = enrObservacionMig;
    }

    @XmlTransient
    public Collection<EvaDetalleRespuesta> getEvaDetalleRespuestaCollection() {
        return evaDetalleRespuestaCollection;
    }

    public void setEvaDetalleRespuestaCollection(Collection<EvaDetalleRespuesta> evaDetalleRespuestaCollection) {
        this.evaDetalleRespuestaCollection = evaDetalleRespuestaCollection;
    }

    public EvaEvaCueInf getEvaEvaCueInf() {
        return evaEvaCueInf;
    }

    public void setEvaEvaCueInf(EvaEvaCueInf evaEvaCueInf) {
        this.evaEvaCueInf = evaEvaCueInf;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enrCodigo != null ? enrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaEncabezadoRespuesta)) {
            return false;
        }
        EvaEncabezadoRespuesta other = (EvaEncabezadoRespuesta) object;
        if ((this.enrCodigo == null && other.enrCodigo != null) || (this.enrCodigo != null && !this.enrCodigo.equals(other.enrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaEncabezadoRespuesta[ enrCodigo=" + enrCodigo + " ]";
    }
    
}
