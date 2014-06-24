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
@NamedQuery(name = "Locations.findAll", query = "select o from Locations o") 
public class Locations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="location_id", nullable = false)
    private Integer locationId;
    @Column(name="street_address")
    private String streetAddress;
    @Column(name="postal_code")
    private String postalCode;
    @Column(name="city")
    private String city;
    @Column(name="state_province")
    private String stateProvince;
    @Column(name="country_id", insertable = false, updatable = false)
    private String countryId;
    @ManyToOne(cascade = { }, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id" , insertable=false, updatable=false)
    private Countries countries;
    @OneToMany(mappedBy = "locations")
    private List <Departments> departmentsList;

    public Locations() {
        countries = new Countries();
    }

    public Integer getLocationId(){
        return locationId;
    }

    public void setLocationId(Integer locationId){
        this.locationId = locationId;
    }

    public String getStreetAddress(){
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getStateProvince(){
        return stateProvince;
    }

    public void setStateProvince(String stateProvince){
        this.stateProvince = stateProvince;
    }

    public String getCountryId(){
        return countryId;
    }

    public void setCountryId(String countryId){
        this.countryId = countryId;
    }

    public Countries  getCountries(){
        return countries;
    }

    public void setCountries(Countries countries){
        this.countries = countries;
    }

    public List<Departments>  getDepartmentsList(){
        return departmentsList;
    }

    public void setDepartments(List<Departments> departments){
        this.departmentsList = departments;
    }

}
