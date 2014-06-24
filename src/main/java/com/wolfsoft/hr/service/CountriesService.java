package com.wolfsoft.hr.service; 

import java.util.List;

import com.wolfsoft.hr.entity.Countries;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla countries. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface CountriesService {

    /**
     * Return Countries's entity by PK
     * @return Countries
     */
    public Countries findByPK(String id);

    /**
     * Return all Countries rows 
     */
    public List<Countries> findAll();

    /**
     * Add a row in the Countries Table
     * @return Countries
     */
    public Countries save(Countries entity);

    /**
    * Delete a row in the Countries Table by PK 
    */
    public void delete(Countries entity);

}
