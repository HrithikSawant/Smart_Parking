<%@page errorPage="error_page.jsp" %>
<%@page import="java.util.Enumeration"%>
<%  response.setHeader("cache-Control", "no-cache,no-store,must-revalidate");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="components/bootstrap.jsp"%>
        <style> 
            main{
                margin-top: 56px;
            }
        </style>
    </head>
    <body>
        <%@ include file="components/header.jsp"%>
        <main>
            <%@ include file="components/carousel.jsp"%>
        </main>
        <!--our services start-->
        <section class="main_heading">
            <div class="text-center">
                <h1 class="display-4">Our Services</h1>
                <hr class="w-25 mx-auto" />
            </div>

            <div class="container mt-5">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-12 col-xxl-6">
                        <figure>
                            <img src="Stylesheets/images/background.png" alt="img"
                                 class="img-fluid">
                        </figure>
                    </div>
                    <div class="col-lg-6 col-md-6 col-12 col-xxl-6
                         justify-content-center align-items-start flex-column">
                        <h1> My Journey</h1>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                            Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                            when an unknown printer took a galley of type and scrambled it to make a type specimen book.
                            It has survived not only five centuries, but also the leap into electronic typesetting,
                            remaining essentially unchanged.
                            It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
                            and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <button type="button" class="btn btn-outline-info">
                            Check More
                        </button>
                    </div>
                </div>
            </div>
        </section>
        <!--our services end-->


        <!--about us sec start-->
        <section class="main_heading my-5">
            <div class="text-center">
                <h1 class="display-4">About Us</h1>
                <hr class="w-25 mx-auto" />
                <%@ include file="about.jsp"%>
            </div>
        </section>
        <!--about us sec end-->
        <!--
                Feature sec start
                <section class="main_heading mt-5">
                    <div class="text-center">
                        <h1 class="display-4">Feature</h1>
                        <hr class="w-25 mx-auto" />
                    </div>
                </section>
                about us sec end-->
        <%    Integer hitsCount = (Integer) application.getAttribute("hitCounter");
            if (hitsCount == null || hitsCount == 0) {
                hitsCount = 1;
            } else {
                hitsCount += 1;
            }
            application.setAttribute("hitCounter", hitsCount);
        %>

        <%@ include file="components/footer.jsp"%>
    </body>
</html>
