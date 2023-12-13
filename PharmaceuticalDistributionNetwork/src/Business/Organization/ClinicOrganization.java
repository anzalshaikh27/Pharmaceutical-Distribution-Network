/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.Role;
import Business.Role.ClinicProviderRole;
import java.util.ArrayList;

/**
 *
 * @author zakir
 */
public class ClinicOrganization extends Organization{
    
    private String ClincName;
    
    public ClinicOrganization() {
        super(OrganizationType.ClinicOrganization.getValue());
    }

    public String getClincName() {
        return ClincName;
    }

    public void setClincName(String ClincName) {
        this.ClincName = ClincName;
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClinicProviderRole());
        return roles;
    }
    
}
