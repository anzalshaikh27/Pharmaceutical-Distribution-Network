/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserInterface;


import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import captcha.GUI;
import captcha.ImageGenerator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author anzal
 */
public class MainFrame extends javax.swing.JFrame {

    
    private final EcoSystem business;
    private final DB4OUtil dB40Util = DB4OUtil.getInstance();
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        business = dB40Util.retrieveSystem();
        btnLogoutUser.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        loginPanel = new javax.swing.JPanel();
        lblWelcomePage = new javax.swing.JLabel();
        lblUsernameField = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPasswordField = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLoginUser = new javax.swing.JButton();
        btnLogoutUser = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        welcomeScreen = new javax.swing.JPanel();
        lblProjectName = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setBackground(new java.awt.Color(0, 0, 102));
        jSplitPane1.setDividerLocation(210);

        loginPanel.setBackground(new java.awt.Color(51, 255, 255));

        lblWelcomePage.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        lblWelcomePage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcomePage.setText("WELCOME");

        lblUsernameField.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblUsernameField.setText("USERNAME:");

        lblPasswordField.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblPasswordField.setForeground(new java.awt.Color(0, 0, 102));
        lblPasswordField.setText("PASSWORD:");

        btnLoginUser.setBackground(new java.awt.Color(0, 51, 102));
        btnLoginUser.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        btnLoginUser.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginUser.setText("LOGIN");
        btnLoginUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginUserActionPerformed(evt);
            }
        });

        btnLogoutUser.setBackground(new java.awt.Color(0, 0, 102));
        btnLogoutUser.setFont(new java.awt.Font("Comic Sans MS", 2, 14)); // NOI18N
        btnLogoutUser.setForeground(new java.awt.Color(255, 255, 255));
        btnLogoutUser.setText("LOGOUT");
        btnLogoutUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername)
                    .addComponent(lblPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword)
                    .addComponent(btnLoginUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogoutUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblWelcomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(lblUsernameField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPasswordField)
                .addGap(16, 16, 16)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(btnLoginUser)
                .addGap(18, 18, 18)
                .addComponent(btnLogoutUser)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        loginPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLoginUser, btnLogoutUser, lblPasswordField, lblUsernameField, txtPassword, txtUsername});

        jSplitPane1.setLeftComponent(loginPanel);

        container.setLayout(new java.awt.CardLayout());

        welcomeScreen.setBackground(new java.awt.Color(204, 255, 255));

        lblProjectName.setBackground(new java.awt.Color(255, 255, 255));
        lblProjectName.setFont(new java.awt.Font("Segoe UI Black", 3, 48)); // NOI18N
        lblProjectName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProjectName.setText("PHARMACEUTICAL DISTRIBUTION NETWORK");

        lblImage.setBackground(new java.awt.Color(0, 0, 0));
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/giphy1.gif"))); // NOI18N

        javax.swing.GroupLayout welcomeScreenLayout = new javax.swing.GroupLayout(welcomeScreen);
        welcomeScreen.setLayout(welcomeScreenLayout);
        welcomeScreenLayout.setHorizontalGroup(
            welcomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(welcomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 1337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        welcomeScreenLayout.setVerticalGroup(
            welcomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeScreenLayout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        container.add(welcomeScreen, "card2");

        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   


    
    private void btnLoginUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginUserActionPerformed
        // TODO add your handling code here:
       
        String username = txtUsername.getText();
        if(username.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter Username..!!");
            return;
            
        }
        char[] passwordCharArray = txtPassword.getPassword();
        String password = String.valueOf(passwordCharArray);
        if(password.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter Password..!!");
            return;
            
        }

        Enterprise isEnterprise = null;
        Organization organization = null;
        StateNetwork stateNetwork = null;

        UserAccount userAccount = business.getUserAccountDirectory().authenticateUser(username, password);
        
        if (userAccount == null) {
           
            userAccount = business.getCdc().getUserAccountDirectory().authenticateUser(username, password);
            if(userAccount == null)
            { for(Organization org: business.getCdc().getOrganizationDirectory().getOrganizationList())
            {
                userAccount = org.getUserAccountDirectory().authenticateUser(username, password);
            if(userAccount != null)
            {organization = org;
            break;
            }
            }
            }
            if(userAccount != null)
            {isEnterprise = business.getCdc();
                
            }
        }
        if (userAccount == null) {
            for(Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory())
            { 
                userAccount = manufacturer.getUserAccountDirectory().authenticateUser(username, password);
                
                if(userAccount == null)
                {
                    for(Organization org: manufacturer.getOrganizationDirectory().getOrganizationList())
                {
                    userAccount = org.getUserAccountDirectory().authenticateUser(username, password);
                    if(userAccount != null)
                        break;
                }
                }
                if(userAccount != null)
                { isEnterprise = manufacturer;
                    break;
                }
            }
 
        }if (userAccount == null) {
              
            userAccount = business.getDistributor().getUserAccountDirectory().authenticateUser(username, password);
            if(userAccount == null)
            { for(Organization org: business.getDistributor().getOrganizationDirectory().getOrganizationList())
            { userAccount = org.getUserAccountDirectory().authenticateUser(username, password);
                if(userAccount != null)
                {
                    organization = org;
                    break;
                }
            }
            }
            if(userAccount != null)
                isEnterprise = business.getDistributor();

        }if (userAccount == null) {
            for (StateNetwork state : business.getStateList()) {
                if(userAccount==null)
                { userAccount = state.getLocalHealthDepartment().getUserAccountDirectory().authenticateUser(username, password);
                if(userAccount == null)
                {for(Organization org: state.getLocalHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {userAccount = org.getUserAccountDirectory().authenticateUser(username, password);
                    if(userAccount != null)
                    {   stateNetwork = state;
                        organization =org;
                        break;
                    }
                }
                }
                if(userAccount != null)
                {
                    isEnterprise = state.getLocalHealthDepartment();
                    
                }
                if (userAccount == null) {
                    
                  for (CityNetwork city : state.getCityList()) {
                        for (Enterprise hospital : city.getEnterpriseDirectory().getEnterpriseDirectory()) {
                            userAccount = hospital.getUserAccountDirectory().authenticateUser(username, password);
                            if (userAccount == null) {
                                for (Organization o : hospital.getOrganizationDirectory().getOrganizationList()) {
                                    userAccount = o.getUserAccountDirectory().authenticateUser(username, password);

                                    if (userAccount != null) {
                                        stateNetwork = state;
                                        isEnterprise = hospital;
                                        organization = o;
                                        break;

                                    }
                                }
                            }
                            else
                            {  
                               
                                isEnterprise = hospital;
                                break;
                            }
                           
                    if(organization != null)
                    {
                        break;
                    }
                            

                        }
                        if(isEnterprise != null)
                {
                    break;
                }
                    }

                } 
                else {
                    isEnterprise = state.getLocalHealthDepartment();
                    break;
                }

            }
        }
        }
       
        if(userAccount == null)
        {
            JOptionPane.showMessageDialog(null, "Please enter correct credentials..!!");
            txtUsername.setText("");
            txtPassword.setText("");
        }
        
        else
        {
           
            CardLayout layout = (CardLayout)container.getLayout();
            container.add("WorkArea", userAccount.getRole().createWorkArea(container, userAccount,isEnterprise, organization, business, stateNetwork));
            layout.next(container);
            
            btnLoginUser.setEnabled(false);
            btnLogoutUser.setEnabled(true);
                    
        }
        
        
    }//GEN-LAST:event_btnLoginUserActionPerformed

    private void btnLogoutUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutUserActionPerformed
        // TODO add your handling code here:
        
        container.removeAll();
        txtUsername.setText(null);
        txtPassword.setText(null);
        
        btnLoginUser.setEnabled(true);
        btnLogoutUser.setEnabled(false);
        
        JPanel blankJP = new JPanel();
        //blankJP.setBackground(new java.awt.Color(102, 153, 255));
        //container.add("blank", blankJP);
        container.add(welcomeScreen, "welcomeScreen");
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.show(container,"welcomeScreen");
        
        dB40Util.storeSystem(business);
    }//GEN-LAST:event_btnLogoutUserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginUser;
    private javax.swing.JButton btnLogoutUser;
    private javax.swing.JPanel container;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPasswordField;
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JLabel lblUsernameField;
    private javax.swing.JLabel lblWelcomePage;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPanel welcomeScreen;
    // End of variables declaration//GEN-END:variables

//    private void displayCaptchaLogic() {
//        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
//        
//        jLabel1.setIcon(img);
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}