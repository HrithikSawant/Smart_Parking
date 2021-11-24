<%@page import="com.mycompany.smartparkingmanagement.entities.BookingBean"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.Slot"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.Week"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%@page import="com.mycompany.smartparkingmanagement.dao.DashBoardDao"%>
<%@page errorPage="error_page.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer hitsCount = (Integer) application.getAttribute("hitCounter");
    DashBoardDao dash = new DashBoardDao();
    ArrayList<LoginBean> list = dash.getAllLoginDetails();
    ArrayList<Slot> slot = dash.slotStatus();
    ArrayList<BookingBean> vehicle = dash.visitedVehicle();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DashBoard</title>
        <%@ include file="components/bootstrap.jsp"%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <section>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 fw-bold fs-3">Dashboard</div>
                </div>
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <div class="card text-center text-white bg-secondary h-100">
                            <h2 class="card-header">Total Users</h2>
                            <div class="card-body">
                                <h1 class="card-text"><%= list.size()%></h1>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 mb-3">
                        <div class="card text-center border-dark text-white bg-secondary h-100">
                            <h2 class="card-header">Website Visitor Count</h2>
                            <div class="card-body">
                                <!--                                <h5 class="card-title">visitor number: </h5>-->
                                <h1 class="card-text"><%= hitsCount%></h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <div class="card text-center text-white bg-secondary h-100">
                            <div class="card-body">
                                <h4 class="card-title my-2">Top Booking Customers</h4>
                                <a data-bs-toggle="modal"  data-bs-target="#ViewTopCustomerModal"  class="btn btn-dark mt-5">View</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--                    <div class="col-md-3 mb-3">
                                    <div class="card text-white bg-primary h-100">
                                        <div class="card-header">Header</div>
                                        <div class="card-body">
                                            <h5 class="card-title">Primary card title</h5>
                                            <p class="card-text">Some quick example text to build on the card
                                                title and make up the bulk of the card's content.</p>
                                        </div>
                                    </div>
                                </div>-->

        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">Charts</div>
                    <div class="card-body">
                        <div class="chartBox">
                            <canvas id="myChart" width="400" height="400"></canvas>
                            <div class="col-md-8" >
                                <div class="spinner-border" role="status" id="loader">
                                    <span class="visually-hidden">Loading...</span>
                                </div>
                                <div id="post-container">
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-6">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">SLOT ID</th>
                            <th scope="col">BLOCK ID</th>
                            <th scope="col">STATUS</th>
                            <th scope="col">BUFFER</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Slot sl : slot) {
                        %>
                        <tr>
                            <td><%= sl.getSlot_id()%></td>
                            <td><%= sl.getBlock_id()%></td>
                            <td><%= sl.getStatus()%></td>
                            <td><%= sl.getBuffer()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>      
            </div>
            <!-------------------------Top Booking Customers MODAL------------------------------>
            <div class="modal fade"  id="ViewTopCustomerModal" aria-hidden="true" tabindex="-1">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Top Booking Customers</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <table class="table table-striped" style="display: hide;">
                                <thead>
                                    <tr>
                                        <th scope="col">COUNT</th>
                                        <th scope="col">FIRST NAME</th>
                                        <th scope="col">SURNAME</th>
                                        <th scope="col">VEHICLE No</th>
                                        <th scope="col">DATE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%  if (vehicle != null) {
                                        for (BookingBean vk : vehicle) {%>
                                    <tr>
                                        <td><%=  vk.getBook_id()%></td>
                                        <td><%=  vk.getCust_name()%></td>
                                        <td><%=  vk.getCust_surname()%></td>
                                        <td><%=  vk.getVehicle_no()%></td>
                                        <td><%=  vk.getDate()%></td> 
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <!----------------------///////Top Booking Customers MODAL//////////-------------------------->

        </div>
    </div>
</section>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "LoadData.jsp",
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                $("#loader").hide();
                $('#post-container').html(data);
            }
        });
    });
</script>
</body>
</html>