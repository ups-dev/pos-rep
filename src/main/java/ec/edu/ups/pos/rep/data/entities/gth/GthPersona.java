package ec.edu.ups.pos.rep.data.entities.gth;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Description.
 *
 * @author ups .
 */
@Entity
@Table(name = "GTH_PERSONA", catalog = "", schema = "GTH",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "PER_NRO_SEGURO_SOCIAL" }),
				@UniqueConstraint(columnNames = { "PER_NRO_IDENTIFICACION" }),
				@UniqueConstraint(columnNames = { "PER_NRO_PASAPORTE" }) })
public class GthPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "PER_CODIGO", nullable = false)
	private Long perCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 32)
	@Column(name = "PER_NRO_IDENTIFICACION", nullable = false, length = 32)
	private String perNroIdentificacion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "PER_APELLIDOS", nullable = false, length = 50)
	private String perApellidos;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "PER_NOMBRES", nullable = false, length = 50)
	private String perNombres;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PER_GENERO", nullable = false, length = 1)
	private String perGenero;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PER_FECHA_NACIMIENTO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date perFechaNacimiento;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "PER_CALLE_PRINCIPAL", nullable = false, length = 50)
	private String perCallePrincipal;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "PER_NRO_CASA", nullable = false, length = 10)
	private String perNroCasa;

	@Size(max = 50)
	@Column(name = "PER_CALLE_SECUNDARIA", length = 50)
	private String perCalleSecundaria;

	@Size(max = 250)
	@Column(name = "PER_REFERENCIA", length = 250)
	private String perReferencia;

	@Size(max = 32)
	@Column(name = "PER_NRO_PASAPORTE", length = 32)
	private String perNroPasaporte;

	@Column(name = "PER_PAS_FECHA_EMISION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date perPasFechaEmision;

	@Column(name = "PER_PAS_FECHA_VENCIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date perPasFechaVencimiento;

	@Size(max = 20)
	@Column(name = "PER_CASILLA", length = 20)
	private String perCasilla;

	@Size(max = 20)
	@Column(name = "PER_NRO_SEGURO_SOCIAL", length = 20)
	private String perNroSeguroSocial;

	@Column(name = "PER_FECHA_AFILIACION_SEGURO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date perFechaAfiliacionSeguro;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "PER_ELIMINADO", nullable = false, length = 1)
	private String perEliminado;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "PER_ADICIONADO", nullable = false, length = 30)
	private String perAdicionado;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PER_FECHA_ADICION", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date perFechaAdicion;

	@Size(max = 30)
	@Column(name = "PER_MODIFICADO", length = 30)
	private String perModificado;

	@Column(name = "PER_FECHA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date perFechaModificacion;

	public GthPersona() {
	}

	public GthPersona(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public Long getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Long perCodigo) {
		this.perCodigo = perCodigo;
	}

	public String getPerNroIdentificacion() {
		return this.perNroIdentificacion;
	}

	public void setPerNroIdentificacion(String perNroIdentificacion) {
		this.perNroIdentificacion = perNroIdentificacion;
	}

	public String getPerApellidos() {
		return this.perApellidos;
	}

	public void setPerApellidos(String perApellidos) {
		this.perApellidos = perApellidos;
	}

	public String getPerNombres() {
		return this.perNombres;
	}

	public void setPerNombres(String perNombres) {
		this.perNombres = perNombres;
	}

	public String getPerGenero() {
		return this.perGenero;
	}

	public void setPerGenero(String perGenero) {
		this.perGenero = perGenero;
	}

	public Date getPerFechaNacimiento() {
		return this.perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public String getPerCallePrincipal() {
		return this.perCallePrincipal;
	}

	public void setPerCallePrincipal(String perCallePrincipal) {
		this.perCallePrincipal = perCallePrincipal;
	}

	public String getPerNroCasa() {
		return this.perNroCasa;
	}

	public void setPerNroCasa(String perNroCasa) {
		this.perNroCasa = perNroCasa;
	}

	public String getPerCalleSecundaria() {
		return this.perCalleSecundaria;
	}

	public void setPerCalleSecundaria(String perCalleSecundaria) {
		this.perCalleSecundaria = perCalleSecundaria;
	}

	public String getPerReferencia() {
		return this.perReferencia;
	}

	public void setPerReferencia(String perReferencia) {
		this.perReferencia = perReferencia;
	}

	public String getPerNroPasaporte() {
		return this.perNroPasaporte;
	}

	public void setPerNroPasaporte(String perNroPasaporte) {
		this.perNroPasaporte = perNroPasaporte;
	}

	public Date getPerPasFechaEmision() {
		return this.perPasFechaEmision;
	}

	public void setPerPasFechaEmision(Date perPasFechaEmision) {
		this.perPasFechaEmision = perPasFechaEmision;
	}

	public Date getPerPasFechaVencimiento() {
		return this.perPasFechaVencimiento;
	}

	public void setPerPasFechaVencimiento(Date perPasFechaVencimiento) {
		this.perPasFechaVencimiento = perPasFechaVencimiento;
	}

	public String getPerCasilla() {
		return this.perCasilla;
	}

	public void setPerCasilla(String perCasilla) {
		this.perCasilla = perCasilla;
	}

	public String getPerNroSeguroSocial() {
		return this.perNroSeguroSocial;
	}

	public void setPerNroSeguroSocial(String perNroSeguroSocial) {
		this.perNroSeguroSocial = perNroSeguroSocial;
	}

	public Date getPerFechaAfiliacionSeguro() {
		return this.perFechaAfiliacionSeguro;
	}

	public void setPerFechaAfiliacionSeguro(Date perFechaAfiliacionSeguro) {
		this.perFechaAfiliacionSeguro = perFechaAfiliacionSeguro;
	}

	public String getPerEliminado() {
		return this.perEliminado;
	}

	public void setPerEliminado(String perEliminado) {
		this.perEliminado = perEliminado;
	}

	public String getPerAdicionado() {
		return this.perAdicionado;
	}

	public void setPerAdicionado(String perAdicionado) {
		this.perAdicionado = perAdicionado;
	}

	public Date getPerFechaAdicion() {
		return this.perFechaAdicion;
	}

	public void setPerFechaAdicion(Date perFechaAdicion) {
		this.perFechaAdicion = perFechaAdicion;
	}

	public String getPerModificado() {
		return this.perModificado;
	}

	public void setPerModificado(String perModificado) {
		this.perModificado = perModificado;
	}

	public Date getPerFechaModificacion() {
		return this.perFechaModificacion;
	}

	public void setPerFechaModificacion(Date perFechaModificacion) {
		this.perFechaModificacion = perFechaModificacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof GthPersona)) {
			return false;
		}
		GthPersona other = (GthPersona) object;
		if ((this.perCodigo == null && other.perCodigo != null)
				|| (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.perCodigo != null) ? this.perCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "GthPersona[ perCodigo=" + this.perCodigo + " ]";
	}

}
