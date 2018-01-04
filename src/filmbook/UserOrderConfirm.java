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
public class UserOrderConfirm {

    String UOCStatus = "" + UserLoginFrame.status;
    String UOCPrice = "" + UserLoginFrame.Price;
    int UOCuid = UserLoginFrame.LoggedInUserId;

    public void OrderConfirmed() {
        if (!OperationFrame.buyFilmList.isEmpty()) {
            Double buyFilmPrice = 0.0;
            for (String string : OperationFrame.buyFilmList) {

                String queryPrice = "SELECT film_purchase_price FROM film WHERE film_id = '" + string + "'";
                
                DB db = new DB();
                
                try {
                    ResultSet rs = db.connect().executeQuery(queryPrice);
                    while (rs.next()) {                        
                        buyFilmPrice = rs.getDouble("" + FilmEnum.film_purchase_price);
                    }
                } catch (SQLException e) {
                    System.err.println("FİLM FİYAT CEKME HATASI" + e);
                } finally{
                    db.close();
                }
                String query = "INSERT INTO purchase VALUES (null ,'"+UOCuid+"' ,'" + string + "' , '" +UOCStatus+ "' , '" + buyFilmPrice + "', 0 ,NOW())";
                try {
                    int ekle = db.connect().executeUpdate(query);
                    
                } catch (SQLException e) {
                    System.err.println("INSERT BUY FILM HATASI" + e);
                }finally{
                    buyFilmPrice = 0.0;
                    db.close();
                }
                String stok = "UPDATE film SET film_amount = film_amount - 1 WHERE film_id = '"+string+"' AND film_amount > 0";
                try {
                    int update = db.connect().executeUpdate(stok);
                } catch (SQLException e) {
                    System.err.println("FİLM STOK GUNCELLEME HATASI : " + e);
                }finally{
                    db.close();
                }
                

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
                    System.err.println("BOOK PURCHASE PRİCE CEKME HATASI " + e);
                } finally{
                    
                    db.close();
                }
                
                String query = "INSERT INTO purchase VALUES (null,'"+UOCuid+"' ,'" + string + "' , '" + UOCStatus + "' , '" + buyBookPrice + "', 1 ,NOW())";
                try {
                    int ekle = db.connect().executeUpdate(query);
                    
                } catch (SQLException e) {
                    System.err.println("KITAP SATIN ALMA EKLEME HATASI" + e);
                }finally{
                    buyBookPrice = 0.0;
                    db.close();
                }
                String stok = "UPDATE book SET book_amount = book_amount - 1 WHERE book_id = '"+string+"' AND book_amount > 0";
                try {
                    int stockupdate = db.connect().executeUpdate(stok);
                } catch (SQLException e) {
                    System.err.println("STOK KITAP UPDATE HATASI" + e);
                } 

            }

        }
        // rent type 0 = FİLM,
        
        
        
        
       
        
        
        if (!OperationFrame.rentFilmList.isEmpty()) {
            double rentFilmPrice = 0.0;
            for (String string : OperationFrame.rentFilmList) {
                
                String queryPrice = "SELECT film_rent_price FROM film WHERE film_id = '"+ string +"'";
                
                DB db = new DB();
                
                try {
                    ResultSet rs = db.connect().executeQuery(queryPrice);
                    while (rs.next()) {                        
                        rentFilmPrice = rs.getDouble("" + FilmEnum.film_rent_price);
                    }
                } catch (SQLException e) {
                    System.err.println("FİLM KİRA FİYAT CEKME HATASI" + e);
                }finally{
                    db.close();
                }
                
                String query = "INSERT INTO rent VALUES(NULL, '"+UOCuid+"' ,'" + string + "','" + rentFilmPrice + "',  b'0' , NOW(),null,null )";
                
                try {
                    int updateRent = db.connect().executeUpdate(query);
                } catch (SQLException e) {
                    System.err.println("FİLM KİRALAMA UPDATE HATASI" + e);
                }  finally{
                    rentFilmPrice = 0.0;
                    db.close();
                }
                String queryStock = "UPDATE film SET film_amount = film_amount - 1 WHERE film_id = '"+string+"' AND film_amount > 0";
                
                try {
                    int updateFilmStok = db.connect().executeUpdate(queryStock);
                } catch (SQLException e) {
                    System.err.println("STOK FİLM KİRA UPDATE HATASI " + e);
                } finally{
                    db.close();
                }
                
            }
        }

        if (!OperationFrame.rentBookList.isEmpty()) {
            double rentBookPrice = 0.0;
            for (String string : OperationFrame.rentBookList) {
               
                String queryPrice = "SELECT book_rent_price FROM book WHERE book_id = '"+string+"'";
                
                DB db = new DB();

                try {
                    ResultSet rs = db.connect().executeQuery(queryPrice);
                    while (rs.next()) {
                       rentBookPrice = rs.getDouble("" + BookEnum.book_rent_price);
                        
                    }
                } catch (Exception e) {
                    System.err.println("BOOK FİYAT CEKME HATASI" + e);
                } finally {
                    db.close();
                }
                 String query = "INSERT INTO rent VALUES(NULL, '"+UOCuid+"' ,'" + string + "','" + rentBookPrice + "',  b'1' , NOW(),null,null )";
                
                try {
                    int ekle = db.connect().executeUpdate(query);
                } catch (SQLException e) {
                    System.err.println("RENT BOOK DATA EKLEME HATASI " + e);
                }finally{
                    rentBookPrice = 0.0;
                    db.close();
                }
                
                String queryBookStock = "UPDATE book SET book_amount = book_amount - 1 WHERE book_id = '"+string+"' AND book_amount > 0";
                try {
                   int stockUpdate = db.connect().executeUpdate(queryBookStock);
                } catch (SQLException e) {
                    System.err.println("BOOK STOCK RENT HATASI" + e);
                }finally{
                    db.close();
                }
                
                
            }
        }

    }

}
