package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wolfsoft.hr.entity.Locations;
import com.wolfsoft.hr.repository.LocationsRepository;
import com.wolfsoft.hr.service.LocationsService;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
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
@Service("locationsService")
@Repository
@Transactional
public class LocationsServiceImpl implements LocationsService {
    @Autowired
    private LocationsRepository locationsRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Locations findByPK(Integer id){
		return locationsRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Locations> findAll() {
		return (List<Locations>)locationsRepository.findAll();
    }

    public Locations save(Locations entity) {
		if(entity.getLocationId()==null){
			locationsRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    @Override
    public void delete(Locations entity) {
         em.remove(findByPK(entity.getLocationId()));
    }

}
