package com.mycompany.smartparkingmanagement.dao;

import com.mycompany.smartparkingmanagement.entities.BookingBean;
import com.mycompany.smartparkingmanagement.entities.Customer;
import com.mycompany.smartparkingmanagement.entities.Slot;
import com.mycompany.smartparkingmanagement.helper.ConnectionProvider;
import java.sql.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class AdminDao {
    

    public Boolean updateTime(int book_id, String time) {
        Boolean f = false;
        try {

            Connection con = ConnectionProvider.getConnection();
            String sql_update_time;
            if (time.equals("checkin")) {
                sql_update_time = "UPDATE booking SET checkin_time = now() WHERE book_id = ?";
            } else {
                sql_update_time = "UPDATE booking SET checkout_time = now() WHERE book_id = ?";
            }
            PreparedStatement pstmt_update_time = con.prepareStatement(sql_update_time);
            pstmt_update_time.setInt(1, book_id);
            int rowInserted = pstmt_update_time.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new record is updated");
                //;
                f = true;
            }
        } catch (Exception e) {
            System.out.println("Error in updateTime " + e);
            //
        }
        return f;
    }

    public BookingBean totalCost(int book_id) {

        BookingBean bk = null;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_book = "SELECT * FROM booking WHERE book_id = ?";
            PreparedStatement pstmt_book = con.prepareStatement(sql_book);
            pstmt_book.setInt(1, book_id);
            ResultSet rs_book = pstmt_book.executeQuery();
            String vehicle_type = "";
            int paid_amount = 0;
            String new_start_datetime = "";
            String new_end_datetime = "";
            String checkout_time = "";
            while (rs_book.next()) {
                vehicle_type = rs_book.getString("vehicle_type");
                paid_amount = rs_book.getInt("paid_amount");
                new_start_datetime = rs_book.getString("start_time");
                new_end_datetime = rs_book.getString("end_time");
                checkout_time = rs_book.getString("checkout_time");
            }

            String start_time = "";
            for (String value : new_start_datetime.split(" ")) {
                start_time = value;
            }
            String end_time = "";
            for (String value : new_end_datetime.split(" ")) {
                end_time = value;
            }
            String sql_vehicle = "SELECT * FROM master where vehicle_type = ?";
            PreparedStatement pstmt_payment = con.prepareStatement(sql_vehicle);
            pstmt_payment.setString(1, vehicle_type);
            ResultSet rs_payment = pstmt_payment.executeQuery();
            int db_rate = 0;
            int db_increment_rate = 0;
            while (rs_payment.next()) {
                db_rate = rs_payment.getInt("rate");
                db_increment_rate = rs_payment.getInt("increment_rate");
            }
            LocalTime conv_start_time = LocalTime.parse(start_time);
            LocalTime conv_end_time = LocalTime.parse(end_time);
            LocalTime conv_checkout_time = LocalTime.parse(checkout_time);

// Calculating the difference in Hours
            int start_checkout_hours = (int) ChronoUnit.HOURS.between(conv_start_time, conv_checkout_time);

// Calculating the difference in Minutes
            int start_checkout_minutes = (int) (ChronoUnit.MINUTES.between(conv_start_time, conv_checkout_time) % 60);

            int end_checkout_hours = (int) ChronoUnit.HOURS.between(conv_end_time, conv_checkout_time);

// Calculating the difference in Minutes
            int end_checkout_minutes = (int) (ChronoUnit.MINUTES.between(conv_end_time, conv_checkout_time) % 60);
            int start_checkout_min = (start_checkout_hours * 60) + start_checkout_minutes;
            int end_checkout_min = (end_checkout_hours * 60) + end_checkout_minutes;
            float total_cost = 0;
            float new_total_cost = 0;
            if (db_increment_rate <= 0 || end_checkout_min <= 0) {

                total_cost = db_rate * (start_checkout_min / 30);

                new_total_cost = total_cost - paid_amount;
                System.out.println("if part");
                if (paid_amount > new_total_cost) {
                    new_total_cost = paid_amount;
                }
            } else {
                new_total_cost = db_increment_rate * (end_checkout_min / 30);
                total_cost = new_total_cost + paid_amount;
                System.out.println("else part");
            }
            bk = new BookingBean();
            bk.setAmount_paid(paid_amount);
            bk.setTotal_amount(total_cost);
            bk.setNew_total_amount(new_total_cost);
            //
            System.out.println("you have already payed " + paid_amount);
            System.out.println("You have to pay total amount :" + total_cost);
            System.out.println("finally you have to pay " + new_total_cost);

            String sql_updatetotal_amount = "UPDATE booking SET total_amount = ? WHERE book_id = ?";
            PreparedStatement pstmt_totalpaid_amount = con.prepareStatement(sql_updatetotal_amount);
            pstmt_totalpaid_amount.setFloat(1, total_cost);
            pstmt_totalpaid_amount.setInt(2, book_id);
            pstmt_totalpaid_amount.executeUpdate();
            int rowInserted = pstmt_totalpaid_amount.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Book No " + book_id + " Updated Successfully ");
                bk.setBool(true);
            } else {
                System.out.println("Cannot Update data ");
                bk.setBool(false);
            }

        } catch (Exception e) {
            bk = new BookingBean();
            System.out.println("Opps Something is wrong in total cost" + e);
            bk.setBool(false);
        }

        return bk;
    }

