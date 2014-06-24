package com.wolfsoft.hr.service; 

import java.util.List;

import com.wolfsoft.hr.entity.Departments;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla departments. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface DepartmentsService {

    /**
     * Return Departments's entity by PK
     * @return Departments
     */
    public Departments findByPK(Integer id);

    /**
     * Return all Departments rows 
     */
    public List<Departments> findAll();

    /**
     * Add a row in the Departments Table
     * @return Departments
     */
    public Departments save(Departments entity);

    /**
    * Delete a row in the Departments Table by PK 
    */
    public void delete(Departments entity);

}
