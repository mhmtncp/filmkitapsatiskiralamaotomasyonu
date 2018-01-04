/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmbook;

import db.DB;

/**
 *
 * @author Java_sabah
 */
public class AddFilm {

    public int addFilm(String filmName, String filmDirector, String FilmYear, String filmAmount, String filmRentPrice, String filmPurchasePrice) {
        int rtrn = 0;

        String query = "INSERT INTO film VALUES(null,'" + filmName + "','" + filmDirector + "','" + FilmYear + "','" + filmAmount + "','" + filmRentPrice + "','" + filmPurchasePrice + "')";

        DB db = new DB();

        try {
            int add = db.connect().executeUpdate(query);
            rtrn = add;
        } catch (Exception e) {
            System.err.println("FİLM EKLEME HATASI " + e);
        } finally {
            db.close();
        }

        return rtrn;
    }

}
