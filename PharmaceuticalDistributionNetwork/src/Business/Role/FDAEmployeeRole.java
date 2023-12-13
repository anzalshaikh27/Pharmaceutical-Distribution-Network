
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.FDA;
import Business.Network.StateNetwork;
import Business.Organization.FDAOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.FDA.FDAEmployee;
import javax.swing.JPanel;

/**
 *
 * @author sanal
 */
public class FDAEmployeeRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new FDAEmployee(userProcessContainer, account, (FDA)enterprise, (FDAOrganization)organization, business);
    }
    
}
