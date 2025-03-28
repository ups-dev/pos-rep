package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_REQUISITO_ESTRUCTURA", schema = "INS")
public class InsRequisitoEstructura extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "REE_CODIGO", nullable = false)
	private Long reeCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Column(name = "PEL_CODIGO_INI")
	private Long pelCodigoIni;

	@Column(name = "PEL_CODIGO_FIN")
	private Long pelCodigoFin;

	@Size(max = 1)
	@Column(name = "REE_OBLIGATORIO", length = 1)
	private String reeObligatorio;

	@Size(max = 1)
	@Column(name = "REE_VALIDAR_DOCUMENTACION", length = 1)
	private String reeValidarDocumentacion;

	@Size(max = 1)
	@Column(name = "REE_OBL_PRIMERA", length = 1)
	private String reeOblPrimera;

	@Size(max = 1)
	@Column(name = "REE_OBL_SEGUNDA", length = 1)
	private String reeOblSegunda;

	@Basic(optional = false)
	@Size(max = 1)
	@Column(name = "REE_TIPO", length = 1, nullable = false)
	private String reeTipo;

	@Column(name = "REE_DESCRIPCION", length = 450)
	private String reeDescripcion;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insRequisitoEstructura", fetch = FetchType.LAZY)
	private Collection<InsReqEstIns> insReqEstInsCollection;

	@JoinColumn(name = "TII_CODIGO", referencedColumnName = "TII_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private InsTipoInscripcion insTipoInscripcion;

	@JoinColumn(name = "REQ_CODIGO", referencedColumnName = "REQ_CODIGO", nullable = true)
	@ManyToOne(optional = true)
	private InsRequisito insRequisito;

	@OneToMany(mappedBy = "insRequisitoEstructuraPadre")
	private Collection<InsRequisitoEstructura> insRequisitoEstructuraCollection;

	@JoinColumn(name = "REE_CODIGO_PADRE", referencedColumnName = "REE_CODIGO")
	@ManyToOne
	private InsRequisitoEstructura insRequisitoEstructuraPadre;

	@Column(name = "REE_OBLIGATORIO_INS", length = 1)
	private String reeObligatorio_ins;

	@Size(max = 1)
	@Column(name = "REE_TIPO_NACIONALIDAD", length = 1)
	private String reeTipoNacionalidad;

	@Size(max = 1)
	@Column(name = "REE_TIPO_REQUISITO", length = 1)
	private String reeTipoRequisito;

	@Size(max = 1)
	@Column(name = "REE_MOSTRAR_REQUISITO", length = 1)
	private String reeMostrarRequisito;

	@Size(max = 1)
	@Column(name = "REE_RESIDENCIA", length = 1)
	private String reeResidencia;

	public InsRequisitoEstructura() {
	}

	public InsRequisitoEstructura(Long reeCodigo) {
		this.reeCodigo = reeCodigo;
	}

	public String getReeDescripcion() {
		return this.reeDescripcion;
	}

	public void setReeDescripcion(String reeDescripcion) {
		this.reeDescripcion = reeDescripcion;
	}

	public InsRequisitoEstructura getInsRequisitoEstructuraPadre() {
		return this.insRequisitoEstructuraPadre;
	}

	public void setInsRequisitoEstructuraPadre(InsRequisitoEstructura insRequisitoEstructuraPadre) {
		this.insRequisitoEstructuraPadre = insRequisitoEstructuraPadre;
	}

	public String getReeValidarDocumentacion() {
		return this.reeValidarDocumentacion;
	}

	public void setReeValidarDocumentacion(String reeValidarDocumentacion) {
		this.reeValidarDocumentacion = reeValidarDocumentacion;
	}

	public Collection<InsRequisitoEstructura> getInsRequisitoEstructuraCollection() {
		return this.insRequisitoEstructuraCollection;
	}

	public void setInsRequisitoEstructuraCollection(
			Collection<InsRequisitoEstructura> insRequisitoEstructuraCollection) {
		this.insRequisitoEstructuraCollection = insRequisitoEstructuraCollection;
	}

	public Long getReeCodigo() {
		return this.reeCodigo;
	}

	public void setReeCodigo(Long reeCodigo) {
		this.reeCodigo = reeCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getReeObligatorio() {
		return this.reeObligatorio;
	}

	public void setReeObligatorio(String reeObligatorio) {
		this.reeObligatorio = reeObligatorio;
	}

	public Collection<InsReqEstIns> getInsReqEstInsCollection() {
		return this.insReqEstInsCollection;
	}

	public void setInsReqEstInsCollection(Collection<InsReqEstIns> insReqEstInsCollection) {
		this.insReqEstInsCollection = insReqEstInsCollection;
	}

	public InsTipoInscripcion getInsTipoInscripcion() {
		return this.insTipoInscripcion;
	}

	public void setInsTipoInscripcion(InsTipoInscripcion insTipoInscripcion) {
		this.insTipoInscripcion = insTipoInscripcion;
	}

	public InsRequisito getInsRequisito() {
		return this.insRequisito;
	}

	public void setInsRequisito(InsRequisito insRequisito) {
		this.insRequisito = insRequisito;
	}

	public String getReeTipo() {
		return this.reeTipo;
	}

	public void setReeTipo(String reeTipo) {
		this.reeTipo = reeTipo;
	}

	public Long getPelCodigoIni() {
		return this.pelCodigoIni;
	}

	public void setPelCodigoIni(Long pelCodigoIni) {
		this.pelCodigoIni = pelCodigoIni;
	}

	public Long getPelCodigoFin() {
		return this.pelCodigoFin;
	}

	public void setPelCodigoFin(Long pelCodigoFin) {
		this.pelCodigoFin = pelCodigoFin;
	}

	public String getReeOblPrimera() {
		return this.reeOblPrimera;
	}

	public void setReeOblPrimera(String reeOblPrimera) {
		this.reeOblPrimera = reeOblPrimera;
	}

	public String getReeOblSegunda() {
		return this.reeOblSegunda;
	}

	public void setReeOblSegunda(String reeOblSegunda) {
		this.reeOblSegunda = reeOblSegunda;
	}

	public String getReeObligatorio_ins() {
		return this.reeObligatorio_ins;
	}

	public void setReeObligatorio_ins(String reeObligatorio_ins) {
		this.reeObligatorio_ins = reeObligatorio_ins;
	}

	public String getReeTipoNacionalidad() {
		return this.reeTipoNacionalidad;
	}

	public void setReeTipoNacionalidad(String reeTipoNacionalidad) {
		this.reeTipoNacionalidad = reeTipoNacionalidad;
	}

	public String getReeTipoRequisito() {
		return this.reeTipoRequisito;
	}

	public void setReeTipoRequisito(String reeTipoRequisito) {
		this.reeTipoRequisito = reeTipoRequisito;
	}

	public String getReeMostrarRequisito() {
		return this.reeMostrarRequisito;
	}

	public void setReeMostrarRequisito(String reeMostrarRequisito) {
		this.reeMostrarRequisito = reeMostrarRequisito;
	}

	public String getReeResidencia() {
		return this.reeResidencia;
	}

	public void setReeResidencia(String reeResidencia) {
		this.reeResidencia = reeResidencia;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsRequisitoEstructura)) {
			return false;
		}
		InsRequisitoEstructura other = (InsRequisitoEstructura) object;
		if ((this.reeCodigo == null && other.reeCodigo != null)
				|| (this.reeCodigo != null && !this.reeCodigo.equals(other.reeCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.reeCodigo != null) ? this.reeCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsRequisitoEstructura[ reeCodigo=" + this.reeCodigo + " ]";
	}

}
