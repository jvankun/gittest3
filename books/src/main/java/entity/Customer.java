/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.CustomerType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

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
    @Enumerated(EnumType.STRING) //giver string i database
    private CustomerType type;
    @ElementCollection()//opretter nyt tabel customer_hobbies i databasen.
    private List<String> hobbies = new ArrayList();
    @ElementCollection(fetch=FetchType.LAZY)
    @MapKeyColumn(name="PHONE")//kolonne PHONE i tabellen
    @Column(name="Description")//kolonne Description i tabellen
    Map<String,String> phones = new HashMap();
    
    
    public Customer(){};
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Customer(String firstName, String lastName, CustomerType type){
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }
    
    public String getFirstName(){ return firstName;}
    public String getLastName(){ return lastName;}
    public Integer getId() {   return id; }
    public CustomerType getType(){ return type;}
    
    public void setId(Integer id) { this.id = id;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName ){this.lastName = lastName;}
    public void setType(CustomerType type){this.type = type;}
    
    
    public void addPhone(String phoneNo, String description){
        phones.put(phoneNo, description);    
    }
    public String getPhoneDescription(String phoneNo){
        String s = phones.get(phoneNo);
        return s;
    }
    
    public void addHobby(String s){ hobbies.add(s);}
    public String getHobbies(){
        
        String s = null;
        for(int i = 0; i <hobbies.size(); i++){
            s += hobbies.get(i) +",";  }
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ id=" + id + " ]";
    }
    
}
