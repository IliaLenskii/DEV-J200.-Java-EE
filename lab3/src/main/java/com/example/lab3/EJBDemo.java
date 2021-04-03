package com.example.lab3;

//import javax.ejb.Remote;

//@Remote
public interface EJBDemo {

    /*

     */
    boolean login(String login, String psw);

    /*

     */
    String getMessage (String login);
}
