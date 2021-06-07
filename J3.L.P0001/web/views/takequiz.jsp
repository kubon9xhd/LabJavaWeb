<%-- 
    Document   : takequiz.jsp
    Created on : 24-05-2021, 22:56:31
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Take Quiz</title>
        <link rel="stylesheet" href="<c:url value="views/css/style.css"></c:url>">
        </head>
        <body>
            <div class="container">
            <%@include file="components/header.jsp" %>
            <div class="row">
                <c:if test="${not empty message}">
                    <b class="${alert}">${message}</b>
                </c:if>
                <c:if test="${empty QUIZMODEL and empty SCORE}">
                    <h3 class="title mt-1 mb-1"><p>Welcome</p> ${USERMODEL.username}</h3>
                    <%@include  file="components/selectquiz.jsp" %>
                </c:if>
                <c:if test="${not empty QUIZMODEL}">
                    <h3 class="title mt-1 mb-1"><p>Welcome</p> ${USERMODEL.username}</h3>
                    <%@include  file="components/startquiz.jsp" %>
                </c:if>
                <c:if test="${not empty SCORE}">
                    <h3 class="title mt-1 mb-1"><p>Your Score</p> ${SCORE} (${SCORE*10}%) - <c:if test="${SCORE < 5}">Not Pass</c:if><c:if test="${SCORE >= 5}">Passed</c:if></h3>
                    <%@include  file="components/resultquiz.jsp" %>
                </c:if>
            </div>
        </div>    </body>
</html>
