<%@page errorPage="error_page.jsp" %>
<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%
    LoginBean custlog = (LoginBean) session.getAttribute("CurrentUser");
    if (custlog == null) {
        response.sendRedirect("Login.jsp");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>
        <%@ include file="components/header.jsp"%>
        <div class="mt-5">
            <%@ include file="booking.jsp"%>
        </div>
        <%@ include file="components/footer.jsp"%> 
    </body>
</html>
