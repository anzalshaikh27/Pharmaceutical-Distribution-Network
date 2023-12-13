/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author anzal
 */

public class VaccineDirectory {
    
    private ArrayList<Vaccine> vaccineCatalog;

    public VaccineDirectory() {
        
        vaccineCatalog = new ArrayList<>();
    }

    public ArrayList<Vaccine> getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(ArrayList<Vaccine> vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }
    
    public Vaccine addNewVaccineDefinition(){
        
        Vaccine newVaccine = new Vaccine();
        vaccineCatalog.add(newVaccine);
        return newVaccine;
        
    }
    
    public void removeVaccineDefinition(Vaccine vaccine){
        
        vaccineCatalog.remove(vaccine);
    }
    
    
    
}
