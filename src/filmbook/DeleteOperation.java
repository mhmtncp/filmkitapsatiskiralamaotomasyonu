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
public class DeleteOperation {

    public int deleteFilm(String id) {
        String query = "DELETE FROM film WHERE film_id = '" + id + "'";
        DB db = new DB();
        int rtrn = 0;

        try {
            int delete = db.connect().executeUpdate(query);
            rtrn = delete;
        } catch (Exception e) {
            System.err.println("FİLM SİLME HATASI " + e);
        } finally {
            db.close();
        }

        return rtrn;
    }
        public int deleteBook(String id){
            int rtrn = 0;
            String query = "DELETE FROM book WHERE book_id = '"+id+"'";
            DB db = new DB();
            
            try {
                int delete = db.connect().executeUpdate(query);
                rtrn = delete;
            } catch (Exception e) {
                System.err.println("BOOK SİLME HATASI " + e);
            }finally{
                db.close();
            }
            
            
            
            return rtrn;
    }

}




