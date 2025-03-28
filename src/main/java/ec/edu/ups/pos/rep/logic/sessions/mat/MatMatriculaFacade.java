package ec.edu.ups.pos.rep.logic.sessions.mat;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Description.
 *
 * @author UPS .
 */
@Stateless
public class MatMatriculaFacade implements Serializable {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return this.em;
	}

	public MatMatriculaFacade() {

	}

	public List<String> obtieneSemestre(Long aluCodigo) {
		Query q = getEntityManager()
			.createNativeQuery("select distinct pee.pee_nivel  semestre " + "from   mat.mat_matricula    mta, "
					+ "       fac.fac_pago_factura paf, " + "       ins.ins_inscripcion  inc, "
					+ "       org.org_periodo_estructura pee " + "where mta.mat_codigo   = paf.ins_codigo "
					+ "and   mta.mat_tipo_proceso = 'M' " + "and   paf.tip_codigo    = 4 "
					+ "and   mta.aud_eliminado = 'N' " + "and   paf.paf_pagado    = 'S' "
					+ "and   inc.ins_codigo    = mta.ins_codigo " + "and   inc.alu_codigo    = ?1 "
					+ "and   mta.pee_codigo    = pee.pee_codigo " + "order by semestre ")
			.setParameter(1, aluCodigo);
		return q.getResultList();
	}

}
