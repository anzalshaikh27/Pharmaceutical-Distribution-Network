/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.FDA;

import Business.EcoSystem;
import Business.NationalEnterprise.FDA;
import Business.Organization.FDAOrganization;
import Business.Organization.medicalOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
/**
 *
 * @author anzal
 */
public class MedicalOfficerNewJPanel extends javax.swing.JPanel {

    private final JPanel userProcessContainer;
    private final UserAccount userAccount;
    private final EcoSystem business;
    private final FDA cdcEnterprise;
    private final medicalOrganization mo;
    private FDA cdc;
    private FDAOrganization cdcOrg; 
    
    /**
     * Creates new form MedicalOfficerNewJPanel
     * @param userProcessContainer
     * @param userAccount
     * @param business
     * @param cdcEnterprise
     * @param mo
     */
    public MedicalOfficerNewJPanel(JPanel userProcessContainer, UserAccount userAccount,EcoSystem business,FDA cdcEnterprise,medicalOrganization mo ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.cdcEnterprise = cdcEnterprise;
        this.mo = mo;
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
        workContainer = new javax.swing.JPanel();
        mainMenu = new javax.swing.JPanel();
        btnViewDrugDistribution = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setBackground(new java.awt.Color(0, 0, 102));
        jSplitPane1.setDividerLocation(200);

        workContainer.setBackground(new java.awt.Color(204, 255, 255));
        workContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(workContainer);

        mainMenu.setBackground(new java.awt.Color(102, 255, 255));

        btnViewDrugDistribution.setBackground(new java.awt.Color(0, 0, 102));
        btnViewDrugDistribution.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnViewDrugDistribution.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDrugDistribution.setText("View Medicine Distribution");
        btnViewDrugDistribution.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewDrugDistribution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDrugDistributionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainMenuLayout = new javax.swing.GroupLayout(mainMenu);
        mainMenu.setLayout(mainMenuLayout);
        mainMenuLayout.setHorizontalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewDrugDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainMenuLayout.setVerticalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnViewDrugDistribution)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(mainMenu);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDrugDistributionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDrugDistributionActionPerformed
        // TODO add your handling code here:
        DrugStateDistributionJPanel panel = new DrugStateDistributionJPanel(workContainer,userAccount, business, cdc, cdcOrg);
        workContainer.add("VaccineStateDistributionJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnViewDrugDistributionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewDrugDistribution;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JPanel workContainer;
    // End of variables declaration//GEN-END:variables
}
