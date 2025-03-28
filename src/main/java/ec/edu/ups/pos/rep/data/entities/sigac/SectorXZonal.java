package ec.edu.ups.pos.rep.data.entities.sigac;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Description.
 *
 * @author DQUISI .
 */
@Entity
@Table(name = "SECTOR_X_ZONAL", catalog = "", schema = "SIGAC")
@NamedQueries({ @NamedQuery(name = "SectorXZonal.findAll", query = "SELECT s FROM SectorXZonal s") })
public class SectorXZonal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false, fetch = FetchType.LAZY)
	@Size(min = 1, max = 3)
	@Column(name = "SCVN_CDG", nullable = false, length = 3)
	private String scvnCdg;

	@Basic(optional = false, fetch = FetchType.LAZY)
	@Size(min = 1, max = 30)
	@Column(name = "SCVN_NMB", nullable = false, length = 30)
	private String scvnNmb;

	@Basic(optional = false, fetch = FetchType.LAZY)
	@Column(name = "ZOAC_CDG", nullable = false)
	private short zoacCdg;

	@Basic(fetch = FetchType.LAZY)
	@Size(max = 3)
	@Column(name = "OFTS_CDG", length = 3)
	private String oftsCdg;

	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "sectorXZonal", fetch = FetchType.LAZY)
	private Collection<ClienteLocal> clienteLocalCollection;

	public SectorXZonal() {
	}

	public SectorXZonal(String scvnCdg) {
		this.scvnCdg = scvnCdg;
	}

	public SectorXZonal(String scvnCdg, String scvnNmb, short zoacCdg) {
		this.scvnCdg = scvnCdg;
		this.scvnNmb = scvnNmb;
		this.zoacCdg = zoacCdg;
	}

	public String getScvnCdg() {
		return this.scvnCdg;
	}

	public void setScvnCdg(String scvnCdg) {
		this.scvnCdg = scvnCdg;
	}

	public String getScvnNmb() {
		return this.scvnNmb;
	}

	public void setScvnNmb(String scvnNmb) {
		this.scvnNmb = scvnNmb;
	}

	public short getZoacCdg() {
		return this.zoacCdg;
	}

	public void setZoacCdg(short zoacCdg) {
		this.zoacCdg = zoacCdg;
	}

	public String getOftsCdg() {
		return this.oftsCdg;
	}

	public void setOftsCdg(String oftsCdg) {
		this.oftsCdg = oftsCdg;
	}

	public Collection<ClienteLocal> getClienteLocalCollection() {
		return this.clienteLocalCollection;
	}

	public void setClienteLocalCollection(Collection<ClienteLocal> clienteLocalCollection) {
		this.clienteLocalCollection = clienteLocalCollection;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SectorXZonal)) {
			return false;
		}
		SectorXZonal other = (SectorXZonal) object;
		if ((this.scvnCdg == null && other.scvnCdg != null)
				|| (this.scvnCdg != null && !this.scvnCdg.equals(other.scvnCdg))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ((this.scvnCdg != null) ? this.scvnCdg.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder descripcion = new StringBuilder();
		descripcion.append(this.scvnCdg).append(" - ").append(this.scvnNmb);
		return descripcion.toString();
	}

}
