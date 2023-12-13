
package Business.Person;

import Business.Vaccine.VaccineProductCatalog;
/**
 *
 * @author sanal
 */
public class ManufacturerEmployee extends Person{
    
    private int id;
    private static int count = 1;
    //private VaccineProductCatalog vaccineProductCatalog;

    public ManufacturerEmployee() {
        id = count;
        count++;
        this.setLastName(null);
       // this.vaccineProductCatalog = new VaccineProductCatalog();
        
    }
    
    public int getId() {
        return id;
    }
     
    @Override
    public String toString(){
        return this.getFirstName()+" "+this.getLastName();
    }
    
}
