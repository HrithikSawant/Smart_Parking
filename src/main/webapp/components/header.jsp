<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%
    LoginBean log = (LoginBean) session.getAttribute("CurrentUser");
%>
<!--   Navbar   -->
<nav class="navbar navbar-expand-lg navbar-dark  fixed-top" style="background-color: black" >
    <div class="container-fluid">
        <!--offcanvas trigger-->
        <button class="navbar-toggler me-3" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
            <span class="navbar-toggler-icon" data-bs-target="#offcanvasExample"></span>
        </button>
        <!--offcanvas trigger-->
        <a class="navbar-brand" href="index.jsp">Smart Park</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value = "about.jsp"/>">About</a>
                </li>
            </ul>
            <!--Login & Register-->
            <div>
                <%
                    if (log == null) {
                %>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0" >
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value = "Login.jsp"/>">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"href="<c:url value = "CustormerRegistration.jsp"/>">Register</a>
                    </li>
                </ul>

                <% } else if (log.getRole().equals("Admin")) {

                %>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    </li>
                    <li class="nav-item">
                    <li> <a class="text-decoration-none" href="<c:url value = "AdminPanel.jsp"/>">
                            <h5 class="nav-link me-3 font-weight-bold">Admin Panel</h5> </a></li>
                    </li
                    <li class="nav-item">
                    <li><h5 class="nav-link me-3 font-weight-bold"  href="#">Welcome, <%= log.getUserName()%></h5> </li>
                    </li>
                    <li class="nav-item">
                    <li><a class="nav-link me-2" href="LogoutServlet">Logout</a></li>
                    </li>
                </ul>
                <%      } else {

                %>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0"> 
                    <li class="nav-item">
                    <li>
                        <a class="nav-link me-2" href="<c:url value = "Profile.jsp"/>">
                            <h5>Profile</h5></a>
                    </li>
                    <li class="nav-item">
                    <li>
                        <h5 class="nav-link me-3 font-weight-bold"  href="#">Welcome, <%= log.getUserName()%></h5> 
                    </li>
                    </li>   
                    <li class="nav-item">
                    <li>
                        <a class="nav-link me-2" href="LogoutServlet">Logout</a>
                    </li>
                    </li>
                </ul>
                <%      }
                %>
            </div>
        </div>
    </div>
</nav>

