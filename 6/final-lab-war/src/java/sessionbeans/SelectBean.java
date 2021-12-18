/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package sessionbeans;

import entitymy.Finallab;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ilia
 */
@Stateless
@LocalBean
public class SelectBean {
    
    private EntityManagerFactory factory;
    private EntityManager em;
    
    private final String factoryName = "final-lab-warPU";
    
    @PostConstruct
    public void initialize() {

        factory = Persistence.createEntityManagerFactory(factoryName);
        em = factory.createEntityManager();
    }
    
    public List<Finallab> getAllAttrAndVal() {

        List<Finallab> sqlRes = em.createNamedQuery("Finallab.findAll", Finallab.class).getResultList();
        
        return sqlRes;
    }
    
    public List<Finallab> getValByLikeAtName(String like) {

        List<Finallab> sqlRes = em.createNamedQuery("Finallab.findByLike", Finallab.class)
                .setParameter("name", "%"+ like +"%")
                .getResultList();

        return sqlRes;
    }
}
