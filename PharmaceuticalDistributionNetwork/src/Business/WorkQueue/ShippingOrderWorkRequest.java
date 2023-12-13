/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.Order.Order;
import Business.UserAccount.UserAccount;
import java.util.Date;
/**
 *
 * @author zakir
 */
public class ShippingOrderWorkRequest extends WorkRequest {
    
    private Order vaccineOrder;
    private Order shipOrder;
   
    private Date shippingDate;

    public ShippingOrderWorkRequest() {
        shipOrder = new Order();
    }
 

    public Order getVaccineOrder() {
        return vaccineOrder;
    }

    public void setVaccineOrder(Order vaccineOrder) {
        this.vaccineOrder = vaccineOrder;
    }

    public Order getShipOrder() {
        return shipOrder;
    }

    public void setShipOrder(Order shipOrder) {
        this.shipOrder = shipOrder;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccineOrder.getOrderNumber());
    }
   
  
}
