package ec.edu.ups.pos.rep.data.entities.ins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.edu.ups.util.jpa.EntitySuperclass;

@Entity
@Table(name = "INS_OFERTA_INSCRIPCION")
@SequenceGenerator(name = "INS_OFERTA_INSCRIPCION_SQ", initialValue = 1, allocationSize = 1, schema = "INS")
public class InsOfertaInscripcion extends EntitySuperclass {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INS_OFERTA_INSCRIPCION_SQ")
	@NotNull
	@Column(name = "OFI_CODIGO", nullable = false)
	private Integer id;

	@Column(name = "OFI_VIGENTE", nullable = false, length = 1)
	private String ofiVigente;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OII_CODIGO", nullable = false)
	private InsOfertaInscripcionInicial oiiCodigo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "INS_CODIGO", nullable = false)
	private InsInscripcion insCodigo;

	public InsInscripcion getInsCodigo() {
		return this.insCodigo;
	}

	public void setInsCodigo(InsInscripcion insCodigo) {
		this.insCodigo = insCodigo;
	}

	public InsOfertaInscripcionInicial getOiiCodigo() {
		return this.oiiCodigo;
	}

	public void setOiiCodigo(InsOfertaInscripcionInicial oiiCodigo) {
		this.oiiCodigo = oiiCodigo;
	}

	public String getOfiVigente() {
		return this.ofiVigente;
	}

	public void setOfiVigente(String ofiVigente) {
		this.ofiVigente = ofiVigente;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
