package com.wolfsoft.hr.entity; 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "User.findAll", query = "select o from User o") 
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id", nullable = false)
    private Long id;
    @Column(name="user_login")
    private String userLogin;
    @Column(name="user_pass")
    private String userPass;
    @Column(name="user_nicename")
    private String userNicename;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="user_status")
    private Integer userStatus;
    @Column(name="role_id", insertable = false, updatable = false)
    private Integer roleId;
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Rol rol;

    public User() {
        rol = new Rol();
        userStatus = 1;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUserLogin(){
        return userLogin;
    }

    public void setUserLogin(String userLogin){
        this.userLogin = userLogin;
    }

    public String getUserPass(){
        return userPass;
    }

    public void setUserPass(String userPass){
        this.userPass = userPass;
    }

    public String getUserNicename(){
        return userNicename;
    }

    public void setUserNicename(String userNicename){
        this.userNicename = userNicename;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public Integer getUserStatus(){
        return userStatus;
    }

    public void setUserStatus(Integer userStatus){
        this.userStatus = userStatus;
    }

    public Integer getRoleId(){
        return roleId;
    }

    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    public Rol  getRol(){
        return rol;
    }

    public void setRol(Rol rol){
        this.rol = rol;
    }

}
