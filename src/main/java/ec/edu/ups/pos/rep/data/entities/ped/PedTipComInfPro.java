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
@Table(name = "PED_TIP_COM_INF_PRO", schema = "PED")
public class PedTipComInfPro extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TCI_CODIGO", nullable = false)
	private Long tciCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TCI_DESCRIPCION", nullable = false, length = 200)
	private String tciDescripcion;

	@Size(max = 1)
	@Column(name = "TCI_TIPO", length = 1)
	private String tciTipo;

	@OneToMany(mappedBy = "pedTipComInfPro", fetch = FetchType.LAZY)
	private Collection<PedComInfArc> pedComInfArcCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipComInfPro", fetch = FetchType.LAZY)
	private Collection<PedComInfEmp> pedComInfEmpCollection;

	@OneToMany(mappedBy = "pedTipComInfProPadre", fetch = FetchType.LAZY)
	private Collection<PedTipComInfPro> pedTipComInfProCollection;

	@JoinColumn(name = "TCI_CODIGO_PADRE", referencedColumnName = "TCI_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private PedTipComInfPro pedTipComInfProPadre;

	public PedTipComInfPro() {
	}

	public PedTipComInfPro(Long tciCodigo) {
		this.tciCodigo = tciCodigo;
	}

	public PedTipComInfPro(Long tciCodigo, String tciDescripcion) {
		this.tciCodigo = tciCodigo;
		this.tciDescripcion = tciDescripcion;
	}

	public Long getTciCodigo() {
		return this.tciCodigo;
	}

	public void setTciCodigo(Long tciCodigo) {
		this.tciCodigo = tciCodigo;
	}

	public String getTciDescripcion() {
		return this.tciDescripcion;
	}

	public void setTciDescripcion(String tciDescripcion) {
		this.tciDescripcion = tciDescripcion;
	}

	public String getTciTipo() {
		return this.tciTipo;
	}

	public void setTciTipo(String tciTipo) {
		this.tciTipo = tciTipo;
	}

	public Collection<PedComInfArc> getPedComInfArcCollection() {
		return this.pedComInfArcCollection;
	}

	public void setPedComInfArcCollection(Collection<PedComInfArc> pedComInfArcCollection) {
		this.pedComInfArcCollection = pedComInfArcCollection;
	}

	public Collection<PedComInfEmp> getPedComInfEmpCollection() {
		return this.pedComInfEmpCollection;
	}

	public void setPedComInfEmpCollection(Collection<PedComInfEmp> pedComInfEmpCollection) {
		this.pedComInfEmpCollection = pedComInfEmpCollection;
	}

	public Collection<PedTipComInfPro> getPedTipComInfProCollection() {
		return this.pedTipComInfProCollection;
	}

	public void setPedTipComInfProCollection(Collection<PedTipComInfPro> pedTipComInfProCollection) {
		this.pedTipComInfProCollection = pedTipComInfProCollection;
	}

	public PedTipComInfPro getPedTipComInfProPadre() {
		return this.pedTipComInfProPadre;
	}

	public void setPedTipComInfProPadre(PedTipComInfPro pedTipComInfProPadre) {
		this.pedTipComInfProPadre = pedTipComInfProPadre;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipComInfPro)) {
			return false;
		}
		PedTipComInfPro other = (PedTipComInfPro) object;
		if ((this.tciCodigo == null && other.tciCodigo != null)
				|| (this.tciCodigo != null && !this.tciCodigo.equals(other.tciCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tciCodigo != null) ? this.tciCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipComInfPro[ tciCodigo=" + this.tciCodigo + " ]";
	}

}
