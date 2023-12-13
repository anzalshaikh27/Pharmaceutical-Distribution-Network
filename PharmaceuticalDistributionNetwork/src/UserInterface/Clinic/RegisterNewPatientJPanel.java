/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Clinic;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.ClinicOrganization;
import Business.Person.Person;
import Business.Role.PatientRole;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sanal
 */
public class RegisterNewPatientJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;

    private final HospitalEnterprise hospital;
    private final UserAccount userAccount;
    private final ClinicOrganization clinicOrg;
    private final EcoSystem business;
    /**
     * Creates new form RegisterNewPatientJPanel
     * @param workContainer
     * @param hospital
     * @param clinicOrg
     * @param userAccount
     * @param business
     */
    public RegisterNewPatientJPanel(JPanel workContainer, HospitalEnterprise hospital, ClinicOrganization clinicOrg, UserAccount userAccount , EcoSystem business) {
        initComponents();
         this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.clinicOrg = clinicOrg;
        populateTable();
    }
    
    
     private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblNewPatientDetails.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : hospital.getOrganizationDirectory().getOrganizationList())
        {   if(organization instanceof PatientOrganization)
            for(Person person: organization.getPersonDirectory().getPeopleList())
            {
                Object[] row = new Object[5];
            row[0] = person;
            row[1] = person.getEmail();
            row[2] = person.getPhone();
            row[3] = person.getDateOfBirth();
            row[4] = organization;
           
            
            model.addRow(row);
            }
        }
        
        
    }
     
      private boolean checkIfUserAccountExists(String username){
        
        boolean flag= false;
        
        flag = business.getUserAccountDirectory().checkIfUserAccountExists(username );
        
        if (flag == false) {
            //not a sys admin
            //check if it is a cdc enterprise admin

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
                    for(Organization org: manufacturer.getOrganizationDirectory().getOrganizationList())
                {
                    flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
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
                //not a sys,cdc,manufacturer admin
            //check if it is a distributor enterprise admin

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
                //not a sys,cdc,manufacturer,distributor admin
            //check if it is a PHD enterprise admin
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
                              //not a sys,cdc,manufacturer,distributor,PHD admin
                    //check if it is a Provider/hospital enterprise admin

                    for (CityNetwork city : state.getCityList()) {
                        for (Enterprise hospital : city.getEnterpriseDirectory().getEnterpriseDirectory()) {
                            flag = hospital.getUserAccountDirectory().checkIfUserAccountExists(username);
                            if (flag == false) {
                                for (Organization o : hospital.getOrganizationDirectory().getOrganizationList()) {
                                    flag = o.getUserAccountDirectory().checkIfUserAccountExists(username);

                                    if (flag == true) {
                                        
                                        break;

                                    }
                                }
                            }
                            else
                            {   
                                //find the useraccount as enterprise admin
                                
                                break;
                            }
                            // check if we already found the ord user account
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNewPatientDetails = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblNewPatient = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnCreatePatient = new javax.swing.JButton();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblAccountDetails = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lblPhone = new javax.swing.JLabel();
        lblPersonalInfo = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jDateDOB = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(204, 255, 255));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Register New Patient");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblNewPatientDetails.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblNewPatientDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person Name", "Email", "Phone Number", "Date of Birth", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNewPatientDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblNewPatientDetails);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        lblNewPatient.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblNewPatient.setForeground(new java.awt.Color(0, 0, 102));
        lblNewPatient.setText("Create New Patient:");

        btnCreatePatient.setBackground(new java.awt.Color(0, 0, 102));
        btnCreatePatient.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCreatePatient.setForeground(new java.awt.Color(255, 255, 255));
        btnCreatePatient.setText("Create Patient");
        btnCreatePatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePatientActionPerformed(evt);
            }
        });

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 102));

        lblAccountDetails.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblAccountDetails.setForeground(new java.awt.Color(0, 0, 102));
        lblAccountDetails.setText("Account details");

        lblPassword.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 102));
        lblPassword.setText("Password:");

        lblUsername.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 102));
        lblUsername.setText("UserName:");

        lblDOB.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblDOB.setForeground(new java.awt.Color(0, 0, 102));
        lblDOB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDOB.setText("Date of Birth:");

        jSeparator5.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 102));

        lblPhone.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(0, 0, 102));
        lblPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhone.setText("Phone:");

        lblPersonalInfo.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPersonalInfo.setForeground(new java.awt.Color(0, 0, 102));
        lblPersonalInfo.setText("Personal Information:");

        lblEmail.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 0, 102));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email:");

        lblLastName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(0, 0, 102));
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName.setText("Last Name:");

        lblFirstName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(0, 0, 102));
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("First Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPersonalInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFirstName)
                                    .addComponent(lblLastName)
                                    .addComponent(lblEmail))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtLastName)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword)
                            .addComponent(lblUsername)
                            .addComponent(lblAccountDetails))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUserName)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnCreatePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewPatient)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPhone)
                                    .addComponent(lblDOB))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(jDateDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblPassword, lblUsername});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblDOB, lblEmail, lblFirstName, lblLastName, lblPhone});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNewPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPersonalInfo)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccountDetails)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFirstName)
                            .addComponent(lblUsername)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(btnCreatePatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDOB))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jDateDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePatientActionPerformed
        // TODO add your handling code here:
        try{
            Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String phoneText = txtPhone.getText();
            long phone = Long.parseLong(txtPhone.getText());
            Date dob = jDateDOB.getDate();
            String username = txtUserName.getText();
            String password = txtPassword.getText();
            PatientOrganization patientOrg = null;
            for(Organization org : hospital.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof PatientOrganization)
                {
                    patientOrg = (PatientOrganization)org;
                }
                
            }
            if(firstName.trim().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "First name empty");
                return;
            }
            if(!(pattern.matcher(firstName.trim()).matches()))
            {
                JOptionPane.showMessageDialog(null, "First name cannot be a number");
                return;
            }

            if(lastName.trim().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Last name empty");
                return;
            }
            if(!(pattern.matcher(lastName.trim()).matches()))
            {
                JOptionPane.showMessageDialog(null, "Last name cannot be a number");
                return;
            }
            
            LocalDate dobValue = jDateDOB.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // convert JDateChooser to LocalDate
            LocalDate today = LocalDate.now();
            
            if (dobValue == null) {
            JOptionPane.showMessageDialog(null, "Please enter your date of birth.");
            return;
            }  else if (dobValue.isAfter(today)) {
                JOptionPane.showMessageDialog(null, "Invalid date of birth. Date cannot be in the future.");
                return;
            } else if (dobValue.isEqual(today)) {
            JOptionPane.showMessageDialog(null, "Invalid date of birth. Date cannot be today.");
            return;
            }  
                  
                  
                  
            
            Person patient = patientOrg.getPersonDirectory().createPerson(firstName, lastName, RoleType.Patient);
                
            patient.setDateOfBirth(dob);
            if(email.trim().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Email empty");
                return;
            }
            String emailvalidate = "[a-z0-9!-_.&#*]{2,100}[@][a-z]{3,100}[.][a-z]{3}";
            Pattern p;
            p = Pattern.compile(emailvalidate);
              if (!(p.matcher(email).matches()))
              {
                  JOptionPane.showMessageDialog(null, "Email is not in correct");
              }

            patient.setEmail(email);
            if(phoneText.trim().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Phone empty!");
                return;
            }
            int a = phoneText.trim().length();
            if (a < 10)
            {
                JOptionPane.showMessageDialog(null, "Phone is not in the correct length!");
                return;
            }

            patient.setPhone(phone);
            if(username.trim().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Username empty!");
                return;
            }
            
            
            
            if(password.trim().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Password empty!");
                return;
            }
            
            boolean check = checkIfUserAccountExists(username);
            if(check == true)
            {
                JOptionPane.showMessageDialog(null, "Username already exists, please select a new username!");
                return;
            }
            
            patientOrg.getUserAccountDirectory().createUserAccount(username, password, patient,new PatientRole());
            populateTable();

            JOptionPane.showMessageDialog(null, "Patient Added!");

        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter numeric value for Phone");
            //return;
        }

    }//GEN-LAST:event_btnCreatePatientActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePatient;
    private com.toedter.calendar.JDateChooser jDateDOB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblAccountDetails;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblNewPatient;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPersonalInfo;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblNewPatientDetails;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
