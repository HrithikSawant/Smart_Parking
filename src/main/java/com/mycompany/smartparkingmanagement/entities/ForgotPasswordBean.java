/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.entities;

public class ForgotPasswordBean {
    private String username;
    private String emailid;
    private String role;
    private Boolean status;

    public ForgotPasswordBean() {
    }

    public ForgotPasswordBean(String username, String emailid, String role) {
        this.username = username;
        this.emailid = emailid;
        this.role = role;
    }
    
    
    
    public ForgotPasswordBean(String username, String emailid, String role, Boolean status) {
        this.username = username;
        this.emailid = emailid;
        this.role = role;
        this.status = status;
    }
   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ForgotPasswordBean{" + "username=" + username + ", emailid=" + emailid + ", role=" + role + ", status=" + status + '}';
    }
    

    
    
    
}
