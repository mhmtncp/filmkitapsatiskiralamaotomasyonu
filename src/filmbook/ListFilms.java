/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmbook;

import Properties.Film;
import db.DB;
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
public class ListFilms {

    List<Film> films = new ArrayList<>();

    public void gatherData() {
        films.clear();
        String query = "SELECT * FROM film";
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
                films.add(film);

            }

        } catch (SQLException e) {
            System.err.println("FİLM DATASI CEKME HATASI" + e);
        } finally {
            db.close();
        }

    }
    public DefaultTableModel listFilms(){
        gatherData();
        
        DefaultTableModel filmTable = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        filmTable.addColumn("ID");
        filmTable.addColumn("Film Name");
        filmTable.addColumn("Director");
        filmTable.addColumn("Year");
        filmTable.addColumn("Amount");
        filmTable.addColumn("Rent Price");
        filmTable.addColumn("Purchase Price");
        
        for (Film film : films) {
            filmTable.addRow(new String[] {film.getFid(),film.getfName(),film.getfDirector(),film.getfYear(),film.getfAmount(),film.getfRentPrice(),film.getfPurchasePrice()});
            
        }
        return filmTable;
    }

}
