<%@page import="com.mycompany.smartparkingmanagement.entities.BookingBean"%>
<%
    BookingBean bk = (BookingBean) session.getAttribute("Retrive");
    if (bk != null) {
        //print
%>


<%              session.removeAttribute("Retrive");
    }
%>  