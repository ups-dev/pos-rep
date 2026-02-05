package ec.edu.ups.pos.rep.logic.sessions.org;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pos.rep.data.entities.org.OrgEstructura;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

@Stateless
public class OrgEstructuraFacade extends AbstractFacade<OrgEstructura> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public OrgEstructuraFacade() {
		super(OrgEstructura.class);
	}

	public List<OrgEstructura> obtenerEstructuraAlumno(String alu_codigo) {
		String sql = " SELECT estCarrera.*" + " FROM INS.INS_ALUMNO alu "
				+ "     inner join INS.INS_INSCRIPCION insc on alu.ALU_CODIGO = insc.ALU_CODIGO"
				+ "     inner join INS.INS_OFERTA_INSCRIPCION_INICIAL oii on insc.OII_CODIGO = oii.OII_CODIGO"
				+ "     inner join ORG.ORG_ESTRUCTURA estCarrera on estCarrera.EST_CODIGO = oii.EST_CODIGO"
				+ "     inner join ORG.ORG_DESCRIPCION_ESTRUCTURA deeCarrera on deeCarrera.DEE_CODIGO = estCarrera.DEE_CODIGO"
				+ " WHERE alu.ALU_CODIGO = " + alu_codigo;
		Query q = this.em.createNativeQuery(sql, OrgEstructura.class);
		return q.getResultList();
	}

	// Obtiene la lista de OrgEstructuraSede
	public List<OrgEstructura> listaEstructuraSedeActivo() {
		Query q = getEntityManager().createQuery(
				"SELECT t FROM OrgEstructura t WHERE t.orgDescripcionEstructura.tieCodigo = 2L AND t.audEliminado = 'N' ORDER BY t.estCodigo ");

		return q.getResultList();
	}

	// Obtiene la lista de OrgEstructuraCampus
	public List<OrgEstructura> listaEstructuraCampusActivo(OrgEstructura orgEstructuraSede) {
		Query q = getEntityManager().createQuery(
				"SELECT t FROM OrgEstructura t WHERE t.orgEstructuraPadre= :orgEstructuraSede AND t.orgDescripcionEstructura.tieCodigo IN (3L,4L) AND t.audEliminado = 'N' ORDER BY t.estCodigo ")
			.setParameter("orgEstructuraSede", orgEstructuraSede);

		return q.getResultList();
	}

	// Obtiene la lista de OrgEstructuraCarrera seleccionado un campus y todos las
	// carreras
	public List<OrgEstructura> listaEstructuraCarreraSelecActivo(OrgEstructura orgEstructuraCampus) {
		Query q = getEntityManager().createQuery(
				"SELECT t FROM OrgEstructura t WHERE t.orgEstructuraPadre= :orgEstructuraCampus AND t.orgDescripcionEstructura.orgTipoEstructura.tieCodigo = 5L AND t.audEliminado = 'N' ORDER BY t.orgDescripcionEstructura.deeDescripcion ASC ")
			.setParameter("orgEstructuraCampus", orgEstructuraCampus);

		return q.getResultList();
	}

	// Obtiene la lista de OrgEstructuraPostGrado seleccionado un campus y todos las
	// carreras
	public List<OrgEstructura> listaEstructuraPostGradoSelecActivo(OrgEstructura orgEstructuraCampus) {
		Query q = getEntityManager().createQuery(
				"SELECT t FROM OrgEstructura t WHERE t.orgEstructuraPadre= :orgEstructuraCampus AND t.orgDescripcionEstructura.orgTipoEstructura.tieCodigo = 6L AND t.audEliminado = 'N' ORDER BY t.orgDescripcionEstructura.deeDescripcion ASC")
			.setParameter("orgEstructuraCampus", orgEstructuraCampus);

		return q.getResultList();
	}

	public List<OrgEstructura> listaEstructuraDoctoradoSelecActivo(OrgEstructura orgEstructuraCampus) {
		Query q = getEntityManager().createQuery(
				"SELECT t FROM OrgEstructura t WHERE t.orgEstructuraPadre= :orgEstructuraCampus AND t.orgDescripcionEstructura.orgTipoEstructura.tieCodigo = 18L AND t.audEliminado = 'N' ORDER BY t.orgDescripcionEstructura.deeDescripcion ASC")
			.setParameter("orgEstructuraCampus", orgEstructuraCampus);

		return q.getResultList();
	}

	public List<OrgEstructura> obtenerEstructuraPosgradoAlumno(String alu_codigo) {

		String sql = " SELECT distinct  pos.*    " + " FROM ins.ins_inscripcion inc,   "
				+ "     ins.ins_oferta_inscripcion_inicial oii,   " + "     ins.ins_ins_pro_aca                ipa,  "
				+ "     org.org_estructura                 pos,  " + "     fac.fac_pago_factura               paf   "
				+ " WHERE inc.oii_codigo = oii.oii_codigo   " + " AND   oii.est_codigo = pos.est_codigo   "
				+ " AND   inc.aud_eliminado      = 'N'    " + " AND   inc.ins_anulado        = 'N'    "
				+ " AND   ipa.aud_eliminado      = 'N'   " + " AND   inc.ins_aprobado       = 'S'  "
				+ " AND   inc.ins_codigo         = paf.ins_codigo  " + " AND   paf.paf_pagado         = 'S'  "
				+ " AND   paf.tip_codigo         = 8    " + " AND   ipa.ins_codigo         = inc.ins_codigo   "
				+ " AND   ipa.ipa_vigente        = 'S'  " + " AND   ipa.aud_eliminado      = 'N'  "
				+ " AND   inc.alu_codigo         = " + alu_codigo;

		Query q = this.em.createNativeQuery(sql, OrgEstructura.class);
		return q.getResultList();
	}

	public List<OrgEstructura> obtenerEstructuraDoctoradoAlumno(String alu_codigo) {

		String sql = " SELECT distinct  pos.*    " + " FROM ins.ins_inscripcion inc,   "
				+ "     ins.ins_oferta_inscripcion_inicial oii,   " + "     ins.ins_ins_pro_aca                ipa,  "
				+ "     org.org_estructura                 pos,  " + "     fac.fac_pago_factura               paf   "
				+ " WHERE inc.oii_codigo = oii.oii_codigo   " + " AND   oii.est_codigo = pos.est_codigo   "
				+ " AND   inc.aud_eliminado      = 'N'    " + " AND   inc.ins_anulado        = 'N'    "
				+ " AND   ipa.aud_eliminado      = 'N'   " + " AND   inc.ins_aprobado       = 'S'  "
				+ " AND   inc.ins_codigo         = paf.ins_codigo  " + " AND   paf.paf_pagado         = 'S'  "
				+ " AND   paf.tip_codigo         = 13    " + " AND   ipa.ins_codigo         = inc.ins_codigo   "
				+ " AND   ipa.ipa_vigente        = 'S'  " + " AND   ipa.aud_eliminado      = 'N'  "
				+ " AND   inc.alu_codigo         = " + alu_codigo;

		Query q = this.em.createNativeQuery(sql, OrgEstructura.class);
		return q.getResultList();
	}

}
