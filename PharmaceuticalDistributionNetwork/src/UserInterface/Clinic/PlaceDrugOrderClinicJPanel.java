/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Clinic;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.StateNetwork;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.HospitalOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.Organization.ClinicOrganization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineDetails;
import Business.WorkQueue.ProviderVaccineOrderWorkRequest;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author sanal
 */
public class PlaceDrugOrderClinicJPanel extends javax.swing.JPanel {

    private final JPanel workContainer;

    private final HospitalEnterprise hospital;
    private final UserAccount userAccount;
    private ClinicOrganization clinicOrg;
    private final EcoSystem business;
    private Order tempOrder;
    private final ArrayList<OrderItem> cartOrder;
    private boolean isCheckout;
    private final StateNetwork state;
    
    
    public PlaceDrugOrderClinicJPanel(JPanel workContainer, HospitalEnterprise hospital,ClinicOrganization clinicOrg,UserAccount userAccount , EcoSystem business, StateNetwork state) {
        initComponents();
        searchInTable();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.state = state;
        populateManufacturerComboBox();
        this.isCheckout = false;
        cartOrder = new ArrayList<OrderItem>();
        if(isCheckout == false){
             tempOrder = new Order();
        }
   
    }
     
    private void searchInTable(){
        DefaultTableModel model = (DefaultTableModel) tblDrugDetails.getModel();
        TableRowSorter sorter = new TableRowSorter<>(model);
        tblDrugDetails.setRowSorter(sorter);
        txtSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(txtSearch.getText()); 
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(txtSearch.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(txtSearch.getText());
            }

            private void search(String str) {
                if (str.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
            
        });
    }

    
      
    
    private void refreshCartTable(){
        
          int rowCount = tblCartDetails.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblCartDetails.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        
        for(OrderItem oi: tempOrder.getItemList())
        {
            Object[] row = new Object[8];
            
                row[0] = oi.getVaccineDetails();
                row[1] = oi;
                row[2] = oi.getVaccineDetails().getVaccineId();
                row[3] = oi.getVaccineDetails().getBatchId();
                row[4] = oi.getVaccineDetails().getVaccinePrice();
                row[5] = oi.getQuantity();
                row[6] = oi.getVaccineDetails().getManufactureDate();
                row[7] = oi.getVaccineDetails().getVaccinePrice()*oi.getQuantity();
                defaulttabelmodel.addRow(row);
 
        }
   
    }
    
private void populateManufacturerComboBox() {
        comboBoxManufacturer.removeAllItems();
        for (Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory()) {
            comboBoxManufacturer.addItem(manufacturer);

        }
    }
    
