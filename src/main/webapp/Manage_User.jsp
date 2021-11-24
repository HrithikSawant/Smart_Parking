<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.Customer"%>
<%@page errorPage="error_page.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Customer> cust = (ArrayList<Customer>) request.getAttribute("cust");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage User</title>
        <%@ include file="components/bootstrap.jsp"%>
    </head>
    <body>

        <main  class="d-flex justify-content-center mt-5">
            <section style="width: 60rem;">
                <%@ include file="components/message.jsp"%>
                <div class="card  shadow ">
                    <h5 class="card-header text-center ">Add User </h5>
                    <div class="card-body mx-2">
                        <form name="AddUser" action="AdminPanel" method="POST">
                            <h4 class="card-title"><b> Choose User role :</b></h4>
                            <div class="m-4 row">
                                <div class="col">
                                    <input class="form-check-input" type="radio" name="user" value="customer" checked="checked" />
                                    <label class="form-check-label ps-3">Customer</label>
                                </div>
                                <div class="col">
                                    <input class="form-check-input" type="radio" name="user" value="staff" />
                                    <label class="form-check-label ps-4">Staff</label>
                                </div>
                                <div class="col">
                                    <input class="form-check-input" type="radio" name="user" value="admin" />
                                    <label class="form-check-label ps-4">Admin</label>
                                </div>
                                <div class="mt-4 d-flex justify-content-end">   
                                    <input type="hidden" name="val" value="adduser" />
                                    <button type="submit" value="Add User" class="btn btn-primary px-5">Add User</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card text-center mt-5 shadow">
                    <h5 class="card-header">Block or UnBlock a User</h5>
                    <div class="card-body mx-2">
                        <form name="BlockUser" action="AdminPanel" method="POST"> 
                            <div class="m-4">
                                <div class="input-group ">
                                    <span class="input-group-text">Username</span>
                                    <input class="form-control"  type="text" name="username" value="" /> <br><br>
                                </div>
                                <div class="mt-4 mx-5 row">
                                    <div class="col">
                                        <input class="form-check-input" type="radio" name="block" value="unblock" checked="checked" />
                                        <label class="form-check-label ps-4">Unblock</label>
                                    </div>
                                    <div class="col">
                                        <input class="form-check-input" type="radio" name="block" value="block" />
                                        <label class="form-check-label ps-4">Block</label>
                                    </div>
                                </div>
                                <div class="mt-4 d-flex justify-content-end">   
                                    <input type="hidden" name="val" value="blockuser" />
                                    <button type="submit" value="Submit" class="btn btn-primary px-5">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="card  my-5 shadow">
                    <h5 class="card-header text-center ">Search Users Details </h5>
                    <div class="card-body mx-2">
                        <form name="AddUser" action="AdminPanel" method="POST">
                            <h4 class="card-title"><b> Please Choose user role : :</b></h4>
                            <div class="m-4 row">
                                <div class="col">
                                    <input class="form-check-input" type="radio" name="role" value="customer" checked="checked" />    
                                    <label class="form-check-label ps-3">Customer</label>
                                </div>
                                <div class="col">
                                    <input class="form-check-input" type="radio" name="role" value="staff" /> 
                                    <label class="form-check-label ps-4">Staff</label>
                                </div>
                                <div class="col">
                                    <input class="form-check-input" type="radio" name="role" value="admin" /> 
                                    <label class="form-check-label ps-4">Admin</label>
                                </div>
                                <div class="mt-4 d-flex justify-content-end">   
                                    <input type="hidden" name="val" value="searchuser" /><br>
                                    <button type="submit"  value="Search User" class="btn btn-primary px-5">Search</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </main>
        <%   if (cust != null) {
                if (cust.size() > 0) {
        %>

        <table class="table table-striped mt-5">
            <thead>
                <tr>
                    <th scope="col">Username</th>
                    <th scope="col">role</th>
                </tr>
            </thead>
            <tbody>
                <%  for (Customer c : cust) {%>
                <tr>
                    <td><%= c.getFirstName()%></td>
                    <td><%= c.getMiddleName()%></td>
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