//bakki hai
    public ArrayList<Slot> bufferSlots(String status) {
        ArrayList<Slot> list = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_buffer_slots = "SELECT * FROM slot WHERE buffer = 'yes' AND status = ?";
            PreparedStatement pstmt_buffer_slots = con.prepareStatement(sql_buffer_slots);
            pstmt_buffer_slots.setString(1, status);
            ResultSet rs_payment = pstmt_buffer_slots.executeQuery();

            while (rs_payment.next()) {
                System.out.println(rs_payment.getInt("slot_id"));
                Slot slot = new Slot(rs_payment.getInt("slot_id"), rs_payment.getString("block_id"));
                list.add(slot);
                System.out.println(list);
            }

        } catch (SQLException e) {
            System.out.println("There is error in bufferSlots " + e);
        }
        return list;
    }

    public boolean allotSlot(int book_id, int slot_id) {
        boolean value = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_slot_status = "SELECT * FROM slot WHERE slot_id = ? AND status = 'green'";
            PreparedStatement pstmt_slot_status = con.prepareStatement(sql_slot_status);
            pstmt_slot_status.setInt(1, slot_id);
            ResultSet rs_slot_status = pstmt_slot_status.executeQuery();
            while (rs_slot_status.next()) {
                System.out.println("Slot is Available");
                value = true;
            }
            if (value) {
                String sql_update_bookingslotid = "UPDATE booking SET slot_id = ? WHERE book_id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql_update_bookingslotid);
                pstmt.setInt(1, slot_id);
                pstmt.setInt(2, book_id);
                int rowInserted = pstmt.executeUpdate();
                if (rowInserted > 0) {
                    System.out.println("A new record is updated");
                }
            } else {
                System.out.println("Sorry!!! Slot No " + slot_id + " is occupied already.");
                value = false;
            }
        } catch (Exception e) {
            System.out.println("There is error in allotSlot " + e);
        }
        return value;
    }

    public boolean addSlot(String block_id, String status, String buffer) {
        boolean f = false;
        try {

            Connection con = ConnectionProvider.getConnection();
            String sql_addslot = "INSERT INTO slot(block_id, status, buffer) VALUES (?,?,?)";
            PreparedStatement pstmt_addslot = con.prepareStatement(sql_addslot);
            pstmt_addslot.setString(1, block_id);
            pstmt_addslot.setString(2, status);
            pstmt_addslot.setString(3, buffer);
            int rowInserted = pstmt_addslot.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A New Slot Is added");
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("There is error in addslot");
        }
        return f;
    }
