package com.wolfsoft.ht.test;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.wolfsoft.hr.config.ApplicationConfig;
import com.wolfsoft.hr.entity.Employees;
import com.wolfsoft.hr.service.EmployeesService;

@Component
public class EmployeeTest {
	private ApplicationContext ctx;
	private EmployeesService service;
	private int COD_EMPLOYEES = 201;

	@Before
	public void setUp() throws Exception {
		ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println("ApplicationConfig initialized successfully");
		service = (EmployeesService) ctx.getBean("employeesService");
	}

	@Test
	public void testInsert() throws SQLException {
		Employees employee = getEmployees();

		service.save(employee);
		assertNotNull(employee.getEmployeeId());
		printObject(employee);
		System.out.println("Employees Inserted...");
	}

	@Test
	public void testUpdate() throws SQLException {
		Employees employee = service.findByPK(100);
		assertNotNull(employee);
		employee.setLastName("Merkel");
		service.update(employee);
		assertNotNull(employee.getEmployeeId());
		printObject(employee);
		System.out.println("Employees Updated...");
	}
	
	@Test
	public void testSearchForParameter() {
		Hashtable<Object, Object> camposWhere = null;
		String[] camposORDER_BY = {};
		List<Employees> list = service.searchByParametros(camposWhere,
				camposORDER_BY);
		assertNotNull(list);
		for (Employees employees : list) {
			printObject(employees);
		}
		System.out.println("Employees searchByParametros...");
	}

	private Employees getEmployees() {
		Employees employee = new Employees();
		employee.setEmployeeId(COD_EMPLOYEES++);
		employee.setFirstName("FirstName" + COD_EMPLOYEES);
		employee.setLastName("LastName" + COD_EMPLOYEES);
		employee.setEmail("firstName" + COD_EMPLOYEES + "@email.com");
		employee.setPhone("515.123.4" + COD_EMPLOYEES);
		employee.setJobId("SA_MAN-" + COD_EMPLOYEES);
		employee.setSalary(85000L);
		java.util.Date hireDate = new java.util.Date();
		employee.setHireDate(new Date(hireDate.getTime()));
		employee.setDepartmentId(80);

		return employee;
	}

    private void printObject(Object object) {
        Method[] methods = object.getClass().getMethods();
        Method meSet=null;
        System.out.println(object.getClass().getName()+"[");
        for (int k = 0; k < methods.length; k++) {
            String name = methods[k].getName();
            if (name.startsWith("get")){
                try {
                    meSet = methods[k];
                    if (meSet != null) {
                    	if(!meSet.getReturnType().getName().contains("List")
                    			&& !meSet.getReturnType().getName().contains("Class")){
                            System.out.println(name+"="+meSet.invoke(object, null));
                    	}
                    	//System.out.println("Tipo "+meSet.getReturnType().getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("]");
    }	
	
}
