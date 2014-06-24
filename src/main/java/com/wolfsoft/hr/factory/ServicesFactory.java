package com.wolfsoft.hr.factory; 

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wolfsoft.hr.config.ApplicationConfig;
import com.wolfsoft.hr.service.*;
/**
* <p>Title: Clase ServicesFactory Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Services Factory 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public class ServicesFactory{
     private static ApplicationContext ctx;
     private static CountriesService countriesService;
     private static DepartmentsService departmentsService;
     private static EmployeesService employeesService;
     private static JobHistoryService jobHistoryService;
     private static JobsService jobsService;
     private static LocationsService locationsService;
     private static RegionsService regionsService;
     private static RolService rolService;
     private static UserService userService;

     public static CountriesService getCountriesService() {
		if (ctx == null)
			ctx = getCtx();

		if (countriesService == null)
			countriesService = (CountriesService) ctx.getBean("countriesService"); 

		return countriesService;
     }

     public static DepartmentsService getDepartmentsService() {
		if (ctx == null)
			ctx = getCtx();

		if (departmentsService == null)
			departmentsService = (DepartmentsService) ctx.getBean("departmentsService"); 

		return departmentsService;
     }

     public static EmployeesService getEmployeesService() {
		if (ctx == null)
			ctx = getCtx();

		if (employeesService == null)
			employeesService = (EmployeesService) ctx.getBean("employeesService"); 

		return employeesService;
     }

     public static JobHistoryService getJobHistoryService() {
		if (ctx == null)
			ctx = getCtx();

		if (jobHistoryService == null)
			jobHistoryService = (JobHistoryService) ctx.getBean("jobHistoryService"); 

		return jobHistoryService;
     }

     public static JobsService getJobsService() {
		if (ctx == null)
			ctx = getCtx();

		if (jobsService == null)
			jobsService = (JobsService) ctx.getBean("jobsService"); 

		return jobsService;
     }

     public static LocationsService getLocationsService() {
		if (ctx == null)
			ctx = getCtx();

		if (locationsService == null)
			locationsService = (LocationsService) ctx.getBean("locationsService"); 

		return locationsService;
     }

     public static RegionsService getRegionsService() {
		if (ctx == null)
			ctx = getCtx();

		if (regionsService == null)
			regionsService = (RegionsService) ctx.getBean("regionsService"); 

		return regionsService;
     }

     public static RolService getRolService() {
		if (ctx == null)
			ctx = getCtx();

		if (rolService == null)
			rolService = (RolService) ctx.getBean("rolService"); 

		return rolService;
     }

     public static UserService getUserService() {
		if (ctx == null)
			ctx = getCtx();

		if (userService == null)
			userService = (UserService) ctx.getBean("userService"); 

		return userService;
     }

	 private static ApplicationContext getCtx() {
		return new AnnotationConfigApplicationContext(ApplicationConfig.class);
     }
}
