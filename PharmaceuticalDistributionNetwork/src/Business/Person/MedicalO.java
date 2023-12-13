
package Business.Person;

/**
 *
 * @author sanal
 */
public class MedicalO extends Person{
    private int id;
    private static int count = 1;

    public MedicalO() {
        
        id = count;
        count++;
    }
    
    
     public int getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return this.getFirstName()+" "+this.getLastName();
    }
}
