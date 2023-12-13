/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Order;

import Business.Vaccine.VaccineDetails;

/**
 *
 * @author anzal
 */
public class OrderItem {
    
    private VaccineDetails vaccineDetails;
    private int quantity;

    public VaccineDetails getVaccineDetails() {
        return vaccineDetails;
    }

    public void setVaccineDetails(VaccineDetails vaccineDetails) {
        this.vaccineDetails = vaccineDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return vaccineDetails.getVaccineDefinition().getVaccineName();
    }
}
