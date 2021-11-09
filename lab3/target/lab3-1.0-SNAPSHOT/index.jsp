<%@ page session="true" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="com.example.lab3.EJBDemo" %>

<%!
    EJBDemo myBeanSession;
    String SESSION_KEY = "__LAB3__";
    boolean isPost = false;
    String message = "";
    String v1 = null;
    String v2 = null;
    Context context = null;
    HttpSession session = null;
%>

<%
    session = request.getSession(true);
    isPost = "POST".equals(request.getMethod());

    myBeanSession = (EJBDemo) session.getAttribute(SESSION_KEY);

    if(myBeanSession == null) {

        try {
            context = new InitialContext();

            myBeanSession = (EJBDemo) context.lookup("java:module/Lab3");
        } catch(Exception e) {
            e.printStackTrace();
        }

        session.setAttribute(SESSION_KEY, myBeanSession);
    }

    if(isPost) {

        v1 = request.getParameter("login");
        v2 = request.getParameter("pass");

        myBeanSession.login(v1, v2);

        response.setHeader("Refresh", "0;");
        return;
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
        input, button, textarea {
            display: inline-block;
            padding: 4px;
            width: 100%;
        }

        textarea {
            height: 50px;
            resize: none;
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
        .user-status {
            margin: 10px 0;
        }
    </style>
</head>
<body>

    <div class="container">

        <div class="message-block">
            <%= message %>
        </div>

        <div class="user-status">
            <%= myBeanSession.getMessage("") %>
        </div>

        <form class="form-select-button" action="index.jsp" method="post">
            <input type="text" name="login" maxlength="50" placeholder="Login is..." value="login">
            <br />
            <br />
            <input type="password" name="pass" maxlength="50" placeholder="Password is..." value="1">
            <br />
            <br />
            <button type="submit">Send</button>
        </form>
    </div>

</body>
</html>