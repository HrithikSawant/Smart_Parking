<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>AdminRegistraion Page</title>
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
                        <h2><b>Admin Registration Page</b></h2>
                    </div>
                    <%@ include file="components/message.jsp"%>
                    <!--Card Body-->
                    <div class="card-body ">
                        <form onsubmit="return validate()" novactionalidate="" action="AdminRegisterServlet" method="POST">
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

                            <!-- Aadhar Card And Pancard-->
                            <div class="form-group row py-2">
                                <div class="col-6">
                                    <label class="form-label">Aadhaar Card No</label>
                                    <input type="tel" class="aadhar form-control" name="aadhaarNo">
                                    <small class="aadhar-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <div class="col-6">
                                    <label class="form-label">Pancard No</label>
                                    <input type="tel" class="pan form-control" name="pancardNo">
                                    <small class="Pancard-field-msg form-text text-danger mx-2"></small>          
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
                                    <input type="password" class="password-name form-control" id="typepass" name="password">
                                    <span class="input-group-text p-3 bg-transparent border-0 border-bottom border-dark">
                                        <i class="bi bi-eye-slash-fill" id="icon" onclick="Toggle()"></i>
                                    </span>
                                    <small class="password-field-msg form-text text-danger mx-2"></small>
                                </div>
                                <div class="col-6">
                                    <label  class="form-label">Confirm Password</label>
                                    <input type="password" class="cpassword-name form-control" name="cpassword">
                                    <small class="cpassword-field-msg form-text text-danger mx-2"></small>
                                </div>

                            </div> 

                            <!--Submit Btn for Form-->
                            <div class="mt-3">
                                <button type="submit" name="value" value="Regitration" class="btn btn-primary px-5 rounded-pill" >
                                    Register
                                </button>
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



                //aadharcard validation
                let aadhar = $(".aadhar").val();
                let adharcardTwelveDigit = /^\d{12}$/;
                let adharSixteenDigit = /^\d{16}$/;
                if (aadhar == "" || aadhar == undefined) {
                    $(".aadhar-field-msg")
                            .html("aadhar is required !!")
                            .addClass("text-danger");
                    f = false;
                } else {
                    if (aadhar.match(adharcardTwelveDigit)) {
                        var valid = validateaadhar(aadhar);
                        if (valid) {
                            $(".aadhar-field-msg").html("validated !!")
                                    .removeClass("text-danger")
                                    .addClass("text-success");
                        } else {
                            $(".aadhar-field-msg")
                                    .html("Aadhar Number is not valid")
                                    .addClass("text-danger");
                            f = false;
                        }
                    } else {
                        $(".aadhar-field-msg")
                                .html("Enter valid Aadhar Number")
                                .addClass("text-danger");
                        f = false;
                    }
                }




                //pancard validation
                var regex = /[A-Z]{5}[0-9]{4}[A-Z]{1}$/;
                let pancard = $(".pan").val();
                if (pancard == "" || pancard == undefined) {
                    $(".Pancard-field-msg")
                            .html("Pancard is required !!")
                            .addClass("text-danger");
                    f = false;
                } else {
                    if (pancard.match(regex)) {
                        $(".Pancard-field-msg").html("validated !!")
                                .removeClass("text-danger")
                                .addClass("text-success");
                    } else {
                        $(".Pancard-field-msg")
                                .html("Pancard is not valid")
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



    ///*
    // For more info on the algorithm: http://en.wikipedia.org/wiki/Verhoeff_algorithm
    // by Sergey Petushkov, 2014
    // */

    // multiplication table d
            var d = [
                [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
                [1, 2, 3, 4, 0, 6, 7, 8, 9, 5],
                [2, 3, 4, 0, 1, 7, 8, 9, 5, 6],
                [3, 4, 0, 1, 2, 8, 9, 5, 6, 7],
                [4, 0, 1, 2, 3, 9, 5, 6, 7, 8],
                [5, 9, 8, 7, 6, 0, 4, 3, 2, 1],
                [6, 5, 9, 8, 7, 1, 0, 4, 3, 2],
                [7, 6, 5, 9, 8, 2, 1, 0, 4, 3],
                [8, 7, 6, 5, 9, 3, 2, 1, 0, 4],
                [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
            ];
    // permutation table p
            var p = [
                [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
                [1, 5, 7, 6, 2, 8, 3, 0, 9, 4],
                [5, 8, 0, 3, 7, 9, 6, 1, 4, 2],
                [8, 9, 1, 6, 0, 4, 3, 5, 2, 7],
                [9, 4, 5, 3, 1, 2, 6, 8, 7, 0],
                [4, 2, 8, 6, 5, 7, 3, 9, 0, 1],
                [2, 7, 9, 3, 8, 0, 6, 4, 1, 5],
                [7, 0, 4, 6, 9, 1, 3, 2, 5, 8]
            ];
    // inverse table inv
            var inv = [0, 4, 3, 2, 1, 5, 6, 7, 8, 9];
    // converts string or number to an array and inverts it
            function invArray(array) {

                if (Object.prototype.toString.call(array) == "[object Number]") {
                    array = String(array);
                }

                if (Object.prototype.toString.call(array) == "[object String]") {
                    array = array.split("").map(Number);
                }

                return array.reverse();
            }

    // generates checksum
            function generate(array) {

                var c = 0;
                var invertedArray = invArray(array);
                for (var i = 0; i < invertedArray.length; i++) {
                    c = d[c][p[((i + 1) % 8)][invertedArray[i]]];
                }

                return inv[c];
            }

    // validates checksum
            function validateaadhar(array) {

                var c = 0;
                var invertedArray = invArray(array);
                for (var i = 0; i < invertedArray.length; i++) {
                    c = d[c][p[(i % 8)][invertedArray[i]]];
                }

                return (c === 0);
            }
        </script>
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    </body>

</html>
