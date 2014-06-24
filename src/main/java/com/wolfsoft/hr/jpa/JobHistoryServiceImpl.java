package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wolfsoft.hr.entity.JobHistory;
import com.wolfsoft.hr.entity.JobHistoryPK;
import com.wolfsoft.hr.repository.JobHistoryRepository;
import com.wolfsoft.hr.service.JobHistoryService;
import java.sql.Date;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
*    los metodos de Persistencia de la tabla job_history. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
@Service("jobHistoryService")
@Repository
@Transactional
public class JobHistoryServiceImpl implements JobHistoryService {
    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public JobHistory findByPK(JobHistoryPK id){
		return jobHistoryRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<JobHistory> findAll() {
		return (List<JobHistory>)jobHistoryRepository.findAll();
    }

    public JobHistory save(JobHistory entity) {
		if(entity.getPk()==null){
			jobHistoryRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    @Override
    public void delete(JobHistory entity) {
        em.remove(findByPK(new JobHistoryPK(entity.getEmployeeId(),entity.getStartDate())));
    }

}
