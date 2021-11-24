<%-- 
    Document   : ManageBookingDetails
    Created on : Sep 26, 2021, 6:58:41 PM
    Author     : Hrithik
--%>
<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%@page errorPage="error_page.jsp" %>
<% response.setHeader("cache-Control", "no-cache,no-store,must-revalidate");
    HttpSession s = request.getSession();
    LoginBean acc = (LoginBean) session.getAttribute("CurrentUser");
    if (acc == null) {
        Message msg = new Message("Please Login First!!", "error", "alert-danger");
        s.setAttribute("message", msg);
        response.sendRedirect("Login.jsp");
        return;
    } else if (acc.getRole().equals("Staff")) {
        Message msg = new Message("You are not admin!! do not access this page", "error", "alert-danger");
        s.setAttribute("message", msg);
        response.sendRedirect("AdminPanel.jsp");
    } else {
%>
<%@page import="com.mycompany.smartparkingmanagement.entities.Admin"%>
<%
    Admin ad = (Admin) session.getAttribute("AdminUser");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Booking</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>
        <%@ include file="components/message.jsp"%>
        <div class="row">
            <!-- ALLOT SLOT  Card-->
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Allot A Slot For Booking Id</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#AllotSlotModal" class="btn btn-dark mt-5">Allot A Slot</a>
                    </div>
                </div>
            </div>

            <!--UPDATE PAID AMOUNT Card-->
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Update Paid Amount</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#UpdatePaidAmountModal" class="btn btn-dark mt-5">Update</a>
                    </div>
                </div>
            </div>

            <!--UPDATE BOOKING TIME Card-->
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Update Booking time</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#UpdateBookingTimeModal" class="btn btn-dark mt-5">Update Time</a>
                    </div>
                </div>
            </div>

            <!--Total Cost Card-->
            <div class="col-lg-4 mt-5">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title my-2">Total Cost</h4>
                        <a data-bs-toggle="modal"  data-bs-target="#TotalCostModal" class="btn btn-dark mt-5">Total Cost</a>
                    </div>
                </div>
            </div>
        </div>

        <!--------------------------------ALLOT SLOT MODAL--------------------------------------->
        <div class="modal fade"  id="AllotSlotModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Allot A Slot For Booking Id</h5>                       
                        <!--<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">                      
                        <form name="UpdateBookingSlotNo" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">                        
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Slot ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3"> 
                                    <input class="form-control" type="text" name="slot_id" value="" />
                                </div>
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Book ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3">                                                     
                                    <input class="form-control" type="text" name="book_id" value="" />
                                </div>
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="updatebookingslotno" />
                                    <button type="submit" value="Ok" class="btn btn-primary col-5 col-sm-3 mt-4">Allot</button>                  
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////ALLOT SLOT MODAL//////////-------------------------->

        <!--------------------------------UPDATEPAIDAMOUNT SLOT--------------------------------------->
        <div class="modal fade"  id="UpdatePaidAmountModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Update Paid Amount</h5>                       
                        <!--<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body"> 
                        <form name="UpdateAmount" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">  
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Book ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3">                                                     
                                    <input class="form-control" type="text" name="book_id" value="" />
                                </div>

                                <div class="form-group col-5 ms-2 mt-3 ">  
                                    <h4 class="label"><b>Amount Paid :</b></h4>  
                                </div>
                                <div class="form-group col-6 ms-2 mt-3 "> 
                                    <input class="form-control" type="text" name="paid_amount" value="" />
                                </div>
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="updateamount" />
                                    <button type="submit" value="Update Amount" class="btn btn-primary col-5 col-sm-3 mt-4">Update</button>             
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////UPDATEPAIDAMOUNT MODAL//////////-------------------------->

        <!--------------------------------UPDATE Booking Time--------------------------------------->
        <div class="modal fade"  id="UpdateBookingTimeModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Update booking time</h5>                       
                        <!--<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">
                        <label>Update booking time (check one option current timestamp will be given)</label>                     
                        <form name="UpdateBookingTime" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Book ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3"> 
                                    <input class="form-control" type="text" name="book_id" value="" />
                                </div>
                                <div class="col-4 mt-3 ms-5">
                                    <input class="form-check-input" type="radio" name="time" value="checkin" checked="checked" />                                              
                                    <label class="form-check-label ms-3">Checkin time</label>
                                </div>
                                <div class="col-4 mt-3 ms-2">
                                    <input class="form-check-input" type="radio" name="time" value="checkout" />                                     
                                    <label class="form-check-label ms-3">Checkout time</label>
                                </div>                          
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="updatebookingtime" />
                                    <button type="submit" value="Update" class="btn btn-primary col-5 col-sm-3 mt-4">Update</button>
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////UPDATE Booking Time MODAL//////////-------------------------->

        <!--------------------------------TOTAL COST MODAL--------------------------------------->
        <div class="modal fade"  id="TotalCostModal" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Total Cost</h5>                       
                        <!--<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body"> 
                        <form name="TotalCost" action="AdminPanel" method="POST">
                            <div class="form-group row align-items-center">  
                                <div class="form-group col-4 ms-5 mt-3">  
                                    <h4 class="label"><b>Book ID :</b></h4>  
                                </div>
                                <div class="form-group ms-2 col-6 mt-3"> 
                                    <input class="form-control" type="text" name="book_id" value="" />
                                </div> 
                                <div class="form-group d-flex justify-content-center">
                                    <input type="hidden" name="val" value="totalamount" />
                                    <button type="submit" value="View Amount" class="btn btn-primary col-5 col-sm-3 mt-4">View</button>          
                                    <button type="button" class="btn btn-dark col-5 col-sm-3 mt-4 ms-2" data-bs-dismiss="modal">Cancel</button>         
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------///////TOTAL COST MODAL//////////-------------------------->
    </body>
</html>
<%    }
%>
