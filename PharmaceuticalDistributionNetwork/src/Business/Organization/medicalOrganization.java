/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MedicalOfficer;
import Business.Role.PatientRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author zakir
 */

public class medicalOrganization extends Organization{
    public medicalOrganization() {
        super(OrganizationType.MedicalOrganization.getValue());
    }
    
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MedicalOfficer());
        return roles;
    }
    
}
