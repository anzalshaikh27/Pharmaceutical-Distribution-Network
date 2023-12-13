
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.ClinicOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.Clinic.ClinicWorkAreaJPanel;
import javax.swing.JPanel;
/**
 *
 * @author sanal
 */
public class ClinicProviderRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business,StateNetwork state) {
        return new ClinicWorkAreaJPanel(userProcessContainer, account, (HospitalEnterprise)enterprise, (ClinicOrganization)organization, business, state);
    }
 
}
