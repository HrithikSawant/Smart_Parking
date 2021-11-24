package com.mycompany.smartparkingmanagement.dao;

import com.mycompany.smartparkingmanagement.entities.BookingBean;
import com.mycompany.smartparkingmanagement.entities.LoginBean;
import com.mycompany.smartparkingmanagement.entities.OrderBean;
import com.mycompany.smartparkingmanagement.entities.Slot;
import com.mycompany.smartparkingmanagement.entities.Week;
import com.mycompany.smartparkingmanagement.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class DashBoardDao {

    public ArrayList<Slot> slotStatus() {
        ArrayList<Slot> list = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_slotstatus = "SELECT * FROM slot";
            PreparedStatement pstmt_slotstatus = con.prepareStatement(sql_slotstatus);
            ResultSet rs_slotstatus = pstmt_slotstatus.executeQuery();
            while (rs_slotstatus.next()) {
                Slot slot = new Slot(rs_slotstatus.getInt("slot_id"), rs_slotstatus.getString("block_id"),
                        rs_slotstatus.getString("status"), rs_slotstatus.getString("buffer"));
                list.add(slot);
            }
        } catch (SQLException e) {
            System.out.println("Error From slotStatus" + e);
        }
        return list;
    }

    public ArrayList<BookingBean> visitedVehicle() {
        ArrayList<BookingBean> list = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql_visitedvehicle = "SELECT *, Count(*) as cnt FROM booking GROUP BY vehicle_no ORDER BY COUNT(*) DESC";
            PreparedStatement pstmt_visitedvehicle = con.prepareStatement(sql_visitedvehicle);
            ResultSet rs_visitedvehicle = pstmt_visitedvehicle.executeQuery();
            while (rs_visitedvehicle.next()) {
                System.out.println("Date " + rs_visitedvehicle.getString("date"));
                BookingBean visitedVehicle = new BookingBean(rs_visitedvehicle.getInt("cnt"),
                        rs_visitedvehicle.getString("cust_name"), rs_visitedvehicle.getString("cust_surname"),
                        rs_visitedvehicle.getString("vehicle_no"), rs_visitedvehicle.getString("date"));
                list.add(visitedVehicle);
            }
        } catch (SQLException e) {
            System.out.println("Error From VisitedVehicle " + e);
        }
        return list;
    }

    public ArrayList<LoginBean> getAllLoginDetails() throws SQLException {
        ArrayList<LoginBean> list = new ArrayList<>();
        try {
            String q = "select * from login";
            Connection con = ConnectionProvider.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                LoginBean l = new LoginBean(rs.getString("username"), rs.getString("role"));
                list.add(l);
            }

        } catch (SQLException e) {

        }
        return list;
    }

    //
    public ArrayList<BookingBean> SearchBookingDetails_Act() throws SQLException {
        ArrayList<BookingBean> list = new ArrayList<>();

        return list;
    }

    public Week traffic() {
        ArrayList<Integer> arr = new ArrayList();
        Week week = null;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT WEEKDAY(date) FROM booking";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                arr.add(rs.getInt("WEEKDAY(date)"));
            }
            System.out.println("date " + arr);
            int monday = Collections.frequency(arr, 0);
            System.out.println("Monday " + monday);
            int tuesday = Collections.frequency(arr, 1);
            System.out.println("Tuesday " + tuesday);
            int wednesday = Collections.frequency(arr, 2);
            int thursday = Collections.frequency(arr, 3);
            int friday = Collections.frequency(arr, 4);
            int saturday = Collections.frequency(arr, 5);
            int sunday = Collections.frequency(arr, 6);
// gs.setMonday(monday);gs.setTuesday(tuesday);gs.setWednesday(wednesday);gs.setThursday(thursday);gs.setFriday(friday);gs.setSaturday(saturday);gs.setSunday(sunday);
            System.out.println("monday " + monday);
            week = new Week(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
            System.out.println("sunday : " + week.getSunday());
//list.add(week);
            System.out.println("week " + week);

        } catch (Exception e) {
            System.out.println("Error From SearchUser " + e);
        }
        return week;
    }
}
