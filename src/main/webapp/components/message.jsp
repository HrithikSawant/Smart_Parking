<%@page import="com.mycompany.smartparkingmanagement.entities.Message"%>
<%
    Message mess = (Message) session.getAttribute("message");
    if (mess != null) {
        //print
%>

<div class="alert <%= mess.getCssClass()%> alert-dismissible fade show" role="alert">
  <strong><%= mess.getContent() %></strong>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
      
  </button>
</div>


<%              session.removeAttribute("message");
    }
%>  