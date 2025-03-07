package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_AUT_JOR_INS", schema = "INS")
@SequenceGenerator(name = "INS_AUT_JOR_INS_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsAutJorIns extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_AUT_JOR_INS_SQ")
	@Column(name = "AJO_CODIGO", nullable = false)
	private Long ajoCodigo;

	@Column(name = "PEL_CODIGO")
	private Long pelCodigo;

	@Column(name = "AJO_AUTORIZADO_POR", length = 50)
	private String ajoAutorizadoPor;

	@Column(name = "AJO_FECHA_AUTORIZACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ajoFechaAutorizacion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "AJO_TIPO", nullable = false, length = 1)
	private String ajoTipo;

	@JoinColumn(name = "INS_CODIGO", referencedColumnName = "INS_CODIGO")
	@ManyToOne
	private InsInscripcion insInscripcion;

	@JoinColumn(name = "JOR_CODIGO", referencedColumnName = "JOR_CODIGO")
	@ManyToOne
	private InsJornada insJornada;

	public InsAutJorIns() {
	}

	public InsAutJorIns(Long ajoCodigo) {
		this.ajoCodigo = ajoCodigo;
	}

	public Long getAjoCodigo() {
		return this.ajoCodigo;
	}

	public void setAjoCodigo(Long ajoCodigo) {
		this.ajoCodigo = ajoCodigo;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public String getAjoAutorizadoPor() {
		return this.ajoAutorizadoPor;
	}

	public void setAjoAutorizadoPor(String ajoAutorizadoPor) {
		this.ajoAutorizadoPor = ajoAutorizadoPor;
	}

	public Date getAjoFechaAutorizacion() {
		return this.ajoFechaAutorizacion;
	}

	public void setAjoFechaAutorizacion(Date ajoFechaAutorizacion) {
		this.ajoFechaAutorizacion = ajoFechaAutorizacion;
	}

	public InsInscripcion getInsInscripcion() {
		return this.insInscripcion;
	}

	public void setInsInscripcion(InsInscripcion insInscripcion) {
		this.insInscripcion = insInscripcion;
	}

	public InsJornada getInsJornada() {
		return this.insJornada;
	}

	public void setInsJornada(InsJornada insJornada) {
		this.insJornada = insJornada;
	}

	public String getAjoTipo() {
		return this.ajoTipo;
	}

	public void setAjoTipo(String ajoTipo) {
		this.ajoTipo = ajoTipo;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsAutJorIns)) {
			return false;
		}
		InsAutJorIns other = (InsAutJorIns) object;
		if ((this.ajoCodigo == null && other.ajoCodigo != null)
				|| (this.ajoCodigo != null && !this.ajoCodigo.equals(other.ajoCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.ajoCodigo != null) ? this.ajoCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsAutJorIns[ ajoCodigo=" + this.ajoCodigo + " ]";
	}

}
