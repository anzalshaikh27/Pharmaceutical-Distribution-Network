
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.FDA;
import Business.Network.StateNetwork;
import Business.Organization.FDAOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.medicalOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.FDA.MedicalOfficerNewJPanel;
import UserInterface.Patient.PatientWorkAreaJPanel;
import javax.swing.JPanel;
/**
 *
 * @author sanal
 */
public class MedicalOfficer extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, EcoSystem business, StateNetwork state) {
        return new MedicalOfficerNewJPanel(userProcessContainer, account,business, (FDA)enterprise, (medicalOrganization)organization);
    }
    
}
