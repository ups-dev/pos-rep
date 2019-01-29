/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.data.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ups
 */
public class PosRepConstants {

    //Nombre de la aplicación
    public static final String APPLICATION_NAME = "Sistema de Reportes";

    //Correo desarrollo
    public static final List<String> EMAIL_TO_ERROR = new ArrayList<String>();
    public static final List<String> EMAIL_CC_ERROR = new ArrayList<String>();
    public static final List<String> EMAIL_TO = new ArrayList<String>();
    public static final List<String> EMAIL_BCC = new ArrayList<String>();

    public static final Long TODAS_SEDES = 0L;      //UNO DESARROLLO CERO PRODUCCION
    public static final Long TODOS_CAMPUS = 0L;     //CAMPUS
    public static final Long TODAS_CARRERAS = 0L;   //CARRERA
    public static final Long TODOS_PROGRAMAS = 0L;  //PROGRAMAS DE POSGRADO
    public static final Long CERO = 0L;             //CERO

    public static final String DATASOURCE_NAME = "jdbc/rep"; //Nombre de referencia al datasource, es el mismo que se declara en el archivo "jboss-web.xml".

    public static final Integer REPORTE_VACIO_PDF = 1001; //Si el archivo de reporte generado tiene igual o menor tamaño, es considerado en blanco
    public static final Integer REPORTE_VACIO_XLSX = 1871; //Si el archivo de reporte generado tiene igual o menor tamaño, es considerado en blanco

    public static final String TIPO_DOCUMENTO_DF = "C";      //TIPO DOCUMENTO X DF CEDULA
    public static final Integer NUMERO_ALUMNOS_REPORTE = 1;  //NÚMERO DE ALUMNOS PARA OBTENER REPORTE 

    public static final String PAIS_DF = "ECUADOR";     //PAIS POR DEFECTO
    public static final Long TIPO_AREA_PAIS = 1L;     //PAIS POR DEFECTO
    
    public static final Long REP_PARAMETRO_SEDE = 1L;               //Parámetro de Sede
    public static final Long REP_PARAMETRO_CAMPUS = 2L;             //Parámetro de Campús
    public static final Long REP_PARAMETRO_CARRERA = 3L;            //Parámetro de Carrera
    public static final Long REP_PARAMETRO_PERIODO_INICIAL = 4L;    //Parámetro de Periodo Inicial
    public static final Long REP_PARAMETRO_PERIODO_FINAL = 5L;      //Parámetro de Periodo Final
    public static final Long REP_PARAMETRO_MODALIDAD = 6L;          //Parámetro de Modalidad
    public static final Long REP_PARAMETRO_CUESTIONARIO = 7L;       //Parámetro de Cuestionario
    public static final Long REP_PARAMETRO_INFORMANTE = 8L;         //Parámetro de Informante
    public static final Long REP_PARAMETRO_DOCENTE = 9L;            //Parámetro de Docente
    public static final Long REP_PARAMETRO_ASIGNATURA = 10L;        //Parámetro de Asignatura
    public static final Long REP_PARAMETRO_GRUPO = 11L;             //Parámetro de Grupo
    //public static final Long REP_PARAMETRO_PROGRAMA = 12L;          //Parámetro de Programa
    public static final Long REP_PARAMETRO_ALUMNO = 12L;          //Parámetro de Alumno
    public static final Long REP_PARAMETRO_NIVEL = 14L;          //Parámetro de Nivel
    public static final Long REP_PARAMETRO_SEMESTRE = 15L;          //Parámetro de Semestre
    public static final Long REP_PARAMETRO_CERTIFICACION = 16L;
    public static final String REP_PARAMETRO_MODULO_CERTIFICADOS = "REPORTES_CERTIFICADOS";     //Parámetro fijo del Módulo    
    public static final String REP_PARAMETRO_MODULO_REPORTES = "REPORTES";     //Parámetro fijo del Módulo
    public static final Long REP_PARAMETRO_PAGADO = 17L;          //Parámetro de Pagado SI/NO
    
    static {
//        EMAIL_TO_ERROR.add("mpinedav@ups.edu.ec");        
//        EMAIL_TO_ERROR.add("mjarama@ups.edu.ec");
        EMAIL_TO_ERROR.add("emora@ups.edu.ec");
        EMAIL_TO_ERROR.add("prodriguezl@ups.edu.ec");
        EMAIL_TO_ERROR.add("myunga@ups.edu.ec");
        EMAIL_TO_ERROR.add("dperalta@ups.edu.ec");
        EMAIL_TO_ERROR.add("vclavijo@ups.edu.ec");
        EMAIL_TO_ERROR.add("esalto@ups.edu.ec");
//        EMAIL_TO.add("mpinedav@ups.edu.ec");       
    }
}
