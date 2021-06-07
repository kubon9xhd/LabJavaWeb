<%-- 
    Document   : home
    Created on : 23-05-2021, 17:27:23
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home Page</title>
        <link rel="stylesheet" href="<c:url value="views/css/style.css"></c:url>">
        </head>
        <body>
            <div class="container">
            <%@include file="components/header.jsp" %>
            <div class="row">
                <c:if test="${not empty message}">
                    <b class="${alert}">${message}</b>
                </c:if>
                <h3 class="title mt-1 mb-1">Login Form</h3>
                <form action="#" method="post">
                    <table>
                        <thead>
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>                
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>User Name: </td>
                                <td><input class="input_" type="text" name="username" id="username" required=""></td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td><input class="input_" type="password" name="password" id="password" required=""></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input class="input_" type="submit" name="submit" id="submit" value="Sign in">
                                    <a href="<c:url value="/register"></c:url>">Register</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
