<%@page import="com.mycompany.smartparkingmanagement.entities.Email"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row align-items-center" style="height: 100vh;" >
                <div class="card mx-auto shadow-lg" style="width:26rem;">
                    <div class="card-header">
                        <h2 class="text-center">Verify</h2><hr>
                    </div>
                    <%@ include file="components/message.jsp"%>
                    <div class="card-body">
                        <form action="ForgotPassword" method="POST" id="done">
                            <div class="mb-3" >                            
                                <label class="form-label">Email Id</label>
                                <input type="email" id="email_id"  name="email" class="form-control" disabled>
                                <label class="form-label">Enter Your OTP</label>
                                <input type="tel" name="OTP" class="form-control" pattern=".{3,6}" title="Length should be 3 or more">
                            </div>
                            <button onclick="getDetails()" name="value" value="check" class="btn btn-primary">Submit</button>
                        </form> 
                        <form action="ForgotPassword" method="POST" id="confirm" style="display:none;">
                            <div class="mb-3">
                                <label class="form-label">Username</label>
                                <input type="text" id="username" name="username" class="form-control" disabled>
                                <label class="form-label">Password</label>
                                <input type="password" name="pass" class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}" 
                                       title="It must contain atleast 1 Uppercase char, Lowercase char, 1 digit and lenght must 6 to 20 !!">
                                <label class="form-label">Confirm Password</label>
                                <input type="password" name="cpass" class="form-control"pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}" 
                                       title="It must contain atleast 1 Uppercase char, Lowercase char, 1 digit and lenght must 6 to 20 !!">
                            </div>
                            <button  name="value" value="reset_password" type="submit" class="btn btn-primary">Submit</button>"
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
