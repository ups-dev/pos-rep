package ec.edu.ups.pos.rep.data.entities.ofe;

import ec.edu.ups.util.jpa.EntitySuperclass;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "OFE_GRUPO", catalog = "", schema = "OFE")
@XmlRootElement
public class OfeGrupo extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRU_CODIGO", nullable = false)
    private Long gruCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAL_CODIGO", nullable = false)
    private Long malCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEL_CODIGO", nullable = false)
    private Long pelCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMP_CODIGO", nullable = false)
    private Long empCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRU_ITEM", nullable = false)
    private Long gruItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GRU_DESCRIPCION", nullable = false, length = 100)
    private String gruDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRU_CUPOS", nullable = false)
    private Integer gruCupos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRU_CUPOS_INTERNET", nullable = false)
    private Integer gruCuposInternet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GRU_ABIERTO", nullable = false, length = 1)
    private String gruAbierto;
    @Column(name = "GRU_CUPOS_UTILIZADOS")
    private Integer gruCuposUtilizados;
    @Column(name = "GRU_CUPOS_UTILIZADOS_INTERNET")
    private Integer gruCuposUtilizadosInternet;    
    @Column(name = "GRU_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gruFechaInicio;
    @Column(name = "GRU_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gruFechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GRU_MODALIDAD_EVALUACION", nullable = false, length = 1)
    private String gruModalidadEvaluacion;
    @Size(max = 1)
    @Column(name = "GRU_AUTORIZADO", length = 1)
    private String gruAutorizado;
    @Size(max = 1)
    @Column(name = "GRU_PLANIFICADO", length = 1)
    private String gruPlanificado;
    @Column(name = "EST_CODIGO_EVA")
    private Long estCodigoEva;
    @Column(name = "GRU_OFG_NUMERO_LEG")
    private Long gruOfgNumeroLeg;
    @Size(max = 1)
    @Column(name = "OFG_TIPO_LEG", length = 1)
    private String ofgTipoLeg;
    @Size(max = 1)
    @Column(name = "OFG_TIENE_HORARIO_LEG", length = 1)
    private String ofgTieneHorarioLeg;
    @Size(max = 1)
    @Column(name = "GRU_JORNADA", length = 1)
    private String gruJornada;
    @Column(name = "PEE_CODIGO")
    private Long peeCodigo;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gruCodigo", fetch = FetchType.LAZY)
//    private Collection<OfeDocumentoPortafolio> ofeDocumentoPortafolioCollection;
    @OneToMany(mappedBy = "ofeGrupo", fetch = FetchType.LAZY)
    private Collection<OfeDistributivo> ofeDistributivoCollection;

    public OfeGrupo() {
    }

    public OfeGrupo(Long gruCodigo) {
        this.gruCodigo = gruCodigo;
    }

    public OfeGrupo(Long gruCodigo, Long malCodigo, Long pelCodigo, Long empCodigo, Long gruItem, String gruDescripcion, Integer gruCupos, Integer gruCuposInternet, String gruAbierto, String gruModalidadEvaluacion) {
        this.gruCodigo = gruCodigo;
        this.malCodigo = malCodigo;
        this.pelCodigo = pelCodigo;
        this.empCodigo = empCodigo;
        this.gruItem = gruItem;
        this.gruDescripcion = gruDescripcion;
        this.gruCupos = gruCupos;
        this.gruCuposInternet = gruCuposInternet;
        this.gruAbierto = gruAbierto;        
        this.gruModalidadEvaluacion = gruModalidadEvaluacion;
    }

    public Long getGruCodigo() {
        return gruCodigo;
    }

    public void setGruCodigo(Long gruCodigo) {
        this.gruCodigo = gruCodigo;
    }

    public Long getMalCodigo() {
        return malCodigo;
    }

    public void setMalCodigo(Long malCodigo) {
        this.malCodigo = malCodigo;
    }

    public Long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(Long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public Long getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(Long empCodigo) {
        this.empCodigo = empCodigo;
    }

    public Long getGruItem() {
        return gruItem;
    }

    public void setGruItem(Long gruItem) {
        this.gruItem = gruItem;
    }

    public String getGruDescripcion() {
        return gruDescripcion;
    }

    public void setGruDescripcion(String gruDescripcion) {
        this.gruDescripcion = gruDescripcion;
    }

    public Integer getGruCupos() {
        return gruCupos;
    }

    public void setGruCupos(Integer gruCupos) {
        this.gruCupos = gruCupos;
    }

    public Integer getGruCuposInternet() {
        return gruCuposInternet;
    }

    public void setGruCuposInternet(Integer gruCuposInternet) {
        this.gruCuposInternet = gruCuposInternet;
    }

    public String getGruAbierto() {
        return gruAbierto;
    }

    public void setGruAbierto(String gruAbierto) {
        this.gruAbierto = gruAbierto;
    }

    public Integer getGruCuposUtilizados() {
        return gruCuposUtilizados;
    }

    public void setGruCuposUtilizados(Integer gruCuposUtilizados) {
        this.gruCuposUtilizados = gruCuposUtilizados;
    }

    public Integer getGruCuposUtilizadosInternet() {
        return gruCuposUtilizadosInternet;
    }

    public void setGruCuposUtilizadosInternet(Integer gruCuposUtilizadosInternet) {
        this.gruCuposUtilizadosInternet = gruCuposUtilizadosInternet;
    }    

    public Date getGruFechaInicio() {
        return gruFechaInicio;
    }

    public void setGruFechaInicio(Date gruFechaInicio) {
        this.gruFechaInicio = gruFechaInicio;
    }

    public Date getGruFechaFin() {
        return gruFechaFin;
    }

    public void setGruFechaFin(Date gruFechaFin) {
        this.gruFechaFin = gruFechaFin;
    }

    public String getGruModalidadEvaluacion() {
        return gruModalidadEvaluacion;
    }

    public void setGruModalidadEvaluacion(String gruModalidadEvaluacion) {
        this.gruModalidadEvaluacion = gruModalidadEvaluacion;
    }

    public String getGruAutorizado() {
        return gruAutorizado;
    }

    public void setGruAutorizado(String gruAutorizado) {
        this.gruAutorizado = gruAutorizado;
    }

    public String getGruPlanificado() {
        return gruPlanificado;
    }

    public void setGruPlanificado(String gruPlanificado) {
        this.gruPlanificado = gruPlanificado;
    }

    public Long getEstCodigoEva() {
        return estCodigoEva;
    }

    public void setEstCodigoEva(Long estCodigoEva) {
        this.estCodigoEva = estCodigoEva;
    }

    public Long getGruOfgNumeroLeg() {
        return gruOfgNumeroLeg;
    }

    public void setGruOfgNumeroLeg(Long gruOfgNumeroLeg) {
        this.gruOfgNumeroLeg = gruOfgNumeroLeg;
    }

    public String getOfgTipoLeg() {
        return ofgTipoLeg;
    }

    public void setOfgTipoLeg(String ofgTipoLeg) {
        this.ofgTipoLeg = ofgTipoLeg;
    }

    public String getOfgTieneHorarioLeg() {
        return ofgTieneHorarioLeg;
    }

    public void setOfgTieneHorarioLeg(String ofgTieneHorarioLeg) {
        this.ofgTieneHorarioLeg = ofgTieneHorarioLeg;
    }

    public String getGruJornada() {
        return gruJornada;
    }

    public void setGruJornada(String gruJornada) {
        this.gruJornada = gruJornada;
    }

    public Long getPeeCodigo() {
        return peeCodigo;
    }

    public void setPeeCodigo(Long peeCodigo) {
        this.peeCodigo = peeCodigo;
    }

//    @XmlTransient
//    public Collection<OfeDocumentoPortafolio> getOfeDocumentoPortafolioCollection() {
//        return ofeDocumentoPortafolioCollection;
//    }
//
//    public void setOfeDocumentoPortafolioCollection(Collection<OfeDocumentoPortafolio> ofeDocumentoPortafolioCollection) {
//        this.ofeDocumentoPortafolioCollection = ofeDocumentoPortafolioCollection;
//    }

    @XmlTransient
    public Collection<OfeDistributivo> getOfeDistributivoCollection() {
        return ofeDistributivoCollection;
    }

    public void setOfeDistributivoCollection(Collection<OfeDistributivo> ofeDistributivoCollection) {
        this.ofeDistributivoCollection = ofeDistributivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruCodigo != null ? gruCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfeGrupo)) {
            return false;
        }
        OfeGrupo other = (OfeGrupo) object;
        if ((this.gruCodigo == null && other.gruCodigo != null) || (this.gruCodigo != null && !this.gruCodigo.equals(other.gruCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfeGrupo[ gruCodigo=" + gruCodigo + " ]";
    }
    
}
