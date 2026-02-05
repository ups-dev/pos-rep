package ec.edu.ups.pos.rep.data.entities.sol;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SOL_SOLICITUD_DATOS", schema = "SOL")
public class SolSolicitudDatos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(max = 100)
	@Column(name = "SOD_ESTUDIANTE_TELEFONO")
	private String sodEstudianteTelefono;

	@Size(max = 250)
	@Column(name = "SOD_PROYECTO_ACADEMICO_ACTUAL")
	private String sodProyectoAcademicoActual;

	@Size(max = 250)
	@Column(name = "SOD_PROYECTO_ACADEMICO_NUEVO")
	private String sodProyectoAcademicoNuevo;

	@Size(max = 100)
	@Column(name = "SOD_NOMBRE_UNIVERSIDAD_ORIGEN")
	private String sodNombreUniversidadOrigen;

	@Size(max = 250)
	@Column(name = "SOD_NOMBRE_CARRERA_ORIGEN")
	private String sodNombreCarreraOrigen;

	@Size(max = 100)
	@Column(name = "SOD_PERIODO_ACADEMICO")
	private String sodPeriodoAcademico;

	@Size(max = 20)
	@Column(name = "SOD_PERIODO_ACADEMICO_ULTIMO")
	private String sodPeriodoAcademicoUltimo;

	@Size(max = 20)
	@Column(name = "SOD_TOTAL_HORAS")
	private String sodTotalHoras;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "SOD_CASOS_EXCEPCIONALES")
	private String sodCasosExcepcionales;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "SOD_CASO_APROBADO")
	private String sodCasoAprobado;

	@Size(max = 20)
	@Column(name = "SOD_PORCENTAJE_CREDITOS")
	private String sodPorcentajeCreditos;

	@Size(max = 20)
	@Column(name = "SOD_PROMEDIO")
	private String sodPromedio;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "SOL_CODIGO")
	private BigDecimal solCodigo;

	@Size(max = 250)
	@Column(name = "SOD_NOMBRE_CARRERA")
	private String sodNombreCarrera;

	@Size(max = 250)
	@Column(name = "SOD_PLAN_ESTUDIOS")
	private String sodPlanEstudios;

	@Size(max = 250)
	@Column(name = "SOD_NOMBRE_PROGRAMA_ESTUDIOS")
	private String sodNombreProgramaEstudios;

	@Size(max = 20)
	@Column(name = "SOD_COHORTE")
	private String sodCohorte;

	@Size(max = 100)
	@Column(name = "SOD_EMAIL_PERSONAL")
	private String sodEmailPersonal;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "SOD_NOMBRE_DIRECTOR")
	private String sodNombreDirector;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "SOD_CIUDAD")
	private String sodCiudad;

	@Size(max = 150)
	@Column(name = "SOD_NOMBRE_CARRERA_DIRECTOR")
	private String sodNombreCarreraDirector;

	@Column(name = "PEL_CODIGO")
	private BigInteger pelCodigo;

	@Size(max = 20)
	@Column(name = "SOD_MONTO_DEUDA")
	private String sodMontoDeuda;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "SOD_CARRERA_PED")
	private String sodCarreraPed;

	@Lob
	@Column(name = "SOD_JUSTIFICACION")
	private String sodJustificacion;

	@Size(max = 60)
	@Column(name = "SOD_ASIGNATURAS_APROBADAS")
	private String sodAsignaturasAprobadas;

	@Size(max = 60)
	@Column(name = "SOD_TOTAL_ASIGNATURAS")
	private String sodTotalAsignaturas;

	@Size(max = 60)
	@Column(name = "SOD_NIVEL_APROBADO")
	private String sodNivelAprobado;

	@Size(max = 60)
	@Column(name = "SOD_TOTAL_NIVELES")
	private String sodTotalNiveles;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "AUD_ELIMINADO")
	private String audEliminado;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "AUD_ADICIONADO")
	private String audAdicionado;

	@Basic(optional = false)
	@NotNull
	@Column(name = "AUD_FECHA_ADICION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaAdicion;

	@Size(max = 50)
	@Column(name = "AUD_MODIFICADO")
	private String audModificado;

	@Column(name = "AUD_FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date audFechaModificacion;

	@Size(max = 2000)
	@Column(name = "SOD_VARCHAR_1")
	private String sodVarchar1;

	@Size(max = 2000)
	@Column(name = "SOD_VARCHAR_2")
	private String sodVarchar2;

	@Size(max = 2000)
	@Column(name = "SOD_VARCHAR_3")
	private String sodVarchar3;

	@Size(max = 2000)
	@Column(name = "SOD_VARCHAR_4")
	private String sodVarchar4;

	@Size(max = 2000)
	@Column(name = "SOD_VARCHAR_5")
	private String sodVarchar5;

	@Column(name = "SOD_NUMBER_1")
	private BigInteger sodNumber1;

	@Column(name = "SOD_NUMBER_2")
	private BigInteger sodNumber2;

	@Column(name = "SOD_NUMBER_3")
	private BigInteger sodNumber3;

	@Column(name = "SOD_NUMBER_4")
	private BigInteger sodNumber4;

	@Column(name = "SOD_NUMBER_5")
	private BigInteger sodNumber5;

	public SolSolicitudDatos() {
	}

	public SolSolicitudDatos(BigDecimal solCodigo) {
		this.solCodigo = solCodigo;
	}

	public SolSolicitudDatos(BigDecimal solCodigo, String sodCasosExcepcionales, String sodCasoAprobado,
			String sodNombreDirector, String sodCiudad, String sodCarreraPed, String audEliminado, String audAdicionado,
			Date audFechaAdicion) {
		this.solCodigo = solCodigo;
		this.sodCasosExcepcionales = sodCasosExcepcionales;
		this.sodCasoAprobado = sodCasoAprobado;
		this.sodNombreDirector = sodNombreDirector;
		this.sodCiudad = sodCiudad;
		this.sodCarreraPed = sodCarreraPed;
		this.audEliminado = audEliminado;
		this.audAdicionado = audAdicionado;
		this.audFechaAdicion = audFechaAdicion;
	}

	public String getSodEstudianteTelefono() {
		return this.sodEstudianteTelefono;
	}

	public void setSodEstudianteTelefono(String sodEstudianteTelefono) {
		this.sodEstudianteTelefono = sodEstudianteTelefono;
	}

	public String getSodProyectoAcademicoActual() {
		return this.sodProyectoAcademicoActual;
	}

	public void setSodProyectoAcademicoActual(String sodProyectoAcademicoActual) {
		this.sodProyectoAcademicoActual = sodProyectoAcademicoActual;
	}

	public String getSodProyectoAcademicoNuevo() {
		return this.sodProyectoAcademicoNuevo;
	}

	public void setSodProyectoAcademicoNuevo(String sodProyectoAcademicoNuevo) {
		this.sodProyectoAcademicoNuevo = sodProyectoAcademicoNuevo;
	}

	public String getSodNombreUniversidadOrigen() {
		return this.sodNombreUniversidadOrigen;
	}

	public void setSodNombreUniversidadOrigen(String sodNombreUniversidadOrigen) {
		this.sodNombreUniversidadOrigen = sodNombreUniversidadOrigen;
	}

	public String getSodNombreCarreraOrigen() {
		return this.sodNombreCarreraOrigen;
	}

	public void setSodNombreCarreraOrigen(String sodNombreCarreraOrigen) {
		this.sodNombreCarreraOrigen = sodNombreCarreraOrigen;
	}

	public String getSodPeriodoAcademico() {
		return this.sodPeriodoAcademico;
	}

	public void setSodPeriodoAcademico(String sodPeriodoAcademico) {
		this.sodPeriodoAcademico = sodPeriodoAcademico;
	}

	public String getSodPeriodoAcademicoUltimo() {
		return this.sodPeriodoAcademicoUltimo;
	}

	public void setSodPeriodoAcademicoUltimo(String sodPeriodoAcademicoUltimo) {
		this.sodPeriodoAcademicoUltimo = sodPeriodoAcademicoUltimo;
	}

	public String getSodTotalHoras() {
		return this.sodTotalHoras;
	}

	public void setSodTotalHoras(String sodTotalHoras) {
		this.sodTotalHoras = sodTotalHoras;
	}

	public String getSodCasosExcepcionales() {
		return this.sodCasosExcepcionales;
	}

	public void setSodCasosExcepcionales(String sodCasosExcepcionales) {
		this.sodCasosExcepcionales = sodCasosExcepcionales;
	}

	public String getSodCasoAprobado() {
		return this.sodCasoAprobado;
	}

	public void setSodCasoAprobado(String sodCasoAprobado) {
		this.sodCasoAprobado = sodCasoAprobado;
	}

	public String getSodPorcentajeCreditos() {
		return this.sodPorcentajeCreditos;
	}

	public void setSodPorcentajeCreditos(String sodPorcentajeCreditos) {
		this.sodPorcentajeCreditos = sodPorcentajeCreditos;
	}

	public String getSodPromedio() {
		return this.sodPromedio;
	}

	public void setSodPromedio(String sodPromedio) {
		this.sodPromedio = sodPromedio;
	}

	public BigDecimal getSolCodigo() {
		return this.solCodigo;
	}

	public void setSolCodigo(BigDecimal solCodigo) {
		this.solCodigo = solCodigo;
	}

	public String getSodNombreCarrera() {
		return this.sodNombreCarrera;
	}

	public void setSodNombreCarrera(String sodNombreCarrera) {
		this.sodNombreCarrera = sodNombreCarrera;
	}

	public String getSodPlanEstudios() {
		return this.sodPlanEstudios;
	}

	public void setSodPlanEstudios(String sodPlanEstudios) {
		this.sodPlanEstudios = sodPlanEstudios;
	}

	public String getSodNombreProgramaEstudios() {
		return this.sodNombreProgramaEstudios;
	}

	public void setSodNombreProgramaEstudios(String sodNombreProgramaEstudios) {
		this.sodNombreProgramaEstudios = sodNombreProgramaEstudios;
	}

	public String getSodCohorte() {
		return this.sodCohorte;
	}

	public void setSodCohorte(String sodCohorte) {
		this.sodCohorte = sodCohorte;
	}

	public String getSodEmailPersonal() {
		return this.sodEmailPersonal;
	}

	public void setSodEmailPersonal(String sodEmailPersonal) {
		this.sodEmailPersonal = sodEmailPersonal;
	}

	public String getSodNombreDirector() {
		return this.sodNombreDirector;
	}

	public void setSodNombreDirector(String sodNombreDirector) {
		this.sodNombreDirector = sodNombreDirector;
	}

	public String getSodCiudad() {
		return this.sodCiudad;
	}

	public void setSodCiudad(String sodCiudad) {
		this.sodCiudad = sodCiudad;
	}

	public String getSodNombreCarreraDirector() {
		return this.sodNombreCarreraDirector;
	}

	public void setSodNombreCarreraDirector(String sodNombreCarreraDirector) {
		this.sodNombreCarreraDirector = sodNombreCarreraDirector;
	}

	public BigInteger getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(BigInteger pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public String getSodMontoDeuda() {
		return this.sodMontoDeuda;
	}

	public void setSodMontoDeuda(String sodMontoDeuda) {
		this.sodMontoDeuda = sodMontoDeuda;
	}

	public String getSodCarreraPed() {
		return this.sodCarreraPed;
	}

	public void setSodCarreraPed(String sodCarreraPed) {
		this.sodCarreraPed = sodCarreraPed;
	}

	public String getSodJustificacion() {
		return this.sodJustificacion;
	}

	public void setSodJustificacion(String sodJustificacion) {
		this.sodJustificacion = sodJustificacion;
	}

	public String getSodAsignaturasAprobadas() {
		return this.sodAsignaturasAprobadas;
	}

	public void setSodAsignaturasAprobadas(String sodAsignaturasAprobadas) {
		this.sodAsignaturasAprobadas = sodAsignaturasAprobadas;
	}

	public String getSodTotalAsignaturas() {
		return this.sodTotalAsignaturas;
	}

	public void setSodTotalAsignaturas(String sodTotalAsignaturas) {
		this.sodTotalAsignaturas = sodTotalAsignaturas;
	}

	public String getSodNivelAprobado() {
		return this.sodNivelAprobado;
	}

	public void setSodNivelAprobado(String sodNivelAprobado) {
		this.sodNivelAprobado = sodNivelAprobado;
	}

	public String getSodTotalNiveles() {
		return this.sodTotalNiveles;
	}

	public void setSodTotalNiveles(String sodTotalNiveles) {
		this.sodTotalNiveles = sodTotalNiveles;
	}

	public String getAudEliminado() {
		return this.audEliminado;
	}

	public void setAudEliminado(String audEliminado) {
		this.audEliminado = audEliminado;
	}

	public String getAudAdicionado() {
		return this.audAdicionado;
	}

	public void setAudAdicionado(String audAdicionado) {
		this.audAdicionado = audAdicionado;
	}

	public Date getAudFechaAdicion() {
		return this.audFechaAdicion;
	}

	public void setAudFechaAdicion(Date audFechaAdicion) {
		this.audFechaAdicion = audFechaAdicion;
	}

	public String getAudModificado() {
		return this.audModificado;
	}

	public void setAudModificado(String audModificado) {
		this.audModificado = audModificado;
	}

	public Date getAudFechaModificacion() {
		return this.audFechaModificacion;
	}

	public void setAudFechaModificacion(Date audFechaModificacion) {
		this.audFechaModificacion = audFechaModificacion;
	}

	public String getSodVarchar1() {
		return this.sodVarchar1;
	}

	public void setSodVarchar1(String sodVarchar1) {
		this.sodVarchar1 = sodVarchar1;
	}

	public String getSodVarchar2() {
		return this.sodVarchar2;
	}

	public void setSodVarchar2(String sodVarchar2) {
		this.sodVarchar2 = sodVarchar2;
	}

	public String getSodVarchar3() {
		return this.sodVarchar3;
	}

	public void setSodVarchar3(String sodVarchar3) {
		this.sodVarchar3 = sodVarchar3;
	}

	public String getSodVarchar4() {
		return this.sodVarchar4;
	}

	public void setSodVarchar4(String sodVarchar4) {
		this.sodVarchar4 = sodVarchar4;
	}

	public String getSodVarchar5() {
		return this.sodVarchar5;
	}

	public void setSodVarchar5(String sodVarchar5) {
		this.sodVarchar5 = sodVarchar5;
	}

	public BigInteger getSodNumber1() {
		return this.sodNumber1;
	}

	public void setSodNumber1(BigInteger sodNumber1) {
		this.sodNumber1 = sodNumber1;
	}

	public BigInteger getSodNumber2() {
		return this.sodNumber2;
	}

	public void setSodNumber2(BigInteger sodNumber2) {
		this.sodNumber2 = sodNumber2;
	}

	public BigInteger getSodNumber3() {
		return this.sodNumber3;
	}

	public void setSodNumber3(BigInteger sodNumber3) {
		this.sodNumber3 = sodNumber3;
	}

	public BigInteger getSodNumber4() {
		return this.sodNumber4;
	}

	public void setSodNumber4(BigInteger sodNumber4) {
		this.sodNumber4 = sodNumber4;
	}

	public BigInteger getSodNumber5() {
		return this.sodNumber5;
	}

	public void setSodNumber5(BigInteger sodNumber5) {
		this.sodNumber5 = sodNumber5;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SolSolicitudDatos)) {
			return false;
		}
		SolSolicitudDatos other = (SolSolicitudDatos) object;
		if ((this.solCodigo == null && other.solCodigo != null)
				|| (this.solCodigo != null && !this.solCodigo.equals(other.solCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.solCodigo != null) ? this.solCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "ec.edu.ups.sse.data.entity.sol.SolSolicitudDatos[ solCodigo=" + this.solCodigo + " ]";
	}

}
