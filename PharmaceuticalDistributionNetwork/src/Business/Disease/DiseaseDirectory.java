/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Disease;

import java.util.ArrayList;

/**
 *
 * @author sanal
 */
public class DiseaseDirectory {
    
    private ArrayList<Disease> diseaseDirectory;

    public DiseaseDirectory() {
        
        diseaseDirectory = new ArrayList<>();
    }

    public ArrayList<Disease> getdiseaseDirectory() {
        return diseaseDirectory;
    }

    public void setdiseaseDirectory(ArrayList<Disease> diseaseDirectory) {
        this.diseaseDirectory = diseaseDirectory;
    }
    
    
    public Disease addNewDisease(){
        
        Disease newD = new Disease();
        diseaseDirectory.add(newD);
        return newD;        
        
    }
    
    
    public void removeDisease(Disease disease){
        
        diseaseDirectory.remove(disease);
    }
   
}
