<%@page errorPage="error_page.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rate</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>
        <div class="card shadow w-50  mx-auto my-5" style="width: 30rem;">
            <div class="card-header text-center">
                <h3 class="font-weight-bold">Update Vehicle details </h3>
            </div>
            <%@ include file="components/message.jsp"%>
            <div class="card-body mt-5"> 
                <form name="VehicleAdd" action="AdminPanel" method="POST">
                    <table class="table table-secoundary table-striped">
                        <tbody>
                            <tr>
                                <th scope="row">Vehicle Type:</th>
                                <td><select class="form-select" name="vehicle_type">
                                        <option>two-wheeler</option>
                                        <option>four-wheeler</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">Actual Rate for 30 mins</th>
                                <td><input class="form-control actualrate"  type="text" pattern="[0-9\/]*" title="Please Enter Number" name="rate" value="" /></td>
                            </tr>
                            <tr>
                                <th scope="row">Increment Rate for 30 mins</th>
                                <td><input class="form-control incrementrate" type="text" pattern="[0-9\/]*" title="Please Enter Number" name="increment_rate" value="" /></td>
                            </tr>
                            <tr>
                                <th scope="row">Open Time :</th>
                                <td class="row">
                                    <label class="font-weight-bold col mt-2">Hrs:</label>
                                    <select class="drop form-select col"  name="open_hrs">
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
                                    <select class="drop form-select col" name="open_mins">
                                        <option>00</option>
                                        <option>30</option>
                                    </select>
                                </td>
                            </tr>
                            <!--//-->
                            <tr>
                                <th scope="row">Close Time :</th>
                                <td class="row">
                                    <label class="font-weight-bold col mt-2" >Hrs:</label>
                                    <select class="drop form-select col" name="close_hrs">
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
                                    <select class="drop form-select col" class="form-select" name="close_mins">
                                        <option>00</option>
                                        <option>30</option>
                                    </select> 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" name="val" value="updatevehicledetail" />
                    <button onclick="return validate()" type="submit" value="Update" class="btn btn-primary">Update</button>
                </form>
            </div>
        </div>
            <script>
                
            function validate(){
                let f = true;
                let actualrate = $(".actualrate").val();
                let incrementrate = $(".incrementrate").val();
                if (actualrate == "" || actualrate == undefined) {
                    swal("oops", "Actual Rate is required", "warning");
                    f = false;
                }else if(incrementrate == "" || incrementrate == undefined) {
                    swal("oops", "Increment Rate is required !!", "warning");
                    f = false;
                }
                return f;
            }
            </script>
    </body>
</html>
