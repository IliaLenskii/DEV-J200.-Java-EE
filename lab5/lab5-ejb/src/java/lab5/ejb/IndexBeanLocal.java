/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.ejb;

import javax.ejb.Local;

/**
 *
 * @author il.lenskii
 */
@Local
public interface IndexBeanLocal {
    
    String getResult();
}
