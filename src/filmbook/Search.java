/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmbook;

import Properties.Book;
import Properties.Film;
import db.DB;
import enums.BookEnum;
import enums.FilmEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MNK
 */
public class Search {

    List<Film> searchFilmList = new ArrayList<>();
    List<Book> searchBookList = new ArrayList<>();

    public void gatherSearchFilmData(String searchPattern) {
        searchFilmList.clear();
        String query = "SELECT * FROM film WHERE film_name LIKE '%" + searchPattern + "%'";

        DB db = new DB();

        try {
            ResultSet rs = db.connect().executeQuery(query);

            while (rs.next()) {
                Film film = new Film();
                film.setFid(rs.getString("" + FilmEnum.film_id));
                film.setfName(rs.getString("" + FilmEnum.film_name));
                film.setfDirector(rs.getString("" + FilmEnum.film_director));
                film.setfYear(rs.getString("" + FilmEnum.film_year));
                film.setfAmount(rs.getString("" + FilmEnum.film_amount));
                film.setfRentPrice(rs.getString("" + FilmEnum.film_rent_price));
                film.setfPurchasePrice(rs.getString("" + FilmEnum.film_purchase_price));
                searchFilmList.add(film);
            }

        } catch (SQLException e) {
            System.err.println("FİLM ARAMA DATASI CEKME HATASI");
        } finally {
            db.close();
        }

    }

    public DefaultTableModel listSearchFilms(String searchPattern) {
        gatherSearchFilmData(searchPattern);
        DefaultTableModel table = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        table.addColumn("ID");
        table.addColumn("Film Name");
        table.addColumn("Director");
        table.addColumn("Year");
        table.addColumn("Amount");
        table.addColumn("Rent Price");
        table.addColumn("Purchase Price");

        for (Film film : searchFilmList) {
            table.addRow(new String[]{film.getFid(), film.getfName(), film.getfDirector(), film.getfYear(), film.getfAmount(), film.getfRentPrice(), film.getfPurchasePrice()});

        }

        return table;
    }
    
    public void gatherSearchBookData(String searchPattern){
        searchBookList.clear();
        String query = "SELECT * FROM book WHERE book_name LIKE '%"+searchPattern+"%'";
        DB db = new DB();
        
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
                
                
                searchBookList.add(book);
            }
            
        } catch (SQLException e) {
            System.err.println("SEARCH BOOK DATA CEKME HATASI" + e);
        }finally{
            db.close();
        }
        
    }
    
    public DefaultTableModel listSearchBooks(String searchPattern){
        gatherSearchBookData(searchPattern);
        DefaultTableModel table = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        table.addColumn("ID");
        table.addColumn("Book Name");
        table.addColumn("Author");
        table.addColumn("Genre");
        table.addColumn("Description");
        table.addColumn("Publisher");
        table.addColumn("Amount");
        table.addColumn("Rent Price");
        table.addColumn("Purchase Price");
        
        for (Book book : searchBookList) {
        table.addRow(new String[] {book.getBid(),book.getbName(),book.getbAuthor(),book.getbGenre(),book.getbDescription(),book.getbPublisher(),book.getbAmount(),book.getbRentPrice(),book.getbPurchasePrice()});
        }
        
        
        return table;
    }

}
