<%@page errorPage="error_page.jsp" %>
<%  response.setHeader("cache-Control", "no-cache,no-store,must-revalidate");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="Stylesheets/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>  
        <!--Card Content-->
        <div class="content">
            <div class="container">
                <div class="card bg-transparent shadow-lg p-3 bg-body" style="width:45rem; ">
                    <!--Card Header-->
                    <div class="card-header text-center">
                        <h2><b>LOGIN</b></h2>
                    </div>
                    <%@ include file="components/message.jsp"%>

                    <!--Card Body-->
                    <div class="card-body ">
                        <form action="LoginServlet" method="post"> 
                            <!--UserName Field-->
                            <div class="input-group mb-3">
                                <span class="input-group-text p-3 bg-transparent border-0 border-bottom border-dark">
                                    <i class="bi bi-person-fill"></i>
                                </span>
                                <input type="text"
                                       class="form-control shadow-none pt-1 bg-transparent border-0 border-bottom border-dark"
                                       placeholder="Username" name="username" pattern=".{5,16}" title="Four or more characters" >
                            </div>
                            <!--Password Field-->
                            <div class="input-group mb-3">
                                <span class="input-group-text p-3 bg-transparent border-0 border-bottom border-dark">
                                    <i class="bi bi-lock-fill"></i>
                                </span>
                                <input type="password"
                                       class="form-control shadow-none pt-1 bg-transparent border-0 border-bottom border-dark"
                                       placeholder="Password" name="password" id="typepass">
<!--                                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}" 
                                       title="It must contain atleast 1 Uppercase char, Lowercase char, 1 digit and lenght must 6 to 20 !!">-->
                                <span class="input-group-text p-3 bg-transparent border-0 border-bottom border-dark">
                                    <i class="bi bi-eye-slash-fill" id="icon" onclick="Toggle()"></i>
                                </span>
                            </div>
                            
                            <!--Links-->
                            <div class="d-flex justify-content-between mt-4">
                                <div>
                                    <a href="Forgot_Password.jsp" class="text-dark">Forgot Your Password?</a>
                                </div>
                                <div>
                                    <a href="CustomerRegistration.jsp" class="text-dark">Register Now</a>
                                </div>
                            </div>

                            <!--Submit Btn for Form-->
                            <div class="mt-3">
                                <button type="submit" class="btn btn-primary px-5 rounded-pill">Login</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

        <script>
            // Change the type of input to password or text
            function Toggle() {
                var temp = document.getElementById("typepass");
                icon = document.getElementById('icon');

                if (temp.type === "password") {
                    temp.type = "text";
                    icon.className = 'bi bi-eye-fill';
                } else {
                    temp.type = "password";
                    icon.className = 'bi bi-eye-slash-fill'
                }
            }
            

        </script>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        -->
    </body>
</html>
