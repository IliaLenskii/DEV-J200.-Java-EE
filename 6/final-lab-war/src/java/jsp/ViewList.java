package jsp;

import entitymy.Finallab;
import java.util.List;
import javax.ejb.EJB;
import mymdb2.DbManager;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author ilia
 */
public class ViewList {

    private HttpServletRequest request;
    
    @EJB
    private DbManager dbManager;
    
    public ViewList (HttpServletRequest request) {
        
        if(dbManager == null)
            dbManager = Registrator.getDbManager();

        this.request = request;
    }
    
    public String getResultToHtml() {
        
        boolean isPost = "POST".equals(request.getMethod());
        
        String attr = request.getParameter("attr");
        String attrValid = "";
        
        if(attr != null) {

            attrValid = attr.trim();
        }
        
        StringBuffer html = new StringBuffer();
        html.append("List is empry");

        List<Finallab> fl = null;

        if(isPost && attrValid.length() > 0) {

            fl = dbManager.getValByLikeAtName(attrValid);

        } else {

            fl = dbManager.getAllAttrAndVal();
        }

        if(fl != null && !fl.isEmpty()) {

            html.delete(0, html.length());
            
            fl.forEach(itm -> {
                
                html.append(itm.toStringToLi());
            });
        }

        return html.toString();
    }
}
