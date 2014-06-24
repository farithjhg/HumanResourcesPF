package com.wolfsoft.hr.service; 

import java.util.List;

import java.sql.Date;
import com.wolfsoft.hr.entity.JobHistory;
import com.wolfsoft.hr.entity.JobHistoryPK;
/**
* <p>Title: Services Interface Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Service Interface que representa ... 
*    los metodos de Persistencia de la tabla job_history. 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
public interface JobHistoryService {

    /**
     * Return JobHistory's entity by PK
     * @return JobHistory
     */
    public JobHistory findByPK(JobHistoryPK pk);

    /**
     * Return all JobHistory rows 
     */
    public List<JobHistory> findAll();

    /**
     * Add a row in the JobHistory Table
     * @return JobHistory
     */
    public JobHistory save(JobHistory entity);

    /**
    * Delete a row in the JobHistory Table by PK 
    */
    public void delete(JobHistory entity);

}
