/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.EnterpriseAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.ClinicOrganization;
import Business.Person.Person;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author anzal
 */
public class CreateUserAccountJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;
    private final Enterprise enterprise;
    private final ManageUserAccountJPanel panel;
    private final EcoSystem business;
    /**
     * Creates new form CreateUserAccountJPanel
     * @param workContainer
     * @param enterprise
     * @param panel
     * @param business
     */
    public CreateUserAccountJPanel(JPanel workContainer, Enterprise enterprise, ManageUserAccountJPanel panel, EcoSystem business) {
        initComponents();
        this.workContainer = workContainer;
        this.enterprise = enterprise;
        this.business = business;
        populateOrganizationComboBox();
        this.panel = panel;
        lblSatelliteClinicName.setVisible(false);
            txtClinicName.setVisible(false);
        if(enterprise instanceof HospitalEnterprise)
        {
            lblSatelliteClinicName.setVisible(true);
            txtClinicName.setVisible(true);
        }
    }
    
    private void populateOrganizationComboBox(){
        
        comboBoxOrganizationList.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            comboBoxOrganizationList.addItem(organization);
        }
    }
    
    public void populatePersonComboBox(Organization organization){
        comboBoxPersonList.removeAllItems();
        
        for (Person person : organization.getPersonDirectory().getPeopleList()){
            comboBoxPersonList.addItem(person);
        }
    }
    
    
    private boolean checkIfUserAccountExists(String username){
        
        boolean flag= false;
        
        flag = business.getUserAccountDirectory().checkIfUserAccountExists(username );
        
        if (flag == false) {


            flag = business.getCdc().getUserAccountDirectory().checkIfUserAccountExists(username);
            if(flag == false)
            { for(Organization org: business.getCdc().getOrganizationDirectory().getOrganizationList())
            {
                flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                break;
            }
            
            }
            
        }
        if (flag == false) {
                //not a sys,cdc admin
            //check if it is a manufacture enterprise admin
            for(Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory())
            { 
                flag = manufacturer.getUserAccountDirectory().checkIfUserAccountExists(username);
                
                if(flag == false)
                {
                    for(Organization organize: manufacturer.getOrganizationDirectory().getOrganizationList())
                {
                    flag = organize.getUserAccountDirectory().checkIfUserAccountExists(username);
                    if(flag == true)
                        break;
                }
                }
                if(flag == true)
                { 
                    break;
                }
            }
            
                
            
        }if (flag == false) {


            flag = business.getDistributor().getUserAccountDirectory().checkIfUserAccountExists(username);
            if(flag == false)
            { for(Organization org: business.getDistributor().getOrganizationDirectory().getOrganizationList())
            { flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                {
                    
                    break;
                }
            }
            }
            

        }if (flag == false) {

            for (StateNetwork state : business.getStateList()) {
                if(flag == false)
                { flag = state.getLocalHealthDepartment().getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == false)
                {for(Organization org: state.getLocalHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                    if(flag == true)
                    {   
                        break;
                    }
                }
                }
                
                if (flag == false) {
                          

                    for (CityNetwork city : state.getCityList()) {
                        for (Enterprise hospital : city.getEnterpriseDirectory().getEnterpriseDirectory()) {
                            flag = hospital.getUserAccountDirectory().checkIfUserAccountExists(username);
                            if (flag == false) {
                                for (Organization organize : hospital.getOrganizationDirectory().getOrganizationList()) {
                                    flag = organize.getUserAccountDirectory().checkIfUserAccountExists(username);

                                    if (flag == true) {
                                        
                                        break;

                                    }
                                }
                            }
                            else
                            {   
                             
                                
                                break;
                            }
                        
                    if(flag == true)
                    {
                        break;
                    }
                            

                        }
                        if(flag == true)
                {
                    break;
                }
                    }

                } 
                else {
                    
                    break;
                }

            }
        }
        }
    
        
        return flag;
        
    }
    
    
    
    private void populateRoleComboBox(Organization organization){
        comboBoxRoleList.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            comboBoxRoleList.addItem(role);
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblOrganization = new javax.swing.JLabel();
        comboBoxOrganizationList = new javax.swing.JComboBox();
        lblPerson = new javax.swing.JLabel();
        comboBoxPersonList = new javax.swing.JComboBox();
        lblRole = new javax.swing.JLabel();
        comboBoxRoleList = new javax.swing.JComboBox();
        lblUserName = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnCreateUserAccount = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblSatelliteClinicName = new javax.swing.JLabel();
        txtClinicName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 255));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Create User Account");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblOrganization.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblOrganization.setForeground(new java.awt.Color(0, 0, 102));
        lblOrganization.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrganization.setText("Organization:");

        comboBoxOrganizationList.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxOrganizationList.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        comboBoxOrganizationList.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxOrganizationList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxOrganizationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxOrganizationListActionPerformed(evt);
            }
        });

        lblPerson.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPerson.setForeground(new java.awt.Color(0, 0, 102));
        lblPerson.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPerson.setText("Person:");

        comboBoxPersonList.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxPersonList.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        comboBoxPersonList.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxPersonList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblRole.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(0, 0, 102));
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRole.setText("Role:");

        comboBoxRoleList.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxRoleList.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        comboBoxRoleList.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxRoleList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxRoleList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRoleListActionPerformed(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(0, 0, 102));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 102));

        lblPassword.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 102));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 102));

        btnCreateUserAccount.setBackground(new java.awt.Color(0, 0, 102));
        btnCreateUserAccount.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCreateUserAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateUserAccount.setText("Create User Account");
        btnCreateUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserAccountActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 102));
        btnBack.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblSatelliteClinicName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblSatelliteClinicName.setForeground(new java.awt.Color(0, 0, 102));
        lblSatelliteClinicName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSatelliteClinicName.setText("Satellite Clinic Name:");

        txtClinicName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtClinicName.setForeground(new java.awt.Color(0, 0, 102));
        txtClinicName.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCreateUserAccount)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSatelliteClinicName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClinicName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPerson, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRole, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOrganization, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxPersonList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxRoleList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword)
                            .addComponent(comboBoxOrganizationList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblOrganization, lblPassword, lblPerson, lblRole, lblSatelliteClinicName, lblUserName});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBoxOrganizationList, comboBoxPersonList, comboBoxRoleList, txtClinicName, txtPassword, txtUsername});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganization)
                    .addComponent(comboBoxOrganizationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPersonList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPerson))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxRoleList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSatelliteClinicName)
                    .addComponent(txtClinicName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreateUserAccount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreateUserAccount, comboBoxOrganizationList, comboBoxPersonList, comboBoxRoleList, lblOrganization, lblPassword, lblPerson, lblRole, lblSatelliteClinicName, lblUserName, txtClinicName, txtPassword, txtUsername});

    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxOrganizationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxOrganizationListActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization) comboBoxOrganizationList.getSelectedItem();
        if (organization != null){
            populatePersonComboBox(organization);
            populateRoleComboBox(organization);
            if(organization instanceof ClinicOrganization)
            {   ClinicOrganization satOrg = (ClinicOrganization)organization;
                txtClinicName.setText(satOrg.getClincName());
            }
            else
            txtClinicName.setText("");
        }

    }//GEN-LAST:event_comboBoxOrganizationListActionPerformed

    private void btnCreateUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserAccountActionPerformed
        // TODO add your handling code here:

        String userName = txtUsername.getText();
        if(userName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Username cannot be blank. Please try again.");
            return;
        }
        
        
        String password = txtPassword.getText();

        
        boolean PASSWORD_PATTERN = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=~|?])(?=\\S+$).{8,}$", password);
        if(!PASSWORD_PATTERN){
            JOptionPane.showMessageDialog(null, "Please create a strong password. Password should be 8 characters long. It must contain alphanumeric characters in upper and lower case along with at least one special character from - !@#$%^&+=~|? ");
            txtPassword.setText("");
            return;
        }
        
        Organization organization = (Organization) comboBoxOrganizationList.getSelectedItem();
        Person person = (Person) comboBoxPersonList.getSelectedItem();
        Role role = (Role) comboBoxRoleList.getSelectedItem();

        boolean check = checkIfUserAccountExists(userName);

        if(check == true)
        {
            JOptionPane.showMessageDialog(null, "Username alreaday exists, choose different username");
            txtUsername.setText("");
            return;
        }

        for(UserAccount userAcc: organization.getUserAccountDirectory().getUserAccountList())
        {
            if(userAcc.getPerson().equals(person))
            {
                JOptionPane.showMessageDialog(null, "Credentials for the person already exists..!!");
                txtUsername.setText("");
                txtPassword.setText("");
                return;
            }
        }
        organization.getUserAccountDirectory().createUserAccount(userName, password, person, role);

        panel.populateUserAccountTable();
        JOptionPane.showMessageDialog(null, "User Account Created!");
        txtUsername.setText("");
        txtPassword.setText("");
        
    }//GEN-LAST:event_btnCreateUserAccountActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboBoxRoleListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRoleListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRoleListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateUserAccount;
    private javax.swing.JComboBox comboBoxOrganizationList;
    private javax.swing.JComboBox comboBoxPersonList;
    private javax.swing.JComboBox comboBoxRoleList;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPerson;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSatelliteClinicName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtClinicName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
