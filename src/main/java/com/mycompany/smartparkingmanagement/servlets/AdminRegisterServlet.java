package com.mycompany.smartparkingmanagement.servlets;

import api.Generator;
import com.mycompany.smartparkingmanagement.dao.Dao;
import com.mycompany.smartparkingmanagement.entities.Admin;
import com.mycompany.smartparkingmanagement.entities.ForgotPasswordBean;
import com.mycompany.smartparkingmanagement.entities.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        String value = request.getParameter("value");
        try {
            if (value.equals("Regitration")) {

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
                    response.sendRedirect("AdminRegistration_Form.jsp");
                    return;
                } else if (middleName.isEmpty()) {
                    Message msg = new Message("MiddleName is Blank !!", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    System.out.println("MiddleName is blank");
                    response.sendRedirect("AdminRegistration_Form.jsp");
                    return;
                } else if (lastName.isEmpty()) {
                    Message msg = new Message("LastName is Blank !!", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    System.out.println("LastName is blank");
                    response.sendRedirect("AdminRegistration_Form.jsp");
                    return;
                }
                long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
                long aadhaarNo = Long.parseLong(request.getParameter("aadhaarNo"));
                String pancardNo = request.getParameter("pancardNo");
                long alternate_phoneNo = Long.parseLong(alternate);

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                //validation
                //Creating user object to store data;
                Admin admin = new Admin(firstName, middleName,
                        lastName, dob, gender, emailId,
                        alternate_emailId, phoneNo, alternate_phoneNo,
                        country, state, city, aadhaarNo, pancardNo, username, password, "Admin");
                System.out.println(admin);
                Dao Dao = new Dao();
                //inserting in database and returing boolean value
                if (Dao.checkAdmin(admin)) {
                    ForgotPasswordBean forgot = Dao.CheckUsername(username);
                    if (forgot.getStatus()) {
                        Message msg = new Message("Please Enter Unique Username !!", "error", "alert-danger");
                        System.out.println("Please Enter Unique username !!");
                        s.setAttribute("message", msg);
                        response.sendRedirect("AdminRegistration_Form.jsp");
                    } else {
                        s.setAttribute("RegisterUser", admin);
                        Generator g = new Generator();
                        Dao.StoreToken(admin.getEmailId(), g.OTP());
                        Message msg = new Message("OTP Send Successfully, Please Check Your Email<script>\n"
                                + "            $(document).ready(function () {\n"
                                + "                $('#email_id').val(\""
                                + admin.getEmailId() + "\");\n"
                                + "            });\n"
                                + "        </script>", "success", "alert-success");
                        s.setAttribute("message", msg);
                        response.sendRedirect("RegistrationVerifyOTP.jsp");
                        return;
                    }
                } else {
                    Message msg = new Message("It Seems Like You Already have an account !!", "error", "alert-danger");
                    System.out.println("It Seems Like You Already have an account !!");
                    s.setAttribute("message", msg);
                    response.sendRedirect("AdminRegistration_Form.jsp");
                }
            } else if (value.equals("VerifyOTP")) {
                Admin admin = (Admin) s.getAttribute("RegisterUser");
                int OTP = Integer.parseInt(request.getParameter("OTP"));
                System.out.println(OTP);
                Dao d = new Dao();
                if (d.VerfyOTP(admin.getEmailId(), OTP)) {
                    if (Dao.InsertAdminToDB(admin)) {
                        System.out.println("Admin is added successfully..");
                        Message msg = new Message("Register Successful !! " + admin.getFirstName(), "success", "alert-success");
                        s.setAttribute("message", msg);
                        response.sendRedirect("Login.jsp");
                    } else {
                        Message msg = new Message("Unsuccesful", "error", "alert-danger");
                        s.setAttribute("message", msg);
                        response.sendRedirect("AdminRegistration_Form.jsp");
                    }
                } else {
                    Message msg = new Message("Please Enter Correct OTP<script>\n"
                            + "            $(document).ready(function () {\n"
                            + "                $('#email_id').val(\""
                            + admin.getEmailId() + "\");\n"
                            + "            });\n"
                            + "        </script>", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    response.sendRedirect("VerifyOTP.jsp");
                }
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error_page.jsp");//
            return;
        }
    }
}
