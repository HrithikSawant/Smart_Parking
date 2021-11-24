package com.mycompany.smartparkingmanagement.entities;

import java.io.Serializable;

public class BookingBean implements Serializable {

    private int book_id;
    private String cust_name;
    private String cust_surname;
    private String vehicle_type;
    private String vehicle_no;
    private String date;
    private String str_start_time;
    private String str_end_time;
    private double total_amount;
    private double amount_paid;
    private double new_total_amount;
    private int slot_no;
    private String checkIn;
    private String checkOut;
    private String booked_date;
    private String msg;
    private boolean bool;

//    private String start_hrs;//
//    private String start_mins;//
//    private String end_hrs;//
//    private String end_mins;//
    public BookingBean() {
    }

    public BookingBean(int book_id, String cust_name, String cust_surname, String vehicle_no, String date) {
        this.book_id = book_id;
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.vehicle_no = vehicle_no;
        this.date = date;
    }

    
    public BookingBean(String cust_name, String cust_surname, String vehicle_type, String vehicle_no, String date, String str_start_time, String str_end_time) {
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.vehicle_type = vehicle_type;
        this.vehicle_no = vehicle_no;
        this.date = date;
        this.str_start_time = str_start_time;
        this.str_end_time = str_end_time;
    }

    public BookingBean(String cust_name, String cust_surname, String vehicle_type, String vehicle_no, String date, String str_start_time, String str_end_time, double total_amount, double amount_paid, int slot_no) {
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.vehicle_type = vehicle_type;
        this.vehicle_no = vehicle_no;
        this.date = date;
        this.str_start_time = str_start_time;
        this.str_end_time = str_end_time;
        this.total_amount = total_amount;
        this.amount_paid = amount_paid;
        this.slot_no = slot_no;
    }

    //used for showing data
    public BookingBean(int book_id, String cust_name, String cust_surname, String vehicle_type, String vehicle_no, String date, String str_start_time, String str_end_time, double total_amount, double amount_paid,int slot_no, String checkIn, String checkOut, String booked_date, String msg, boolean bool) {
        this.book_id = book_id;
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.vehicle_type = vehicle_type;
        this.vehicle_no = vehicle_no;
        this.date = date;
        this.str_start_time = str_start_time;
        this.str_end_time = str_end_time;
        this.total_amount = total_amount;
        this.amount_paid = amount_paid;
        this.slot_no = slot_no;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.booked_date = booked_date;
        this.msg = msg;
        this.bool = bool;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getBooked_date() {
        return booked_date;
    }

    public void setBooked_date(String booked_date) {
        this.booked_date = booked_date;
    }
    
    
    
    
    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_surname() {
        return cust_surname;
    }

    public void setCust_surname(String cust_surname) {
        this.cust_surname = cust_surname;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStr_start_time() {
        return str_start_time;
    }

    public void setStr_start_time(String str_start_time) {
        this.str_start_time = str_start_time;
    }

    public String getStr_end_time() {
        return str_end_time;
    }

    public void setStr_end_time(String str_end_time) {
        this.str_end_time = str_end_time;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public double getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public double getNew_total_amount() {
        return new_total_amount;
    }

    public void setNew_total_amount(double new_total_amount) {
        this.new_total_amount = new_total_amount;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    

    @Override
    public String toString() {
        return "BookingBean{" + "cust_name=" + cust_name + ", cust_surname=" + cust_surname + ", vehicle_type=" + vehicle_type + ", vehicle_no=" + vehicle_no + ", date=" + date + ", str_start_time=" + str_start_time + ", str_end_time=" + str_end_time + ", msg=" + msg + '}';
    }
}
