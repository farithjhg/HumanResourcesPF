package com.wolfsoft.hr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.wolfsoft.hr.entity.User;
import com.wolfsoft.hr.factory.ServicesFactory;
import com.wolfsoft.hr.service.UserService;
import com.wolfsoft.hr.util.Utility;

@ViewScoped
@ManagedBean
public class LoginBean implements Serializable {
    private static final long serialVersionUID = -6239437588285327644L;
    private UserService userService;
    private String userName;
    private String passWord;
	public static final String USER_BEAN_SESSION = "userBean";

    @PostConstruct
    public void postContruct() {
    	userService = ServicesFactory.getUserService();
    }

    public String login(){
    	String navegar="";
    	List<User> userList=userService.findByUserLogin(userName);
    	if(userList!=null && userList.size()>0){
    		User user=userList.get(0);
    		if(user.getUserPass().equals(passWord)){
    			navegar="/pages/home.xhtml";
    			Utility.subirASession(USER_BEAN_SESSION, user);
    		}else{
    			Utility.setErrorMessage("Password is invalid");
    		}
    	}else{
    		Utility.setErrorMessage("Username is invalid");
    	}
    	return navegar;
    }
    
    public void logout() {
    	FacesContext.getCurrentInstance().getExternalContext()
    	.invalidateSession();
    	FacesContext
    	.getCurrentInstance()
    	.getApplication()
    	.getNavigationHandler()
    	.handleNavigation(FacesContext.getCurrentInstance(), null,
    	"/index.xhtml?faces-redirect=true");
    }    

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
  
}