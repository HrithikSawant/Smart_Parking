package com.mycompany.smartparkingmanagement.dao;

import com.mycompany.smartparkingmanagement.entities.BookingBean;
import com.mycompany.smartparkingmanagement.entities.OrderBean;
import com.mycompany.smartparkingmanagement.entities.TimeCheckBean;
import com.mycompany.smartparkingmanagement.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

public class BookingDao {

    Random random = new Random();

    public boolean bookingDone(String cust_name, String cust_surname, String vehicle_type,
            String vehicle_no, String date, String newstart, String newend,
            double total_amount, double amount_paid, int slot_no) {
        String str_time = date + " " + newstart;
        String end_time = date + " " + newend;
        boolean f = true;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_insert_bookingtable = "INSERT INTO booking(cust_name,cust_surname,"
                    + "vehicle_type,vehicle_no,date,start_time,end_time"
                    + ",total_amount,paid_amount,slot_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt_insert_bookingtable = con.prepareStatement(sql_insert_bookingtable);
            pstmt_insert_bookingtable.setString(1, cust_name);
            pstmt_insert_bookingtable.setString(2, cust_surname);
            pstmt_insert_bookingtable.setString(3, vehicle_type);
            pstmt_insert_bookingtable.setString(4, vehicle_no);
            pstmt_insert_bookingtable.setString(5, date);
            pstmt_insert_bookingtable.setString(6, str_time);
            pstmt_insert_bookingtable.setString(7, end_time);
            pstmt_insert_bookingtable.setDouble(8, total_amount);
            pstmt_insert_bookingtable.setDouble(9, amount_paid);
            pstmt_insert_bookingtable.setInt(10, slot_no);
            int rowInserted = pstmt_insert_bookingtable.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new record is added");
                f = true;
            }
        } catch (SQLException e) {
            System.out.println("Opps Something is wrong " + e);
        }
        return f;
    }

    public BookingBean slotProvider(BookingBean book) {
        book.setBool(false);
        try {
            Connection con = ConnectionProvider.getConnection();
            ArrayList<Integer> arr = new ArrayList<>();
            String newstart = book.getDate() + " " + book.getStr_start_time();
            String newend = book.getDate() + " " + book.getStr_end_time();

            String sql = "SELECT slot_id FROM booking WHERE NOT (end_time < ? OR start_time > ?) AND (date=?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newstart);
            pstmt.setString(2, newend);
            pstmt.setString(3, book.getDate());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                arr.add(rs.getInt("slot_id"));
            }

            ArrayList<Integer> arr1 = new ArrayList<>();
            Statement stmt = con.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT slot_id FROM slot WHERE buffer='no'");
            while (rs1.next()) {
                arr1.add(rs1.getInt("slot_id"));
            }
            arr1.removeAll(arr);
//            System.out.println("Available Slots:" + arr1);
            if (arr1.isEmpty()) {
                System.out.println("Sorry we are out of slots on " + book.getDate() + " at " + book.getStr_start_time());
                book.setMsg("Sorry we are out of slots on");//
                book.setMsg("false");
                book.setBool(true);
            } else {
                int slot_no = arr1.get(random.nextInt(arr1.size()));
                book.setMsg("true");
                book.setSlot_no(slot_no);
                book.setBool(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    //vehicle type //start time//end time from slot provider
    public double Payment(String vehicle_type, String new_start_time, String new_end_time) {
        //Payment part
        float cost = 0;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_vehicle = "SELECT * FROM master where vehicle_type = ?";
            System.out.println("vehicle type:" + vehicle_type);
            PreparedStatement pstmt_payment = con.prepareStatement(sql_vehicle);
            pstmt_payment.setString(1, vehicle_type);
            ResultSet rs_payment = pstmt_payment.executeQuery();
            int db_rate = 0;
            while (rs_payment.next()) {
                db_rate = rs_payment.getInt("rate");
            }
            LocalTime start_time = LocalTime.parse(new_start_time);
            LocalTime end_time = LocalTime.parse(new_end_time);
            // Calculating the difference in Hours
            int hours = (int) ChronoUnit.HOURS.between(start_time, end_time);
            // Calculating the difference in Minutes
            int minutes = (int) (ChronoUnit.MINUTES.between(start_time, end_time) % 60);
            int min = (hours * 60) + minutes;
            cost = db_rate * (min / 30);
            System.out.println("You have to pay :" + cost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cost;
    }

    public TimeCheckBean CheckTImeFromMaster(String vehicle_type) {
        Connection con = ConnectionProvider.getConnection();
        TimeCheckBean time = null;
        try {
            String sql = "SELECT * FROM master WHERE vehicle_type = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vehicle_type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                time = new TimeCheckBean();
                time.setDb_open_time(rs.getString("open_time"));
                time.setDb_close_time(rs.getString("close_time"));
                System.out.println(rs.getString("open_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public boolean InsertOrderToDB(OrderBean or) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO orders(amount,"
                    + " amount_paid, created_at, amount_due, currency, receipt, order_id, entity,"
                    + " offer_id, status, attempts) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setDouble(1, or.getAmount());
            pstmt.setDouble(2, or.getAmount_paid());
            pstmt.setString(3, or.getCreated_at());
            pstmt.setDouble(4, or.getAmount_due());
            pstmt.setString(5, or.getCurrency());
            pstmt.setString(6, or.getReceipt());
            pstmt.setString(7, or.getOrder_id());
            pstmt.setString(8, or.getEntity());
            pstmt.setInt(9, or.getOffer_id());
            pstmt.setString(10, or.getStatus());
            pstmt.setInt(11, or.getAttempts());
            int rowInserted = pstmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("InsertedSuccessfully Orderdb");
                f = true;
            } else {
                System.out.println("Cannot Update data ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean InsertSuccessPaidToDB(OrderBean or) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement pstmt = con.prepareStatement(" UPDATE orders SET amount_paid=?,amount_due=?,"
                    + "razor_id=?,signature=?,status=? WHERE order_id = ?");
            pstmt.setDouble(1, or.getAmount_paid());
            pstmt.setDouble(2, or.getAmount_due());
            pstmt.setString(3, or.getId());
            pstmt.setString(4, or.getSignature());
            pstmt.setString(5, or.getStatus());
            pstmt.setString(6, or.getOrder_id());
            int rowInserted = pstmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("InsertedSuccessfully signature");
                f = true;
            } else {
                System.out.println("Cannot Update data ");;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            f = false;
        }
        return f;
    }

    public boolean onSpotBookingInsertion(String cust_name, String cust_surname, String vehicle_type, String vehicle_no, String date, String newstart, String newend, int slot_no) {
        String str_time = date + " " + newstart;
        String end_time = date + " " + newend;
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_insert_ordertable = "INSERT INTO orders( created_at) VALUES (now())";
            PreparedStatement pstmt_insert_ordertable = con.prepareStatement(sql_insert_ordertable);
            int rowInserted = pstmt_insert_ordertable.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new record is added");
                
                String sql_insert_bookingtable = "INSERT INTO BOOKING(cust_name,cust_surname,vehicle_type,vehicle_no,date,start_time,end_time,checkin_time,slot_id) VALUES(?,?,?,?,?,?,?,now(),?)";
                PreparedStatement pstmt_insert_bookingtable = con.prepareStatement(sql_insert_bookingtable);
                pstmt_insert_bookingtable.setString(1, cust_name);
                pstmt_insert_bookingtable.setString(2, cust_surname);
                pstmt_insert_bookingtable.setString(3, vehicle_type);
                pstmt_insert_bookingtable.setString(4, vehicle_no);
                pstmt_insert_bookingtable.setString(5, date);
                pstmt_insert_bookingtable.setString(6, str_time);
                pstmt_insert_bookingtable.setString(7, end_time);
                pstmt_insert_bookingtable.setInt(8, slot_no);
                int rowInserted1 = pstmt_insert_bookingtable.executeUpdate();
                if (rowInserted1 > 0) {
                    System.out.println("A new record is added");
                    f = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Opps Something is wrong " + e);
        }
        return f;
    }

}
