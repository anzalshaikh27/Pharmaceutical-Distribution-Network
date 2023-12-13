/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Warehouse;


import Business.Vaccine.VaccineDetails;
import java.util.ArrayList;

/**
 *
 * @author anzal
 */

//Creating class Warehouse
public class Warehouse {
    
    private ArrayList<VaccineDetails> vaccineInventoryList;
    private String location;
    private int id;
    private static int count = 1;
    
    public Warehouse() {
        
        vaccineInventoryList = new ArrayList<>();
        id= count++;
    }
    
    
    public ArrayList<VaccineDetails> getVaccineInventoryList() {
        return vaccineInventoryList;
    }

    public void setVaccineInventoryList(ArrayList<VaccineDetails> vaccineProductList) {
        this.vaccineInventoryList = vaccineProductList;
    }
    
    public VaccineDetails addNewVaccineProduct(){
        
        VaccineDetails vaccineProduct = new VaccineDetails();
        vaccineInventoryList.add(vaccineProduct);
        return vaccineProduct;

    }
    
    public void addVaccineProduct(VaccineDetails vp){
        
        vaccineInventoryList.add(vp);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public void removeVaccineProduct(VaccineDetails vaccineProduct){
        vaccineInventoryList.remove(vaccineProduct);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
