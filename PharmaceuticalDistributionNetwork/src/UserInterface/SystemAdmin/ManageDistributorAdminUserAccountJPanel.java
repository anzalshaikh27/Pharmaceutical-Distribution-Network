
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Person.EnterpriseAdminPerson;
import Business.Role.EnterpriseAdminRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sanal
 */
public class ManageDistributorAdminUserAccountJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;
    private final EcoSystem business;
    /**
     * Creates new form ManageDistributorUserAccountJPanel
     * @param workContainer
     * @param business
     */
    public ManageDistributorAdminUserAccountJPanel(JPanel workContainer, EcoSystem business) {
        initComponents();
        this.workContainer = workContainer;
        this.business = business;
        populateTable();
    }
     private void populateTable(){
        int rowCount = tblDistributorAdmin.getRowCount();
         DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblDistributorAdmin.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        for(UserAccount ua : business.getDistributor().getUserAccountDirectory().getUserAccountList()){
            
            if(ua.getRole() instanceof EnterpriseAdminRole){
                Object[] row = new Object[3];
                row[0]=ua;
                row[1]=ua.getPassword();
                row[2]=String.valueOf(ua.getPerson().getFirstName()+ " "+ ua.getPerson().getLastName());
            
            defaulttabelmodel.addRow(row);
            
                
                
                
            }
            
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

        lblTitle = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnback = new javax.swing.JButton();
        btnRemoveAdmin = new javax.swing.JButton();
        btnCreateDistributorAdmin = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDistributorAdmin = new javax.swing.JTable();
        lblPassword = new javax.swing.JLabel();
        lblAdminList = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Distributor Admin");

        lblLastName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(0, 0, 102));
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName.setText("Last Name:");

        txtFirstName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        lblFirstName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(0, 0, 102));
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("First Name:");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        btnback.setBackground(new java.awt.Color(0, 51, 153));
        btnback.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("<");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnRemoveAdmin.setBackground(new java.awt.Color(0, 51, 153));
        btnRemoveAdmin.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        btnRemoveAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveAdmin.setText("Remove Admin");
        btnRemoveAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAdminActionPerformed(evt);
            }
        });

        btnCreateDistributorAdmin.setBackground(new java.awt.Color(0, 51, 153));
        btnCreateDistributorAdmin.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        btnCreateDistributorAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateDistributorAdmin.setText("Create Admin");
        btnCreateDistributorAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDistributorAdminActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        tblDistributorAdmin.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblDistributorAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Person"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDistributorAdmin.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDistributorAdmin);

        lblPassword.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 102));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password:");

        lblAdminList.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblAdminList.setForeground(new java.awt.Color(0, 0, 102));
        lblAdminList.setText("List of Admins:");

        txtUserName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        lblUsername.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 102));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText("UserName:");

        txtLastName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFirstName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirstName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLastName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsername)
                                    .addComponent(lblPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword)
                                    .addComponent(txtUserName)))
                            .addComponent(btnCreateDistributorAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addComponent(btnRemoveAdmin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdminList)
                            .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblFirstName, lblLastName, lblPassword, lblUsername});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnback)
                .addGap(12, 12, 12)
                .addComponent(lblAdminList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemoveAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateDistributorAdmin)
                        .addContainerGap())
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnRemoveAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAdminActionPerformed
        // TODO add your handling code here:
        int row = tblDistributorAdmin.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select an Admin from table");
            return;
        }

        UserAccount ua = (UserAccount)tblDistributorAdmin.getValueAt(row, 0);
        business.getDistributor().getUserAccountDirectory().removeUserAccount(ua);
        populateTable();
    }//GEN-LAST:event_btnRemoveAdminActionPerformed

    private void btnCreateDistributorAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDistributorAdminActionPerformed
        // TODO add your handling code here:

        String firstName = txtFirstName.getText();
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        if(firstName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter First Name!");
            return;
        }
        String lastName = txtLastName.getText();
        if(lastName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter last Name!");
            return;
        }
        String username = txtUserName.getText();
        if(username.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter Username!");
            return;
        }
        String password = txtPassword.getText();
        if(password.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter Password!");
            return;
        }
          String passwordCheck = txtPassword.getText();

        
        boolean PASSWORD_PATTERN = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=~|?])(?=\\S+$).{8,}$", passwordCheck);
        if(!PASSWORD_PATTERN){
            JOptionPane.showMessageDialog(null, "Please create a strong password. Password should be 8 characters long. It must contain alphanumeric characters in upper and lower case along with at least one special character from - !@#$%^&+=~|? ");
            txtPassword.setText("");
            return;
        }
        
         if (!(pattern.matcher(firstName.trim()).matches())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid first name");
            return;
        } 
         
        if (!(pattern.matcher(lastName.trim()).matches())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid last name");
            return;
        } 
        
        if (!(pattern.matcher(username.trim()).matches())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid user name");
            return;
        } 
         
        
        
 
        boolean check = checkIfUserAccountExists(username);

        if(check == true)
        {
            JOptionPane.showMessageDialog(null, "Username exists, please choose a different username!");
            return;
        }

        EnterpriseAdminPerson admin = (EnterpriseAdminPerson) business.getDistributor().getPersonDirectory().createPerson(firstName, lastName, Role.RoleType.EnterpriseAdmin);

        business.getDistributor().getUserAccountDirectory().createUserAccount(username, password, admin, new EnterpriseAdminRole());

        populateTable();
    }//GEN-LAST:event_btnCreateDistributorAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateDistributorAdmin;
    private javax.swing.JButton btnRemoveAdmin;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdminList;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblDistributorAdmin;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
