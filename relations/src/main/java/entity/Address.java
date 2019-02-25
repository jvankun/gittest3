/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Johnny
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;
    
    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
    private List<Customer> customers  = new ArrayList();

    
    public void addCustomer(Customer customer){
       customers.add(customer);
    }
    public List<Customer> getCustomers(){
        return customers;
    }
    
    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id;}
    public String getStreet() { return street;}
    public void setStreet(String street) {   this.street = street;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public Address() {}
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
  
    
}
