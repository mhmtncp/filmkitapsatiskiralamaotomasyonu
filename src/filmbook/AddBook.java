/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmbook;

import db.DB;
import java.sql.SQLException;

/**
 *
 * @author Java_sabah
 */
public class AddBook {

    public int addBook(String bookName, String bookAuthor, String bookGenre, String bookDescription, String bookPublisher, String bookAmount, String bookRentPrice, String bookPurchasePrice) {
        int rtrn = 0;

        String query = "INSERT INTO book VALUES (null,'" + bookName + "','" + bookAuthor + "','" + bookGenre + "','" + bookDescription + "','" + bookPublisher + "','" + bookAmount + "','" + bookRentPrice + "','" + bookPurchasePrice + "')";

        DB db = new DB();

        try {
            int add = db.connect().executeUpdate(query);
            rtrn = add;

        } catch (SQLException e) {
            System.err.println("KİTAP EKLEME HATASI " + e);
        } finally {

            db.close();
        }
        return rtrn;

    }

}
