/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package mymdb2;

import entitymy.Tabletoint;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ilia
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/lab4queueInt"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ObjectReader implements MessageListener {

    public ObjectReader() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        Integer bodyInt = -1;
        ObjectMessage objMsg = (ObjectMessage) message;
        
        try {
            bodyInt = objMsg.getBody(Integer.class);

        } catch (JMSException ex) {
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Tabletoint tbval = new Tabletoint();
        tbval.setVal(bodyInt);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AppPU");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist( tbval );
        em.getTransaction().commit();
        em.close();
        
        //System.out.println("Object Reader: "+ bodyInt);
    }
    
}
