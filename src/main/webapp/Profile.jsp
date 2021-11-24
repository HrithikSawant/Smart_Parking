<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%@page errorPage="error_page.jsp" %>
<%
    HttpSession s = request.getSession();
    LoginBean lg = (LoginBean) session.getAttribute("User");
    if (lg == null) {
        Message msg = new Message("Please Login First!!", "error", "alert-danger");
        s.setAttribute("message", msg);
        response.sendRedirect("Login.jsp");
        return;
    } else {
        
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <%@ include file="components/bootstrap.jsp"%>
        <style>
            .example {
                background-color: #eee;
                overflow-y: scroll; /* Add the ability to scroll */
            }

            /* Hide scrollbar for Chrome, Safari and Opera */
            .example::-webkit-scrollbar {
                display: none;
            }

            /* Hide scrollbar for IE, Edge and Firefox */
            .example {
                -ms-overflow-style: none;  /* IE and Edge */
                scrollbar-width: none;  /* Firefox */
            }
        </style>
    </head>
    <body class="example">
        
        <% if (lg.getRole().equals("Customer") ||lg.getRole().equals("Staff")) {%>
            <div style="margin: 5rem 0"> <%@ include file="components/header.jsp"%>  </div>
        <% }%>

        <section class="example container">
            <div class="card shadow bg-secoundary" style="width: 30rem; margin: auto;">
                <div class="card-header text-center">
                    <h3 class="font-weight-bold">Profile</h3>
                </div>
                <%@ include file="components/message.jsp"%>
                <div class="p-3  mt-3" style="width: 15rem;margin-left: 7rem;">
                    <img class="card-img-top rounded-circle " style=" height: 13rem" src="profile/<%= lg.getProfile()%>" alt="Profile picture">
                </div>

                <!--Profile Picture-->
                <div  class="me-3 mt-4 px-6" style="width: 20rem;margin-left: 5rem;">
                    <form action="UpdateProfile" method="post" enctype="multipart/form-data">
                        <input id="input-pic" type="file" name="profile" class="form-control mb-4" style="display:none;"  value="default.png" required>
                        <button  id="saveProfile" type="submit" class="btn btn-success"  style="margin-left: 4rem; display:none;">Save</button>
                        <button  id="update-profileBtn" type="button" class="btn btn-secondary" style="margin-left: 5rem;">Update Profile Pic</button>
                    </form>
                </div>

                <div class="card-body mt-5"> 
                    <!--Profile Details-->
                    <div id="profile-details">
                        <table class="table">
                            <tbody>
                                <tr>
                                    <th scope="row">UserID: </th>
                                    <td><%= lg.getUserName()%></td>
                                </tr>
                                <tr>
                                    <th scope="row">Email: </th>
                                    <td><%= lg.getEmailid()%></td>
                                </tr>
                                <tr>
                                    <th scope="row">Name:</th>
                                    <td><%= lg.getFirstName()%> </td>
                                </tr>
                                <tr>
                                    <th scope="row">Gender: </th>
                                    <td><%= lg.getGender()%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!--Profile Edit-->
                    <div id="profile-edit" style="display:none">
                        <h3 class="mt-2">Please Edit Carefully</h3>
                        <form action="EditServlet" method="post" >
                            <table class="table">
                                <tr>
                                    <th>UserID :</th>
                                    <td><%= lg.getUserName()%></td>
                                </tr>
                                <tr>
                                    <th>Email: </th>
                                    <td><input type="email" name="email" class="form-control" value="<%= lg.getEmailid()%>"></td>
                                </tr>
                                <tr>
                                    <th scope="row">Name:</th>
                                    <td><input type="text" name="name" class="form-control" value="<%= lg.getFirstName()%>"</td>
                                </tr>
                                <tr>
                                    <th>Password:</th>
                                    <td><input type="password" name="password" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <th>Confirm Password:</th>
                                    <td><input type="password" name="confirmpass" class="form-control" required></td>
                                </tr>
                                <tr>
                                    <th>Gender:</th>
                                    <td><%= lg.getGender()%></td>
                                </tr>

                            </table>
                            <button id="save" type="submit" class="btn btn-success me-3 px-4" style="display:none;">Save</button>
                        </form>
                    </div>
                    <div class="card-footer border text-end ">
                        <button id="edit-profile-btn" type="button" class="btn btn-secondary px-4">Edit</button>
                    </div>
                </div>
            </div>
        </section>
                                
        <% if (lg.getRole().equals("Customer") ||lg.getRole().equals("Staff")) {%>
        <div style="margin-top: 5rem"> <%@ include file="components/footer.jsp"%>  </div>
        <% }%>
        <script>
            $(document).ready(function () {
                let editPic = false;
                $('#update-profileBtn').click(function () {
                    if (editPic == false) {
                        $('#saveProfile').show();
                        editPic = true;
                        $(this).text('Back');
                        $('#input-pic').show();
                    } else {
                        $('#saveProfile').hide();
                        $('#input-pic').hide();
                        editPic = false;
                        $(this).text('Update Profile Pic');
                    }
                });
                let editStatus = false;
                $('#edit-profile-btn').click(function () {
                    if (editStatus == false) {
                        $('#profile-details').hide();
                        $('#profile-edit').show();
                        editStatus = true;
                        $(this).text('Back')
                        $('#save').show();
                    } else {
                        $('#profile-details').show();
                        $('#profile-edit').hide();
                        $('#save').hide();
                        editStatus = false;
                        $(this).text('Edit');
                    }

                })
            });
        </script>
    </body>
</html>
<%    }
%>