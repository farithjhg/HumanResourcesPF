package com.wolfsoft.hr.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolfsoft.hr.entity.User;
import com.wolfsoft.hr.repository.UserRepository;
import com.wolfsoft.hr.service.UserService;
/**
* <p>Title: Clase ServiceImpl Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: ServiceImpl que representa la CRUD de 
*    los metodos de Persistencia de la tabla user. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public User findByPK(Long id){
		return userRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<User> findAll() {
		return (List<User>)userRepository.findAll();
    }

    public User save(User entity) {
		if(entity.getId()==null){
			userRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }


    public void delete(User entity) {
         em.remove(findByPK(entity.getId()));
    }

	public List<User> findByUserLogin(String userName) {
		return userRepository.findByUserLogin(userName);
	}

	public List<User> findByRoleId(Integer roleId) {
		return userRepository.findByRoleId(roleId);
	}

}
