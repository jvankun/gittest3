
package test;

import entity.Book;
import entity.Customer;
import enums.CustomerType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




/**
 *
 * @author Johnny
 */
public class Tester {
     public static void main(String[] args) {
         //Book c1;
         //recreate my database whenever I like by running this method
         //Persistence.generateSchema("pu", null);
         
        
        Customer c1 = new Customer("ida", "corr",CustomerType.GOLD);
        Customer c2 = new Customer("helle", "hansen",CustomerType.SILVER);
        Customer c3 = new Customer("ole", "jensen",CustomerType.RUSTY);
        c3.addHobby("fodbold");
        c3.addHobby("piger");
        c3.addPhone("20202020", "mobil");
        c3.addPhone("10101010", "hjemme");   
        c1.addPhone("70707070", "hjemme"); 
        Book b1 = new Book("strange thing");
        Book b2 = new Book("holy");
        //pu is the name of the persistence unit, chosen before.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
           em.getTransaction().begin();
           em.persist(c1);
           em.persist(c2);
           em.persist(c3);
            
           em.getTransaction().commit();
            
        } finally {
            em.close();
        }
        
         
     
     }
         
    
}
