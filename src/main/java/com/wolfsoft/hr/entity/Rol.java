package com.wolfsoft.hr.entity; 

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Rol.findAll", query = "select o from Rol o") 
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="role_id", nullable = false)
    private Integer roleId;
    @Column(name="role_name")
    private String roleName;
    @OneToMany(mappedBy = "rol")
    private List <User> userList;

    public Rol() {
    }

    public Integer getRoleId(){
        return roleId;
    }

    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    public String getRoleName(){
        return roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public List<User>  getUserList(){
        return userList;
    }

    public void setUser(List<User> user){
        this.userList = user;
    }

}
