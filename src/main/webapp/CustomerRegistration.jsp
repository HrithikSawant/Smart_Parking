<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style>
            .content {
                position: absolute;
                top: 40%;
                left: 50%;
                transform: translate(-50%, -30%);
                z-index: 2;
                font-family: Georgia, 'Times New Roman', Times, serif;
            }
            button {
                width: 10rem;
            }
        </style>

    </head>

    <body>
        <!--Card Content-->
        <div class="content">
            <div class="container">
                <div class="card bg-transparent shadow-lg p-3 bg-body" style="width:45rem; ">
                    <!--Card Header-->
                    <div class="card-header text-center">
                        <h2><b>Registration Page</b></h2>
                    </div>
                    <%@ include file="components/message.jsp"%>
                    <!--Card Body-->
                    <div class="card-body ">
                        <!--onsubmit="return validate()"-->
                        <form  novalidate="" action="CustomerRegisterServlet" method="POST">
                            <!--UserName Field-->
                            <div class="form-group row py-2">
                                <div class="col-4">
                                    <label class="form-label">First Name</label>
                                    <input type="text" class="first-name form-control" name="firstName">
                                    <small class="firstn-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <div class="col-4">
                                    <label class="form-label">Middle Name</label>
                                    <input type="text" class="form-control middle-name" name="middleName">
                                    <small class="middlen-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <div class="col-4">
                                    <label class="form-label">Last Name</label>
                                    <input type="text" class="last-name form-control ln-field" name="lastName">
                                    <small class="lastn-field-msg form-text text-danger mx-2"></small>
                                </div>
                            </div>
                            <!--BirthDate //-->  
                            <div class="form-group row py-2">
                                <div class="col-4">
                                    <label class="form-label">Date of Birth</label>
                                    <input type="date" class="form-control date-field" id="dob" name="dob">
                                    <small class="date-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <!--Gender //-->
                                <div class="col-6">
                                    <label class="form-label mx-2 ">Gender</label>
                                    <div class="row  mt-2 mx-2">
                                        <div class="form-check form-check-inline col">
                                            <input class="form-check-input" type="radio" name="gender" value="Male">
                                            <label class="form-check-label">Male</label>
                                        </div>
                                        <div class="form-check form-check-inline col">
                                            <input class="form-check-input" type="radio" name="gender"  value="Female">
                                            <label class="form-check-label">Female</label>
                                        </div>
                                        <div class="form-check form-check-inline col">
                                            <input class="form-check-input" type="radio" name="gender" value="Other">
                                            <label class="form-check-label">Other</label>
                                        </div>
                                    </div>
                                    <small class="gender-field-msg form-text text-danger mx-2"></small>
                                </div>
                            </div>
                            <!--Email id //-->
                            <div class="form-group row py-2">
                                <div class="col-6">
                                    <label class="form-label">Email address</label>
                                    <input type="email" class="email-field form-control" name="emailId">
                                    <div  class="form-text">We'll never share your email with anyone else.</div>
                                    <small class="email-field-msg form-text text-danger mx-2"></small>
                                </div>

                                <div class="col-6">
                                    <label class="form-label">Alternate Email</label>
                                    <input type="email" class="form-control" name="alternate_emailId">
                                </div>
                            </div>
                            <!-- Contact No //-->
                            <div class="form-group row py-2">
                                <div class="col-6">
                                    <label class="form-label">Contact No</label>
                                    <input type="tel" class=" phone-field form-control" name="phoneNo">
                                    <small class="phone-field-msg form-text text-danger mx-2"></small>
                                </div>                         
                                <div class="col-6">
                                    <label class="form-label">Alternate No</label>
                                    <input type="tel" class="form-control" value="0" name="alternate_phoneNo">
                                </div>
                            </div>
                            <!--Country-->
                            <div class="form-group row py-2">
                                <div class="col-4">
                                    <label class="form-label">Country</label>
                                    <input type="text" class="country form-control" name="country">
                                    <small class="country-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <div class="col-4">
                                    <label class="form-label">State</label>
                                    <input type="text" class="state form-control" name="state">
                                    <small class="state-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <div class="col-4">
                                    <label class="form-label">City</label>
                                    <input type="text" class="city form-control" name="city">
                                    <small class="city-field-msg form-text text-danger mx-2"></small>
                                </div>
                            </div>

                            <!-- License-->
                            <div class="form-group row py-2">
                                <div class="col-6">
                                    <label class="form-label">License Number</label>
                                    <input type="text" class="license_no form-control" name="LicenseNo">
                                    <small class="license-field-msg form-text text-danger mx-2"></small>
                                </div> 

                            </div>
                            <div class="form-group row py-2">
                                <div class="col-6">
                                    <label for="exampleInputusername" class="form-label">Username</label>
                                    <input type="text" class="form-control"
                                           id="exampleInputusernamepstmt.setString(1, ad.getUsername());" name="username">
                                </div>
                            </div>
                            <div class="form-group row py-2">
                                <div class="col-6">
                                    <label class="form-label">Password</label>
                                    <input type="password" class="password-name form-control" name="password">
                                    <small class="password-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <div class="col-6">
                                    <label  class="form-label">Confirm Password</label>
                                    <input type="password" class="cpassword-name form-control" name="password">
                                    <small class="cpassword-field-msg form-text text-danger mx-2"></small>
                                </div>
                            </div> 
                            <!--Submit Btn for Form-->
                            <div class="mt-3">
                                <button type="submit" class="btn btn-primary px-5 rounded-pill" >
                                    Login
                                </button>
                            </div> 

                        </form>
                    </div>
                </div>
            </div>
            <script>
                var today = new Date();
                var min_year = today.getFullYear() - 100;
                var max_year = today.getFullYear() - 18;
                var today_month = String(today.getMonth() + 1).padStart(2, '0');
                var today_date = String(today.getDate()).padStart(2, '0');
                min_date = min_year + '-' + today_month + '-' + today_date;
                max_date = max_year + '-' + today_month + '-' + today_date;
                var dob = document.getElementById('dob');
                dob.setAttribute("min", min_date);
                dob.setAttribute("max", max_date);

                function validate() {
                    let f = true;

                    let name_regex = /^[a-zA-Z]{3,16}$/;
                    //first name
                    let f_name = $(".first-name").val();
                    if (f_name == "" || f_name == undefined) {
                        $(".firstn-field-msg")
                                .html("first is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        if (f_name.match(name_regex)) {
                            $(".firstn-field-msg").html("ok !!")
                                    .removeClass("text-danger")
                                    .addClass("text-success");
                        } else {
                            $(".firstn-field-msg")
                                    .html("Not a Valid first Name !!")
                                    .addClass("text-danger");
                            f = false;
                        }
                    }

                    //middle
                    let m_name = $(".middle-name").val();
                    if (m_name == "" || m_name == undefined) {
                        $(".middlen-field-msg")
                                .html("middle is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        if (m_name.match(name_regex)) {
                            $(".middlen-field-msg").html("ok !!")
                                    .removeClass("text-danger")
                                    .addClass("text-success");
                        } else {
                            $(".middlen-field-msg")
                                    .html("Not a Valid middle Name !!")
                                    .addClass("text-danger");
                            f = false;
                        }
                    }

                    //last_name validation
                    let ls_name = $(".last-name").val();
                    if (ls_name == "" || ls_name == undefined) {
                        $(".lastn-field-msg")
                                .html("last is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        if (m_name.match(name_regex)) {
                            $(".lastn-field-msg").html("ok !!")
                                    .removeClass("text-danger")
                                    .addClass("text-success");
                        } else {
                            $(".lastn-field-msg")
                                    .html("Not a Valid Last Name !!")
                                    .addClass("text-danger");
                            f = false;
                        }
                    }

                    //Gender
                    if ($('input[type=radio][name=gender]:checked').length == 0) {
                        $(".gender-field-msg")
                                .html("Gender is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        $(".gender-field-msg").html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");
                    }

                    // date of birth
                    let dob = $(".date-field").val();
                    if (dob == "") {
                        $(".date-field-msg")
                                .html("Date of birth is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        $(".date-field-msg").html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");

                    }
                    //email validation

                    let email = $(".email-field").val();
                    let exp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                    if (email == "" || email == undefined) {
                        $(".email-field-msg")
                                .html("Email is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else if (exp.test(email) == false) {
                        $(".email-field-msg")
                                .html("Invalid Email, Email must in correct format (example@gmail.com) !!")
                                .add("text-danger");
                        f = false;
                    } else {
                        $(".email-field-msg")
                                .html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");

                    }

                    //Contact No
                    //phone validation add digit only validation left
                    let phone = $(".phone-field").val();
                    if (phone == "" || undefined) {
                        $(".phone-field-msg")
                                .html("Phone number is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else if (phone.length == 10) {
                        //more validation
                        $(".phone-field-msg")
                                .html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");

                    } else {
                        $(".phone-field-msg")
                                .html("Phone number is invalid it must be of 10 digit !!")
                                .addClass("text-danger");
                        f = false;
                    }

                    //country validation
                    let country = $(".country").val();
                    if (country == "" || country == undefined) {
                        $(".country-field-msg")
                                .html("country is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        $(".country-field-msg").html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");
                    }

                    //state validation
                    let state = $(".state").val();
                    if (state == "" || state == undefined) {
                        $(".state-field-msg")
                                .html("state is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        $(".state-field-msg").html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");
                    }

                    //City validation
                    let city = $(".city").val();
                    if (city == "" || city == undefined) {
                        $(".city-field-msg")
                                .html("city is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        $(".city-field-msg").html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");

                    }

                    //license validation
                    let license = /^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$/;
                    let license_no = $("license_no").val();
                    if (license_no == "" || license_no == undefined) {
                        $(".license-field-msg")
                                .html("license no is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        if (license_no.match(license)) {
                            $(".license-field-msg").html("validated !!")
                                    .removeClass("text-danger")
                                    .addClass("text-success");
                        } else {
                            $(".license-field-msg")
                                    .html("license no is not valid")
                                    .addClass("text-danger");
                            f = false;
                        }
                    }

                    //password validation
                    let password = $(".password-name").val();
                    let exp1 = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
                    if (password == "" || password == undefined) {
                        $(".password-field-msg")
                                .html("Password is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else if (exp1.test(password) == false) {
                        $(".password-field-msg")
                                .html("Password is Invalid,<br> It must contain atleast 1 Uppercase char,<br> Lowercase char, 1 digit and <br>lenght must 6 to 20 !!")
                                .addClass("text-danger");
                        f = false
                    } else {
                        $(".password-field-msg")
                                .html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");
                    }   
                    let cpass = $(".cpassword-name").val();
                    if (cpass == "" || cpass == undefined) {
                        $(".cpassword-field-msg")
                                .html("Confirm Password is required !!")
                                .addClass("text-danger");
                        f = false;
                    } else if (cpass != password) {
                        $(".cpassword-field-msg")
                                .html("Password Not Matched !!")
                                .addClass("text-danger");
                        f = false;
                    } else {
                        $(".cpassword-field-msg")
                                .html("ok !!")
                                .removeClass("text-danger")
                                .addClass("text-success");
                    }

                    return f;
                }
            </script>      

            <!-- Option 1: Bootstrap Bundle with Popper -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    </body>

</html>

