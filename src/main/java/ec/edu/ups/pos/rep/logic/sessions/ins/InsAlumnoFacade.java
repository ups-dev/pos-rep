/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.logic.sessions.ins;

import ec.edu.ups.ins.common.data.entities.InsAlumno;
import ec.edu.ups.pos.rep.data.entities.wrapper.InsAlumnoWrapper;
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
import java.util.ArrayList;
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
    
    
    //Método facade
    public List<InsAlumnoWrapper> findAlumnoWrapper(String query) {
        try {
            List<String> params = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT ALU.ALU_CODIGO aluCodigo, CLI.CLLC_RUC cllcRuc,  ALU.ALU_APELLIDOS || ' ' || ALU.ALU_NOMBRES aluNombres "
                    + "FROM INS.INS_ALUMNO ALU, SIGAC.CLIENTE_LOCAL CLI WHERE ALU.CLLC_CDG = CLI.CLLC_CDG AND ");
            params.add(query.trim());
            //Separamos el texto a buscar por espacios
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
            //Agregamos los parámetros
            for (int i = 0; i < params.size(); i++) {
                if (i > 0) {
                    String param = params.get(i);
                    param = "%" + param + "%";
                    q.setParameter(i, param);
                }

            }
            List<InsAlumnoWrapper> result = q.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        }

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
