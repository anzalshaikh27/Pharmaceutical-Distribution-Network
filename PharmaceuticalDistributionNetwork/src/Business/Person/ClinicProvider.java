
package Business.Person;

/**
 *
 * @author sanal
 */
public class ClinicProvider extends Person{
    
     private int id;
    private static int count = 1;
    //private HospitalEnterprise affliatedHospital;

    public ClinicProvider() {
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
