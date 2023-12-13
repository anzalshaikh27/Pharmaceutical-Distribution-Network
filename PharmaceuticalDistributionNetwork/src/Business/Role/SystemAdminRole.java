
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.SystemAdmin.SystemAdminWorkAreaJPanel;

import javax.swing.JPanel;
/**
 *
 * @author sanal
 */
public class SystemAdminRole extends Role{
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, business, account);
    }
    
}
