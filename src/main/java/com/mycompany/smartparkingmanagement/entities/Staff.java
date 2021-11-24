package com.mycompany.smartparkingmanagement.entities;

import java.io.Serializable;

public class Staff implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private String gender;
    private String emailId;
    private String alternate_emailId;
    private long phoneNo;
    private long alternate_phoneNo;
    private String country;
    private String state;
    private String city;
    private long aadhaarNo;
    private String pancardNo;
    private String signature;
    private String username;
    private String password;
    private String role;
    private String profile;

    public Staff(String firstName, String middleName, String lastName, String dob, String gender, String emailId, String alternate_emailId, long phoneNo, long alternate_phoneNo, String country, String state, String city, long aadhaarNo, String pancardNo, String username, String password, String role) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.emailId = emailId;
        this.alternate_emailId = alternate_emailId;
        this.phoneNo = phoneNo;
        this.alternate_phoneNo = alternate_phoneNo;
        this.country = country;
        this.state = state;
        this.city = city;
        this.aadhaarNo = aadhaarNo;
        this.pancardNo = pancardNo;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Staff() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAlternate_emailId() {
        return alternate_emailId;
    }

    public void setAlternate_emailId(String alternate_emailId) {
        this.alternate_emailId = alternate_emailId;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public long getAlternate_phoneNo() {
        return alternate_phoneNo;
    }

    public void setAlternate_phoneNo(long alternate_phoneNo) {
        this.alternate_phoneNo = alternate_phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(long aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getPancardNo() {
        return pancardNo;
    }

    public void setPancardNo(String pancardNo) {
        this.pancardNo = pancardNo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Staff{" + "firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender + ", emailId=" + emailId + ", alternate_emailId=" + alternate_emailId + ", country=" + country + ", state=" + state + ", city=" + city + ", pancardNo=" + pancardNo + ", signature=" + signature + ", username=" + username + ", password=" + password + ", role=" + role + ", profile=" + profile + '}';
    }
}
