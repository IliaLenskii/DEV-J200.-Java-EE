/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsp;

import java.util.List;
import entitymy.Tabletotext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ilia
 */
public class ReaderDatam {
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("AppPU");
    private EntityManager em = factory.createEntityManager();

    public Long getSum() {
        
        Query sqlRes = em.createNamedQuery("Tabletoint.getSumByVal");

        Long sum = (Long) sqlRes.getSingleResult();
        
        return sum;
    }
    
    public String getAllMsg() {
        
        StringBuilder sb = new StringBuilder("");
        
        Query sqlRes = em.createNamedQuery("Tabletotext.findAll");
        
        List<Tabletotext> resList = sqlRes.getResultList();
        
        resList.forEach(_item -> {
            
            sb.append((_item.getVal() +"<br />"));
        });

        return sb.toString();
    }
}
