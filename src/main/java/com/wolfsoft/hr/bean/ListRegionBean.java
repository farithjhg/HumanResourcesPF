package com.wolfsoft.hr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.wolfsoft.hr.entity.Regions;
import com.wolfsoft.hr.factory.ServicesFactory;
import com.wolfsoft.hr.service.RegionsService;
import com.wolfsoft.hr.util.HRUtility;

@SessionScoped
@ManagedBean
public class ListRegionBean extends GeneralBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Regions> regionsList;
	private List<Regions> filteredRegions;
	private RegionsService regionsService;
	private Regions region;
	private boolean editMode = false;
	private int rowSelected;
	
	@PostConstruct
	public void postContruct() {
		try {
			regionsService = ServicesFactory.getRegionsService();
			regionsList = regionsService.findAll();
			region = new Regions();
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_MANAGED_BEAN
					+ this.getClass().getName() + ", Error: " + e.getMessage());
		}		
	}

	/**
	 * Close the actual program 
	 * and come back to Home page 
	 * @return
	 */
	public String back() {
		return HRUtility.regresar("listRegionBean", "/pages/home.xhtml?faces-redirect=true");
	}
	
	/**
	 * Create a new Entity
	 * @param ae
	 */
	public void newRegions(){
		region = new Regions();
		editMode = false;
	}
	
	/**
	 * Save Entity to DB
	 * @return
	 */
	public String saveEntity() {
		try {
			regionsService.save(region);
			if (!editMode) {
				regionsList.add(region);
				HRUtility.asignarMensajeInfo("Region [" + region.getRegionId() + ","
						+ region.getRegionName()+ "] Added Satisfactorily!");
			} else {
				regionsList.set(rowSelected, region);
				HRUtility.asignarMensajeInfo("Region [" + region.getRegionId() + ","
						+ region.getRegionName()+ "] Updated Satisfactorily!");
			}
			editMode = false;
			closeDialog("regionEditDialogWidget");
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_GRABAR + e);
		}
		return null;
	}	
	
	public void delete(){
		try {
			regionsService.delete(region);
			regionsList.remove(region);
			HRUtility.asignarMensajeInfo("Registro [" + region.getRegionId() + ":"
					+ region.getRegionName() + "] Eliminado Satisfactoriamente!");
			closeDialog("regionDeleteDialogWidget");
		} catch (Exception e) {
			HRUtility.asignarMensajeError(HRUtility.ERROR_MENSAJE_ELIMINAR
					+ "\n" + HRUtility.getRootErrorMessage(e));
		}		
	}
	
	public List<Regions> getRegionsList() {
		return regionsList;
	}

	public void setRegionsList(List<Regions> regionsList) {
		this.regionsList = regionsList;
	}

	public Regions getRegion() {
		return region;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public int getRowSelected() {
		return rowSelected;
	}

	public void setRowSelected(int rowSelected) {
		this.rowSelected = rowSelected;
	}

	public List<Regions> getFilteredRegions() {
		return filteredRegions;
	}

	public void setFilteredRegions(List<Regions> filteredRegions) {
		this.filteredRegions = filteredRegions;
	}
}
