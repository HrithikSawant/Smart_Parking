<%@page errorPage="error_page.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="components/bootstrap.jsp"%>
        <title>About Page</title>
        <style>
            .item:hover{
                background:     #ccf2ff;
            }
        </style>
    </head>
    <body>
        <main>
            <div class="row">
                <div class="section-head col-sm-12 text-center">
                    <h4 style="color: #006080" class="fs-1 p-2">Smart Parking Management </h4>
                    <p class="lh-base text-center " style="color: #0086b3"> A parking management system automates a car parking system. 
                        It optimizes parking space and make processes efficient. 
                        <br>It gives real-time car parking information such as vehicle & slot counts,<br> available slots display, 
                        reserved parking, pay-and-park options, <br>easy payments, reports, and a host of other features.  </p>
                    <br> 
                </div>
                <div class="col-lg-4">
                    <div class="item text-center pl-30 pt-30 shadow-lg p-4 m-8  rounded border border-3 border-info">
                        <span class="icon">
                            <i class="bi bi-phone-fill"></i>
                        </span>
                        <h6>Smart Parking Booking System</h6>
                        <p>The built-in parking reservation system you to manage bookings,
                            customer details, <br> park space types and extra services on our smart<br>  parking website.</p>
                    </div>
                </div>
                <div class="col-lg-4 ">
                    <div class="item text-center pl-30 pt-30 shadow-lg p-4 m-8 rounded border border-3  border-info" >
                        <span class="icon">
                            <i class="bi bi-cash-coin"></i>
                        </span>
                        <h6>Manage Prices & Promos </h6>
                        <p>Set standard parking fees (per hour,<br> per day, etc.) for  particular periods.
                            Launch<br> hot offers and special discounts to promote<br> sales and foster customer loyalty.
                        </p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="item text-center pl-30 pt-30 shadow-lg p-4 m-8 rounded border border-3 border-info">
                        <span class="icon ">
                            <i class="bi bi-bar-chart-fill"></i>
                        </span>
                        <h6>View Periodic Reports</h6>
                        <p>Generate automatic reports for all bookings <br>and extras within a selected period.
                            <br>Thus you can analyze your business results<br> and take corrective measures, if necessary.
                        </p>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
