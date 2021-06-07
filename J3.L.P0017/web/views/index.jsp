<%-- 
    Document   : index
    Created on : 31-05-2021, 22:34:50
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
                            <img id="myImg" src="<c:url value="views/images/${contact.imageMain}"></c:url>" alt="homeImage">
                                <p class="subtitle2">
                                ${contact.contentMain}
                            </p>
                        </div>
                        <div class="category">
                            <c:forEach var="listModel" items="${list}">
                                <div class="category-gallery">
                                    <img class="mb-5" id="myImg" src="<c:url value="views/images/${listModel.url}"></c:url>" alt="">
                                    <h4 class="mb-10"><a href="gallery?id=${listModel.id}">${listModel.title}</a></h4>
                                    <p class="description">${listModel.description}</p>
                                </div>
                            </c:forEach>
                        </div>
                        <center>   
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <div class="paging">
                                    <a  href="home?index=${i}">${i}</a>
                                </div>
                            </c:forEach>
                        </center>
                        <div class="about">
                            <h4 class="subtitle3">About</h4>
                            <p class="description">
                                ${contact.about}
                            </p>
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
