package com.wolfsoft.hr.listener;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import com.wolfsoft.hr.entity.User;
import com.wolfsoft.hr.util.Utility;

public class AuthorizationListener implements PhaseListener {
	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {
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

		nav.performNavigation("LOGIN");
	}

	public void beforePhase(PhaseEvent event) {

	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}