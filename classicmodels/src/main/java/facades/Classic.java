
package facades;

import entity.Customer;
import entity.Employee;
import entity.Office;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Johnny
 */
public class Classic {
    EntityManagerFactory emf;

    public Classic(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public long employeeCountBAD(){
         EntityManager em = emf.createEntityManager();
        try{
            //don't do this 
            return (long) em.createNamedQuery("Employee.findAll").getResultList().size();
        }finally{
            em.close();
        }
    }
    public long getEmployeeCount(){
        EntityManager em = emf.createEntityManager();
        try{
           Query q = em.createQuery("select count(e) from Employee e");
           return (long) q.getSingleResult();
        }finally{
            em.close();
        }
    
    }
   
    public Employee createEmployee(String lastName, String firstName, String extension, String email, String jobTitle, String officeCode) {
    Employee emp = new Employee(lastName, firstName, extension, email, jobTitle);
    EntityManager em = emf.createEntityManager();
    Office of = em.find(Office.class, officeCode);
    emp.setOffice(of);
   
    try{
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }finally{
        em.close();
    }
    }  
    public Customer updateCustomer(Customer cust){
         EntityManager em = emf.createEntityManager();
    try{
            em.getTransaction().begin();
            em.merge(cust);
            em.getTransaction().commit();
            return cust;     
        }finally{
                 em.close();
                }
        
    }
    public Customer findCustomer(int id){
         EntityManager em = emf.createEntityManager();
    try{
            em.getTransaction().begin();    
            Customer cust = em.find(Customer.class, id);
            em.getTransaction().commit();
            return cust;
        }finally{
                 em.close();
                }
    }
    
    public List<Employee> getAllEmployees(){
        EntityManager em = emf.createEntityManager();
    try{
        em.getTransaction().begin();    
        Query q = em.createQuery("select e from Employee e ");
        List<Employee> list = q.getResultList();
        em.getTransaction().commit();
        return list;
    }finally{
                 em.close();
            }
    }
    public List<Customer> getCustomerInCity(String city){
        EntityManager em = emf.createEntityManager();
    try{
        em.getTransaction().begin(); 
        Query q = em.createQuery("select c from Customer c where c.city =:city");
        q.setParameter("city", city);
        List<Customer> list = q.getResultList();
        em.getTransaction().commit();
        return list;
    }finally{
                 em.close();
            }
    }
    
  
   
    public List<Integer> getOrdersOnHold(){
         EntityManager em = emf.createEntityManager();
    try{
        em.getTransaction().begin(); 
         Query q = em.createQuery("select o.ordernumber From OrderClassic o where o.status ='On Hold'");
         List<Integer> numbers = q.getResultList();
        em.getTransaction().commit();
        return numbers;
    }finally{
                 em.close();
            }
    }
    
        
    
        
    
}

    

