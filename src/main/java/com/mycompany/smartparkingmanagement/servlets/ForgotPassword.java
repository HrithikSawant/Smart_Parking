/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.servlets;

import com.mycompany.smartparkingmanagement.dao.Dao;
import com.mycompany.smartparkingmanagement.entities.ForgotPasswordBean;
import com.mycompany.smartparkingmanagement.entities.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForgotPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ForgotPasswordBean forgot;
            HttpSession s = request.getSession();
            String value = request.getParameter("value");

            if (value.equals("forgot")) {
                String emailid = request.getParameter("email");
                String username = request.getParameter("username");

                Dao d = new Dao();
                forgot = d.CheckUsername(username);
                if (forgot.getStatus()) {
                    switch (forgot.getRole()) {
                        case "Admin": {
                            boolean CheckEmailid = d.CheckEmailIdofAdmin(emailid);
                            if (CheckEmailid) {
                                Message msg = new Message("OTP Send Successfully, Please Check Your Email<script>\n"
                                        + "            $(document).ready(function () {\n"
                                        + "                $('#email_id').val(\""
                                        + emailid + "\");\n"
                                        + "            });\n"
                                        + "        </script>", "success", "alert-success");
                                s.setAttribute("message", msg);
                                response.sendRedirect("VerifyOTP.jsp");
                            } else {
                                Message msg = new Message("Enter Valid EmailId", "error", "alert-danger");
                                s.setAttribute("message", msg);
                                response.sendRedirect("Forgot_Password.jsp");
                            }
                            break;
                        }
                        case "Customer": {
                            boolean CheckEmailid = d.CheckEmailIdofUser(emailid);
                            if (CheckEmailid == true) {
                                Message msg = new Message("OTP Send Successfully, Please Check Your Email<script>\n"
                                        + "            $(document).ready(function () {\n"
                                        + "                $('#email_id').val(\""
                                        + emailid + "\");\n"
                                        + "            });\n"
                                        + "        </script>", "success", "alert-success");
                                s.setAttribute("message", msg);
                                response.sendRedirect("VerifyOTP.jsp");;
                            } else {
                                Message msg = new Message("Enter Valid EmailId", "error", "alert-danger");
                                s.setAttribute("message", msg);
                                response.sendRedirect("Forgot_Password.jsp");
                            }
                            break;
                        }
                        //
                        case "Staff": {
                            boolean CheckEmailid = d.CheckEmailIdofUser(emailid);
                            if (CheckEmailid == true) {
                                Message msg = new Message("OTP Send Successfully, Please Check Your Email<script>\n"
                                        + "            $(document).ready(function () {\n"
                                        + "                $('#email_id').val(\""
                                        + emailid + "\");\n"
                                        + "            });\n"
                                        + "        </script>", "success", "alert-success");
                                s.setAttribute("message", msg);
                                response.sendRedirect("VerifyOTP.jsp");;
                            } else {
                                Message msg = new Message("Enter Valid EmailId", "error", "alert-danger");
                                s.setAttribute("message", msg);
                                response.sendRedirect("Forgot_Password.jsp");
                            }
                            break;
                        }
                        default:
                            Message msg = new Message("Please Enter Valid username", "error", "alert-danger");
                            s.setAttribute("message", msg);
                            response.sendRedirect("Forgot_Password.jsp");
                            break;
                    }
                    forgot = new ForgotPasswordBean(username, emailid, forgot.getRole());
                    s.setAttribute("detail", forgot);
                } else {
                    Message msg = new Message("Please Enter Valid username", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    response.sendRedirect("Forgot_Password.jsp");
                }
            } else if (value.equals("check")) {
                forgot = (ForgotPasswordBean) s.getAttribute("detail");
                System.out.println("check " + forgot);
                int OTP = Integer.parseInt(request.getParameter("OTP"));
                System.out.println(OTP);
                Dao d = new Dao();
                if (d.VerfyOTP(forgot.getEmailid(), OTP)) {
                    Message msg = new Message("OTP Verified Successfully<script>\n"
                            + "            $(document).ready(function () {\n"
                            + "                $('#done').hide();\n"
                            + "                $('#confirm').show();\n"
                            + "                $('#username').val(\""
                            + forgot.getUsername() + "\");\n"
                            + "            });\n"
                            + "        </script>",
                            "success", "alert-success");
                    s.setAttribute("message", msg);
                    response.sendRedirect("VerifyOTP.jsp");
                } else {
                    Message msg = new Message("Please Enter Correct OTP<script>\n"
                            + "            $(document).ready(function () {\n"
                            + "                $('#email_id').val(\""
                            + forgot.getEmailid() + "\");\n"
                            + "            });\n"
                            + "        </script>", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    response.sendRedirect("VerifyOTP.jsp");
                }
            } else if (value.equals("reset_password")) {
                forgot = (ForgotPasswordBean) s.getAttribute("detail");
                Dao d = new Dao();
//                email = (Email) s.getAttribute("detail");
                String pass = request.getParameter("pass");
                String cpass = request.getParameter("cpass");
                if (!pass.equals(cpass)) {
                    Message msg = new Message("Password & confirm Password should Matched<script>\n"
                            + "            $(document).ready(function () {\n"
                            + "                $('#done').hide();\n"
                            + "                $('#confirm').show();\n"
                            + "                $('#username').val(\""
                            + forgot.getUsername() + "\");\n"
                            + "            });\n"
                            + "        </script>", "error", "alert-danger");
                    s.setAttribute("message", msg);
                    response.sendRedirect("VerifyOTP.jsp");
                } else {
                    if (d.UserPassword(pass, forgot.getUsername())) {
                        System.out.println("Succuessful");
                        Message msg = new Message("Password Updated Successfully Please Login", "success", "alert-success");
                        s.setAttribute("message", msg);
                        response.sendRedirect("Login.jsp");
                    } else {
                        System.out.println("Password not Updated");
                        Message msg = new Message("Password not Updated<script>\n"
                                + "            $(document).ready(function () {\n"
                                + "                $('#done').hide();\n"
                                + "                $('#confirm').show();\n"
                                + "                $('#username').val(\""
                                + forgot.getUsername() + "\");\n"
                                + "            });\n"
                                + "        </script>", "error", "alert-danger");
                        s.setAttribute("message", msg);
                        response.sendRedirect("VerifyOTP.jsp");
                    }
                }
            }else if(value.equals("RegistrationOTP")){
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error_page.jsp");//
        }
    }
}
