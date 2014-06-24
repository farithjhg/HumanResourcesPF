package com.wolfsoft.hr.entity; 

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Regions.findAll", query = "select o from Regions o") 
public class Regions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="region_id", nullable = false)
    private Integer regionId;
    @Column(name="region_name")
    private String regionName;
    @OneToMany(mappedBy = "regions")
    private List <Countries> countriesList;

    public Regions() {
    }

    public Integer getRegionId(){
        return regionId;
    }

    public void setRegionId(Integer regionId){
        this.regionId = regionId;
    }

    public String getRegionName(){
        return regionName;
    }

    public void setRegionName(String regionName){
        this.regionName = regionName;
    }

    public List<Countries>  getCountriesList(){
        return countriesList;
    }

    public void setCountries(List<Countries> countries){
        this.countriesList = countries;
    }

}
