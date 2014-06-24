package com.wolfsoft.hr.service; 

import java.util.List;

import com.wolfsoft.hr.entity.Regions;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla regions. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface RegionsService {

    /**
     * Return Regions's entity by PK
     * @return Regions
     */
    public Regions findByPK(Integer id);

    /**
     * Return all Regions rows 
     */
    public List<Regions> findAll();

    /**
     * Add a row in the Regions Table
     * @return Regions
     */
    public Regions save(Regions entity);

    /**
    * Delete a row in the Regions Table by PK 
    */
    public void delete(Regions entity);

}
