/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.sigac;

import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.pos.rep.data.entities.sigac.ClienteLocal;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;

/**
 * Description.
 *
 * @author Administrador .
 */
@Stateless
public class ClienteLocalFacade extends AbstractFacade<ClienteLocal> {

	@PersistenceContext(unitName = "POS_REP_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	public ClienteLocalFacade() {
		super(ClienteLocal.class);
	}

	public ClienteLocal findClienteLocalByCedula(String cedula) {
		try {
			return (ClienteLocal) getEntityManager()
				.createQuery("SELECT c FROM ClienteLocal c where c.cllcRuc = :cllcRuc")
				.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH)
				.setParameter("cllcRuc", cedula)
				.getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}

}
