/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;

/**
 *
 * @author anzal
 */
public class CityNetwork {
    
    private EnterpriseDirectory enterpriseDirectory;
    private String cityName;

    public CityNetwork() {
        this.enterpriseDirectory = new EnterpriseDirectory();
        
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public String getName() {
        return cityName;
    }

    public void setName(String name) {
        this.cityName = name;
    }

    @Override
    public String toString() {
        return cityName; 
    }
    
    //displays number of vaccinesadministerdin city
    public int getTotalVaccinesAdministeredInCity()
    {
        int sum = 0;
        if(enterpriseDirectory != null)
        {
            for(Enterprise enterprise: enterpriseDirectory.getEnterpriseDirectory())
            {
                if( enterprise instanceof HospitalEnterprise)
                {
                    HospitalEnterprise he = (HospitalEnterprise)enterprise;
                    for(Organization org : he.getOrganizationDirectory().getOrganizationList())
                    {
                        if(org instanceof HospitalOrganization)
                        {
                            HospitalOrganization ho = (HospitalOrganization)org;
                            sum = sum + ho.getClinic().getTotalAdministeredVaccines();
                        }
                    }
                }
            }
        }
        
    
    return sum;
    
}
    //displays number of failed vaccines in city
    public int getTotalFailedVaccinesInCity()
    {
        int sum = 0;
        if(enterpriseDirectory != null)
        {
            for(Enterprise enterprise: enterpriseDirectory.getEnterpriseDirectory())
            {
                if( enterprise instanceof HospitalEnterprise)
                {
                    HospitalEnterprise he = (HospitalEnterprise)enterprise;
                    for(Organization org : he.getOrganizationDirectory().getOrganizationList())
                    {
                        if(org instanceof HospitalOrganization)
                        {
                            HospitalOrganization ho = (HospitalOrganization)org;
                            sum = sum + ho.getClinic().getTotalVaccinesFailed();
                        }
                    }
                }
            }
        }
        
    
    return sum;
    
}
    
    //displays number of distributed vaccines in city
    public int getTotalVaccinesDistributedInCity()
    {
        int sum = 0;
        if(enterpriseDirectory != null)
        {
            for(Enterprise enterprise: enterpriseDirectory.getEnterpriseDirectory())
            {
                if( enterprise instanceof HospitalEnterprise)
                {
                    HospitalEnterprise he = (HospitalEnterprise)enterprise;
                    for(Organization org : he.getOrganizationDirectory().getOrganizationList())
                    {
                        if(org instanceof HospitalOrganization)
                        {
                            HospitalOrganization ho = (HospitalOrganization)org;
                            sum = sum + ho.getClinic().getTotalStoredVaccines();
                        }
                    }
                }
            }
        }
        
    
    return sum;
    
}
    
    
}
