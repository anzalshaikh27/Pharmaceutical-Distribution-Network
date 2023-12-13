
package Business.Person;

import Business.Order.OrderHistory;

/**
 *
 * @author sanal
 */
public class Provider extends Person {
     
    private OrderHistory orderHistory;
     private int id;
    private static int count = 1;

    public Provider() {
        id = count;
        count++;
    }
    
    public int getId() {
        return id;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

        @Override
    public String toString(){
        return this.getFirstName()+ " " + this.getLastName();
    }

}
