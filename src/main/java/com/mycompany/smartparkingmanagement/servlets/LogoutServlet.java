/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.entities.Admin;
import com.mycompany.smartparkingmanagement.entities.LoginBean;
import com.mycompany.smartparkingmanagement.entities.Message;
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
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        LoginBean lg = (LoginBean) s.getAttribute("CurrentUser");
        if (lg.getRole().equals("Admin")) {
            s.removeAttribute("CurrentUser");
            s.removeAttribute("AdminUser");
        } else if (lg.getRole().equals("Staff")) {
            s.removeAttribute("CurrentUser");
            s.removeAttribute("StaffUser");
        } else if (lg.getRole().equals("Normal")) {
            s.removeAttribute("CurrentUser");
            s.removeAttribute("StaffUser");
        }
        Message msg = new Message("Logout Successfully!!", "success", "alert-success");
        s.setAttribute("message", msg);
        response.sendRedirect("Login.jsp");

    }

}
