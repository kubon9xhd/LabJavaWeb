<%-- 
    Document   : index
    Created on : 25-05-2021, 22:33:24
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đối tượng string</title>
        <style>
            .container {
                width: 500px;
                margin: 0 auto;
            }

            input {
                width: 50px;
            }

            input:first-of-type {
                width: 150px;
            }

            .cl-blue {
                background-color: cadetblue;
            }

            .bd-bt {
                width: 100%;
                border: 1px solid #353232;
                margin: 20px 0px;
            }

            .submit {
                margin-left: 100px;
                margin-top: 10px;
            }

            .submit input {
                width: 70px;
                margin-left: 5px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <center>
                <h1>Đối tượng string</h1>
            </center>
            <form action="ObjectString" method="get">
                <p>Nhập đoạn văn:</p>
                <textarea style="overflow-y:scroll; 
                          width: 430px;
                          height: 126px; 
                          margin-left: 50px; 
                          margin-bottom: 20px" 
                          name="text"  cols="40" rows="7">${text}</textarea>
                <b>Tổng số ký tự: </b><input class="cl-blue" type="text" name="totalString" value="${total}" disabled=""> 
                <div class="bd-bt"></div>
                <b>Nhập vị trí </b><input type="text" name="index" value="${index}">
                <b>Ký tự tương ứng </b><input class="cl-blue" type="text" name="characterIndex" value="${charIndex}" disabled="">
                <div class="bd-bt"></div>

                <b>Nhập chuỗi </b><input type="text" name="string" value="${string}">
                <b>vị trí tương đương </b><input class="cl-blue" type="text" name="stringIndex" value="${strIndex}" disabled="">
                <div class="bd-bt"></div>

                <b>Nhập vị trí cần tách Từ </b><input type="text" name="indexFrom" value="${indexFr}">
                <b>Đến </b><input type="text" name="indexTo" value="${indexTo}">
                <b>Kết quả </b><input class="cl-blue" type="text" name="result" value="${result}" disabled="">
                <div class="submit">
                    <input type="submit" name="submit" value="Nhập">
                    <input type="reset" value="Nhập lại"><input type="reset" onclick="close()" value="Thoát">
                </div>
            </form>
        </div
    </body>
</html>
