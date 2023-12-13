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

public class ProviderVaccineInventory {
    private ArrayList<VaccineDetails> vaccineDetailsList;

    public ProviderVaccineInventory() {
        
        vaccineDetailsList = new ArrayList<>();
    }

    public ArrayList<VaccineDetails> getVaccineDetailsList() {
        return vaccineDetailsList;
    }

    public void setVaccineDetailsList(ArrayList<VaccineDetails> vdl) {
        this.vaccineDetailsList = vdl;
    }
    
    public VaccineDetails addNewVaccineDetail(){
        
        VaccineDetails vd = new VaccineDetails();
        vaccineDetailsList.add(vd);
        return vd;
  
    }
    
    public void removeVaccineDetail(VaccineDetails vd){
        
        vaccineDetailsList.remove(vd);
    }
}
