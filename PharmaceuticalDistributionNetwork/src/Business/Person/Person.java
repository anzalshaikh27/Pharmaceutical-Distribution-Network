
package Business.Person;

import java.util.Date;

/**
 *
 * @author sanal
 */
public abstract class Person {
    
    private String fName;
    private String lName;
    private String email;
    private long phone;
    private Date dob;


    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String firstName) {
        this.fName = firstName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lastName) {
        this.lName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dob;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dob = dateOfBirth;
    }

    @Override
    public String toString() {
        return fName+ " "+lName;
    }
    
}
