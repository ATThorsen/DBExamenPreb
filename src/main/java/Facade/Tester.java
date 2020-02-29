/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Aske
 */
public class Tester {
    
    
    //Private Constructor to ensure Singleton

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CustomerFacade customerFacade = CustomerFacade.getCustomerFacade(emf);
        em.getTransaction().begin();
        Tester t1 = new Tester();
        
            Customer c1 = new Customer("Jønke", "Jørgensen");
            Customer c2 = new Customer("Hanne", "Jørgensen");
            customerFacade.addPerson(c1);
            customerFacade.addPerson(c2);
            

            Persistence.generateSchema("pu", null);

            em.getTransaction().commit();
   
    }
    
}
