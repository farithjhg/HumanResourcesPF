package com.wolfsoft.hr.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utility {
	public static final String MESSAGE_ERROR_MANAGED_BEAN = "Error initiating the Managed Bean: ";
	public static final String MESSAGE_ERROR_DELETING_DATA = "Problems Trying to Remove Data, Error: ";
	public static final String MESSAGE_ERROR_SAVING_DATA = "Problems Trying to Save Data, Error: ";

	public Utility() {
	}
	
	public static String dateFormat(Date date){
		String patter = "dd-MM-yyyy HH:mm:ss";
	    SimpleDateFormat format = new SimpleDateFormat(patter);

	    return format.format(date);		
	}

	public static void setErrorMessage(String message) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Error: ", message));
	}

	public static void setWarningMessage(String message) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn: ",
				message));
	}

	public static void setInfoMessage(String message) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ",
				message));
	}

	public static Object getFromSession(String ObjectName) {
		return getSession().getAttribute(ObjectName);
	}

	public static void subirASession(String ObjectName, Object object) {
		getSession().setAttribute(ObjectName, object);
	}

	public static void removerBeanSession(String bean) {
		getSession().removeAttribute(bean);
	}

	public static String logout(String bean) {
		removerBeanSession(bean);
		cerrarSesion();
		return "LOGIN";
	}

	public static String logout(String bean, String page) {
		removerBeanSession(bean);
		return page;
	}


	public static void cerrarSesion() {
		if (getSession() != null) {
			getSession().invalidate();
		}
	}

	public static HttpServletRequest getRequest() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc
				.getExternalContext().getRequest();
		return request;
	}

	public static HttpSession getSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);
		return session;
	}

}