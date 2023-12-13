
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
/**
 *
 * @author sanal
 */
public abstract class Role {
    
    public enum RoleType{
        EnterpriseAdmin("Enterprise Admin"),
        FDAEmployee("FDA Employee"),
        Distributor("Distributor"),
        Provider("Provider"),
        Manufacturer("Manufacturer"),
        Patient("Patient"),
        StateHealthDepartment("State Health Department"),
        MedicalOfficer("Medical Officer"),
        ClinicProvider("Clinc Provider");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
