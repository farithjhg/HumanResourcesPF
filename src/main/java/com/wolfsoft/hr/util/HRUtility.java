package com.wolfsoft.hr.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HRUtility {

	private static List<SelectItem> listaSelectItem;
	public static final String ERROR_MENSAJE_MANAGED_BEAN = "Problemas al intentar instanciar Managed Bean: ";
	public static final String ERROR_MENSAJE_ELIMINAR = "Problemas al Intentar Eliminar Datos, Error: ";
	public static final String ERROR_MENSAJE_GRABAR = "Problemas al Intentar Grabar Datos, Error: ";

	public static void asignarMensajeError(String texto) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Error", texto));
	}

	public static void asignarMensajeAdvertencia(String texto) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn",
				texto));
	}

	public static void asignarMensajeInfo(String texto) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
				texto));
	}

	public static void cambiarIdioma(String idioma) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.ENGLISH);
	}

	public static Object recuperarDeSession(String nombreObjeto) {
		return getSession().getAttribute(nombreObjeto);
	}

	public static void subirASession(String nombreObjeto, Object objeto) {
		getSession().setAttribute(nombreObjeto, objeto);
	}

	public static void removerBeanSession(String bean) {
		getSession().removeAttribute(bean);
	}

	public static String regresar(String bean) {
		removerBeanSession(bean);
		return "menuPpal";
	}

	public static String regresar(String bean, String pagina) {
		removerBeanSession(bean);
		return pagina;
	}

	public static List<SelectItem> listaSexo() {
		listaSelectItem = new ArrayList<SelectItem>();
		listaSelectItem.add(new SelectItem("M", "Masculino"));
		listaSelectItem.add(new SelectItem("F", "Femenino"));
		return listaSelectItem;
	}

	public static List<SelectItem> listDepartaments() {
		listaSelectItem = new ArrayList<SelectItem>();
		listaSelectItem.add(new SelectItem("1", "Dpto1"));
		listaSelectItem.add(new SelectItem("2", "Dpto2"));
		return listaSelectItem;
	}

	public static List<SelectItem> listaRta() {
		listaSelectItem = new ArrayList<SelectItem>();
		listaSelectItem.add(new SelectItem("S", "Si"));
		listaSelectItem.add(new SelectItem("N", "No"));
		return listaSelectItem;
	}

	public void cerrarSesion() {
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

	public static String getRootErrorMessage(Exception e) {
		// Default to general error message that registration failed.
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			// This shouldn't happen, but return the default messages
			return errorMessage;
		}

		// Start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// Get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// This is the root cause message
		return errorMessage;
	}

}
