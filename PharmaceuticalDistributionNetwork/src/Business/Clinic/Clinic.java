
package Business.Clinic;

import Business.Vaccine.AdministeredVaccineDetails;
import Business.Vaccine.VaccineDetails;
import java.util.ArrayList;
/**
 *
 * @author sanal
 */
public class Clinic {
    private String clinicName;
    private boolean registered;
    private ArrayList<VaccineDetails> vaccineDetails;
    private ArrayList<AdministeredVaccineDetails> administeredVaccineDetails;

    public Clinic() {
        registered = false;
        vaccineDetails = new ArrayList<>();
        administeredVaccineDetails = new ArrayList<>();

    }    
    
    
    public ArrayList<VaccineDetails> getVaccineInventoryClinic() {
        return vaccineDetails;
    }

    public ArrayList<AdministeredVaccineDetails> getAdministeredVaccineList() {
        return administeredVaccineDetails;
    }

    public void setAdministeredVaccineList(ArrayList<AdministeredVaccineDetails> administeredVaccineDetails) {
        this.administeredVaccineDetails = administeredVaccineDetails;
    }
    
    //Creating getters and setters
    
    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public VaccineDetails addVaccine(VaccineDetails vaccine) {
        vaccineDetails.add(vaccine);
        return vaccine;

    }

    public VaccineDetails addNewVaccineDetails() {
        VaccineDetails details = new VaccineDetails();
        vaccineDetails.add(details);
        return details;

    }

    public void removeVaccine(VaccineDetails vaccine) {

        vaccineDetails.remove(vaccine);

    }

    public AdministeredVaccineDetails addNewAdministeredVaccine() {
        AdministeredVaccineDetails vaccineDetails = new AdministeredVaccineDetails();
        administeredVaccineDetails.add(vaccineDetails);
        return vaccineDetails;

    }

    public int getTotalAdministeredVaccines() {
        int sum = 0;
        if (administeredVaccineDetails != null) {
            for (AdministeredVaccineDetails vaccine : administeredVaccineDetails) {
                sum = sum + 1;
            }

        }

        return sum;

    }

    public int getTotalVaccinesFailed() {
        int sum = 0;
        if (administeredVaccineDetails != null) {
            for (AdministeredVaccineDetails av : administeredVaccineDetails) {
                if (av != null) {
                    if (av.getshotstatus()!= null) {
                        if (av.getshotstatus().equalsIgnoreCase("Fail")) {
                            sum = sum + 1;
                        }
                    }
                }
            }

        }

        return sum;

    }
    
    public int getTotalStoredVaccines() {
        int sum = 0;
        if (vaccineDetails != null) {
            for (VaccineDetails vd : vaccineDetails) {
                sum = sum + vd.getAvailablity();
            }
            sum = sum + getTotalAdministeredVaccines();
        }

        return sum;

    }

    @Override
    public String toString() {
        return clinicName;
    }

}
