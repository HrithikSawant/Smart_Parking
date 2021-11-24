<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row align-items-center" style="height: 100vh;" >
                <div class="card mx-auto shadow-lg" style="width:26rem;">
                    <div class="card-header">
                        <h2 class="text-center">FORGOT PASSWORD?</h2><hr>
                    </div>
                    <%@ include file="components/message.jsp"%>
                    <div class="card-body">
                        <form action="ForgotPassword" method="POST" id="forgot">
                            <div class="mb-3" >
                                <label class="form-label">Username</label>
                                <input type="text" name="username" class="form-control" pattern=".{5,16}" title="Four or more characters">
                                <div class="form-text"></div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email Id</label>
                                <input type="email" name="email" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-primary" name="value" value="forgot">Submit</button>
                        </form>                       
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
