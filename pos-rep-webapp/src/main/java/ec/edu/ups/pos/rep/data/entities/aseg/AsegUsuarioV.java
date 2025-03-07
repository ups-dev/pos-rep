package ec.edu.ups.pos.rep.data.entities.aseg;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ASEG_USUARIO_V", schema = "ASEG")
public class AsegUsuarioV implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PER_CODIGO", nullable = false)
	@Id
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

	@Size(max = 50)
	@Column(name = "MAI_DIRECCION", length = 50)
	private String maiDireccion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "EME_ESTADO", nullable = false, length = 1)
	private String emeEstado;

	public AsegUsuarioV() {
		// default implementation ignored
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

	public String getMaiDireccion() {
		return this.maiDireccion;
	}

	public void setMaiDireccion(String maiDireccion) {
		this.maiDireccion = maiDireccion;
	}

	public String getEmeEstado() {
		return this.emeEstado;
	}

	public void setEmeEstado(String emeEstado) {
		this.emeEstado = emeEstado;
	}

}
