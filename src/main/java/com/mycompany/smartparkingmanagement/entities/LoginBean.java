
package com.mycompany.smartparkingmanagement.entities;

import java.io.Serializable;

public class LoginBean implements Serializable {
    private String userName;
    private String password;
    private String role;
    private String emailid;
    private String profile;
    private String gender;
    private String firstName;
    boolean block;

    
    
    public LoginBean(String userName, String role, String emailid) {
        this.userName = userName;
        this.role = role;
        this.emailid = emailid;
    }

    public LoginBean(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public LoginBean(String userName, String emailid, String profile, String gender, String firstName,String role) {
        this.userName = userName;
        this.emailid = emailid;
        this.profile = profile;
        this.gender = gender;
        this.firstName = firstName;
        this.role = role;
    }
    
    
    public LoginBean() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "LoginBean{" + "userName=" + userName + ", password=" + password + ", role=" + role + ", emailid=" + emailid + ", profile=" + profile + ", gender=" + gender + ", firstName=" + firstName + '}';
    }

        
    
   
}
