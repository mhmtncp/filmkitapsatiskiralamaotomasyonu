/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmbook;

import db.DB;
import enums.BookEnum;
import enums.FilmEnum;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MNK
 */
public class CalculatePrice {
    
    
    public void calculatePrice(){
        for (String string : OperationFrame.buyFilmList) {
            String query = "SELECT film_purchase_price FROM film WHERE film_id = '"+string+"'";
            DB db = new DB();
            
            try {
                ResultSet rs = db.connect().executeQuery(query);
                
                while (rs.next()) {                  
                   
                    UserLoginFrame.Price = UserLoginFrame.Price + rs.getDouble("" + FilmEnum.film_purchase_price);
                    
                }
            } catch (SQLException e) {
                System.err.println("FIYAT DATASI CEKME HATASI " + e);
            } finally{
                db.close();
            }
            
            
            
        }
        for (String string : OperationFrame.buyBookList) {
            String query = "SELECT book_purchase_price FROM book WHERE book_id = '"+string+"'";
            DB db = new DB();
            
            try {
                ResultSet rs = db.connect().executeQuery(query);
                
                while (rs.next()) {                    
                    UserLoginFrame.Price = UserLoginFrame.Price + rs.getDouble("" + BookEnum.book_purchase_price);
                            
                }
            } catch (SQLException e) {
                System.err.println("KİTAP FİYAT CEKME HATASI " + e);
            }finally{
                db.close();
            }
        }
        for (String string : OperationFrame.rentFilmList) {
            String query = "SELECT film_rent_price FROM film WHERE film_id = '"+string+"'";
            DB db = new DB();
            try {
                ResultSet rs = db.connect().executeQuery(query);
                while (rs.next()) {                    
                    UserLoginFrame.Price = UserLoginFrame.Price + rs.getDouble("" + FilmEnum.film_rent_price);
                }

                
                
            } catch (SQLException e) {
                System.err.println("KİRALIK FİLM FİYAT CEKME HATASI" + e);
            } finally{
                db.close();
            }
        }
        for (String string : OperationFrame.rentBookList) {
            String query = "SELECT book_rent_price FROM book WHERE book_id = '"+string+"'";
            DB db = new DB();
            
            try {
                ResultSet rs = db.connect().executeQuery(query);
                
                while (rs.next()) {                    
                UserLoginFrame.Price = UserLoginFrame.Price + rs.getDouble("" + BookEnum.book_rent_price);    
                }
                
            } catch (SQLException e) {
                System.err.println("KITAP KIRALAMA FIYAT CEKME HATASI " + e);
            }finally{
                db.close();
            }
        }
        
        
        System.out.println("PRİCE : " + UserLoginFrame.Price);
        System.out.println("MUSTERİ : " + UserLoginFrame.LoggedInUserName);
    }
    
    
}
