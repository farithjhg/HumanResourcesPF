drop table rol if exists;
CREATE TABLE rol (
  role_id INT(4) NOT NULL,
  role_name varchar(20) DEFAULT '' NOT NULL,
  PRIMARY KEY (role_id)
);

drop table user if exists;
CREATE TABLE user (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  user_login varchar(60) NOT NULL DEFAULT '',
  user_pass varchar(64) NOT NULL DEFAULT '',
  user_nicename varchar(50) NOT NULL DEFAULT '',
  user_email varchar(100) NOT NULL DEFAULT '',
  user_url varchar(100) NOT NULL DEFAULT '',
  user_registered datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  user_activation_key varchar(60) NOT NULL DEFAULT '',
  user_status int(11) NOT NULL DEFAULT '0',
  display_name varchar(250) NOT NULL DEFAULT '',
  role_id INT(4) NOT NULL,
  PRIMARY KEY (id),
  KEY user_login_key (user_login),
  KEY user_nicename (user_nicename)
);


ALTER TABLE user
ADD (FOREIGN KEY (role_id)
REFERENCES rol(role_id));

drop table regions exists;
CREATE TABLE regions
( region_id INT NOT NULL
, region_name varchar(25),
primary key (region_id)
);


CREATE TABLE countries
( country_id CHAR(2) NOT NULL
, country_name varchar(40)
, region_id INT
, PRIMARY KEY (country_id)
) ;


ALTER TABLE countries
ADD (FOREIGN KEY (region_id)
REFERENCES regions(region_id)
) ;

CREATE TABLE locations
( location_id INT(4)
, street_address varchar(40)
, postal_code varchar(12)
, city varchar(30) NOT NULL
, state_province varchar(25)
, country_id CHAR(2)
, PRIMARY KEY (location_id)
) auto_increment=3300;

/*
CREATE SEQUENCE locations_seq\
START WITH 3300\
INCREMENT BY 100\
MAXVALUE 9900\
NOCACHE\
NOCYCLE;\
*/

ALTER TABLE locations
ADD ( FOREIGN KEY (country_id)
REFERENCES countries(country_id)
) ;

CREATE TABLE departments
( department_id INT(4)
, department_name varchar(30) NOT NULL
, manager_id INT(6)
, location_id INT(4)
, PRIMARY KEY (department_id)
) auto_increment=280;

ALTER TABLE departments
ADD ( FOREIGN KEY (location_id)
REFERENCES locations (location_id)
) ;

/*
CREATE SEQUENCE departments_seq\
START WITH 280\
INCREMENT BY 10\
MAXVALUE 9990\
NOCACHE\
NOCYCLE;\
*/

CREATE TABLE jobs
( job_id VARCHAR(10)
, job_title VARCHAR(35) NOT NULL
, min_salary DECIMAL(10,2)
, max_salary DECIMAL(10,2)
, PRIMARY KEY (job_id)
) ;

CREATE TABLE job_history 
    ( 
     employee_id int (6)  not null , 
     start_date date  not null , 
     end_date date  not null , 
     job_id varchar (10)  not null , 
     department_id int (4)
	 , PRIMARY KEY (employee_id, start_date)
	 
    ) ;



ALTER TABLE job_history 
    ADD CONSTRAINT JHIST_DATE_CHECK 
    CHECK (end_date > start_date);

ALTER TABLE job_history 
ADD INDEX JHIST_JOB_IX (job_id ASC);

ALTER TABLE job_history
ADD INDEX JHIST_EMP_IX (employee_id ASC);

ALTER TABLE job_history 
ADD INDEX JHIST_DEPT_IX (department_id ASC);

ALTER TABLE job_history 
ADD UNIQUE INDEX JHIST_ID_DATE_PKX (employee_id ASC, start_date ASC);


CREATE TABLE employees
( employee_id INT(6)
, first_name varchar(20)
, last_name varchar(25) NOT NULL
, email varchar(25) NOT NULL
, phone_INT varchar(20)
, hire_date DATE NOT NULL
, job_id varchar(10) NOT NULL
, salary DECIMAL(8,2)
, commission_pct DECIMAL(2,2)
, manager_id INT(6)
, department_id INT(4)
, UNIQUE KEY (email)
, PRIMARY KEY (employee_id)
) auto_increment=207;

ALTER TABLE job_history
ADD (FOREIGN KEY (job_id)
REFERENCES jobs(job_id));


ALTER TABLE job_history
ADD ( FOREIGN KEY (employee_id)
REFERENCES employees(employee_id));

ALTER TABLE job_history
ADD (FOREIGN KEY (department_id)
REFERENCES departments(department_id)) ;


CREATE OR REPLACE VIEW emp_details_view
(employee_id, job_id, manager_id,
department_id, location_id, country_id,
first_name, last_name, salary,
commission_pct, department_name, job_title,
city, state_province, country_name, region_name)
AS SELECT
e.employee_id, e.job_id, e.manager_id,
e.department_id, d.location_id, l.country_id,
e.first_name, e.last_name, e.salary,
e.commission_pct, d.department_name, j.job_title,
l.city, l.state_province, c.country_name, r.region_name
FROM
employees e, departments d, jobs j,locations l,
countries c, regions r
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
AND l.country_id = c.country_id
AND c.region_id = r.region_id
AND j.job_id = e.job_id ;