/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.dao.AdminDao;
import com.mycompany.smartparkingmanagement.entities.BookingBean;
import com.mycompany.smartparkingmanagement.entities.Customer;
import com.mycompany.smartparkingmanagement.entities.Message;
import com.mycompany.smartparkingmanagement.entities.Slot;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HRITHIK
 */
public class AdminPanel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession s = request.getSession();
            String value = request.getParameter("val");
            AdminDao Dao = new AdminDao();
            if (value.equals("updatebookingtime")) {
                int book_id = Integer.parseInt(request.getParameter("book_id"));
                String time = request.getParameter("time");
                if (Dao.updateTime(book_id, time)) {
                    Message msg = new Message("Successfully Updated", "success", "alert-success");
                    s.setAttribute("message", msg);
                } else {
                    Message msg = new Message("Unsuccessful ", "error", "alert-danger");
                    s.setAttribute("message", msg);
                }
                response.sendRedirect("ManageBookingDetails.jsp");
                return;
            } else if (value.equals("totalamount")) {
                int book_id = Integer.parseInt(request.getParameter("book_id"));
                BookingBean bk = Dao.totalCost(book_id);
                if (bk.isBool()) {
                    Message msg = new Message("Book No " + book_id + " Updated Successfully"
                            + "<br> you have already payed: " + bk.getAmount_paid()
                            + "<br> You have to pay total amount :" + bk.getTotal_amount()
                            + " <br> finally you have to pay " + bk.getNew_total_amount(), "success", "alert-success");
                    s.setAttribute("message", msg);
                } else {
                    Message msg = new Message("Unsuccessful ", "error", "alert-danger");
                    s.setAttribute("message", msg);
                }
                response.sendRedirect("ManageBookingDetails.jsp");
                return;
            } else if (value.equals("buffer")) {
                String status = request.getParameter("status");
                // BAKKI HAI
                ArrayList<Slot> slot = Dao.bufferSlots(status);
                RequestDispatcher rd = request.getRequestDispatcher("Slot.jsp");
                request.setAttribute("slot", slot);
                rd.forward(request, response);
                response.sendRedirect("Slot.jsp");
                return;
            } else if (value.equals("updatebookingslotno")) {
                int book_id = Integer.parseInt(request.getParameter("book_id"));
                int slot_id = Integer.parseInt(request.getParameter("slot_id"));
                if (Dao.allotSlot(book_id, slot_id)) {
                    Message msg = new Message("Successfully alloted", "success", "alert-success");
                    s.setAttribute("message", msg);
                } else {
                    Message msg = new Message("Sorry!!! Slot No " + slot_id + " is occupied already.", "error", "alert-danger");
                    s.setAttribute("message", msg);
                }
                response.sendRedirect("ManageBookingDetails.jsp");
                return;
            } else if (value.equals("updateamount")) {
                int book_id = Integer.parseInt(request.getParameter("book_id"));
                float paid_amount = Float.parseFloat(request.getParameter("paid_amount"));
                if (Dao.updateCost(book_id, paid_amount)) {
                    Message msg = new Message("Book No " + book_id + " Updated Successfully ", "success", "alert-success");
                    s.setAttribute("message", msg);
                } else {
                    Message msg = new Message("Book No " + book_id + " Doesn't Exist", "error", "alert-danger");
                    s.setAttribute("message", msg);
                }
                response.sendRedirect("ManageBookingDetails.jsp");
                return;
            } else if (value.equals("slotadd")) {
                String block_id = request.getParameter("block_id");
                String status = request.getParameter("status");
                String buffer = request.getParameter("buffer");

                if (block_id.isEmpty()) {
                    Message msg = new Message("Please Enter Block ID", "error", "alert-danger");
                    s.setAttribute("message", msg);
                } else {
                    if (Dao.addSlot(block_id, status, buffer)) {
                        Message msg = new Message(" A New Slot Is added", "success", "alert-success");
                        s.setAttribute("message", msg);
                    } else {
                        Message msg = new Message("Unsuccessful ", "error", "alert-danger");
                        s.setAttribute("message", msg);
                    }
                }
                response.sendRedirect("Slot.jsp");
                return;
            } else if (value.equals("slotupdate")) {
                String slot_idvalidate = request.getParameter("slot_id");
                String block_id = request.getParameter("block_id");
                String status = request.getParameter("status");
                String buffer = request.getParameter("buffer");
                if (block_id.isEmpty() || slot_idvalidate.isEmpty()) {
                    Message msg = new Message("Please Enter Required Fields", "error", "alert-danger");
                    s.setAttribute("message", msg);
                } else {
                    int slot_id = Integer.parseInt(slot_idvalidate);
                    if (Dao.updateSlot(slot_id, block_id, status, buffer)) {
                        Message msg = new Message(" Successfully Slot Updated", "success", "alert-success");
                        s.setAttribute("message", msg);
                    } else {
                        Message msg = new Message("Unsuccessful ", "error", "alert-danger");
                        s.setAttribute("message", msg);
                    }
                }
                response.sendRedirect("Slot.jsp");
                return;
            } else if (value.equals("slotdelete")) {
                String slot_idvalidate = request.getParameter("slot_id");
                if (slot_idvalidate.isEmpty()) {
                    Message msg = new Message("Please Enter Slot ID", "error", "alert-danger");
                    s.setAttribute("message", msg);
                } else {
                    int slot_id = Integer.parseInt(slot_idvalidate);
                    if (Dao.deleteSlot(slot_id)) {
                        Message msg = new Message(" A Slot Delete Sucessfully" + slot_id, "success", "alert-success");
                        s.setAttribute("message", msg);
                    } else {
                        Message msg = new Message("Slot No " + slot_id + " Doesn't Exist", "error", "alert-danger");
                        s.setAttribute("message", msg);
                    }
                }
                response.sendRedirect("Slot.jsp");
                return;
            } else if (value.equals("updatevehicledetail")) {
                String vehicel_type = request.getParameter("vehicle_type");
                int rate = Integer.parseInt(request.getParameter("rate"));
                int increment_rate = Integer.parseInt(request.getParameter("increment_rate"));
                String open_hrs = request.getParameter("open_hrs");
                String open_mins = request.getParameter("open_mins");
                String close_hrs = request.getParameter("close_hrs");
                String close_mins = request.getParameter("close_mins");
                String open_time = open_hrs + ":" + open_mins + ":" + "00";
                String close_time = close_hrs + ":" + close_mins + ":" + "00";

                LocalTime open_timevalidate = LocalTime.parse(open_hrs + ":" + open_mins);
                LocalTime close_timevalidate = LocalTime.parse(close_hrs + ":" + close_mins);
                if (open_timevalidate.isAfter(close_timevalidate)) {
                    Message msg = new Message("OpenTime Cannot be After Closing Time ", "error", "alert-danger");
                    s.setAttribute("message", msg);
                } else {
                    if (Dao.updateVehicleDetails(vehicel_type, rate, increment_rate, open_time, close_time)) {
                        Message msg = new Message("Vehicle Detail Updated Successfully ", "success", "alert-success");
                        s.setAttribute("message", msg);
                    } else {
                        Message msg = new Message("Unsuccessful ", "error", "alert-danger");
                        s.setAttribute("message", msg);
                    }
                }
                response.sendRedirect("Rate.jsp");
                return;
            } else if (value.equals("adduser")) {
                String role = request.getParameter("user");
                if (role.equals("customer")) {
                    response.sendRedirect("CustomerRegistration.jsp");
                } else if (role.equals("staff")) {
                    response.sendRedirect("StaffRegistration_Form.jsp");
                } else {
                    response.sendRedirect("AdminRegistration_Form.jsp");
                }
                return;
            } else if (value.equals("blockuser")) {
                String username = request.getParameter("username");
                String block = request.getParameter("block");
                if (username.isEmpty()) {
                    Message msg = new Message("Please Enter Username", "error", "alert-danger");
                    s.setAttribute("message", msg);
                } else {
                    if (Dao.blockUser(username, block)) {
                        Message msg = new Message(username + " is " + block + "now", "success", "alert-success");
                        s.setAttribute("message", msg);
                    } else {
                        Message msg = new Message("There is no " + username, "error", "alert-danger");
                        s.setAttribute("message", msg);
                    }
                }
                response.sendRedirect("Manage_User.jsp");
                return;
            } else if (value.equals("searchbookingdetails")) {
                String date = request.getParameter("date");
                String act = request.getParameter("act");

                if (date.isEmpty()) {
                    Message msg = new Message("Please enter required date to search user", "error", "alert-danger");
                    s.setAttribute("message", msg);
                } else {
                    ArrayList<BookingBean> list = Dao.SearchBookingDetails_Act(date, act);
                    RequestDispatcher rd = request.getRequestDispatcher("ViewBookingDetails.jsp");
                    request.setAttribute("list", list);
                    rd.forward(request, response);
                }
                response.sendRedirect("ViewBookingDetails.jsp");
                return;
            } else if (value.equals("searchbookingbyrange")) {
                String mindate = request.getParameter("mindate");
                String maxdate = request.getParameter("maxdate");
                if (mindate.isEmpty() || maxdate.isEmpty()) {
                    Message msg = new Message("Please enter required date to search user", "error", "alert-danger");
                    s.setAttribute("message", msg);
                } else if (!mindate.equals("") && !maxdate.equals("")) {
                    ArrayList<BookingBean> list = Dao.SearchBookingDetailsRange(mindate, maxdate);
                    RequestDispatcher rd = request.getRequestDispatcher("ViewBookingDetails.jsp");
                    request.setAttribute("list", list);
                    rd.forward(request, response);
                }
                response.sendRedirect("ViewBookingDetails.jsp");
                return;
            } else if (value.equals("searchuser")) {

                String role = request.getParameter("role");
                System.out.println(role);
                ArrayList<Customer> list = Dao.searchUser(role);
                System.out.println(list + "adminpanel list");
                RequestDispatcher rd = request.getRequestDispatcher("Manage_User.jsp");
                request.setAttribute("cust", list);
                rd.forward(request, response);
                response.sendRedirect("Manage_User.jsp");
            }

        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            e.printStackTrace();
            response.sendRedirect("error_page.jsp");//
        }
    }
}
