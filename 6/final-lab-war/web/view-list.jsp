<%@page session="true" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="jsp.ViewList" %>

<%
    ViewList vl = new ViewList(request);
%>

<!DOCTYPE html>
<html>
<head>
    <title>It's final lab <%= request.getContextPath() %></title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-size: 14px;
            font-family: Georgia, "Times New Roman", Times, serif;
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
            margin-top: 40%;
            border: 1px solid #ccc;
            margin-bottom: 12px;
            display: block;
            padding: 8px;
            text-align: center;
        }
        .form-select-button > * {
            
            margin-bottom: 14px;
        }  .form-select-button > *:last-child {
            
            margin-bottom: 0;
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
    </style>
</head>
<body>

    <div class="container">
        <a href="/final-lab-war/">to Home</a>

        <br />
        <form class="form-select-button" action="" method="post">
            <input type="text" name="attr" maxlength="255" placeholder="Name is..." />
            <button type="submit">Send</button>
        </form>

        <br /><br />
        <div class="message-block">
            <ul><%= vl.getResultToHtml() %></ul>
        </div>

    </div>

</body>
</html>