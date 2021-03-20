package com.example.lab1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HelloServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String val = request.getParameter("value");
    }

    public void destroy() {}
}