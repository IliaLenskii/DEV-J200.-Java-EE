<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lab is 1st</title>
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
                display: block;
            }
            input, button {
                padding: 4px;
                width: 100%;
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
    String val = request.getParameter("value");
    boolean isInt = false;
    String message = "";

    if(isPost)
        message = "Please try to again type your message";

    if(val != null) {

        for(char c : val.toCharArray()) {

            isInt = Character.isDigit(c);

            if(!isInt)
                break;
        }

        if(isInt) {

            message = (val +"00000");
        } else {

            String[] splited = val.split("\\s+");

            message = val +" ("+ splited.length +")";
        }
    }
%>

            <div class="message-block">
                <%= message %>
            </div>

            <form class="form-select-button" action="" method="post">
                <input type="text" name="value" maxlength="50" placeholder="Please enter the value...">
                <br /><br />
                <button type="submit">Send</button>
            </form>
        </div>
    </body>
</html>