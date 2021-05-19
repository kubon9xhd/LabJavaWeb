<%-- 
    Document   : Search
    Created on : 11-05-2021, 17:16:19
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
        <link rel="stylesheet" href="<c:url value="view/css/search.css"></c:url>">

            <title>Search Page</title>
        </head>
        <body>
            <div class="container">
            <%@include file="components/Header.jsp" %>
            <div class="main">
                <div class="left">
                    <c:forEach items="${list}" var="i">
                        <div class="title">
                            <a href="Detail?id=${i.id}">      
                                ${i.title}
                            </a>
                            <div class="image-search">
                                <img src="<c:url value="view/images/${i.image}"></c:url>" alt=""/>
                                </div>
                                <div class="text-search">
                                ${i.description}
                            </div>
                            <br>
                        </div>
                    </c:forEach>
                    <div class="paging">
                        <c:if test="${totalPage < 1 or not empty errorPage}">
                            <h3>NOT FOUND !!</h3>
                        </c:if>
                        <c:if test="${totalPage > 1 and empty errorPage}">
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <a  href="Search?index=${i}&txtSearch=${txtSearch}">${i}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <%@include  file="components/Right.jsp" %>
            </div>
                <%@include  file="components/Footer.jsp" %>
        </div></body>
</html>
