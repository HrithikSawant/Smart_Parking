/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.entities;

public class vehicle {

    int Book_id;
    String Cust_name;
    String Cust_surname;
    String Vehicle_no;
    String Date;

    public vehicle(int Book_id, String Cust_name, String Cust_surname, String Vehicle_no, String Date) {
        this.Book_id = Book_id;
        this.Cust_name = Cust_name;
        this.Cust_surname = Cust_surname;
        this.Vehicle_no = Vehicle_no;
        this.Date = Date;
    }

    public int getBook_id() {
        return Book_id;
    }

    public void setBook_id(int Book_id) {
        this.Book_id = Book_id;
    }

    public String getCust_name() {
        return Cust_name;
    }

    public void setCust_name(String Cust_name) {
        this.Cust_name = Cust_name;
    }

    public String getCust_surname() {
        return Cust_surname;
    }

    public void setCust_surname(String Cust_surname) {
        this.Cust_surname = Cust_surname;
    }

    public String getVehicle_no() {
        return Vehicle_no;
    }

    public void setVehicle_no(String Vehicle_no) {
        this.Vehicle_no = Vehicle_no;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

}
