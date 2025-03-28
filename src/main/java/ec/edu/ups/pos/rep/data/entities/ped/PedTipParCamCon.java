package ec.edu.ups.pos.rep.data.entities.ped;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_TIP_PAR_CAM_CON", schema = "PED")
public class PedTipParCamCon extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "TPC_CODIGO", nullable = false)
	private Long tpcCodigo;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TPC_DESCRIPCION", nullable = false, length = 200)
	private String tpcDescripcion;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "TPC_TIPO", nullable = false, length = 1)
	private String tpcTipo;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "pedTipParCamCon", fetch = FetchType.LAZY)
	private Collection<PedTpcCamCon> pedTpcCamConCollection;

	public PedTipParCamCon() {
	}

	public PedTipParCamCon(Long tpcCodigo) {
		this.tpcCodigo = tpcCodigo;
	}

	public PedTipParCamCon(Long tpcCodigo, String tpcDescripcion, String tpcTipo) {
		this.tpcCodigo = tpcCodigo;
		this.tpcDescripcion = tpcDescripcion;
		this.tpcTipo = tpcTipo;
	}

	public Long getTpcCodigo() {
		return this.tpcCodigo;
	}

	public void setTpcCodigo(Long tpcCodigo) {
		this.tpcCodigo = tpcCodigo;
	}

	public String getTpcDescripcion() {
		return this.tpcDescripcion;
	}

	public void setTpcDescripcion(String tpcDescripcion) {
		this.tpcDescripcion = tpcDescripcion;
	}

	public String getTpcTipo() {
		return this.tpcTipo;
	}

	public void setTpcTipo(String tpcTipo) {
		this.tpcTipo = tpcTipo;
	}

	public Collection<PedTpcCamCon> getPedTpcCamConCollection() {
		return this.pedTpcCamConCollection;
	}

	public void setPedTpcCamConCollection(Collection<PedTpcCamCon> pedTpcCamConCollection) {
		this.pedTpcCamConCollection = pedTpcCamConCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedTipParCamCon)) {
			return false;
		}
		PedTipParCamCon other = (PedTipParCamCon) object;
		if ((this.tpcCodigo == null && other.tpcCodigo != null)
				|| (this.tpcCodigo != null && !this.tpcCodigo.equals(other.tpcCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.tpcCodigo != null) ? this.tpcCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedTipParCamCon[ tpcCodigo=" + this.tpcCodigo + " ]";
	}

}
