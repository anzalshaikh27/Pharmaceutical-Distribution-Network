
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Manufacture.ManufactureEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author sanal
 */
public class ManufacturerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new ManufactureEmployeeWorkAreaJPanel(userProcessContainer, account, (Manufacturer)enterprise, business);
    }
    
}
