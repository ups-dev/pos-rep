package ec.edu.ups.pos.rep.data.entities.ped;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "PED_MALLA_TIPO_OFERTA", schema = "PED")
public class PedMallaTipoOferta extends EntitySuperclass {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "MTO_CODIGO", nullable = false)
	private Long mtoCodigo;

	@Basic(optional = false)
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@Basic(optional = false)
	@Column(name = "PEL_CODIGO_INICIAL", nullable = false)
	private Long pelCodigoInicial;

	@Column(name = "PEL_CODIGO_FINAL")
	private Long pelCodigoFinal;

	@Column(name = "MTO_VIGENTE", length = 1)
	private String mtoVigente;

	@Basic(optional = false)
	@Column(name = "MTO_OFERTA_SEMESTRE", nullable = false, length = 1)
	private String mtoOfertaSemestre;

	@JoinColumn(name = "MAL_CODIGO", referencedColumnName = "MAL_CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private PedMalla pedMalla;

	public PedMallaTipoOferta() {
	}

	public PedMallaTipoOferta(Long mtoCodigo) {
		this.mtoCodigo = mtoCodigo;
	}

	public PedMallaTipoOferta(Long mtoCodigo, Long estCodigo, Long pelCodigoInicial, String mtoOfertaSemestre) {
		this.mtoCodigo = mtoCodigo;
		this.estCodigo = estCodigo;
		this.pelCodigoInicial = pelCodigoInicial;
		this.mtoOfertaSemestre = mtoOfertaSemestre;
	}

	public Long getMtoCodigo() {
		return this.mtoCodigo;
	}

	public void setMtoCodigo(Long mtoCodigo) {
		this.mtoCodigo = mtoCodigo;
	}

	public Long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Long getPelCodigoInicial() {
		return this.pelCodigoInicial;
	}

	public void setPelCodigoInicial(Long pelCodigoInicial) {
		this.pelCodigoInicial = pelCodigoInicial;
	}

	public Long getPelCodigoFinal() {
		return this.pelCodigoFinal;
	}

	public void setPelCodigoFinal(Long pelCodigoFinal) {
		this.pelCodigoFinal = pelCodigoFinal;
	}

	public String getMtoVigente() {
		return this.mtoVigente;
	}

	public void setMtoVigente(String mtoVigente) {
		this.mtoVigente = mtoVigente;
	}

	public String getMtoOfertaSemestre() {
		return this.mtoOfertaSemestre;
	}

	public void setMtoOfertaSemestre(String mtoOfertaSemestre) {
		this.mtoOfertaSemestre = mtoOfertaSemestre;
	}

	public PedMalla getPedMalla() {
		return this.pedMalla;
	}

	public void setPedMalla(PedMalla pedMalla) {
		this.pedMalla = pedMalla;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PedMallaTipoOferta)) {
			return false;
		}
		PedMallaTipoOferta other = (PedMallaTipoOferta) object;
		if ((this.mtoCodigo == null && other.mtoCodigo != null)
				|| (this.mtoCodigo != null && !this.mtoCodigo.equals(other.mtoCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.mtoCodigo != null) ? this.mtoCodigo.hashCode() : 0;
		return hash;
	}

	@Override
	public String toString() {
		return "PedMallaTipoOferta[ mtoCodigo=" + this.mtoCodigo + " ]";
	}

}
