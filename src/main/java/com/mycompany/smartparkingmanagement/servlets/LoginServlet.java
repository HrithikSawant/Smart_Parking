package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.dao.Dao;
import com.mycompany.smartparkingmanagement.entities.Admin;
import com.mycompany.smartparkingmanagement.entities.Customer;
import com.mycompany.smartparkingmanagement.entities.LoginBean;
import com.mycompany.smartparkingmanagement.entities.Message;
import com.mycompany.smartparkingmanagement.entities.Staff;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        try {
            // fetching username and password from request 
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username.isEmpty()) {
                Message msg = new Message("Username cannot is Blank !!", "error", "alert-danger");
                s.setAttribute("message", msg);
                System.out.println("Username cannot is Blank");
                response.sendRedirect("Login.jsp");
                return;
            } else if (password.isEmpty()) {
                Message msg = new Message("Password cannot be  is Blank !!", "error", "alert-danger");
                s.setAttribute("message", msg);
                System.out.println("Password cannot be  is Blank !!");
                response.sendRedirect("Login.jsp");
                return;
            } else {
                Dao login = new Dao();
                LoginBean Loguser = login.getUserByUsernameAndPassword(username, password);
                if (Loguser == null) {
                    //login error..... 
                    Message msg = new Message("Invalid credential!! Please Enter Correct username and Password", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    System.out.println("Invalid credential");
                    response.sendRedirect("Login.jsp");
                    return;
                } else {
                    if (Loguser.isBlock()) {
                        Message msg = new Message("You Account Have been Blocked", "error", "alert-danger");
                        s.setAttribute("message", msg);
                        System.out.println("Account Blocked");
                        response.sendRedirect("Login.jsp");
                    } else {
                        System.out.println("name" + Loguser.getUserName());
                        System.out.println(s);
                        s.setAttribute("CurrentUser", Loguser);

                        if (Loguser.getRole().equals("Admin") ) {
                            //admin:-admin.jsp

                            Dao ad = new Dao();
                            Admin admin = ad.getAdminDetailsByUsername(Loguser.getUserName());
//                        System.out.println(admin.getFirstName());
//                        System.out.println(admin.getUsername());
                            LoginBean user = new LoginBean(admin.getUsername(), admin.getEmailId(), admin.getProfile(), admin.getGender(),admin.getFirstName(),"Admin");
                            s.setAttribute("User", user);
                            s.setAttribute("AdminUser", admin);
                            response.sendRedirect("AdminPanel.jsp");

                        } else if (Loguser.getRole().equals("Staff")) {
                            //Staff:-Staff.jsp

                            Dao st = new Dao();
                            Staff staff = st.getStaffDetailsByUsername(Loguser.getUserName());
                            LoginBean user = new LoginBean(staff.getUsername(), staff.getEmailId(), staff.getProfile(), staff.getGender(),staff.getFirstName(),"Staff");
                            s.setAttribute("User", user);

                            s.setAttribute("StaffUser", staff);
                            response.sendRedirect("StaffPanel.jsp");

                        } else if (Loguser.getRole().equals("Customer")) {
                            Dao cust = new Dao();
                            Customer customer = cust.getCustomerDetailsByUsername(Loguser.getUserName());
                            System.out.println(customer);
                            LoginBean user = new LoginBean(customer.getUsername(), customer.getEmailId(),
                                    customer.getProfile(), customer.getGender(), customer.getFirstName(),"Customer");
                            s.setAttribute("User", user);
                            s.setAttribute("CustomerUser", Loguser);
                            response.sendRedirect("Customer.jsp");
                        } else {
                            System.out.println("We have not identified user type");
                        }
                    }
                }
            }
        } catch (Exception e) {
            Message msg = new Message("Something went Wrong", "error", "alert-danger");
            s.setAttribute("message", msg);
            response.sendRedirect("Login.jsp");
            e.printStackTrace();
        }
    }
}
