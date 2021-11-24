<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry !! something went wrong...!!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <style>
            .content {
                position: absolute;
                top: 40%;
                left: 60%;
                transform: translate(-50%, -50%);
                font-family: Georgia, 'Times New Roman', Times, serif;
            }
            .content1 {
                background-image: url(Stylesheets/images/bot.png);
                background-size: cover;
                height: 200px;
                width: 200px;
                position: absolute;
                top: 40%;
                left: 30%;
                transform: translate(-50%, -50%);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="content1">
            </div>
            <div class="content">
                <h2 class="fw-bolder ">Something Went Wrong</h2>
                <small>We keep track of these errors, but feel free to contact us if<br>
                    refreshing doesn't fix things.</small>
                <p><%= exception%></p>
            </div>
        </div>
    </body>
</html>
