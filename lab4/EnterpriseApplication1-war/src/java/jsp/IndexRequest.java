/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.Index;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ilia
 */
@WebServlet(name = "IndexRequest", urlPatterns = {"/index-request"})
public class IndexRequest extends HttpServlet {
    
    @Resource(lookup = "jms/lab4queueFactory")
    private QueueConnectionFactory connFactory;
    
    @Resource(lookup = "jms/lab4queue")
    private Queue queue;
    
    @Resource(lookup = "jms/lab4queueInt")
    private Queue queueInt;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        boolean isPost = "POST".equals(request.getMethod());
        String mainPage = "/EnterpriseApplication1-war";
        
        if(!isPost) {
            
            response.sendRedirect(mainPage);
            return;            
        }

        String attr = request.getParameter("attr");

        if(attr.length() < 1) {

            response.sendRedirect(mainPage);
            return;
        }
        
        boolean isNumericAttr = isNumeric(attr);
        
        try {
            Connection cnFact = connFactory.createConnection();
            Session session = cnFact.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            Queue optQueue = isNumericAttr ? queueInt : queue;
            
            MessageProducer msprd = (MessageProducer) session.createProducer(optQueue);

            if(isNumericAttr) {
                
                msprd.send(getObjectMessage(session, Integer.parseInt(attr)));
            } else {
                
                msprd.send(getTextMessage(session, attr));
            }

        } catch (JMSException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(mainPage);
    }
    
    private TextMessage getTextMessage(Session s, String str) throws JMSException {
        
        TextMessage texmes = s.createTextMessage();
        texmes.setText( str );
        
        return texmes;
    }
    
    private ObjectMessage getObjectMessage(Session s, Integer n) throws JMSException {
        
        ObjectMessage obmes = s.createObjectMessage();
        obmes.setObject( n );
        
        return obmes;
    }
    
    // https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    private boolean isNumeric(String str) {
        
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
