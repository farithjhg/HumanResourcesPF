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
@NamedQuery(name = "Departments.findAll", query = "select o from Departments o") 
public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="department_id", nullable = false)
    private Integer departmentId;
    @Column(name="department_name")
    private String departmentName;
    @Column(name="manager_id")
    private Integer managerId;
    @Column(name="location_id", insertable = false, updatable = false)
    private Integer locationId;
    @ManyToOne(cascade = { }, fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id" , insertable=false, updatable=false)
    private Locations locations;
    @OneToMany(mappedBy = "departments")
    private List <JobHistory> jobHistoryList;

    public Departments() {
        locations = new Locations();
    }

    public Integer getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId){
        this.departmentId = departmentId;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public Integer getManagerId(){
        return managerId;
    }

    public void setManagerId(Integer managerId){
        this.managerId = managerId;
    }

    public Integer getLocationId(){
        return locationId;
    }

    public void setLocationId(Integer locationId){
        this.locationId = locationId;
    }

    public Locations  getLocations(){
        return locations;
    }

    public void setLocations(Locations locations){
        this.locations = locations;
    }

    public List<JobHistory>  getJobHistoryList(){
        return jobHistoryList;
    }

    public void setJobHistory(List<JobHistory> jobHistory){
        this.jobHistoryList = jobHistory;
    }

}
