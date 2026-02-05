package ec.edu.ups.pos.rep.data.utils;

import java.util.ArrayList;
import java.util.List;

public final class PosRepConstants {

	/**
	 * Constructor privado para prevenir la instanciación.
	 */
	private PosRepConstants() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

	/**
	 * Nombre de la aplicación.
	 */
	public static final String APPLICATION_NAME = "Sistema de Reportes";

	// Correo desarrollo
	/**
	 * Description.
	 *
	 */
	public static final List<String> EMAIL_TO_ERROR = new ArrayList<String>();

	/**
	 * Description.
	 */
	public static final List<String> EMAIL_CC_ERROR = new ArrayList<String>();

	/**
	 * Description.
	 */
	public static final List<String> EMAIL_TO = new ArrayList<String>();

	/**
	 * Description.
	 */
	public static final List<String> EMAIL_BCC = new ArrayList<String>();

	/**
	 * UNO DESARROLLO CERO PRODUCCION.
	 */
	public static final Long TODAS_SEDES = 0L;

	/**
	 * CAMPUS.
	 */
	public static final Long TODOS_CAMPUS = 0L;

	/**
	 * CARRERA.
	 */
	public static final Long TODAS_CARRERAS = 0L;

	/**
	 * PROGRAMAS DE POSGRADO.
	 */
	public static final Long TODOS_PROGRAMAS = 0L;

	/**
	 * CERO.
	 */
	public static final Long CERO = 0L;

	/**
	 * Nombre de referencia al datasource, es el mismo que se declara en el archivo
	 * "jboss-web.xml".
	 */
	public static final String DATASOURCE_NAME = "jdbc/rep";

	/**
	 * Si el archivo de reporte generado tiene igual o menor tamaño, es considerado en
	 * blanco.
	 */
	public static final Integer REPORTE_VACIO_PDF = 1001;

	/**
	 * Si el archivo de reporte generado tiene igual o menor tamaño, es considerado en
	 * blanco.
	 */
	public static final Integer REPORTE_VACIO_XLSX = 1871;

	/**
	 * TIPO DOCUMENTO X DF CEDULA.
	 */
	public static final String TIPO_DOCUMENTO_DF = "C";

	/**
	 * NÚMERO DE ALUMNOS PARA OBTENER REPORTE.
	 */
	public static final Integer NUMERO_ALUMNOS_REPORTE = 1;

	/**
	 * PAIS POR DEFECTO.
	 */
	public static final String PAIS_DF = "ECUADOR";

	/**
	 * PAIS POR DEFECTO.
	 */
	public static final Long TIPO_AREA_PAIS = 1L;

	/**
	 * Parámetro de Sede.
	 */
	public static final Long REP_PARAMETRO_SEDE = 1L;

	/**
	 * Parámetro de Campús.
	 */
	public static final Long REP_PARAMETRO_CAMPUS = 2L;

	/**
	 * Parámetro de Carrera.
	 */
	public static final Long REP_PARAMETRO_CARRERA = 3L;

	/**
	 * Parámetro de Periodo Inicial.
	 */
	public static final Long REP_PARAMETRO_PERIODO_INICIAL = 4L;

	/**
	 * Parámetro de Periodo Final.
	 */
	public static final Long REP_PARAMETRO_PERIODO_FINAL = 5L;

	/**
	 * Parámetro de Modalidad.
	 */
	public static final Long REP_PARAMETRO_MODALIDAD = 6L;

	/**
	 * Parámetro de Cuestionario.
	 */
	public static final Long REP_PARAMETRO_CUESTIONARIO = 7L;

	/**
	 * Parámetro de Informante.
	 */
	public static final Long REP_PARAMETRO_INFORMANTE = 8L;

	/**
	 * Parámetro de Docente.
	 */
	public static final Long REP_PARAMETRO_DOCENTE = 9L;

	/**
	 * Parámetro de Asignatura.
	 */
	public static final Long REP_PARAMETRO_ASIGNATURA = 10L;

	/**
	 * Parámetro de Grupo.
	 */
	public static final Long REP_PARAMETRO_GRUPO = 11L;

	/**
	 * Parámetro de Alumno.
	 */
	public static final Long REP_PARAMETRO_ALUMNO = 12L;

	/**
	 * Parámetro de Nivel.
	 */
	public static final Long REP_PARAMETRO_NIVEL = 14L;

	/**
	 * Parámetro de Semestre.
	 */
	public static final Long REP_PARAMETRO_SEMESTRE = 15L;

	/**
	 * Description.
	 */
	public static final Long REP_PARAMETRO_CERTIFICACION = 16L;

	/**
	 * Parámetro fijo del Módulo.
	 */
	public static final String REP_PARAMETRO_MODULO_CERTIFICADOS = "REPORTES_CERTIFICADOS";

	/**
	 * Parámetro fijo del Módulo.
	 */
	public static final String REP_PARAMETRO_MODULO_GESTOR_ARCHIVOS = "";

	/**
	 * Parámetro fijo del Módulo.
	 */
	public static final String REP_PARAMETRO_MODULO_REPORTES = "REPORTES";

	/**
	 * Parámetro fijo del Módulo.
	 */
	public static final String REP_PARAMETRO_MODULO_DOCTORADOS = "DOCTORADO";

	/**
	 * Parámetro de Pagado SI/NO.
	 */
	public static final Long REP_PARAMETRO_PAGADO = 17L;

	/**
	 * Description.
	 */
	public static final Long REPORTE_SISTEMA_CALIFICACIONES_SEMESTRE = 24L;

	/**
	 * Description.
	 */
	public static final Long REPORTE_SISTEMA_RECORD_ACADEMICO_GRADUADOS = 38L;

	/**
	 * Parámetro Cohorte con opción Todos.
	 */
	public static final Long REP_PARAMETRO_COHORTE_TODOS = 19L;

	/**
	 * Parámetro Modalidad con opción Todos.
	 */
	public static final Long REP_PARAMETRO_MODALIDAD_TODOS = 20L;

	/**
	 * Parámetro de Año.
	 */
	public static final Long REP_PARAMETRO_ANIO = 22L;

	static {
		EMAIL_TO_ERROR.add("dperalta@ups.edu.ec");
		EMAIL_TO_ERROR.add("esalto@ups.edu.ec");
		EMAIL_TO_ERROR.add("jsuarez@ups.edu.ec");
		EMAIL_TO_ERROR.add("dmatovelle@ups.edu.ec");
	}

}
