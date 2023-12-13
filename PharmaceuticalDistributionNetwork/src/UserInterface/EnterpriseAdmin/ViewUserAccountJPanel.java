/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.EnterpriseAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author anzal
 */
public class ViewUserAccountJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;
    private final Enterprise enterprise;
    private final ManageUserAccountJPanel panel;
    private final UserAccount userAcc;
    private final Organization organize;
    private final EcoSystem business;
    /**
     * Creates new form ViewUserAccountJPanel
     * @param workContainer
     * @param enterprise
     * @param panel
     * @param userAcc
     * @param organize
     * @param business
     */
    public ViewUserAccountJPanel(JPanel workContainer, Enterprise enterprise, ManageUserAccountJPanel panel, UserAccount userAcc,Organization organize, EcoSystem business ) {
        initComponents();
        this.workContainer = workContainer;
        this.enterprise = enterprise;
        this.panel = panel;
        this.userAcc= userAcc;
        this.organize=organize;
        this.business = business;
        if(organize == null)
        txtOrganization.setText("Enterprise Admin");
        else
          txtOrganization.setText(String.valueOf(organize)); 
        txtPersonName.setText(String.valueOf(userAcc.getPerson()));
        txtRole.setText(String.valueOf(userAcc.getRole()));
        txtUserName.setText(userAcc.getUsername());
        txtPassword.setText(userAcc.getPassword());
        
    }
    
     private boolean checkIfUserAccountExists(String username){
        
        boolean flag= false;
        
        flag = business.getUserAccountDirectory().checkIfUserAccountExists(username );
        
        if (flag == false) {
          

            flag = business.getCdc().getUserAccountDirectory().checkIfUserAccountExists(username);
            if(flag == false)
            { for(Organization organize: business.getCdc().getOrganizationDirectory().getOrganizationList())
            {
                flag = organize.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                break;
            }
            
            }
            
        }
        if (flag == false) {
           
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
            { for(Organization organize: business.getDistributor().getOrganizationDirectory().getOrganizationList())
            { flag = organize.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                {
                    
                    break;
                }
            }
            }
            

        }if (flag == false) {
             
            for (StateNetwork stateNet : business.getStateList()) {
                if(flag == false)
                { flag = stateNet.getLocalHealthDepartment().getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == false)
                {for(Organization organize: stateNet.getLocalHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {flag = organize.getUserAccountDirectory().checkIfUserAccountExists(username);
                    if(flag == true)
                    {   
                        break;
                    }
                }
                }
                
                if (flag == false) {
                            

                    for (CityNetwork city : stateNet.getCityList()) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblViewUpdateUserAccount = new javax.swing.JLabel();
        btnUpdateUserAccount = new javax.swing.JButton();
        lblOrganization = new javax.swing.JLabel();
        lblPerson = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        txtOrganization = new javax.swing.JTextField();
        txtPersonName = new javax.swing.JTextField();
        txtRole = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 255));

        lblUsername.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 102));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("Username:");

        txtUserName.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnBack.setBackground(new java.awt.Color(0, 0, 102));
        btnBack.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 102));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        lblViewUpdateUserAccount.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblViewUpdateUserAccount.setForeground(new java.awt.Color(0, 0, 102));
        lblViewUpdateUserAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViewUpdateUserAccount.setText("View/Update User Account");
        lblViewUpdateUserAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnUpdateUserAccount.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdateUserAccount.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnUpdateUserAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateUserAccount.setText("Update User Account");
        btnUpdateUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserAccountActionPerformed(evt);
            }
        });

        lblOrganization.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblOrganization.setForeground(new java.awt.Color(0, 0, 102));
        lblOrganization.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrganization.setText("Organization:");

        lblPerson.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPerson.setForeground(new java.awt.Color(0, 0, 102));
        lblPerson.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPerson.setText("Person:");

        lblRole.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(0, 0, 102));
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRole.setText("Role:");

        txtOrganization.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtOrganization.setEnabled(false);

        txtPersonName.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtPersonName.setEnabled(false);

        txtRole.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtRole.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblViewUpdateUserAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 450, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrganization)
                            .addComponent(lblPerson)
                            .addComponent(lblRole)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateUserAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUserName)
                            .addComponent(txtPassword)
                            .addComponent(txtOrganization)
                            .addComponent(txtPersonName)
                            .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblOrganization, lblPassword, lblPerson, lblRole, lblUsername});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblViewUpdateUserAccount)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganization)
                    .addComponent(txtOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerson)
                    .addComponent(txtPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRole)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUpdateUserAccount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserAccountActionPerformed
        // TODO add your handling code here:

        String userName = txtUserName.getText();
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
        boolean check = checkIfUserAccountExists(userName);

        if(check == true)
        {
            JOptionPane.showMessageDialog(null, "Username exists. Please choose another username.");
            return;
        }

        userAcc.setUsername(userName);
        userAcc.setPassword(password);

        panel.populateUserAccountTable();
        JOptionPane.showMessageDialog(null, "User details updated successfully!");
        txtUserName.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnUpdateUserAccountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdateUserAccount;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPerson;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblViewUpdateUserAccount;
    private javax.swing.JTextField txtOrganization;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPersonName;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
