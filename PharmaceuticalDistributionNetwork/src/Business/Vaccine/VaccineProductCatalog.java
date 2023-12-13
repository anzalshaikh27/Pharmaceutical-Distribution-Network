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

public class VaccineProductCatalog {
    
    private ArrayList<VaccineDetails> vaccineDetailList;

    public VaccineProductCatalog() {
        
        vaccineDetailList = new ArrayList<>();
    }

    public ArrayList<VaccineDetails> getVaccineProductList() {
        return vaccineDetailList;
    }

    public void setVaccineProductList(ArrayList<VaccineDetails> vdl) {
        this.vaccineDetailList = vdl;
    }
    
    public VaccineDetails addNewVaccineProduct(){
        
        VaccineDetails vd = new VaccineDetails();
        vaccineDetailList.add(vd);
        return vd;

    }
    
    public void removeVaccineProduct(VaccineDetails vaccineProduct){  
        vaccineDetailList.remove(vaccineProduct);
    }

    
}
