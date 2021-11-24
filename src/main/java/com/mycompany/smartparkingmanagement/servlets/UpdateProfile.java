
package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.dao.Dao;
import com.mycompany.smartparkingmanagement.entities.LoginBean;
import com.mycompany.smartparkingmanagement.entities.Message;
import com.mycompany.smartparkingmanagement.helper.Helper;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class UpdateProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Part part = request.getPart("profile");
            String post = part.getSubmittedFileName();
            HttpSession s = request.getSession();
            
            LoginBean lg = (LoginBean) s.getAttribute("User");
            String pre = lg.getUserName();
            String oldFile = lg.getProfile();
            String imageName = pre + post;
            lg.setProfile(imageName);

            //update to db
            Dao dao = new Dao();
            boolean ans = dao.updateUserProfile(lg);
            if (ans) {
                String path = request.getRealPath("/") + "profile" + File.separator + lg.getProfile();
                String oldFilePath = request.getRealPath("/") + "profile" + File.separator + oldFile;
                //delete old file
                Helper.deleteFile(oldFilePath);

                if (Helper.saveFile(part.getInputStream(), path)) {
                    Message msg = new Message("Profile updated", "success", "alert-success");
                    s.setAttribute("message", msg);
                    response.sendRedirect("Profile.jsp");
                } else {
                    Message msg = new Message("Profile Updation unsuccessful", "error", "alert-danger");
                    System.out.println("Something went Wrong");
                    s.setAttribute("message", msg);
                    response.sendRedirect("Profile.jsp");
                }
            } else {
                Message msg = new Message("Something went Wrong", "error", "alert-danger");
                System.out.println("Something went Wrong");
                s.setAttribute("message", msg);
                response.sendRedirect("Profile.jsp");
            }
        }catch (IOException | ServletException e){
            e.printStackTrace();
            response.sendRedirect("error_page.jsp");//
        }
    }
}
