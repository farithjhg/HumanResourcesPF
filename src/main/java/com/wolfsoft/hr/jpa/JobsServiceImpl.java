package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wolfsoft.hr.entity.Jobs;
import com.wolfsoft.hr.repository.JobsRepository;
import com.wolfsoft.hr.service.JobsService;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
*    los metodos de Persistencia de la tabla jobs. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
@Service("jobsService")
@Repository
@Transactional
public class JobsServiceImpl implements JobsService {
    @Autowired
    private JobsRepository jobsRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Jobs findByPK(String id){
		return jobsRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Jobs> findAll() {
		return (List<Jobs>)jobsRepository.findAll();
    }

    public Jobs save(Jobs entity) {
		if(entity.getJobId()==null){
			jobsRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    @Override
    public void delete(Jobs entity) {
         em.remove(findByPK(entity.getJobId()));
    }

}
