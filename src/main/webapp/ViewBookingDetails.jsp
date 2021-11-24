<%@page import="com.mycompany.smartparkingmanagement.entities.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.BookingBean"%>
<%@page import="com.mycompany.smartparkingmanagement.dao.DashBoardDao"%>
<%
    ArrayList<BookingBean> list = (ArrayList<BookingBean>) request.getAttribute("list");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Booking Details</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>
        <%@ include file="components/message.jsp"%>
        <div class="row">
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Search Booking by ACT</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#SearchBookingbyActModal" class="btn btn-dark mt-5">Search</a>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Search Booking by Range</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#SearchBookingbyRangeModal" class="btn btn-dark mt-5">Search</a>
                    </div>
                </div>
            </div>
        </div>
        <!--------------------------------SearchBookingbyActModal--------------------------------------->
        <div class="modal fade"  id="SearchBookingbyActModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Search Booking Details</h5>                       
                        <!--<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">
                        <label>Update booking time (check one option current timestamp will be given)</label>                     
                        <form name="SearchBookingDetails" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Date :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3"> 
                                    <input class="form-control" type='date' name='date' id='date'>
                                </div>
                                <div class="col-3 mt-3 ms-5">
                                    <input class="form-check-input" type="radio" name="act" value="on" checked="checked" />                                            
                                    <label class="form-check-label ms-3">On</label>
                                </div>
                                <div class="col-3 mt-3 ms-2">
                                    <input class="form-check-input" type="radio" name="act" value="before" />                                     
                                    <label class="form-check-label ms-3">Before</label>
                                </div>
                                <div class="col-3 mt-3 ms-2">
                                    <input class="form-check-input" type="radio" name="act" value="after" />                                    
                                    <label class="form-check-label ms-3">After</label>
                                </div> 
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="searchbookingdetails" /><br>
                                    <button type="submit" value="Search" class="btn btn-primary col-5 col-sm-3 mt-4">Search</button>
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////Search Booking by Act MODAL//////////-------------------------->


        <!--------------------------------SearchBookingbyRangeModal--------------------------------------->
        <div class="modal fade"  id="SearchBookingbyRangeModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Search Booking Details</h5>                       
                        <!--<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">
                        <label>Update booking time (check one option current timestamp will be given)</label>                     
                        <form name="SearchBookingByrange" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">
                                <div class="form-group col-12 ms-5 mt-3">  
                                    <h4 class="label"><b>Range:</b></h4>   
                                </div>
                                <div class="col-5 mt-3 ms-2">
                                    <label class="form-check-label ms-3">Start</label>
                                </div>
                                <div class="col-5 form-group ms-2  mt-3"> 
                                    <input type='date' name='mindate' id='mindate'>           
                                </div>
                                <div class="col-5 form-group ms-2 mt-3">  
                                    <label class="form-check-label ms-3">End</label>  
                                </div>
                                <div class="form-group ms-2 col-5 mt-3"> 
                                    <input type='date' name='maxdate' id='maxdate'>
                                </div>
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="searchbookingbyrange" /><br>
                                    <button type="submit" value="Search" class="btn btn-primary col-5 col-sm-3 mt-4">Search</button>
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////Search Booking by Range MODAL//////////-------------------------->        

        <%            if (list != null) {
                if (list.size() > 0) {
        %>
        <table name="SeachBookingDetails" class="table table-striped mt-5">
            <thead>
                <tr>
                    <th scope="col">Book ID</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Vehicle Type</th>
                    <th scope="col">Vehicle no</th>
                    <th scope="col">Booked Date</th>
                    <th scope="col">Start Time</th>
                    <th scope="col">End Time</th>
                    <th scope="col">CheckIn Time</th>
                    <th scope="col">CheckOut Time</th>
                    <th scope="col">Total Amount</th>
                    <th scope="col">Amount Paid</th>
                    <th scope="col">Slot id</th>
                </tr>
            </thead>
            <tbody>
                <%  for (BookingBean log : list) {%>
                <tr>
                    <td><%= log.getBook_id()%></td>
                    <td><%= log.getCust_name()%></td>
                    <td><%= log.getCust_surname()%></td>
                    <td><%= log.getVehicle_type()%></td>
                    <td><%= log.getVehicle_no()%></td>
                    <td><%= log.getDate()%></td>
                    <td><%= log.getStr_start_time()%></td>
                    <td><%= log.getStr_end_time()%></td>
                    <td><%= log.getCheckIn()%></td>
                    <td><%= log.getCheckOut()%></td>
                    <td><%= log.getTotal_amount()%></td>
                    <td><%= log.getAmount_paid()%></td>
                    <td><%= log.getSlot_no()%></td>
                </tr>
                <%
                    }
                } else {
                %>
            </tbody>
        </table>
        <div>No Record Found</div>
        <%
                }
            }
        %>
    </body>  
</html>
