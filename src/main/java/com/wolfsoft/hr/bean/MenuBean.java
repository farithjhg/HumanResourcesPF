package com.wolfsoft.hr.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.wolfsoft.hr.entity.User;
import com.wolfsoft.hr.util.Utility;

@SessionScoped
@ManagedBean
public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private MenuModel simpleMenuModel = new DefaultMenuModel();
	
	@PostConstruct
	public void postContruct() {
		User user = (User) Utility.getFromSession(LoginBean.USER_BEAN_SESSION);
		buildMenu(user);
	}

	private void buildMenu(User user) {
		DefaultSubMenu submenu = null;
		DefaultMenuItem item = null;
		if(user!=null){
			switch (user.getRol().getRoleId()) {
				case 1: {
					submenu = new DefaultSubMenu("Security");
					break;
				}
				case 2: {
					submenu = new DefaultSubMenu("Security");
					break;
				}
				default: {
					submenu = new DefaultSubMenu("Security");
					break;
				}
			}
			item = new DefaultMenuItem("Rol");
	        item.setCommand("listRols?faces-redirect=true");
	        item.setIcon("ui-icon-contact");
	        submenu.addElement(item);
			item = new DefaultMenuItem("User");
	        item.setCommand("listUsers?faces-redirect=true");
	        item.setIcon("ui-icon-person");
	        submenu.addElement(item);
	        
			simpleMenuModel.addElement(submenu);
			
			submenu = new DefaultSubMenu("Master Tables");
			item = new DefaultMenuItem("Regions");
	        item.setCommand("listRegions?faces-redirect=true");
	        item.setIcon("ui-icon-newwin");
	        submenu.addElement(item);
	        
			simpleMenuModel.addElement(submenu);
		}
	}
	
	public MenuModel getSimpleMenuModel() {
		return simpleMenuModel;
	}
	public void setSimpleMenuModel(MenuModel simpleMenuModel) {
		this.simpleMenuModel = simpleMenuModel;
	}

}
