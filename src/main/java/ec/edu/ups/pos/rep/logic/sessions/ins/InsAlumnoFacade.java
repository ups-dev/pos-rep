/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.ins;

import ec.edu.ups.ins.common.data.entities.InsAlumno;
import ec.edu.ups.pos.rep.logic.sessions.AbstractFacade;
import ec.edu.ups.util.jpa.UPSDataConstants;
import ec.edu.ups.util.jpa.search.DefaultParamOrderSearch;
import ec.edu.ups.util.jpa.search.DefaultParamSearch;
import ec.edu.ups.util.jpa.search.SearchCondition;
import ec.edu.ups.util.jpa.search.builder.SearchBuilder;
import ec.edu.ups.util.jpa.search.condition.PathValue;
import ec.edu.ups.util.jpa.search.function.ConcatFunction;
import ec.edu.ups.util.jpa.search.function.UpperFunction;
import ec.edu.ups.util.jpa.search.param.CacheStoreModeParam;
import ec.edu.ups.util.jpa.search.param.MaxResultsParam;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class InsAlumnoFacade extends AbstractFacade<InsAlumno> {

    @PersistenceContext(unitName = "POS_REP_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsAlumnoFacade() {
        super(InsAlumno.class);
    }

    public List<InsAlumno> findByNombre(String nombreBusqueda) {
        return findRecords(SearchBuilder.create(new DefaultParamSearch("audEliminado", UPSDataConstants.CONDICION_LOGICA_NO))
                .addParam(new DefaultParamSearch(new UpperFunction(new ConcatFunction("aluApellidos", " ", new PathValue("aluNombres"))),
                                nombreBusqueda.toUpperCase(), SearchCondition.CONTAIN).setSplitValue(true))
                .addParam(new DefaultParamOrderSearch("aluApellidos"))
                .addParam(new DefaultParamOrderSearch("aluNombres"))
                .addParam(new MaxResultsParam(50)));
    }

    public InsAlumno buscarAlumno(InsAlumno alumno) {
        List<InsAlumno> datos = findRecords(SearchBuilder.create(new DefaultParamSearch().setValue(alumno)).addParam(new CacheStoreModeParam(CacheStoreMode.REFRESH)));
        return (datos.isEmpty() ? null : datos.get(0));
    }

    public InsAlumno findByCllcCdg(Long cllcCdg) {
        List<InsAlumno> datos = findRecords(SearchBuilder.create(new DefaultParamSearch("cllcCdg", cllcCdg)).addParam(new CacheStoreModeParam(CacheStoreMode.REFRESH)));
        return (datos.isEmpty() ? null : datos.get(0));
    }

    public InsAlumno obtenerAlumno(Long aluCodigo) {
        return find(aluCodigo, true);
    }

    public String obtenerCedula(Long aluCodigo) {
        Query q = getEntityManager().createQuery("SELECT c.cllcRuc from InsAlumno a, ClienteLocal c where a.cllcCdg = c.cllcCdg and a.aluCodigo = :aluCodigo and a.audEliminado = 'N' ")
                .setParameter("aluCodigo", aluCodigo);
        String datos = q.getSingleResult().toString();
        return datos;
    }

}
