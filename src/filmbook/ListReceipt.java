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
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Java_sabah
 */
public class ListReceipt {

    List<Film> buyFilmList = new ArrayList<>();
    List<Film> rentFilmList = new ArrayList<>();
    List<Book> buyBookList = new ArrayList<>();
    List<Book> rentBookList = new ArrayList<>();
    
   
    public void gatherBuyFilmData() {
        buyFilmList.clear();

        for (String item : OperationFrame.buyFilmList) {
            String query = "SELECT film_id,film_name,film_amount,film_purchase_price FROM film WHERE film_id = '" + item + "'";
            DB db = new DB();

            try {
                ResultSet rs = db.connect().executeQuery(query);

                while (rs.next()) {
                    Film f = new Film();
                    f.setFid(rs.getString("" + FilmEnum.film_id));
                    f.setfName(rs.getString("" + FilmEnum.film_name));
                    f.setfAmount(rs.getString("" + FilmEnum.film_amount));
                    f.setfPurchasePrice(rs.getString("" + FilmEnum.film_purchase_price));

                    buyFilmList.add(f);
                    
                    

                }
            } catch (Exception e) {
                System.err.println("DATA CEKME HATASI BUYFİLM..." + e);
            } finally {
                db.close();
            }

        }

    }

    //String query = SELECT * FROM film WHERE film_id IN (1,2,3,4)    }
    public DefaultTableModel listBuyFilmReceipt() {
        gatherBuyFilmData();
        DefaultTableModel table = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        table.addColumn("ID");
        table.addColumn("Film Name");
        table.addColumn("Amount");
        table.addColumn("Price");

        for (Film f : buyFilmList) {
            table.addRow(new String[]{f.getFid(), f.getfName(), f.getfAmount(), f.getfPurchasePrice()});
        }

        return table;
    }

    public void gatherBuyBookData() {
        buyBookList.clear();

        for (String item : OperationFrame.buyBookList) {
            String query = "SELECT book_id,book_name,book_amount,book_purchase_price FROM book WHERE book_id = '" + item + "'";
            DB db = new DB();

            try {
                ResultSet rs = db.connect().executeQuery(query);

                while (rs.next()) {
                    Book b = new Book();
                    b.setBid(rs.getString("" + BookEnum.book_id));
                    b.setbName(rs.getString("" + BookEnum.book_name));
                    b.setbAmount(rs.getString("" + BookEnum.book_amount));
                    b.setbPurchasePrice(rs.getString("" + BookEnum.book_purchase_price));

                    buyBookList.add(b);
                }
            } catch (Exception e) {
                System.err.println("DATA CEKME HATASI BUYBOOK..." + e);
            } finally {
                db.close();
            }

        }

    }

    public DefaultTableModel listBuyBookReceipt() {
        gatherBuyBookData();

        DefaultTableModel table = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        table.addColumn("ID");
        table.addColumn("Book Name");
        table.addColumn("Amount");
        table.addColumn("Price");

        for (Book book : buyBookList) {
            table.addRow(new String[]{book.getBid(), book.getbName(), book.getbAmount(), book.getbPurchasePrice()});
        }

        return table;
    }

    public void gatherRentFilmData() {
        rentFilmList.clear();
        for (String item : OperationFrame.rentFilmList) {
            String query = "SELECT film_id,film_name,film_amount,film_rent_price FROM film WHERE film_id = '" + item + "'";
            DB db = new DB();

            try {
                ResultSet rs = db.connect().executeQuery(query);

                while (rs.next()) {
                    Film f = new Film();
                    f.setFid(rs.getString("" + FilmEnum.film_id));
                    f.setfName(rs.getString("" + FilmEnum.film_name));
                    f.setfAmount(rs.getString("" + FilmEnum.film_amount));
                    f.setfRentPrice(rs.getString("" + FilmEnum.film_rent_price));

                    rentFilmList.add(f);

                }
            } catch (Exception e) {
                System.err.println("DATA CEKME HATASI RENTFİLM..." + e);
            } finally {
                db.close();
            }

        }

    }

    public DefaultTableModel listRentFilmReceipt() {
        gatherRentFilmData();
        
        System.out.println("GELENVERIIII : " + rentFilmList);
        DefaultTableModel table = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        table.addColumn("ID");
        table.addColumn("Film Name");
        table.addColumn("Amount");
        table.addColumn("Rent Price");

        for (Film film : rentFilmList) {
            table.addRow(new String[]{film.getFid(), film.getfName(), film.getfAmount(), film.getfRentPrice()});
        }

        return table;
    }

    public void gatherRentBookData() {

        rentBookList.clear();

        for (String item : OperationFrame.rentBookList) {
            String query = "SELECT book_id,book_name,book_amount,book_rent_price FROM book WHERE book_id = '" + item + "'";
            DB db = new DB();

            try {
                ResultSet rs = db.connect().executeQuery(query);

                while (rs.next()) {
                    Book b = new Book();
                    b.setBid(rs.getString("" + BookEnum.book_id));
                    b.setbName(rs.getString("" + BookEnum.book_name));
                    b.setbAmount(rs.getString("" + BookEnum.book_amount));
                    b.setbRentPrice(rs.getString("" + BookEnum.book_rent_price));

                   rentBookList.add(b);

                }
            } catch (Exception e) {
                System.err.println("DATA CEKME HATASI RENTBOOK..." + e);
            } finally {
                db.close();
            }

        }

    }

    public DefaultTableModel listRentBookReceipt() {
        
        gatherRentBookData();
        
        
        DefaultTableModel table = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        table.addColumn("ID");
        table.addColumn("Book Name");
        table.addColumn("Amount");
        table.addColumn("Rent Price");

        for (Book book : rentBookList) {
            table.addRow(new String[]{book.getBid(), book.getbName(), book.getbAmount(), book.getbRentPrice()});
        }

        return table;

    }
}
