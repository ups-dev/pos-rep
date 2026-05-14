package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_CONVENIO", schema = "PED")
public class PedConvenio extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CON_CODIGO", nullable = false)
	private Long conCodigo;

	@Size(max = 200)
	@Column(name = "CON_PAR_PROFESIONAL", length = 200)
	private String conParProfesional;

	@Column(name = "CON_FECHA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date conFechaInicio;

	@Column(name = "CON_FECHA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date conFechaFin;

	@Size(max = 1)
	@Column(name = "CON_ESTADO", length = 1)
	private String conEstado;

	@Column(name = "INE_CODIGO")
	private Long ineCodigo;

	@Column(name = "EST_CODIGO")
	private Long estCodigo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedConvenio", fetch = FetchType.LAZY)
	private Collection<PedConvenioAnexo> pedConvenioAnexoCollection;

	@JoinColumn(name = "TIC_CODIGO", referencedColumnName = "TIC_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedTipoConvenio pedTipoConvenio;

	@JoinColumn(name = "PRE_NUMERO", referencedColumnName = "PRE_NUMERO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedProyectoEducacion pedProyectoEducacion;

	public PedConvenio() {
	}

	public PedConvenio(Long conCodigo) {
		this.conCodigo = conCodigo;
	}

	public Long getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Long conCodigo) {
		this.conCodigo = conCodigo;
	}

	public String getConParProfesional() {
		return this.conParProfesional;
	}

	public void setConParProfesional(String conParProfesional) {
		this.conParProfesional = conParProfesional;
	}

	public Date getConFechaInicio() {
		return this.conFechaInicio;
	}

	public void setConFechaInicio(Date conFechaInicio) {
		this.conFechaInicio = conFechaInicio;
	}

	public Date getConFechaFin() {
		return this.conFechaFin;
	}

	public void setConFechaFin(Date conFechaFin) {
		this.conFechaFin = conFechaFin;
	}

	public String getConEstado() {
		return this.conEstado;
	}

	public void setConEstado(String conEstado) {
		this.conEstado = conEstado;
	}

	public Long getIneCodigo() {
		return this.ineCodigo;
	}

	public void setIneCodigo(Long ineCodigo) {
		this.ineCodigo = ineCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Collection<PedConvenioAnexo> getPedConvenioAnexoCollection() {
		return this.pedConvenioAnexoCollection;
	}

	public void setPedConvenioAnexoCollection(Collection<PedConvenioAnexo> pedConvenioAnexoCollection) {
		this.pedConvenioAnexoCollection = pedConvenioAnexoCollection;
	}

	public PedTipoConvenio getPedTipoConvenio() {
		return this.pedTipoConvenio;
	}

	public void setPedTipoConvenio(PedTipoConvenio pedTipoConvenio) {
		this.pedTipoConvenio = pedTipoConvenio;
	}

	public PedProyectoEducacion getPedProyectoEducacion() {
		return this.pedProyectoEducacion;
	}

	public void setPedProyectoEducacion(PedProyectoEducacion pedProyectoEducacion) {
		this.pedProyectoEducacion = pedProyectoEducacion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedConvenio)) {
			return false;
		}
		PedConvenio other = (PedConvenio) object;
		if ((this.conCodigo == null && other.conCodigo != null)
				|| (this.conCodigo != null && !this.conCodigo.equals(other.conCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.conCodigo != null) ? this.conCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedConvenio[ conCodigo=" + this.conCodigo + " ]";
	}

}
