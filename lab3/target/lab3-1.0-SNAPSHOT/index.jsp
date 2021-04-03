<%@ page import="com.example.lab3.MyBean" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>

<%!
    MyBean myBean;
%>

<%
    Context context = null;
    try {
        context = new InitialContext();
        myBean = (MyBean) context.lookup("java:module/MyBean");
    }
    catch(Exception e) {
        e.printStackTrace();
    }
%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>It's lab3</title>

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
    <p1><%= "Hello World!" %> 3</p1>
</body>
</html>