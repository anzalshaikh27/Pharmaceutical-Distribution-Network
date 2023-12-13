/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.NationalEnterprise;

import Business.Enterprise.Enterprise;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author anzal
 */

public class Manufacturer extends Enterprise {
    
    
    public Manufacturer(String name) {
        super(name , EnterpriseType.Manufacturer);
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    
    
    
}
