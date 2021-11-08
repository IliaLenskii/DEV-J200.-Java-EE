package com.example.lab3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.util.HashMap;

@Stateful(name = "Lab3")
@Remote(EJBDemo.class)
public class MyBean implements EJBDemo {
    private boolean isAuthorized = false;
    private HashMap<String, Integer> showCounter = new HashMap<>();

    @Override
    public String getMessage (String login){
        String m1 = "Access denied";
        String m2 = "This important message for you!";

        if(login == null || login.equals(""))
            return m1;

        if(!showCounter.containsKey(login)) {

            return m1;
        }

        Integer va = showCounter.get(login);

        --va;

        showCounter.remove(login);

        if (va != 0) {

            showCounter.put(login, va);

            return m2;
        }

        return m1;
    }

    @Override
    public boolean login(String login, String psw) {
        boolean isAuth = false;

        if(login == null || psw == null)
            isAuth = false;

        if(login.equals("") || psw.equals(""))
            isAuth = false;

        if(login.equals("login") && psw.equals("1"))
            isAuth = true;

        if(isAuth) {

            if(!showCounter.containsKey(login)) {

                showCounter.put(login, 3);
            }
        }

        this.isAuthorized = isAuth;

        return this.isAuthorized;
    }

    @PostConstruct
    public void myPostConstruct() {

        //System.out.println("PostConstruct");
    }

    @PreDestroy
    public void myPreDestroy() {

        //System.out.println("PreDestroy");
    }

    @PostActivate
    public void myPostActivate() {

        //System.out.println("PostActivate");
    }

    @PrePassivate
    public void myPrePassivate() {

        //System.out.println("PrePassivate");
    }
}