<%-- 
    Document   : makequiz
    Created on : 24-05-2021, 23:02:16
    Author     : asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Make Quiz Page</title>
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
                                <td>Question: </td>
                                <td><textarea  name="question" cols="70" rows="6"></textarea></td>
                            </tr>
                            <tr>
                                <td>Option1: </td>
                                <td><textarea name="option1" cols="10" rows="3"></textarea></td>
                            </tr>
                            <tr>
                                <td>Option2: </td>
                                <td><textarea name="option2" cols="3" rows="3"></textarea></td>
                            </tr>
                            <tr>
                                <td>Option3: </td>
                                <td><textarea name="option3" cols="3" rows="3"></textarea></td>
                            </tr>
                            <tr>
                                <td>Option4: </td>
                                <td><textarea name="option4" cols="3" rows="3"></textarea></td>
                            </tr>
                            <tr>
                                <td>Answer(s): </td>
                                <td><input type="checkbox" name="answers" value="1">Option 1
                                    <input type="checkbox" name="answers" value="2">Option 2
                                    <input type="checkbox" name="answers" value="3">Option 3
                                    <input type="checkbox" name="answers" value="4">Option 4
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input class="input_" type="submit" name="submit" id="submit" value="Save">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>    </body>
</html>
