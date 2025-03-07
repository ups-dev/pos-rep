package ec.edu.ups.pos.rep.logic.sessions.rep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pos.rep.data.entities.rep.RepReportesSistema;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author ups .
 */
@Stateless
public class RepReportesSistemaFacade extends AbstractFacade<RepReportesSistema> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public RepReportesSistemaFacade() {
		super(RepReportesSistema.class);
	}

	// Obtiene la lista de docentes de GthPersona y GthContrato
	public List<RepReportesSistema> listaReportesAutorizados(String user, String sistema, String modulo) {

		System.out.println("2s: " + user + " sistema: " + sistema + " módulo: " + modulo);

		Query q = getEntityManager().createNativeQuery(
				"SELECT DISTINCT res.RES_CODIGO,  res.RES_SISTEMA,  res.RES_SISTEMA, res.RES_APLICACION,  res.RES_ARCHIVO, res.RES_REPORTE, res.RES_ARCHIVO_EXCEL , res.RES_FORMATO "
						+ "FROM   rep.rep_reportes_sistema       res, " + "       rep.rep_reporte_rol            rer, "
						+ "       aseg.aseg_usr_est_rol          uer, " + "       aseg.aseg_usuario_estructura   use, "
						+ "       aseg.aseg_usuario              usu "
						+ "WHERE  res.res_codigo                 = rer.res_codigo "
						+ "AND    rer.rol_codigo                 = uer.rol_codigo "
						+ "AND    uer.use_codigo                 = use.use_codigo "
						+ "AND    use.usu_codigo                 = usu.usu_codigo "
						+ "AND    usu.usu_email                  = ?1 " + "AND    res.res_aplicacion             = ?2 "
						+ "AND    res.res_modulo                 = ?3 ",
				RepReportesSistema.class)
			.setParameter(1, user)
			.setParameter(2, sistema)
			.setParameter(3, modulo);
		q.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
		return q.getResultList();
	}

	public List<Map<String, Object>> getSystem() {

		String sql = "SELECT DISTINCT res_sistema, res_aplicacion FROM rep.rep_reportes_sistema";

		Query q = getEntityManager().createNativeQuery(sql);

		List<Object[]> results = q.getResultList();
		List<Map<String, Object>> resultList = new ArrayList<>();

		String[] columnNames = { "res_sistema", "res_aplicacion" };

		for (Object[] row : results) {
			Map<String, Object> rowMap = new HashMap<>();

			for (int i = 0; i < columnNames.length; i++) {
				rowMap.put(columnNames[i], row[i]);
			}
			resultList.add(rowMap);
		}
		return resultList;
	}

	public List<String> getModules() {

		String sql = "SELECT DISTINCT res_modulo FROM rep.rep_reportes_sistema";
		Query q = getEntityManager().createNativeQuery(sql);
		List<String> results = q.getResultList();
		return results;
	}

	@Override
	public void createRecord(RepReportesSistema entity) {
		entity.setResCodigo(findSequence());
		super.createRecord(entity);
	}

}
