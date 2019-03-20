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
    private String estSede;
    private String estCampus;
    private String estPosgrado;
    private String modalidad;
    private String periodo;
    private Long   codPeriodo;
    private String cohorte;
    private String tieneMencion;
    private String tieneMencionEst;
    private Long   totalMenciones;
    private String titulo;
    
    
    
    

    public PosgradoAlumnoWrapper() {
    }

    public PosgradoAlumnoWrapper(Long aluCodigo) {
        this.aluCodigo = aluCodigo;
    }

    public PosgradoAlumnoWrapper(String identificador, Long aluCodigo, String sede, String campus, String posgrado, String estSede, String estCampus, String estPosgrado, String modalidad, String periodo, Long codPeriodo, String cohorte, String tieneMencion, String tieneMencionEst, Long totalMenciones, String titulo) {
        this.identificador = identificador;
        this.aluCodigo = aluCodigo;
        this.sede = sede;
        this.campus = campus;
        this.posgrado = posgrado;
        this.estSede = estSede;
        this.estCampus = estCampus;
        this.estPosgrado = estPosgrado;
        this.modalidad = modalidad;
        this.periodo = periodo;
        this.codPeriodo = codPeriodo;
        this.cohorte = cohorte;
        this.tieneMencion = tieneMencion;
        this.tieneMencionEst = tieneMencionEst;
        this.totalMenciones = totalMenciones;
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

    public String getEstSede() {
        return estSede;
    }

    public void setEstSede(String estSede) {
        this.estSede = estSede;
    }

    public String getEstCampus() {
        return estCampus;
    }

    public void setEstCampus(String estCampus) {
        this.estCampus = estCampus;
    }

    public String getEstPosgrado() {
        return estPosgrado;
    }

    public void setEstPosgrado(String estPosgrado) {
        this.estPosgrado = estPosgrado;
    }

    public String getCohorte() {
        return cohorte;
    }

    public void setCohorte(String cohorte) {
        this.cohorte = cohorte;
    }

    public String getTieneMencion() {
        return tieneMencion;
    }

    public void setTieneMencion(String tieneMencion) {
        this.tieneMencion = tieneMencion;
    }

    public String getTieneMencionEst() {
        return tieneMencionEst;
    }

    public void setTieneMencionEst(String tieneMencionEst) {
        this.tieneMencionEst = tieneMencionEst;
    }

    public Long getTotalMenciones() {
        return totalMenciones;
    }

    public void setTotalMenciones(Long totalMenciones) {
        this.totalMenciones = totalMenciones;
    }

  
   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aluCodigo != null ? aluCodigo.hashCode() : 0);
        return hash;
    }
    
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
