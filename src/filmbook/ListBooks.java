/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmbook;

import Properties.Book;

import db.DB;
import enums.BookEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MNK
 */
public class ListBooks {
    List<Book> books = new ArrayList<>();
    
    public void gatherData(){
        books.clear();
        DB db = new DB();
        String query = "SELECT * FROM book";
        
        
        
        try {
            ResultSet rs = db.connect().executeQuery(query);
            
            while (rs.next()) {
                Book book = new Book();
                book.setBid(rs.getString("" + BookEnum.book_id));
                book.setbName(rs.getString("" + BookEnum.book_name));
                book.setbAuthor(rs.getString("" + BookEnum.book_author));
                book.setbGenre(rs.getString("" + BookEnum.book_genre));
                book.setbDescription(rs.getString("" + BookEnum.book_description));
                book.setbPublisher(rs.getString("" + BookEnum.book_publisher));
                book.setbAmount(rs.getString("" + BookEnum.book_amount));
                book.setbRentPrice(rs.getString("" + BookEnum.book_rent_price));
                book.setbPurchasePrice(rs.getString("" + BookEnum.book_purchase_price));
                
                
                books.add(book);
            }
            
            
            
            
            
        } catch (SQLException e) {
            System.err.println("KİTAP DATASI CEKME HATASI" + e);
        }finally{
            db.close();
        }
        
    }
    
    public DefaultTableModel listBooks(){
        gatherData();
        
        DefaultTableModel bookTable = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        bookTable.addColumn("ID");
        bookTable.addColumn("Book Name");
        bookTable.addColumn("Author");
        bookTable.addColumn("Genre");
        bookTable.addColumn("Description");
        bookTable.addColumn("Publisher");
        bookTable.addColumn("Amount");
        bookTable.addColumn("Rent Price");
        bookTable.addColumn("Purchase Price");
        
        for (Book book : books) {
            bookTable.addRow(new String[] {book.getBid(),book.getbName(),book.getbAuthor(),book.getbGenre(),book.getbDescription(),book.getbPublisher(),book.getbAmount(),book.getbRentPrice(),book.getbPurchasePrice()});
        }
        
        return bookTable;
        
    }
    
}
