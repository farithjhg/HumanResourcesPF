package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wolfsoft.hr.entity.Rol;
import com.wolfsoft.hr.repository.RolRepository;
import com.wolfsoft.hr.service.RolService;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
*    los metodos de Persistencia de la tabla rol. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
@Service("rolService")
@Repository
@Transactional
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Rol findByPK(Integer id){
		return rolRepository.findOne(id);
    }


    public List<Rol> findAll() {
		return (List<Rol>)rolRepository.findAll();
    }


    public Rol save(Rol entity) {
		if(entity.getRoleId()==null){
			rolRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    @Override
    public void delete(Rol entity) {
         em.remove(findByPK(entity.getRoleId()));
    }

}
