<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%@page errorPage="error_page.jsp" %>
<%@page import="com.mycompany.smartparkingmanagement.servlets.pay"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.OrderBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.setHeader("cache-Control", "no-cache,no-store,must-revalidate");
    String id = (String) session.getAttribute("order_id");
    OrderBean ob = new OrderBean();
    LoginBean l = (LoginBean) session.getAttribute("User");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="components/bootstrap.jsp"%>
        <style> 
            .drop{
                width: 5rem;
            }
        </style>
    </head>
    <body>
        <section class="container" style="margin-top: 8rem">
            <div class="card shadow w-50  mx-auto my-5" style="width: 30rem;">
                <div class="card-header text-center">
                    <h3 class="font-weight-bold">BOOKING!</h3>
                </div>
                <%@ include file="components/message.jsp"%>
                <div class="card-body mt-5"> 
                    <form action="Booking" method="POST">
                        <table class="table table-secoundary table-striped">
                            <tbody>
                                <tr>
                                    <th scope="row">Customer Name: </th>
                                    <td><input class="form-control cname" pattern="[a-zA-Z]{3,20}" type="text" name="cust_firstname" value="" /></td>
                                </tr>
                                <tr>
                                    <th scope="row">Surname: </th>
                                    <td><input class="form-control sname" pattern="[a-zA-Z]{3,16}" type="text" name="cust_surname" value="" /></td>
                                </tr>
                                <tr>
                                    <th scope="row">Vehicle Type:</th>
                                    <td><select class="form-control" name="vehicle_type">
                                            <option>two-wheeler</option>
                                            <option>four-wheeler</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Vehicle Number </th>
                                    <td><input class="form-control vnumber" pattern="[[A-Z]{2}[0-9]{1,2}[A-Z]{1,2}[0-9]{3,4}"
                                               type="text" name="vehicle_no" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Date: </th>
                                    <td><input class="form-control" type="date" name="date" id="date"></td>
                                </tr>
                                <tr>
                                    <th scope="row">Entry Time:  </th>
                                    <td class="row">
                                        <label class="font-weight-bold col mt-2">Hrs:</label>
                                        <select class="form-select col" name="start_hrs" id='start_hrs'>
                                            <option>00</option>
                                            <option>01</option>
                                            <option>02</option>
                                            <option>03</option>
                                            <option>04</option>
                                            <option>05</option>
                                            <option>06</option>
                                            <option>07</option>
                                            <option>08</option>
                                            <option>09</option>
                                            <option>10</option>
                                            <option>11</option>
                                            <option>12</option>
                                            <option>13</option>
                                            <option>14</option>
                                            <option>15</option>
                                            <option>16</option>
                                            <option>17</option>
                                            <option>18</option>
                                            <option>19</option>
                                            <option>20</option>
                                            <option>21</option>
                                            <option>22</option>
                                            <option>23</option>
                                        </select>
                                        <label class="font-weight-bold col mt-2">Min:</label>
                                        <select class="form-select col" name="start_mins" onchange="compareDate()">
                                            <option>00</option>
                                            <option>30</option>
                                        </select>
                                    </td>
                                </tr>
                                <!--//-->
                                <tr>
                                    <th scope="row">Exit Time:  </th>
                                    <td class="row">
                                        <label class="font-weight-bold col mt-2" >Hrs:</label>
                                        <select class="form-select col" name="end_hrs">
                                            <option>00</option>
                                            <option>01</option>
                                            <option>02</option>
                                            <option>03</option>
                                            <option>04</option>
                                            <option>05</option>
                                            <option>06</option>
                                            <option>07</option>
                                            <option>08</option>
                                            <option>09</option>
                                            <option>10</option>
                                            <option>11</option>
                                            <option>12</option>
                                            <option>13</option>
                                            <option>14</option>
                                            <option>15</option>
                                            <option>16</option>
                                            <option>17</option>
                                            <option>18</option>
                                            <option>19</option>
                                            <option>20</option>
                                            <option>21</option>
                                            <option>22</option>
                                            <option>23</option>
                                        </select>
                                        <label class="font-weight-bold col mt-2">Min:</label>
                                        <select class="form-select col" class="form-select" name="end_mins">
                                            <option>00</option>
                                            <option>30</option>
                                        </select> 
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="hidden" name="val" value="online" />
                        <input type="submit" onclick="return validate()" class="btn btn-success" value="Book" />
                    </form>
                </div>
            </div>
        </section>
                
        <p id ="content"></p>
        <form action="PaymentTest" method="POST" name="razorpayForm">
            <input id="razorpay_payment_id" type="hidden" name="razorpay_payment_id" />
            <input id="razorpay_order_id" type="hidden" name="razorpay_order_id" />
            <input id="razorpay_signature" type="hidden" name="razorpay_signature" />
        </form>
        <script>
            var today = new Date();
            var dd = String(today.getDate()).padStart(2, '0');
            var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
            var yyyy = today.getFullYear();
            var dd2 = String((today.getDate()) + 7).padStart(2, '0');

            var time = today.getHours() + ":" + today.getMinutes();
            today = yyyy + '-' + mm + '-' + dd;
            week = yyyy + '-' + mm + '-' + dd2;
            var cal_date = document.getElementById("date");

            cal_date.setAttribute("min", today);
            cal_date.setAttribute("max", week);
            
            function validate(){
                let f = true;
                let c_name = $(".cname").val();
                let s_name = $(".sname").val();
                let vnumber = $(".vnumber").val();
                if (c_name == "" || c_name == undefined) {
                    swal("oops", "name is required", "warning");
                    f = false;
                }else if(s_name == "" || s_name == undefined) {
                    swal("oops", "surname is required !!", "warning");
                    f = false;
                }else if(vnumber == "" || vnumber == undefined){
                    swal("oops", "Vehicle no is required !!", "warning");
                    f = false;
                }
                return f;
            }
        </script>
        <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
        <script>
            var options = {
                "key": "rzp_test_OjRvNWbHuRbnNA", // Enter the Key ID generated from the Dashboard
                // "amount": "30000000",  Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
                "currency": "INR",
                "name": "Smart Parking",
                "description": "Test Transaction",
                "image": "",
                "order_id": "<%= id%>", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
                "handler": function (response) {
                    document.getElementById('razorpay_payment_id').value = response.razorpay_payment_id;
                    document.getElementById('razorpay_order_id').value = response.razorpay_order_id;
                    document.getElementById('razorpay_signature').value = response.razorpay_signature;
                    document.razorpayForm.submit();
                    swal("Good job!", "Congrates !! Payment Successful !!", "success");

                },
                "prefill": {
                    "name": "<%= l.getFirstName()  %>",
                    "email": "<%= l.getEmailid()  %>",
//                    "contact": "9869722209"
                },
                "notes": {
                    "address": "Razorpay Corporate Office"
                },
                "theme": {
                    "color": "#3399cc"
                }
            };
            var rzp1 = new Razorpay(options);
            rzp1.on('payment.failed', function (response) {
                console.log(response.error.code);
                console.log(response.error.description);
                console.log(response.error.source);
                console.log(response.error.step);
                console.log(response.error.reason);
                console.log(response.error.metadata.order_id);
                console.log(response.error.metadata.payment_id);

                swal("Failed !!", "!!Oops payment failed !!", "error");
            });

            document.getElementById('rzp-button1').onclick = function (e) {
                rzp1.open();
                e.preventDefault();
            };
        </script>

    </body>
</html>