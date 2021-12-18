package mymdb2;

import entitymy.Finallab;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.Query;
import java.util.List;
import sessionbeans.SelectBean;
import sessionbeans.UpdateBean;

/**
 *
 * @author ilia
 */
@Singleton
//@Startup
public class DbManager {
    
    @EJB
    private SelectBean selecteBean;
    
    @EJB
    private UpdateBean updateBean;

    private final String factoryName = "final-lab-warPU";

    private EntityManagerFactory factory;
    private EntityManager em;

    @PostConstruct
    public void initialize() {

        factory = Persistence.createEntityManagerFactory(factoryName);
        em = factory.createEntityManager();
    }

    public boolean doSaveOrUpdate(String attr, Integer val) {

        Finallab getFirstEl = updateBean.isExistsName(attr);
        
        if(getFirstEl != null) {
            
            updateBean.updateData(getFirstEl, val);
        } else {
            
            updateBean.insertData(attr, val);
        }        
        
        return getFirstEl != null;
    }
    
    public List<Finallab> getAllAttrAndVal() {

        return selecteBean.getAllAttrAndVal();
    }
    
    public List<Finallab> getValByLikeAtName(String like) {

        return selecteBean.getValByLikeAtName(like);
    }
}