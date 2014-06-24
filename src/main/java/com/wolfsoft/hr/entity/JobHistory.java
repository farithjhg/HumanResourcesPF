package com.wolfsoft.hr.entity; 

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@NamedQuery(name = "JobHistory.findAll", query = "select o from JobHistory o") 
@Table(name = "job_history")
public class JobHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private JobHistoryPK pk;
    @Column(name="employee_id", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;
    @ManyToOne(cascade = { }, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id" , insertable=false, updatable=false)
    private Employees employees;
    @Column(name="start_date", nullable = false, insertable = false, updatable = false)
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;
    @Column(name="job_id", insertable = false, updatable = false)
    private String jobId;
    @ManyToOne(cascade = { }, fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id" , insertable=false, updatable=false)
    private Jobs jobs;
    @Column(name="department_id", insertable = false, updatable = false)
    private Integer departmentId;
    @ManyToOne(cascade = { }, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id" , insertable=false, updatable=false)
    private Departments departments;

    public JobHistory() {
        employees = new Employees();
        jobs = new Jobs();
        departments = new Departments();
    }

    public JobHistoryPK getPk() {
        return pk;
    }

    public void setPk(JobHistoryPK pk) {
        this.pk = pk;
    }

    public Integer getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId){
        this.employeeId = employeeId;
    }

    public Employees  getEmployees(){
        return employees;
    }

    public void setEmployees(Employees employees){
        this.employees = employees;
    }

    public Date getStartDate(){
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public String getJobId(){
        return jobId;
    }

    public void setJobId(String jobId){
        this.jobId = jobId;
    }

    public Jobs  getJobs(){
        return jobs;
    }

    public void setJobs(Jobs jobs){
        this.jobs = jobs;
    }

    public Integer getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId){
        this.departmentId = departmentId;
    }

    public Departments  getDepartments(){
        return departments;
    }

    public void setDepartments(Departments departments){
        this.departments = departments;
    }

}
