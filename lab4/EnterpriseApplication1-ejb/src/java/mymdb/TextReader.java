/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package mymdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 *
 * @author ilia
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/lab4queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class TextReader implements MessageListener {
    
    public TextReader() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        String bodyText = "";
        TextMessage textMsg = (TextMessage) message;
        
        try {
            bodyText = textMsg.getText();

        } catch (JMSException ex) {
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Text t = new Text();
        
        System.out.println("Text Reader: "+ bodyText);
    }
    
}
