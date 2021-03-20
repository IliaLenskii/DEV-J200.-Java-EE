<%@ page import="java.util.*" %>
<%@ page import="com.example.lab1.UserUtils" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lab is 2nd</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-size: 14px;
                font-family: Georgia, 'Times New Roman', Times, serif;
            }
            html, body{
                background-color: #ededed;
                width: 100%;
                height: 100%;
            }
            .container {
                width: 400px;
                height: inherit;
                margin-left: auto;
                margin-right: auto;
            }
            .form-select-button {
                border: 1px solid #ccc;
                margin-bottom: 12px;
                display: block;
                padding: 4px;
                text-align: center;
            }
            input, button {
                display: inline-block;
                padding: 4px;
                width: 46%;
            }

            button[type="submit"] {
                width: 45%;
                color: green;
            }
            button[type="reset"] {
                width: 25%;
            }
            .message-block {
                margin-top: 40%;
                margin-bottom: 18px;
                text-align: center;
                font-size: 18px;
            }
        </style>
    </head>
    <body>
        <div class="container">
<%
    boolean isPost = "POST".equals(request.getMethod());
    //boolean isGet = "GET".equals(request.getMethod());
    String message = "";

    String v1 = request.getParameter("value1");
    String v2 = request.getParameter("value2");

    Double d1 = null;
    Double d2 = null;

    if(v1 != null && v2 != null) {

        if(UserUtils.isDigit(v1)) {
            d1 = Double.parseDouble(v1);
        }

        if(UserUtils.isDigit(v2)) {
            d2 = Double.parseDouble(v2);
        }
    }

    if(d1 != null && d2 != null) {

        if(isPost) {

            message = "Result: "+ (d1 * d2);
        } else {

            message = "Result: "+ (d1 + d2);
        }
    }
%>

            <div class="message-block">
                <%= message %>
            </div>

            <form class="form-select-button" action="index.jsp" method="get">
                <input type="text" name="value1" maxlength="50" placeholder="Enter the value...">
                <input type="text" name="value2" maxlength="50" placeholder="Enter the value...">
                <br /><br />
                <button type="submit">Сложить</button>
                <button type="reset">Очистить</button>
            </form>

            <form class="form-select-button" action="index.jsp" method="post">
                <input type="text" name="value1" maxlength="50" placeholder="Enter the value...">
                <input type="text" name="value2" maxlength="50" placeholder="Enter the value...">
                <br /><br />
                <button type="submit">Умножить</button>
                <button type="reset">Очистить</button>
            </form>
        </div>
    </body>
</html>