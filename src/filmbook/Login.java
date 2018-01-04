
package filmbook;

import db.DB;
import enums.UserEnum;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Java_sabah
 */
public class Login {
    
    public int userLogin(String username , String password){
        DB db = new DB();
        String query = "select count(*) as count ,status,user_id,user_first_name,user_last_name,user_address from user WHERE user_username like '"+username+"' and user_password like '"+password+"'";
        
        try {
            ResultSet rs = db.connect().executeQuery(query);
          
            while (rs.next()) {
                if (rs.getInt("count") != 1) {//UYE YOKSA 1 DISINDA BISEY GELIR HATA VERDİRMEYİ UNUTMA
                    UserLoginFrame.status = 4; // ??? EMİN DEGİLİM
                    System.out.println("STATUS " + UserLoginFrame.status);
                    
                }else{
                    UserLoginFrame.LoggedInUserId = rs.getInt("" + UserEnum.user_id);
                    UserLoginFrame.status = rs.getInt("" + UserEnum.status);
                    UserLoginFrame.LoggedInUserName = rs.getString("" + UserEnum.user_first_name);
                    UserLoginFrame.LoggedInUserLastName = rs.getString("" + UserEnum.user_last_name);
                    UserLoginFrame.LoggedInUserAddress = rs.getString("" + UserEnum.user_address);
                    System.out.println("STATUS " + UserLoginFrame.status);
                    System.out.println("ID : " + UserLoginFrame.LoggedInUserId);
                    System.out.println("NAME : " + UserLoginFrame.LoggedInUserName);
                    System.out.println("LASTNAME : " + UserLoginFrame.LoggedInUserLastName);
                    System.out.println("ADDRESS : " + UserLoginFrame.LoggedInUserAddress);
                    
                    
                 }
                
                
                
                
            }
                    
           
        } catch (SQLException e) {
            System.err.println("LOGIN HATASI" + e);
        }finally{
            db.close();
        }
        return -1;
    }
    
   

}
