package com.wolfsoft.hr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.sun.faces.context.flash.ELFlash;
import com.wolfsoft.hr.entity.Rol;
import com.wolfsoft.hr.factory.ServicesFactory;
import com.wolfsoft.hr.service.RolService;
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
public class ListaRolBean extends GeneralBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String SELECTED_ROL = "selectedRol";
	private List<Rol> listaDatos;
	private List<Rol> filteredRols;
	private Rol rol;
	private int tipoEdicion = 1;
	private int rowSelected = -1;
	private RolService rolService;

	@PostConstruct
	public void postContruct() {
		try {
			rolService = ServicesFactory.getRolService();
			listaDatos = rolService.findAll();
			rol = new Rol();
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_MANAGED_BEAN
					+ this.getClass().getName() + ", Error: " + e.getMessage());
		}
	}

	public String regresar() {
		return HRUtility.regresar("listaRolBean", "/pages/home.xhtml?faces-redirect=true");
	}

	public void nuevo(ActionEvent ae) {
		tipoEdicion = 1;
		rol = new Rol();
	}

	public void delete() {
		try {
			rolService.delete(rol);
			listaDatos.remove(rol);
			HRUtility.asignarMensajeInfo("Registro [" + rol.getRoleId() + ":"
					+ rol.getRoleName() + "] Eliminado Satisfactoriamente!");
			closeDialog("rolDeleteDialogWidget");
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_ELIMINAR
					+ "\n" + HRUtility.getRootErrorMessage(e));
		}
	}

	public String grabar() {
		try {
			rolService.save(rol);
			if (tipoEdicion == 1) {
				listaDatos.add(rol);
				HRUtility.asignarMensajeInfo("Row [" + rol.getRoleId() + ","
						+ rol.getRoleName() + "] Added Satisfactorily!");
			} else {
				listaDatos.set(rowSelected, rol);
				HRUtility.asignarMensajeInfo("Row [" + rol.getRoleId() + ","
						+ rol.getRoleName() + "] Updated Satisfactorily!");
			}
			tipoEdicion = 1;
			rol = null;
			closeDialog("rolEditDialogWidget");
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_GRABAR + e);
		}
		return null;
	}
	
	public String getListUsers(Rol rol){
		ELFlash.getFlash().put(SELECTED_ROL, rol);
		return "/pages/listUsers.xhtml?faces-redirect=true";
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

	public List<Rol> getListaDatos() {
		return listaDatos;
	}

	public void setListaDatos(List<Rol> listaDatos) {
		this.listaDatos = listaDatos;
	}

	public List<Rol> getFilteredRols() {
		return filteredRols;
	}

	public void setFilteredRols(List<Rol> filteredRols) {
		this.filteredRols = filteredRols;
	}
	
	public int getTipoEdicion() {
		return tipoEdicion;
	}

	public void setTipoEdicion(int tipoEdicion) {
		this.tipoEdicion = tipoEdicion;
	}
	
}
