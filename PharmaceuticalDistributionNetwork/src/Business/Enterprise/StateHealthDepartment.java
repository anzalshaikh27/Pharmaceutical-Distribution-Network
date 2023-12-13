/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author anzal
 */
public class StateHealthDepartment extends Enterprise {

    public StateHealthDepartment(String stateName) {
        super(stateName, EnterpriseType.StateHealthDepartment);
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
