/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Distributor;

import Business.EcoSystem;
import Business.NationalEnterprise.Distributor;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProviderVaccineOrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author zakir
 */
public class ManageProviderOrdersJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;  
    private final Distributor enterprise;
    private final UserAccount userAccount;
    private final DistributorOrganization distributorOrg;
    private final EcoSystem business;
    /**
     * Creates new form ManageProviderOrdersJPanel
     * @param workContainer
     * @param enterprise
     * @param distributorOrg
     * @param userAccount
     * @param business
     */
    public ManageProviderOrdersJPanel(JPanel workContainer,Distributor enterprise,DistributorOrganization distributorOrg, UserAccount userAccount,EcoSystem business) {
        initComponents();
         this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.distributorOrg = distributorOrg;
        this.business = business;
        this.workContainer = workContainer;
        populateContractTable();
        populateAdhocTable();
    }
    
    private void populateContractTable(){
        
        DefaultTableModel defaulttabelmodel = (DefaultTableModel) tblControlOrder.getModel();
        defaulttabelmodel.setRowCount(0);
        
         DistributorOrganization distOrg = null;
         
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof DistributorOrganization)
        {   distOrg = (DistributorOrganization)org;
            for(WorkRequest workRequest : distOrg.getWorkQueue().getWorkRequestList())
            {   if(workRequest instanceof ProviderVaccineOrderWorkRequest)
            {ProviderVaccineOrderWorkRequest vaccineOrderWR = (ProviderVaccineOrderWorkRequest)workRequest;
                if(vaccineOrderWR.isasReq()== false)
                {
                Object[] row = new Object[9];
            
                row[0] = vaccineOrderWR;
                row[1] = getContractDetails(vaccineOrderWR);
                row[2] = vaccineOrderWR.getEnterprise();
                row[3] = vaccineOrderWR.getreqState();
                row[4] = vaccineOrderWR.getSender();
                row[5] = vaccineOrderWR.getdeliDate();
                row[6] = vaccineOrderWR.getStatus();
                row[7] = vaccineOrderWR.getReceiver();
                row[8] = vaccineOrderWR.getResolveDate();               
                defaulttabelmodel.addRow(row);
                
                }
            }
            }
        }
        
        
        
        
    }
        
        
    }
    
    private void populateAdhocTable(){
        
        DefaultTableModel defaulttabelmodel = (DefaultTableModel) tblAsRequiredOrders.getModel();
        defaulttabelmodel.setRowCount(0);
        
         DistributorOrganization distOrg = null;
         
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof DistributorOrganization)
        {   distOrg = (DistributorOrganization)org;
            for(WorkRequest workRequest : distOrg.getWorkQueue().getWorkRequestList())
            {   if(workRequest instanceof ProviderVaccineOrderWorkRequest)
            {ProviderVaccineOrderWorkRequest vaccineOrderWR = (ProviderVaccineOrderWorkRequest)workRequest;
                if(vaccineOrderWR.isasReq()== true)
                {
                Object[] row = new Object[7];
            
                row[0] = vaccineOrderWR;
                row[1] = vaccineOrderWR.getEnterprise();
                row[2] = vaccineOrderWR.getreqState();
                row[3] = vaccineOrderWR.getSender();
                row[4] = vaccineOrderWR.getStatus();
                row[5] = vaccineOrderWR.getReceiver();
                row[6] = vaccineOrderWR.getResolveDate();
                
                
                defaulttabelmodel.addRow(row);
                
                }
            }
            }
        }
  
    }
 
    }
    
    
    private String getContractDetails(ProviderVaccineOrderWorkRequest request){
        
        if(request.ishalfmonthContract())
            return "Half Monthly";
        else if(request.isfullMonthContract())
            return "Monthly";
        else
           return "As Required";
        
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
        tblControlOrder = new javax.swing.JTable();
        btnRefresh1 = new javax.swing.JButton();
        lbl2 = new javax.swing.JLabel();
        btnViewDetailsAndShip = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsRequiredOrders = new javax.swing.JTable();
        lblAsReqOrders = new javax.swing.JLabel();
        btnRefresh2 = new javax.swing.JButton();
        btnViewDetailsShip = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Provider Orders");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblControlOrder.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblControlOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Contract Type", "Provider", "State", "Sender", "Next Delivery Date", "Status", "Shipped by", "Last Shipping Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblControlOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblControlOrder);

        btnRefresh1.setBackground(new java.awt.Color(0, 0, 102));
        btnRefresh1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnRefresh1.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh1.setText("Refresh");
        btnRefresh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(0, 51, 102));
        lbl2.setText("Orders type:");

        btnViewDetailsAndShip.setBackground(new java.awt.Color(0, 0, 102));
        btnViewDetailsAndShip.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnViewDetailsAndShip.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDetailsAndShip.setText("View Details and Ship");
        btnViewDetailsAndShip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewDetailsAndShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsAndShipActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        tblAsRequiredOrders.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblAsRequiredOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Provider", "State", "Sender", "Status", "Shipped By", "Shipping Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsRequiredOrders.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblAsRequiredOrders);

        lblAsReqOrders.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblAsReqOrders.setForeground(new java.awt.Color(0, 51, 102));
        lblAsReqOrders.setText("AsRequired Orders:");

        btnRefresh2.setBackground(new java.awt.Color(0, 0, 102));
        btnRefresh2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnRefresh2.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh2.setText("Refresh");
        btnRefresh2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh2ActionPerformed(evt);
            }
        });

        btnViewDetailsShip.setBackground(new java.awt.Color(0, 0, 102));
        btnViewDetailsShip.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnViewDetailsShip.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDetailsShip.setText("View Details and Ship");
        btnViewDetailsShip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewDetailsShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsShipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAsReqOrders)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh2)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 610, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewDetailsAndShip, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnViewDetailsShip, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh1)
                    .addComponent(lbl2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewDetailsAndShip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsReqOrders)
                    .addComponent(btnRefresh2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewDetailsShip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRefresh1, lbl2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRefresh2, lblAsReqOrders});

    }// </editor-fold>//GEN-END:initComponents

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        // TODO add your handling code here:
        populateContractTable();
    }//GEN-LAST:event_btnRefresh1ActionPerformed

    private void btnViewDetailsAndShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsAndShipActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblControlOrder.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Kindly select an Order from table");
            return;
        }

        ProviderVaccineOrderWorkRequest request = (ProviderVaccineOrderWorkRequest)tblControlOrder.getValueAt(selectedRow, 0);

        ViewContractDetailsAndShipJPanel panel = new ViewContractDetailsAndShipJPanel(workContainer, userAccount, business, request, enterprise);
        workContainer.add("ViewContractDetailsAndShipJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnViewDetailsAndShipActionPerformed

    private void btnRefresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh2ActionPerformed
        // TODO add your handling code here:
        populateContractTable();
    }//GEN-LAST:event_btnRefresh2ActionPerformed

    private void btnViewDetailsShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsShipActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAsRequiredOrders.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Kindly select an Order from table");
            return;
        }

        ProviderVaccineOrderWorkRequest request = (ProviderVaccineOrderWorkRequest)tblAsRequiredOrders.getValueAt(selectedRow, 0);

        ViewAsRequestedDetailsAndShipJPanel panel = new ViewAsRequestedDetailsAndShipJPanel(workContainer, userAccount, business, request, enterprise);
        workContainer.add("ViewAdhocDetailsAndShipJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnViewDetailsShipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnRefresh2;
    private javax.swing.JButton btnViewDetailsAndShip;
    private javax.swing.JButton btnViewDetailsShip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblAsReqOrders;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAsRequiredOrders;
    private javax.swing.JTable tblControlOrder;
    // End of variables declaration//GEN-END:variables
}
