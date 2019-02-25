/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Johnny
 */
public class CustomerFacade {
    
    EntityManagerFactory emf;
    public CustomerFacade(EntityManagerFactory emf){this.emf =emf;}
    EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    // Query for a single object.

    //CRUD
    public Customer getCustomer(int id){
        EntityManager em = getEntityManager();
    try{
            Query q = em.createQuery("Select c FROM Customer WHERE c.id = :id");
            q.setParameter("id", id);
            return (Customer)q.getSingleResult();
        }finally{
                 em.close();
                }
    }
    //Query for a List of data elements.
    public List<Customer> getCustomers(){   
        EntityManager em = getEntityManager();
    try{
            Query q = em.createQuery("Select c.firstName,c.lastName FROM Customer c");
            List<Customer> res = q.getResultList();  
            return res;
        }finally{
                 em.close();
                }
    
    }
    // 
    public Customer addCustomer(Customer cust){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        }finally{
            em.close();
        }
    }
    //update
    public Customer editCustomer(Customer cust){
         EntityManager em = getEntityManager();
    try{
            em.getTransaction().begin();
            em.merge(cust);
            em.getTransaction().commit();
            return cust;     
        }finally{
                 em.close();
                }
        
         }
    public Customer deleteCustomer(int id){
        EntityManager em = getEntityManager();
    try{
         em.getTransaction().begin();   
        Customer c = em.find(Customer.class, id);
        em.remove(c);
        em.getTransaction().commit();
        return c; 
        }finally{
                 em.close();
                }
    }
}

  
    
    
    
    


