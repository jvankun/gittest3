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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Johnny
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
   
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList();
    
    
    public Integer getId() { return id;}
    public void setId(Integer id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {  return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public Customer() {}
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void addAddress(Address address){
        addresses.add(address);
         
    }
      public List<Address> getAddresses(){
        return addresses;
    }
    
    /*public String getAddresses(){
        
        String s = null;
        for(int i = 0; i <addresses.size(); i++){
            s += addresses.get(i) +",";  }
        return s;
    }*/

   
  
    
}
