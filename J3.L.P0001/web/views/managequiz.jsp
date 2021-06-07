<%-- 
    Document   : managequiz
    Created on : 24-05-2021, 23:02:50
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Management Page</title>
        <link rel="stylesheet" href="<c:url value="views/css/style.css"></c:url>">
        </head>
        <body>
            <div class="container">
            <%@include file="components/header.jsp" %>
            <div class="row">
                <h3 class="title mt-1 mb-1"><p>Number of questions: </p> ${totalItems}</h3>
                <table>
                    <thead>
                    <th style="text-align: left; color: blue;">Question</th>
                    <th style="text-align: left; color: blue;">DateCreated</th>
                    </thead>
                    <tbody>
                        <c:if test="${not empty listQuestion}">
                            <c:forEach items="${listQuestion}" var="question">
                                <tr>
                                    <td style="width: 450px;padding-right: 50px;">${question.question}</td>
                                    <td>${question.getDateConvertToString()}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
                <center> 
                    <c:forEach begin="1" end="${totalPage}" var="i">
                        <div class="paging">

                            <a  href="managequiz?index=${i}">${i}</a>
                        </div>

                    </c:forEach>
                </center>
            </div>
        </div>
    </body>
</html>
