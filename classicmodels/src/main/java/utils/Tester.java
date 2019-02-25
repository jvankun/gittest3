/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Customer;
import entity.Employee;
import facades.Classic;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Johnny
 */
public class Tester {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        Classic facade = new Classic(emf);
        //create an employee med nummer 2000 som id!!!!
        Employee emp = facade.createEmployee("aaa","bbb","ed","dfs","dfdsf","1");
        
        System.out.println(emp.getFirstname()+","+emp.getEmployeenumber());
        
        Customer cus = facade.findCustomer(103);
        System.out.println(cus.getCustomername()+ "," + cus.getContactfirstname());
        
        List<Integer> list = facade.getOrdersOnHold();
       System.out.println( list);
        
       List<Integer> list2 = facade.getOrdersOnHold(144);
       System.out.println( list2);
        
    }
    
}
