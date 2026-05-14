package ec.edu.ups.pos.rep.data.entities.aseg;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "ASEG_MENU", schema = "ASEG", uniqueConstraints = { @UniqueConstraint(columnNames = { "SEC_CODIGO" }) })
public class AsegMenu extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "MEN_CODIGO", nullable = false)
	private Long menCodigo;

	@Column(name = "MEN_ORDEN")
	private Integer menOrden;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "MEN_ETIQUETA", nullable = false, length = 100)
	private String menEtiqueta;

	@Column(name = "MEN_NIVEL")
	private Integer menNivel;

	@OneToMany(mappedBy = "asegMenuPadre", fetch = FetchType.LAZY)
	private Collection<AsegMenu> asegMenuCollection;

	@JoinColumn(name = "MEN_PADRE", referencedColumnName = "MEN_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private AsegMenu asegMenuPadre;

	@JoinColumn(name = "SEC_CODIGO", referencedColumnName = "SEC_CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	private AsegSeccion asegSeccion;

	public AsegMenu() {
		// default implementation ignored
	}

	public AsegMenu(Long menCodigo, String menEtiqueta) {
		this.menCodigo = menCodigo;
		this.menEtiqueta = menEtiqueta;
	}

	public Long getMenCodigo() {
		return this.menCodigo;
	}

	public void setMenCodigo(Long menCodigo) {
		this.menCodigo = menCodigo;
	}

	public Integer getMenOrden() {
		return this.menOrden;
	}

	public void setMenOrden(Integer menOrden) {
		this.menOrden = menOrden;
	}

	public String getMenEtiqueta() {
		return this.menEtiqueta;
	}

	public void setMenEtiqueta(String menEtiqueta) {
		this.menEtiqueta = menEtiqueta;
	}

	public Integer getMenNivel() {
		return this.menNivel;
	}

	public void setMenNivel(Integer menNivel) {
		this.menNivel = menNivel;
	}

	public Collection<AsegMenu> getAsegMenuCollection() {
		return this.asegMenuCollection;
	}

	public void setAsegMenuCollection(Collection<AsegMenu> asegMenuCollection) {
		this.asegMenuCollection = asegMenuCollection;
	}

	public AsegMenu getAsegMenuPadre() {
		return this.asegMenuPadre;
	}

	public void setAsegMenuPadre(AsegMenu asegMenuPadre) {
		this.asegMenuPadre = asegMenuPadre;
	}

	public AsegSeccion getAsegSeccion() {
		return this.asegSeccion;
	}

	public void setAsegSeccion(AsegSeccion asegSeccion) {
		this.asegSeccion = asegSeccion;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AsegMenu)) {
			return false;
		}
		AsegMenu other = (AsegMenu) object;
		return !((this.menCodigo == null && other.menCodigo != null)
				|| (this.menCodigo != null && !this.menCodigo.equals(other.menCodigo)));
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.menCodigo != null) ? this.menCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return String.format("AsegMenu[%d]", this.menCodigo);
	}

}
