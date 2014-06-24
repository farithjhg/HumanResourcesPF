package com.wolfsoft.hr.entity; 

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Countries.findAll", query = "select o from Countries o") 
public class Countries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="country_id", nullable = false)
    private String countryId;
    @Column(name="country_name")
    private String countryName;
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id" , insertable=false, updatable=false)
    private Regions regions;
    @OneToMany(mappedBy = "countries")
    private List <Locations> locationsList;

    public Countries() {
        regions = new Regions();
    }

    public String getCountryId(){
        return countryId;
    }

    public void setCountryId(String countryId){
        this.countryId = countryId;
    }

    public String getCountryName(){
        return countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public Regions  getRegions(){
        return regions;
    }

    public void setRegions(Regions regions){
        this.regions = regions;
    }

    public List<Locations>  getLocationsList(){
        return locationsList;
    }

    public void setLocations(List<Locations> locations){
        this.locationsList = locations;
    }

}
