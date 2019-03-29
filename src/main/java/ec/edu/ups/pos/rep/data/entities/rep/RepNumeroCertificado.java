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
@Table(name = "REP_NUMERO_CERTIFICADO", catalog = "", schema = "REP")
@XmlRootElement

public class RepNumeroCertificado extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NCE_CODIGO", nullable = false)
    private Long nceCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_CODIGO", nullable = false)
    private Long estCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEL_CODIGO", nullable = false)
    private Long pelCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIC_CODIGO", nullable = false)
    private Long ticCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NCE_NUMERO_CERTIFICADO", nullable = false)
    private Long nceNumeroCertificado;

    public RepNumeroCertificado() {
    }

    public RepNumeroCertificado(Long nceCodigo) {
        this.nceCodigo = nceCodigo;
    }
   public RepNumeroCertificado(Long nceCodigo, Long estCodigo, Long pelCodigo, Long ticCodigo, Long nceNumeroCertificado) {
        this.nceCodigo = nceCodigo;
        this.estCodigo = estCodigo;
        this.pelCodigo = pelCodigo;
        this.ticCodigo = ticCodigo;
        this.nceNumeroCertificado = nceNumeroCertificado;
    }
    

    public Long getNceCodigo() {
        return nceCodigo;
    }

    public void setNceCodigo(Long nceCodigo) {
        this.nceCodigo = nceCodigo;
    }

    public long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public long getPelCodigo() {
        return pelCodigo;
    }

    public void setPelCodigo(long pelCodigo) {
        this.pelCodigo = pelCodigo;
    }

    public long getTicCodigo() {
        return ticCodigo;
    }

    public void setTicCodigo(long ticCodigo) {
        this.ticCodigo = ticCodigo;
    }
    public long getNceNumeroCertificado() {
        return nceNumeroCertificado;
    }

    public void setNceNumeroCertificado(long nceNumeroCertificado) {
        this.nceNumeroCertificado = nceNumeroCertificado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nceCodigo != null ? nceCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepNumeroCertificado)) {
            return false;
        }
        RepNumeroCertificado other = (RepNumeroCertificado) object;
        if ((this.nceCodigo == null && other.nceCodigo != null) || (this.nceCodigo != null && !this.nceCodigo.equals(other.nceCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RepNumeroCertificado[ nceCodigo=" + nceCodigo + " ]";
    }
    
}
