<%-- 
    Document   : Right
    Created on : 11-05-2021, 17:18:12
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="view/css/right.css"></c:url>">

        </head>
        <body>
            <div class="right">
                <div class="right_digital">
                    <div class="title">
                        Digital News
                    </div>
                    <div class="text">
                    ${topOne.description}
                </div>
            </div>
            <div class="right_search">
                <div class="title">
                    Search
                </div>
                <form action="Search" method="get">
                    <input type="text" name="txtSearch" value="">
                    <input type="submit" name="Submit" value="Go">
                </form>
            </div>
            <div class="right_articles">
                <div class="title">
                    Last Articles
                </div>
                <div class="articles_link">
                    <c:if test="${not empty topFive}">
                        <c:forEach items="${topFive}" var="i">
                            <a href="Detail?id=${i.id}">${i.title}</a>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
