package com.wolfsoft.hr.service; 

import java.util.List;

import com.wolfsoft.hr.entity.User;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla user. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface UserService {

    /**
     * Return User's entity by PK
     * @return User
     */
    public User findByPK(Long id);

    /**
     * Return all User rows 
     */
    public List<User> findAll();

    /**
     * Add a row in the User Table
     * @return User
     */
    public User save(User entity);

    /**
    * Delete a row in the User Table by PK 
    */
    public void delete(User entity);

    public List<User> findByUserLogin(String userName);
    
    public List<User> findByRoleId(Integer roleId);
}
