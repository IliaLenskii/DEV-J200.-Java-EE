/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.ejb;

import java.io.IOException;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author il.lenskii
 */
@Stateless
public class IndexBean implements IndexBeanLocal {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    boolean isPost = false;
    String formAttr = "";
    String resultToJsp = "-";

    public IndexBean() {
    }

    public IndexBean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        this.request = request;
        this.response = response;
        this.isPost = "POST".equals(request.getMethod());
        
        if(!this.isPost) {

            return;
        }

        formAttr = request.getParameter("attr").trim();

        if(formAttr == null || formAttr.equals("") || formAttr.isEmpty()) {
            
            response.sendRedirect( request.getRequestURI() );
            return;
        }
        
        if(isNumeric(formAttr)) {

            resultToJsp = ("9"+ formAttr +"1");
        } else {
            
            long spaces = formAttr.split("\\s+").length;
            
            resultToJsp = formAttr +" ("+ spaces +")";
        }
    }

    @Override
    public String getResult() {
        
        return resultToJsp;
    }
    
    // https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    private boolean isNumeric(String str) {
        
        return str.matches("-?\\d+(\\.\\d+)?");
    }    
}
