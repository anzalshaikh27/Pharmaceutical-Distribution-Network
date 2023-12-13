/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Vaccine;

import java.util.Date;

/**
 *
 * @author anzal
 */
public class VaccineDetails {
    
    private Vaccine vaccineDef;
    private int vaccineId;
    private static int count = 1;
    private Date manuDate;
    private String batchId;
    private double vaccinePrice;
    private int avail;
    private String manuName;

    public VaccineDetails() {
        vaccineId = count;
        count++;
    }

    public String getManufacturerName() {
        return manuName;
    }

    public void setManufacturerName(String manuName) {
        this.manuName = manuName;
    }
    
    
    
    public int getAvailablity() {
        return avail;
    }

    public void setAvailablity(int avail) {
        this.avail = avail;
    }
    

    public Vaccine getVaccineDefinition() {
        return vaccineDef;
    }

    public void setVaccineDefinition(Vaccine vaccineDef) {
        this.vaccineDef = vaccineDef;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Date getManufactureDate() {
        return manuDate;
    }

    public void setManufactureDate(Date manuDate) {
        this.manuDate = manuDate;
    }


    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public double getVaccinePrice() {
        return vaccinePrice;
    }

    public void setVaccinePrice(double vaccinePrice) {
        this.vaccinePrice = vaccinePrice;
    }

    @Override
    public String toString() {
        return vaccineDef.getVaccineCode();
    }

}
