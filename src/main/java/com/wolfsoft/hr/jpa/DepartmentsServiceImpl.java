package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wolfsoft.hr.entity.Departments;
import com.wolfsoft.hr.repository.DepartmentsRepository;
import com.wolfsoft.hr.service.DepartmentsService;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
*    los metodos de Persistencia de la tabla departments. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
@Service("departmentsService")
@Repository
@Transactional
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    private DepartmentsRepository departmentsRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Departments findByPK(Integer id){
		return departmentsRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Departments> findAll() {
		return (List<Departments>)departmentsRepository.findAll();
    }

    public Departments save(Departments entity) {
		if(entity.getDepartmentId()==null){
			departmentsRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    @Override
    public void delete(Departments entity) {
         em.remove(findByPK(entity.getDepartmentId()));
    }

}
