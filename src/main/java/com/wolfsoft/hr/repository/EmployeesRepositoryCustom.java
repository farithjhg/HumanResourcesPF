package com.wolfsoft.hr.repository; 

import java.util.Hashtable;
import java.util.List;

import com.wolfsoft.hr.entity.Employees;

/**
* <p>Title: Interfaz Repository Custom Spring Data JPA Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Interfaz Repository Spring Data JPA 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface EmployeesRepositoryCustom {

    public List<Employees> searchByParametros(Hashtable<Object, Object> camposWhere, String[] camposORDER_BY);
}
