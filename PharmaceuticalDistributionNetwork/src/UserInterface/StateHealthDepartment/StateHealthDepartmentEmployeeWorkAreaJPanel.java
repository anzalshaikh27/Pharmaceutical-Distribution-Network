/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.StateHealthDepartment;

import Business.EcoSystem;
import Business.Enterprise.StateHealthDepartment;
import Business.Network.StateNetwork;
import Business.Organization.SHDImmuneOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author zakir
 */
public class StateHealthDepartmentEmployeeWorkAreaJPanel extends javax.swing.JPanel {

   
    private final JPanel userProcessContainer;
    private final UserAccount userAccount;
    private final StateHealthDepartment enterprise;
    private final SHDImmuneOrganization lhdOrg;
    private final EcoSystem business;
    private final StateNetwork state;
    
    public StateHealthDepartmentEmployeeWorkAreaJPanel(JPanel userProcessContainer,UserAccount userAccount, StateHealthDepartment enterprise, SHDImmuneOrganization lhdOrg,EcoSystem business, StateNetwork state  ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.lhdOrg = lhdOrg;
        this.business = business;
        this.state = state;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnEnterStatePopulation = new javax.swing.JButton();
        btnOrderApprove = new javax.swing.JButton();
        lbl2 = new javax.swing.JLabel();
        workContainer = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setBackground(new java.awt.Color(0, 0, 102));
        jSplitPane1.setDividerLocation(240);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        btnEnterStatePopulation.setBackground(new java.awt.Color(0, 0, 102));
        btnEnterStatePopulation.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnEnterStatePopulation.setForeground(new java.awt.Color(255, 255, 255));
        btnEnterStatePopulation.setText("Enter State Population");
        btnEnterStatePopulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterStatePopulationActionPerformed(evt);
            }
        });

        btnOrderApprove.setBackground(new java.awt.Color(0, 0, 102));
        btnOrderApprove.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnOrderApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnOrderApprove.setText("Order Approvals");
        btnOrderApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderApproveActionPerformed(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(0, 0, 102));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("State Health Department");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnterStatePopulation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrderApprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl2)
                .addGap(80, 80, 80)
                .addComponent(btnEnterStatePopulation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOrderApprove)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        workContainer.setBackground(new java.awt.Color(204, 255, 255));
        workContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(workContainer);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderApproveActionPerformed
        // TODO add your handling code here:
         OrderApprovalDetailsJPanel panel = new OrderApprovalDetailsJPanel(workContainer, userAccount, enterprise,lhdOrg, state, business);
        workContainer.add("OrderApprovalsJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
        
    }//GEN-LAST:event_btnOrderApproveActionPerformed

    private void btnEnterStatePopulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterStatePopulationActionPerformed
        // TODO add your handling code here:
        EnterStatePopulationJPanel panel = new EnterStatePopulationJPanel(workContainer, state);
        workContainer.add("EnterStatePopulationJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
        
    }//GEN-LAST:event_btnEnterStatePopulationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnterStatePopulation;
    private javax.swing.JButton btnOrderApprove;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JPanel workContainer;
    // End of variables declaration//GEN-END:variables
}
