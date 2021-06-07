<%-- 
    Document   : contact
    Created on : 31-05-2021, 22:35:58
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Photographer</title>
        <link rel="stylesheet" href="<c:url value="views/css/style.css"></c:url>">
        </head>
        <body>
            <div class="container">
            <%@include file="components/header.jsp" %>
            <div class="row">
                <div class="main">
                    <div class="left">
                        <div class="left-home">
                            <h4 class="subtitle2 mb-20">Contact</h4>
                            <h4 class="subtitle2 mb-20">PHOTOGRAPHER</h4>
                            <p class="info-text mb-5">Address: ${contact.address}</p>
                            <p class="info-text mb-5">City: ${contact.city}</p>
                            <p class="info-text mb-20">Country: ${contact.country}</p>
                            <p class="info-text mb-5">Tel: ${contact.telephone}</p>
                            <p class="info-text mb-5">Email: ${contact.email}</p>
                        </div>
                        <div class="category mt-50">
                            ${contact.map}
                        </div>
                    </div>
                    <%@include file="components/right.jsp" %>
                </div>
            </div>
            <%@include file="components/footer.jsp" %>
        </div>
        <script src="views/js/images.js">
        </script>
    </body>
</html>
