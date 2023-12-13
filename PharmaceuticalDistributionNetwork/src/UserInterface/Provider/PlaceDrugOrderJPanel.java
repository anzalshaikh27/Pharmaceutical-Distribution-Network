/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Provider;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.StateNetwork;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.HospitalOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.Organization.SHDImmuneOrganization;
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
 * @author zakir
 */
public class PlaceDrugOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVaccineOrderJPanel
     */
    private final JPanel workContainer;

    private final HospitalEnterprise hospital;
    private final UserAccount userAccount;
    private HospitalOrganization hospitalOrg;
    private final EcoSystem business;
    private Order tempOrder;
    private final ArrayList<OrderItem> cartOrder;
    private boolean isCheckout;
    private final StateNetwork state;

    public PlaceDrugOrderJPanel(JPanel workContainer, HospitalEnterprise hospital,HospitalOrganization hospitalOrg,UserAccount userAccount , EcoSystem business, StateNetwork state) {
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
        DefaultTableModel model = (DefaultTableModel) tblManufacturerDetails.getModel();
        TableRowSorter sorter = new TableRowSorter<>(model);
        tblManufacturerDetails.setRowSorter(sorter);
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

    private void populateManufacturerComboBox() {
        comboBoxManufacturerList.removeAllItems();
        for (Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory()) {
            comboBoxManufacturerList.addItem(manufacturer);

        }
    }
    
    private void displayManufacturerVaccines(){
        
        int rowCount = tblManufacturerDetails.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblManufacturerDetails.getModel();
        
        //delete rows
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        
        //get Manufacturer from combo box
        Manufacturer manufacturer = (Manufacturer)comboBoxManufacturerList.getSelectedItem();
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
    
    
    private void searchVaccineProducts(String vaccineCode){
        
        int rowCount = tblManufacturerDetails.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblManufacturerDetails.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }
        
        //search vaccines from all the manufacturers
        
        for(Manufacturer manufacturer: business.getManufacturerDirectory().getManufacturerDirectory())
        {
             ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineDetails vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {
                if(vaccineCode.equalsIgnoreCase(vaccine.getVaccineDefinition().getVaccineCode()))
                {
                Object[] row = new Object[6];
            
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
            
            
        }
        
        
        
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        lblManufacturer = new javax.swing.JLabel();
        comboBoxManufacturerList = new javax.swing.JComboBox();
        lblManufacturerDrugCatalog = new javax.swing.JLabel();
        lblDrugCode = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManufacturerDetails = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCartDetails = new javax.swing.JTable();
        lblQuantity = new javax.swing.JLabel();
        spinCount = new javax.swing.JSpinner();
        btnAddToCart = new javax.swing.JButton();
        txtQuantityCount = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        lblQuantityModify = new javax.swing.JLabel();
        btnRemoveFromCart = new javax.swing.JButton();
        btnCheckoutCart = new javax.swing.JButton();
        lblOrderAmount = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JTextField();
        lblTypeOfContract = new javax.swing.JLabel();
        comboBoxTypeOfOrder = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(new java.awt.Color(0, 0, 102));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Create Medicine Order");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblManufacturer.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblManufacturer.setForeground(new java.awt.Color(0, 0, 102));
        lblManufacturer.setText("Manufacturer:");

        comboBoxManufacturerList.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxManufacturerList.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxManufacturerList.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxManufacturerList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxManufacturerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxManufacturerListActionPerformed(evt);
            }
        });

        lblManufacturerDrugCatalog.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblManufacturerDrugCatalog.setForeground(new java.awt.Color(0, 0, 102));
        lblManufacturerDrugCatalog.setText("Manufacturer Medicine Catalog:");

        lblDrugCode.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblDrugCode.setForeground(new java.awt.Color(0, 0, 102));
        lblDrugCode.setText("Type to Search:");

        tblManufacturerDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblManufacturerDetails.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblManufacturerDetails);

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

        spinCount.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        btnAddToCart.setBackground(new java.awt.Color(0, 0, 102));
        btnAddToCart.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        txtQuantityCount.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnModify.setBackground(new java.awt.Color(0, 0, 102));
        btnModify.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnModify.setForeground(new java.awt.Color(255, 255, 255));
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        lblQuantityModify.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblQuantityModify.setForeground(new java.awt.Color(0, 0, 102));
        lblQuantityModify.setText("Quantity:");

        btnRemoveFromCart.setBackground(new java.awt.Color(0, 0, 102));
        btnRemoveFromCart.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnRemoveFromCart.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveFromCart.setText("Remove");
        btnRemoveFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromCartActionPerformed(evt);
            }
        });

        btnCheckoutCart.setBackground(new java.awt.Color(0, 0, 102));
        btnCheckoutCart.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCheckoutCart.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckoutCart.setText("Check Out");
        btnCheckoutCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutCartActionPerformed(evt);
            }
        });

        lblOrderAmount.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblOrderAmount.setForeground(new java.awt.Color(0, 0, 102));
        lblOrderAmount.setText("Total Amount of Order:");

        txtTotalAmount.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtTotalAmount.setEnabled(false);

        lblTypeOfContract.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblTypeOfContract.setForeground(new java.awt.Color(0, 0, 102));
        lblTypeOfContract.setText("Set Contract: ");

        comboBoxTypeOfOrder.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxTypeOfOrder.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxTypeOfOrder.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxTypeOfOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AsRequired", "Monthly", "Bi-Monthly" }));
        comboBoxTypeOfOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTypeOfOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblManufacturer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxManufacturerList, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblManufacturerDrugCatalog)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDrugCode)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCart)
                        .addGap(32, 32, 32)
                        .addComponent(lblQuantityModify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantityCount, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemoveFromCart)
                        .addGap(78, 78, 78)
                        .addComponent(lblTypeOfContract)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTypeOfOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(btnCheckoutCart, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinCount, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblOrderAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblManufacturer)
                            .addComponent(comboBoxManufacturerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblManufacturerDrugCatalog))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDrugCode)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(spinCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCart)
                    .addComponent(txtQuantityCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify)
                    .addComponent(lblQuantityModify)
                    .addComponent(lblOrderAmount)
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckoutCart)
                    .addComponent(btnRemoveFromCart)
                    .addComponent(lblTypeOfContract)
                    .addComponent(comboBoxTypeOfOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnModify, lblCart, lblOrderAmount, lblQuantityModify, txtQuantityCount, txtTotalAmount});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddToCart, lblDrugCode, lblManufacturerDrugCatalog, lblQuantity, spinCount, txtSearch});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        try{
            int quantity = (Integer) spinCount.getValue();

            //get the selected item
            int selectRow = tblManufacturerDetails.getSelectedRow();
            if (selectRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select a Vaccine First!");
                return;
            }
            VaccineDetails product = (VaccineDetails) tblManufacturerDetails.getValueAt(selectRow, 0);

            if (quantity <= 0 ) {
                JOptionPane.showMessageDialog(null, "Please enter correct quantity");
                return;
            }


            boolean flag = true;
            //  ArrayList<OrderItem> orders = customer.getOrder().getOrderItemList();
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
            //OrderItem orderItem = customer.getOrder().addOrderItem(product, quantity);
            OrderItem orderItem = tempOrder.addNewOrderItem(quantity, product);
            }


            isCheckout = false;
            String msg = Integer.toString(quantity) + " " + product.getVaccineDefinition().getVaccineName() + " has added to cart!";
            JOptionPane.showMessageDialog(null, msg);

           displayManufacturerVaccines();
            refreshCartTable();
            calulateTotalAmountOfOrder();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numeric data for quantity.");
        }

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
        
        txtTotalAmount.setText(String.valueOf(totalAmount));
        
        
    }
    
  
    
    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        try{
            int selectRow = tblCartDetails.getSelectedRow();
            if (selectRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select a vaccine from cart first!");
                return;
            }
            //modify the item Quantity
            OrderItem orderItem = (OrderItem) tblCartDetails.getValueAt(selectRow, 1);

            int oldQuantity = orderItem.getQuantity();
            //get new quantity
            int newQuantity = Integer.parseInt(txtQuantityCount.getText());

            orderItem.setQuantity(newQuantity);
            String msg = "The quantity of " + orderItem.getVaccineDetails().getVaccineDefinition().getVaccineName() + " has changed from " + oldQuantity + " to " + newQuantity;
            JOptionPane.showMessageDialog(null, msg);

            //orderItem.getVaccineProduct().setAvailablity(oldAvail + oldQuantity - newQuantity);//update the availability

            //refresh the tables
            displayManufacturerVaccines();
            refreshCartTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numeric data to modify quantity.");
        }

    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnRemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromCartActionPerformed
        // TODO add your handling code here:
        int selectRow = tblCartDetails.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vaccine from cart first!");
            return;
        }
        OrderItem oi = (OrderItem) tblCartDetails.getValueAt(selectRow, 1);
     
        
        tempOrder.removeOrderItem(oi);
        

        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_btnRemoveFromCartActionPerformed

    private void btnCheckoutCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutCartActionPerformed
        // TODO add your handling code here:
        // if(!customer.getOrder().getOrderItemList().isEmpty())
        
