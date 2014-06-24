package com.wolfsoft.hr.entity; 

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class JobHistoryPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="employee_id", nullable = false, insertable = true, updatable = true)
    private Integer employeeId;
    @Column(name="start_date", nullable = false, insertable = true, updatable = true)
    private Date startDate;

    public JobHistoryPK() {
    }

    public JobHistoryPK(Integer employeeid,Date startdate) {
        this.employeeId = employeeid;
        this.startDate = startdate;
    }

    public Integer getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId){
        this.employeeId = employeeId;
    }

    public Date getStartDate(){
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public boolean equals(Object other) {
        if (other instanceof JobHistoryPK) {
            final JobHistoryPK otherJobHistoryPK = (JobHistoryPK) other;
            final boolean areEqual =
                (otherJobHistoryPK.employeeId.equals(employeeId) && otherJobHistoryPK.startDate.equals(startDate));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

}
