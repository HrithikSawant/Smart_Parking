

function Toggle() {
    var temp = document.getElementById("typepass");
    icon = document.getElementById('icon');
    if (temp.type === "password") {
        temp.type = "text";
        icon.className = 'bi bi-eye-fill';
    } else {
        temp.type = "password";
        icon.className = 'bi bi-eye-slash-fill';
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




