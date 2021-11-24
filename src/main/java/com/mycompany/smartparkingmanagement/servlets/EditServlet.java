package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.dao.Dao;
import com.mycompany.smartparkingmanagement.entities.Admin;
import com.mycompany.smartparkingmanagement.entities.LoginBean;
import com.mycompany.smartparkingmanagement.entities.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the user from the session...
        HttpSession s = request.getSession();
        try {

            //fetch all data
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String cpass = request.getParameter("confirmpass");

            if (!password.equals(cpass)) {
                Message msg = new Message("Password not matched", "error", "alert-danger");
                s.setAttribute("message", msg);
                response.sendRedirect("Profile.jsp");
            } else {
                LoginBean lg = (LoginBean) s.getAttribute("User");
                lg.setFirstName(name);
                lg.setEmailid(email);
                lg.setPassword(password);
                
                Dao dao = new Dao();
                //update to db
                boolean ans = dao.updateUserDetails(lg);
                if (ans) {
                    Message msg = new Message("Detail Updated Succesfully", "success", "alert-success");
                    s.setAttribute("message", msg);
                    response.sendRedirect("Profile.jsp");
                } else {
                    Message msg = new Message("Details Not Updated", "error", "alert-danger");
                    System.out.println("Something went Wrong");
                    s.setAttribute("message", msg);
                    response.sendRedirect("Profile.jsp");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("error_page.jsp");
        }
    }
}
