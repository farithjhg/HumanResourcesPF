package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wolfsoft.hr.entity.Countries;
import com.wolfsoft.hr.repository.CountriesRepository;
import com.wolfsoft.hr.service.CountriesService;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
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
@Service("countriesService")
@Repository
@Transactional
public class CountriesServiceImpl implements CountriesService {
    @Autowired
    private CountriesRepository countriesRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Countries findByPK(String id){
		return countriesRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Countries> findAll() {
		return (List<Countries>)countriesRepository.findAll();
    }

    public Countries save(Countries entity) {
		if(entity.getCountryId()==null){
			countriesRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    @Override
    public void delete(Countries entity) {
         em.remove(findByPK(entity.getCountryId()));
    }

}
