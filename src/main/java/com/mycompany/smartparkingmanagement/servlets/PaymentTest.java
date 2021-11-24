package com.mycompany.smartparkingmanagement.servlets;

import static api.Razorpay.fetch_Payment;
import com.mycompany.smartparkingmanagement.dao.BookingDao;
import com.mycompany.smartparkingmanagement.entities.BookingBean;
import com.mycompany.smartparkingmanagement.entities.Message;
import com.mycompany.smartparkingmanagement.entities.OrderBean;
import com.razorpay.Order;
import com.razorpay.RazorpayException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("razorpay_payment_id");
            String order_id = request.getParameter("razorpay_order_id");
            String signature = request.getParameter("razorpay_signature");

            Order order = fetch_Payment(order_id);
            System.out.println(order);
            int amount = order.get("amount");
            amount = amount / 100;
            int paid_amount = order.get("amount_paid");
            paid_amount = paid_amount / 100;
            int amount_due = order.get("amount_due");
            amount_due = amount_due / 100;
            String status = order.get("status");

            OrderBean orderBean = new OrderBean(paid_amount,amount_due, id, order_id, signature, status); 
            BookingDao bkDao = new BookingDao();
            HttpSession s = request.getSession();
            if (!bkDao.InsertSuccessPaidToDB(orderBean)) {
                Message msg = new Message("Something went wrong try again !!", "error", "alert-danger");
                System.out.println("Something went wrong try again");
                s.setAttribute("message", msg);
                response.sendRedirect("booking.jsp");
            } else {
                BookingBean bkBean = (BookingBean) s.getAttribute("booking");
                System.out.println(bkBean);
                boolean ans = bkDao.bookingDone(bkBean.getCust_name(), bkBean.getCust_surname(),
                        bkBean.getVehicle_type(), bkBean.getVehicle_no(), bkBean.getDate(),
                        bkBean.getStr_start_time(), bkBean.getStr_end_time(), amount , paid_amount, bkBean.getSlot_no()); //Total Amount,amount_Paid,
                if (ans != true) {
                    Message msg = new Message("Booking Done not submitted", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    response.sendRedirect("booking.jsp");
                } else {
                    System.out.println("Received id" + id);
                    System.out.println("order id" + order_id);
                    System.out.println("signature id" + signature);

                    Message msg = new Message("Received payment!!", "success", "alert-success");
                    s.setAttribute("message", msg);
                    response.sendRedirect("booking.jsp");
                }
            }
        } catch (RazorpayException ex) {
            System.out.println("razorpay id exception");
        }
    }
}
