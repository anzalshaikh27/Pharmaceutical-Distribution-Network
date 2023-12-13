/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.NationalEnterprise;

import java.util.ArrayList;

/**
 *
 * @author anzal
 */

public class ManufacturerDirectory {
    
    private ArrayList<Manufacturer> manufacturerDirectory;

    public ManufacturerDirectory() {
        
        manufacturerDirectory = new ArrayList<>();
        
    }

    public ArrayList<Manufacturer> getManufacturerDirectory() {
        return manufacturerDirectory;
    }

    public void setManufacturerDirectory(ArrayList<Manufacturer> manufacturerDirectory) {
        this.manufacturerDirectory = manufacturerDirectory;
    }
    
    public Manufacturer addNewManufacturer(String name){
        
        Manufacturer nm = new Manufacturer(name);
        manufacturerDirectory.add(nm);
        return nm;  
    }
    
    public void removeManufacturer(Manufacturer m){
        
        manufacturerDirectory.remove(m);
    }
    
    
}
