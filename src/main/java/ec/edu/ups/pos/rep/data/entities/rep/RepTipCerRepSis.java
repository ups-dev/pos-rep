/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.data.entities.rep;

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
 * @author UPS
 */
@Entity
@Table(name = "REP_TIP_CER_REP_SIS", catalog = "", schema = "REP")
@XmlRootElement
public class RepTipCerRepSis extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCR_CODIGO", nullable = false)
    private Long tcrCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_CODIGO", nullable = false)
    private Long resCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIC_CODIGO", nullable = false)
    private Long ticCodigo;

    public RepTipCerRepSis() {
    }

    public RepTipCerRepSis(Long tcrCodigo) {
        this.tcrCodigo = tcrCodigo;
    }
    
    public RepTipCerRepSis(Long tcrCodigo, Long resCodigo, Long ticCodigo) {
        this.tcrCodigo = tcrCodigo;
        this.resCodigo = resCodigo;
        this.ticCodigo = ticCodigo;
    }
   
    public Long getTcrCodigo() {
        return tcrCodigo;
    }

    public void setTcrCodigo(Long tcrCodigo) {
        this.tcrCodigo = tcrCodigo;
    }
    public long getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(long resCodigo) {
        this.resCodigo = resCodigo;
    }

    public long getTicCodigo() {
        return ticCodigo;
    }

    public void setTicCodigo(long ticCodigo) {
        this.ticCodigo = ticCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcrCodigo != null ? tcrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepTipCerRepSis)) {
            return false;
        }
        RepTipCerRepSis other = (RepTipCerRepSis) object;
        if ((this.tcrCodigo == null && other.tcrCodigo != null) || (this.tcrCodigo != null && !this.tcrCodigo.equals(other.tcrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RepTipCerRepSis[ tcrCodigo=" + tcrCodigo + " ]";
    }
    
}
