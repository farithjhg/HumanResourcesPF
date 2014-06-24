package com.wolfsoft.hr.service; 

import java.util.Hashtable;
import java.util.List;
import java.sql.Date;

import com.wolfsoft.hr.entity.Employees;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla employees. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface EmployeesService {

    /**
     * Return Employees's entity by PK
     * @return Employees
     */
    public Employees findByPK(Integer id);

    /**
     * Return all Employees rows 
     */
    public List<Employees> findAll();

    /**
     * Add a row in the Employees Table
     * @return Employees
     */
    public Employees save(Employees entity);

    public Employees update(Employees entity);
    
    /**
    * Delete a row in the Employees Table by PK 
    */
    public void delete(Employees entity);

    public List<Employees> searchByParametros(Hashtable<Object, Object> camposWhere, String[] camposORDER_BY);
}
