/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Clinic;

import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.StateNetwork;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.ClinicOrganization;
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
 * @author sanal
 */
public class AdministerDrugToPatientClinicJPanel extends javax.swing.JPanel {

   
    private final JPanel workContainer;

    private final HospitalEnterprise hospital;
    private final UserAccount userAccount;
    private final ClinicOrganization clinicOrg;
    private final EcoSystem business;
    private final Patient patient;
    private final StateNetwork state;
    private int flagg;
    
    public AdministerDrugToPatientClinicJPanel(JPanel workContainer, HospitalEnterprise hospital, ClinicOrganization clinicOrg, UserAccount userAccount , EcoSystem business, Patient patient, StateNetwork state) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.clinicOrg = clinicOrg;
        this.patient = patient;
        this.state = state;
        txtDoctorName.setText(userAccount.getPerson().getFirstName()+" "+userAccount.getPerson().getLastName());
        txtPatientName.setText(patient.getFirstName() + " " + patient.getLastName());
        comboBoxMedicineCodeList.removeAllItems();
        comboBoxBrand.removeAllItems();
        comboBoxBatchNumber.removeAllItems();
        
        populateVaccineCodeComboBox();
        
    }
    
    private void populateVaccineCodeComboBox()
    {
       comboBoxMedicineCodeList.removeAllItems();
       
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
                       comboBoxMedicineCodeList.addItem(product);
                       vprodList.add(product.getVaccineDefinition().getVaccineCode());
                   }
                   
               }
           }
       }
        
    }
    
    private void populateBrandComboBox(VaccineDetails vaccine)
    {
        comboBoxBrand.removeAllItems();
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
                       comboBoxBrand.addItem(product.getManufacturerName());
                       brandList.add(product.getManufacturerName());
                   }
               }
           }
       }
        
    }
    
    
    private void populateBatchComboBox(String brandName){
        
        comboBoxBatchNumber.removeAllItems();
        VaccineDetails vp = (VaccineDetails)comboBoxMedicineCodeList.getSelectedItem();
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
        VaccineDetails prod = (VaccineDetails)comboBoxMedicineCodeList.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        String vaccineCode = prod.getVaccineDefinition().getVaccineCode();
        
        
        String brand = (String)comboBoxBrand.getSelectedItem();
        
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
                       txtManufactureDate.setText(String.valueOf(product.getManufactureDate()));
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

        lblTitle = new javax.swing.JLabel();
        lblPatient = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblMedicineCode = new javax.swing.JLabel();
        comboBoxMedicineCodeList = new javax.swing.JComboBox();
        lblDoseNumber = new javax.swing.JLabel();
        txtDoseNumber = new javax.swing.JTextField();
        lblManufactureDate = new javax.swing.JLabel();
        txtManufactureDate = new javax.swing.JTextField();
        lblBatchNumber = new javax.swing.JLabel();
        comboBoxBatchNumber = new javax.swing.JComboBox();
        lblArm = new javax.swing.JLabel();
        lblInjectionStatus = new javax.swing.JLabel();
        lblGivenBy = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        btnAdminMedicine = new javax.swing.JButton();
        lblBrand = new javax.swing.JLabel();
        comboBoxBrand = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        comboBoxArm = new javax.swing.JComboBox();
        comboBoxStatus = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Administer Medicine");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPatient.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblPatient.setForeground(new java.awt.Color(0, 51, 102));
        lblPatient.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatient.setText("Patient: ");

        txtPatientName.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtPatientName.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Drug Details:");

        lblMedicineCode.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblMedicineCode.setForeground(new java.awt.Color(0, 51, 102));
        lblMedicineCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMedicineCode.setText("Medicine Code:");

        comboBoxMedicineCodeList.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxMedicineCodeList.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxMedicineCodeList.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxMedicineCodeList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxMedicineCodeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMedicineCodeListActionPerformed(evt);
            }
        });

        lblDoseNumber.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblDoseNumber.setForeground(new java.awt.Color(0, 51, 102));
        lblDoseNumber.setText("Dose Number:");

        txtDoseNumber.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        lblManufactureDate.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        lblManufactureDate.setForeground(new java.awt.Color(0, 51, 102));
        lblManufactureDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblManufactureDate.setText("Manufacture Date:");

        txtManufactureDate.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtManufactureDate.setEnabled(false);

        lblBatchNumber.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblBatchNumber.setForeground(new java.awt.Color(0, 51, 102));
        lblBatchNumber.setText("Batch Number :");

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
        lblArm.setForeground(new java.awt.Color(0, 51, 102));
        lblArm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblArm.setText("Arm");

        lblInjectionStatus.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblInjectionStatus.setForeground(new java.awt.Color(0, 51, 102));
        lblInjectionStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInjectionStatus.setText("Injection Status:");

        lblGivenBy.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblGivenBy.setForeground(new java.awt.Color(0, 51, 102));
        lblGivenBy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGivenBy.setText("Given By:");

        txtDoctorName.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtDoctorName.setEnabled(false);

        btnAdminMedicine.setBackground(new java.awt.Color(0, 0, 102));
        btnAdminMedicine.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAdminMedicine.setForeground(new java.awt.Color(255, 255, 255));
        btnAdminMedicine.setText("Administer Medicine");
        btnAdminMedicine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminMedicineActionPerformed(evt);
            }
        });

        lblBrand.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(0, 51, 102));
        lblBrand.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBrand.setText("Brand:");

        comboBoxBrand.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxBrand.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxBrand.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxBrand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxBrandActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 102));
        btnBack.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 102));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 102));

        comboBoxArm.setBackground(new java.awt.Color(0, 0, 102));
        comboBoxArm.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        comboBoxArm.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxArm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Right", "Left" }));
        comboBoxArm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxArmActionPerformed(evt);
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
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblMedicineCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtManufactureDate, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                    .addComponent(comboBoxArm, 0, 177, Short.MAX_VALUE))
                                                .addGap(338, 338, 338))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(comboBoxMedicineCodeList, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboBoxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(349, 349, 349)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblBatchNumber)
                                            .addComponent(lblDoseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboBoxBatchNumber, 0, 120, Short.MAX_VALUE)
                                            .addComponent(txtDoseNumber)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblManufactureDate)
                                            .addComponent(lblArm)
                                            .addComponent(lblGivenBy)
                                            .addComponent(lblInjectionStatus))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDoctorName, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                            .addComponent(comboBoxStatus, 0, 185, Short.MAX_VALUE))
                                        .addGap(269, 269, 269))
                                    .addComponent(btnAdminMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblArm, lblBrand, lblGivenBy, lblInjectionStatus, lblManufactureDate, lblMedicineCode});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPatient))
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMedicineCode)
                            .addComponent(comboBoxMedicineCodeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatchNumber)
                            .addComponent(comboBoxBatchNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBrand)
                            .addComponent(lblDoseNumber)
                            .addComponent(txtDoseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(lblManufactureDate))
                    .addComponent(txtManufactureDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxArm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArm))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGivenBy)
                    .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInjectionStatus)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdminMedicine)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboBoxArm, comboBoxBrand, comboBoxMedicineCodeList, comboBoxStatus, txtDoctorName, txtManufactureDate});

    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxMedicineCodeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMedicineCodeListActionPerformed
        // TODO add your handling code here:
        comboBoxBrand.removeAllItems();
        VaccineDetails prod = (VaccineDetails)comboBoxMedicineCodeList.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        populateBrandComboBox(prod);
 
    }//GEN-LAST:event_comboBoxMedicineCodeListActionPerformed

    private void btnAdminMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminMedicineActionPerformed
        // TODO add your handling code here:
      
        
        try
        {
         int count =0;
         boolean checkDose = (Integer.parseInt(txtDoseNumber.getText()) < 0);
        if (checkDose) {
            JOptionPane.showMessageDialog(null, "Please enter a valid dose number");
               count = 1;
               System.out.println("Inside dose validation");
            }
       
 
               
             VaccineDetails vp = (VaccineDetails)comboBoxMedicineCodeList.getSelectedItem();
            String vaccineCode = vp.getVaccineDefinition().getVaccineCode();
        
        String brand = (String)comboBoxBrand.getSelectedItem();
        
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
        siteRoute = (String)comboBoxArm.getSelectedItem();
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
                            JOptionPane.showMessageDialog(null, "Vaccine Out of Stock!");
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
        
   
        
        
        if(count == 0)
        {
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
       
       
        JOptionPane.showMessageDialog(null, "Vaccination Done!");
     
        }
        }
       
        
      }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter numeric data in dose field");
            //return;
        }
  
    }//GEN-LAST:event_btnAdminMedicineActionPerformed

    private void comboBoxBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBrandActionPerformed
        // TODO add your handling code here:
        comboBoxBatchNumber.removeAllItems();
        String brand = (String)comboBoxBrand.getSelectedItem();
        if(brand == null)
        {
            return;
        }
        
        populateBatchComboBox(brand);
        
        
    }//GEN-LAST:event_comboBoxBrandActionPerformed

    private void comboBoxBatchNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBatchNumberActionPerformed
        // TODO add your handling code here:
        populateTextFields();
    }//GEN-LAST:event_comboBoxBatchNumberActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboBoxArmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxArmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxArmActionPerformed

    private void comboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminMedicine;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox comboBoxArm;
    private javax.swing.JComboBox comboBoxBatchNumber;
    private javax.swing.JComboBox comboBoxBrand;
    private javax.swing.JComboBox comboBoxMedicineCodeList;
    private javax.swing.JComboBox comboBoxStatus;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblArm;
    private javax.swing.JLabel lblBatchNumber;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblDoseNumber;
    private javax.swing.JLabel lblGivenBy;
    private javax.swing.JLabel lblInjectionStatus;
    private javax.swing.JLabel lblManufactureDate;
    private javax.swing.JLabel lblMedicineCode;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtDoseNumber;
    private javax.swing.JTextField txtManufactureDate;
    private javax.swing.JTextField txtPatientName;
    // End of variables declaration//GEN-END:variables
}
