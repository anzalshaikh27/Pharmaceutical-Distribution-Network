/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Provider;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.StateNetwork;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Person.Patient;
import Business.UserAccount.UserAccount;
import Business.Vaccine.AdministeredVaccineDetails;
import Business.Vaccine.VaccineDetails;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author zakir
 */
public class AdministerDrugToPatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdministerDrugToPatientJPanel
     */
    private final JPanel workContainer;

    private final HospitalEnterprise hospital;
    private final UserAccount userAccount;
    private final HospitalOrganization hospitalOrg;
    private final EcoSystem business;
    private final Patient patient;
    private final StateNetwork state;
    private int flagg;
    
    public AdministerDrugToPatientJPanel(JPanel workContainer, HospitalEnterprise hospital,HospitalOrganization hospitalOrg,UserAccount userAccount , EcoSystem business,Patient patient, StateNetwork state) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.hospitalOrg = hospitalOrg;
        this.patient = patient;
        this.state = state;
        txtDoctor.setText(userAccount.getPerson().getFirstName()+" "+userAccount.getPerson().getLastName());
        txtPatientName.setText(patient.getFirstName() + " " + patient.getLastName());
        comboBoxDrugList.removeAllItems();
        comboBoxDrugBrand.removeAllItems();
        comboBoxBatchNumber.removeAllItems();
        
        populateVaccineCodeComboBox();
        
    }
    
    private void populateVaccineCodeComboBox()
    {
       comboBoxDrugList.removeAllItems();
       
       ArrayList<String> vprodList = new ArrayList<String>();
       
       
       for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(vprodList.contains(product.getVaccineDefinition().getVaccineCode())== false)
                   {
                       comboBoxDrugList.addItem(product);
                       vprodList.add(product.getVaccineDefinition().getVaccineCode());
                   }
                   
               }
           }
       }
        
    }
    
    private void populateBrandComboBox(VaccineDetails vaccine)
    {
        comboBoxDrugBrand.removeAllItems();
         String vaccineCode = vaccine.getVaccineDefinition().getVaccineCode();
            ArrayList<String> brandList = new ArrayList<String>();
         for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && brandList.contains(product.getManufacturerName())==false )
                   {
                       comboBoxDrugBrand.addItem(product.getManufacturerName());
                       brandList.add(product.getManufacturerName());
                   }
               }
           }
       }

    }
    
    
    private void populateBatchComboBox(String brandName){
        
        comboBoxBatchNumber.removeAllItems();
        VaccineDetails vp = (VaccineDetails)comboBoxDrugList.getSelectedItem();
        String vaccineCode = vp.getVaccineDefinition().getVaccineCode();
        
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brandName) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                       comboBoxBatchNumber.addItem(product.getBatchId());
                   }
               }
           }
       }
        
        
    }
    
    private void populateTextFields()
    {
        VaccineDetails prod = (VaccineDetails)comboBoxDrugList.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        String vaccineCode = prod.getVaccineDefinition().getVaccineCode();
        
        
        String brand = (String)comboBoxDrugBrand.getSelectedItem();
        
        String batchID = (String)comboBoxBatchNumber.getSelectedItem();
        
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brand) && product.getBatchId().equalsIgnoreCase(batchID) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                       txtManufacturingDate.setText(String.valueOf(product.getManufactureDate()));

                       return;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblPatient = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        lblDrugDetails = new javax.swing.JLabel();
        lblDrugCode = new javax.swing.JLabel();
        comboBoxDrugList = new javax.swing.JComboBox();
        lblDoseNumber = new javax.swing.JLabel();
        txtDoseNumber = new javax.swing.JTextField();
        lblManufacturingDate = new javax.swing.JLabel();
        txtManufacturingDate = new javax.swing.JTextField();
        lblBatchNumber = new javax.swing.JLabel();
        comboBoxBatchNumber = new javax.swing.JComboBox();
        lblArm = new javax.swing.JLabel();
        lblInjectionStatus = new javax.swing.JLabel();
        lblGivenBy = new javax.swing.JLabel();
        txtDoctor = new javax.swing.JTextField();
        btnAdministerDrug = new javax.swing.JButton();
        lblBrand = new javax.swing.JLabel();
        comboBoxDrugBrand = new javax.swing.JComboBox();
        btnback = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        comboBoxInjectingArm = new javax.swing.JComboBox();
        comboBoxStatus = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administer Medicine To Patient");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPatient.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPatient.setForeground(new java.awt.Color(0, 0, 102));
        lblPatient.setText("Patient: ");

        txtPatientName.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtPatientName.setEnabled(false);

        lblDrugDetails.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblDrugDetails.setForeground(new java.awt.Color(0, 0, 102));
        lblDrugDetails.setText("Medicine Details:");

        lblDrugCode.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblDrugCode.setForeground(new java.awt.Color(0, 0, 102));
        lblDrugCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDrugCode.setText("Medicine Code:");

        comboBoxDrugList.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxDrugList.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxDrugList.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxDrugList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxDrugList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDrugListActionPerformed(evt);
            }
        });

        lblDoseNumber.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblDoseNumber.setForeground(new java.awt.Color(0, 0, 102));
        lblDoseNumber.setText("Dose Number:");

        txtDoseNumber.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        lblManufacturingDate.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblManufacturingDate.setForeground(new java.awt.Color(0, 0, 102));
        lblManufacturingDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblManufacturingDate.setText("Manufacture Date:");

        txtManufacturingDate.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtManufacturingDate.setEnabled(false);

        lblBatchNumber.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblBatchNumber.setForeground(new java.awt.Color(0, 0, 102));
        lblBatchNumber.setText("Batch Number:");

        comboBoxBatchNumber.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxBatchNumber.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxBatchNumber.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxBatchNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxBatchNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxBatchNumberActionPerformed(evt);
            }
        });

        lblArm.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblArm.setForeground(new java.awt.Color(0, 0, 102));
        lblArm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblArm.setText("Injecting Arm");

        lblInjectionStatus.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblInjectionStatus.setForeground(new java.awt.Color(0, 0, 102));
        lblInjectionStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInjectionStatus.setText("Injection Status:");

        lblGivenBy.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblGivenBy.setForeground(new java.awt.Color(0, 0, 102));
        lblGivenBy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGivenBy.setText("Given By:");

        txtDoctor.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtDoctor.setEnabled(false);

        btnAdministerDrug.setBackground(new java.awt.Color(0, 0, 102));
        btnAdministerDrug.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAdministerDrug.setForeground(new java.awt.Color(255, 255, 255));
        btnAdministerDrug.setText("Administer Medicine");
        btnAdministerDrug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministerDrugActionPerformed(evt);
            }
        });

        lblBrand.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(0, 0, 102));
        lblBrand.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBrand.setText("Brand:");

        comboBoxDrugBrand.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxDrugBrand.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxDrugBrand.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxDrugBrand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxDrugBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDrugBrandActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(0, 0, 102));
        btnback.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setText("<");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        comboBoxInjectingArm.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxInjectingArm.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxInjectingArm.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxInjectingArm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Right", "Left" }));
        comboBoxInjectingArm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxInjectingArmActionPerformed(evt);
            }
        });

        comboBoxStatus.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxStatus.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxStatus.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Success", "Fail" }));
        comboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDrugDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBrand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDrugCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblManufacturingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblArm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtManufacturingDate)
                            .addComponent(comboBoxInjectingArm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxDrugList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxDrugBrand, 0, 159, Short.MAX_VALUE)
                            .addComponent(btnAdministerDrug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(lblDoseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(lblBatchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxBatchNumber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDoseNumber)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblGivenBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblInjectionStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lblPatient)
                                .addGap(18, 18, 18)
                                .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBoxDrugBrand, comboBoxStatus, txtDoctor, txtDoseNumber});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatient))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDrugDetails)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboBoxBatchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(txtDoseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxDrugList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDrugCode)
                                    .addComponent(lblBatchNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxDrugBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBrand)
                                    .addComponent(lblDoseNumber))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblManufacturingDate)
                            .addComponent(txtManufacturingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblArm)
                            .addComponent(comboBoxInjectingArm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGivenBy))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInjectionStatus))))
                .addGap(18, 18, 18)
                .addComponent(btnAdministerDrug)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblArm, lblBatchNumber, lblBrand, lblDoseNumber, lblDrugCode, lblGivenBy, lblInjectionStatus, lblManufacturingDate});

    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxDrugListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDrugListActionPerformed
        // TODO add your handling code here:
        comboBoxDrugBrand.removeAllItems();
        VaccineDetails prod = (VaccineDetails)comboBoxDrugList.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        populateBrandComboBox(prod);
  
        
    }//GEN-LAST:event_comboBoxDrugListActionPerformed

    private void btnAdministerDrugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministerDrugActionPerformed
        // TODO add your handling code here:
        
    
        try
        {
     
            
             VaccineDetails vp = (VaccineDetails)comboBoxDrugList.getSelectedItem();
        String vaccineCode = vp.getVaccineDefinition().getVaccineCode();
        
        String brand = (String)comboBoxDrugBrand.getSelectedItem();
        
        String batchID = (String)comboBoxBatchNumber.getSelectedItem();
        VaccineDetails prod = null;
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization && prod== null)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineDetails product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brand) && product.getBatchId().equalsIgnoreCase(batchID) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                      prod=product;
                      break;
                   }
               }
           }
       }
                       
        Date administeredDate = new Date();        
        
        String siteRoute = null;
        String status = null;
        siteRoute = (String)comboBoxInjectingArm.getSelectedItem();
        status = (String)comboBoxStatus.getSelectedItem();
        
   
        AdministeredVaccineDetails administeredVaccine = null;
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                administeredVaccine = hospOrg.getClinic().addNewAdministeredVaccine();
            }
        }
        
     
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                for(VaccineDetails product : hospOrg.getClinic().getVaccineInventoryClinic())
                {
                    if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && product.getBatchId().equalsIgnoreCase(batchID))
                    {administeredVaccine.setVaccineProduct(product);
                    break;
                    }
                        
                }
            }
        }
        
    
       for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                for(VaccineDetails p: hospOrg.getClinic().getVaccineInventoryClinic())
                {
                    
                    
                    if(p.equals(administeredVaccine.getVaccineProduct()))
                    {   
                        if(p.getAvailablity()<0)
                        {
                            JOptionPane.showMessageDialog(null, "Not enough quantity of vaccine!");
                            flagg=1;
                        }
                        else
                        {p.setAvailablity(p.getAvailablity()-1);
                            flagg=2;
                        }
                    }
                }
                        
                }
            }
        
        if (flagg==2){
        int dose = Integer.parseInt(txtDoseNumber.getText());
        administeredVaccine.setDoseNumber(dose);
        administeredVaccine.setshotstatus(status);
        administeredVaccine.setProvider(userAccount);
        administeredVaccine.setSiteRoute(siteRoute);
        administeredVaccine.setDate(administeredDate);
        administeredVaccine.setPatient(patient);
        if(status.equalsIgnoreCase("Fail"))
        {
            administeredVaccine.setfailedReason("Failed");
        }
        
        

        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                AdministeredVaccineDetails v = hospOrg.getClinic().addNewAdministeredVaccine();
                v = administeredVaccine;
            }
        }
    
        AdministeredVaccineDetails av = patient.addNewAdministeredVaccine();
        av=administeredVaccine;
       
       
        JOptionPane.showMessageDialog(null, "Vaccination Done !");
      
        
        }}
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter numeric data in dose field");
            return;
        }
        


    }//GEN-LAST:event_btnAdministerDrugActionPerformed

    private void comboBoxDrugBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDrugBrandActionPerformed
        // TODO add your handling code here:
        comboBoxBatchNumber.removeAllItems();
        String brand = (String)comboBoxDrugBrand.getSelectedItem();
        if(brand == null)
        {
            return;
        }
        
        populateBatchComboBox(brand);
        
        
    }//GEN-LAST:event_comboBoxDrugBrandActionPerformed

    private void comboBoxBatchNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBatchNumberActionPerformed
        // TODO add your handling code here:
        populateTextFields();
    }//GEN-LAST:event_comboBoxBatchNumberActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void comboBoxInjectingArmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxInjectingArmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxInjectingArmActionPerformed

    private void comboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministerDrug;
    private javax.swing.JButton btnback;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox comboBoxBatchNumber;
    private javax.swing.JComboBox comboBoxDrugBrand;
    private javax.swing.JComboBox comboBoxDrugList;
    private javax.swing.JComboBox comboBoxInjectingArm;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblArm;
    private javax.swing.JLabel lblBatchNumber;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblDoseNumber;
    private javax.swing.JLabel lblDrugCode;
    private javax.swing.JLabel lblDrugDetails;
    private javax.swing.JLabel lblGivenBy;
    private javax.swing.JLabel lblInjectionStatus;
    private javax.swing.JLabel lblManufacturingDate;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JTextField txtDoctor;
    private javax.swing.JTextField txtDoseNumber;
    private javax.swing.JTextField txtManufacturingDate;
    private javax.swing.JTextField txtPatientName;
    // End of variables declaration//GEN-END:variables
}
