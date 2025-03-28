package ec.edu.ups.pos.rep.data.entities.ped;

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
@Table(name = "PED_CDE_DEP", schema = "PED")
public class PedCdeDep extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CDD_CODIGO", nullable = false)
	private Long cddCodigo;

	@Column(name = "CDD_NIVEL_APROBACION")
	private Short cddNivelAprobacion;

	@Size(max = 1)
	@Column(name = "CDD_TITULO_TERMINAL", length = 1)
	private String cddTituloTerminal;

	@Size(max = 1)
	@Column(name = "CDD_NIVEL_TITULO", length = 1)
	private String cddNivelTitulo;

	@Size(max = 500)
	@Column(name = "CDD_MENCION", length = 500)
	private String cddMencion;

	@Size(max = 1)
	@Column(name = "CDD_HISTORICO", length = 1)
	private String cddHistorico;

	@Size(max = 1)
	@Column(name = "CDD_TRABAJO_GRADO", length = 1)
	private String cddTrabajoGrado;

	@JoinColumn(name = "CDE_CODIGO", referencedColumnName = "CDE_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedCamDesEst pedCamDesEst;

	@JoinColumn(name = "DEP_CODIGO", referencedColumnName = "DEP_CODIGO", nullable = false)
	@ManyToOne(optional = false)
	private PedDesEstProEdu pedDesEstProEdu;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedCdeDep", fetch = FetchType.EAGER)
	private Collection<PedMallaMencion> pedMallaMencionCollection;

	public PedCdeDep() {
	}

	public PedCdeDep(Long cddCodigo) {
		this.cddCodigo = cddCodigo;
	}

	public Long getCddCodigo() {
		return this.cddCodigo;
	}

	public void setCddCodigo(Long cddCodigo) {
		this.cddCodigo = cddCodigo;
	}

	public Short getCddNivelAprobacion() {
		return this.cddNivelAprobacion;
	}

	public void setCddNivelAprobacion(Short cddNivelAprobacion) {
		this.cddNivelAprobacion = cddNivelAprobacion;
	}

	public String getCddTituloTerminal() {
		return this.cddTituloTerminal;
	}

	public void setCddTituloTerminal(String cddTituloTerminal) {
		this.cddTituloTerminal = cddTituloTerminal;
	}

	public String getCddNivelTitulo() {
		return this.cddNivelTitulo;
	}

	public void setCddNivelTitulo(String cddNivelTitulo) {
		this.cddNivelTitulo = cddNivelTitulo;
	}

	public String getCddMencion() {
		return this.cddMencion;
	}

	public void setCddMencion(String cddMencion) {
		this.cddMencion = cddMencion;
	}

	public String getCddHistorico() {
		return this.cddHistorico;
	}

	public void setCddHistorico(String cddHistorico) {
		this.cddHistorico = cddHistorico;
	}

	public String getCddTrabajoGrado() {
		return this.cddTrabajoGrado;
	}

	public void setCddTrabajoGrado(String cddTrabajoGrado) {
		this.cddTrabajoGrado = cddTrabajoGrado;
	}

	public PedCamDesEst getPedCamDesEst() {
		return this.pedCamDesEst;
	}

	public void setPedCamDesEst(PedCamDesEst pedCamDesEst) {
		this.pedCamDesEst = pedCamDesEst;
	}

	public PedDesEstProEdu getPedDesEstProEdu() {
		return this.pedDesEstProEdu;
	}

	public void setPedDesEstProEdu(PedDesEstProEdu pedDesEstProEdu) {
		this.pedDesEstProEdu = pedDesEstProEdu;
	}

	public Collection<PedMallaMencion> getPedMallaMencionCollection() {
		return this.pedMallaMencionCollection;
	}

	public void setPedMallaMencionCollection(Collection<PedMallaMencion> pedMallaMencionCollection) {
		this.pedMallaMencionCollection = pedMallaMencionCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedCdeDep)) {
			return false;
		}
		PedCdeDep other = (PedCdeDep) object;
		if ((this.cddCodigo == null && other.cddCodigo != null)
				|| (this.cddCodigo != null && !this.cddCodigo.equals(other.cddCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.cddCodigo != null) ? this.cddCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedCdeDep[ cddCodigo=" + this.cddCodigo + " ]";
	}

}
