package ec.edu.ups.pos.rep.data.entities.eva;

import ec.edu.ups.util.jpa.EntitySuperclass;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ups
 */
@Entity
@Table(name = "EVA_HISTORIAL_SESION", catalog = "", schema = "EVA")
@XmlRootElement
public class EvaHistorialSesion extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIS_CODIGO", nullable = false)
    private Long hisCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALU_CODIGO", nullable = false)
    private Long aluCodigo;    

    public EvaHistorialSesion() {
    }

    public EvaHistorialSesion(Long hisCodigo) {
        this.hisCodigo = hisCodigo;
    }

    public EvaHistorialSesion(Long hisCodigo, Long aluCodigo) {
        this.hisCodigo = hisCodigo;
        this.aluCodigo = aluCodigo;        
    }

    public Long getHisCodigo() {
        return hisCodigo;
    }

    public void setHisCodigo(Long hisCodigo) {
        this.hisCodigo = hisCodigo;
    }

    public Long getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisCodigo != null ? hisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaHistorialSesion)) {
            return false;
        }
        EvaHistorialSesion other = (EvaHistorialSesion) object;
        if ((this.hisCodigo == null && other.hisCodigo != null) || (this.hisCodigo != null && !this.hisCodigo.equals(other.hisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaHistorialSesion[ hisCodigo=" + hisCodigo + " ]";
    }
    
}
