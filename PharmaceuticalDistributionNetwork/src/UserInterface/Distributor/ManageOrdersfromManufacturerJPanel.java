/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Distributor;

import Business.Enterprise.Enterprise;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.VaccineOrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author zakir
 */
public class ManageOrdersfromManufacturerJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;
    private final Enterprise enterprise;
    private final DistributorOrganization distributorOrganization;
    /**
     * Creates new form ManageOrdersfromManufacturerJPanel
     */
    public ManageOrdersfromManufacturerJPanel(JPanel workContainer,Enterprise enterprise, DistributorOrganization distributorOrganization) {
        initComponents();
        this.workContainer = workContainer;
        this.enterprise = enterprise;
        this.distributorOrganization = distributorOrganization;
        populateOrderTable();
        
    }
    
    private void populateOrderTable(){
        
        DefaultTableModel defaulttabelmodel = (DefaultTableModel) tblManufactureOrder.getModel();
        defaulttabelmodel.setRowCount(0);
         
        DistributorOrganization distOrg = null;
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof DistributorOrganization)
        {   distOrg = (DistributorOrganization)org;
            for(WorkRequest workRequest : distOrg.getWorkQueue().getWorkRequestList())
            {   
                if(workRequest instanceof VaccineOrderWorkRequest)
                {VaccineOrderWorkRequest vaccineOrderWR = (VaccineOrderWorkRequest)workRequest;
                
                Object[] row = new Object[4];
                row[0] = vaccineOrderWR;
                row[1] = vaccineOrderWR.getSender();
                row[2] = vaccineOrderWR.getReceiver();
                row[3] = vaccineOrderWR.getStatus();               
                defaulttabelmodel.addRow(row);
                }
                
            }
        }

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
        lblShipments = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManufactureOrder = new javax.swing.JTable();
        btnStoreMedicine = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Orders from Manufacturers");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblShipments.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblShipments.setForeground(new java.awt.Color(0, 51, 102));
        lblShipments.setText("Received Shipments:");

        tblManufactureOrder.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblManufactureOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderId", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblManufactureOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblManufactureOrder);

        btnStoreMedicine.setBackground(new java.awt.Color(0, 0, 102));
        btnStoreMedicine.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnStoreMedicine.setForeground(new java.awt.Color(255, 255, 255));
        btnStoreMedicine.setText("Store Medicine");
        btnStoreMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStoreMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreMedicineActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 0, 102));
        btnRefresh.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStoreMedicine))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblShipments)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh)
                    .addComponent(lblShipments, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStoreMedicine)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStoreMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreMedicineActionPerformed
        // TODO add your handling code here:

        int row = tblManufactureOrder.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Kindly select a Order from table");
            return;
        }

        VaccineOrderWorkRequest wr = (VaccineOrderWorkRequest)tblManufactureOrder.getValueAt(row, 0);
        if(wr.getStatus().equalsIgnoreCase("Order Stored")) {
            JOptionPane.showMessageDialog(null, "Order already Stored");
            return;
        }

        StoreDrugsJPanel panel = new StoreDrugsJPanel(workContainer, enterprise, distributorOrganization, wr);
        workContainer.add("ManageOrdersfromManufacturerJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_btnStoreMedicineActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateOrderTable();

    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnStoreMedicine;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblShipments;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblManufactureOrder;
    // End of variables declaration//GEN-END:variables
}
