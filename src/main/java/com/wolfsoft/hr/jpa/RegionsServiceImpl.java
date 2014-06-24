package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wolfsoft.hr.entity.Regions;
import com.wolfsoft.hr.repository.RegionsRepository;
import com.wolfsoft.hr.service.RegionsService;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
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
@Service("regionsService")
@Repository
@Transactional
public class RegionsServiceImpl implements RegionsService {
    @Autowired
    private RegionsRepository regionsRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Regions findByPK(Integer id){
		return regionsRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Regions> findAll() {
		return (List<Regions>)regionsRepository.findAll();
    }

    
    public Regions save(Regions entity) {
		if(entity.getRegionId()==null){
			regionsRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    @Override
    public void delete(Regions entity) {
         em.remove(findByPK(entity.getRegionId()));
    }

}
