package com.wolfsoft.hr.repository; 

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.wolfsoft.hr.entity.Countries;
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
public interface CountriesRepository extends PagingAndSortingRepository<Countries,String> {

}
