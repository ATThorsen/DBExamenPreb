/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Aske
 */
public class CustomerFacade {
    
    
    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    private CustomerFacade() {
    }
        public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
            public List<Customer> getAllPerson(){
        EntityManager em = emf.createEntityManager();
        
              try {
            Query query = em.createNamedQuery("Customer.getAll");
            //return new Gson().toJson(query.getResultList());
            List<Customer> resultList = query.getResultList(); 
        
            return resultList; 
              }
        finally {
            em.close();
        }
    }
    
    public Customer addPerson(Customer c){
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            
        }finally {
            em.close();
        }
        return c;
    }
}
    

