
package Business.Person;

/**
 *
 * @author sanal
 */
public class LocalHealthDepartmentEmployee extends Person{
    
    private int id;
    private static int count = 1;
    
     public LocalHealthDepartmentEmployee() {
        id = count;
        count++;
    }
     
     public int getId() {
        return id;
    }
     
         @Override
    public String toString(){
        return this.getFirstName()+ " " + this.getLastName();
    }
    
}
