
package Business;

import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author anzal
 */
public class ConfigureASystem {
    public static EcoSystem configure(){
        //Creating Ecosystem
        EcoSystem business = EcoSystem.getInstance();
        Person person = null;
        //Creating sysadmin user account
        UserAccount sysAdmin = business.getUserAccountDirectory().createUserAccount("dsadmin", "dsadmin", person, new SystemAdminRole());       
        return business;
    }
}
