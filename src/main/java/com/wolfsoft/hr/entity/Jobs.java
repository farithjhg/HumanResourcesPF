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
@NamedQuery(name = "Jobs.findAll", query = "select o from Jobs o") 
public class Jobs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="job_id", nullable = false)
    private String jobId;
    @Column(name="job_title")
    private String jobTitle;
    @Column(name="min_salary")
    private Long minSalary;
    @Column(name="max_salary")
    private Long maxSalary;
    @OneToMany(mappedBy = "jobs")
    private List <JobHistory> jobHistoryList;

    public Jobs() {
    }

    public String getJobId(){
        return jobId;
    }

    public void setJobId(String jobId){
        this.jobId = jobId;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public Long getMinSalary(){
        return minSalary;
    }

    public void setMinSalary(Long minSalary){
        this.minSalary = minSalary;
    }

    public Long getMaxSalary(){
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary){
        this.maxSalary = maxSalary;
    }

    public List<JobHistory>  getJobHistoryList(){
        return jobHistoryList;
    }

    public void setJobHistory(List<JobHistory> jobHistory){
        this.jobHistoryList = jobHistory;
    }

}
