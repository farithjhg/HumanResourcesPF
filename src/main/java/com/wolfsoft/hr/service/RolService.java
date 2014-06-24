package com.wolfsoft.hr.service; 

import java.util.List;

import com.wolfsoft.hr.entity.Rol;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla rol. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface RolService {

    /**
     * Return Rol's entity by PK
     * @return Rol
     */
    public Rol findByPK(Integer id);

    /**
     * Return all Rol rows 
     */
    public List<Rol> findAll();

    /**
     * Add a row in the Rol Table
     * @return Rol
     */
    public Rol save(Rol entity);

    /**
    * Delete a row in the Rol Table by PK 
    */
    public void delete(Rol entity);

}
