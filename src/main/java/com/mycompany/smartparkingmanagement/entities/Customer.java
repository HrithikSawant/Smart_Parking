/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.entities;

public class Customer {
    int id;
    String firstName;
            String middleName;
            String lastName;
            String dob;
            String gender;
            String emailId;
            String alternate_emailId;
            String alternate;
            String country;
            String state;
            String city;
            long phoneNo;
            String LicenseNo;
            long alternate_phoneNo;
            String profile;
            String signature;
            String username;
            String password;
            String role;

    public Customer(int id, String firstName, String middleName, String lastName, String gender, String emailId, String country, String state, String city, long phoneNo, long alternate_phoneNo) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailId = emailId;
        this.country = country;
        this.state = state;
        this.city = city;
        this.phoneNo = phoneNo;
        this.alternate_phoneNo = alternate_phoneNo;
    }

    public Customer() {
    }
    
    public Customer(String firstName, String middleName, String lastName, String dob, String gender, String emailId, String alternate_emailId, String alternate, String country, String state, String city, long phoneNo, String LicenseNo, long alternate_phoneNo, String username, String password, String role) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.emailId = emailId;
        this.alternate_emailId = alternate_emailId;
        this.alternate = alternate;
        this.country = country;
        this.state = state;
        this.city = city;
        this.phoneNo = phoneNo;
        this.LicenseNo = LicenseNo;
        this.alternate_phoneNo = alternate_phoneNo;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAlternate() {
        return alternate;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
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

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLicenseNo() {
        return LicenseNo;
    }

    public void setLicenseNo(String LicenseNo) {
        this.LicenseNo = LicenseNo;
    }

    public long getAlternate_phoneNo() {
        return alternate_phoneNo;
    }

    public void setAlternate_phoneNo(long alternate_phoneNo) {
        this.alternate_phoneNo = alternate_phoneNo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender + ", emailId=" + emailId + ", alternate_emailId=" + alternate_emailId + ", alternate=" + alternate + ", country=" + country + ", state=" + state + ", city=" + city + ", LicenseNo=" + LicenseNo + ", profile=" + profile + ", signature=" + signature + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

    
   }