//        if((rbbimon.isSelected() || rbmon.isSelected() || rbnormal.isSelected()))
//        {
            
        
        if (!tempOrder.getItemList().isEmpty()) 
            {   
                boolean adhoc = false;
                boolean bimonth = false;
                boolean monthly = false;
                String s = (String) comboBoxTypeOfOrder.getSelectedItem();
            
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
                //get the contract details
//                boolean adhoc = rbnormal.isSelected();
//                boolean bimonth = rbbimon.isSelected();
//                boolean monthly = rbmon.isSelected();
//                
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
             
                for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
                {
                    if(org instanceof HospitalOrganization)
                    {
                        HospitalOrganization hosOrg = (HospitalOrganization)org;
                        hosOrg.getWorkQueue().addWorkRequest(workRequest);
                    }
                }
                
                for(Organization org: state.getLocalHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {
                    if(org instanceof SHDImmuneOrganization)
                    {
                        org.getWorkQueue().addWorkRequest(workRequest);
                    }
                }
                
                
                JOptionPane.showMessageDialog(null, "Your order has been successfuly added!");
            
        }
        else
        {JOptionPane.showMessageDialog(null, "Error occured when trying to check out!");
        }
        
        isCheckout = true;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to Place another order?", "Warning", dialogButton);


        if (dialogResult == JOptionPane.YES_OPTION) {
            tempOrder = new Order();

        }

        displayManufacturerVaccines();
        refreshCartTable();

          PlaceDrugOrderJPanel panel = new PlaceDrugOrderJPanel(workContainer, hospital, hospitalOrg, userAccount, business, state);
        workContainer.add("PlaceVaccineOrderJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
  
        
//        else
//        {
//            JOptionPane.showMessageDialog(null, "Please Select a type of order");
//            return;
//        }
        
    }//GEN-LAST:event_btnCheckoutCartActionPerformed

    private void comboBoxManufacturerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxManufacturerListActionPerformed
        // TODO add your handling code here:

        displayManufacturerVaccines();
    }//GEN-LAST:event_comboBoxManufacturerListActionPerformed

    private void comboBoxTypeOfOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTypeOfOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTypeOfOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnCheckoutCart;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRemoveFromCart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboBoxManufacturerList;
    private javax.swing.JComboBox comboBoxTypeOfOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblDrugCode;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblManufacturerDrugCatalog;
    private javax.swing.JLabel lblOrderAmount;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblQuantityModify;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTypeOfContract;
    private javax.swing.JSpinner spinCount;
    private javax.swing.JTable tblCartDetails;
    private javax.swing.JTable tblManufacturerDetails;
    private javax.swing.JTextField txtQuantityCount;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
