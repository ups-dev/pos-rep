package ec.edu.ups.pos.rep.data.entities.ins;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_OFERTA_INSCRIPCION_INICIAL", schema = "INS")
@SequenceGenerator(name = "INS_OFE_INS_INI_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsOfertaInscripcionInicial extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_OFE_INS_INI_SQ")
	@NotNull
	@Column(name = "OII_CODIGO", nullable = false)
	private Long oiiCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "MOD_CODIGO", nullable = false)
	private Long modCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "PEL_CODIGO", nullable = false)
	private Long pelCodigo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Column(name = "OII_CUPO")
	private Long oiiCupo;

	@JoinColumn(name = "JOR_CODIGO", referencedColumnName = "JOR_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private InsJornada insJornada;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insOfertaInscripcionInicial", fetch = FetchType.LAZY)
	private Collection<InsInscripcion> insInscripcionCollection;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
			mappedBy = "insOfertaInscripcionInicial", fetch = FetchType.LAZY)
	private Collection<InsSancion> insSancionCollection;

	@Column(name = "OII_TIPO_OFERTA", length = 1)
	private String oiiTipoOferta;

	public InsOfertaInscripcionInicial() {
	}

	public InsOfertaInscripcionInicial(Long oiiCodigo) {
		this.oiiCodigo = oiiCodigo;
	}

	public Long getOiiCodigo() {
		return this.oiiCodigo;
	}

	public void setOiiCodigo(Long oiiCodigo) {
		this.oiiCodigo = oiiCodigo;
	}

	public Long getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Long modCodigo) {
		this.modCodigo = modCodigo;
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

	public Long getOiiCupo() {
		return this.oiiCupo;
	}

	public void setOiiCupo(Long oiiCupo) {
		this.oiiCupo = oiiCupo;
	}

	public InsJornada getInsJornada() {
		return this.insJornada;
	}

	public void setInsJornada(InsJornada insJornada) {
		this.insJornada = insJornada;
	}

	public Collection<InsSancion> getInsSancionCollection() {
		return this.insSancionCollection;
	}

	public void setInsSancionCollection(Collection<InsSancion> insSancionCollection) {
		this.insSancionCollection = insSancionCollection;
	}

	public Collection<InsInscripcion> getInsInscripcionCollection() {
		return this.insInscripcionCollection;
	}

	public void setInsInscripcionCollection(Collection<InsInscripcion> insInscripcionCollection) {
		this.insInscripcionCollection = insInscripcionCollection;
	}

	public String getOiiTipoOferta() {
		return this.oiiTipoOferta;
	}

	public void setOiiTipoOferta(String oiiTipoOferta) {
		this.oiiTipoOferta = oiiTipoOferta;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InsOfertaInscripcionInicial)) {
			return false;
		}
		InsOfertaInscripcionInicial other = (InsOfertaInscripcionInicial) object;
		if ((this.oiiCodigo == null && other.oiiCodigo != null)
				|| (this.oiiCodigo != null && !this.oiiCodigo.equals(other.oiiCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.oiiCodigo != null) ? this.oiiCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "InsOfertaInscripcionInicial[ oiiCodigo=" + this.oiiCodigo + " ]";
	}

}
