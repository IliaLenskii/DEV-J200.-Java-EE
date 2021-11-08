<%@ page session="true" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="com.example.lab3.EJBDemo" %>

<%!
    EJBDemo myBean;
    String SESSION_KEY = "sdfdg34577ff";
%>

<%

    Context context = null;

    Context context2 = null;
    EJBDemo myBeanSession = (EJBDemo) request.getSession().getAttribute(SESSION_KEY);

    if(myBeanSession == null) {

        try {
            context2 = new InitialContext();

            myBeanSession = (EJBDemo) context2.lookup("java:module/Lab3");
        } catch(Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute(SESSION_KEY, myBeanSession);
    }

    try {
        context = new InitialContext();

        myBean = (EJBDemo) context.lookup("java:module/Lab3");
    } catch(Exception e) {
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
        <%
            boolean isPost = "POST".equals(request.getMethod());

            String message = "";

            String v1 = null;
            String v2 = null;

            if(isPost) {

                v1 = request.getParameter("login");
                v2 = request.getParameter("pass");

                myBean.login(v1, v2);
            }
        %>

        <div class="message-block">
            <%= message %>
        </div>

        <div class="user-status">
            <%= myBean.getMessage( v1 ) %>
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