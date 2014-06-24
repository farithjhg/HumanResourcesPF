package com.wolfsoft.hr.service; 

import java.util.List;

import com.wolfsoft.hr.entity.Jobs;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla jobs. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface JobsService {

    /**
     * Return Jobs's entity by PK
     * @return Jobs
     */
    public Jobs findByPK(String id);

    /**
     * Return all Jobs rows 
     */
    public List<Jobs> findAll();

    /**
     * Add a row in the Jobs Table
     * @return Jobs
     */
    public Jobs save(Jobs entity);

    /**
    * Delete a row in the Jobs Table by PK 
    */
    public void delete(Jobs entity);

}
