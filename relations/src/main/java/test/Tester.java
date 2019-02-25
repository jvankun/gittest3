/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Address;
import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Johnny
 */
public class Tester {
   public static void main(String[] args) {
   
       //Persistence.generateSchema("pu", null);
       
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
       EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
       Customer cm2 = new Customer("ida", "corr");
       Customer cm = new Customer("johnny", "van");
       Address ad = new Address("keplersgade", "københavn");
       Address ad1 = new Address("århusgade", "københavn");
       
       Customer cm1 = new Customer("michael", "schultz");
       Address ad2 = new Address("viborggade", "århus");
       Address ad3 = new Address("skakgade", "ålborg");
       
       cm2.addAddress(ad);
       ad.addCustomer(cm2); //en adresse har to kunder
       
       
       cm.addAddress(ad);
       cm.addAddress(ad1);
       cm1.addAddress(ad2);
       cm1.addAddress(ad3);
         
          em.persist(cm);
          em.persist(cm1);
          em.persist(cm2);
           
            
           em.getTransaction().commit();
            
        } finally {
            em.close();
        }
        
         
     
     }
       
  
   
    
}
