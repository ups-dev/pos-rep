//Entidad
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.data.entities.wrapper;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ups
 */
@Entity
public class PosgradoAlumnoWrapper implements Serializable {

    @Id
    private String identificador;
    private Long aluCodigo;
    private String sede;
    private String campus;
    private String posgrado;
    private String est_campus;
    private String est_posgrado;
    private String modalidad;
    private String periodo;
    private Long   codPeriodo;
    private String titulo;
    
    
    
    

    public PosgradoAlumnoWrapper() {
    }

    public PosgradoAlumnoWrapper(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public PosgradoAlumnoWrapper(String identificador, Long aluCodigo, String sede, String campus, String posgrado, String est_campus, String est_posgrado, String modalidad, String periodo, Long codPeriodo, String titulo) {
        this.identificador = identificador;
        this.aluCodigo = aluCodigo;
        this.sede = sede;
        this.campus = campus;
        this.posgrado = posgrado;
        this.est_campus = est_campus;
        this.est_posgrado = est_posgrado;
        this.modalidad = modalidad;
        this.periodo = periodo;
        this.codPeriodo = codPeriodo;
        this.titulo = titulo;
    }     
     

    public Long getAluCodigo() {
        return aluCodigo;
    }

    public void setAluCodigo(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }


    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getPosgrado() {
        return posgrado;
    }

    public void setPosgrado(String posgrado) {
        this.posgrado = posgrado;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Long getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Long codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEst_campus() {
        return est_campus;
    }

    public void setEst_campus(String est_campus) {
        this.est_campus = est_campus;
    }

    public String getEst_posgrado() {
        return est_posgrado;
    }

    public void setEst_posgrado(String est_posgrado) {
        this.est_posgrado = est_posgrado;
    }
   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aluCodigo != null ? aluCodigo.hashCode() : 0);
        return hash;
    }

   // @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof PosgradoAlumnoWrapper)) {
//            return false;
//        }
//        PosgradoAlumnoWrapper other = (PosgradoAlumnoWrapper) object;
//        if ((this.aluCodigo == null && other.aluCodigo != null) || (this.aluCodigo != null && !this.aluCodigo.equals(other.aluCodigo))) {
//            return false;
//        }
//        return true;
//    }
       @Override
     public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosgradoAlumnoWrapper)) {
            return false;
        }
        PosgradoAlumnoWrapper other = (PosgradoAlumnoWrapper) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

}