//bakki hai

    public boolean updateSlot(int slot_id, String block_id, String status, String buffer) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_updateslot = "UPDATE slot SET block_id = ?, status = ?, buffer = ? WHERE slot_id = ?";
            PreparedStatement pstmt_updateslot = con.prepareStatement(sql_updateslot);
            pstmt_updateslot.setString(1, block_id);
            pstmt_updateslot.setString(2, status);
            pstmt_updateslot.setString(3, buffer);
            pstmt_updateslot.setInt(4, slot_id);
            int rowInserted = pstmt_updateslot.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Slot Updated Successfully ");
                f = true;
            }

        } catch (Exception e) {
            System.out.println("There is error in updateslot " + e);
        }
        return f;
    }

    public boolean deleteSlot(int slot_id) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_checkslot = "SELECT * FROM slot WHERE slot_id = ?";
            PreparedStatement pstmt_checkslot = con.prepareStatement(sql_checkslot);
            pstmt_checkslot.setInt(1, slot_id);
            ResultSet rs_checkslot = pstmt_checkslot.executeQuery();
            if (rs_checkslot.next()) {
                String sql_deleteslot = "DELETE FROM slot WHERE slot_id = ?";
                PreparedStatement pstmt_deleteslot = con.prepareStatement(sql_deleteslot);
                pstmt_deleteslot.setInt(1, slot_id);
                pstmt_deleteslot.executeUpdate();
                System.out.println("Slot No " + slot_id + " Deleted Sucessfully");
                f = true;
            } else {
                System.out.println("Slot No " + slot_id + " Doesn't Exist");
                f = false;
            }
        } catch (Exception e) {
            System.out.println("There is error in deleteslot " + e);
        }
        return f;
    }

    public boolean updateVehicleDetails(String vehicle_type, int rate, int increment_rate, String open_time, String close_time) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_updateslot = "UPDATE master SET rate = ?, increment_rate = ?, open_time = ?, close_time = ? WHERE vehicle_type = ?";
            PreparedStatement pstmt_updateslot = con.prepareStatement(sql_updateslot);
            pstmt_updateslot.setInt(1, rate);
            pstmt_updateslot.setInt(2, increment_rate);
            pstmt_updateslot.setString(3, open_time);
            pstmt_updateslot.setString(4, close_time);
            pstmt_updateslot.setString(5, vehicle_type);
            int rowInserted = pstmt_updateslot.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Vehicle Detail Updated Successfully ");
                f = true;
            }

        } catch (Exception e) {
            System.out.println("There is an error in updateVehicle " + e);
        }
        return f;
    }

    public boolean blockUser(String username, String block) {
        boolean blockUsers = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_blockuser;
            if (block.equals("block")) {
                sql_blockuser = "UPDATE login SET block = 'yes' WHERE username = ?";
            } else {
                sql_blockuser = "UPDATE login SET block = 'no' WHERE username = ?";
            }
            PreparedStatement pstmt_blockuser = con.prepareStatement(sql_blockuser);
            pstmt_blockuser.setString(1, username);
            int rowInserted = pstmt_blockuser.executeUpdate();
            if (rowInserted > 0) {
                System.out.println(username + " is " + block + " now");
                blockUsers = true;
            } else {
                System.out.println("There is no " + username);
            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong in blockUser " + e);
        }
        return blockUsers;
    }

    public boolean updateCost(int book_id, float paid_amount) {
        boolean updateCosts = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_checkbookid = "SELECT * FROM booking WHERE book_id = ?";
            PreparedStatement pstmt_checkbookid = con.prepareStatement(sql_checkbookid);
            pstmt_checkbookid.setInt(1, book_id);
            ResultSet rs_checkbookid = pstmt_checkbookid.executeQuery();
            if (rs_checkbookid.next()) {
                float db_paidamont = rs_checkbookid.getFloat("paid_amount");
                String sql_updatepaid_amount = "UPDATE booking SET paid_amount = ? WHERE book_id = ?";
                PreparedStatement pstmt_updatepaid_amount = con.prepareStatement(sql_updatepaid_amount);
                paid_amount = paid_amount + db_paidamont;
                pstmt_updatepaid_amount.setFloat(1, paid_amount);
                pstmt_updatepaid_amount.setInt(2, book_id);
                pstmt_updatepaid_amount.executeUpdate();
                int rowInserted = pstmt_updatepaid_amount.executeUpdate();
                if (rowInserted > 0) {
                    System.out.println("Book No " + book_id + " Updated Successfully ");
                    updateCosts = true;
                }
            } else {
                System.out.println("Book No " + book_id + " Doesn't Exist");
            }
        } catch (Exception e) {
            System.out.println("Opps Something is wrong in updateCost " + e);
        }
        return updateCosts;
    }

    public ArrayList<BookingBean> SearchBookingDetails_Act(String date, String act) {
        ArrayList<BookingBean> list = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_bookingdate_act = "";
            if (act.equals("on")) {
                sql_bookingdate_act = "SELECT * FROM booking WHERE date = ?";
            } else if (act.equals("before")) {
                sql_bookingdate_act = "SELECT * FROM booking WHERE date < ?";  
            } else if (act.equals("after")) {
                sql_bookingdate_act = "SELECT * FROM booking WHERE date > ?";
            }
            PreparedStatement pstmt_bookingdate_act = con.prepareStatement(sql_bookingdate_act);
            pstmt_bookingdate_act.setString(1, date);
            ResultSet rs_bookingdate_act = pstmt_bookingdate_act.executeQuery();
            while (rs_bookingdate_act.next()) {
                BookingBean bookdetails = new BookingBean(rs_bookingdate_act.getInt("book_id"),
                        rs_bookingdate_act.getString("cust_name"), rs_bookingdate_act.getString("cust_surname"),
                        rs_bookingdate_act.getString("vehicle_type"), rs_bookingdate_act.getString("vehicle_no"),
                        rs_bookingdate_act.getString("date"), rs_bookingdate_act.getString("start_time"),
                        rs_bookingdate_act.getString("end_time"), rs_bookingdate_act.getDouble("total_amount"),
                        rs_bookingdate_act.getDouble("paid_amount"), rs_bookingdate_act.getInt("slot_id"),
                        rs_bookingdate_act.getString("checkin_time"), rs_bookingdate_act.getString("checkout_time"),
                        rs_bookingdate_act.getString("booked_date_time"), "", true);
                list.add(bookdetails);
                System.out.println(list);
            }
//else{
// System.out.println("There is no Record available");

        } catch (Exception e) {
            System.out.println("Error From SearchBookingDetails_Act " + e);
        }
        return list;
    }

    public ArrayList<BookingBean> SearchBookingDetailsRange(String mindate, String maxdate) {
        ArrayList<BookingBean> list = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_bookingdaterange = "SELECT * FROM booking WHERE ? <= date AND date <= ?";
            PreparedStatement pstmt_bookingdaterange = con.prepareStatement(sql_bookingdaterange);
            pstmt_bookingdaterange.setString(1, mindate);
            pstmt_bookingdaterange.setString(2, maxdate);
            ResultSet rs_bookingdaterange = pstmt_bookingdaterange.executeQuery();
            while (rs_bookingdaterange.next()) {
                BookingBean bookdetails = new BookingBean(rs_bookingdaterange.getInt("book_id"),
                        rs_bookingdaterange.getString("cust_name"), rs_bookingdaterange.getString("cust_surname"),
                        rs_bookingdaterange.getString("vehicle_type"), rs_bookingdaterange.getString("vehicle_no"),
                        rs_bookingdaterange.getString("date"), rs_bookingdaterange.getString("start_time"),
                        rs_bookingdaterange.getString("end_time"), rs_bookingdaterange.getDouble("total_amount"),
                        rs_bookingdaterange.getDouble("paid_amount"), rs_bookingdaterange.getInt("slot_id"),
                        rs_bookingdaterange.getString("checkin_time"), rs_bookingdaterange.getString("checkout_time"),
                        rs_bookingdaterange.getString("booked_date_time"), "", true);
                list.add(bookdetails);
                System.out.println(list);

            }//else{
// System.out.println("There is no Record available");}
        } catch (Exception e) {
            System.out.println("Error From SearchBookingDetailsRange " + e);
        }
        return list;
    }

    public ArrayList<Customer> searchUser(String role) throws SQLException {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_searchuser = "";
            if (role.equals("customer")) {
                sql_searchuser = "SELECT * FROM customer";
            } else if (role.equals("staff")) {
                sql_searchuser = "SELECT * FROM staff";
            } else {
                sql_searchuser = "SELECT * FROM admin";
            }
            PreparedStatement pstmt_searchuser = con.prepareStatement(sql_searchuser);
            ResultSet rs_searchuser = pstmt_searchuser.executeQuery();
            while (rs_searchuser.next()) {
                Customer customerDetails = new Customer(rs_searchuser.getInt("id"), rs_searchuser.getString("first_name"),
                        rs_searchuser.getString("middle_name"), rs_searchuser.getString("last_name"),
                        rs_searchuser.getString("gender"), rs_searchuser.getString("email"),
                        rs_searchuser.getString("country"), rs_searchuser.getString("state"),
                        rs_searchuser.getString("city"), rs_searchuser.getLong("contact_no"),
                        rs_searchuser.getLong("alternate_contact_no"));
                list.add(customerDetails);
                System.out.println(list + "this is Dao");
            }

        } catch (SQLException e) {
            System.out.println("Error From SearchUser " + e);
        }
        return list;
    }

}
