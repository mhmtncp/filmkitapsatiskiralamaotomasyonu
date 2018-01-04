
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.SpringLayout;


/**
 * @author Java_sabah
 */
public class DB {
    
    private String driver = "com.mysql.jdbc.Driver";
    private String dbName = "filmbook";
    private String dbUser = "root";
    private String dbPass = "";
    private String url = "jdbc:mysql://localhost/";
    final private String encode = "?useUnicode=true&characterEncoding=utf-8";
    
    private Connection conn = null ;
    private Statement st = null;
    
    public DB(){
    
    }
    
    public DB(String dbName,String dbUser,String dbPass){
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        
    }
    
    public Statement connect(){
        
        try {
            if (conn == null) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url + dbName + encode, dbUser, dbPass);
                st = conn.createStatement();
            }
            System.out.println("DB BAĞLANTISI SAĞLANDI");
        } catch (Exception e) {
            System.err.println("DB BAĞLANTI HATASI" + e);
        }
        
        return st;
    }
    
    public void close(){
        try {
            if (st != null) {
                st.close();
                st = null;
                System.out.println("STATEMENT KAPATILDI");
                
            }
            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("CONNECTİON KAPATILDI");
            }
        } catch (Exception e) {
            System.err.println("DATABASE KAPATMA HATASI" + e);
        }
    }
    
}
