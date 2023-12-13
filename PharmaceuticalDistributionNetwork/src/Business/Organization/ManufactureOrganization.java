/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.ManufacturerRole;
import Business.Role.Role;
import Business.Vaccine.VaccineProductCatalog;
import java.util.ArrayList;

/**
 *
 * @author zakir
 */

public class ManufactureOrganization extends Organization {
    
    private VaccineProductCatalog vaccineProductCatalog;
    
    public ManufactureOrganization() {
        super(OrganizationType.ManufactureOrg.getValue());
        vaccineProductCatalog = new VaccineProductCatalog();
    }

    public VaccineProductCatalog getVaccineProductCatalog() {
        return vaccineProductCatalog;
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManufacturerRole());
        return roles;
    }
    
}
