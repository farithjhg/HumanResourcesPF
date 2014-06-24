package com.wolfsoft.hr.bean;

import java.io.Serializable;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import com.wolfsoft.hr.entity.User;
import com.wolfsoft.hr.util.Utility;

@ManagedBean(name = "security")
@SessionScoped
public class SecurityBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public void isSessionValid(ComponentSystemEvent event) {
		User user = null;
		HttpSession session = Utility.getSession();
		if (session != null) {
			user = (User) session.getAttribute("userBean");
			if(user==null)
				redirect();
		} else {
			redirect();
		}
	}

	private void redirect() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc
				.getApplication().getNavigationHandler();

		nav.handleNavigation(FacesContext.getCurrentInstance(), null,
		    	"/index.xhtml?faces-redirect=true");
	}
}