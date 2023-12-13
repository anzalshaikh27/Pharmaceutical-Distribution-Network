/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Order;

import java.util.ArrayList;
/**
 *
 * @author anzal
 */
public class OrderHistory {
    
    private ArrayList<Order> History;

    public OrderHistory() {
        History = new ArrayList<>();
        
    }

    public ArrayList<Order> getOrderHistory() {
        return History;
    }
    
    public Order addNewOrder(){
        Order order = new Order();
        History.add(order);
        return order;
    }
    
    public Order addOrder(Order order){
        
       
        History.add(order);
        return order;
    }
    
    
    public void removeOrder(Order order){
        History.remove(order);
        
    }
    
}
