package com.wolfsoft.hr.service; 

import java.util.List;

import com.wolfsoft.hr.entity.Locations;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla locations. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface LocationsService {

    /**
     * Return Locations's entity by PK
     * @return Locations
     */
    public Locations findByPK(Integer id);

    /**
     * Return all Locations rows 
     */
    public List<Locations> findAll();

    /**
     * Add a row in the Locations Table
     * @return Locations
     */
    public Locations save(Locations entity);

    /**
    * Delete a row in the Locations Table by PK 
    */
    public void delete(Locations entity);

}
