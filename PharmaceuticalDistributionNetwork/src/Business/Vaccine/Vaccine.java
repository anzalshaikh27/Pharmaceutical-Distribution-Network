/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Vaccine;

import Business.Disease.Disease;
import Business.Network.StateNetwork;

/**
 *
 * @author anzal
 */

public class Vaccine {
    
    private String vaccineCode;
    private String vaccineName;
    private StateNetwork state;
    private Disease disease;
    

    public Vaccine() {
    }

    public StateNetwork getState() {
        return state;
    }

    public void setState(StateNetwork state) {
        this.state = state;
    }


    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }


    public String getVaccineCode() {
        return vaccineCode;
    }

    public void setVaccineCode(String vaccineCode) {
        this.vaccineCode = vaccineCode;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    @Override
    public String toString() {
        return vaccineCode;
    }

}
