package com.example.lab3;

public interface EJBDemo {

    boolean login(String login, String psw);

    String getMessage (String login);

    boolean getIsAuthorized();
}
