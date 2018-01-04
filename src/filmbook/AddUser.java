
package filmbook;

import db.DB;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Java_sabah
 */
public class AddUser {
    
    public int addUser(String username,String password,String firstName,String lastName,String email,String address){
        int don = -1;
        String query = "INSERT INTO user values (null,'"+username+"','"+password+"','"+firstName+"','"+lastName+"','"+email+"','"+address+"')";
        DB db = new DB();
        SignUpFrame suf = new SignUpFrame();
        try {
            int ekle = db.connect().executeUpdate(query);
            don = ekle;
        } catch (HeadlessException | SQLException e) {
            
            System.err.println("ÜYE OLUŞTURMA HATASI " + e);
        }finally{
            
            db.close();
        }
        return don;
    }

}
