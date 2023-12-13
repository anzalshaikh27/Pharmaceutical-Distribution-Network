
package Business.Person;


/**
 *
 * @author sanal
 */
public class Distributor extends Person {
    
    private int id;
    private static int count = 1;

    public Distributor() {
        id = count;
        count++;
        this.setLastName(null);
        
    }
    
      public int getId() {
        return id;
    }
      
      @Override
    public String toString(){
        return this.getFirstName()+" "+this.getLastName();
    }
    
    
}
