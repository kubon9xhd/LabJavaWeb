<%-- 
    Document   : Detail
    Created on : 12-05-2021, 23:46:15
    Author     : asus
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="view/css/style.css"></c:url>">
            <title>Detail Page</title>
        </head>
        <body>
            <div class="container">
            <%@include file="components/Header.jsp" %>
            <div class="main">
                <div class="left">
                    <div class="title">
                        ${model.title}
                    </div>
                    <div class="content">
                        <div class="image">
                            <img src="<c:url value="view/images/${model.image}"></c:url>" alt="image news">
                            </div>
                            <div class="text">
                            ${model.content}
                        </div>
                    </div>
                    <div class="border">
                    </div>
                    <div class="author">
                        <p>
                            <img src="<c:url value="view/images/comment.gif"></c:url>" alt="Icon comment">
                            <img src="<c:url value="view/images/timeicon.gif"></c:url>" alt="Icon time"> By ${model.createdBy} | ${model.dateConvert}
                            </p>
                        </div>
                    </div>
                            <%@include  file="components/Right.jsp" %>
            </div>
                            <%@include  file="components/Footer.jsp" %>
        </div>
    </body>
</html>
