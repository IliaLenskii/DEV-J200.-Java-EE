package sessionbeans;

import entitymy.Finallab;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ilia
 */
@Stateless
@LocalBean
public class UpdateBean {
    
    private EntityManagerFactory factory;
    private EntityManager em;
    
    private final String factoryName = "final-lab-warPU";
    
    @PostConstruct
    public void initialize() {

        factory = Persistence.createEntityManagerFactory(factoryName);
        em = factory.createEntityManager();
    }
    
    public Finallab isExistsName(String attr) {

        Query sqlRes = em.createNamedQuery("Finallab.findByName");
              sqlRes.setParameter("name", attr);

        List<Finallab> resDB = sqlRes.getResultList();
        
        if(resDB == null || resDB.isEmpty())
            return null;

        return resDB.get(0);
    }
    
    public Boolean insertData(String attr, Integer val) {

        Finallab fl = new Finallab(attr, val);
        
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist( fl );
        tx.commit();
        
        return true;
    }
    
    public Boolean updateData(Finallab el, Integer val) {
        
        el.setVal(val);
        
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist( el );
        tx.commit();
        
        return true;
    }
    
    public Boolean removeData(Finallab el) {
        
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(el);
        tx.commit();
        
        return true;
    }

}
