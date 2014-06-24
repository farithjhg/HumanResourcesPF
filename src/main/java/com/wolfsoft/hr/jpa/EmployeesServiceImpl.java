package com.wolfsoft.hr.jpa;

import java.util.Hashtable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolfsoft.hr.entity.Employees;
import com.wolfsoft.hr.repository.EmployeesRepository;
import com.wolfsoft.hr.service.EmployeesService;

import java.sql.Date;

/**
 * <p>
 * Title: Clase ServiceImpl Generada por Masterclass Ver 2.0
 * </p>
 * 
 * <p>
 * Description: ServiceImpl que representa la CRUD de los metodos de
 * Persistencia de la tabla employees.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * 
 * <p>
 * Company: Wolfsoft Co.
 * </p>
 * 
 * @author Farith José Heras García
 * @version 1.0
 */
@Service("employeesService")
@Repository
@Transactional
public class EmployeesServiceImpl implements EmployeesService {
	@Autowired
	private EmployeesRepository employeesRepository;

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public Employees findByPK(Integer id) {
		return employeesRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Employees> findAll() {
		return (List<Employees>) employeesRepository.findAll();
	}

	public Employees save(Employees entity) {
		return employeesRepository.save(entity);
	}

	@Override
	public void delete(Employees entity) {
		em.remove(findByPK(entity.getEmployeeId()));
	}

	@Override
	public List<Employees> searchByParametros(
			Hashtable<Object, Object> camposWhere, String[] camposORDER_BY) {
		return employeesRepository.searchByParametros(camposWhere,
				camposORDER_BY);
	}

	public Employees update(Employees entity) {
		return em.merge(entity);
	}

}
