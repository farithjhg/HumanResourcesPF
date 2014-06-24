package com.wolfsoft.hr.repository; 

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wolfsoft.hr.entity.Employees;
/**
* <p>Title: Interfaz Repository Spring Data JPA Generada por Masterclass Ver 2.0 </p>
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
public interface EmployeesRepository extends PagingAndSortingRepository<Employees,Integer>, EmployeesRepositoryCustom {

}
