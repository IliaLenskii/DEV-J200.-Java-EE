package com.example.lab3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import java.io.IOException;

@Stateful
public class MyBean implements EJBDemo {

    @Override
    public String getMessage (String login){

        return "sfasdff";
    }

    @Override
    public boolean login(String login, String psw) {

        return false;
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