<%-- 
    Document   : Error
    Created on : 11-05-2021, 17:16:30
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="view/css/style.css">

        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="components/Header.jsp"/>
            <div class="main">
                <div class="left">
                    <center>                    
                        <h1>ERROR</h1>
                    </center>
                </div>
                <jsp:include page="components/Right.jsp"/> 
            </div>
                <jsp:include page="components/Footer.jsp"/>
        </div>
    </body>
</html>
