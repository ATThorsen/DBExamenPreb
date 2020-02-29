/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aske
 */
@Entity
@Table(name = "CustomerOrder")
@NamedQueries({
    @NamedQuery(name = "Order.deleteAllRows", query = "DELETE FROM Order"),
    @NamedQuery(name = "Order.getAll", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Order.getByCustomer", query = "SELECT o From Order o WHERE o.customer.id = :id")
})
 public class Order implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDERID")
    private Long orderID;
    
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private ArrayList<OrderLine> orderLine = new ArrayList<>();
    

    public Order() {
        this.orderLine = new ArrayList();
    }
    
    public Order(Long orderID) {
        this.orderLine = new ArrayList<>();
        this.orderID = orderID;
    }
    
    public Long getId() {
        return orderID;
    }

    public void setId(Long orderID) {
        this.orderID = orderID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ordre[ orderID=" + orderID + " ]";
    }
    
}