    private void displayManufacturerVaccines(){
        
        int rowCount = tblDrugDetails.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblDrugDetails.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        
        //get Manufacturer from combo box
        Manufacturer manufacturer = (Manufacturer)comboBoxManufacturer.getSelectedItem();
        if(manufacturer == null){
            return;
        }
        
        //populate the table
        ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineDetails vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {Object[] row = new Object[6];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineDefinition().getVaccineName();
            row[2] = vaccine.getVaccineId();
            row[3] = vaccine.getBatchId();
            row[4] = vaccine.getVaccinePrice();
            row[5] = vaccine.getManufactureDate();
            defaulttabelmodel.addRow(row);
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

        lblMedicineOrder = new javax.swing.JLabel();
        lblManufacuter = new javax.swing.JLabel();
        comboBoxManufacturer = new javax.swing.JComboBox();
        lblManufactureDrugCatalog = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDrugDetails = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCartDetails = new javax.swing.JTable();
        lblQuantity = new javax.swing.JLabel();
        spinnerQuantity = new javax.swing.JSpinner();
        btnAddToCart = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        lblQuantityModify = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        lblTotalOrder = new javax.swing.JLabel();
        txtTotalOrder = new javax.swing.JTextField();
        lblContractType = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxOrdertype = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(204, 255, 255));

        lblMedicineOrder.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblMedicineOrder.setForeground(new java.awt.Color(0, 0, 102));
        lblMedicineOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMedicineOrder.setText("Create Medicine Order");
        lblMedicineOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblManufacuter.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblManufacuter.setForeground(new java.awt.Color(0, 0, 102));
        lblManufacuter.setText("Manufacturer:");

        comboBoxManufacturer.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxManufacturer.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        comboBoxManufacturer.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxManufacturer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxManufacturerActionPerformed(evt);
            }
        });

        lblManufactureDrugCatalog.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblManufactureDrugCatalog.setForeground(new java.awt.Color(0, 0, 102));
        lblManufactureDrugCatalog.setText("Manufacturer Drug Catalog:");

        lblSearch.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(0, 0, 102));
        lblSearch.setText("Type to Search:");

        txtSearch.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        tblDrugDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblDrugDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Code", "Medicine Name", "Medicine ID", "Lot Number", "Price", "Manufacture date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDrugDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDrugDetails);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        lblCart.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblCart.setForeground(new java.awt.Color(0, 0, 102));
        lblCart.setText("Cart:");

        tblCartDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblCartDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Code", "Medicine Name", "Medicine ID", "Lot Number", "Price", "Quantity", "Manufacture date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCartDetails);

        lblQuantity.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(0, 0, 102));
        lblQuantity.setText("Quantity:");

        spinnerQuantity.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnAddToCart.setBackground(new java.awt.Color(0, 0, 102));
        btnAddToCart.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        txtQuantity.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnModify.setBackground(new java.awt.Color(0, 0, 102));
        btnModify.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnModify.setForeground(new java.awt.Color(255, 255, 255));
        btnModify.setText("Modify");
        btnModify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        lblQuantityModify.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblQuantityModify.setForeground(new java.awt.Color(0, 0, 102));
        lblQuantityModify.setText("Quantity:");

        btnRemove.setBackground(new java.awt.Color(0, 0, 102));
        btnRemove.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnCheckOut.setBackground(new java.awt.Color(0, 0, 102));
        btnCheckOut.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCheckOut.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckOut.setText("Check Out");
        btnCheckOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        lblTotalOrder.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblTotalOrder.setForeground(new java.awt.Color(0, 0, 102));
        lblTotalOrder.setText("Total Amount of Order:");

        txtTotalOrder.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtTotalOrder.setEnabled(false);

        lblContractType.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblContractType.setForeground(new java.awt.Color(0, 0, 102));
        lblContractType.setText("Set Contract: ");

        comboBoxOrdertype.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxOrdertype.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxOrdertype.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxOrdertype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AsRequired", "Monthly", "Bi-Monthly" }));
        comboBoxOrdertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxOrdertypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMedicineOrder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblCart)
                        .addGap(32, 32, 32)
                        .addComponent(lblQuantityModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalOrder)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblManufactureDrugCatalog)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblManufacuter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(139, 139, 139)
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove)
                        .addGap(78, 78, 78)
                        .addComponent(lblContractType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxOrdertype, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMedicineOrder)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblManufacuter)
                            .addComponent(comboBoxManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblManufactureDrugCatalog))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSearch)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCart)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify)
                    .addComponent(lblQuantityModify)
                    .addComponent(lblTotalOrder)
                    .addComponent(txtTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckOut)
                    .addComponent(btnRemove)
                    .addComponent(lblContractType)
                    .addComponent(comboBoxOrdertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxManufacturerActionPerformed
        // TODO add your handling code here:

        displayManufacturerVaccines();
    }//GEN-LAST:event_comboBoxManufacturerActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        int quantity = (Integer) spinnerQuantity.getValue();

        int selectRow = tblDrugDetails.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Kindly select a drug first!");
            return;
        }
        VaccineDetails product = (VaccineDetails) tblDrugDetails.getValueAt(selectRow, 0);
        
        
        //condition for -ve 
        if (quantity <= 0 ) {
            JOptionPane.showMessageDialog(null, "Incorrect quantity. Please try again!");
            return;
        }
  
        boolean flag = true;
        ArrayList<OrderItem> orders = tempOrder.getItemList();
        for (OrderItem oi : orders) {
            if (oi.getVaccineDetails().equals(product)) {
                int oldQuantity = oi.getQuantity();
                int newQuantity = oldQuantity + quantity;
                oi.setQuantity(newQuantity);
                flag = false;
            }
        }
     
        if(flag){
        OrderItem orderItem = tempOrder.addNewOrderItem(quantity, product);
        }
         
        isCheckout = false;
        String msg = Integer.toString(quantity) + " " + product.getVaccineDefinition().getVaccineName() + " has been added to cart!";
        JOptionPane.showMessageDialog(null, msg);
  
       displayManufacturerVaccines();
        refreshCartTable();
        calulateTotalAmountOfOrder();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void calulateTotalAmountOfOrder(){
        
        if(tempOrder == null){
            return;
        }
        double totalAmount = 0;
        
        for(OrderItem oi: tempOrder.getItemList())
        {
            totalAmount = totalAmount + oi.getQuantity()*oi.getVaccineDetails().getVaccinePrice();
            
        }
        
        txtTotalOrder.setText(String.valueOf(totalAmount));
        
        
    }
    
    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        try{
            int selectRow = tblCartDetails.getSelectedRow();
            if (selectRow < 0) {
                JOptionPane.showMessageDialog(null, "Kindly select a vaccine first from cart!");
                return;
            }

            OrderItem orderItem = (OrderItem) tblCartDetails.getValueAt(selectRow, 1);
            int oldQuantity = orderItem.getQuantity();
            int newQuantity = Integer.parseInt(txtQuantity.getText());


            orderItem.setQuantity(newQuantity);
            String msg = "The quantity of " + orderItem.getVaccineDetails().getVaccineDefinition().getVaccineName() + " has changed from " + oldQuantity + " to " + newQuantity;
            JOptionPane.showMessageDialog(null, msg);

            displayManufacturerVaccines();
            refreshCartTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numeric data to update quantity.");
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectRow = tblCartDetails.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Kindly select a drug first!");
            return;
        }
        OrderItem oi = (OrderItem) tblCartDetails.getValueAt(selectRow, 1);
       
        
        tempOrder.removeOrderItem(oi);
        

        displayManufacturerVaccines();
        refreshCartTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:

        if (!tempOrder.getItemList().isEmpty()) 
            {   boolean adhoc = false;
                boolean bimonth = false;
                boolean monthly = false;
                String s = (String) comboBoxOrdertype.getSelectedItem();
            
            if(s.equals("AsRequired"))
            {
                adhoc = true;
                bimonth = false;
                monthly = false;
            }
            if(s.equals("Monthly"))
            {
                adhoc = false;
                bimonth = false;
                monthly = true;
            }
            if(s.equals("Bi-Monthly"))
            {
                adhoc = false;
                bimonth = true;
                monthly = false;
            }
    
              
                Order o = hospital.getOrderCatalog().addNewOrder();
                o=tempOrder;
                
                ProviderVaccineOrderWorkRequest workRequest = new ProviderVaccineOrderWorkRequest();
                workRequest.setasReq(adhoc);
                workRequest.setHalfmonthContract(bimonth);
                workRequest.setfullMonthContract(monthly);
                workRequest.setVaccineOrder(tempOrder);
                workRequest.setSender(userAccount);
                workRequest.setStatus("New Order");
                workRequest.calculateDeliveryDate(workRequest);
                workRequest.setEnterprise(hospital);
                workRequest.setClinicOrganization(clinicOrg);
                workRequest.setClinicOrder(true);
                
                for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
                {
                    if(org instanceof HospitalOrganization)
                    {
                        HospitalOrganization hosOrg = (HospitalOrganization)org;
                        hosOrg.getWorkQueue().addWorkRequest(workRequest);
                    }
                }
  
                JOptionPane.showMessageDialog(null, "Order has been added successfuly!");
            
        }
        else
        {JOptionPane.showMessageDialog(null, "Cannot checkout due to error!");
        }
        
        isCheckout = true;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to add another order ?", "Warning", dialogButton);

        //if yes
        if (dialogResult == JOptionPane.YES_OPTION) {
            tempOrder = new Order(); 

        }
       
        displayManufacturerVaccines();
        refreshCartTable();
        
        PlaceDrugOrderClinicJPanel panel = new PlaceDrugOrderClinicJPanel(workContainer, hospital,clinicOrg , userAccount, business, state);
        workContainer.add("PlaceVaccineOrderJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);        
        
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void comboBoxOrdertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxOrdertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxOrdertypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox comboBoxManufacturer;
    private javax.swing.JComboBox comboBoxOrdertype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblContractType;
    private javax.swing.JLabel lblManufactureDrugCatalog;
    private javax.swing.JLabel lblManufacuter;
    private javax.swing.JLabel lblMedicineOrder;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantityModify;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTotalOrder;
    private javax.swing.JSpinner spinnerQuantity;
    private javax.swing.JTable tblCartDetails;
    private javax.swing.JTable tblDrugDetails;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalOrder;
    // End of variables declaration//GEN-END:variables
}
