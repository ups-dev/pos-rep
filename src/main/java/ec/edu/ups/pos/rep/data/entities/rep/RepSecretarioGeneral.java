
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UPS
 */
@Entity
@Table(name = "REP_SECRETARIO_GENERAL", catalog = "", schema = "REP")
@XmlRootElement

public class RepSecretarioGeneral extends EntitySuperclass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEG_CODIGO", nullable = false)
    private Long segCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEG_NOMBRE", nullable = false, length = 100)
    private String segNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEG_TITULO", nullable = false, length = 100)
    private String segTitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SEG_LUGAR_CERTIFICA", nullable = false, length = 50)
    private String segLugarCertifica;


    public RepSecretarioGeneral() {
    }

    public RepSecretarioGeneral(Long segCodigo) {
        this.segCodigo = segCodigo;
    }

    public RepSecretarioGeneral(Long segCodigo, String segNombre, String segTitulo, String segLugarCertifica) {
        this.segCodigo = segCodigo;
        this.segNombre = segNombre;
        this.segTitulo = segTitulo;
        this.segLugarCertifica = segLugarCertifica;

    }

    public Long getSegCodigo() {
        return segCodigo;
    }

    public void setSegCodigo(Long segCodigo) {
        this.segCodigo = segCodigo;
    }

    public String getSegNombre() {
        return segNombre;
    }

    public void setSegNombre(String segNombre) {
        this.segNombre = segNombre;
    }

    public String getSegTitulo() {
        return segTitulo;
    }

    public void setSegTitulo(String segTitulo) {
        this.segTitulo = segTitulo;
    }

    public String getSegLugarCertifica() {
        return segLugarCertifica;
    }

    public void setSegLugarCertifica(String segLugarCertifica) {
        this.segLugarCertifica = segLugarCertifica;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segCodigo != null ? segCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepSecretarioGeneral)) {
            return false;
        }
        RepSecretarioGeneral other = (RepSecretarioGeneral) object;
        if ((this.segCodigo == null && other.segCodigo != null) || (this.segCodigo != null && !this.segCodigo.equals(other.segCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RepSecretarioGeneral[ segCodigo=" + segCodigo + " ]";
    }
    
}
