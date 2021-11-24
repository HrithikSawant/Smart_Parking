<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>
        <h1>Admin Panel!</h1>
        <%@ include file="components/message.jsp"%>
        <iframe src="DashBoard.jsp" id="dashboard-form" width="82%" style="border:none;height: 41rem; margin-left:auto;margin-top: 4px">
            hello
        </iframe>
        
        <form name="OnSpotBooking" action="OfflineBooking.jsp" method="POST">
            <input type="submit" value="Book Slot" />
            <%--<input type="hidden" name="val" value="bookslots" />--%>
        </form>
        <!--Data-->
        <main>
            <%-- Search stuffs --%>
            <form name="Buffer" action="adminPanel" method="POST">
                <h4>Search Buffer Slots</h4>
                <input type="radio" name="status" value="red" checked="checked" /> RED
                <input type="radio" name="status" value="green" /> GREEN
                <input type="hidden" name="val" value="buffer" /><br>
                <input type="submit" value="Search" />
            </form>
        </main>
        
        


    </body>
</html>
