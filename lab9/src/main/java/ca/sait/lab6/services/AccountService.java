
package ca.sait.lab6.services;

import ca.sait.lab6.dataacess.UserDB;
import ca.sait.lab6.models.User;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saksham
 */
public class AccountService {
     public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
     public boolean forgotPassword(String email, String path) {
         try {
             UserDB userDB = new UserDB();
             User user = userDB.get(email);
             String to = user.getEmail();
             String subject = "Notes App Login";
             String template = path + "/emailtemplates/login.html";
             
             HashMap<String, String> tags = new HashMap<>();
             tags.put("firstname", user.getFirstName());
             tags.put("lastname", user.getLastName());
             tags.put("email", user.getEmail());
             tags.put("password", user.getPassword());
             
             GmailService.sendMail(to, subject, template, tags);
         
         } catch (Exception ex) {
            return false; 
            //Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return true;
    }
}
