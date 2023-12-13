/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Warehouse;

import java.util.ArrayList;

/**
 *
 * @author anzal
 */

//Creating class WarehouseDirectory
public class WarehouseDirectory {
    
    private ArrayList<Warehouse> warehouseList;

    public WarehouseDirectory() {
        warehouseList = new ArrayList<>();
    }

    public ArrayList<Warehouse> getWarehouseList() {
        return warehouseList;
    }
    
    public Warehouse addNewWareHouse(){
        
        Warehouse wh = new Warehouse();
        warehouseList.add(wh);
        return wh;
    }
    
    
    public void removeWarehouse(Warehouse wh){
        
        warehouseList.remove(wh);
    }
}
