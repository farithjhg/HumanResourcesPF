package com.wolfsoft.hr.bean;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;

public class GeneralBean {
	
	@PostConstruct
	public void init(){
		System.out.println("Entro!");
	}
	
	protected void closeDialog(String dialog){
		getRequestContext().execute("PF('"+dialog+"').hide();");
	}

	protected RequestContext getRequestContext(){
		return RequestContext.getCurrentInstance();
	}
}
