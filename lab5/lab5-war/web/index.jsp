<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page session="true" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="lab5.ejb.IndexBeanLocal" %>
<%@page import="lab5.ejb.IndexBean" %>

<%

IndexBeanLocal parseReq = new IndexBean(request, response);

%>

<!DOCTYPE html>
<html>
<head>
    <title>It's lab5</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-size: 14px;
            font-family: Georgia, "Times New Roman", Times, serif;
        }
        html, body {
            background-color: #ededed;
            width: 100%;
            height: 100%;
        }
        .container {
            width: 400px;
            height: inherit;
            margin-left: auto;
            margin-right: auto;
            padding-top: 15%;
        }
        .form-select-button {
            border: 1px solid #ccc;
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
        <form class="form-select-button" action="index.jsp" method="post">
            <input type="text" name="attr" maxlength="50" placeholder="Enter the value..." />
            <br />
            <br />
            <button type="submit">Send</button>
        </form>
        
        <br /><br />
        <div class="message-block">
            <div>
                Result is: <%= parseReq.getResult() %>
            </div>
        </div>
        
    </div>

</body>
</html>