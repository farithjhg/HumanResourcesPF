package com.wolfsoft.hr.entity; 

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Employees.findAll", query = "select o from Employees o") 
public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="employee_id", nullable = false)
    private Integer employeeId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="hire_date")
    private Date hireDate;
    @Column(name="job_id")
    private String jobId;
    @Column(name="salary")
    private Long salary;
    @Column(name="commission_pct")
    private Long commissionPct;
    @Column(name="manager_id")
    private Integer managerId;
    @Column(name="department_id")
    private Integer departmentId;
    @OneToMany(mappedBy = "employees")
    private List <JobHistory> jobHistoryList;

    public Employees() {
    }

    public Integer getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId){
        this.employeeId = employeeId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Date getHireDate(){
        return hireDate;
    }

    public void setHireDate(Date hireDate){
        this.hireDate = hireDate;
    }

    public String getJobId(){
        return jobId;
    }

    public void setJobId(String jobId){
        this.jobId = jobId;
    }

    public Long getSalary(){
        return salary;
    }

    public void setSalary(Long salary){
        this.salary = salary;
    }

    public Long getCommissionPct(){
        return commissionPct;
    }

    public void setCommissionPct(Long commissionPct){
        this.commissionPct = commissionPct;
    }

    public Integer getManagerId(){
        return managerId;
    }

    public void setManagerId(Integer managerId){
        this.managerId = managerId;
    }

    public Integer getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId){
        this.departmentId = departmentId;
    }

    public List<JobHistory>  getJobHistoryList(){
        return jobHistoryList;
    }

    public void setJobHistory(List<JobHistory> jobHistory){
        this.jobHistoryList = jobHistory;
    }

}
