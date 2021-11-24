package com.mycompany.smartparkingmanagement.servlets;

import api.Razorpay;
import com.mycompany.smartparkingmanagement.dao.BookingDao;
import com.mycompany.smartparkingmanagement.entities.BookingBean;
import com.mycompany.smartparkingmanagement.entities.Message;
import com.mycompany.smartparkingmanagement.entities.OrderBean;
import com.mycompany.smartparkingmanagement.entities.TimeCheckBean;
import java.io.IOException;
import java.time.LocalTime;
import com.razorpay.Order;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Booking extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        String value = request.getParameter("val");
        try {
            String cust_name = request.getParameter("cust_firstname");
            String cust_surname = request.getParameter("cust_surname");
            String vehicle_type = request.getParameter("vehicle_type");
            String vehicle_no = request.getParameter("vehicle_no");
            String date = request.getParameter("date");

            String start_hrs = request.getParameter("start_hrs");
            String start_mins = request.getParameter("start_mins");

            String end_hrs = request.getParameter("end_hrs");
            String end_mins = request.getParameter("end_mins");

            BookingDao bkDao = new BookingDao();
            TimeCheckBean time = bkDao.CheckTImeFromMaster(vehicle_type);

            LocalTime open_time = LocalTime.parse(time.getDb_open_time());
            //for msg
            String OpenTime_msg = open_time.toString();
            LocalTime close_time = LocalTime.parse(time.getDb_close_time());
            //for msg
            String CloseTime_msg = close_time.toString();

            String str_start_time = start_hrs + ":" + start_mins + ":" + "00";
            String str_end_time = end_hrs + ":" + end_mins + ":" + "00";

            LocalTime start_time = LocalTime.parse(start_hrs + ":" + start_mins);
            LocalTime end_time = LocalTime.parse(end_hrs + ":" + end_mins);

            if (start_time.isBefore(end_time)) {
                if (start_time.isBefore(open_time)) {
                    System.out.println("you can't book.... Parking opens at : " + OpenTime_msg + " please change entry time");
                    Message msg = new Message("you can't book.... Parking opens at : " + OpenTime_msg + " please change entry time", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    if (value.equals("online")) {
                        response.sendRedirect("booking.jsp");
                    } else {
                        response.sendRedirect("OfflineBooking.jsp");
                    }
                } else if (end_time.isAfter(close_time)) {
                    System.out.println("you can't book.... Parking closes at : " + close_time + " please change exit time");
                    Message msg = new Message("you can't book.... Parking opens at : " + CloseTime_msg + " please change exit time", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    if (value.equals("online")) {
                        response.sendRedirect("booking.jsp");
                    } else {
                        response.sendRedirect("OfflineBooking.jsp");
                    }
                } else if (start_time.equals(open_time) || start_time.isAfter(open_time)) {
                    if (end_time.equals(close_time) || end_time.isBefore(close_time)) {
                        System.out.println("book can be done");
                        BookingBean book = new BookingBean(cust_name, cust_surname, vehicle_type, vehicle_no, date, str_start_time, str_end_time);
//                        String result = bkDao.slotProvider(book);
                        book = bkDao.slotProvider(book);
//                        if (result.equals("Proceed to pay")) {
                        if (book.isBool() && book.getMsg().equals("true")) {
                            //checking online or onspot
                            if (value.equals("online")) {

                                double cost = bkDao.Payment(book.getVehicle_type(), book.getStr_start_time(), book.getStr_end_time());
                                System.out.println(cost);
                                System.out.println(book.getDate());
                                Order order = Razorpay.Generate_Order(cost, 1);
                                int amt_paid = order.get("amount_paid");
                                //String created_at = order.get("created_at");
                                int amount_due = order.get("amount_due");
                                System.out.println(amount_due + "checking amount");
                                amount_due = amount_due / 100; // converting paise to rs
                                System.out.println(amount_due + "After Converting");
                                String currency = order.get("currency");
                                String receipt = order.get("receipt");
                                String order_id = order.get("id");//order id
//                            int offer_id = order.get("offer_id");
                                String status = order.get("status");
                                int attempts = order.get("attempts");
                                OrderBean orderBean = new OrderBean(cost, amt_paid, amount_due, currency,
                                        receipt, order_id, 1, status, attempts); //1 is offer id
                                boolean answer = bkDao.InsertOrderToDB(orderBean);
                                if (answer != true) {
                                    Message msg = new Message("Something went wrong try again !!", "error", "alert-danger");
                                    System.out.println("Something went wrong try again");
                                    s.setAttribute("message", msg);
                                    response.sendRedirect("booking.jsp");
                                } else {
//                            s.setAttribute("RazorpayOrder", order);
//                            String id = order.get("id");
                                    s.setAttribute("order_id", order_id);
                                    System.out.println(order_id);
                                    s.setAttribute("booking", book);
                                    Message msg = new Message("Proceed to pay your " + cost + ""
                                            + " <button type=\"submit\" id=\"rzp-button1\" class=\"btn btn-success me-3 px-4\">Pay</button> ",
                                            "success", "alert-success");
                                    s.setAttribute("message", msg);
                                }
                                
                            } //ONSPOT START HERE
                            else {
                                if (bkDao.onSpotBookingInsertion(cust_name, cust_surname, vehicle_type,
                                        vehicle_no, book.getDate(), book.getStr_start_time(), book.getStr_end_time(), book.getSlot_no())) {
                                    Message msg = new Message("Booking Done Successfully, Your Slot No is " + book.getSlot_no(), "success", "alert-success");
                                    s.setAttribute("message", msg);
                                } else {
                                    Message msg = new Message("Offline Slot Something went Wrong", "error", "alert-danger");
                                    s.setAttribute("message", msg);
                                }
                            }

                        } else if (book.isBool() && book.getMsg().equals("false")) {
                            Message msg = new Message("Sorry we are out of slots on" + book.getDate() + " at " + book.getStr_start_time(), "error", "alert-danger");
                            s.setAttribute("message", msg);
                        } else {
                            Message msg = new Message("error", "error", "alert-danger");
                            s.setAttribute("message", msg);
                        }
                        if (value.equals("online")) {
                            response.sendRedirect("booking.jsp");
                        } else {
                            response.sendRedirect("OfflineBooking.jsp");
                        }
                    }
                }
            } else {
                Message msg = new Message("Start Time cannot be Greater than End Time", "error", "alert-danger");
                s.setAttribute("message", msg);
                if (value.equals("online")) {
                    response.sendRedirect("booking.jsp");
                } else {
                    response.sendRedirect("OfflineBooking.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (value.equals("online")) {
                response.sendRedirect("booking.jsp");
            } else {
                response.sendRedirect("OfflineBooking.jsp");
            }
            System.out.println("OOps... Something is wrong  " + e);
        }
    }
}
