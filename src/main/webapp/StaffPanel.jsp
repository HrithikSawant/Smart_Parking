<%@page errorPage="error_page.jsp" %>
<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.Staff"%>
<% response.setHeader("cache-Control", "no-cache,no-store,must-revalidate");
    HttpSession msg = request.getSession();
    LoginBean lg = (LoginBean) session.getAttribute("CurrentUser");
    if (lg == null) {
        msg.setAttribute("message", "Please Login First!!");
        response.sendRedirect("Login.jsp");
        return;
    }
Staff st = (Staff) session.getAttribute("StaffUser");
%>
<%@page errorPage="error_page.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= lg.getUserName() %>!</h1>
        <h2>Welcome to Staff Panel</h2>    <br>
        <a href="LogoutServlet">Logout</a>
    </body>
</html>
