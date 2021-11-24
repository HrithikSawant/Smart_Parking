package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.dao.Dao;
import com.mycompany.smartparkingmanagement.entities.Customer;
import com.mycompany.smartparkingmanagement.entities.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        try {
            // fetching data 
            String firstName = request.getParameter("firstName");
            String middleName = request.getParameter("middleName");
            String lastName = request.getParameter("lastName");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String emailId = request.getParameter("emailId");
            String alternate_emailId = request.getParameter("alternate_emailId");
            String alternate = request.getParameter("alternate_phoneNo");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            if (firstName.isEmpty()) {
                Message msg = new Message("Name is Blank !!", "error", "alert-danger");
                s.setAttribute("message", msg);
                System.out.println("Name is blank");
                response.sendRedirect("CustomerRegistration.jsp");
                return;
            } else if (middleName.isEmpty()) {
                Message msg = new Message("MiddleName is Blank !!", "error", "alert-danger");
                s.setAttribute("message", msg);
                System.out.println("MiddleName is blank");
                response.sendRedirect("CustomerRegistration.jsp");
                return;
            } else if (lastName.isEmpty()) {
                Message msg = new Message("LastName is Blank !!", "error", "alert-danger");
                s.setAttribute("message", msg);
                System.out.println("LastName is blank");
                response.sendRedirect("CustomerRegistration.jsp");
                return;
            }
            String LicenseNo = request.getParameter("LicenseNo");
            long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
            long alternate_phoneNo = Long.parseLong(alternate);

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //validation
            //Creating customer object to store data;
            Customer customer = new Customer(firstName, middleName, lastName,
                    dob, gender, emailId, alternate_emailId, alternate, country,
                    state, city, phoneNo, LicenseNo, alternate_phoneNo, username, password, "Customer");
            System.out.println(customer);

            if (Dao.checkCustomer(customer)) {
                if (Dao.InsertCustomerToDB(customer)) {
                    System.out.println("Customer is added successfully..");
                    Message msg = new Message("Register Successful !! " + firstName, "success", "alert-success");
                    s.setAttribute("message", msg);
                    response.sendRedirect("Login.jsp");
                } else {
                    Message msg = new Message("Please Enter Unique Username!!", "error", "alert-danger");
                    System.out.println("Please Enter Unique Username!!");
                    s.setAttribute("message", msg);
                    response.sendRedirect("CustomerRegistration.jsp");
                }
            } else {
                Message msg = new Message("It Seems Like You Already have an account !!", "error", "alert-danger");
                System.out.println("It Seems Like You Already have an account !!");
                s.setAttribute("message", msg);
                response.sendRedirect("AdminRegistration_Form.jsp");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error_page.jsp");//
            return;
        }
    }
}
