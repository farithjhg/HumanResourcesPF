package com.wolfsoft.hr.repository;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.wolfsoft.hr.entity.Employees;

public class EmployeesRepositoryCustomImpl implements EmployeesRepositoryCustom {
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Employees> searchByParametros(
			Hashtable<Object, Object> camposWhere, String[] camposORDER_BY) {
        String txtQuery = "SELECT p FROM Employees p ";
        String donde = "";
        String campo, simbolo;
        String varParametro = "";
        String varParametro1 = "";
        String varParametro2 = "";
        String orden = "";
        Hashtable valoresPS = new Hashtable();

        if (camposWhere != null && !camposWhere.isEmpty()) {
            Hashtable valor = null;
            for (Enumeration enumer = camposWhere.keys();
                 enumer.hasMoreElements(); ) {
                simbolo = (String)enumer.nextElement();
                valor = (Hashtable)camposWhere.get(simbolo);
                if (valor != null && !valor.isEmpty()) {
                    campo = "";
                    if (simbolo.contains("BETWEEN")) {
                        for (Enumeration enumeration = valor.keys();
                             enumeration.hasMoreElements(); ) {
                            campo = (String)enumeration.nextElement();
                            varParametro = campo;
                            if (campo.contains(".")) {
                                StringTokenizer token =
                                    new StringTokenizer(campo, ".");
                                while (token.hasMoreTokens()) {
                                    varParametro = token.nextToken();
                                }
                            }
                            varParametro1 = varParametro + "1";
                            varParametro2 = varParametro + "2";
                            donde +=
                                    " AND p." + campo + " " + simbolo + " :" + varParametro1 +
                                    " AND :" + varParametro2;
                            valoresPS.put(varParametro1,
                                          ((Vector)valor.get(campo)).get(0));
                            valoresPS.put(varParametro2,
                                          ((Vector)valor.get(campo)).get(1));
                        }
                    } else if (simbolo.contains("IN")) {
                        for (Enumeration enumeration = valor.keys();
                             enumeration.hasMoreElements(); ) {
                            campo = (String)enumeration.nextElement();
                            varParametro = campo;
                            if (campo.contains(".")) {
                                StringTokenizer token =
                                    new StringTokenizer(campo, ".");
                                while (token.hasMoreTokens()) {
                                    varParametro = token.nextToken();
                                }
                            }
                            List listaValores = (List)valor.get(campo);
                            varParametro = "(";
                            for (Iterator iter = listaValores.iterator();
                                 iter.hasNext(); ) {
                                varParametro += iter.next().toString() + ",";
                            }
                            varParametro =
                                    varParametro.substring(0, varParametro.length() - 1);
                            varParametro += ")";
                            donde +=
                                    " AND p." + campo + " " + simbolo + " " + (!varParametro.equals("()") ?
                                                                               varParametro :"");
                        }
                    } else {
                        for (Enumeration enumeration = valor.keys();
                              enumeration.hasMoreElements(); ) {
                            campo = (String)enumeration.nextElement();
                            varParametro = campo;
                            if (campo.contains(".")) {
                                StringTokenizer token =
                                    new StringTokenizer(campo, ".");
                                while (token.hasMoreTokens()) {
                                    varParametro = token.nextToken();
                                }
                            }

                            donde +=
                                    " AND p." + campo + " " + simbolo + (!valor.get(campo).toString().equals("") ?
                                                                         " :" +varParametro :"");
                            if (!valor.get(campo).toString().equals(""))
                                valoresPS.put(varParametro, valor.get(campo));
                        }
                    }
                }
            }
        }

        if (camposORDER_BY != null) {
            for (int i = 0; i < camposORDER_BY.length; i++) {
                campo = camposORDER_BY[i];
                orden += ", p." + campo;
            }
        }

        orden = orden.replaceFirst(",", " ORDER BY");
        donde = donde.replaceFirst("AND", "WHERE");
        donde += orden;
        txtQuery += donde;

        Query query = null;
        query = em.createQuery(txtQuery);
        if (valoresPS != null && !valoresPS.isEmpty()) {
            for (Enumeration enumer = valoresPS.keys();
                 enumer.hasMoreElements(); ) {
                campo = (String)enumer.nextElement();
                query.setParameter(campo, valoresPS.get(campo));
            }
        }
        return query.getResultList();
	}

}
