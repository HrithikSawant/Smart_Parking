/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.dao.Dao;
import com.mycompany.smartparkingmanagement.entities.Message;
import com.mycompany.smartparkingmanagement.entities.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ROHAN
 */
public class StaffRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
                    response.sendRedirect("StaffRegistration_Form.jsp");
                    return;
                } else if (middleName.isEmpty()) {
                    Message msg = new Message("MiddleName is Blank !!", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    System.out.println("MiddleName is blank");
                    response.sendRedirect("StaffRegistration_Form.jsp");
                    return;
                } else if (lastName.isEmpty()) {
                    Message msg = new Message("LastName is Blank !!", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    System.out.println("LastName is blank");
                    response.sendRedirect("StaffRegistration_Form.jsp");
                    return;
                }
                long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
                long aadhaarNo = Long.parseLong(request.getParameter("aadhaarNo"));
                String pancardNo = request.getParameter("pancardNo");
                long alternate_phoneNo = Long.parseLong(alternate);

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                //Creating user object to store data
                Staff staff = new Staff(firstName, middleName,
                        lastName, dob, gender, emailId,
                        alternate_emailId, phoneNo, alternate_phoneNo,
                        country, state, city, aadhaarNo, pancardNo, username, password, "Staff");

                if (Dao.checkStaff(staff)) {
                    if (Dao.InsertStaffToDB(staff)) {
                        System.out.println("staff is added successfully..");
//for sendign data and displaying
                        Message msg = new Message("Register Successful !! " + firstName, "success", "alert-success");
                        s.setAttribute("message", msg);
                        response.sendRedirect("Login.jsp");
                    } else {
                        Message msg = new Message("Please Enter Unique value !!", "error", "alert-danger");
                        System.out.println("Please Enter Unique value !!");
                        s.setAttribute("message", msg);
                        response.sendRedirect("StaffRegistration_Form.jsp");
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
}
