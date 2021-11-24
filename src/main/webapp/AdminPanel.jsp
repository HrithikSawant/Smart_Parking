<%@page import="com.mycompany.smartparkingmanagement.entities.Message"%>
<%@page import="com.mycompany.smartparkingmanagement.entities.LoginBean"%>
<%@page errorPage="error_page.jsp" %>
<% response.setHeader("cache-Control", "no-cache,no-store,must-revalidate");
    HttpSession s = request.getSession();
    LoginBean lg = (LoginBean) session.getAttribute("CurrentUser");
    if (lg == null) {
        Message msg = new Message("Please Login First!!", "error", "alert-danger");
        s.setAttribute("message", msg);
        response.sendRedirect("Login.jsp");
        return;
    } else if (lg.getRole().equals("Staff")) {
        Message msg = new Message("You are not admin!! do not access this page", "error", "alert-danger");
        s.setAttribute("message", msg);
        response.sendRedirect("Login.jsp");
    } else {
%>
<%@page import="com.mycompany.smartparkingmanagement.entities.Admin"%>
<%
    Admin ad = (Admin) session.getAttribute("AdminUser");
%>

<%@page errorPage="error_page.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Parking Management</title>
        <%@ include file="components/bootstrap.jsp"%>
        <link href="Stylesheets/admin.css" rel="stylesheet" type="text/css"/>
        <style>
            .back{
                background-color: black;
            }
            iframe { height: 91%; }
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
        <%@ include file="components/header.jsp"%>
        <div class="offcanvas offcanvas-start back text-white  sidebar-nav" tabindex="-1" id="offcanvasExample"
             aria-labelledby="offcanvasExampleLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
            </div>
            <div class="offcanvas-body p-0">
                <nav class="navbar-dark">
                    <ul class="navbar-nav">
                        <li>
                            <div class="text-muted small fw-bold text-uppercase px-3">
                                CORE
                            </div>
                        </li>
                        <li>
                            <a href="#" id="statistic" class="nav-link px-3 active">
                                <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                <span>DASHBOARD</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" id="profile" class="nav-link px-3">
                                <span class="me-2">
                                    <i class="bi bi-layout-split"></i>
                                </span>
                                <span>Profile</span>
                            </a>
                        </li>
                        <li>
                            <a href="https://dashboard.razorpay.com/app/dashboard"  class="nav-link px-3">
                                <span class="me-2">
                                    <i class="bi bi-layout-split"></i>
                                </span>
                                <span>Payment Reports</span>
                            </a>
                        </li>

                        <li class="my-4">
                            <hr class="dropdown-divider">
                        </li>
                        <li>
                            <div class="text-muted small fw-bold text-uppercase px-3">
                                Interface
                            </div>
                        </li>
                        <!--Rates-->
                        <li>
                            <a class="nav-link px-3 sidebar-link" id="rate-link" role="button">
                                <span class="me-2"><i class="bi bi-layout-split"></i></i></span>
                                <span>Rate</span>
                            </a>
                        </li>
                        <!--Manage User-->
                        <li>
                            <a class="nav-link px-3 sidebar-link" id="manage_user-link" role="button">
                                <span class="me-2"><i class="bi bi-layout-split"></i></i></span>
                                <span>Manage User</span>
                            </a>
                        </li>
                        <!--Slot-->
                        <li>
                            <a class="nav-link px-3 sidebar-link" id="slot-link" role="button">
                                <span class="me-2"><i class="bi bi-layout-split"></i></i></span>
                                <span>Parking Slot</span>
                            </a>
                        </li>
                        <!--Booking-->
                        <li>
                            <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#collapseExample1"
                               role="button" aria-expanded="false" aria-controls="collapseExample1">
                                <span class="me-2"><i class="bi bi-layout-split"></i></i></span>
                                <span>Booking</span>
                                <span class="right-icon ms-auto">
                                    <i class="bi bi-chevron-down"></i>
                                </span>
                            </a>
                            <div class="collapse" id="collapseExample1">
                                <div>
                                    <ul class="navbar-nax ps-3">
                                        <a href="#" id="offbook-link" class="nav-link px-3">
                                            <span class="me-2">
                                                <i class="bi bi-layout-split"></i>
                                            </span>
                                            <span>Offline Booking</span>
                                        </a>
                                        <a href="#" id="managebook-link" class="nav-link px-3">
                                            <span class="me-2">
                                                <i class="bi bi-layout-split"></i>
                                            </span>
                                            <span>Manage Booking</span>
                                        </a>
                                        <a href="#" id="viewbook-link" class="nav-link px-3">
                                            <span class="me-2">
                                                <i class="bi bi-layout-split"></i>
                                            </span>
                                            <span>View Booking</span>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <!--Reports-->
                    </ul>
                </nav>
            </div>
        </div>

        <!--Data-->
        <!--Chart.js-->
        <iframe src="DashBoard.jsp" id="dashboard-form" width="82%"
                style="border:none;height: 41rem; margin-left:17rem;margin-top: 7rem;">
            hello
        </iframe>
        <!--        <div class="frame">
            <iframe class="responsive-iframe" src="DashBoard.jsp" id="dashboard-form"></iframe>
        </div>-->
        <script>
            $(document).ready(function () {
                $('#statistic').click(function () {
                    $('#dashboard-form').attr('src', 'DashBoard.jsp');
                    $('#dashboard-form').show();
                });
                $('#profile').click(function () {
                    $('#dashboard-form').attr('src', 'Profile.jsp');
                    $('#dashboard-form').show();
                });
                $('#rate-link').click(function () {
                    $('#dashboard-form').attr('src', 'Rate.jsp');
                    $('#dashboard-form').show();
                });
                $('#manage_user-link').click(function () {
                    $('#dashboard-form').attr('src', 'Manage_User.jsp');
                    $('#dashboard-form').show();
                });
                $('#slot-link').click(function () {
                    $('#dashboard-form').attr('src', 'Slot.jsp');
                    $('#dashboard-form').show();
                });
                $('#book-link').click(function () {
                    $('#dashboard-form').attr('src', 'booking.jsp');
                    $('#dashboard-form').show();
                });
                $('#offbook-link').click(function () {
                    $('#dashboard-form').attr('src', 'OfflineBooking.jsp');
                    $('#dashboard-form').show();
                });
                $('#managebook-link').click(function () {
                    $('#dashboard-form').attr('src', 'ManageBookingDetails.jsp');
                    $('#dashboard-form').show();
                });
                $('#viewbook-link').click(function () {
                    $('#dashboard-form').attr('src', 'ViewBookingDetails.jsp');
                    $('#dashboard-form').show();
                });


//                let editPic = false;
//                $('#update-profileBtn').click(function () {
//                    if (editPic == false) {
//                        $('#saveProfile').show();
//                        editPic = true;
//                        $(this).text('Back');
//                        $('#input-pic').show();
//                    } else {
//                        $('#saveProfile').hide();
//                        $('#input-pic').hide();
//                        editPic = false;
//                        $(this).text('Update Profile Pic');
//                    }
//                });
//
//                let editStatus = false;
//                $('#edit-profile-btn').click(function () {
//                    if (editStatus == false) {
//                        $('#profile-details').hide();
//                        $('#profile-edit').show();
//                        editStatus = true;
//                        $(this).text('Back');
//                        $('#save').show();
//                    } else {
//                        $('#profile-details').show();
//                        $('#profile-edit').hide();
//                        $('#save').hide();
//                        editStatus = false;
//                        $(this).text('Edit');
//                    }
//                });
            });
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js" integrity="sha512-Wt1bJGtlnMtGP0dqNFH1xlkLBNpEodaiQ8ZN5JLA5wpc1sUlk/O5uuOMNgvzddzkpvZ9GLyYNa8w2s7rqiTk5Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </body>

</html>
<%    }
%>
