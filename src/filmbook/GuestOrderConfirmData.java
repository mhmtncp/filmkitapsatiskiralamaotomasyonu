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
public class GuestOrderConfirmData {
    String GOCDStatus = "" + UserLoginFrame.status;
    int GOCDId = 2;
    
    public void GuestOrderConfirmed(){
        if (!OperationFrame.buyFilmList.isEmpty()) {
            double buyFilmPrice = 0.0;
            for (String string : OperationFrame.buyFilmList) {
                
            String queryPrice = "SELECT film_purchase_price FROM film WHERE film_id = '"+string+"'";
            
            DB db = new DB();
            
            try {
                ResultSet rs = db.connect().executeQuery(queryPrice);
                
                while (rs.next()) {                    
                buyFilmPrice = rs.getDouble("" + FilmEnum.film_purchase_price);
                
                }
            } catch (SQLException e) {
                System.err.println("ZİYARETCİ FİLM FİYAT CEKME HATASI" + e);
            }finally{
                db.close();
            }
            String query = "INSERT INTO purchase VALUES (NULL, '"+GOCDId+"', '"+string +"' ,'"+GOCDStatus+"', '"+buyFilmPrice+"', b'0' , NOW())";
            
                try {
                    int update = db.connect().executeUpdate(query);
                    
                } catch (SQLException e) {
                    System.err.println("ZİYARETCİ FİLM SATIS EKLEME HATASI" + e);
                }finally{
                    buyFilmPrice = 0.0;
                    db.close();
                }
            String queryFilmStock = "UPDATE film SET film_amount = film_amount - 1 WHERE film_id = '"+string+"' AND film_amount > 0";

                try {
                    int stockUpdate = db.connect().executeUpdate(queryFilmStock);
                } catch (SQLException e) {
                    System.err.println("ZİYARETCİ FİLM SATIS STOK UPDATE HATASI " + e);
                }finally{
                    db.close();
            }
            
               
           
    }
             if (!OperationFrame.buyBookList.isEmpty()) {
                 double buyBookPrice = 0.0;
                    for (String string : OperationFrame.buyBookList) {
                        String queryPrice = "SELECT book_purchase_price FROM book WHERE book_id = '"+string+"'";
                        
                        DB db = new DB();
                        
                        try {
                            ResultSet rs = db.connect().executeQuery(queryPrice);
                            while (rs.next()) {                                
                                buyBookPrice = rs.getDouble("" + BookEnum.book_purchase_price);
                            }
                        } catch (SQLException e) {
                            System.err.println("ZİYARETCİ KİTAP FİYAT CEKME HATASI" + e);
                        }finally{
                            db.close();
                        }
                        String query = "INSERT INTO purchase VALUES (null,'"+GOCDId+"' ,'" + string + "' , '" + GOCDStatus + "' , '" + buyBookPrice + "', b'1' ,NOW())";

                        try {
                            int update = db.connect().executeUpdate(query);
                        } catch (SQLException e) {
                            System.err.println("ZİYARETCİ KİTAP SATIS EKLEME HATASI" + e);
                        } finally{
                            buyBookPrice = 0.0;
                            db.close();
                        }
                        String queryStock = "UPDATE book SET book_amount = book_amount -1 WHERE book_id = '"+string+"' AND book_amount > 0" ;
                        try {
                            int stockUpdate = db.connect().executeUpdate(queryStock);
                        } catch (Exception e) {
                            System.err.println("ZİYARETCİ KITAP SATIS STOK UPDATE HATASI " + e);
                        }   finally{
                            db.close();
                        }
                        
                        
                    }
                }
            
            
            
            
            
            
        }
    }
    
}
