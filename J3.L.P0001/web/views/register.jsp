<%-- 
    Document   : register
    Created on : 23-05-2021, 17:38:29
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Register Page</title>
        <link rel="stylesheet" href="<c:url value="views/css/style.css"></c:url>">
        </head>
        <body>
            <div class="container">
            <%@include file="components/header.jsp" %>
            <div class="row">
                <c:if test="${not empty message}">
                    <b class="${alert}">${message}</b>
                </c:if>
                <form action="#" method="post">
                    <table>
                        <thead>
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <h3 class="title mt-2 mb-2">Registration Form</h3>
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
                                <td>User Type: </td>
                                <td><select name="roleid">
                                        <option value="1" selected>Teacher</option>
                                        <option value="2">Student</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Email: </td>
                                <td><input class="input_" type="email" name="email" id="email" required=""></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input class="input_" type="submit" name="submit" id="submit" value="Register">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>    
    </body>
</html>
