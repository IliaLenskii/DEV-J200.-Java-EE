<%@page session="true" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="jsp.ReaderDatam" %>

<%!
   ReaderDatam rd = new ReaderDatam();
%>

<!DOCTYPE html>
<html>
<head>
    <title>It's lab4</title>

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
        <form class="form-select-button" action="index-request" method="post">
            <input type="text" name="attr" maxlength="50" placeholder="Attr is..." />
            <br />
            <br />
            <button type="submit">Send</button>
        </form>
        
        <br /><br />
        <div class="message-block">
            <div>
                Sum is <%= rd.getSum() %>
            </div>
            <br />
            <div>
                Messages is: <br />
                <%= rd.getAllMsg() %>
            </div>
        </div>
        
    </div>

</body>
</html>