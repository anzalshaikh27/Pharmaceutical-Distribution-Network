
package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sanal
 */

public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person employee, Role role){
        UserAccount uA = new UserAccount();
        uA.setUsername(username);
        uA.setPassword(password);
        uA.setPerson(employee);
        uA.setRole(role);
        userAccountList.add(uA);
        return uA;
    }
    
    public void removeUserAccount(UserAccount userAccount){
        
        userAccountList.remove(userAccount);
    }
    
    public boolean checkIfUserAccountExists(String username){
        
        for(UserAccount ua: userAccountList){
            if(ua.getUsername().equals(username))
            return true;
        }
        return false;
    }
    
    
}

