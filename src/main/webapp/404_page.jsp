<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404 Error</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            .content {
                position: absolute;
                top: 40%;
                left: 50%;
                transform: translate(-50%, -50%);
            }

            .bg {
                background-image: url(Stylesheets/images/404.png);
                background-size: cover;
                height: 20rem;
                width: 20rem;
            }
            a {text-decoration: none;}
        </style>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <div class="bg"></div>
                <br>
                <h3 class="ms-2">It looks like you are lost...</h3><br>
                <div class="ms-5">
                    <button class="badge rounded-pill bg-info text-dark ms-5 py-2 px-4">
                        <a href="index.jsp"  class="link text-white">Go Back Home</a>
                    </button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
