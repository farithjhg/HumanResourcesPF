package com.wolfsoft.hr.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import com.sun.faces.context.flash.ELFlash;
import com.wolfsoft.hr.entity.Rol;
import com.wolfsoft.hr.entity.User;
import com.wolfsoft.hr.factory.ServicesFactory;
import com.wolfsoft.hr.service.RolService;
import com.wolfsoft.hr.service.UserService;
import com.wolfsoft.hr.util.HRUtility;

/**
 * <p>
 * Title: ...
 * </p>
 * 
 * <p>
 * Description: Managed Bean
 * 
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Wolfsoft Co.
 * </p>
 * 
 * @author Farith José Heras García
 * @version 1.0
 */

@SessionScoped
@ManagedBean
public class ListaUserBean extends GeneralBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String SELECTED_ROL = "selectedRol";
	private List<User> listaDatos;
	private List<User> filteredUsers;
	private List<SelectItem> rols;
	private Rol rol;
	private User user;
	private int tipoEdicion = 1;
	private int rowSelected = -1;
	private UserService userService;
	private RolService rolService;
	private Integer roleId;
	
	@PostConstruct
	public void postContruct() {
		try {
			userService = ServicesFactory.getUserService();
			rolService = ServicesFactory.getRolService();
			getRolsAsSelectItems(rolService.findAll());
			rol = (Rol) ELFlash.getFlash().get(SELECTED_ROL);
			if(rol!=null)
				listaDatos = userService.findByRoleId(rol.getRoleId());
			else
				listaDatos = userService.findAll();
			user = new User();
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_MANAGED_BEAN
					+ this.getClass().getName() + ", Error: " + e.getMessage());
		}
	}
	
	public void filterByRol(ActionEvent ae){
		if(!roleId.equals(0)){
			listaDatos = userService.findByRoleId(roleId);
		}else{
			listaDatos = userService.findAll();
		}
	}
	
	private void getRolsAsSelectItems(List<Rol> rolsList) {
    	rols = new ArrayList<SelectItem>();
        for (Rol rol : rolsList) {
        	rols.add(new SelectItem(rol.getRoleId(), rol.getRoleName()));
        }
    } 	

	public String regresar() {
		if(rol!=null)
			return HRUtility.regresar("listaUserBean", "/pages/listRols.xhtml?faces-redirect=true");
		else
			return HRUtility.regresar("listaUserBean", "/pages/home.xhtml?faces-redirect=true");
	}

	public void nuevo() {
		tipoEdicion = 1;
		user = new User();
		if(rol!=null){
			user.setRol(rol);
			user.setRoleId(rol.getRoleId());
		}else{
			if(!roleId.equals(0))
				user.setRoleId(rol.getRoleId());
		}
	}

	public void delete() {
		try {
			userService.delete(user);
			listaDatos.remove(user);
			HRUtility.asignarMensajeInfo("Registro [" + user.getId() + ":"
					+ user.getUserLogin() + "] Eliminado Satisfactoriamente!");
			closeDialog("userDeleteDialogWidget");
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_ELIMINAR
					+ "\n" + HRUtility.getRootErrorMessage(e));
		}
	}

	public String grabar() {
		try {
			user.setRol(rolService.findByPK(user.getRoleId()));
			userService.save(user);
			if (tipoEdicion == 1) {
				listaDatos.add(user);
				HRUtility.asignarMensajeInfo("User [" + user.getId() + ","
						+ user.getUserLogin() + "] Added Satisfactorily!");
			} else {
				listaDatos.set(rowSelected, user);
				HRUtility.asignarMensajeInfo("User [" + user.getId() + ","
						+ user.getUserLogin() + "] Updated Satisfactorily!");
			}
			tipoEdicion = 1;
			user = new User();
			closeDialog("userEditDialogWidget");
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_GRABAR + e);
		}
		return null;
	}
	
	
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public int getRowSelected() {
		return rowSelected;
	}

	public void setRowSelected(int rowSelected) {
		this.rowSelected = rowSelected;
	}

	public List<User> getListaDatos() {
		return listaDatos;
	}

	public void setListaDatos(List<User> listaDatos) {
		this.listaDatos = listaDatos;
	}

	public int getTipoEdicion() {
		return tipoEdicion;
	}

	public void setTipoEdicion(int tipoEdicion) {
		this.tipoEdicion = tipoEdicion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public List<SelectItem> getRols() {
		return rols;
	}

	public void setRols(List<SelectItem> rols) {
		this.rols = rols;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
