<%@page errorPage="error_page.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="components/bootstrap.jsp"%>
        <title>Offline Booking</title>
    </head>
    <body>
        <section class="container">
            <div class="card shadow w-50  mx-auto mb-5" style="width: 30rem;">
                <div class="card-header text-center">
                    <h3 class="font-weight-bold">OFFLINE BOOKING!</h3>
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
                                    <td>
                                        <select class="form-select" name="vehicle_type">
                                            <option>two-wheeler</option>
                                            <option>four-wheeler</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">Vehicle Number </th>
                                    <td><input class="form-control vnumber" pattern="[[A-Z]{2}[0-9]{1,2}[A-Z]{1,2}[0-9]{3,4}"
                                               type="text" name="vehicle_no" value="" /></td>
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
                                <tr>
                                    <th scope="row">Exit Time:  </th>
                                    <td class="row">
                                        <label class="font-weight-bold col mt-2">Hrs:</label>
                                        <select class="form-select col" name="end_hrs" id="end_hrs">  
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
                                        <select class="form-select col" name="end_mins">
                                            <option>00</option>
                                            <option>30</option>
                                        </select> 
                                    </td>
                                </tr>
                                <!--//-->
                            </tbody>
                        </table>
                        <input type="hidden" name="val" value="onspot" />
                        <input type="submit" onclick="return validate()" class="btn btn-success" value="Book"/>
                    </form>
                </div>
            </div>
        </section>
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
    </body>
</html>