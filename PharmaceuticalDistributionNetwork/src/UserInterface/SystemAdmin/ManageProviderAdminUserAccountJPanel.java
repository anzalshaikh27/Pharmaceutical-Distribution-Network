

package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Person.EnterpriseAdminPerson;
import Business.Role.EnterpriseAdminRole;
import Business.Role.Role.RoleType;
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
public class ManageProviderAdminUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProviderAdminUserAccountJPanel
     */
    
    private final JPanel workContainer;
    private final EcoSystem business;
    public ManageProviderAdminUserAccountJPanel(JPanel workContainer, EcoSystem business) {
        initComponents();
        this.workContainer = workContainer;
        this.business = business;
        populateTable();
        comboBoxProviderList.removeAllItems();
        populateProviderJComboBox();
    }
    
    private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblProviderAdminDetails.getModel();
        model.setRowCount(0);
        
        for(StateNetwork state : business.getStateList())
        {
            for(CityNetwork city : state.getCityList())
            {
                for(Enterprise hospital :city.getEnterpriseDirectory().getEnterpriseDirectory())
                {   
                    for(UserAccount ua : hospital.getUserAccountDirectory().getUserAccountList())
                    {   
                        if(ua.getRole() instanceof EnterpriseAdminRole)
                        {Object[] row = new Object[4];
                        row[0] = ua;
                        row[1] = ua.getPassword();
                        row[2] = hospital;
                        row[3] = ua.getPerson().getFirstName()+ " " + ua.getPerson().getLastName();
                        model.addRow(row);
                        }
                    }
                }
            }
            
        }
        
        
        
    }
    
    private void populateProviderJComboBox(){
        
        comboBoxProviderList.removeAllItems();
        for(StateNetwork state : business.getStateList())
        {
            for(CityNetwork city : state.getCityList())
            {
                for(Enterprise hospital :city.getEnterpriseDirectory().getEnterpriseDirectory())
                {   
                    
                    comboBoxProviderList.addItem(hospital);
                }
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
        tblProviderAdminDetails = new javax.swing.JTable();
        btnRemoveAdmin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblNewAdmin = new javax.swing.JLabel();
        lblProviderEnterprise = new javax.swing.JLabel();
        comboBoxProviderList = new javax.swing.JComboBox();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnAddAdmin = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 255));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Provider Admins");

        tblProviderAdminDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblProviderAdminDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Enterprise Name", "Person name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProviderAdminDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProviderAdminDetails);
        if (tblProviderAdminDetails.getColumnModel().getColumnCount() > 0) {
            tblProviderAdminDetails.getColumnModel().getColumn(0).setResizable(false);
            tblProviderAdminDetails.getColumnModel().getColumn(1).setResizable(false);
            tblProviderAdminDetails.getColumnModel().getColumn(2).setResizable(false);
            tblProviderAdminDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        btnRemoveAdmin.setBackground(new java.awt.Color(0, 51, 153));
        btnRemoveAdmin.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        btnRemoveAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveAdmin.setText("Remove Admin");
        btnRemoveAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAdminActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        lblNewAdmin.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblNewAdmin.setForeground(new java.awt.Color(0, 0, 102));
        lblNewAdmin.setText("Add New Admin:");

        lblProviderEnterprise.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblProviderEnterprise.setForeground(new java.awt.Color(0, 0, 102));
        lblProviderEnterprise.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProviderEnterprise.setText("Provider Enterprise:");

        comboBoxProviderList.setBackground(new java.awt.Color(0, 51, 153));
        comboBoxProviderList.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        comboBoxProviderList.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxProviderList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUserName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(0, 0, 102));
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("Username:");

        lblPassword.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 102));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password:");

        txtUserName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        btnAddAdmin.setBackground(new java.awt.Color(0, 51, 153));
        btnAddAdmin.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        btnAddAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAddAdmin.setText("Add Admin");
        btnAddAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdminActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 51, 153));
        btnBack.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblFirstName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(0, 0, 102));
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("First Name:");

        txtFirstName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        lblLastName.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(0, 0, 102));
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName.setText("Last Name:");

        txtLastName.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemoveAdmin))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserName)
                            .addComponent(lblPassword)
                            .addComponent(lblNewAdmin)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProviderEnterprise)
                                    .addComponent(lblFirstName)
                                    .addComponent(lblLastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxProviderList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUserName)
                                    .addComponent(txtPassword)
                                    .addComponent(txtFirstName)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblFirstName, lblLastName, lblPassword, lblProviderEnterprise, lblUserName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblNewAdmin)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProviderEnterprise)
                    .addComponent(comboBoxProviderList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddAdmin)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddAdmin, comboBoxProviderList, txtFirstName, txtLastName, txtPassword, txtUserName});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAdminActionPerformed
        // TODO add your handling code here:
         int row = tblProviderAdminDetails.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a UserAccount from table");
            return;
        }
        
        UserAccount ua = (UserAccount)tblProviderAdminDetails.getValueAt(row, 0);
        HospitalEnterprise hospital = (HospitalEnterprise)tblProviderAdminDetails.getValueAt(row, 2);
         hospital.getUserAccountDirectory().removeUserAccount(ua);
        
        populateTable();
    }//GEN-LAST:event_btnRemoveAdminActionPerformed

    private void btnAddAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdminActionPerformed
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        HospitalEnterprise provider = (HospitalEnterprise) comboBoxProviderList.getSelectedItem();
        String username = txtUserName.getText();
        if(username.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a Username!");
            return;
        }
        String password = txtPassword.getText();
        if(password.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a Password!");
            return;
        }
        
        String firstName = txtFirstName.getText();
        if(firstName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a first Name!");
            return;
        }
        String lastName = txtLastName.getText();
        if(lastName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a last Name!");
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
         
         
           String passwordCheck = txtPassword.getText();

        
        boolean PASSWORD_PATTERN = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=~|?])(?=\\S+$).{8,}$", passwordCheck);
        if(!PASSWORD_PATTERN){
            JOptionPane.showMessageDialog(null, "Please create a strong password. Password should be 8 characters long. It must contain alphanumeric characters in upper and lower case along with at least one special character from - !@#$%^&+=~|? ");
            txtPassword.setText("");
            return;
        }
        boolean check = checkIfUserAccountExists(username);
        if(check == true)
        {
            JOptionPane.showMessageDialog(null, "Username exists, please choose a differnt username!");
            return;
            
        }
        
        
        EnterpriseAdminPerson admin = (EnterpriseAdminPerson)provider.getPersonDirectory().createPerson(firstName, lastName, RoleType.EnterpriseAdmin);
        provider.getUserAccountDirectory().createUserAccount(username, password, admin, new EnterpriseAdminRole());
        
        populateTable();
    }//GEN-LAST:event_btnAddAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdmin;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveAdmin;
    private javax.swing.JComboBox comboBoxProviderList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblNewAdmin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblProviderEnterprise;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblProviderAdminDetails;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
