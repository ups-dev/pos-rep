/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.ins;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.edu.ups.pos.rep.data.entities.ins.InsAlumno;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.util.exceptions.UPSDataSelectException;
import ec.edu.ups.util.jpa.UPSDataConstants;

/**
 * Description.
 *
 * @author Administrador .
 */
@Stateless
public class InsAlumnoFacade extends AbstractFacade<InsAlumno> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public InsAlumnoFacade() {
		super(InsAlumno.class);
	}

	// Método facade
	public List<InsAlumnoWrapper> findAlumnoWrapper(String query) {
		try {
			List<String> params = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			sb.append(
					" SELECT ALU.ALU_CODIGO aluCodigo, CLI.CLLC_RUC cllcRuc,  ALU.ALU_APELLIDOS || ' ' || ALU.ALU_NOMBRES aluNombres "
							+ "FROM INS.INS_ALUMNO ALU, SIGAC.CLIENTE_LOCAL CLI WHERE ALU.CLLC_CDG = CLI.CLLC_CDG AND ");
			params.add(query.trim());
			// Separamos el texto a buscar por espacios
			String[] splits = query.split("[\\s]+");
			sb.append("(");
			for (int i = 0; i < splits.length; i++) {
				if (i > 0) {
					sb.append(" AND ");
				}
				sb.append("CLI.CLLC_RUC LIKE ?1 or ");
				params.add(splits[i].toUpperCase());
				sb.append("ALU.ALU_APELLIDOS || ' ' || ALU.ALU_NOMBRES LIKE ?2 ");
				params.add(splits[i].toUpperCase());

			}
			sb.append(" ) AND ROWNUM <= 20 order by aluNombres");
			Query q = getEntityManager().createNativeQuery(sb.toString(), InsAlumnoWrapper.class);
			// Agregamos los parámetros
			for (int i = 0; i < params.size(); i++) {
				if (i > 0) {
					String param = params.get(i);
					param = "%" + param + "%";
					q.setParameter(i, param);
				}

			}
			List<InsAlumnoWrapper> result = q.getResultList();
			return result;
		}
		catch (Exception ex) {
			return null;
		}

	}

	public List<InsAlumno> findByNombre(String nombreBusqueda) {
		String jpql = "SELECT i FROM InsAlumno i WHERE i.audEliminado = :audEliminado "
				+ "AND UPPER(CONCAT(i.aluApellidos, ' ', i.aluNombres)) LIKE :nombreBusqueda "
				+ "ORDER BY i.aluApellidos, i.aluNombres";

		TypedQuery<InsAlumno> query = getEntityManager().createQuery(jpql, InsAlumno.class);
		query.setParameter("audEliminado", UPSDataConstants.CONDICION_LOGICA_NO);
		query.setParameter("nombreBusqueda", "%" + nombreBusqueda.toUpperCase() + "%");
		query.setMaxResults(50);

		return query.getResultList();
	}

	public InsAlumno buscarAlumno(InsAlumno alumno) {
		String jpql = "SELECT i FROM InsAlumno i WHERE i.aluApellidos = :aluApellidos AND i.aluNombres = :aluNombres";
		// Ajusta los parámetros y agrega más condiciones según sea necesario.

		try {
			TypedQuery<InsAlumno> query = getEntityManager().createQuery(jpql, InsAlumno.class)
				.setParameter("aluApellidos", alumno.getAluApellidos())
				.setParameter("aluNombres", alumno.getAluNombres());
			query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);

			List<InsAlumno> datos = query.getResultList();
			return (datos.isEmpty() ? null : datos.get(0));
		}
		catch (Exception ex) {
			// Manejo de excepciones
			throw new UPSDataSelectException(ex);
		}
	}

	public InsAlumno findByCllcCdg(Long cllcCdg) {
		String jpql = "SELECT i FROM InsAlumno i WHERE i.cllcCdg = :cllcCdg";

		try {
			TypedQuery<InsAlumno> query = getEntityManager().createQuery(jpql, InsAlumno.class)
				.setParameter("cllcCdg", cllcCdg);
			query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);

			List<InsAlumno> datos = query.getResultList();
			return (datos.isEmpty() ? null : datos.get(0));
		}
		catch (Exception ex) {
			// Manejo de excepciones
			throw new UPSDataSelectException(ex);
		}
	}

	public InsAlumno obtenerAlumno(Long aluCodigo) {
		return find(aluCodigo);
	}

	public String obtenerCedula(Long aluCodigo) {
		Query q = getEntityManager().createQuery(
				"SELECT c.cllcRuc from InsAlumno a, ClienteLocal c where a.cllcCdg = c.cllcCdg and a.aluCodigo = :aluCodigo and a.audEliminado = 'N' ")
			.setParameter("aluCodigo", aluCodigo);
		return q.getSingleResult().toString();
	}

}
