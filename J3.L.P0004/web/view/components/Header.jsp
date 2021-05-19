<%-- 
    Document   : Header
    Created on : 11-05-2021, 17:15:55
    Author     : asus
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="view/css/header.css"></c:url>">
        </head>
        <body>
            <div class="header">
                <div class="header_top">
                </div>
                <div class="header_bottom">
                    <h3>My Digital News</h3>
                </div>
                <div class="menu">
                    <a href="<c:url value="/Home"></c:url>">News</a>
            </div>
        </div>
    </body>
</html>
