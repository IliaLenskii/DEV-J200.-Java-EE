package jsp;

import java.io.IOException;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mymdb2.DbManager;

/**
 *
 * @author ilia
 */
@WebServlet(name = "IndexRegistrator", urlPatterns = {"/index-registrator"})
public class Registrator extends HttpServlet {

    public static final String nameUserError = "nameUserError";
    
    @EJB
    private DbManager dbManager;

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
        String mainPage = request.getContextPath();

        if(!isPost) {
            
            response.sendRedirect(mainPage);
            return;            
        }

        String attr = request.getParameter("attr");
        String val = request.getParameter("val");
        Integer intVal;
        
        String isErr = isValidParr(attr, val);
        
        if(isErr != null) {
            
            Registrator.setValUserError(request, isErr);
            
            response.sendRedirect(mainPage);
            return;
        }        

        intVal = Integer.parseInt(val);     

        Boolean isNew = dbManager.doSaveOrUpdate(attr, intVal);
        
        Registrator.setValUserError(request, "Parameter and value "+ (isNew ? "isn't new" : "is new")); 

        response.sendRedirect(mainPage);
    }

    public static final Boolean setValUserError(HttpServletRequest req, String v) {
        
        if(v.isEmpty())
            return false;
        
        try {
        
            req.getSession().setAttribute(Registrator.nameUserError, v);
        } catch (Exception err) {
            
            System.out.println(err.getMessage());
            
            return false;
        }
        
        return true;
    }
    
    public static final String getValUserError(HttpServletRequest req) {
        
        String val = null;
        
        try {
        
            val = (String) req.getSession().getAttribute(Registrator.nameUserError);

            req.getSession().removeAttribute(Registrator.nameUserError);
        } catch (Exception err) {
            
            System.out.println(err.getMessage());
            
            return null;
        }
        
        return val;
    }
    
    public static final DbManager getDbManager() {
        
        try {

            InitialContext ic = new InitialContext();
            DbManager dbMan = (DbManager) ic.lookup("java:module/DbManager");
            
            return dbMan;

        } catch (NamingException err){
            
            System.out.println(err.getMessage());
        }

        return null;
    }
    
    private String isValidParr(String attr, String val) {
        
        if(attr == null || val == null) {

            return "Required parameter is missing";
        }
        
        attr = attr.trim();
        val = val.trim();

        if(attr.length() < 1) {

            return "Name is empty";
        }
        
        if(attr.length() > 255) {

            return "Name is too long";
        }
        
        if(val.length() < 1) {

            return "Value is empty";
        }
        
        if(!isNumeric(val)) {

            return "Value is not Numeric";
        }

        try {

            Integer intVal = Integer.parseInt(val);

        } catch (NumberFormatException err) {

            return "NumberFormatException: "+ err.getMessage();
        }

        return null;
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
