package ec.edu.ups.pos.rep.data.entities.ins;

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

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_RESERVA_EXAMEN", schema = "INS")
public class InsReservaExamen extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "REE_CODIGO", nullable = false)
	private Long reeCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO", nullable = false)
	private Long pelCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "ESF_CODIGO", nullable = false)
	private Long esfCodigo;

	@Column(name = "REE_CUPO")
	private Long reeCupo;

	@Column(name = "REE_CUPO_UTILIZADO")
	private Long reeCupoUtilizado;

	@Column(name = "REE_FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reeFecha;

	@Column(name = "REE_HORA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reeHoraInicio;

	@Column(name = "REE_HORA_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reeHoraFin;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insReservaExamen", fetch = FetchType.LAZY)
	private Collection<InsExamen> insExamenCollection;

	@JoinColumn(name = "TIE_CODIGO", referencedColumnName = "TIE_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsTipoExamen insTipoExamen;

	@JoinColumn(name = "JOR_CODIGO", referencedColumnName = "JOR_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsJornada insJornada;

	public InsReservaExamen() {
	}

	public InsReservaExamen(Long reeCodigo) {
		this.reeCodigo = reeCodigo;
	}

	public Long getReeCodigo() {
		return this.reeCodigo;
	}

	public void setReeCodigo(Long reeCodigo) {
		this.reeCodigo = reeCodigo;
	}

	public Long getPelCodigo() {
		return this.pelCodigo;
	}

	public void setPelCodigo(Long pelCodigo) {
		this.pelCodigo = pelCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getEsfCodigo() {
		return this.esfCodigo;
	}

	public void setEsfCodigo(Long esfCodigo) {
		this.esfCodigo = esfCodigo;
	}

	public Long getReeCupo() {
		return this.reeCupo;
	}

	public void setReeCupo(Long reeCupo) {
		this.reeCupo = reeCupo;
	}

	public Long getReeCupoUtilizado() {
		return this.reeCupoUtilizado;
	}

	public void setReeCupoUtilizado(Long reeCupoUtilizado) {
		this.reeCupoUtilizado = reeCupoUtilizado;
	}

	public Date getReeFecha() {
		return this.reeFecha;
	}

	public void setReeFecha(Date reeFecha) {
		this.reeFecha = reeFecha;
	}

	public Date getReeHoraInicio() {
		return this.reeHoraInicio;
	}

	public void setReeHoraInicio(Date reeHoraInicio) {
		this.reeHoraInicio = reeHoraInicio;
	}

	public Date getReeHoraFin() {
		return this.reeHoraFin;
	}

	public void setReeHoraFin(Date reeHoraFin) {
		this.reeHoraFin = reeHoraFin;
	}

	public Collection<InsExamen> getInsExamenCollection() {
		return this.insExamenCollection;
	}

	public void setInsExamenCollection(Collection<InsExamen> insExamenCollection) {
		this.insExamenCollection = insExamenCollection;
	}

	public InsTipoExamen getInsTipoExamen() {
		return this.insTipoExamen;
	}

	public void setInsTipoExamen(InsTipoExamen insTipoExamen) {
		this.insTipoExamen = insTipoExamen;
	}

	public InsJornada getInsJornada() {
		return this.insJornada;
	}

	public void setInsJornada(InsJornada insJornada) {
		this.insJornada = insJornada;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsReservaExamen)) {
			return false;
		}
		InsReservaExamen other = (InsReservaExamen) object;
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
		return "InsReservaExamen[ reeCodigo=" + this.reeCodigo + " ]";
	}

}
