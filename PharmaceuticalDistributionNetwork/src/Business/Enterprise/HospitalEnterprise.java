/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Order.OrderHistory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author anzal
 */
public class HospitalEnterprise  extends Enterprise {
    
    private OrderHistory orderHistory;
    
    public HospitalEnterprise(String name) {
        
        super(name, EnterpriseType.Hospital);
        this.orderHistory = new OrderHistory();
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
