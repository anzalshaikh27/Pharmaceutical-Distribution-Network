/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Distributor;

import Business.EcoSystem;
import Business.NationalEnterprise.Distributor;
import Business.Order.OrderItem;
import Business.Organization.DistributorOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineDetails;
import Business.Warehouse.Warehouse;
import Business.WorkQueue.ProviderVaccineOrderWorkRequest;
import Business.WorkQueue.ShippingOrderWorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author zakir
 */
public class ViewAsRequestedDetailsAndShipJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;
    private final Distributor distributorEnterprise;
    private final UserAccount userAccount;
    private final EcoSystem business;
    private final ProviderVaccineOrderWorkRequest request;
    private boolean flag;
    /**
     * Creates new form ViewAsRequestedDetailsAndShipJPanel
     * @param workContainer
     * @param userAccount
     * @param business
     * @param request
     * @param distributorEnterprise
     */
    public ViewAsRequestedDetailsAndShipJPanel(JPanel workContainer, UserAccount userAccount,EcoSystem business, ProviderVaccineOrderWorkRequest request, Distributor distributorEnterprise) {

        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.request = request;
        this.distributorEnterprise = distributorEnterprise;
        calculateTotalCostOfOrder();
        populateOrderTable();
        flag = false;
     
    }
    
     private void calculateTotalCostOfOrder(){
        
        double total = 0;
        for(OrderItem oi : request.getVaccineOrder().getItemList())
        {
            total = total + (oi.getVaccineDetails().getVaccinePrice()*oi.getQuantity());
        }
        txtTotalCost.setText(String.valueOf(total));
    }
     
     private void populateOrderTable(){
        
         int rowCount = tblOrderDetails.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblOrderDetails.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        for(OrderItem oi: request.getVaccineOrder().getItemList())
        {
            Object[] row = new Object[9];
            
                row[0] = oi.getVaccineDetails();
                row[1] = oi;
                row[2] = oi.getVaccineDetails().getManufacturerName();
                row[3] = oi.getVaccineDetails().getVaccineId();
                row[4] = oi.getVaccineDetails().getBatchId();
                row[5] = oi.getVaccineDetails().getVaccinePrice();
                row[6] = oi.getQuantity();
                row[7] = oi.getVaccineDetails().getManufactureDate();
                row[8] = oi.getVaccineDetails().getVaccinePrice()*oi.getQuantity();

                defaulttabelmodel.addRow(row);
            
            
            
            
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

        lbl1 = new javax.swing.JLabel();
        txtTotalCost = new javax.swing.JTextField();
        txtOrderNumber = new javax.swing.JTextField();
        btnCheckInventory = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderDetails = new javax.swing.JTable();
        lbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventoryDetails = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbl3 = new javax.swing.JLabel();
        btnShipOrder = new javax.swing.JButton();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        lbl1.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lbl1.setForeground(new java.awt.Color(0, 0, 102));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("View order and ship");
        lbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTotalCost.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtTotalCost.setEnabled(false);

        txtOrderNumber.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtOrderNumber.setEnabled(false);

        btnCheckInventory.setBackground(new java.awt.Color(0, 0, 102));
        btnCheckInventory.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCheckInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckInventory.setText("Check Inventory");
        btnCheckInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInventoryActionPerformed(evt);
            }
        });

        tblOrderDetails.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblOrderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Code", "Medicine Name", "Brand", "Medicine ID", "Batch ID", "Price", "Quantity", "Manufacture date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrderDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblOrderDetails);

        lbl2.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(0, 0, 102));
        lbl2.setText("Order Particulars");

        tblInventoryDetails.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tblInventoryDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Code", "Medicine Name", "Brand", "Warehouse Id", "Warehouse Location", "Medicine ID", "BatchID", "Medicines in Inventory", "Available?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventoryDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblInventoryDetails);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        lbl3.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(0, 0, 102));
        lbl3.setText("Inventory Check");

        btnShipOrder.setBackground(new java.awt.Color(0, 0, 102));
        btnShipOrder.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnShipOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnShipOrder.setText("Ship order");
        btnShipOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShipOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShipOrderActionPerformed(evt);
            }
        });

        lbl4.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lbl4.setForeground(new java.awt.Color(0, 0, 102));
        lbl4.setText("Total Cost of the Order:");

        lbl5.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lbl5.setForeground(new java.awt.Color(0, 0, 102));
        lbl5.setText("Order Number:");

        btnBack.setBackground(new java.awt.Color(0, 0, 102));
        btnBack.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl3)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnShipOrder, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCheckInventory, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(lbl5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(lbl4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl2)
                        .addComponent(lbl5)
                        .addComponent(txtOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnCheckInventory)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnShipOrder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCheckInventory, lbl2, lbl3, lbl4, lbl5, txtOrderNumber});

    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInventoryActionPerformed
        // TODO add your handling code here:
        int rowCount = tblInventoryDetails.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblInventoryDetails.getModel();

        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }

        String vaccineCode = null;
        String manufacturer = null;
        String batchId = null;
        DistributorOrganization distOrg = null;

        int count =0;

        for(OrderItem oi : request.getVaccineOrder().getItemList())
        {
            vaccineCode = oi.getVaccineDetails().getVaccineDefinition().getVaccineCode();
            manufacturer = oi.getVaccineDetails().getManufacturerName();
            batchId = oi.getVaccineDetails().getBatchId();

            for(Organization org: distributorEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof DistributorOrganization)
                {
                    distOrg = (DistributorOrganization) org;
                    for(Warehouse warehouse: distOrg.getWarehouseDir().getWarehouseList())
                    {
                        for(VaccineDetails product: warehouse.getVaccineInventoryList())
                        {
                            if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && product.getManufacturerName().equalsIgnoreCase(manufacturer)&& product.getBatchId().equals(batchId))// && product.getVaccineId() == oi.getVaccineDetails().getVaccineId() )
                        {
                            if(product.getAvailablity()>0)
                            {count++;
                                flag = true;
                                Object[] row = new Object[9];

                                row[0] = product;
                                row[1] = product.getVaccineDefinition().getVaccineName();
                                row[2] = product.getManufacturerName();
                                row[3] = warehouse;
                                row[4] = warehouse.getLocation();
                                row[5] = product.getVaccineId();
                                row[6] = product.getBatchId();
                                row[7] = product.getAvailablity();
                                row[8] = "Yes";

                                defaulttabelmodel.addRow(row);
                            }
                            else
                            {
                                String msg = new String("Not Enough quantity of "+ product);
                                JOptionPane.showMessageDialog(null, msg);
                                return;

                            }
                        }
                    }
                }

            }

        }

        }

        if(count==0)
        {
            JOptionPane.showMessageDialog(null, "Vaccine are out of Stock Inventory!");
            return;
        }

        //populate the table
    }//GEN-LAST:event_btnCheckInventoryActionPerformed

    private void btnShipOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShipOrderActionPerformed
        // TODO add your handling code here:
        if(request.getStatus().equalsIgnoreCase("Shipped"))
        {
            JOptionPane.showMessageDialog(null, "Order already Shipped!");
            return;
        }

        if(flag== false)
        {
            JOptionPane.showMessageDialog(null, "Vaccine are out of Stock Inventory!");
            return;
        }
        flag = false;

        ShippingOrderWorkRequest shipRequest = new ShippingOrderWorkRequest();
        shipRequest.setVaccineOrder(request.getVaccineOrder());
        shipRequest.setShippingDate(new Date());
        shipRequest.setSender(userAccount);
        shipRequest.setStatus("Shipped");

        request.setReceiver(userAccount);
        request.setStatus("Shipped");
        request.setResolveDate(new Date());

        String vaccineCode = null;
        String manufacturer = null;
        DistributorOrganization distOrg = null;

        String batchID = null;
        boolean warehouseFlag = false;

        for(OrderItem oi : request.getVaccineOrder().getItemList())
        {   warehouseFlag= false;
            vaccineCode = oi.getVaccineDetails().getVaccineDefinition().getVaccineCode();
            manufacturer = oi.getVaccineDetails().getManufacturerName();
            batchID = oi.getVaccineDetails().getBatchId();

            for(Organization org: distributorEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof DistributorOrganization)
                {
                    distOrg = (DistributorOrganization) org;
                    for(Warehouse warehouse: distOrg.getWarehouseDir().getWarehouseList())
                    {   if(warehouseFlag == false)
                        {

                            for(VaccineDetails product: warehouse.getVaccineInventoryList())
                            {
                                if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && product.getManufacturerName().equalsIgnoreCase(manufacturer) && product.getBatchId().equals(batchID))// && product.getVaccineId() == vaccineId)
                            {
                                if(product.getAvailablity()>0)
                                {product.setAvailablity(product.getAvailablity()-oi.getQuantity());
                                    shipRequest.getShipOrder().addNewOrderItem(oi.getQuantity(), product);
                                    warehouseFlag = true;

                                    break;
                                }
                                else
                                {
                                    String msg = new String("Not Enough quantity of "+ product);
                                    JOptionPane.showMessageDialog(null, msg);
                                    return;
                                }
                            }
                        }
                    }
                    else
                    {
                        break;
                    }
                }

            }

        }

        }

        //get the provider and insert it in his work queue
        HospitalOrganization hospOrg = null;
        for(Organization org: request.getEnterprise().getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                hospOrg = (HospitalOrganization)org;
                hospOrg.getWorkQueue().addWorkRequest(shipRequest);

            }

        }
        JOptionPane.showMessageDialog(null, "Order Shipped!");

        //        RequestPayment();
    }//GEN-LAST:event_btnShipOrderActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckInventory;
    private javax.swing.JButton btnShipOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JTable tblInventoryDetails;
    private javax.swing.JTable tblOrderDetails;
    private javax.swing.JTextField txtOrderNumber;
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}
