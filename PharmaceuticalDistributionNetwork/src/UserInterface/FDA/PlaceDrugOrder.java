/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.FDA;

import Business.EcoSystem;
import Business.NationalEnterprise.FDA;
import Business.NationalEnterprise.Manufacturer;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.FDAOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineDetails;
import Business.WorkQueue.VaccineOrderWorkRequest;
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
 * @author anzal
 */
public class PlaceDrugOrder extends javax.swing.JPanel {
    
    private final JPanel workContainer;
    private final FDA cdc;
    private final UserAccount userAccount;
    private FDAOrganization cdcOrg;
    private final EcoSystem business;
    private final ArrayList<OrderItem> cartOrder;
    private final boolean isCheckout;
    /**
     * Creates new form CreateVaccineOrder
     * @param workContainer
     * @param cdc
     * @param business
     * @param cdcOrg
     * @param userAccount
     */
    public PlaceDrugOrder(JPanel workContainer, FDA cdc, EcoSystem business, FDAOrganization cdcOrg, UserAccount userAccount) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.cdc = cdc;
        this.business = business;
        populateManufacturerComboBox();
        this.isCheckout = false;
        cartOrder = new ArrayList<OrderItem>();
        searchInTable();
    
    }

    private void populateManufacturerComboBox() {
        comboBoxManufacturerList.removeAllItems();
        for (Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerDirectory()) {
            comboBoxManufacturerList.addItem(manufacturer);

        }
    }
    
    private void displayManufacturerVaccines(){
        
        int rowCount = tblOrderDrug.getRowCount();
        DefaultTableModel defaulttabelmodel = (DefaultTableModel)tblOrderDrug.getModel();

        for(int i=rowCount-1 ; i>=0; i--){
            defaulttabelmodel.removeRow(i);
        }

        Manufacturer manufacturer = (Manufacturer)comboBoxManufacturerList.getSelectedItem();
        if(manufacturer == null){
            return;
        }

        ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineDetails vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {Object[] row = new Object[6];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineDefinition().getVaccineName();
            row[2] = vaccine.getManufacturerName();
            row[3] = vaccine.getVaccinePrice();
            row[4] = vaccine.getAvailablity();
            row[5] = vaccine.getManufactureDate();
            defaulttabelmodel.addRow(row);
            }
        }
        }
  
    }
    
    
    private void searchInTable(){
        DefaultTableModel model = (DefaultTableModel) tblOrderDrug.getModel();
        TableRowSorter sorter = new TableRowSorter<>(model);
        tblOrderDrug.setRowSorter(sorter);
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
        
        
        for(OrderItem oi: cartOrder )
        {
            Object[] row = new Object[7];
            
                row[0] = oi.getVaccineDetails();
                row[1] = oi;
                row[2] = oi.getVaccineDetails().getManufacturerName();            
                row[3] = oi.getVaccineDetails().getVaccinePrice();
                row[4] = oi.getQuantity();
                row[5] = oi.getVaccineDetails().getManufactureDate();
                row[6] = oi.getVaccineDetails().getVaccinePrice()*oi.getQuantity();
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

        lblTitle = new javax.swing.JLabel();
        lblManufacturer = new javax.swing.JLabel();
        comboBoxManufacturerList = new javax.swing.JComboBox();
        lblDrugCatalog = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderDrug = new javax.swing.JTable();
        Separator1 = new javax.swing.JSeparator();
        lblCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCartDetails = new javax.swing.JTable();
        lblQuantity = new javax.swing.JLabel();
        addcount = new javax.swing.JSpinner();
        btnAddToCart = new javax.swing.JButton();
        txt2 = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        lbl8 = new javax.swing.JLabel();
        btnCancelOrder = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        lblTotalAmount = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        lblTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Place Medicine Order");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblManufacturer.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblManufacturer.setForeground(new java.awt.Color(0, 51, 102));
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

        lblDrugCatalog.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblDrugCatalog.setForeground(new java.awt.Color(0, 51, 102));
        lblDrugCatalog.setText("Medicine Catalog");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        tblOrderDrug.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblOrderDrug.setForeground(new java.awt.Color(0, 51, 102));
        tblOrderDrug.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Code", "Medicine Name", "Brand", "Price", "Availability", "Manufacture date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrderDrug);

        Separator1.setBackground(new java.awt.Color(0, 0, 102));
        Separator1.setForeground(new java.awt.Color(0, 0, 102));

        lblCart.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblCart.setForeground(new java.awt.Color(0, 51, 102));
        lblCart.setText("Cart:");

        tblCartDetails.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tblCartDetails.setForeground(new java.awt.Color(0, 51, 102));
        tblCartDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Code", "Medicine Name", "Brand", "Price", "Quantity", "Manufacture date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCartDetails);

        lblQuantity.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(0, 0, 102));
        lblQuantity.setText("Quantity:");

        addcount.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        btnAddToCart.setBackground(new java.awt.Color(0, 0, 102));
        btnAddToCart.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdate.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lbl8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbl8.setForeground(new java.awt.Color(0, 51, 102));
        lbl8.setText("Quantity:");

        btnCancelOrder.setBackground(new java.awt.Color(0, 0, 102));
        btnCancelOrder.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCancelOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(0, 0, 102));
        btnRemove.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnCheckout.setBackground(new java.awt.Color(0, 0, 102));
        btnCheckout.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckout.setText("Check Out");
        btnCheckout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        lblTotalAmount.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblTotalAmount.setForeground(new java.awt.Color(0, 51, 102));
        lblTotalAmount.setText("Total Amount:");

        txtTotalAmount.setEnabled(false);

        lblSearch.setBackground(new java.awt.Color(0, 0, 102));
        lblSearch.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(0, 0, 102));
        lblSearch.setText("Type to Search:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Separator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblCart)
                        .addGap(43, 43, 43)
                        .addComponent(lbl8)
                        .addGap(1, 1, 1)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalAmount)
                        .addGap(3, 3, 3)
                        .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCheckout))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(256, 256, 256))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addcount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddToCart))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblManufacturer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxManufacturerList, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addComponent(lblSearch)
                        .addGap(3, 3, 3)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblDrugCatalog)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddToCart, btnCancelOrder, btnCheckout, btnRemove, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblDrugCatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxManufacturerList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblManufacturer)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(addcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCart)
                        .addComponent(btnUpdate)
                        .addComponent(lbl8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTotalAmount)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckout)
                    .addComponent(btnRemove)
                    .addComponent(btnCancelOrder))
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboBoxManufacturerList, lblDrugCatalog, lblManufacturer, lblSearch, txtSearch});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnUpdate, lbl8, lblCart, lblTotalAmount, txt2, txtTotalAmount});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addcount, btnAddToCart, lblQuantity});

    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxManufacturerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxManufacturerListActionPerformed
        // TODO add your handling code here:
        displayManufacturerVaccines();
    }//GEN-LAST:event_comboBoxManufacturerListActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        try{
            int quantity = (Integer) addcount.getValue();

            int selectRow = tblOrderDrug.getSelectedRow();
            if (selectRow < 0) {
                JOptionPane.showMessageDialog(null, "Kindly first select a vaccine!");
                return;
            }
            VaccineDetails product = (VaccineDetails) tblOrderDrug.getValueAt(selectRow, 0);

            if (quantity <= 0 || quantity > product.getAvailablity()) {
                JOptionPane.showMessageDialog(null, "Incorect Quantity, Please enter it again !");
                return;
            }

            boolean flag = true;

            ArrayList<OrderItem> orders = cartOrder;
            for (OrderItem oi : orders) {
                if (oi.getVaccineDetails().equals(product)) {
                    int oldQuantity = oi.getQuantity();
                    int newQuantity = oldQuantity + quantity;
                    oi.setQuantity(newQuantity);
                    flag = false;
                }
            }


            if(flag==true)
            {OrderItem orderItem = new OrderItem();
            orderItem.setVaccineDetails(product);
            orderItem.setQuantity(quantity);
            cartOrder.add(orderItem);

            }

            String msg = Integer.toString(quantity) + " " + product.getVaccineDefinition().getVaccineName() + " has added to cart!";
            JOptionPane.showMessageDialog(null, msg);

            product.setAvailablity(product.getAvailablity()-quantity);

            displayManufacturerVaccines();
            refreshCartTable();
            calulateTotalAmountOfOrder();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numeric data for quantity.");
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void calulateTotalAmountOfOrder(){
        
        if(cartOrder == null){
            return;
        }
        double totalAmount = 0;
        
        for(OrderItem oi: cartOrder)
        {
            totalAmount = totalAmount + oi.getQuantity()*oi.getVaccineDetails().getVaccinePrice();
            
        }
        
        txtTotalAmount.setText(String.valueOf(totalAmount));
      
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try{
            int selectRow = tblCartDetails.getSelectedRow();
            if (selectRow < 0) {
                JOptionPane.showMessageDialog(null, "Kindly first select a vaccine from the cart !");
                return;
            }

            OrderItem orderItem = (OrderItem) tblCartDetails.getValueAt(selectRow, 1);

            int oldQuantity = orderItem.getQuantity();
            int oldAvail = orderItem.getVaccineDetails().getAvailablity();

            int newQuantity = Integer.parseInt(txt2.getText());

            if (newQuantity <= 0 || newQuantity > oldQuantity + oldAvail) {
                JOptionPane.showMessageDialog(null, "Incorect Quantity, Please enter it again");
                return;
            }
            orderItem.setQuantity(newQuantity);
            String msg = "The quantity of " + orderItem.getVaccineDetails().getVaccineDefinition().getVaccineName() + " has changed from " + oldQuantity + " to " + newQuantity;
            JOptionPane.showMessageDialog(null, msg);
            orderItem.getVaccineDetails().setAvailablity(oldAvail + oldQuantity - newQuantity);

            displayManufacturerVaccines();
            refreshCartTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numeric data to update quantity.");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
        // TODO add your handling code here:

        if (!isCheckout) {

            for (OrderItem oi : cartOrder) {
                VaccineDetails product = oi.getVaccineDetails();
                int oldAvail = product.getAvailablity();
                int orderedQuantity = oi.getQuantity();
                int newAvail = oldAvail + orderedQuantity;
                product.setAvailablity(newAvail);
            }
            

            JOptionPane.showMessageDialog(null, "Order has not been checked out properly hence previous order will be canceled!");

        } else {
            JOptionPane.showMessageDialog(null, "Order has been checked out successfully, Thank you!");
        }
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);

    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectRow = tblCartDetails.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Kindly first select a vaccine from the cart !");
            return;
        }
        OrderItem oi = (OrderItem) tblCartDetails.getValueAt(selectRow, 1);
        int oldQuantity = oi.getVaccineDetails().getAvailablity();
        int orderedQuantity = oi.getQuantity();
        int newQuantity = orderedQuantity + oldQuantity;
        oi.getVaccineDetails().setAvailablity(newQuantity);
        cartOrder.remove(oi);
        
        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
       if (cartOrder != null) 
            {
     
                Order cdcOrder = new Order();
                
                for(OrderItem oi: cartOrder)
                {
                    cdcOrder.getItemList().add(oi);
                }
                
                for(OrderItem oi: cartOrder)
                {
                    String manufacturer = oi.getVaccineDetails().getManufacturerName();
                    for(Manufacturer manuf : business.getManufacturerDirectory().getManufacturerDirectory())
                    {
                        if(manufacturer.equalsIgnoreCase(String.valueOf(manuf)))
                        {   
                          
                                VaccineOrderWorkRequest vaccineWorkRequest = new VaccineOrderWorkRequest();
                                vaccineWorkRequest.setSender(userAccount);
                                vaccineWorkRequest.setStatus("NewOrder");
                                Order order = new Order();
                                order.addNewOrderItem(oi.getQuantity(), oi.getVaccineDetails());
                                vaccineWorkRequest.setVaccineOrder(order);
                               
                            for(Organization org:manuf.getOrganizationDirectory().getOrganizationList() )
                            {
                                if(org instanceof ManufactureOrganization)
                                {
                                    org.getWorkQueue().addWorkRequest(vaccineWorkRequest);
                                }
                            }
                        }
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Your order has been successfuly added!");
                
                PlaceDrugOrder panel = new PlaceDrugOrder(workContainer, cdc, business, cdcOrg,userAccount);
        workContainer.add("CreateVaccineOrderJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
            
        }
        else
        {JOptionPane.showMessageDialog(null, "Cannot Checkout due to error !");
        }
        displayManufacturerVaccines();
        refreshCartTable();
              
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSpinner addcount;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox comboBoxManufacturerList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblDrugCatalog;
    private javax.swing.JLabel lblManufacturer;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTable tblCartDetails;
    private javax.swing.JTable tblOrderDrug;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
