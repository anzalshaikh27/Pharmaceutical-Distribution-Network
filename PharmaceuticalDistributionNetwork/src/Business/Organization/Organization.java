/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import java.util.ArrayList;
import Business.Person.PersonDirectory;
import Business.Order.OrderHistory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;


/**
 *
 * @author zakir
 */

public abstract class Organization {
    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private OrderHistory orderCatalog;
    
    private static int counter;
    
    //Here are the below organizations that we are going to use in this project
    
    public enum OrganizationType{
        EnterpriseAdminOrg("Enterprise Admin Organization") ,
        FDAOrg ("FDA Organization"),
        ManufactureOrg("Manufacture Organization"),
        DistributorOrg("Distributor Organization"),
        StateHealthDepartmentOrg("State Health Department"),
        HospitalOrg("Hospital Organization"),
        PatientOrganization("Patient Organization"),
        MedicalOrganization("Medical Organization"),
        ClinicOrganization("Clinic Organization");
        
        private String value;
        private OrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        orderCatalog = new OrderHistory();
        organizationID = counter;
        ++counter;
    }

    public OrderHistory getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderHistory orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    
    

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    
    
    
    
    @Override
    public String toString() {
        return name;
    }
    
  
}
